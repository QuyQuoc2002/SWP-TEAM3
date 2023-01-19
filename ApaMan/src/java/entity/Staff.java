/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Staff {
    private int staffId;
    private Account account;
    private String staffCitizenIdentification;
    private String staffName;
    private String staffDob;
    private String staffPhoneNumber;
    private String staffCountryside;
    private String staffJob;
    private String staffSalary;
}
