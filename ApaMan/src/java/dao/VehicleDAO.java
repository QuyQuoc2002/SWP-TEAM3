/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Room;
import entity.Tenant;
import entity.Vehicle;
import entity.VehicleType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class VehicleDAO {

    public List<Vehicle> getAll(int apartmentId) {

        String sql = "SELECT vehicle.vehicle_id, "
                + "vehicle.vehicle_type_id, "
                + "vehicle.vehicle_license_plate, "
                + "vehicle.vehicle_description, "
                + "vehicle.tenant_id, "
                + "vehicle.room_id, "
                + "vehicle.apartment_id, "
                + "vehicle.vehicle_img_path, "
                + "fee.fee_value \n"
                + "FROM apamandb.vehicle Join apamandb.fee ON vehicle.vehicle_type_id = fee.fee_key AND fee.fee_type = 'FEE_VEHICLE' \n"
                + "Where vehicle.apartment_id = ? ";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Vehicle> list = new ArrayList<>();//
            while (rs.next()) {
                Vehicle obj = Vehicle.builder()
                        .vehicleId(rs.getInt("vehicle_id"))
                        .vehicleType(VehicleType.builder()
                                .vehicleTypeId(rs.getInt("vehicle_type_id"))
                                .vehicleTypeName(rs.getString("fee_value"))
                                .build())
                        .tenant(Tenant.builder()
                                .tenantId(rs.getInt("tenant_id"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .build())
                        .apartmentId(rs.getInt("apartment_id"))
                        .vehicleLicensePlate(rs.getString("vehicle_license_plate"))
                        .vehicleDescription(rs.getString("vehicle_description"))
                        .vehicleImgPath(rs.getString("vehicle_img_path"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Vehicle> getAll(int tenantId ,int apartmentId) {

        String sql = "SELECT vehicle.vehicle_id, "
                + "vehicle.vehicle_type_id, "
                + "vehicle.vehicle_license_plate, "
                + "vehicle.vehicle_description, "
                + "vehicle.tenant_id, "
                + "vehicle.room_id, "
                + "vehicle.apartment_id, "
                + "vehicle.vehicle_img_path, "
                + "fee.fee_value \n"
                + "FROM apamandb.vehicle Join apamandb.fee ON vehicle.vehicle_type_id = fee.fee_key AND fee.fee_type = 'FEE_VEHICLE' \n"
                + "Where vehicle.tenant_id = ? And vehicle.apartment_id = ? ";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, tenantId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Vehicle> list = new ArrayList<>();//
            while (rs.next()) {
                Vehicle obj = Vehicle.builder()
                        .vehicleId(rs.getInt("vehicle_id"))
                        .vehicleType(VehicleType.builder()
                                .vehicleTypeId(rs.getInt("vehicle_type_id"))
                                .vehicleTypeName(rs.getString("fee_value"))
                                .build())
                        .tenant(Tenant.builder()
                                .tenantId(rs.getInt("tenant_id"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .build())
                        .apartmentId(rs.getInt("apartment_id"))
                        .vehicleLicensePlate(rs.getString("vehicle_license_plate"))
                        .vehicleDescription(rs.getString("vehicle_description"))
                        .vehicleImgPath(rs.getString("vehicle_img_path"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Vehicle getOne(int vehicleId) {
        String sql = "SELECT vehicle.vehicle_id, "
                + "vehicle.vehicle_type_id, "
                + "vehicle.vehicle_license_plate, "
                + "vehicle.vehicle_description, "
                + "vehicle.tenant_id, "
                + "vehicle.room_id, "
                + "vehicle.apartment_id, "
                + "vehicle.vehicle_img_path, "
                + "fee.fee_value \n"
                + "FROM apamandb.vehicle Join apamandb.fee ON vehicle.vehicle_type_id = fee.fee_key AND fee.fee_type = 'FEE_VEHICLE' \n"
                + "Where vehicle.vehicle_id = ? ";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle obj = Vehicle.builder()
                        .vehicleId(rs.getInt("vehicle_id"))
                        .vehicleType(VehicleType.builder()
                                .vehicleTypeId(rs.getInt("vehicle_type_id"))
                                .vehicleTypeName(rs.getString("fee_value"))
                                .build())
                        .tenant(Tenant.builder()
                                .tenantId(rs.getInt("tenant_id"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .build())
                        .apartmentId(rs.getInt("apartment_id"))
                        .vehicleLicensePlate(rs.getString("vehicle_license_plate"))
                        .vehicleDescription(rs.getString("vehicle_description"))
                        .vehicleImgPath(rs.getString("vehicle_img_path"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public int add(Vehicle obj) {
        int check = 0;
        String sql = "INSERT INTO vehicle(vehicle_type_id, vehicle_license_plate, vehicle_description,tenant_id,room_id,apartment_id,vehicle_img_path)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getVehicleType().getVehicleTypeId());
            ps.setObject(2, obj.getVehicleLicensePlate());
            ps.setObject(3, obj.getVehicleDescription());
            ps.setObject(4, obj.getTenant().getTenantId());
            ps.setObject(5, obj.getRoom().getRoomId());
            ps.setObject(6, obj.getApartmentId());
            ps.setObject(7, obj.getVehicleImgPath());
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

    public boolean update(Vehicle obj, int vehicleId) {
        int check = 0;
        String query = "UPDATE vehicle Set vehicle_type_id = ?, "
                + "vehicle_license_plate = ? , "
                + "vehicle_description = ? ,"
                + "tenant_id = ? ,"
                + "room_id = ? ,"
                + "apartment_id = ?,"
                + "vehicle_img_path = ?"
                + "WHERE vehicle_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {

            ps.setObject(1, obj.getVehicleType().getVehicleTypeId());
            ps.setObject(2, obj.getVehicleLicensePlate());
            ps.setObject(3, obj.getVehicleDescription());
            ps.setObject(4, obj.getTenant().getTenantId());
            ps.setObject(5, obj.getRoom().getRoomId());
            ps.setObject(6, obj.getApartmentId());
            ps.setObject(7, obj.getVehicleImgPath());
            ps.setObject(8, vehicleId);
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public boolean delete(int vehicleId, int apartmentId) {
        int check = 0;
        String sql = "DELETE FROM vehicle Where vehicle_id = ? AND apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, vehicleId);
            ps.setObject(2, apartmentId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new VehicleDAO().delete(22, 1));
    }
}
