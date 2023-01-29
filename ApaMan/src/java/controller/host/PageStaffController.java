/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Staff;
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
import service.StaffService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageStaffController", urlPatterns = {"/staff"})
public class PageStaffController extends HttpServlet {

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
            out.println("<title>Servlet PageStaffController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PageStaffController at " + request.getContextPath() + "</h1>");
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
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            List<Staff> staffs = new StaffService().getAll(apartmentId);
            request.setAttribute("staffs", staffs);
            request.getRequestDispatcher("staff.jsp").forward(request, response);
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
            Account curAccount = (Account) session.getAttribute("curAccount");
            String submitType = request.getParameter("submitType");
            AccountService accountService = new AccountService();
            StaffService staffService = new StaffService();
            int staffId;
            int accountId;
            
            switch (submitType) {
                case "Save":
                    String password = request.getParameter("password");
                    boolean accountAccessible = request.getParameter("accountAccessible") != null;
                    String countrySide = request.getParameter("countrySide");
                    String dob = request.getParameter("dob");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String citizenIdentification = request.getParameter("citizenIdentification");
                    String salary = request.getParameter("salary");
                    String name = request.getParameter("name");
                    String job = request.getParameter("job");
                    staffId = Integer.parseInt(request.getParameter("staffId"));
                    accountId = Integer.parseInt(request.getParameter("accountId"));
                    
                    Account account = accountService.getOne(accountId);
                    account.setAccountAccessible(accountAccessible);
                    account.setAccountPassword(password);
                    boolean updateAccountSuccess = accountService.update(account, accountId);
                    
                    Staff staff = staffService.getOne(staffId);
                    staff.setStaffCountryside(countrySide);
                    staff.setStaffDob(dob);
                    staff.setStaffPhoneNumber(phoneNumber);
                    staff.setStaffCitizenIdentification(citizenIdentification);
                    staff.setStaffSalary(salary);
                    staff.setStaffName(name);
                    staff.setStaffJob(job);
                    boolean updateStaffSuccess = staffService.update(staff, staffId);
                    
                    if (updateAccountSuccess && updateStaffSuccess) {
                        session.setAttribute("messageUpdate", "success|Update|Update Success");
                    } else {
                        session.setAttribute("messageUpdate", "error|Update|Update Fail");
                    }
                    break;
                case "Delete":
                    staffId = Integer.parseInt(request.getParameter("staffId"));
                    accountId = Integer.parseInt(request.getParameter("accountId"));
                    boolean deleteAccountSuccess = accountService.delete(accountId);
                    boolean deleteStaffSuccess = staffService.delete(staffId);
                    
                    if (deleteAccountSuccess && deleteStaffSuccess) {
                        session.setAttribute("messageUpdate", "success|Delete|Delete Success");
                    } else {
                        session.setAttribute("messageUpdate", "error|Delete|Delete Fail");
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            int apartmentId = curAccount.getApartmentId();

            List<Staff> staffs = staffService.getAll(apartmentId);
            request.setAttribute("staffs", staffs);
            request.getRequestDispatcher("staff.jsp").forward(request, response);
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
