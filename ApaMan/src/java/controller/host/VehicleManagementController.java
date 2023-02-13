/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Room;
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
import service.VehicleService;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "VehicleManagementController", urlPatterns = {"/vehicle-manage"})
public class VehicleManagementController extends HttpServlet {

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
            out.println("<title>Servlet VehicleManagementController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleManagementController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
//        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            VehicleService vehicleService = new VehicleService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            String vehicleDescription = request.getParameter("vehicleDescription");
            String vehicleLicensePlate = request.getParameter("vehicleLicensePlate");
            String vehicleImgPath = request.getParameter("vehicleImgPath");

            int vehicleTypeId = Integer.parseInt(request.getParameter("vehicleTypeId"));
            int tenantId = Integer.parseInt(request.getParameter("tenantId"));
            int roomId = Integer.parseInt(request.getParameter("roomId"));

            Vehicle vehicle = Vehicle.builder()
                    .apartmentId(apartmentId)
                    .vehicleType(VehicleType.builder()
                            .vehicleTypeId(vehicleTypeId)
                            .build())
                    .vehicleDescription(vehicleDescription)
                    .vehicleLicensePlate(vehicleLicensePlate)
                    .vehicleImgPath(vehicleImgPath)
                    .tenant(Tenant.builder()
                            .tenantId(tenantId)
                            .build())
                    .room(Room.builder()
                            .roomId(roomId)
                            .build())
                    .build();

            boolean addVehicleSuccess = vehicleService.add(vehicle);

            if (addVehicleSuccess) {
                session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Vehicle Success|edit-vehicle");
            } else {
                session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Vehicle Fail|edit-vehicle");
            }

           response.sendRedirect("room-member?roomId="+roomId);

//        }
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
