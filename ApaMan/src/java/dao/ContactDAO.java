/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Contact;
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
public class ContactDAO {

    public List<Contact> getAll(int apartmentId) {

        String sql = "SELECT * FROM contact WHERE apartment_id = ? ORDER BY contact_id DESC";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Contact> list = new ArrayList<>();//
            while (rs.next()) {
                Contact obj = Contact.builder()
                        .contactId(rs.getInt("contact_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .contactName(rs.getString("contact_name"))
                        .contactEmail(rs.getString("contact_email"))
                        .contactPhone(rs.getString("contact_phone"))
                        .contactMessage(rs.getString("contact_message"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(Contact obj) {
        int check = 0;
        String sql = "INSERT INTO contact(apartment_id, contact_name, contact_email , contact_phone ,contact_message)"
                + " VALUES(?, ?, ? ,?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getContactName());
            ps.setObject(3, obj.getContactEmail());
            ps.setObject(4, obj.getContactPhone());
            ps.setObject(5, obj.getContactMessage());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    
}
