/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import constant.IConst;
import entity.Account;
import entity.Floor;
import entity.Role;
import entity.Room;
import entity.Roomtype;
import entity.Tenant;
import entity.Vehicle;
import entity.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import service.AccountService;
import service.FloorService;
import service.RoomService;
import service.RoomtypeService;
import service.TenantService;
import service.VehicleTypeService;
import utils.Cypher;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "RoomMemberController", urlPatterns = {"/room-member"})
public class RoomMemberController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoomMemberController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomMemberController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            FloorService floorService = new FloorService();
            RoomtypeService roomtypeService = new RoomtypeService();
            TenantService tenantService = new TenantService();
            VehicleTypeService vehicleTypeService = new VehicleTypeService();
            RoomService roomService = new RoomService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            int roomId = Integer.parseInt(request.getParameter("roomId"));

            Room room = roomService.getOne(roomId, apartmentId);
            request.setAttribute("room", room);
            request.setAttribute("floorIdUpdate", room.getFloorId());
            request.setAttribute("RoomtypeIdUpdate", room.getRoomtype().getRoomtypeId());

            List<Floor> floors = floorService.getAll(apartmentId);
            request.setAttribute("floors", floors);

            List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);
            request.setAttribute("roomtypes", roomtypes);

            List<Tenant> tenants = tenantService.getAll(roomId, apartmentId);
            request.setAttribute("tenants", tenants);

            List<VehicleType> vehicleTypes = vehicleTypeService.getAll();
            request.setAttribute("vehicleTypes", vehicleTypes);

