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

                <div class="d-flex mb-3">
                    <input type="text" class="form-control bg-dark text-white w-75" placeholder="Add Floor">
                    <div class="text-white d-flex aligns-items-center justify-content-center align-items-center w-25">
                        <button type="submit" class=" btn btn-danger px-4">Add</button>
                    </div>
                </div>
                <hr>
                
                <c:forEach items="${requestScope.floors}" var="floor">
                    <div class="d-flex mb-3">
                        <input type="text" class="form-control bg-dark text-white w-75" value="${floor.floorName}">
                        <a href="" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                                class="fa-solid fa-trash-can fs-3"></i></a>
                    </div>
                </c:forEach>
                <div class="d-flex mb-3">
                    <input type="text" class="form-control bg-dark text-white w-75" value="T?ng 2">
                    <a href="" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                            class="fa-solid fa-trash-can fs-3"></i></a>
                </div>
                <div class="d-flex mb-3">
                    <input type="text" class="form-control bg-dark text-white w-75" value="T?ng 3">
                    <a href="" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                            class="fa-solid fa-trash-can fs-3"></i></a>
                </div>
                <div class="d-flex mb-3">
                    <input type="text" class="form-control bg-dark text-white w-75" value="T?ng 4">
                    <a href="" class="d-flex aligns-items-center justify-content-center align-items-center w-25"><i
                            class="fa-solid fa-trash-can fs-3"></i></a>
                </div>

                <!-- </div> -->
                <div class="row">
                    <div class="col-6">
                        <button type="submit" class="btn btn-danger py-3 w-100 mb-4"
                                data-bs-dismiss="modal">?óng</button>
                    </div>
                    <div class="col-6">
                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">L?u</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- #endregion -->