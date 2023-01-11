/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Account;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    public Account login(String username, String password, int apartmemtId) {
        String query = "SELECT a.account_id, a.apartment_id, a.account_username, a.account_password, r.role_name FROM apamandb.`account` a join `role` r ON a.role_id = r.role_id\n"
                + "Where a.account_username = ? AND a.account_password = ? AND a.account_accessible = true AND (a.apartment_id = 0 OR a.apartment_id = ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, username);
                ps.setObject(2, password);
                ps.setObject(3, apartmemtId);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    Account obj = Account.builder()
                            .accountId(rs.getInt("account_id"))
                            .apartmentId(rs.getInt("apartment_id"))
                            .accountUsername(rs.getString("account_username"))
                            .accountPassword(rs.getString("account_password"))
                            .role(Role.builder().roleName(rs.getString("role_name")).build())
                            .build();
                    return obj;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new AccountDAO().login("admin","admin", 0));
    }
}
