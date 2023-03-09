/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author DELL
 */
public interface IConst {
    
    int SHIFT_KEY = 5;

    String ROLE_ADMIN = "ADMIN";
    String ROLE_HOST = "HOST";
    String ROLE_STAFF = "STAFF";
    String ROLE_TENANT = "TENANT";
    
    int ROLE_ADMIN_ID = 1;
    int ROLE_HOST_ID = 2;
    int ROLE_STAFF_ID = 3;
    int ROLE_TENANT_ID = 4;
    
    String ADMIN_EMAIL = "quocpqhe163061@fpt.edu.vn";
    String ADMIN_EMAIL_PASS = "Shironeko02";
    
    String REGEX_PASSWORD = "^[a-zA-Z0-9!@#$%^&*,.]{8,20}$";
    
    int NUMBER_APARTMENT_PER_PAGE = 6;
}
