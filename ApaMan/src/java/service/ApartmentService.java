/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ApartmentDAO;
import entity.Apartment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import utils.Map;

/**
 *
 * @author DELL
 */
public class ApartmentService {

    private ApartmentDAO apartmentDAO = new ApartmentDAO();

    public List<Apartment> getAll(int districtId) {
        return apartmentDAO.getAll(districtId);
    }

    public List<Apartment> getAllByRadius(double latDevice, double lonDevice, double radius) {
        
        List<Apartment> lstByRadius = new ArrayList<>();
        List<Apartment> lstAllApartment = apartmentDAO.getAll(0);
        for (Apartment apartment : lstAllApartment) {
            double distanceFromDevice = Map.getDistanceBetweenPointsNew(
                    latDevice,
                    lonDevice,
                    Double.parseDouble(apartment.getApartmentLat()),
                    Double.parseDouble(apartment.getApartmentLon()),
                    "kilometers"
            );
            
            if (distanceFromDevice < radius) {
                apartment.setDistanceFromDevice(distanceFromDevice);
                lstByRadius.add(apartment);
            }
            
            Collections.sort(lstByRadius, new Comparator<Apartment>() {
                @Override
                public int compare(Apartment obj1, Apartment obj2) {
                    return Double.compare(obj1.getDistanceFromDevice(), obj2.getDistanceFromDevice());
                }
            });
        }
        return lstByRadius;
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
