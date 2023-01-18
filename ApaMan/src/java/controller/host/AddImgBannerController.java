package controller.host;

import entity.Account;
import entity.Apartment;
import entity.ApartmentImgBanner;
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
import service.ApartmentImgBannerService;
import service.ApartmentService;

@WebServlet(name = "AddImgBannerController", urlPatterns = {"/add-img-banner"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddImgBannerController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 0;
        System.out.println("asdds");
        HttpSession session = request.getSession();
        Account curAccount = (Account) session.getAttribute("curAccount");
        int apartmentId = curAccount.getApartmentId();
        for (Part part : request.getParts()) {
            if (i < request.getParts().size()) {
                int apartmentImgBannerId = new ApartmentImgBannerService().add(ApartmentImgBanner.builder().apartmentId(apartmentId).build());
                String fileName = "img-banner" + apartmentImgBannerId +  extractFileName(part);
                // refines the fileName in case it is an absolute path
                File storeFile = new File(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                part.write(storeFile.toString());
                ApartmentImgBanner apartmentImgBanner = new ApartmentImgBannerService().getOne(apartmentImgBannerId);
                apartmentImgBanner.setApartmentImgBannerPath("assets/images/" + fileName);
                boolean addSuccess = new ApartmentImgBannerService().update(apartmentImgBanner, apartmentImgBannerId);
                if (addSuccess) {
                    session.setAttribute("messageUpdate", "success|Add|Add Img Banner Success");
                } else {
                    session.setAttribute("messageUpdate", "error|Add|Add Img Banner Fail");
                }

            }
            i++;
        }
        response.sendRedirect("homepage-management#banner");
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
