/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.StaffDAO;
import dao.TenantDAO;
import entity.Staff;
import entity.Tenant;
import java.util.List;

/**
 *
 * @author DELL
 */
public class TenantService {

    private TenantDAO tenantDAO = new TenantDAO();
    
    public int numberOfTenants(int apartmentId) {
        return tenantDAO.numberOfTenants(apartmentId);
    }

    public List<Tenant> getAll(int apartmentId) {
        return tenantDAO.getAll(apartmentId);
    }
    
    public List<Tenant> getAll(int roomId, int apartmentId) {
        return tenantDAO.getAll(roomId,apartmentId);
    }
    
    public boolean add(List<Tenant> list) {
        return tenantDAO.add(list);
    }

    public Tenant getOne(int tenantId) {
        return tenantDAO.getOne(tenantId);
    }

    public boolean update(Tenant obj, int tenantId) {
        return tenantDAO.update(obj, tenantId);
    }
    
    public boolean delete(int tenantId) {
        return tenantDAO.delete(tenantId);
    }
   
}
