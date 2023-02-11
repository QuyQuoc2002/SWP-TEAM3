<%-- 
    Document   : floor-room
    Created on : Feb 8, 2023, 11:19:21 AM
    Author     : Laputa
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Apaman</title>
        <link rel="icon" type="image/x-icon" href="assets/system/icons8-home-pulsar-color-32.png">
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" type="text/css" href="assets/css/floor.css"> 

    </head>

    <body>
        <div class="toast-container position-fixed top-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="color: black">
            </div>
        </div>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Sidebar Start -->
            <%@include file="component/common/sidebar.jsp" %>
            <!-- Sidebar End -->
            <div class="content">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->

                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">APARTMENT ROOM CONTROL</div>



                <div class="container-fluid pt-4 px-4">
                    <button class="btn btn-dark-cus mb-3">
                        Tiến Hành lấy số điện, số nước
                    </button>
                    <div class="bg-secondary-cus rounded p-4" style="margin-bottom: 70px">
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Room Name</th>
                                    <th>Roomtype</th>
                                    <th>Status</th>
                                    <th>Thanh Toán</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.rooms}" var="room" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td><a href="room-member.html">${room.roomName}</a></td>
                                    <td>
                                        <c:forEach items="${requestScope.roomtypes}" var="roomtype">
                                        <c:if test="${room.roomtypeId eq roomtype.roomtypeId}">${roomtype.roomtypeName}</c:if>
                                        </c:forEach>
                                    </td>
                                    <td>${room.roomStatus}</td>
                                    <td><a class="text-warning" href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#confirm-modal">Cần thanh toán</a></td>
                                    <td><a href="#"><i class="fa-solid fa-pen-to-square text-danger"></i></a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>


                <!-- #region confirm modal-->
                <div class="modal fade" id="confirm-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-hidden="true" style="margin-top: 50px;">
                    <div class="modal-dialog">
                        <div class="modal-content bg-secondary-cus">
                            <div class="rounded my-4 mx-3">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <div class="">
                                        <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Phòng 105 (2.500.000đ/tháng)</h4>
                                    </div>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="text-white mb-3"><h5>Lần cập nhật ngày: 27-09-2022</h5></div>
                                <div class="row text-white mb-4">
                                    <h6 class="col-6">Số Nước: <span class="text-info fw-bold">5</span></h6>
                                    <h6 class="col-6">Số Điện: <span class="text-info fw-bold">2</span></h6>
                                </div>
                                <div class="text-white mb-3"><h5>Lần cập nhật ngày: 27-10-2022</h5></div>
                                <div class="row text-white mb-3">
                                    <h6 class="col-6">Số Nước: <span class="text-info fw-bold">15</span></h6>
                                    <h6 class="col-6">Số Điện: <span class="text-info fw-bold">200</span></h6>
                                </div>
                                <div class="text-white mb-3"><h5>Tiền nước: <span class="text-info fw-bold">300.000đ</span></h5></div>
                                <div class="text-white mb-3"><h5>Tiền điện: <span class="text-info fw-bold">320.000đ</span></h5></div>
                                <div class="text-white mb-3"><h5>2 xe máy, 1 xe đạp: <span class="text-info fw-bold">120.000đ</span></h5></div>
                                <div class="text-white mb-3"><h3>Tổng: <span class="text-info fw-bold">3.120.000đ</span></h3></div>


                                <!-- </div> -->
                                <div class="row">
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-danger py-3 w-100 mb-4"
                                                data-bs-dismiss="modal">Đóng</button>
                                    </div>
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Thanh toán</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- #endregion -->

                <!-- #region Modal lấy số điện nước-->
                <div class="modal fade" id="we-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-hidden="true" style="margin-top: 120px;">
                    <div class="modal-dialog">
                        <div class="modal-content bg-secondary-cus">
                            <div class="rounded my-4 mx-3">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <a href="index.html" class="">
                                        <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Phòng 105</h4>
                                    </a>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="text-white mb-3"><h3>Lần cập nhật ngày: 27-09-2022</h3></div>
                                <div class="row text-white mb-4">
                                    <h5 class="col-6">Số Nước: <span class="text-info fw-bold">5</span></h5>
                                    <h5 class="col-6">Số Điện: <span class="text-info fw-bold">2</span></h5>
                                </div>
                                <div class="text-white mb-3"><h3>Lần cập nhật ngày: Today</h3></div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           placeholder="name@example.com">
                                    <label class=" text-white" for="floatingInput">Số nước</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           placeholder="name@example.com">
                                    <label class=" text-white" for="floatingInput">Số điện</label>
                                </div>
                                <!-- </div> -->
                                <div class="row">
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-danger py-3 w-100 mb-4"
                                                data-bs-dismiss="modal">Đóng</button>
                                    </div>
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Xác Nhận</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- #endregion -->

                <!-- #region Thanh toán -->
                <div class="modal fade" id="payment-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                     aria-hidden="true" style="margin-top: 50px;">
                    <div class="modal-dialog">
                        <div class="modal-content bg-secondary-cus">
                            <div class="rounded my-4 mx-3">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <a href="index.html" class="">
                                        <h4 class="text-primary-cus"><i class="fa fa-user-edit me-2"></i>Phòng 105 (2.500.000đ/tháng)</h4>
                                    </a>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="text-white mb-3"><h4>Lần cập nhật ngày: 27-09-2022</h4></div>
                                <div class="row text-white mb-4">
                                    <h5 class="col-6">Số Nước: <span class="text-info fw-bold">5</span></h5>
                                    <h5 class="col-6">Số Điện: <span class="text-info fw-bold">2</span></h5>
                                </div>
                                <div class="text-white mb-3"><h4>Lần cập nhật ngày: 27-10-2022</h4></div>
                                <div class="row text-white mb-4">
                                    <h5 class="col-6">Số Nước: <span class="text-info fw-bold">15</span></h5>
                                    <h5 class="col-6">Số Điện: <span class="text-info fw-bold">200</span></h5>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           value="300.000đ">
                                    <label class=" text-white" for="floatingInput">Tiền nước (30.000đ/m2)</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           value="320.000đ">
                                    <label class=" text-white" for="floatingInput">Tiền điện (3.000đ/KWh)</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           value="120.000đ">
                                    <label class=" text-white" for="floatingInput">2 xe máy 1 xe đạp</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control bg-dark text-white" id="input-name-room"
                                           value="4.000.000đ">
                                    <label class=" text-white" for="floatingInput">Tổng tiền</label>
                                </div>
                                <!-- </div> -->
                                <div class="row">
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-danger py-3 w-100 mb-4"
                                                data-bs-dismiss="modal">Đóng</button>
                                    </div>
                                    <div class="col-6">
                                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Xác Nhận</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- #endregion -->

            </div>
        </div>

        <!-------------------------MODAL-------------------------------------->
        <%@include file="component/modal/add-room.jsp" %>
        <%@include file="component/modal/edit-floor.jsp" %>
        <!-------------------------END MODAL---------------------------------->

        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/room-control.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/main.js"></script>
        <!---------------------------------------------SHOW TOAST---------------------------------------------------------->
        <script>
            const messageUpdate = '<%= session.getAttribute("messageUpdate") %>';
            if (messageUpdate !== 'null') {
                const words = messageUpdate.split("|");
                showToast(words[0], words[1], words[2]);
                openModal(words[3]);
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script>$(document).ready(function () {
                $('#example').DataTable();
            });</script>

    </body>

    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>
