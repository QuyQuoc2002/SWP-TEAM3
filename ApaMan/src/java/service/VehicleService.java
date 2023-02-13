/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.VehicleDAO;
import entity.Vehicle;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class VehicleService {
    
    private VehicleDAO vehicleDAO = new VehicleDAO();
    
    public List<Vehicle> getAll(int apartmentId) {
        return vehicleDAO.getAll(apartmentId);
    }
    
    public boolean add(Vehicle obj) {
        return vehicleDAO.add(obj);
    }

    public Vehicle getOne(int vehicleId) {
        return vehicleDAO.getOne(vehicleId);
    }

    public boolean update(Vehicle obj, int vehicleId) {
        return vehicleDAO.update(obj, vehicleId);
    }
    
    public boolean delete(int vehicleId, int apartmentId) {
        return vehicleDAO.delete(vehicleId, apartmentId);
    }
    
}
