package controller.host;


import entity.RoomtypeImgBanner;
import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.RoomtypeImgBannerService;

@WebServlet(name = "UpdateImgRoomtypeController", urlPatterns = {"/update-img-roomtype"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateImgRoomtypeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int i = 2;
        int roomtypeImgBannerId = Integer.parseInt(request.getParameter("roomtypeImgBannerId"));
        int roomtypeId = Integer.parseInt(request.getParameter("roomtypeIdImg"));
        
        RoomtypeImgBanner roomtypeImgBannerOld = new RoomtypeImgBannerService().getOne(roomtypeImgBannerId);
        String oldImgPath = roomtypeImgBannerOld.getRoomtypeImgBannerPath();
        
        String oldImgName = oldImgPath.replace("assets/images/", "");
        for (Part part : request.getParts()) {
            if (i < request.getParts().size()) {
                String fileName = "img-roomtype" + roomtypeImgBannerId + extractFileName(part);
                // refines the fileName in case it is an absolute path
                File storeFile = new File(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                File oldImgFile = new File(this.getFolderUpload().getAbsolutePath() + File.separator + oldImgName);
                if (storeFile.exists()) {
                    storeFile.delete();
                }
                if (oldImgFile.exists()) {
                    oldImgFile.delete();
                }
                part.write(storeFile.toString());
                RoomtypeImgBanner roomtypeImgBanner = new RoomtypeImgBannerService().getOne(roomtypeImgBannerId);
                roomtypeImgBanner.setRoomtypeImgBannerPath("assets/images/" + fileName);
                boolean updateSuccess = new RoomtypeImgBannerService().update(roomtypeImgBanner, roomtypeImgBannerId);
                if (updateSuccess) {
                    session.setAttribute("messageUpdate", "success|Update|Update Img Roomtype Success");
                } else {
                    session.setAttribute("messageUpdate", "error|Update|Update Img Roomtype Fail");
                }

            }
            i++;
        }
        response.sendRedirect("roomtype-detail?roomtypeId=" + roomtypeId);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private File getFolderUpload() throws IOException {
        String readPart = getServletContext().getRealPath("/");
        String partUpload = readPart.replace("build\\", "") + "assets\\images";
        File folderUpload = new File(partUpload);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
