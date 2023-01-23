/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import constant.IConst;
import entity.Account;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Cypher;

/**
 *
 * @author DELL
 */
public class StaffDAO {

    public List<Staff> getAll(int apartmentId) {

        String sql = "SELECT \n"
                + "staff.staff_id, \n"
                + "staff.account_id, \n"
                + "staff.staff_name, \n"
                + "staff.staff_citizen_identification, \n"
                + "staff.staff_dob, \n"
                + "staff.staff_phone_number, \n"
                + "staff.staff_countryside,\n"
                + "staff.staff_job,\n"
                + "staff.staff_salary,\n"
                + "`account`.apartment_id,\n"
                + "`account`.account_username,\n"
                + "`account`.account_password,\n"
                + "`account`.account_accessible,\n"
                + "`account`.role_id\n"
                + "FROM staff Join `account` ON staff.account_id = `account`.account_id\n"
                + "Where `account`.apartment_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Staff> list = new ArrayList<>();//
            while (rs.next()) {
                Staff obj = Staff.builder()
                        .staffId(rs.getInt("staff_id"))
                        .account(Account.builder()
                                .accountId(rs.getInt("account_id"))
                                .apartmentId(rs.getInt("apartment_id"))
                                .accountUsername(rs.getString("account_username"))
                                .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                                .accountAccessible(rs.getBoolean("account_accessible"))
                                .build())
                        .staffName(rs.getString("staff_name"))
                        .staffCitizenIdentification(rs.getString("staff_citizen_identification"))
                        .staffDob(rs.getString("staff_dob"))
                        .staffPhoneNumber(rs.getString("staff_phone_number"))
                        .staffCountryside(rs.getString("staff_countryside"))
                        .staffJob(rs.getString("staff_job"))
                        .staffSalary(rs.getString("staff_salary"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Staff getOne(int staffId) {
        String sql = "SELECT \n"
                + "staff.staff_id, \n"
                + "staff.account_id, \n"
                + "staff.staff_name, \n"
                + "staff.staff_citizen_identification, \n"
                + "staff.staff_dob, \n"
                + "staff.staff_phone_number, \n"
                + "staff.staff_countryside,\n"
                + "staff.staff_job,\n"
                + "staff.staff_salary,\n"
                + "`account`.apartment_id,\n"
                + "`account`.account_username,\n"
                + "`account`.account_password,\n"
                + "`account`.account_accessible,\n"
                + "`account`.role_id\n"
                + "FROM staff Join `account` ON staff.account_id = `account`.account_id\n"
                + "Where staff.staff_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, staffId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Staff obj = Staff.builder()
                        .staffId(rs.getInt("staff_id"))
                        .account(Account.builder()
                                .accountId(rs.getInt("account_id"))
                                .apartmentId(rs.getInt("apartment_id"))
                                .accountUsername(rs.getString("account_username"))
                                .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                                .accountAccessible(rs.getBoolean("account_accessible"))
                                .build())
                        .staffName(rs.getString("staff_name"))
                        .staffCitizenIdentification(rs.getString("staff_citizen_identification"))
                        .staffDob(rs.getString("staff_dob"))
                        .staffPhoneNumber(rs.getString("staff_phone_number"))
                        .staffCountryside(rs.getString("staff_countryside"))
                        .staffJob(rs.getString("staff_job"))
                        .staffSalary(rs.getString("staff_salary"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean update(Staff obj, int staffId) {
        int check = 0;
        String sql = "UPDATE staff SET\n"
                + "staff_citizen_identification = ?,\n"
                + "staff_name = ?,\n"
                + "staff_dob = ?,\n"
                + "staff_phone_number = ?,\n"
                + "staff_countryside = ?,\n"
                + "staff_job = ?,\n"
                + "staff_salary = ?\n"
                + "WHERE staff_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getStaffCitizenIdentification());
            ps.setObject(2, obj.getStaffName());
            ps.setObject(3, obj.getStaffDob());
            ps.setObject(4, obj.getStaffPhoneNumber());
            ps.setObject(5, obj.getStaffCountryside());
            ps.setObject(6, obj.getStaffJob());
            ps.setObject(7, obj.getStaffSalary());
            ps.setObject(8, obj.getStaffId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new StaffDAO().getOne(1));
    }
}
