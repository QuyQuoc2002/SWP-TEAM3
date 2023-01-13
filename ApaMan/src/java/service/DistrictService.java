/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DistrictDAO;
import entity.District;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DistrictService {
    
    private DistrictDAO districtDAO = new DistrictDAO();
    
    public List<District> getAll() {
        return districtDAO.getAll();
    }
}
