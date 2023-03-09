/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Laputa
 */

import dao.RoomDAO;
import entity.Room;
import java.util.List;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();
    
    public int numberOfRooms(int apartmentId) {
        return roomDAO.numberOfRooms(apartmentId);
    }
    
    public int numberOfStatusRoom(int apartmentId, int roomStatusId) {
        return roomDAO.numberOfStatusRoom(apartmentId,roomStatusId);
    }
    
    public int numberOfTenantActive(int roomId) {
        return roomDAO.numberOfTenantActive(roomId);
    }
    
    
    public int countVehicle(int roomId, int vehicaleTypeId) {
        return roomDAO.countVehicle(roomId, vehicaleTypeId);
    }
    
    public List<Room> getAll(int floorId, int apartmentId) {
        return roomDAO.getAll(floorId,apartmentId);
    }
    
    public List<Room> getAll( int apartmentId) {
        return roomDAO.getAll(apartmentId);
    }
    
    public List<Room> getAllStatus( int apartmentId, int roomStatusId) {
        return roomDAO.getAllStatus(apartmentId,roomStatusId);
    }
    
    public List<Room> getFindRoommate( int apartmentId, boolean findRoommate) {
        return roomDAO.getFindRoommate(apartmentId,findRoommate);
    }
    
    public Room getOne(int roomId, int apartmentId) {
        return roomDAO.getOne(roomId,apartmentId);
    }
    
    public int add(Room obj) {
        return roomDAO.add(obj);
    }
    
    public boolean update(Room obj) {
        return roomDAO.update(obj);
    }
    
    public boolean updateRoomPaymentStatus(int paymentStatusId, int roomId) {
        return roomDAO.updateRoomPaymentStatus(paymentStatusId, roomId);
    }
    
    public boolean updateRooms(List<Room> list) {
        return roomDAO.updateRooms(list);
    }
    
    public boolean delete(int roomId, int floorId) {
        return roomDAO.delete(roomId, floorId);
    }
    
}
