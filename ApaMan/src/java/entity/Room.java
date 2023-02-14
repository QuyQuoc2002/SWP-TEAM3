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

public class Room {
    private int roomId;
    private String roomName;
    private int roomtypeId;
    private int floorId;
    private int apartmentId;
    private RoomStatus roomStatus;
    private boolean findRoommate;
    
}
