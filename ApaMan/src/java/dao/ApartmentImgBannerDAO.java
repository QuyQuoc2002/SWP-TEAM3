
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.ApartmentImgBanner;
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
public class ApartmentImgBannerDAO {

    public List<ApartmentImgBanner> getAll(int apartmentId) {

        String sql = "SELECT * FROM apartment_img_banner Where apartment_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<ApartmentImgBanner> list = new ArrayList<>();//
            while (rs.next()) {
                ApartmentImgBanner obj = ApartmentImgBanner.builder()
                        .apartmentImgBannerId(rs.getInt("apartment_img_banner_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .apartmentImgBannerPath(rs.getString("apartment_img_banner_path"))
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
