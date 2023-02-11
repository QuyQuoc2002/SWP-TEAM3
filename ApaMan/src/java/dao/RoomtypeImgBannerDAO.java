
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.RoomtypeImgBanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomtypeImgBannerDAO {

    public List<RoomtypeImgBanner> getAll(int roomtypeId) { //20Loc
        String sql = "SELECT * FROM roomtype_img_banner Where roomtype_id = ?";//
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeId);
            ResultSet rs = ps.executeQuery();
            List<RoomtypeImgBanner> list = new ArrayList<>();//
            while (rs.next()) {
                RoomtypeImgBanner obj = RoomtypeImgBanner.builder()
                        .roomtypeImgBannerId(rs.getInt("roomtype_img_banner_id"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .roomtypeImgBannerPath(rs.getString("roomtype_img_banner_path"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public RoomtypeImgBanner getOne(int roomtypeImgBannerId) { //17LOC
        String sql = "SELECT * FROM roomtype_img_banner WHERE roomtype_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeImgBannerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                RoomtypeImgBanner obj = RoomtypeImgBanner.builder()
                        .roomtypeImgBannerId(rs.getInt("roomtype_img_banner_id"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .roomtypeImgBannerPath(rs.getString("roomtype_img_banner_path"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(List<RoomtypeImgBanner> list) { 
        int[] arr = {};
        String sql = "INSERT INTO roomtype_img_banner(roomtype_id, roomtype_img_banner_path)"
                + " VALUES(?, ?)";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if (ps != null) {
                for (RoomtypeImgBanner obj : list) {
                    ps.setObject(1, obj.getRoomtypeId());
                    ps.setObject(2, obj.getRoomtypeImgBannerPath());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }
    
     public boolean update(RoomtypeImgBanner obj, int roomtypeImgBannerId) { //13Loc
        int check = 0;
        String sql = "UPDATE roomtype_img_banner SET "
                + "roomtype_img_banner_path = ? "
                + "WHERE roomtype_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getRoomtypeImgBannerPath());
            ps.setObject(2, roomtypeImgBannerId);
            
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     
     public boolean delete(int roomtypeImgBannerId) {//9 loc
        int check = 0;
        String sql = "DELETE FROM roomtype_img_banner WHERE roomtype_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeImgBannerId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     
      public boolean deleteAllRoomtype(int roomtypeId) {//9 loc
        int check = 0;
        String sql = "DELETE FROM roomtype_img_banner WHERE roomtype_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     
     public static void main(String[] args) {
         System.out.println(new RoomtypeImgBannerDAO().getOne(5));
    }
}

