/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Floor;
import entity.Roomtype;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import service.FloorService;
import service.RoomService;
import service.RoomtypeService;
import service.StaffService;
import service.TenantService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageRoomControlController", urlPatterns = {"/room-control"})
public class PageRoomControlController extends HttpServlet {

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
            HttpSession session = request.getSession();
            FloorService floorService = new FloorService();
            RoomtypeService roomtypeService = new RoomtypeService();
            TenantService tenantService = new TenantService();
            RoomService roomService = new RoomService();
            StaffService staffService = new StaffService();
            
            
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            
            int numberOfFloors = floorService.numberOfFloors(apartmentId);
            request.setAttribute("numberOfFloors", numberOfFloors);
            
            int numberOfRooms = roomService.numberOfRooms(apartmentId);
            request.setAttribute("numberOfRooms", numberOfRooms);
            
            int numberOfRoomtypes = roomtypeService.numberOfRoomtypes(apartmentId);
            request.setAttribute("numberOfRoomtypes", numberOfRoomtypes);
            
            int numberOfTenants = tenantService.numberOfTenants(apartmentId);
            request.setAttribute("numberOfTenants", numberOfTenants);
            
            int numberOfStaffs = staffService.numberOfStaffs(apartmentId);
            request.setAttribute("numberOfStaffs", numberOfStaffs);
            
            int numberOfEmptyRoom = roomService.numberOfStatusRoom(apartmentId, 1);
            request.setAttribute("numberOfEmptyRoom", numberOfEmptyRoom);
            
            int numberOfDepositRoom = roomService.numberOfStatusRoom(apartmentId, 2);
            request.setAttribute("numberOfDepositRoom", numberOfDepositRoom);
            
            int numberOfRentingRoom = roomService.numberOfStatusRoom(apartmentId, 3);
            request.setAttribute("numberOfRentingRoom", numberOfRentingRoom);
            
            
            
            List<Floor> floors = floorService.getAll(apartmentId);
            request.setAttribute("floors", floors);
            
            List<Roomtype> roomtypes = roomtypeService.getAll(apartmentId);
            request.setAttribute("roomtypes", roomtypes);
            
            request.getRequestDispatcher("room-control.jsp").forward(request, response);
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
