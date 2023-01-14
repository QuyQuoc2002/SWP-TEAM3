/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ApartmentImgBannerDAO;
import entity.ApartmentImgBanner;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ApartmentImgBannerService {
    
    private ApartmentImgBannerDAO apartmentImgBannerDAO = new ApartmentImgBannerDAO();
    
    public List<ApartmentImgBanner> getAll(int apartmentId) {
        return apartmentImgBannerDAO.getAll(apartmentId);
    }
}
