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
                    <!--                    <button class="btn btn-dark-cus mb-3">
                                            Proceed to get electricity, water number
                                        </button>-->
                    <div class="bg-secondary-cus rounded p-4" style="margin-bottom: 70px">
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Room Name</th>
                                    <th>Roomtype</th>
                                    <th>Status</th>
                                        <c:if test="${sessionScope.curAccount.role.roleName eq 'HOST'}">
                                        <th>Payment</th>
                                        </c:if>
                                    <th>Electric/Water</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.rooms}" var="room" varStatus="i">
                                    <tr>
                                        <td>${i.count}</td>
                                        <td><a href="room-member?roomId=${room.roomId}" class="a-none">${room.roomName}</a></td>
                                        <td>${room.roomtype.roomtypeName}</td>
                                        <td><c:if test="${room.findRoommate}"> Find Roommate</c:if>
                                            <c:if test="${!room.findRoommate}">${room.roomStatus.roomStatusName}</c:if>
                                            
                                        </td>
                                        <c:if test="${sessionScope.curAccount.role.roleName eq 'HOST'}">
                                            <td><a <c:if test="${room.paymentStatus.paymentStatusId == 1}">
                                                        href="#" 
                                                    </c:if>
                                                    <c:if test="${room.paymentStatus.paymentStatusId == 2}">
                                                        href="Payment?roomId=${room.roomId}&floorId=${room.floorId}" 
                                                    </c:if>
                                                    <c:if test="${room.paymentStatus.paymentStatusId == 3}">
                                                        href="confirmPayment?roomId=${room.roomId}&floorId=${room.floorId}" 
                                                    </c:if>
                                                    class="text-warning a-none" >${room.paymentStatus.paymentStatusName}</a></td>
                                            </c:if>
                                        <td>
                                            <c:if test="${room.paymentStatus.paymentStatusId == 1}">
                                                <a href="GetElectricWater?roomId=${room.roomId}&floorId=${room.floorId}" class="a-none"  ><i class="fa-solid fa-pen-to-square text-danger"></i></a>
                                                </c:if>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>



            </div>
        </div>

        <!-------------------------MODAL-------------------------------------->
        <%@include file="component/modal/modal-get-electric.jsp" %>
        <%@include file="component/modal/modal-payment.jsp" %>
        <%@include file="component/modal/modal-confirm-payment.jsp" %>
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

        <script>
            const isOpenModal = '<%= session.getAttribute("isOpenModal") %>';
            if (isOpenModal !== 'null') {
                var myModal = new bootstrap.Modal(document.getElementById("we-modal"), {});
                document.onreadystatechange = function () {
                    myModal.show();
                };
            }
        </script>

        <script>
            const isOpenModalPayment = '<%= session.getAttribute("isOpenModalPayment") %>';
            if (isOpenModalPayment !== 'null') {
                var myModal = new bootstrap.Modal(document.getElementById("payment-modal"), {});
                document.onreadystatechange = function () {
                    myModal.show();
                };
            }
        </script>

        <script>
            const isOpenModalConfirm = '<%= session.getAttribute("isOpenModalConfirm") %>';
            if (isOpenModalConfirm !== 'null') {
                var myModal = new bootstrap.Modal(document.getElementById("confirm-modal"), {});
                document.onreadystatechange = function () {
                    myModal.show();
                };
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
            request.getSession().removeAttribute("isOpenModal");
            request.getSession().removeAttribute("isOpenModalPayment");
            request.getSession().removeAttribute("isOpenModalConfirm");
    %>
</html>
