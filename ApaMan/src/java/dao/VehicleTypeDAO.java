/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.VehicleType;
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
public class VehicleTypeDAO {
    
    public List<VehicleType> getAll() {

        String sql = "SELECT fee_key, fee_value FROM fee WHERE fee_type = 'FEE_VEHICAL'";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<VehicleType> list = new ArrayList<>();//
            while (rs.next()) {
                VehicleType obj = VehicleType.builder()
                        .vehicleTypeId(rs.getInt("fee_key"))
                        .vehicleTypeName(rs.getString("fee_value"))
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
