package controller.admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import constant.IConst;
import entity.Account;
import entity.Apartment;
import entity.City;
import entity.District;
import entity.Role;
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
import utils.Calendars;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/admin"})
public class PageAdminController extends HttpServlet {

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
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            List<Account> listHostAccount = new AccountService().getAllHostAccount();
            request.setAttribute("listHostAccount", listHostAccount);

            List<City> listCity = new CityService().getAll();
            request.setAttribute("listCity", listCity);

            List<District> listDistrict = new DistrictService().getAll();
            request.setAttribute("listDistrict", listDistrict);

            List<Apartment> listApartment = new ApartmentService().getAll();
            request.setAttribute("listApartment", listApartment);
            
            request.setAttribute("Calendars", new Calendars());

            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            String apartmentName = request.getParameter("apartmentName");
            String hostName = request.getParameter("hostName");
            String hostMobile = request.getParameter("hostMobile");
            String apartmentAddress = request.getParameter("apartmentAddress");
            int districtId = Integer.parseInt(request.getParameter("districtId"));
            String apartmentLat = request.getParameter("apartmentLat");
            String apartmentLong = request.getParameter("apartmentLong");
            long apartmentCreateTime = Calendars.getCurrentTime();

            Apartment objApartment = Apartment.builder()
                    .apartmentName(apartmentName)
                    .hostName(hostName)
                    .hostMobile(hostMobile)
                    .apartmentAddress(apartmentAddress)
                    .districtId(districtId)
                    .apartmentLat(apartmentLat)
                    .apartmentLon(apartmentLong)
                    .apartmentCreateTime(apartmentCreateTime)
                    .apartmentAccessible(false)
                    .build();

            String accountUsername = request.getParameter("accountUsername");
            String accountPassword = request.getParameter("accountPassword");

            int apartmentId = new ApartmentService().add(objApartment);

            Account objAccount = Account.builder()
                    .apartmentId(apartmentId)
                    .accountUsername(accountUsername)
                    .accountPassword(accountPassword)
                    .accountAccessible(false)
                    .role(Role.builder()
                            .roleId(IConst.ROLE_HOST_ID)
                            .build()
                    )
                    .build();

            int addAccountSuccess = new AccountService().add(objAccount);
            if (addAccountSuccess > 0) {
                session.setAttribute("messageUpdate", "success|Add|Add Apartment Success");
            } else {
                session.setAttribute("messageUpdate", "error|Add|Add Apartment Fail");
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
