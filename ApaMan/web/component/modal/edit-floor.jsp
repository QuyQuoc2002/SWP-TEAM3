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
                <form action="floor-management" method="post">
                    <div class="d-flex mb-3">
                        <input type="text" name="floorName" class="form-control bg-dark text-white w-75" placeholder="Add Floor">
                        <div class="text-white d-flex aligns-items-center justify-content-center align-items-center w-25">
                            <button name="submitType" value="Add" type="submit" class=" btn btn-danger px-4">Add</button>
                        </div>
                    </div>
                </form>
                <hr>
                <form action="floor-management" method="post">
                    <c:forEach items="${requestScope.floors}" var="floor">
                        <div class="d-flex mb-3">
                            <input type="hidden" name="floorId" value="${floor.floorId}">
                            <input name="floorName" type="text" class="form-control bg-dark text-white w-75" value="${floor.floorName}">
                            <a href="javascript:void(0);" onclick="openConfirmDeleteFloor('${floor.floorId}', '${floor.floorName}');" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                                    class="fa-solid fa-trash-can fs-3"></i></a>
                        </div>
                    </c:forEach>
                    <hr>
                    <div id="update-floor-button-block">
                        <div class="row">
                            <div class="col-6">
                                <button class="btn btn-danger py-3 w-100 mb-4" data-bs-dismiss="modal">Close</button>
                            </div>
                            <div class="col-6">
                                <button name="submitType" value="Update" type="submit" class="btn btn-primary py-3 w-100 mb-4">Save</button>
                            </div>
                        </div>
                    </div>
                </form>
                <div id="delete-floor-button-block">
                    <div class="row text-wheat">
                        <h3 class="col-12 mb-3 text-center">
                            Are you sure delete <span class="text-danger" id="floor-name-delete"></span>
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