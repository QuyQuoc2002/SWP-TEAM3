<%-- 
    Document   : add-vehicle
    Created on : Feb 14, 2023, 12:42:15 AM
    Author     : Laputa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!----------------------------------ADD VEHICLE MODAL--------------------------------->
<div class="modal fade" id="add-vehicle" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 120px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <h3 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Add Vehicle</h3>
                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark"></i></a>
                </div>
                <form id="add-vehicle-form" action="vehicle" method="post" enctype="multipart/form-data">
                    <!--<div class="form-floating mb-3">-->
                        <input type="file" name="file" lang="en" class="btn btn-dark-cus" size="60" required="">
                        <label for="floatingInput">Image</label>
                    <!--</div>-->
                    <select class="form-control bg-dark w-100 text-white fs-5 mb-3" name="vehicleTypeId" ">
                        <c:forEach items="${vehicleTypes}" var="vehicleType">
                            <option value="${vehicleType.vehicleTypeId}" >${vehicleType.vehicleTypeName}</option>
                        </c:forEach>
                    </select>

                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" name="vehicleDescription" required="">
                        <label for="floatingInput">Description</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="text" class="form-control bg-dark text-white" name="vehicleLicensePlate">
                        <label for="floatingInput">License Plate</label>
                    </div>



                    <div class="row">
                        <div class="col-6">
                            <button type="button" class="btn btn-danger py-3 w-100 mb-4"
                                    data-bs-dismiss="modal">Close</button>
                        </div>
                        <div class="col-6">
                            <input hidden name="tenantId" id="tenantIdVehicle">
                            <input hidden name="roomId" id="roomIdVehicle">
                            <input hidden name="submitType" value="Add">
                            <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

