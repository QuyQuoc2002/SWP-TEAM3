/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.FeeDAO;
import entity.Fee;
import java.util.List;

/**
 *
 * @author Laputa
 */

public class FeeService {
    
    private FeeDAO feeDAO = new FeeDAO();
    
    public List<Fee> getAll() {
        return feeDAO.getAll();
    }
    
    public int getValue(int feeId) {
        return feeDAO.getValue(feeId);
    }
    
}
