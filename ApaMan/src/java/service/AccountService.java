/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AccountDAO;
import entity.Account;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AccountService {
    
    private AccountDAO accountDAO = new AccountDAO();
    
    public Account authenticate(String username, int apartmentId) {
        return accountDAO.authenticate(username, apartmentId);
    }
    
    public Account login(String username, String password, int apartmemtId) {
        return accountDAO.login(username, password, apartmemtId);
    }
    
    public boolean resetPassword(String username, String password, int apartmentId) {
        return accountDAO.resetPassword(username, password, apartmentId);
    }
    
    public int add(Account obj) {
        return accountDAO.add(obj);
    }
    
    public boolean update(Account obj, int accountId) {
        return accountDAO.update(obj, accountId);
    }
   
    public Account getOne(int accountId) {
        return accountDAO.getOne(accountId);
    }
    
    public boolean delete(int accountId) {
        return accountDAO.delete(accountId);
    }
    
    public String getAccountUsername(int apartmentId, int roleId) {
        return accountDAO.getAccountUsername(apartmentId, roleId);
    }
    
    public List<Account> getAllHostAccount() {
        return accountDAO.getAllHostAccount();
    }
}
