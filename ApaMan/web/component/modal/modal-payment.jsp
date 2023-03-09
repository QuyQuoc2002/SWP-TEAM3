<%-- 
    Document   : modal-payment
    Created on : Mar 8, 2023, 2:11:48 PM
    Author     : Laputa
--%>

<div class="modal fade" id="payment-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 50px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <form action="Payment" method="post">
                <div class="rounded my-4 mx-3">

                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <a class="a-none">
                            <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Room ${room.roomName} (${room.roomtype.roomtypeCost}VND / Month)</h4>
                        </a>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="text-white mb-3"><h4>Day Update: ${Calendars.formatTime('dd/MM/yyy',payment.paymentDayUpdatePre)}</h4></div>
                    <div class="row text-white mb-4">
                        <h5 class="col-6">Water: <span class="text-info fw-bold">${payment.paymentWaterIndexPre}</span></h5>
                        <h5 class="col-6">Electric: <span class="text-info fw-bold">${payment.paymentElectricIndexPre}</span></h5>
                    </div>
                    <div class="text-white mb-3"><h4>Day Update: ${Calendars.formatTime('dd/MM/yyy',payment.paymentDayUpdateCur)}</h4></div>
                    <div class="row text-white mb-4">
                        <h5 class="col-6">Water: <span class="text-info fw-bold">${payment.paymentWaterIndexCur}</span></h5>
                        <h5 class="col-6">Electric: <span class="text-info fw-bold">${payment.paymentElectricIndexCur}</span></h5>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" value="${payment.paymentWaterMoney}" name="paymentWaterMoney" readonly>
                        <label class=" text-white" for="floatingInput">Water Price (${payment.paymentWaterUnitFee}/m2)</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" value="${payment.paymentElectricMoney}" name="paymentElectricMoney" readonly>
                        <label class=" text-white" for="floatingInput">Electric Price (${payment.paymentElectricUnitFee}/KWh)</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" value="${payment.paymentCarMoney + payment.paymentMotorMoney + payment.paymentBikeMoney}" readonly>
                        <label class=" text-white" for="floatingInput">Vehicle </label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" value="${payment.paymentTotalMoney}" name="paymentTotalMoney">
                        <label class=" text-white" for="floatingInput">Total</label>
                    </div>
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
