/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Fee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class FeeDAO {
    
    public List<Fee> getAll() {

        String sql = "SELECT * FROM fee";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Fee> list = new ArrayList<>();//
            while (rs.next()) {
                Fee obj = Fee.builder()
                        .feeId(rs.getInt("fee_id"))
                        .feeType(rs.getString("fee_type"))
                        .feeKey(rs.getInt("fee_key"))
                        .feeValue(rs.getString("fee_value"))
                        .feeCost(rs.getInt("fee_cost"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    
    public int getValue(int feeId) {
        int value;
        String sql = "SELECT * FROM fee where fee_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, feeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                value = rs.getInt("fee_cost");
                return value;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }
    
}
