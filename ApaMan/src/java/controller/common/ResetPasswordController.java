/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

import constant.IConst;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AccountService;
import utils.Cypher;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ResetPasswordController", urlPatterns = {"/reset-password"})
public class ResetPasswordController extends HttpServlet {

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
        HttpSession session = request.getSession();
        int apartmentId = Integer.parseInt(request.getParameter("apartmentId"));
        String username = request.getParameter("username");
        try {
            /* TODO output your page here. You may use following sample code. */
            int code = Integer.parseInt(request.getParameter("code")); //exceoption
            int oldCode = (int) session.getAttribute("code"); //exceoption
            if (code == oldCode) {
                String newPassword = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");
                if (newPassword.matches(IConst.REGEX_PASSWORD)) {
                    if (newPassword.equals(confirmPassword)) {
                        boolean resetSuccess = new AccountService().resetPassword(username, Cypher.encryptData(newPassword, IConst.SHIFT_KEY), apartmentId);
                        if (resetSuccess) {
                            String message = "Change Password success";
                            session.setAttribute("message", message);
                            session.removeAttribute("code");
                            response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
                        } else {
                            response.sendRedirect("WEB-INF/error-404.jsp");
                        }
                    } else {
                        session.setAttribute("message", "Password not matches");
                        response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
                    }
                } else {
                    session.setAttribute("message", "Password is wrong format");
                    response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
                }
            } else {
                session.setAttribute("message", "Wrong Code Confirm");
                response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
            }
            /*
            if (code != oldCode) {
                session.setAttribute("message", "Wrong Code Confirm");
                response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
            }
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            if (!newPassword.matches(IConst.REGEX_PASSWORD)) {
                session.setAttribute("message", "Password is wrong format");
                response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
            }
            if (!newPassword.equals(confirmPassword)) {
                session.setAttribute("message", "Password not matches");
                response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
            }
            boolean resetSuccess = new AccountService().resetPassword(username, Cypher.encryptData(newPassword, IConst.SHIFT_KEY), apartmentId);
            if (resetSuccess) {
                String message = "Change Password success";
                session.setAttribute("message", message);
                session.removeAttribute("code");
                response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
            } else {
                response.sendRedirect("WEB-INF/error-404.jsp");
            }
            */
        } catch (IOException | NumberFormatException |NullPointerException e) {
            session.setAttribute("message", "Wrong Code Confirm");
            response.sendRedirect("confirm-code?apartmentId=" + apartmentId + "&username=" + username);
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
        processRequest(request, response);
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
