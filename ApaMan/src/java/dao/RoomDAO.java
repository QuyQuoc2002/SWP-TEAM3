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

    public int numberOfRooms(int apartmentId) {
        int numberOfRooms;
        String sql = "SELECT COUNT(room_id) AS numberOfRooms \n"
                + "FROM apamandb.room r \n"
                + "Where r.apartment_id = ?;";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfRooms = rs.getInt("numberOfRooms");
                return numberOfRooms;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int numberOfStatusRoom(int apartmentId, int roomStatusId) {
        int numberOfStatusRoom;
        String sql = "SELECT COUNT(room_id) AS numberOfStatusRoom \n"
                + "FROM apamandb.room r \n"
                + "Where r.apartment_id = ? AND r.room_status_id = ?;";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ps.setObject(2, roomStatusId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfStatusRoom = rs.getInt("numberOfStatusRoom");
                return numberOfStatusRoom;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public List<Room> getAll(int floorId, int apartmentId) {

        String sql = "SELECT "
                + "r.room_id,"
                + "r.room_name,"
                + "r.roomtype_id,"
                + "r.floor_id,"
                + "r.apartment_id,"
                + "r.room_status_id,"
                + "r.find_roommate,"
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
                        .findRoommate(rs.getBoolean("find_roommate"))
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
                + "r.find_roommate,"
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
                        .findRoommate(rs.getBoolean("find_roommate"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Room> getAllStatus(int apartmentId, int roomStatusId) {

        String sql = "SELECT "
                + "r.room_id,"
                + "r.room_name,"
                + "r.roomtype_id,"
                + "r.floor_id,"
                + "r.apartment_id,"
                + "r.room_status_id,"
                + "r.find_roommate,"
                + "rs.room_status_description \n"
                + "FROM apamandb.room r JOIN apamandb.room_status rs ON r.room_status_id = rs.room_status_id \n"
                + "WHERE r.apartment_id = ? AND r.room_status_id = ? ;";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, apartmentId);
            ps.setObject(2, roomStatusId);
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
                        .findRoommate(rs.getBoolean("find_roommate"))
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
                + "r.find_roommate,"
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
                        .findRoommate(rs.getBoolean("find_roommate"))
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
        String sql = "INSERT INTO room(room_name, roomtype_id, floor_id, apartment_id , find_roommate, room_status_id)"
                + " VALUES(?, ?, ?, ? , ? , ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) : null;) {
            ps.setObject(1, obj.getRoomName());
            ps.setObject(2, obj.getRoomtypeId());
            ps.setObject(3, obj.getFloorId());
            ps.setObject(4, obj.getApartmentId());
            ps.setObject(5, 0);
            ps.setObject(6, 1);
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
        String query = "UPDATE room Set room_name = ?,roomtype_id = ?, floor_id = ?, apartment_id = ?, room_status_id = ?, find_roommate = ? WHERE room_id = ?";
        int[] arr = {};
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (Room obj : list) {
                    ps.setObject(1, obj.getRoomName());
                    ps.setObject(2, obj.getRoomtypeId());
                    ps.setObject(3, obj.getFloorId());
                    ps.setObject(4, obj.getApartmentId());
                    ps.setObject(5, obj.getRoomStatus().getRoomStatusId());
                    ps.setObject(6, obj.isFindRoommate());
                    ps.setObject(7, obj.getRoomId());
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public boolean update(Room obj) {
        int check = 0;
        String query = "UPDATE room Set room_name = ?,roomtype_id = ?, floor_id = ?, apartment_id = ?, room_status_id = ?, find_roommate = ? WHERE room_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, obj.getRoomName());
                ps.setObject(2, obj.getRoomtypeId());
                ps.setObject(3, obj.getFloorId());
                ps.setObject(4, obj.getApartmentId());
                ps.setObject(5, obj.getRoomStatus().getRoomStatusId());
                ps.setObject(6, obj.isFindRoommate());
                ps.setObject(7, obj.getRoomId());

                check = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
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
