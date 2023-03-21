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
import java.util.HashMap;
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
            long lastYear = Calendars.getTimeLastYear();
            long lastMonth = Calendars.getMonthLastYear();
            int nameLastMonth = Calendars.getNameMonthLastYear();
            List<Payment> paymentYears = new ArrayList();

            HashMap<Integer, String> months = new HashMap<>();
            months.put(1, "Jan");
            months.put(2, "Feb");
            months.put(3, "Mar");
            months.put(4, "Apr");
            months.put(5, "May");
            months.put(6, "Jun");
            months.put(7, "Jul");
            months.put(8, "Aug");
            months.put(9, "Sep");
            months.put(10, "Oct");
            months.put(11, "Nov");
            months.put(12, "Dec");

            long monthSelect = lastMonth;
            int indexMonth = nameLastMonth;
            for (int i = 0; i < 12; i++) {
                boolean isLeap = Calendars.isLeapYear(Calendars.getYear(monthSelect));
                int totalMoney = 0;
                
                if (i == 11) {
                    List<Payment> paymentMonth = paymentService.getAllHistoryMonth(curAccount.getApartmentId(), monthSelect, timeNow);
                    for (Payment payment : paymentMonth) {
                        totalMoney += payment.getPaymentTotalMoney();
                    }
                } else {
                    List<Payment> paymentMonth = paymentService.getAllHistoryMonth(curAccount.getApartmentId(), monthSelect, monthSelect + 2592000);
                    for (Payment payment : paymentMonth) {
                        totalMoney += payment.getPaymentTotalMoney();
                    }
                }

                Payment monthPayment = Payment.builder()
                        .paymentTotalMoney(totalMoney)
                        .month(months.get(indexMonth))
                        .build();

                paymentYears.add(monthPayment);
                if (indexMonth == 4 || indexMonth == 6 || indexMonth == 9 || indexMonth == 11) {
                    monthSelect += 2592000;
                }
                if (indexMonth == 1 || indexMonth == 3 || indexMonth == 5 || indexMonth == 7 || indexMonth == 8 || indexMonth == 10 || indexMonth == 12) {
                    monthSelect += 2678400;
                }
                if (indexMonth == 2 && isLeap == false) {
                    monthSelect += 2419200;
                }
                if (indexMonth == 2 && isLeap == true) {
                    monthSelect += 2505600;
                }

                indexMonth += 1;
                if (indexMonth == 13) {
                    indexMonth = 1;
                }
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
