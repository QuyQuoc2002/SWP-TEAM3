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
    private int districId;
    private String apartmentAddress;
    private String apartmentIntro;
    private double apartmentLat;
    private double apartmentLon;
    private String apartmentImgAboutus;
    private String apartmentContentAboutus;
    private String apartmentContentService;
    private String apartmentContentRecruitment;
    private boolean apartmentAccessible;
}
