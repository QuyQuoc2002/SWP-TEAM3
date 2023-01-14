/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Apartment;
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
public class ApartmentDAO {

    public List<Apartment> getAll(int districtId) {
        
        String sql = "SELECT * FROM apartment Where apartment_accessible = true";
        sql += districtId != 0 ? " AND district_id = ?" : ""; // Query search by district Id

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if(districtId != 0) {ps.setObject(1, districtId);}
            ResultSet rs = ps.executeQuery();
            List<Apartment> list = new ArrayList<>();//
            while (rs.next()) {
                Apartment obj = Apartment.builder()
                        .apartmentId(rs.getInt("apartment_id"))
                        .apartmentName(rs.getString("apartment_name"))
                        .districId(rs.getInt("district_id"))
                        .apartmentAddress(rs.getString("apartment_address"))
                        .apartmentIntro(rs.getString("apartment_intro"))
                        .apartmentLat(rs.getDouble("apartment_lat"))
                        .apartmentLon(rs.getDouble("apartment_lon"))
                        .apartmentImgAboutus(rs.getString("apartment_img_aboutus"))
                        .apartmentContentAboutus(rs.getString("apartment_content_aboutus"))
                        .apartmentContentService(rs.getString("apartment_content_service"))
                        .apartmentContentRecuitment(rs.getString("apartment_content_recruitment"))
                        .apartmentAccessible(rs.getBoolean("apartment_accessible"))
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
