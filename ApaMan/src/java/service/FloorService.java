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
}
