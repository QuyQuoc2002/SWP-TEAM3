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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class VehicleDAO {

    public List<Vehicle> getAll(int apartmentId) {

        String sql = "SELECT v.vehicle_id, "
                + "v.vehicle_type_id, "
                + "v.vehicle_licensea_plate, "
                + "v.vehicle_description, "
                + "v.tenant_id, "
                + "v.room_id, "
                + "v.apartment_id, "
                + "vt.vehicle_type_name \n"
                + "FROM apamandb.vehicle v Join apamandb.vehicle_type vt ON v.vehicle_type_id = vt.vehicle_type_id  \n"
                + "Where v.apartment_id = ? ";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Vehicle> list = new ArrayList<>();//
            while (rs.next()) {
                Vehicle obj = Vehicle.builder()
                        .vehicleId(rs.getInt("vehicle_id"))
                        .vehicleType(VehicleType.builder()
                                .vehicleTypeId(rs.getInt("vehicle_type_id"))
                                .vehicleTypeName(rs.getString("vehicle_type_name"))
                                .build())
                        .tenant(Tenant.builder()
                                .tenantId(rs.getInt("tenant_id"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .build())
                        .apartmentId(rs.getInt("apartment_id"))
                        .vehicleLicenseaPlate(rs.getString("vehicle_licensea_plate"))
                        .vehicleDescription(rs.getString("vehicle_description"))
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
        String sql = "SELECT * FROM vehicle WHERE vehicle_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vehicle obj = Vehicle.builder()
                        .vehicleId(rs.getInt("vehicle_id"))
                        .vehicleType(VehicleType.builder()
                                .vehicleTypeId(rs.getInt("vehicle_type_id"))
                                .vehicleTypeName(rs.getString("vehicle_type_name"))
                                .build())
                        .tenant(Tenant.builder()
                                .tenantId(rs.getInt("tenant_id"))
                                .build())
                        .room(Room.builder()
                                .roomId(rs.getInt("room_id"))
                                .build())
                        .apartmentId(rs.getInt("apartment_id"))
                        .vehicleLicenseaPlate(rs.getString("vehicle_licensea_plate"))
                        .vehicleDescription(rs.getString("vehicle_description"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Vehicle obj) {
        int check = 0;
        String sql = "INSERT INTO vehicle(vehicle_type_id, vehicle_licensea_plate, vehicle_description,tenant_id,room_id,apartment_id)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getVehicleType().getVehicleTypeId());
            ps.setObject(2, obj.getVehicleLicenseaPlate());
            ps.setObject(3, obj.getVehicleDescription());
            ps.setObject(4, obj.getTenant().getTenantId());
            ps.setObject(5, obj.getRoom().getRoomId());
            ps.setObject(6, obj.getApartmentId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Vehicle obj, int vehicleId) {
        int check = 0;
        String query = "UPDATE vehicle Set vehicle_licensea_plate = ? WHERE vehicle_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {

            ps.setObject(1, obj.getVehicleLicenseaPlate());
            ps.setObject(3, vehicleId);
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

}
