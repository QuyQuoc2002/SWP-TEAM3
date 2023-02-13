/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.VehicleTypeDAO;
import entity.VehicleType;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class VehicleTypeService {
    
    private VehicleTypeDAO vehicleTypeDAO = new VehicleTypeDAO();
    
    public List<VehicleType> getAll() {
        return vehicleTypeDAO.getAll();
    }
    
}
