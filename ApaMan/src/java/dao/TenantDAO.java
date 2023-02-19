/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import constant.IConst;
import entity.Account;
import entity.Room;
import entity.Tenant;
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
public class TenantDAO {
    
    public int numberOfTenants (int apartmentId) {
        int numberOfTenants;
        String sql = "SELECT COUNT(tenant_id) AS numberOfTenants \n" +
                     "FROM apamandb.tenant t Join apamandb.account a ON t.account_id = a.account_id\n" +
                     "Where a.apartment_id = ? AND a.account_accessible = true;";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfTenants = rs.getInt("numberOfTenants");
                return numberOfTenants;
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public List<Tenant> getAll(int apartmentId) {

        String sql = "with te as(\n"
                + "SELECT t.tenant_id, "
                + "t.account_id, "
                + "t.room_id, "
                + "t.tenant_citizen_identification, "
                + "t.tenant_name, "
                + "t.tenant_dob, "
                + "t.tenant_phone_number, "
                + "t.tenant_parent_phone, "
                + "t.tenant_countryside, "
                + "a.apartment_id,"
                + "a.account_username,"
                + "a.account_password,"
                + "a.account_accessible,"
                + "a.role_id\n"
                + "FROM apamandb.tenant t Join apamandb.account a ON t.account_id = a.account_id  \n"
                + "Where a.apartment_id = ? AND a.account_accessible = true) \n"
                + "\n"
                + "select te.* , r.room_name\n"
                + "FROM te JOIN apamandb.room r on te.room_id = r.room_id";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Tenant> list = new ArrayList<>();//
            while (rs.next()) {
                Tenant obj = Tenant.builder()
                        .tenantId(rs.getInt("tenant_id"))
                        .account(Account.builder()
                                .accountId(rs.getInt("account_id"))
                                .apartmentId(rs.getInt("apartment_id"))
                                .accountUsername(rs.getString("account_username"))
                                .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                                .accountAccessible(rs.getBoolean("account_accessible"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .roomName(rs.getString("room_name"))
                                .build())
                        .tenantCitizenIdentification(rs.getString("tenant_citizen_identification"))
                        .tenantName(rs.getString("tenant_name"))
                        .tenantDob(rs.getString("tenant_dob"))
                        .tenantPhoneNumber(rs.getString("tenant_phone_number"))
                        .tenantParentPhone(rs.getString("tenant_parent_phone"))
                        .tenantCountryside(rs.getString("tenant_countryside"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Tenant> getAll(int roomId, int apartmentId) {

        String sql = "with te as(\n"
                + "SELECT t.tenant_id, "
                + "t.account_id, "
                + "t.room_id, "
                + "t.tenant_citizen_identification, "
                + "t.tenant_name, "
                + "t.tenant_dob, "
                + "t.tenant_phone_number, "
                + "t.tenant_parent_phone, "
                + "t.tenant_countryside, "
                + "a.apartment_id,"
                + "a.account_username,"
                + "a.account_password,"
                + "a.account_accessible,"
                + "a.role_id\n"
                + "FROM apamandb.tenant t Join apamandb.account a ON t.account_id = a.account_id  \n"
                + "Where t.room_id = ? AND a.apartment_id = ?) \n"
                + "\n"
                + "select te.* , r.room_name\n"
                + "FROM te JOIN apamandb.room r on te.room_id = r.room_id";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Tenant> list = new ArrayList<>();//
            while (rs.next()) {
                Tenant obj = Tenant.builder()
                        .tenantId(rs.getInt("tenant_id"))
                        .account(Account.builder()
                                .accountId(rs.getInt("account_id"))
                                .apartmentId(rs.getInt("apartment_id"))
                                .accountUsername(rs.getString("account_username"))
                                .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                                .accountAccessible(rs.getBoolean("account_accessible"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .roomName(rs.getString("room_name"))
                                .build())
                        .tenantCitizenIdentification(rs.getString("tenant_citizen_identification"))
                        .tenantName(rs.getString("tenant_name"))
                        .tenantDob(rs.getString("tenant_dob"))
                        .tenantPhoneNumber(rs.getString("tenant_phone_number"))
                        .tenantParentPhone(rs.getString("tenant_parent_phone"))
                        .tenantCountryside(rs.getString("tenant_countryside"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(List<Tenant> list) {
        int[] arr = {};
        String sql = "INSERT INTO tenant(account_id, room_id,tenant_citizen_identification, tenant_name, tenant_dob, tenant_phone_number,tenant_parent_phone,tenant_countryside)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if (ps != null) {
                for (Tenant obj : list) {
                    ps.setObject(1, obj.getAccount().getAccountId());
                    ps.setObject(2, obj.getRoom().getRoomId());
                    ps.setObject(3, obj.getTenantCitizenIdentification());
                    ps.setObject(4, obj.getTenantName());
                    ps.setObject(5, obj.getTenantDob());
                    ps.setObject(6, obj.getTenantPhoneNumber());
                    ps.setObject(7, obj.getTenantParentPhone());
                    ps.setObject(8, obj.getTenantCountryside());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public Tenant getOne(int tenantId) {
        String sql = "with te as(\n"
                + "SELECT t.tenant_id, "
                + "t.account_id, "
                + "t.room_id, "
                + "t.tenant_citizen_identification, "
                + "t.tenant_name, "
                + "t.tenant_dob, "
                + "t.tenant_phone_number, "
                + "t.tenant_parent_phone, "
                + "t.tenant_countryside, "
                + "a.apartment_id,"
                + "a.account_username,"
                + "a.account_password,"
                + "a.account_accessible,"
                + "a.role_id\n"
                + "FROM apamandb.tenant t Join apamandb.account a ON t.account_id = a.account_id  \n"
                + "Where t.tenant_id = ?) \n"
                + "\n"
                + "select te.* , r.room_name\n"
                + "FROM te JOIN apamandb.room r on te.room_id = r.room_id";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, tenantId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tenant obj = Tenant.builder()
                        .tenantId(rs.getInt("tenant_id"))
                        .account(Account.builder()
                                .accountId(rs.getInt("account_id"))
                                .apartmentId(rs.getInt("apartment_id"))
                                .accountUsername(rs.getString("account_username"))
                                .accountPassword(Cypher.decryptData(rs.getString("account_password"), IConst.SHIFT_KEY))
                                .accountAccessible(rs.getBoolean("account_accessible"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .roomName(rs.getString("room_name"))
                                .build())
                        .tenantCitizenIdentification(rs.getString("tenant_citizen_identification"))
                        .tenantName(rs.getString("tenant_name"))
                        .tenantDob(rs.getString("tenant_dob"))
                        .tenantPhoneNumber(rs.getString("tenant_phone_number"))
                        .tenantParentPhone(rs.getString("tenant_parent_phone"))
                        .tenantCountryside(rs.getString("tenant_countryside"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Tenant obj, int tenantId) {
        int check = 0;
        String sql = "UPDATE tenant SET\n"
                + "tenant_citizen_identification = ?, "
                + "tenant_name = ?, "
                + "tenant_dob = ?, "
                + "tenant_phone_number = ?, "
                + "tenant_parent_phone = ?, "
                + "tenant_countryside = ?"
                + "WHERE tenant_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getTenantCitizenIdentification());
            ps.setObject(2, obj.getTenantName());
            ps.setObject(3, obj.getTenantDob());
            ps.setObject(4, obj.getTenantPhoneNumber());
            ps.setObject(5, obj.getTenantParentPhone());
            ps.setObject(6, obj.getTenantCountryside());
            ps.setObject(7, tenantId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(int tenantId) {
        int check = 0;
        String sql = "DELETE FROM tenant Where tenant_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, tenantId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(List<Tenant> list) {
        int[] arr = {};
        String sql = "DELETE FROM tenant Where tenant_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            if (ps != null) {
                for (Tenant obj : list) {
                    ps.setObject(1, obj.getTenantId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public static void main(String[] args) {
        System.out.println(new TenantDAO().getOne(1));
    }
}
