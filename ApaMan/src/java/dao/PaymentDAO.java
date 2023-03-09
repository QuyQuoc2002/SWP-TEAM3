/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Payment;
import entity.PaymentStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laputa
 */
public class PaymentDAO {

    public int countUpdate(int roomId) {
        int countUpdate;
        String sql = "SELECT COUNT(room_id) AS countUpdate \n"
                + "FROM apamandb.payment r \n"
                + "Where r.room_id = ?;";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                countUpdate = rs.getInt("countUpdate");
                return countUpdate;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public Payment getOne(int paymentId) {
        String sql = "SELECT p.payment_id,"
                + "p.room_id,p.payment_room_unit_fee,"
                + "p.payment_water_index_pre,p.payment_electric_index_pre,p.payment_day_update_pre , "
                + "p.payment_water_index_cur, p.payment_electric_index_cur, p.payment_day_update_cur, "
                + "p.payment_water_unit_fee, p.payment_water_money, "
                + "p.payment_electric_unit_fee, p.payment_electric_money, "
                + "p.payment_car_quantity, p.payment_car_unit_fee, p.payment_car_money, "
                + "p.payment_motor_quantity, p.payment_motor_unit_fee, p.payment_motor_money, "
                + "p.payment_bike_quantity, p.payment_bike_unit_fee, p.payment_bike_money, "
                + "p.payment_total_money, "
                + "p.payment_status_id, ps.payment_status_name\n"
                + "FROM apamandb.payment p\n"
                + "JOIN apamandb.payment_status ps ON p.payment_status_id = ps.payment_status_id\n"
                + "WHERE p.payment_id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, paymentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Payment obj = Payment.builder()
                        .paymentId(rs.getInt("payment_id"))
                        .roomId(rs.getInt("room_id"))
                        .paymentRoomUnitFee(rs.getInt("payment_room_unit_fee"))
                        .paymentWaterIndexPre(rs.getInt("payment_water_index_pre"))
                        .paymentElectricIndexPre(rs.getInt("payment_electric_index_pre"))
                        .paymentDayUpdatePre(rs.getLong("payment_day_update_pre"))
                        .paymentWaterIndexCur(rs.getInt("payment_water_index_cur"))
                        .paymentElectricIndexCur(rs.getInt("payment_electric_index_cur"))
                        .paymentDayUpdateCur(rs.getLong("payment_day_update_cur"))
                        .paymentWaterUnitFee(rs.getInt("payment_water_unit_fee"))
                        .paymentWaterMoney(rs.getInt("payment_water_money"))
                        .paymentElectricUnitFee(rs.getInt("payment_electric_unit_fee"))
                        .paymentElectricMoney(rs.getInt("payment_electric_money"))
                        .paymentCarQuantity(rs.getInt("payment_car_quantity"))
                        .paymentCarUnitFee(rs.getInt("payment_car_unit_fee"))
                        .paymentCarMoney(rs.getInt("payment_car_money"))
                        .paymentMotorQuantity(rs.getInt("payment_motor_quantity"))
                        .paymentMotorUnitFee(rs.getInt("payment_motor_unit_fee"))
                        .paymentMotorMoney(rs.getInt("payment_motor_money"))
                        .paymentBikeQuantity(rs.getInt("payment_bike_quantity"))
                        .paymentBikeUnitFee(rs.getInt("payment_bike_unit_fee"))
                        .paymentBikeMoney(rs.getInt("payment_bike_money"))
                        .paymentTotalMoney(rs.getInt("payment_total_money"))
                        .paymentStatus(PaymentStatus.builder()
                                .paymentStatusId(rs.getInt("payment_status_id"))
                                .paymentStatusName(rs.getString("payment_status_name"))
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

    public Payment getPaymentPre(int roomId) {
        String sql = "SELECT p.payment_id,"
                + "p.room_id,p.payment_room_unit_fee,"
                + "p.payment_water_index_pre,p.payment_electric_index_pre,p.payment_day_update_pre , "
                + "p.payment_water_index_cur, p.payment_electric_index_cur, p.payment_day_update_cur, "
                + "p.payment_water_unit_fee, p.payment_water_money, "
                + "p.payment_electric_unit_fee, p.payment_electric_money, "
                + "p.payment_car_quantity, p.payment_car_unit_fee, p.payment_car_money, "
                + "p.payment_motor_quantity, p.payment_motor_unit_fee, p.payment_motor_money, "
                + "p.payment_bike_quantity, p.payment_bike_unit_fee, p.payment_bike_money, "
                + "p.payment_total_money, "
                + "p.payment_status_id, ps.payment_status_name\n"
                + "FROM apamandb.payment p\n"
                + "JOIN apamandb.payment_status ps ON p.payment_status_id = ps.payment_status_id\n"
                + "WHERE room_id = ?\n"
                + "ORDER BY payment_id desc LIMIT 1;";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, roomId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Payment obj = Payment.builder()
                        .paymentId(rs.getInt("payment_id"))
                        .roomId(rs.getInt("room_id"))
                        .paymentRoomUnitFee(rs.getInt("payment_room_unit_fee"))
                        .paymentWaterIndexPre(rs.getInt("payment_water_index_pre"))
                        .paymentElectricIndexPre(rs.getInt("payment_electric_index_pre"))
                        .paymentDayUpdatePre(rs.getLong("payment_day_update_pre"))
                        .paymentWaterIndexCur(rs.getInt("payment_water_index_cur"))
                        .paymentElectricIndexCur(rs.getInt("payment_electric_index_cur"))
                        .paymentDayUpdateCur(rs.getLong("payment_day_update_cur"))
                        .paymentWaterUnitFee(rs.getInt("payment_water_unit_fee"))
                        .paymentWaterMoney(rs.getInt("payment_water_money"))
                        .paymentElectricUnitFee(rs.getInt("payment_electric_unit_fee"))
                        .paymentElectricMoney(rs.getInt("payment_electric_money"))
                        .paymentCarQuantity(rs.getInt("payment_car_quantity"))
                        .paymentCarUnitFee(rs.getInt("payment_car_unit_fee"))
                        .paymentCarMoney(rs.getInt("payment_car_money"))
                        .paymentMotorQuantity(rs.getInt("payment_motor_quantity"))
                        .paymentMotorUnitFee(rs.getInt("payment_motor_unit_fee"))
                        .paymentMotorMoney(rs.getInt("payment_motor_money"))
                        .paymentBikeQuantity(rs.getInt("payment_bike_quantity"))
                        .paymentBikeUnitFee(rs.getInt("payment_bike_unit_fee"))
                        .paymentBikeMoney(rs.getInt("payment_bike_money"))
                        .paymentTotalMoney(rs.getInt("payment_total_money"))
                        .paymentStatus(PaymentStatus.builder()
                                .paymentStatusId(rs.getInt("payment_status_id"))
                                .paymentStatusName(rs.getString("payment_status_name"))
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

    public boolean add(Payment obj) {
        int check = 0;
        String sql = "INSERT INTO payment(room_id, payment_room_unit_fee, "
                + "payment_water_index_pre, payment_electric_index_pre, payment_day_update_pre, "
                + "payment_water_index_cur, payment_electric_index_cur, payment_day_update_cur, "
                + "payment_water_unit_fee, payment_water_money,"
                + "payment_electric_unit_fee, payment_electric_money,"
                + "payment_car_quantity, payment_car_unit_fee, payment_car_money,"
                + "payment_motor_quantity, payment_motor_unit_fee, payment_motor_money,"
                + "payment_bike_quantity, payment_bike_unit_fee, payment_bike_money,"
                + "payment_total_money,"
                + "payment_status_id)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getRoomId());
            ps.setObject(2, obj.getPaymentRoomUnitFee());
            ps.setObject(3, obj.getPaymentWaterIndexPre());
            ps.setObject(4, obj.getPaymentElectricIndexPre());
            ps.setObject(5, obj.getPaymentDayUpdatePre());
            ps.setObject(6, obj.getPaymentWaterIndexCur());
            ps.setObject(7, obj.getPaymentElectricIndexCur());
            ps.setObject(8, obj.getPaymentDayUpdateCur());
            ps.setObject(9, obj.getPaymentWaterUnitFee());
            ps.setObject(10, obj.getPaymentWaterMoney());
            ps.setObject(11, obj.getPaymentElectricUnitFee());
            ps.setObject(12, obj.getPaymentElectricMoney());
            ps.setObject(13, obj.getPaymentCarQuantity());
            ps.setObject(14, obj.getPaymentCarUnitFee());
            ps.setObject(15, obj.getPaymentCarMoney());
            ps.setObject(16, obj.getPaymentMotorQuantity());
            ps.setObject(17, obj.getPaymentMotorUnitFee());
            ps.setObject(18, obj.getPaymentMotorMoney());
            ps.setObject(19, obj.getPaymentBikeQuantity());
            ps.setObject(20, obj.getPaymentBikeUnitFee());
            ps.setObject(21, obj.getPaymentBikeMoney());
            ps.setObject(22, obj.getPaymentTotalMoney());
            ps.setObject(23, 2);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updatePayment(Payment obj) {
        int check = 0;
        String query = "UPDATE payment Set payment_water_money = ?, payment_electric_money = ? , payment_total_money = ?, payment_status_id = ? WHERE payment_id = ?";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {

            ps.setObject(1, obj.getPaymentWaterMoney());
            ps.setObject(2, obj.getPaymentElectricMoney());
            ps.setObject(3, obj.getPaymentTotalMoney());
            ps.setObject(4, obj.getPaymentStatus().getPaymentStatusId());
            ps.setObject(5, obj.getPaymentId());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public static void main(String[] args) {
        PaymentDAO paymentDAO = new PaymentDAO();

        System.out.println(paymentDAO.getOne(17));
    }

}
