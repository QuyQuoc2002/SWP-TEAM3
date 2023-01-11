/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AccountDAO;
import entity.Account;

/**
 *
 * @author DELL
 */
public class AccountService {
    
    private AccountDAO accountDAO = new AccountDAO();
    
    public Account login(String username, String password, int apartmemtId) {
        return accountDAO.login(username, password, apartmemtId);
    }
}
