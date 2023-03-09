<%-- 
    Document   : modal-confirm-payment
    Created on : Mar 8, 2023, 2:13:09 PM
    Author     : Laputa
--%>

<div class="modal fade" id="confirm-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 50px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <form action="confirmPayment" method="post">
                <div class="rounded my-4 mx-3">
                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <div class="">
                            <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Room ${room.roomName} (${room.roomtype.roomtypeCost}VND / Month)</h4>
                        </div>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="text-white mb-3"><h5>Day Update: ${Calendars.formatTime('dd/MM/yyy',payment.paymentDayUpdatePre)}</h5></div>
                    <div class="row text-white mb-4">
                        <h6 class="col-6">Water: <span class="text-info fw-bold">${payment.paymentWaterIndexPre}</span></h6>
                        <h6 class="col-6">Electric: <span class="text-info fw-bold">${payment.paymentElectricIndexPre}</span></h6>
                    </div>
                    <div class="text-white mb-3"><h5>Day Update: ${Calendars.formatTime('dd/MM/yyy',payment.paymentDayUpdateCur)}</h5></div>
                    <div class="row text-white mb-3">
                        <h6 class="col-6">Water: <span class="text-info fw-bold">${payment.paymentWaterIndexCur}</span></h6>
                        <h6 class="col-6">Electric: <span class="text-info fw-bold">${payment.paymentElectricIndexCur}</span></h6>
                    </div>
                    <div class="text-white mb-3"><h5>Water Price : <span class="text-info fw-bold">${payment.paymentWaterUnitFee}</span></h5></div>
                    <div class="text-white mb-3"><h5>Electric Price : <span class="text-info fw-bold">${payment.paymentElectricMoney}</span></h5></div>
                    <div class="text-white mb-3"><h5>Vehicle : <span class="text-info fw-bold">${payment.paymentCarMoney + payment.paymentMotorMoney + payment.paymentBikeMoney}</span></h5></div>
                    <div class="text-white mb-3"><h3>Total: <span class="text-info fw-bold">${payment.paymentTotalMoney}</span></h3></div>


                    <!-- </div> -->
                    <div class="row">
                        <div class="col-6">
                            <button type="button" class="btn btn-danger py-3 w-100 mb-4"
                                    data-bs-dismiss="modal">Close</button>
                        </div>
                        <div class="col-6">
                            <input hidden name="roomIdPayment" value="${room.roomId}">
                            <input hidden name="floorIdPayment" value="${room.floorId}">
                            <input hidden name="paymentId" value="${payment.paymentId}">
                            <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Save</button>
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
