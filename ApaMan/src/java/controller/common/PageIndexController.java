/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

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
import java.util.List;
import service.ApartmentService;
import service.CityService;
import service.DistrictService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PageIndexController", urlPatterns = {""})
public class PageIndexController extends HttpServlet {

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
//            List<City> cities = new CityService().getAll();
//            List<District> districts = new DistrictService().getAll();
//            request.setAttribute("cities", cities);
//            request.setAttribute("districts", districts);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
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
            List<City> cities = new CityService().getAll();
            List<District> districts = new DistrictService().getAll();
            List<Apartment> apartments = new ApartmentService().getAll(0);

            request.setAttribute("apartments", apartments);
            request.setAttribute("cities", cities);
            request.setAttribute("districts", districts);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
            
            String searchType = request.getParameter("searchType");
            

            List<City> cities = new CityService().getAll();
            List<District> districts = new DistrictService().getAll();

            request.setAttribute("cities", cities);
            request.setAttribute("districts", districts);
            
            switch (searchType) {
                case "select":
                    int districtId = Integer.parseInt(request.getParameter("districtId"));

                    List<Apartment> apartments = new ApartmentService().getAll(districtId);

                    request.setAttribute("districtId", districtId);
                    request.setAttribute("apartments", apartments);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;

                case "text":
                    String keyWord = request.getParameter("keyWord");
                    List<Apartment> listApartment = new ApartmentService().searchKeyword(keyWord);
                    
                    request.setAttribute("keyWord", keyWord);
                    request.setAttribute("apartments", listApartment);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;

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
