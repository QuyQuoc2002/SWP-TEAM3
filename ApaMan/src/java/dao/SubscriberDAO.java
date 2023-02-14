/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import entity.Subscriber;
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
public class SubscriberDAO {
    
    public int numberOfSubscribers () {
        int numberOfSubscribers;
        String sql = "SELECT COUNT(subscriber_id) AS numberOfSubscribers \n" +
                     "FROM apamandb.subscriber; ";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numberOfSubscribers = rs.getInt("numberOfFloors");
                return numberOfSubscribers;
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public List<Subscriber> getAll() {

        String sql = "SELECT * FROM subscriber";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Subscriber> list = new ArrayList<>();//
            while (rs.next()) {
                Subscriber obj = Subscriber.builder()
                        .subscriberId(rs.getInt("subscriber_id"))
                        .subscriberEmail(rs.getString("subscriber_email"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(String subscriberEmail) {
        int check = 0;
        String sql = "INSERT INTO subscriber(subscriber_email)"
                + " VALUES(?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, subscriberEmail);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