//            List<Vehicle> vehicles = vehicleService.getAll(apartmentId);
//            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("room-member.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            AccountService accountService = new AccountService();
            TenantService tenantService = new TenantService();
            RoomService roomService = new RoomService();
            RoomtypeService roomtypeService = new RoomtypeService();

            int roomId = Integer.parseInt(request.getParameter("roomId"));
            String submitType = request.getParameter("submitType");

            if (submitType.equals("Update")) {
                int floorId = Integer.parseInt(request.getParameter("floorId"));
                int roomtypeId = Integer.parseInt(request.getParameter("roomtypeId"));
                String roomName = request.getParameter("roomName");

                int numberOfTenantActive = roomService.numberOfTenantActive(roomId);
                if (numberOfTenantActive != 0) {
                    session.setAttribute("messageUpdate", "error|APAMAN Notification|Update Room Fail, some tenant exist in this room|edit-room");
                    response.sendRedirect("room-member?roomId=" + roomId);
                } else {
                    String errorStr = "<ol>";
                    Room room = roomService.getOne(roomId, apartmentId);

                    List<Room> rooms = roomService.getAll(apartmentId);
                    //Check roomNameExist already exist
                    boolean roomNameExist = false;
                    if (!rooms.isEmpty()) {
                        for (Room obj : rooms) {
                            if (roomName.equals(obj.getRoomName())) {
                                roomNameExist = true;
                            }
                        }
                    }
                    if (roomNameExist && !roomName.equals(room.getRoomName())) {
                        errorStr += "<li>Room Name Exist</li>";
                    } else {
                        errorStr += "<li>Update Room Name Success</li>";
                        room.setRoomName(roomName);
                    }
                    errorStr += "<li>Update Floor Success</li>";
                    room.setFloorId(floorId);

                    if (room.getRoomtype().getRoomtypeId() != roomtypeId) {

                        List<Tenant> deleteTeants = new ArrayList<>();
                        List<Account> deleteAccounts = new ArrayList<>();

                        List<Tenant> tenants = tenantService.getAll(roomId, apartmentId);
                        for (Tenant tenant : tenants) {
                            deleteTeants.add(tenant);
                            deleteAccounts.add(tenant.getAccount());
                        }
                        boolean deleteTeantSuccess = tenantService.delete(deleteTeants);
                        boolean deleteAccountSuccess = accountService.delete(deleteAccounts);

                        if (deleteTeantSuccess && deleteAccountSuccess) {
                            int maxMember = roomtypeService.getOne(roomtypeId, apartmentId).getRoomtypeMaxMember();

                            //create tenant
                            List<Tenant> addTenants = new ArrayList<>();

                            for (int i = 0; i < maxMember; i++) {
                                String tenantUsername = roomName + "Tenant" + (i + 1);
                                //create account
                                Account account = Account.builder()
                                        .apartmentId(apartmentId)
                                        .accountUsername(tenantUsername)
                                        .accountPassword(Cypher.generateData())
                                        .accountAccessible(false)
                                        .role(Role.builder()
                                                .roleId(IConst.ROLE_TENANT_ID)
                                                .build()
                                        )
                                        .build();
                                int accountId = accountService.add(account);

                                Room roomx = Room.builder()
                                        .roomId(roomId)
                                        .roomName(roomName)
                                        .build();

                                Tenant tenant = Tenant.builder()
                                        .room(roomx)
                                        .account(Account.builder().accountId(accountId).build())
                                        .build();
                                addTenants.add(tenant);
                            }
                            boolean addTenantsSuccess = tenantService.add(addTenants);

                            if (addTenantsSuccess) {
                                errorStr += "<li>Update Room Type Success</li>";
                                room.setRoomtype(Roomtype.builder()
                                        .roomtypeId(roomtypeId)
                                        .roomtypeName(room.getRoomtype().getRoomtypeName())
                                        .roomtypeCost(room.getRoomtype().getRoomtypeCost())
                                        .roomtypeMaxMember(room.getRoomtype().getRoomtypeMaxMember())
                                        .roomtypeArea(room.getRoomtype().getRoomtypeArea())
                                        .build()
                                );
                            } else {
                                errorStr += "<li>Update Room Type Fail</li>";
                            }

                        } else {
                            errorStr += "<li>Update Room Type Fail</li>";
                        }

                    } else {
                        errorStr += "<li>Update Room Type Success</li>";
                        room.setRoomtype(Roomtype.builder()
                                .roomtypeId(roomtypeId)
                                .roomtypeName(room.getRoomtype().getRoomtypeName())
                                .roomtypeCost(room.getRoomtype().getRoomtypeCost())
                                .roomtypeMaxMember(room.getRoomtype().getRoomtypeMaxMember())
                                .roomtypeArea(room.getRoomtype().getRoomtypeArea())
                                .build()
                        );
                    }
                    errorStr += "</ol>";
                    boolean updateRoomSuccess = roomService.update(room);

                    if (updateRoomSuccess) {
                        session.setAttribute("messageUpdate", "success|Update|" + errorStr);
                    } else {
                        session.setAttribute("messageUpdate", "error|Update|Update Fail");
                    }
                    response.sendRedirect("room-member?roomId=" + roomId);
                }
            }
            if (submitType.equals("Delete")) {
                int floorId = Integer.parseInt(request.getParameter("floorId"));
                List<Tenant> deleteTeants = new ArrayList<>();
                List<Account> deleteAccounts = new ArrayList<>();

                List<Tenant> tenants = tenantService.getAll(roomId, apartmentId);
                for (Tenant tenant : tenants) {
                    deleteTeants.add(tenant);
                    deleteAccounts.add(tenant.getAccount());
                }
                boolean deleteTeantSuccess = tenantService.delete(deleteTeants);
                boolean deleteAccountSuccess = accountService.delete(deleteAccounts);
                boolean deleteRoomSuccess = roomService.delete(roomId, floorId);

                if (deleteTeantSuccess && deleteAccountSuccess && deleteRoomSuccess) {
                    session.setAttribute("messageUpdate", "success|APAMAN Notification|Delete Room Success|edit-room");
                } else {
                    session.setAttribute("messageUpdate", "error|APAMAN Notification|Delete Room Fail|edit-room");
                }
                response.sendRedirect("floor-room?floorId=" + floorId);
            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
