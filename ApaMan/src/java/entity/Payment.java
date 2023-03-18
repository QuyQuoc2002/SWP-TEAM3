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

public class Payment {
    
    private int paymentId;
    private int apartmentId;
    private int roomId;
    private int paymentRoomUnitFee;
    
    private int paymentWaterIndexPre;
    private int paymentElectricIndexPre;
    private long paymentDayUpdatePre;
    
    private int paymentWaterIndexCur;
    private int paymentElectricIndexCur;
    private long paymentDayUpdateCur;
    
    private int paymentWaterUnitFee;
    private int paymentWaterMoney;
    
    private int paymentElectricUnitFee;
    private int paymentElectricMoney;
    
    private int paymentCarQuantity;
    private int paymentCarUnitFee;
    private int paymentCarMoney;
    
    private int paymentMotorQuantity;
    private int paymentMotorUnitFee;
    private int paymentMotorMoney;
    
    private int paymentBikeQuantity;
    private int paymentBikeUnitFee;
    private int paymentBikeMoney;
    
    private int paymentTotalMoney;
    private PaymentStatus paymentStatus;
    private long paymentDoneDate;
    
    
}
