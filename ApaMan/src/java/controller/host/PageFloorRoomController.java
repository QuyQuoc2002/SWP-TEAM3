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
import service.PaymentService;
import service.RoomService;
import service.RoomtypeService;
import service.TenantService;
import utils.Cypher;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageFloorRoomController", urlPatterns = {"/floor-room"})
public class PageFloorRoomController extends HttpServlet {

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
            out.println("<title>Servlet PageRoomtypeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PageRoomtypeController at " + request.getContextPath() + "</h1>");
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
            RoomService roomService = new RoomService();
            RoomtypeService roomtypeService = new RoomtypeService();
            PaymentService paymentService = new PaymentService();

            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            int floorId = Integer.parseInt(request.getParameter("floorId"));
            List<Room> rooms = roomService.getAll(floorId, apartmentId);
            List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);

            request.setAttribute("rooms", rooms);
            request.setAttribute("roomtypes", roomtypes);
            request.getRequestDispatcher("floor-room.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            RoomService roomService = new RoomService();
            RoomtypeService roomtypeService = new RoomtypeService();
            AccountService accountService = new AccountService();
            TenantService tenantService = new TenantService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            String roomName = request.getParameter("roomName");
            int roomtypeId = Integer.parseInt(request.getParameter("roomtypeId"));
            int floorId = Integer.parseInt(request.getParameter("floorId"));

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

            if (roomNameExist) {
                session.setAttribute("messageUpdate", "warning|APAMAN Notification|Room Name Exist, Add Fail|edit-room");
            } else {
                //create room
                Room room = Room.builder()
                        .roomName(roomName)
                        .roomtype(Roomtype.builder()
                                .roomtypeId(roomtypeId)
                                .build()
                        )
                        .floorId(floorId)
                        .apartmentId(apartmentId)
                        .build();
                int addRoomSuccess = roomService.add(room);

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
                            .roomId(addRoomSuccess)
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
                    session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Room Success|edit-room");
                } else {
                    session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Room Fail|edit-room");
                }
            }
            response.sendRedirect("room-control");
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
