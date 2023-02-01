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
                        .floorName(rs.getString("floor_name"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new FloorDAO().getAll(1));
    }
}
