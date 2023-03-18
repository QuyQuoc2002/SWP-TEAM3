/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.PaymentDAO;
import entity.Payment;
import java.util.List;

/**
 *
 * @author Laputa
 */
public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();

    public int countUpdate(int roomId) {
        return paymentDAO.countUpdate(roomId);
    }

    public Payment getPaymentPre(int roomId) {
        return paymentDAO.getPaymentPre(roomId);
    }

    public Payment getOne(int paymentId) {
        return paymentDAO.getOne(paymentId);
    }

    public boolean add(Payment obj) {
        return paymentDAO.add(obj);
    }

    public boolean updatePayment(Payment obj) {
        return paymentDAO.updatePayment(obj);
    }
    
    public List<Payment> getAllHistoryByApartmentId(int apartmentId) {
        return paymentDAO.getAllHistoryByApartmentId(apartmentId);
    }

}
