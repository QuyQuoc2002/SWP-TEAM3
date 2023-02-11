/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.RoomtypeImgBannerDAO;
import entity.RoomtypeImgBanner;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomtypeImgBannerService {
    
    private RoomtypeImgBannerDAO roomtypeImgBannerDAO = new RoomtypeImgBannerDAO();
    
    public List<RoomtypeImgBanner> getAll(int roomtypeId) {
        return roomtypeImgBannerDAO.getAll(roomtypeId);
    }
    
    public RoomtypeImgBanner getOne(int roomtypeImgBannerId) {
        return roomtypeImgBannerDAO.getOne(roomtypeImgBannerId);
    }
    
    public boolean add(List<RoomtypeImgBanner> list) {
        return roomtypeImgBannerDAO.add(list);
    }
    
    public boolean update(RoomtypeImgBanner obj, int roomtypeImgBannerId) {
        return roomtypeImgBannerDAO.update(obj, roomtypeImgBannerId);
    }
    
    public boolean delete(int roomtypeImgBannerId) {
        return roomtypeImgBannerDAO.delete(roomtypeImgBannerId);
    }
    
    public boolean deleteAllRoomtype(int roomtypeId) {
        return roomtypeImgBannerDAO.deleteAllRoomtype(roomtypeId);
    }
}
