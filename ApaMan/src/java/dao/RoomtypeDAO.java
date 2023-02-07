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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomtypeDAO {
    
        public List<Roomtype> getAll(int apartmentId) {

        String sql = "SELECT * FROM roomtype WHERE apartment_id = ?";//

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
}
