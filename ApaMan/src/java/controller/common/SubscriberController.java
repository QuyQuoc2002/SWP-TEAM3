/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

import entity.Apartment;
import entity.City;
import entity.District;
import entity.Subscriber;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import service.ApartmentService;
import service.CityService;
import service.DistrictService;
import service.SubscriberService;

/**
 *
 * @author Laputa
 */
@WebServlet(name = "SubscriberController", urlPatterns = {"/subscriber"})
public class SubscriberController extends HttpServlet {

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
            out.println("<title>Servlet SubscriberController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubscriberController at " + request.getContextPath() + "</h1>");
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
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            SubscriberService subscriberService = new SubscriberService();

            String subscriberEmail = request.getParameter("subscriberEmail");
            String page = request.getParameter("page");

            List<Subscriber> subscribers = subscriberService.getAll();

            //Check subscriber email already exist
            boolean subscriberEmailExist = false;
            for (Subscriber obj : subscribers) {
                if (subscriberEmail.equals(obj.getSubscriberEmail())) {
                    subscriberEmailExist = true;
                }
            }

            if (subscriberEmailExist) {
                session.setAttribute("messageUpdate", "warning|APAMAN Notification|Email Exist, Subscribe Fail|edit-subscribe");
            } else {
                boolean addSubscriberSuccess = subscriberService.add(subscriberEmail);
                if (addSubscriberSuccess) {
                    session.setAttribute("messageUpdate", "success|APAMAN Notification|Subscribe Success|edit-subscribe");
                } else {
                    session.setAttribute("messageUpdate", "error|APAMAN Notification|Subscribe Fail|edit-subscribe");
                }
            }
            if (page.equals("homePage")) {
                int apartmentId = Integer.parseInt(request.getParameter("apartmentId"));
                response.sendRedirect("homepage?apartmentId=" + apartmentId);
            }
            if (page.equals("index")) {
                List<City> cities = new CityService().getAll();
                List<District> districts = new DistrictService().getAll();
                List<Apartment> apartmentTop = new ApartmentService().getAll(0);

                request.setAttribute("apartmentTop", apartmentTop);
                request.setAttribute("cities", cities);
                request.setAttribute("districts", districts);
                request.setAttribute("selectType", false);
                request.setAttribute("textType", true);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
