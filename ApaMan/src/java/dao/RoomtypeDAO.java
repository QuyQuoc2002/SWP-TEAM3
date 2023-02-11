/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Roomtype;
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
public class RoomtypeDAO {

    public List<Roomtype> getAll(int apartmentId) {

        String sql = "SELECT * FROM roomtype WHERE apartment_id = ? ORDER BY roomtype_name";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Roomtype> list = new ArrayList<>();//
            while (rs.next()) {
                Roomtype obj = Roomtype.builder()
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomtypeName(rs.getString("roomtype_name"))
                        .roomtypeMaxMember(rs.getInt("roomtype_max_member"))
                        .roomtypeCost(rs.getInt("roomtype_cost"))
                        .roomtypeArea(rs.getString("roomtype_area"))
                        .roomtypeRoomQuantity(rs.getInt("roomtype_room_quantity"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Roomtype getOne(int roomtypeId,int apartmentId) {

        String sql = "SELECT * FROM roomtype WHERE roomtype_id = ? AND apartment_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Roomtype obj = Roomtype.builder()
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomtypeName(rs.getString("roomtype_name"))
                        .roomtypeMaxMember(rs.getInt("roomtype_max_member"))
                        .roomtypeCost(rs.getInt("roomtype_cost"))
                        .roomtypeArea(rs.getString("roomtype_area"))
                        .roomtypeRoomQuantity(rs.getInt("roomtype_room_quantity"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public int add(Roomtype obj) {
        int check = 0;
        String sql = "INSERT INTO roomtype(apartment_id, roomtype_name, roomtype_max_member, roomtype_cost, roomtype_area, roomtype_room_quantity)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getRoomtypeName());
            ps.setObject(3, obj.getRoomtypeMaxMember());
            ps.setObject(4, obj.getRoomtypeCost());
            ps.setObject(5, obj.getRoomtypeArea());
            ps.setObject(6, obj.getRoomtypeRoomQuantity());
            check = ps.executeUpdate();
            if (check > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public boolean updateRoomtype(Roomtype obj) {
        int check = 0;
        String query = "UPDATE roomtype Set roomtype_name = ?, roomtype_max_member = ?, roomtype_cost = ?, roomtype_area = ? WHERE roomtype_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {

            ps.setObject(1, obj.getRoomtypeName());
            ps.setObject(2, obj.getRoomtypeMaxMember());
            ps.setObject(3, obj.getRoomtypeCost());
            ps.setObject(4, obj.getRoomtypeArea());
            ps.setObject(5, obj.getRoomtypeId());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public boolean delete(int roomtypeId, int apartmentId) {
        int check = 0;
        String sql = "DELETE FROM roomtype Where roomtype_id = ? AND apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomtypeId);
            ps.setObject(2, apartmentId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
