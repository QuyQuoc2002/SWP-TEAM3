/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MySQLConnection;
import enity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StudentDAO {
    public List<Student> getAll() {

        String sql = "SELECT * FROM Student";//

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Student> list = new ArrayList<>();//
            while (rs.next()) {
                Student obj = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .build();
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Student getOne(int id) {
        String sql = "SELECT * FROM Student WHERE id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student obj = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .build();
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(Student obj) {
        int check = 0;
        String sql = "INSERT INTO ModelSneaker(name, age)"
                + " VALUES(?, ?)";
        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getAge());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(Student obj, int id) {
        int check = 0;
        String sql = "UPDATE Student SET name = ?, age = ? WHERE id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getAge());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean delete(int id) {
        int check = 0;
        String sql = "DELETE FROM Student Where id = ?";

        try ( Connection con = MySQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
