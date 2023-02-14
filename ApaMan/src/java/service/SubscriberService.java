/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.SubscriberDAO;
import entity.Subscriber;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class SubscriberService {
    
    private SubscriberDAO subscriberDAO = new SubscriberDAO();
    
    public int numberOfSubscribers() {
        return subscriberDAO.numberOfSubscribers();
    }
    
    public List<Subscriber> getAll() {
        return subscriberDAO.getAll();
    }
    
    public boolean add(String subscriberEmail) {
        return subscriberDAO.add(subscriberEmail);
    }
    
}
