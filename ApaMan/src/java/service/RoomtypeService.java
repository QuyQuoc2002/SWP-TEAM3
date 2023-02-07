/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.RoomtypeDAO;
import entity.Roomtype;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomtypeService {
    
    private RoomtypeDAO roomtypeDAO = new RoomtypeDAO();
    
    public List<Roomtype> getAll(int apartmentId) {
        return roomtypeDAO.getAll(apartmentId);
    }
}
