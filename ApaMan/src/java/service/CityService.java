/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CityDAO;
import entity.City;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CityService {
    
    private CityDAO cityDAO = new CityDAO();
    
    public List<City> getAll() {
        return cityDAO.getAll();
    }
}
