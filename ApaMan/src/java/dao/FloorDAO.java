/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Floor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class FloorDAO {

    public List<Floor> getAll(int apartmentId) {

        String sql = "SELECT * FROM floor WHERE apartment_id = ? ORDER BY floor_name ASC";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Floor> list = new ArrayList<>();//
            while (rs.next()) {
                Floor obj = Floor.builder()
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .floorName(rs.getInt("floor_name"))
                        .floorRoomQuantity(rs.getInt("floor_room_quantity"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Floor getOne(int floorId) {
        String sql = "SELECT * FROM floor WHERE floor_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, floorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Floor obj = Floor.builder()
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .floorName(rs.getInt("floor_name"))
                        .floorRoomQuantity(rs.getInt("floor_room_quantity"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Floor obj) {
        int check = 0;
        String sql = "INSERT INTO floor(apartment_id, floor_name, floor_room_quantity)"
                + " VALUES(?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getFloorName());
            ps.setObject(3, obj.getFloorRoomQuantity());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateFloors(List<Floor> list) {
        String query = "UPDATE floor Set floor_name = ? WHERE floor_id = ?";
        int[] arr = {};
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (Floor obj : list) {
                    ps.setObject(1, obj.getFloorName());
                    ps.setObject(2, obj.getFloorId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }
    
    public boolean updateFloor(Floor obj) {
        int check = 0;
        String query = "UPDATE floor Set floor_name = ?, floor_room_quantity = ? WHERE floor_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {

            ps.setObject(1, obj.getFloorName());
            ps.setObject(2, obj.getFloorRoomQuantity());
            ps.setObject(3, obj.getFloorId());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public boolean delete(int floorId, int apartmentId) {
        int check = 0;
        String sql = "DELETE FROM floor Where floor_id = ? AND apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, floorId);
            ps.setObject(2, apartmentId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
