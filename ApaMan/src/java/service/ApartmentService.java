/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ApartmentDAO;
import entity.Apartment;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ApartmentService {
    
    private ApartmentDAO apartmentDAO = new ApartmentDAO();
    
    public List<Apartment> getAll(int districtId) {
        return apartmentDAO.getAll(districtId);
    }
    
    public Apartment getOne(int apartmentId) {
        return apartmentDAO.getOne(apartmentId);
    }
}
