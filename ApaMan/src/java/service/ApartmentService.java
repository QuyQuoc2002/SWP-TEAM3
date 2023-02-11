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
    
    public List<Apartment> searchKeyword(String keyword) {
        return apartmentDAO.searchKeyword(keyword);
    }
    
    public List<Apartment> getAll() {
        return apartmentDAO.getAll();
    }
    
    public Apartment getOne(int apartmentId, boolean accessible) {
        return apartmentDAO.getOne(apartmentId, accessible);
    }
    
    public Apartment getOne(int apartmentId) {
        return apartmentDAO.getOne(apartmentId);
    }
    
    public int add(Apartment obj) {
        return apartmentDAO.add(obj);
    }
    
    public boolean update(Apartment obj, int apartmentId) {
        return apartmentDAO.update(obj, apartmentId);
    }
    
    public boolean delete(int apartmentId) {
        return apartmentDAO.delete(apartmentId);
    }
}
