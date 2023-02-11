/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;


import entity.Account;
import entity.Floor;
import entity.Room;
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
import service.FloorService;
import service.RoomService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RoomManagementController", urlPatterns = {"/room-management"})
public class RoomManagementController extends HttpServlet {

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
            out.println("<title>Servlet FloorManagementController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FloorManagementController at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();
            
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            
            RoomService roomService = new RoomService();
            FloorService floorService = new FloorService();

            String submitType = request.getParameter("submitType");
            switch (submitType) {
                case "Delete":
                    int roomId = Integer.parseInt(request.getParameter("roomId"));
                    int floorId = Integer.parseInt(request.getParameter("floorId"));
                    boolean deleteRoomSuccess = roomService.delete(roomId, floorId);

                    Floor floor = floorService.getOne(floorId);
                    int floorRoomQuantity = floor.getFloorRoomQuantity();
                    int updateFloorRoomQuantity = floorRoomQuantity - 1;

                    Floor updateFloor = floorService.getOne(floorId);
                    updateFloor.setFloorRoomQuantity(updateFloorRoomQuantity);

                    boolean updateFloorsSuccess = floorService.updateFloor(updateFloor);

                    if (deleteRoomSuccess) {
                        session.setAttribute("messageUpdate", "success|Delete|Delete Room Success|edit-room");
                    } else {
                        session.setAttribute("messageUpdate", "error|Delete|Delete Room Fail Somthing went wrong|edit-room");
                    }
                    response.sendRedirect("room-control");
                    break;
            }

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
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            
            RoomService roomService = new RoomService();
            FloorService floorService = new FloorService();

            int floorId = Integer.parseInt(request.getParameter("floorId"));
            int roomtypeId = Integer.parseInt(request.getParameter("roomtypeId"));

            String submitType = request.getParameter("submitType");
            switch (submitType) {
                case "Add":
                    String roomName = request.getParameter("roomName");
                    List<Room> rooms = roomService.getAll(floorId,apartmentId);

                    //Check room name already exist
                    boolean roomNameExist = false;
                    for (Room obj : rooms) {
                        if (roomName.equals(obj.getRoomName())) {
                            roomNameExist = true;
                        }
                    }

                    if (roomNameExist) {
                        session.setAttribute("messageUpdate", "warning|APAMAN Notification|Room Name Exist, Add Fail|edit-room");
                    } else {
                        Room room = Room.builder()
                                .roomName(roomName)
                                .roomtypeId(roomtypeId)
                                .floorId(floorId)
                                .build();
                        boolean addRoomSuccess = roomService.add(room);

                        Floor floor = floorService.getOne(floorId);
                        int floorRoomQuantity = floor.getFloorRoomQuantity();
                        int updateFloorRoomQuantity = floorRoomQuantity + 1;

                        Floor updateFloor = floorService.getOne(floorId);
                        updateFloor.setFloorRoomQuantity(updateFloorRoomQuantity);

                        boolean updateFloorsSuccess = floorService.updateFloor(updateFloor);

                        if (addRoomSuccess) {
                            session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Room Success|edit-room");
                        } else {
                            session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Room Fail|edit-room");
                        }
                    }
                    response.sendRedirect("room-control");
                    break;

                case "Update":
                    String[] updateRoomsNames = request.getParameterValues("roomName");
                    String[] updateRoomtypeIdStrs = request.getParameterValues("roomtypeId");
                    String[] updateFloorIdStrs = request.getParameterValues("floorId");
                    String[] updateRoomsIdStrs = request.getParameterValues("roomId");

                    List<Room> updateRooms = new ArrayList<>();
                    for (int i = 0; i < updateRoomsIdStrs.length; i++) {
                        Room updateRoom = roomService.getOne(Integer.parseInt(updateRoomsIdStrs[i]),apartmentId);
                        updateRoom.setRoomName(updateRoomsNames[i]);
                        updateRoom.setRoomtypeId(Integer.parseInt(updateRoomtypeIdStrs[i]));
                        updateRoom.setFloorId(Integer.parseInt(updateFloorIdStrs[i]));
                        updateRooms.add(updateRoom);
                    }

                    boolean updateRoomsSuccess = roomService.updateRooms(updateRooms);
                    if (updateRoomsSuccess) {
                        session.setAttribute("messageUpdate", "success|APAMAN Notification|Update Room Success|edit-room");
                    } else {
                        session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Room Fail|edit-room");
                    }
                    response.sendRedirect("room-control");
                    break;
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
