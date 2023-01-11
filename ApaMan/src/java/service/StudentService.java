/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.StudentDAO;
import entity.Student;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StudentService {
    public List<Student> getAll() {
        return new StudentDAO().getAll();
    }
    
    public Student getOne(int id) {
        return new StudentDAO().getOne(id);
    }
    
    public boolean add(Student obj) {
        return new StudentDAO().add(obj);
    }
    
    public boolean update(Student obj, int id) {
        return new StudentDAO().update(obj, id);
    }
    
    public boolean delete(int id) {
        return new StudentDAO().delete(id);
    }
}
