/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.FloorDAO;
import entity.Floor;
import java.util.List;

/**
 *
 * @author DELL
 */
public class FloorService {
    
    private FloorDAO floorDAO = new FloorDAO();
    
    public List<Floor> getAll(int apartmentId) {
        return floorDAO.getAll(apartmentId);
    }
    
    public Floor getOne(int apartmentId) {
        return floorDAO.getOne(apartmentId);
    }
    
    public boolean add(Floor obj) {
        return floorDAO.add(obj);
    }
    
    public boolean updateFloors(List<Floor> list) {
        return floorDAO.updateFloors(list);
    }
    
    public boolean delete(int floorId, int apartmentId) {
        return floorDAO.delete(floorId, apartmentId);
    }
}
