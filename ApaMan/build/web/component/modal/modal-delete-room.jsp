<div class="modal fade" id="modal-delete-room" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 70px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <h3 class="text-primary-cus text-center">Delete Room</h3>
                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark text-white"></i></a>
                </div>

                <div class="text-center mb-3 h4 text-white">Are you sure you want to delete room <span class="text-wheat">${requestScope.room.roomName}</span> ? </div>
                <form action="room-member" method="post">
                    <input type="hidden" name="roomId" value="${requestScope.room.roomId}">
                    <div class="row">
                        <div class="col-6">
                            <button type="button" class="btn btn-primary py-3 w-100 mb-4" data-bs-dismiss="modal">Close</button>
                        </div>
                        <div class="col-6">
                            <input hidden name="floorId" value="${requestScope.room.floorId}">
                            <input hidden name="submitType" value="UpdateRoom">
                            <input class="btn btn-danger py-3 w-100 mb-4" type="submit" name="submitType2" value="Delete">
                        </div>
                    </div> 
                </form>
            </div>
        </div>
    </div>
</div>