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
public class Apartment {
    
    private int apartmentId;
    private String apartmentName;
    private String hostName;
    private String hostMobile;
    private int districtId;
    private String apartmentAddress;
    private String apartmentIntro;
    private String apartmentLat;
    private String apartmentLon;
    private String apartmentImgAboutus;
    private String apartmentContentAboutus;
    private String apartmentContentService;
    private String apartmentContentRecruitment;
    private long apartmentCreateTime;
    private boolean apartmentAccessible;
    private double distanceFromDevice;
}
