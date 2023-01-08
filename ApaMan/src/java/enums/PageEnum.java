/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 *
 * @author DELL
 */
public enum PageEnum {
    Home_FIRST_PAGE(11),
    
    FOURTH_PAGE(4),
    FIFTH_PAGE(5),
    SIXTH_PAGE(6),
    SEVENTH_PAGE(7),
    EIGHTH_PAGE(8),
    NINTH_PAGE(9),
    TENTH_PAGE(10);

    private int code;

    PageEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
