/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

import entity.Account;
import entity.Apartment;
import entity.ApartmentImgBanner;
import entity.Contact;
import entity.Floor;
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
import java.util.List;
import service.ApartmentImgBannerService;
import service.ApartmentService;
import service.ContactService;
import service.FloorService;
import service.RoomService;
import service.RoomtypeImgBannerService;
import service.RoomtypeService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageHomepageController", urlPatterns = {"/homepage"})
public class PageHomepageController extends HttpServlet {

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
            ApartmentService apartmentService = new ApartmentService();
            ApartmentImgBannerService apartmentImgBannerService = new ApartmentImgBannerService();
            RoomtypeService roomtypeService = new RoomtypeService();
            RoomtypeImgBannerService roomtypeImgBannerService = new RoomtypeImgBannerService();
            RoomService roomService = new RoomService();
            FloorService floorService = new FloorService();

            int apartmentId = Integer.parseInt(request.getParameter("apartmentId"));
            Apartment apartment = apartmentService.getOne(apartmentId, true);

            List<ApartmentImgBanner> apartmentImgBanners = apartmentImgBannerService.getAll(apartmentId);
            List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);

            List<Room> allRoom = roomService.getAll(apartmentId);
            List<Floor> allFloor = floorService.getAll(apartmentId);
            List<Room> emptyRoom = roomService.getAllStatus(apartmentId, 1);
            List<Room> findRoomates = roomService.getFindRoommate(apartmentId, true);
            System.out.println(findRoomates);

            for (Roomtype roomtype : roomtypes) {
                List<RoomtypeImgBanner> roomtypeImgBanners = roomtypeImgBannerService.getAll(roomtype.getRoomtypeId());
                roomtype.setRoomtypeImg(roomtypeImgBanners);
            }

            request.setAttribute("apartment", apartment);
            request.setAttribute("apartmentImgBanners", apartmentImgBanners);

            request.setAttribute("allRoom", allRoom);
            request.setAttribute("emptyRoom", emptyRoom);
            request.setAttribute("findRoomates", findRoomates);
            request.setAttribute("allFloor", allFloor);

            request.setAttribute("roomtypes", roomtypes);

            request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            ContactService contactService = new ContactService();

            int apartmentId = Integer.parseInt(request.getParameter("apartmentId"));
            String contactName = request.getParameter("contactName");
            String contactEmail = request.getParameter("contactEmail");
            String contactPhone = request.getParameter("contactPhone");
            String contactMessage = request.getParameter("contactMessage");

            Contact contact = Contact.builder()
                    .apartmentId(apartmentId)
                    .contactName(contactName)
                    .contactEmail(contactEmail)
                    .contactPhone(contactPhone)
                    .contactMessage(contactMessage)
                    .build();
            boolean addContactSuccess = contactService.add(contact);

            if (addContactSuccess) {
                session.setAttribute("messageUpdate", "success|APAMAN Notification|Send Message Success|edit-contact");
            } else {
                session.setAttribute("messageUpdate", "error|APAMAN Notification|Send Message Fail|edit-contact");
            }

            doGet(request, response);

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
