<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-----------------------------Edit Floor-------------------->
<!-- #region sadasd-->
<div class="modal fade" id="edit-floor" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 120px;">
    <div class="modal-dialog">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <h3 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Add, Edit, Delete Floor</h3>
                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark"></i></a>
                </div>
                <form id="add-floor-form" action="floor-management" method="post">
                    <div class="d-flex mb-3">
                        <input id="add-floor-name" type="number" name="floorName" class="form-control bg-dark text-white w-75" placeholder="Add Floor">
                        <div class="text-white d-flex aligns-items-center justify-content-center align-items-center w-25">
                            <input type="hidden" name="submitType" value="Add">
                            <button onclick="validateAddFloorName()" type="button" class=" btn btn-danger px-4">Add</button>
                        </div>
                    </div>
                </form>
                <hr>
                <c:if test="${requestScope.floors.size() != 0}">
                    <form id="update-floor-form" action="floor-management" method="post">
                        <c:forEach items="${requestScope.floors}" var="floor">
                            <div class="d-flex mb-3">
                                <input type="hidden" name="floorId" value="${floor.floorId}">
                                <input name="floorName" type="number" class="form-control bg-dark text-white w-75 floor-name" value="${floor.floorName}">
                                <a href="javascript:void(0);" onclick="openConfirmDeleteFloor('${floor.floorId}', '${floor.floorName}');" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                                        class="fa-solid fa-trash-can fs-3"></i></a>
                            </div>
                        </c:forEach>
                        <hr>
                        <div id="update-floor-button-block">
                            <div class="row">
                                <div class="col-6">
                                    <button type="button" class="btn btn-danger py-3 w-100 mb-4" data-bs-dismiss="modal">Close</button>
                                </div>
                                <div class="col-6">
                                    <input type="hidden" name="submitType" value="Update">
                                    <button onclick="checkFloorNameDuplicate();" type="button" class="btn btn-primary py-3 w-100 mb-4">Save</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:if>
                <div id="delete-floor-button-block">
                    <div class="row text-wheat">
                        <h3 class="col-12 mb-3 text-center">
                            Are you sure delete floor <span class="text-danger" id="floor-name-delete"></span>
                        </h3>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <button onclick="closeConfirmDeleteFloor();" class="btn btn-primary py-3 w-100 mb-4">Cancel</button>
                        </div>
                        <div class="col-6">
                            <a href="" class="btn btn-danger py-3 w-100 mb-4">Delete</a>
                        </div>
                    </div>
                </div>  
            </div>
        </div>
    </div>
</div>
<!-- #endregion -->