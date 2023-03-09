/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Payment;
import entity.PaymentStatus;
import entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.PaymentService;
import service.RoomService;
import utils.Calendars;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/Payment"})
public class PaymentController extends HttpServlet {

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
            out.println("<title>Servlet PaymentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentController at " + request.getContextPath() + "</h1>");
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
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();

            PaymentService paymentService = new PaymentService();
            RoomService roomService = new RoomService();

            int roomId = Integer.parseInt(request.getParameter("roomId"));
            int floorId = Integer.parseInt(request.getParameter("floorId"));

            Payment payment = paymentService.getPaymentPre(roomId);
            Room room = roomService.getOne(roomId, apartmentId);

            session.setAttribute("payment", payment);
            session.setAttribute("room", room);
            session.setAttribute("isOpenModalPayment", "open");
            session.setAttribute("Calendars", new Calendars());

            response.sendRedirect("floor-room?floorId=" + floorId);

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
            PaymentService paymentService = new PaymentService();
            RoomService roomService = new RoomService();

            int roomId = Integer.parseInt(request.getParameter("roomIdPayment"));
            int floorId = Integer.parseInt(request.getParameter("floorIdPayment"));
            int paymentId = Integer.parseInt(request.getParameter("paymentId"));

            int paymentWaterMoney = Integer.parseInt(request.getParameter("paymentWaterMoney"));
            int paymentElectricMoney = Integer.parseInt(request.getParameter("paymentElectricMoney"));
            int paymentTotalMoney = Integer.parseInt(request.getParameter("paymentTotalMoney"));

            Payment payment = paymentService.getOne(paymentId);
            payment.setPaymentWaterMoney(paymentWaterMoney);
            payment.setPaymentElectricMoney(paymentElectricMoney);
            payment.setPaymentTotalMoney(paymentTotalMoney);
            payment.setPaymentStatus(PaymentStatus.builder()
                                    .paymentStatusId(3)
                                    .build());
            
            boolean updatePaymentSuccess = paymentService.updatePayment(payment);
            boolean updateRoomPaymentStatus = roomService.updateRoomPaymentStatus(3, roomId);

            if (updatePaymentSuccess && updateRoomPaymentStatus) {
                session.setAttribute("messageUpdate", "success|Add|Add Payment Success");
            } else {
                session.setAttribute("messageUpdate", "error|Add|Add Payment Fail");
            }

            response.sendRedirect("floor-room?floorId=" + floorId);

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
