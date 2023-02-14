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
import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import service.VehicleService;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "VehicleManagementController", urlPatterns = {"/vehicle-manage"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class VehicleManagementController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        try ( PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        HttpSession session = request.getSession();
        VehicleService vehicleService = new VehicleService();

        Account curAccount = (Account) session.getAttribute("curAccount");
        int apartmentId = curAccount.getApartmentId();

        String vehicleDescription = request.getParameter("vehicleDescription");
        String vehicleLicensePlate = request.getParameter("vehicleLicensePlate");

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
                .tenant(Tenant.builder()
                        .tenantId(tenantId)
                        .build())
                .room(Room.builder()
                        .roomId(roomId)
                        .build())
                .build();
        

        int addVehicleSuccess = vehicleService.add(vehicle);

        if (addVehicleSuccess > 0) {

            int i = 5;
            for (Part part : request.getParts()) {
                if (i < request.getParts().size()) {
                    String fileName = "img-vehicle" + addVehicleSuccess + extractFileName(part);
                    // refines the fileName in case it is an absolute path
                    File storeFile = new File(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                    part.write(storeFile.toString());
                    Vehicle vehicleImg = vehicleService.getOne(addVehicleSuccess);
                    vehicleImg.setVehicleImgPath("assets/images/" + fileName);

                    boolean updateVehicleImgSuccess = vehicleService.update(vehicleImg, addVehicleSuccess);
                    if (updateVehicleImgSuccess) {
                        session.setAttribute("messageUpdate", "success|APAMAN Notification|Add Vehicle Success|edit-vehicle");
                    } else {
                        session.setAttribute("messageUpdate", "error|APAMAN Notification|Add Vehicle Fail|edit-vehicle");
                    }

                }
                i++;
            }
        }

        response.sendRedirect("room-member?roomId=" + roomId);

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

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private File getFolderUpload() throws IOException {
        String readPart = getServletContext().getRealPath("/");
        String partUpload = readPart.replace("build\\", "") + "assets\\images";
        File folderUpload = new File(partUpload);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

}
