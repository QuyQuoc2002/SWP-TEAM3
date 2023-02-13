/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Tenant;
import entity.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import service.AccountService;
import service.TenantService;
import service.VehicleTypeService;

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
            TenantService tenantService = new TenantService();
            VehicleTypeService vehicleTypeService = new VehicleTypeService();
            
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            int roomId = Integer.parseInt(request.getParameter("roomId"));

            List<Tenant> tenants = tenantService.getAll(roomId, apartmentId);
            request.setAttribute("tenants", tenants);
            
            List<VehicleType> vehicleTypes = vehicleTypeService.getAll();
            request.setAttribute("vehicleTypes", vehicleTypes);
            
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

            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            AccountService accountService = new AccountService();
            TenantService tenantService = new TenantService();
            
            int tenantId = Integer.parseInt(request.getParameter("tenantId"));
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            int roomId = Integer.parseInt(request.getParameter("roomId"));

            String password = request.getParameter("password");
            boolean accountAccessible = request.getParameter("accountAccessible") != null;
            
            String tenantCountryside = request.getParameter("tenantCountryside");
            String tenantDob = request.getParameter("tenantDob");
            String tenantPhoneNumber = request.getParameter("tenantPhoneNumber");
            String tenantParentPhone = request.getParameter("tenantParentPhone");
            String tenantCitizenIdentification = request.getParameter("tenantCitizenIdentification");
            String tenantName = request.getParameter("tenantName");

            Account account = accountService.getOne(accountId);
            account.setAccountAccessible(accountAccessible);
            account.setAccountPassword(password);
            boolean updateAccountSuccess = accountService.update(account, accountId);

            Tenant tenant = tenantService.getOne(tenantId);
            tenant.setTenantCountryside(tenantCountryside);
            tenant.setTenantDob(tenantDob);
            tenant.setTenantPhoneNumber(tenantPhoneNumber);
            tenant.setTenantParentPhone(tenantParentPhone);
            tenant.setTenantCitizenIdentification(tenantCitizenIdentification);
            tenant.setTenantName(tenantName);
            boolean updateTenantSuccess = tenantService.update(tenant, tenantId);

            if (updateAccountSuccess && updateTenantSuccess) {
                session.setAttribute("messageUpdate", "success|Update|Update Success");
            } else {
                session.setAttribute("messageUpdate", "error|Update|Update Fail");
           }

            response.sendRedirect("room-member?roomId="+roomId);

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
