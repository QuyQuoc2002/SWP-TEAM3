/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import service.PaymentService;
import utils.Calendars;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PagePaymentHistoryController", urlPatterns = {"/payment-history"})
public class PagePaymentHistoryController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            PaymentService paymentService = new PaymentService();
            List<Payment> paymentHistories = paymentService.getAllHistoryByApartmentId(curAccount.getApartmentId());
            request.setAttribute("paymentHistories", paymentHistories);
            request.setAttribute("Calenders", new Calendars());

            //char
            //check now year
            int yearNow = Calendar.getInstance().get(Calendar.YEAR);
            long timeNow = Calendars.getCurrentTime();
            long firstMonth = Calendars.getCurrentTimeYear();
            long countMonth = (timeNow - firstMonth) / 2592000 + 1;
            List<Payment> paymentYears = new ArrayList();
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            long monthSelect = firstMonth;
            for (int i = 0; i < countMonth; i++) {
                int totalMoney = 0;
                List<Payment> paymentMonth = paymentService.getAllHistoryMonth(curAccount.getApartmentId(), monthSelect, monthSelect + 2592000);
                for (Payment payment : paymentMonth) {
                    totalMoney += payment.getPaymentTotalMoney();
                }
                Payment monthPayment = Payment.builder()
                        .paymentTotalMoney(totalMoney)
                        .month(months[i])
                        .build();

                paymentYears.add(monthPayment);
                monthSelect += 2592000;
            }

            request.setAttribute("paymentYears", paymentYears);
            request.setAttribute("Year", yearNow);
            request.getRequestDispatcher("payment-history.jsp").forward(request, response);
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
