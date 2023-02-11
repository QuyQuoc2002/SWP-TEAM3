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
    
    public Roomtype getOne(int roomtypeID) {
        return roomtypeDAO.getOne(roomtypeID);
    }
    
    public int add(Roomtype obj) {
        return roomtypeDAO.add(obj);
    }
    
    public boolean updateRoomtype(Roomtype obj) {
        return roomtypeDAO.updateRoomtype(obj);
    }
    
    public boolean delete(int roomtypeId, int apartmentId) {
        return roomtypeDAO.delete(roomtypeId, apartmentId);
    }
}
