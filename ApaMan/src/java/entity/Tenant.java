/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Laputa
 */
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Tenant {
    private int tenantId;
    private Account account;
    private Room room;
    private String tenantCitizenIdentification;
    private String tenantName;
    private String tenantDob;
    private String tenantPhoneNumber;
    private String tenantParentPhone;
    private String tenantCountryside;
}
