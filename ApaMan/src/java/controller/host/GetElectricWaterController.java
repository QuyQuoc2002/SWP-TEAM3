/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Payment;
import entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.FeeService;
import service.PaymentService;
import service.RoomService;
import utils.Calendars;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "GetElectricWaterController", urlPatterns = {"/GetElectricWater"})
public class GetElectricWaterController extends HttpServlet {

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
            out.println("<title>Servlet GetElectricWater</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetElectricWater at " + request.getContextPath() + "</h1>");
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
            room.setCountUpdate(paymentService.countUpdate(room.getRoomId()));
            room.setCarQuantity(roomService.countVehicle(roomId, 3));
            room.setMotorQuantity(roomService.countVehicle(roomId, 1));
            room.setBikeQuantity(roomService.countVehicle(roomId, 2));

            long paymentDayUpdateNow = Calendars.getCurrentTime();

            session.setAttribute("payment", payment);
            session.setAttribute("room", room);
            session.setAttribute("isOpenModal", "open");
            session.setAttribute("Calendars", new Calendars());
            session.setAttribute("paymentDayUpdateNow", paymentDayUpdateNow);

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
            FeeService feeService = new FeeService();
            RoomService roomService = new RoomService();

            int roomId = Integer.parseInt(request.getParameter("roomIdPayment"));
            int floorId = Integer.parseInt(request.getParameter("floorIdPayment"));
            int paymentRoomUnitFee = Integer.parseInt(request.getParameter("paymentRoomUnitFee"));
            int countUpdate = Integer.parseInt(request.getParameter("countUpdate"));
            long paymentDayUpdateCur = Calendars.getCurrentTime();
            int paymentWaterIndexPre = 0;
            int paymentElectricIndexPre = 0;
            long paymentDayUpdatePre = paymentDayUpdateCur;
            if (countUpdate != 0) {
                paymentWaterIndexPre = Integer.parseInt(request.getParameter("paymentWaterIndexPre"));
                paymentElectricIndexPre = Integer.parseInt(request.getParameter("paymentElectricIndexPre"));
                paymentDayUpdatePre = Long.parseLong(request.getParameter("paymentDayUpdatePre"));
                System.out.println(paymentWaterIndexPre);
            }
            int paymentWaterIndexCur = Integer.parseInt(request.getParameter("paymentWaterIndexCur"));
            int paymentElectricIndexCur = Integer.parseInt(request.getParameter("paymentElectricIndexCur"));
            

            int paymentWaterUnitFee = feeService.getValue(3);
            int paymentElectricUnitFee = feeService.getValue(4);

            int paymentWaterMoney = paymentWaterUnitFee * (paymentWaterIndexCur - paymentWaterIndexPre);
            int paymentElectricMoney = paymentElectricUnitFee * (paymentElectricIndexCur - paymentElectricIndexPre);

            int paymentCarQuantity = Integer.parseInt(request.getParameter("paymentCarQuantity"));
            int paymentMotorQuantity = Integer.parseInt(request.getParameter("paymentMotorQuantity"));
            int paymentBikeQuantity = Integer.parseInt(request.getParameter("paymentBikeQuantity"));

            int paymentCarUnitFee = feeService.getValue(8);
            int paymentMotorUnitFee = feeService.getValue(1);
            int paymentBikeUnitFee = feeService.getValue(2);

            int paymentCarMoney = paymentCarQuantity * paymentCarUnitFee;
            int paymentMotorMoney = paymentMotorQuantity * paymentMotorUnitFee;
            int paymentBikeMoney = paymentBikeQuantity * paymentBikeUnitFee;

            int paymentTotalMoney = paymentRoomUnitFee + paymentWaterMoney + paymentElectricMoney + paymentCarMoney + paymentMotorMoney + paymentBikeMoney;

            Payment objPayment = Payment.builder()
                    .roomId(roomId)
                    .paymentRoomUnitFee(paymentRoomUnitFee)
                    .paymentWaterIndexPre(paymentWaterIndexPre)
                    .paymentElectricIndexPre(paymentElectricIndexPre)
                    .paymentDayUpdatePre(paymentDayUpdatePre)
                    .paymentWaterIndexCur(paymentWaterIndexCur)
                    .paymentElectricIndexCur(paymentElectricIndexCur)
                    .paymentDayUpdateCur(paymentDayUpdateCur)
                    .paymentWaterUnitFee(paymentWaterUnitFee)
                    .paymentWaterMoney(paymentWaterMoney)
                    .paymentElectricUnitFee(paymentElectricUnitFee)
                    .paymentElectricMoney(paymentElectricMoney)
                    .paymentCarQuantity(paymentCarQuantity)
                    .paymentCarUnitFee(paymentCarUnitFee)
                    .paymentCarMoney(paymentCarMoney)
                    .paymentMotorQuantity(paymentMotorQuantity)
                    .paymentMotorUnitFee(paymentMotorUnitFee)
                    .paymentMotorMoney(paymentMotorMoney)
                    .paymentBikeQuantity(paymentBikeQuantity)
                    .paymentBikeUnitFee(paymentBikeUnitFee)
                    .paymentBikeMoney(paymentBikeMoney)
                    .paymentTotalMoney(paymentTotalMoney)
                    .build();
            boolean addPaymentSuccess = paymentService.add(objPayment);
            boolean updateRoomPaymentStatus = roomService.updateRoomPaymentStatus(2, roomId);

            if (addPaymentSuccess && updateRoomPaymentStatus) {
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
