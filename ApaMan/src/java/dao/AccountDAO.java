/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import constant.IConst;
import entity.Account;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Cypher;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    public Account authenticate(String username, int apartmentId) {
        String query = "Select * FROM apamandb.`account` WHERE account_username = ? AND apartment_id = ? AND account_accessible = true AND deleted = false";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, username);
                ps.setObject(2, apartmentId);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    Account obj = Account.builder()
                            .accountId(rs.getInt("account_id"))
                            .apartmentId(rs.getInt("apartment_id"))
                            .accountUsername(rs.getString("account_username"))
                            .build();
                    return obj;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Account login(String username, String password, int apartmemtId) {
        String query = "SELECT \n"
                + "	a.account_id,\n"
                + "	a.apartment_id,\n"
                + "	a.account_username,\n"
                + "	a.account_password,\n"
                + "	r.role_name\n"
                + "FROM apamandb.`account` a join `role` r ON a.role_id = r.role_id\n"
                + "Where 	a.account_username = ? AND \n"
                + "		a.account_password = ? AND \n"
                + "        ((a.account_accessible = true AND deleted = false AND a.apartment_id = ? And (SELECT account_accessible FROM `account` WHERE apartment_id = ? AND role_id = 2) = true) OR a.apartment_id = 0);";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, username);
                ps.setObject(2, password);
                ps.setObject(3, apartmemtId);
                ps.setObject(4, apartmemtId);
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

    public boolean resetPassword(String username, String password, int apartmentId) {
        int check = 0;
        String sql = "UPDATE apamandb.`account` SET account_password = ? WHERE account_username = ? And apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, password);
            ps.setObject(2, username);
            ps.setObject(3, apartmentId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public int add(Account obj) {
        int check = 0;
        String sql = "INSERT INTO `account`(apartment_id, account_username, account_password, account_accessible, role_id, deleted)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getAccountUsername());
            ps.setObject(3, Cypher.encryptData(obj.getAccountPassword(), IConst.SHIFT_KEY));
            ps.setObject(4, obj.isAccountAccessible());
            ps.setObject(5, obj.getRole().getRoleId());
            ps.setObject(6, 0);
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

    public Account getOne(int accountId) {
        String sql
                = "SELECT \n"
                + "a.account_id,\n"
                + "a.apartment_id,\n"
                + "a.account_username,\n"
                + "a.account_password,\n"
                + "a.account_accessible,\n"
                + "a.role_id,\n"
                + "r.role_name\n"
                + "FROM apamandb.`account` a JOIN `role` r ON a.role_id = r.role_id\n"
                + "WHERE deleted = false AND a.account_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, accountId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account obj = Account.builder()
                        .accountId(rs.getInt("account_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .accountUsername(rs.getString("account_username"))
                        .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                        .accountAccessible(rs.getBoolean("account_accessible"))
                        .role(Role.builder()
                                .roleId(rs.getInt("role_id"))
                                .roleName(rs.getString("role_name"))
                                .build()
                        )
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Account obj, int accountId) {
        int check = 0;
        String sql = "UPDATE apamandb.`account` SET apartment_id = ?, account_username = ?, account_password = ?, account_accessible = ?, role_id = ? WHERE account_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getApartmentId());
            ps.setObject(2, obj.getAccountUsername());
            ps.setObject(3, Cypher.encryptData(obj.getAccountPassword(), IConst.SHIFT_KEY));
            ps.setObject(4, obj.isAccountAccessible());
            ps.setObject(5, obj.getRole().getRoleId());
            ps.setObject(6, accountId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(int accountId) {
        int check = 0;
        String sql = "UPDATE `account` SET deleted = 1 WHERE account_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, accountId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String getAccountUsername(int apartmentId, int roleId) {
        String sql
                = "SELECT * FROM apamandb.account Where apartment_id = ? AND role_id = ? ORDER BY account_id DESC LIMIT 1;";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ps.setObject(2, roleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String obj = rs.getString("account_username");
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Account> getAllHostAccount() {

        String sql = "SELECT * FROM account where role_id = 2";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Account> list = new ArrayList<>();//
            while (rs.next()) {
                Account obj = Account.builder()
                        .accountId(rs.getInt("account_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .accountUsername(rs.getString("account_username"))
                        .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                        .accountAccessible(rs.getBoolean("account_accessible"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean delete(List<Account> list) {
        int[] arr = {};
        String sql = "DELETE FROM account Where account_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if (ps != null) {
                for (Account obj : list) {
                    ps.setObject(1, obj.getAccountId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

}
