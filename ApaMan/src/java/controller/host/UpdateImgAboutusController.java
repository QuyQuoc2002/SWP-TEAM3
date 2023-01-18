package controller.host;

import entity.Account;
import entity.Apartment;
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
import service.ApartmentService;

@WebServlet(name = "UpdateImgAboutusController", urlPatterns = {"/update-img-aboutus"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UpdateImgAboutusController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 1;
        HttpSession session = request.getSession();
        Account curAccount = (Account) session.getAttribute("curAccount");
        int apartmentId = curAccount.getApartmentId();
        String oldImgPath = request.getParameter("apartmentImgAboutus");
        String oldImgName = oldImgPath.replace("assets/images/", "");
        for (Part part : request.getParts()) {
            if (i < request.getParts().size()) {
                String fileName = "img-about-us" + apartmentId +  extractFileName(part);
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
                Apartment apartment = new ApartmentService().getOne(apartmentId);
                apartment.setApartmentImgAboutus("assets/images/" + fileName);
                boolean updateSuccess = new ApartmentService().update(apartment, apartmentId);
                if (updateSuccess) {
                    session.setAttribute("messageUpdate", "success|Update|Update Img About Us Success");
                } else {
                    session.setAttribute("messageUpdate", "error|Update|Update Img About Us Fail");
                }

            }
            i++;
        }
        response.sendRedirect("homepage-management#about-us");
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

    public File getFolderUpload() throws IOException {
        String readPart = getServletContext().getRealPath("/");
        String partUpload = readPart.replace("build\\", "") + "assets\\images";
        File folderUpload = new File(partUpload);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
