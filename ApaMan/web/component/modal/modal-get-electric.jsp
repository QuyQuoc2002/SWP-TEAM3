<%-- 
    Document   : modal-get-electric
    Created on : Mar 8, 2023, 2:09:43 PM
    Author     : Laputa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="we-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 120px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <form action="GetElectricWater" method="post">
                <div class="rounded my-4 mx-3">
                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <a class="a-none">
                            <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Room ${room.roomName}</h4>
                        </a>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <input hidden name="countUpdate" value="${room.countUpdate}" >
                    <c:if test="${room.countUpdate != 0}">
                        <div id="pre-update-electric">
                            <div class="text-white mb-3"><h3>Day Update: ${Calendars.formatTime('dd/MM/yyy',payment.paymentDayUpdatePre)}</h3></div>
                            <input hidden name="paymentDayUpdatePre" value="${payment.paymentDayUpdateCur}">
                            <div class="row text-white mb-4">
                                <h5 class="col-6">Water: <span class="text-info fw-bold">${payment.paymentWaterIndexCur}</span></h5>
                                <input hidden name="paymentWaterIndexPre" value="${payment.paymentWaterIndexCur}" >
                                <h5 class="col-6">Electric: <span class="text-info fw-bold">${payment.paymentElectricIndexCur}</span></h5>
                                <input hidden name="paymentElectricIndexPre" value="${payment.paymentElectricIndexCur}" >
                            </div>
                        </div>
                    </c:if>
                    <div class="text-white mb-3" style="display: flex">
                        <h3>Today: ${Calendars.formatTime('dd/MM/yyy',paymentDayUpdateNow)}</h3>
                        <input hidden name="paymentDayUpdateCur" value="${paymentDayUpdateNow}">
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" name="paymentWaterIndexCur">
                        <label class=" text-white" for="floatingInput">Water</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" name="paymentElectricIndexCur">
                        <label class=" text-white" for="floatingInput">Electric</label>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-6">
                        <button type="button" class="btn btn-danger py-3 w-100 mb-4"
                                data-bs-dismiss="modal">Close</button>
                    </div>
                    <div class="col-6">
                        <input hidden name="roomIdPayment" value="${room.roomId}">
                        <input hidden name="floorIdPayment" value="${room.floorId}">
                        <input hidden name="paymentRoomUnitFee" value="${room.roomtype.roomtypeCost}">
                        <input hidden name="paymentCarQuantity"  value="${room.carQuantity}">
                        <input hidden name="paymentMotorQuantity" value="${room.motorQuantity}">
                        <input hidden name="paymentBikeQuantity" value="${room.bikeQuantity}">
                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Save</button>
                    </div>
                </div>

        </div>
        </form>
    </div>
</div>
</div>
