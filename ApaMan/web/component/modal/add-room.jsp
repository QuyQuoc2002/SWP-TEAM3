<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="add-room" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 120px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">

                    <h3 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Add Room</h3>

                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark"></i></a>
                </div>
                <form id="add-room-form" action="floor-room" method="post">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control bg-dark text-white"  id="add-name-room" name="roomName">
                    <label for="floatingInput" >Room Name</label>
                </div>
                <!-- <div class="form-floating mb-3"> -->
                <select class="form-control bg-dark w-100 text-white fs-5 mb-3" name="roomtypeId">
                    <c:forEach items="${requestScope.roomtypes}" var="roomtype">
                        <option value="${roomtype.roomtypeId}">${roomtype.roomtypeName}</option>
                    </c:forEach>
                </select>
                <select class="form-control bg-dark w-100 text-white fs-5 mb-3" name="floorId">
                    <c:forEach items="${requestScope.floors}" var="floor">
                        <option value="${floor.floorId}">floor ${floor.floorName}</option>
                    </c:forEach>
                </select>
                <!-- </div> -->
                <div class="row">
                    <div class="col-6">
                        <button type="button" class="btn btn-danger py-3 w-100 mb-4"
                                data-bs-dismiss="modal">Close</button>
                    </div>
                    <div class="col-6">
                        <button onclick="validateAddRoomName()" type="button" class="btn btn-primary py-3 w-100 mb-4">Add</button>
                        
                    </div>
                </div>
                </form>

            </div>
        </div>
    </div>
</div>