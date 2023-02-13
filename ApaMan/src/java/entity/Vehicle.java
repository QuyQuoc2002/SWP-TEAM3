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

public class Vehicle {
    private int vehicleId;
    private int apartmentId;
    private VehicleType vehicleType;
    private Tenant tenant;
    private Room room;
    private String vehicleLicensePlate;
    private String vehicleDescription;
}
