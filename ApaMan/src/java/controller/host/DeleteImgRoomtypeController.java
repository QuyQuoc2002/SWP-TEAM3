/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.host;

import entity.RoomtypeImgBanner;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import service.RoomtypeImgBannerService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "DeleteImgRoomtypeController", urlPatterns = {"/delete-img-roomtype"})
public class DeleteImgRoomtypeController extends HttpServlet {

    public File getFolderDelete() throws IOException {
        String readPart = getServletContext().getRealPath("/");
        String partUpload = readPart.replace("build\\", "") + "assets\\images";
        File folderUpload = new File(partUpload);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

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
            HttpSession session = request.getSession();
            RoomtypeImgBannerService roomtypeImgBannerService = new RoomtypeImgBannerService();

            int roomtypeImgBannerId = Integer.parseInt(request.getParameter("roomtypeImgBannerId"));
            int roomtypeId = Integer.parseInt(request.getParameter("roomtypeIdImg"));

            String roomtypeImgBannerPathNew = String.valueOf("assets/system/defaultImgSystem.png");

            RoomtypeImgBanner roomtypeImgBanner = roomtypeImgBannerService.getOne(roomtypeImgBannerId);
            String roomtypeImgBannerPath = roomtypeImgBanner.getRoomtypeImgBannerPath();
            String fileName = roomtypeImgBannerPath.replace("assets/images/", "");
            File storeFile = new File(this.getFolderDelete().getAbsolutePath() + File.separator + fileName);
            if (storeFile.delete()) {
                RoomtypeImgBanner roomtypeImgBannerNew = new RoomtypeImgBannerService().getOne(roomtypeImgBannerId);
                roomtypeImgBannerNew.setRoomtypeImgBannerPath(roomtypeImgBannerPathNew);
                boolean updateRoomtypeImgBannerSuccess = roomtypeImgBannerService.update(roomtypeImgBannerNew, roomtypeImgBannerId);

                if (updateRoomtypeImgBannerSuccess) {
                    
                    session.setAttribute("messageUpdate", "success|Delete|Delete Img Roomtype Success");
                } else {
                    session.setAttribute("messageUpdate", "error|Delete|Delete Img Roomtype Fail");
                }
            } else {
                session.setAttribute("messageUpdate", "error|Delete|Delete Img Banner Fail");
            }
            response.sendRedirect("roomtype-detail?roomtypeId=" + roomtypeId);
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
