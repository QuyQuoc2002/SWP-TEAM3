/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Laputa
 */
import connection.MySQLConnection;
import entity.Room;
import entity.RoomStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public List<Room> getAll(int floorId, int apartmentId) {

        String sql = "SELECT "
                + "r.room_id,"
                + "r.room_name,"
                + "r.roomtype_id,"
                + "r.floor_id,"
                + "r.apartment_id,"
                + "r.room_status_id,"
                + "rs.room_status_description \n"
                + "FROM apamandb.room r JOIN apamandb.room_status rs ON r.room_status_id = rs.room_status_id \n"
                + "WHERE floor_id = ? AND apartment_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, floorId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Room> list = new ArrayList<>();//
            while (rs.next()) {
                Room obj = Room.builder()
                        .roomId(rs.getInt("room_id"))
                        .roomName(rs.getString("room_name"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomStatus(RoomStatus.builder()
                                .roomStatusId(rs.getInt("room_status_id"))
                                .roomStatusDescription(rs.getString("room_status_description"))
                                .build()
                        )
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Room> getAll(int apartmentId) {

        String sql = "SELECT "
                + "r.room_id,"
                + "r.room_name,"
                + "r.roomtype_id,"
                + "r.floor_id,"
                + "r.apartment_id,"
                + "r.room_status_id,"
                + "rs.room_status_description \n"
                + "FROM apamandb.room r JOIN apamandb.room_status rs ON r.room_status_id = rs.room_status_id \n"
                + "WHERE apartment_id = ?";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();

            List<Room> list = new ArrayList<>();//
            while (rs.next()) {
                Room obj = Room.builder()
                        .roomId(rs.getInt("room_id"))
                        .roomName(rs.getString("room_name"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomStatus(RoomStatus.builder()
                                .roomStatusId(rs.getInt("room_status_id"))
                                .roomStatusDescription(rs.getString("room_status_description"))
                                .build()
                        )
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Room getOne(int roomId, int apartmentId) {
        String sql = "SELECT "
                + "r.room_id,"
                + "r.room_name,"
                + "r.roomtype_id,"
                + "r.floor_id,"
                + "r.apartment_id,"
                + "r.room_status_id,"
                + "rs.room_status_description \n"
                + "FROM apamandb.room r JOIN apamandb.room_status rs ON r.room_status_id = rs.room_status_id \n"
                + "WHERE room_id = ? AND apartment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ps.setObject(2, apartmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Room obj = Room.builder()
                        .roomId(rs.getInt("room_id"))
                        .roomName(rs.getString("room_name"))
                        .roomtypeId(rs.getInt("roomtype_id"))
                        .floorId(rs.getInt("floor_id"))
                        .apartmentId(rs.getInt("apartment_id"))
                        .roomStatus(RoomStatus.builder()
                                .roomStatusId(rs.getInt("room_status_id"))
                                .roomStatusDescription(rs.getString("room_status_description"))
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

        public int add(Room obj) {
        int check = 0;
        String sql = "INSERT INTO room(room_name, roomtype_id, floor_id, apartment_id , room_status_id)"
                + " VALUES(?, ?, ?, ? , ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getRoomName());
            ps.setObject(2, obj.getRoomtypeId());
            ps.setObject(3, obj.getFloorId());
            ps.setObject(4, obj.getApartmentId());
            ps.setObject(5, 1);
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

    public boolean updateRooms(List<Room> list) {
        String query = "UPDATE room Set room_name = ?,roomtype_id = ?, floor_id = ?, apartment_id = ?, room_status_id = ? WHERE room_id = ?";
        int[] arr = {};
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (Room obj : list) {
                    ps.setObject(1, obj.getRoomName());
                    ps.setObject(2, obj.getRoomtypeId());
                    ps.setObject(3, obj.getFloorId());
                    ps.setObject(4, obj.getApartmentId());
                    ps.setObject(5, obj.getRoomStatus().getRoomStatusId());
                    ps.setObject(6, obj.getRoomId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public boolean delete(int roomId, int floorId) {
        int check = 0;
        String sql = "DELETE FROM room Where room_id = ? AND floor_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ps.setObject(2, floorId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();
        System.out.println(roomDAO.getAll(1));
    }
}
