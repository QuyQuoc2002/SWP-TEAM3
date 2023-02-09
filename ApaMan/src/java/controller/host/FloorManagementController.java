/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Floor;
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

/**
 *
 * @author DELL
 */
@WebServlet(name = "FloorManagementController", urlPatterns = {"/floor-management"})
public class FloorManagementController extends HttpServlet {

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
            FloorService floorService = new FloorService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            String submitType = request.getParameter("submitType");
            switch (submitType) {
                case "Delete":
                    int floorId = Integer.parseInt(request.getParameter("floorId"));
                    Floor floor = floorService.getOne(floorId);
                    if (floor.getFloorRoomQuantity() != 0) {
                        session.setAttribute("messageUpdate", "error|APAMAN Notification|Delete Floor Fail, some room exist in this floor|edit-floor");
                    } else {
                        boolean deleteFloorSuccess = floorService.delete(floorId, apartmentId);
                        if (deleteFloorSuccess) {
                            session.setAttribute("messageUpdate", "success|APAMAN Notification|Delete Floor Success|edit-floor");
                        } else {
                            session.setAttribute("messageUpdate", "error|APAMAN Notification|Delete Floor Fail Somthing went wrong|edit-floor");
                        }
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
            FloorService floorService = new FloorService();

            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            String submitType = request.getParameter("submitType");
            switch (submitType) {
                case "Add":
                    int floorName = Integer.parseInt(request.getParameter("floorName")) ;
                    List<Floor> floors = floorService.getAll(apartmentId);

                    //Check floor name already exist
                    boolean floorNameExist = false;
                    for (Floor obj : floors) {
                        if (floorName == obj.getFloorName()) {
                            floorNameExist = true;
                        }
                    }

                    if (floorNameExist) {
                        session.setAttribute("messageUpdate", "warning|APAMAN Notification|Floor Name Exist, Add Fail|edit-floor");
                    } else {
                        Floor floor = Floor.builder()
                                .apartmentId(apartmentId)
                                .floorName(floorName)
                                .floorRoomQuantity(0)
                                .build();
                        boolean addFloorSuccess = floorService.add(floor);
                        if (addFloorSuccess) {
                            session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Floor Success|edit-floor");
                        } else {
                            session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Floor Fail|edit-floor");
                        }
                    }
                    response.sendRedirect("room-control");
                    break;

                case "Update":
                    String[] updateFloorsNames = request.getParameterValues("floorName");
                    String[] updateFloorsIdStrs = request.getParameterValues("floorId");

                    List<Floor> updateFloors = new ArrayList<>();
                    for (int i = 0; i < updateFloorsIdStrs.length; i++) {
                        Floor updateFloor = floorService.getOne(Integer.parseInt(updateFloorsIdStrs[i]));
                        updateFloor.setFloorName(Integer.parseInt(updateFloorsNames[i]));
                        updateFloors.add(updateFloor);
                    }

                    boolean updateFloorsSuccess = floorService.updateFloors(updateFloors);
                    if (updateFloorsSuccess) {
                        session.setAttribute("messageUpdate", "success|APAMAN Notification|Update Floor Success|edit-floor");
                    } else {
                        session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Floor Fail|edit-floor");
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
