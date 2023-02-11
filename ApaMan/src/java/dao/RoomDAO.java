/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Laputa
 */
import connection.MySQLConnection;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    
    public List<Room> getAll(int floorId, int apartmentId) {

        String sql = "SELECT * FROM room WHERE floor_id = ? AND apartment_id";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, floorId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Room> list = new ArrayList<>();//
            while (rs.next()) {
                Room obj = Room.builder()
                        .roomId(rs.getInt("room_id"))
                        .roomName(rs.getString("room_name"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomStatus(rs.getString("room_status"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Room getOne(int roomId) {
        String sql = "SELECT * FROM room WHERE room_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 Room obj = Room.builder()
                        .roomId(rs.getInt("room_id"))
                        .roomName(rs.getString("room_name"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomStatus(rs.getString("room_status"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(Room obj) {
        int check = 0;
        String sql = "INSERT INTO floor(room_name, roomtype_id,floor_id, apartment_id)"
                + " VALUES(?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getRoomName());
            ps.setObject(2, obj.getRoomtypeId());
            ps.setObject(3, obj.getFloorId());
            ps.setObject(4, obj.getApartmentId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean updateRooms(List<Room> list) {
        String query = "UPDATE floor Set room_name = ?,roomtype_id = ?, floor_id = ?, apartment_id = ?, room_status = ? WHERE room_id = ?";
        int[] arr = {};
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (Room obj : list) {
                    ps.setObject(1, obj.getRoomName());
                    ps.setObject(2, obj.getRoomtypeId());
                    ps.setObject(3, obj.getFloorId());
                    ps.setObject(4, obj.getApartmentId());
                    ps.setObject(5, obj.getRoomStatus());
                    ps.setObject(6, obj.getRoomId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public boolean delete(int roomId, int floorId) {
        int check = 0;
        String sql = "DELETE FROM floor Where room_id = ? AND floor_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ps.setObject(2, floorId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
