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

    public List<Apartment> getAll(int districtId) { //31 LOC

        String sql = "SELECT * FROM apartment Where apartment_accessible = true";
        sql += districtId != 0 ? " AND district_id = ?" : ""; // Query search by district Id

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if (districtId != 0) {
                ps.setObject(1, districtId);
            }
            ResultSet rs = ps.executeQuery();
            List<Apartment> list = new ArrayList<>();//
            while (rs.next()) {
                Apartment obj = Apartment.builder()
                        .apartmentId(rs.getInt("apartment_id"))
                        .apartmentName(rs.getString("apartment_name"))
                        .districId(rs.getInt("district_id"))
                        .apartmentAddress(rs.getString("apartment_address"))
                        .apartmentIntro(rs.getString("apartment_intro"))
                        .apartmentLat(rs.getString("apartment_lat"))
                        .apartmentLon(rs.getString("apartment_lon"))
                        .apartmentImgAboutus(rs.getString("apartment_img_aboutus"))
                        .apartmentContentAboutus(rs.getString("apartment_content_aboutus"))
                        .apartmentContentService(rs.getString("apartment_content_service"))
                        .apartmentContentRecruitment(rs.getString("apartment_content_recruitment"))
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

    public Apartment getOne(int apartmentId) { //27LOC
        String sql = "SELECT * FROM apartment WHERE apartment_accessible = true AND  apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Apartment obj = Apartment.builder()
                        .apartmentId(rs.getInt("apartment_id"))
                        .apartmentName(rs.getString("apartment_name"))
                        .districId(rs.getInt("district_id"))
                        .apartmentAddress(rs.getString("apartment_address"))
                        .apartmentIntro(rs.getString("apartment_intro"))
                        .apartmentLat(rs.getString("apartment_lat"))
                        .apartmentLon(rs.getString("apartment_lon"))
                        .apartmentImgAboutus(rs.getString("apartment_img_aboutus"))
                        .apartmentContentAboutus(rs.getString("apartment_content_aboutus"))
                        .apartmentContentService(rs.getString("apartment_content_service"))
                        .apartmentContentRecruitment(rs.getString("apartment_content_recruitment"))
                        .apartmentAccessible(rs.getBoolean("apartment_accessible"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean update(Apartment obj, int apartmentId) { //32Loc
        int check = 0;
        String sql = "UPDATE Apartment SET "
                + "apartment_name = ?, "
                + "district_id = ?, "
                + "apartment_address = ?, "
                + "apartment_intro = ?, "
                + "apartment_lat = ?, "
                + "apartment_lon = ?, "
                + "apartment_img_aboutus = ?, "
                + "apartment_content_aboutus = ?, "
                + "apartment_content_service = ?, "
                + "apartment_content_recruitment = ? "
                + "WHERE apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getApartmentName());
            ps.setObject(2, obj.getDistricId());
            ps.setObject(3, obj.getApartmentAddress());
            ps.setObject(4, obj.getApartmentIntro());
            ps.setObject(5, obj.getApartmentLat());
            ps.setObject(6, obj.getApartmentLon());
            ps.setObject(7, obj.getApartmentImgAboutus());
            ps.setObject(8, obj.getApartmentContentAboutus());
            ps.setObject(9, obj.getApartmentContentService());
            ps.setObject(10, obj.getApartmentContentRecruitment());
            ps.setObject(11, apartmentId);
            
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
