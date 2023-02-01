package controller.admin;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import entity.Account;
import entity.Apartment;
import entity.City;
import entity.District;
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
import service.ApartmentService;
import service.CityService;
import service.DistrictService;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "HostApartmentDetailController", urlPatterns = {"/host-apartment-detail"})
public class HostApartmentDetailController extends HttpServlet {

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

            int accountId = Integer.parseInt(request.getParameter("accountId"));
            Account hostAccount = new AccountService().getOne(accountId);
            request.setAttribute("hostAccount",hostAccount);

            int apartmentId = hostAccount.getApartmentId();
            Apartment apartment = new ApartmentService().getOne(apartmentId);
            request.setAttribute("apartment",apartment);
            System.out.println(apartment);

            List<City> listCity = new CityService().getAll();
            request.setAttribute("listCity", listCity);

            List<District> listDistrict = new DistrictService().getAll();
            request.setAttribute("listDistrict", listDistrict);

            request.getRequestDispatcher("host-apartment-detail.jsp").forward(request, response);
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
        processRequest(request, response);
        AccountService accountService = new AccountService();
        ApartmentService apartmentService = new ApartmentService();

        HttpSession session = request.getSession();
        String submitType = request.getParameter("submitType");
        int apartmentId = Integer.parseInt(request.getParameter("apartmentId"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        if (submitType.equals("Save")) {

            String apartmentName = request.getParameter("apartmentName");
            String hostName = request.getParameter("hostName");
            String hostMobile = request.getParameter("hostMobile");
            int districtId = Integer.parseInt(request.getParameter("districtId"));
            String apartmentAddress = request.getParameter("apartmentAddress");
            String apartmentLat = request.getParameter("apartmentLat");
            String apartmentLon = request.getParameter("apartmentLong");
            boolean apartmentAccessible = request.getParameter("apartmentAccessible") != null;
            
            Apartment apartment = apartmentService.getOne(apartmentId);
            apartment.setApartmentName(apartmentName);
            apartment.setHostName(hostName);
            apartment.setHostMobile(hostMobile);
            apartment.setDistrictId(districtId);
            apartment.setApartmentAddress(apartmentAddress);
            apartment.setApartmentLat(apartmentLat);
            apartment.setApartmentLon(apartmentLon);
            apartment.setApartmentAccessible(apartmentAccessible);
            boolean updateApartmentSuccess = apartmentService.update(apartment, apartmentId);

            String accountUsername = request.getParameter("accountUsername");
            String accountPassword = request.getParameter("accountPassword");
            boolean accountAccessible = request.getParameter("accountAccessible") != null;

            Account account = accountService.getOne(accountId);
            account.setAccountUsername(accountUsername);
            account.setAccountPassword(accountPassword);
            account.setAccountAccessible(accountAccessible);
            boolean updateAccountSuccess = new AccountService().update(account, accountId);

            if (updateApartmentSuccess && updateAccountSuccess) {
                session.setAttribute("messageUpdate", "success|Update|Update Apartment Success");
            } else {
                session.setAttribute("messageUpdate", "error|Update|Update Apartment Fail");
            }
            response.sendRedirect("host-apartment-detail?accountId=" + accountId);
        }

        if (submitType.equals("Delete")) {
            boolean deleteAccountSuccess = new AccountService().delete(accountId);
            boolean deleteApartmentSuccess = new ApartmentService().delete(apartmentId);

            if (deleteAccountSuccess && deleteApartmentSuccess) {
                session.setAttribute("messageUpdate", "success|Delete|Delete Apartment Success");
                response.sendRedirect("admin");
            } else {
                session.setAttribute("messageUpdate", "error|Delete|Delete Apartment Fail");
                response.sendRedirect("host-apartment-detail?accountId=" + accountId);
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
