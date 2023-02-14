/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ContactDAO;
import entity.Contact;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class ContactService {
    
    private ContactDAO ContactDAO = new ContactDAO();
    
    public List<Contact> getAll(int apartmentId) {
        return ContactDAO.getAll(apartmentId);
    }
    
    public boolean add(Contact obj) {
        return ContactDAO.add(obj);
    }
    
}
