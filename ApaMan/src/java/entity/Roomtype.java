/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Roomtype {
    private int roomtypeId;
    private int apartmentId;
    private String roomtypeName;
    private int roomtypeMaxMember;
    private int roomtypeCost;
    private String roomtypeArea;
    private int roomtypeRoomQuantity;
    private List<RoomtypeImgBanner> roomtypeImg;
}
