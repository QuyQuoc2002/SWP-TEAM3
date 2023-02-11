/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
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
import java.util.List;
import service.RoomtypeImgBannerService;
import service.RoomtypeService;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "RoomtypeManagementController", urlPatterns = {"/roomtype-detail"})
public class RoomtypeManagementController extends HttpServlet {

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
            out.println("<title>Servlet RoomtypeManagementController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomtypeManagementController at " + request.getContextPath() + "</h1>");
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
            RoomtypeService roomtypeService = new RoomtypeService();
            RoomtypeImgBannerService roomtypeImgBannerService = new RoomtypeImgBannerService();

            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            int roomtypeId = Integer.parseInt(request.getParameter("roomtypeId"));
            Roomtype roomtype = roomtypeService.getOne(roomtypeId, apartmentId);
            
            List<RoomtypeImgBanner> roomtypeImgBanners = roomtypeImgBannerService.getAll(roomtypeId);

            request.setAttribute("roomtype", roomtype);
            request.setAttribute("roomtypeImgBanner", roomtypeImgBanners);
            request.getRequestDispatcher("roomtype-detail.jsp").forward(request, response);
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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            RoomtypeService roomtypeService = new RoomtypeService();
            RoomtypeImgBannerService roomtypeImgBannerService = new RoomtypeImgBannerService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            int roomtypeId = Integer.parseInt(request.getParameter("roomtypeId"));

            String submitType = request.getParameter("submitType");
            switch (submitType) {

                case "Update":

                    String roomtypeName = request.getParameter("roomtypeName");
                    int roomtypeMaxMember = Integer.parseInt(request.getParameter("roomtypeMaxMember"));
                    int roomtypeCost = Integer.parseInt(request.getParameter("roomtypeCost"));
                    String roomtypeArea = request.getParameter("roomtypeArea");
                    
                    Roomtype roomtypeCheck = roomtypeService.getOne(roomtypeId,apartmentId);
                    
                    //Check roomtype name have change
                    boolean roomtypeNameChange = true;
                    if (roomtypeName.equals(roomtypeCheck.getRoomtypeName())) {
                            roomtypeNameChange = false;
                        }

                    List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);
                    
                    //Check roomtype name already exist
                    boolean roomtypeNameExist = false;
                    for (Roomtype obj : roomtypes) {
                        if (roomtypeName.equals(obj.getRoomtypeName())) {
                            roomtypeNameExist = true;
                        }
                    }

                    if (roomtypeNameExist && roomtypeNameChange) {
                        session.setAttribute("messageUpdate", "warning|APAMAN Notification|Roomtype Name Exist, Add Fail|edit-roomtype");
                    } else {

                        Roomtype roomtype = roomtypeService.getOne(roomtypeId,apartmentId);
                        roomtype.setRoomtypeName(roomtypeName);
                        roomtype.setRoomtypeMaxMember(roomtypeMaxMember);
                        roomtype.setRoomtypeCost(roomtypeCost);
                        roomtype.setRoomtypeArea(roomtypeArea);

                        boolean updateRoomtypeSuccess = roomtypeService.updateRoomtype(roomtype);
                        if (updateRoomtypeSuccess) {
                            session.setAttribute("messageUpdate", "success|APAMAN Notification|Update Roomtype Success|edit-roomtype-detail");
                        } else {
                            session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Roomtype Fail|edit-roomtype-detail");
                        }
                    }
                    response.sendRedirect("roomtype-detail?roomtypeId=" + roomtypeId);
                    break;

                case "Delete":
                    Roomtype roomtypedel = roomtypeService.getOne(roomtypeId,apartmentId);
                    if (roomtypedel.getRoomtypeRoomQuantity() != 0) {
                        session.setAttribute("messageUpdate", "error|APAMAN Notification|Delete Roomtype Fail, some room exist in this roomtype|edit-roomtype");
                    } else {
                        
                        boolean deleteRoomtypeImgBannerSuccess = roomtypeImgBannerService.deleteAllRoomtype(roomtypeId);
                        boolean deleteRoomtypeSuccess = roomtypeService.delete(roomtypeId, apartmentId);
                        if (deleteRoomtypeSuccess && deleteRoomtypeImgBannerSuccess) {
                            session.setAttribute("messageUpdate", "success|APAMAN Notification|Delete Roomtype Success|edit-roomtype");
                            response.sendRedirect("roomtype?apartmentId=" + apartmentId);
                        } else {
                            session.setAttribute("messageUpdate", "error|APAMAN Notification|Delete Roomtype Fail Somthing went wrong|edit-roomtype");
                            response.sendRedirect("roomtype-detail?roomtypeId=" + roomtypeId);
                        }
                    }

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
