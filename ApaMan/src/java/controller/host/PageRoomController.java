/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Room;
import entity.Roomtype;
import entity.RoomtypeImgBanner;
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
import service.RoomService;
import service.RoomtypeImgBannerService;
import service.RoomtypeService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageRoomtypeController", urlPatterns = {"/floor-room"})
public class PageRoomController extends HttpServlet {

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

            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            
            int floorId = Integer.parseInt(request.getParameter("floorId"));

            List<Room> rooms = roomService.getAll(floorId,apartmentId);

            request.setAttribute("rooms", rooms);
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
            RoomtypeService roomtypeService = new RoomtypeService();
            RoomtypeImgBannerService roomtypeImgBannerService = new RoomtypeImgBannerService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            String roomtypeName = request.getParameter("roomtypeName");
            int roomtypeMaxMember = Integer.parseInt(request.getParameter("roomtypeMaxMember"));
            int roomtypeCost = Integer.parseInt(request.getParameter("roomtypeCost"));
            String roomtypeArea = request.getParameter("roomtypeArea");
            int roomtypeRoomQuantity = 0;

            List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);

            //Check roomtype name already exist
            boolean roomtypeNameExist = false;
            for (Roomtype obj : roomtypes) {
                if (roomtypeName.equals(obj.getRoomtypeName())) {
                    roomtypeNameExist = true;
                }
            }

            if (roomtypeNameExist) {
                session.setAttribute("messageUpdate", "warning|APAMAN Notification|Roomtype Name Exist, Add Fail|edit-roomtype");
            } else {
                Roomtype roomtype = Roomtype.builder()
                        .apartmentId(apartmentId)
                        .roomtypeName(roomtypeName)
                        .roomtypeMaxMember(roomtypeMaxMember)
                        .roomtypeCost(roomtypeCost)
                        .roomtypeArea(roomtypeArea)
                        .roomtypeRoomQuantity(roomtypeRoomQuantity)
                        .build();
                int addRoomtypeSuccess = roomtypeService.add(roomtype);
                int roomtypeId = addRoomtypeSuccess;

                String roomtypeImgBannerPath = "assets/system/defaultImgSystem.png";
                List<RoomtypeImgBanner> addRoomtypeImgBanners = new ArrayList<>();
                
                for (int i = 0; i < 6; i++) {
                    RoomtypeImgBanner roomtypeImgBanner = RoomtypeImgBanner.builder()
                        .roomtypeId(roomtypeId)
                        .roomtypeImgBannerPath(roomtypeImgBannerPath)
                        .build();
                    addRoomtypeImgBanners.add(roomtypeImgBanner);
                }
                boolean addRoomtypeImgBannerSuccess = roomtypeImgBannerService.add(addRoomtypeImgBanners);

                if (addRoomtypeSuccess > 0 && addRoomtypeImgBannerSuccess) {
                    session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Roomtype Success|edit-roomtype");
                } else {
                    session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Roomtype Fail|edit-roomtype");
                }
            }
            response.sendRedirect("roomtype");

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
