
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Apartment;
import entity.ApartmentImgBanner;
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
public class ApartmentImgBannerDAO {

    public List<ApartmentImgBanner> getAll(int apartmentId) { //20Loc
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
    
    public ApartmentImgBanner getOne(int apartmentImgBannerId) { //17LOC
        String sql = "SELECT * FROM apartment_img_banner WHERE apartment_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentImgBannerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ApartmentImgBanner obj = ApartmentImgBanner.builder()
                        .apartmentImgBannerId(rs.getInt("apartment_img_banner_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .apartmentImgBannerPath(rs.getString("apartment_img_banner_path"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public int add(ApartmentImgBanner obj) { //11 loc
        int check = 0;
        String sql = "INSERT INTO apartment_img_banner(apartment_id, apartment_img_banner_path)"
                + " VALUES(?, ?)";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getApartmentImgBannerPath());
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
    
     public boolean update(ApartmentImgBanner obj, int apartmentImgBannerId) { //13Loc
        int check = 0;
        String sql = "UPDATE apartment_img_banner SET "
                + "apartment_img_banner_path = ? "
                + "WHERE apartment_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getApartmentImgBannerPath());
            ps.setObject(2, apartmentImgBannerId);
            
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     
     public boolean delete(int apartmentImgBannerId) {//9 loc
        int check = 0;
        String sql = "DELETE FROM apartment_img_banner WHERE apartment_img_banner_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentImgBannerId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
     public static void main(String[] args) {
         System.out.println(new ApartmentImgBannerDAO().getOne(5));
    }
}

