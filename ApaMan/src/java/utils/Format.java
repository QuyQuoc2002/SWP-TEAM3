/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author DELL
 */
public class Format {

    /**
     * Format phone number ex: 0911092002 -> 0911 092 002
     * 
     * @param strPhoneNumber valid number have to format
     * @return phone number with right form
     */
    public static String phoneNumber(String strPhoneNumber) {
        return strPhoneNumber.substring(0, 4) + " "
                + strPhoneNumber.substring(4, 7) + " "
                + strPhoneNumber.substring(7, 10);
    }
}
