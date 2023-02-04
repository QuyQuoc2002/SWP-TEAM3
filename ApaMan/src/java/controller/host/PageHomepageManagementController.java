/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.Account;
import entity.Apartment;
import entity.ApartmentImgBanner;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import service.ApartmentImgBannerService;
import service.ApartmentService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageHomepageManagementController", urlPatterns = {"/homepage-management"})
public class PageHomepageManagementController extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            HttpSession session = request.getSession();
//            Account curAccount = (Account) session.getAttribute("curAccount");
//            Apartment apartment = new ApartmentService().getOne(curAccount.getApartmentId());
//            List<ApartmentImgBanner> apartmentImgBanners = new ApartmentImgBannerService().getAll(curAccount.getApartmentId());
//            
//            request.setAttribute("apartment", apartment);
//            request.setAttribute("apartmentImgBanners", apartmentImgBanners);
//            request.getRequestDispatcher("homepage-management.jsp").forward(request, response);
//        }
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
            Apartment apartment = new ApartmentService().getOne(curAccount.getApartmentId());
            List<ApartmentImgBanner> apartmentImgBanners = new ApartmentImgBannerService().getAll(curAccount.getApartmentId());

            request.setAttribute("apartment", apartment);
            request.setAttribute("apartmentImgBanners", apartmentImgBanners);
            request.getRequestDispatcher("homepage-management.jsp").forward(request, response);
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
            ApartmentService apartmentService = new ApartmentService();
            Account curAccount = (Account) session.getAttribute("curAccount");
            int apartmentId = curAccount.getApartmentId();
            Apartment apartment = apartmentService.getOne(apartmentId);
            List<ApartmentImgBanner> apartmentImgBanners = new ApartmentImgBannerService().getAll(apartmentId);

            boolean updateSuccess = false;
            String editType = request.getParameter("editType");
            switch (editType) {
                case "editIntroduction":
                    apartment.setApartmentIntro(request.getParameter("editIntroductionContent"));
                    break;
                case "editAboutus":
                    apartment.setApartmentContentAboutus(request.getParameter("editAboutusContent"));
                    break;
                case "editService":
                    apartment.setApartmentContentService(request.getParameter("editServiceContent"));
                    break;
                case "editRecruitment":
                    apartment.setApartmentContentRecruitment(request.getParameter("editRecruitmentContent"));
                    break;
            }
            updateSuccess = apartmentService.update(apartment, apartmentId);
            if (updateSuccess) {
                apartment = apartmentService.getOne(apartmentId);
                request.setAttribute("apartment", apartment);
                request.setAttribute("apartmentImgBanners", apartmentImgBanners);               
                session.setAttribute("messageUpdate", "info|Edit|Edit success!");
                request.getRequestDispatcher("homepage-management.jsp").forward(request, response);
            } else {
                session.setAttribute("messageUpdate", "error|Edit|Something wrong, edit Failed");
                response.sendRedirect("homepage-management");
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
