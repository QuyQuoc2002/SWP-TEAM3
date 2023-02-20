<%-- 
    Document   : member
    Created on : Feb 11, 2023, 8:40:19 PM
    Author     : Laputa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" type="text/css" href="assets/css/switch-toggle-btn.css">
        <link rel="stylesheet" href="assets/css/members.css">
        <link rel="stylesheet" href="assets/css/room-member.css">
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
                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">MEMBER</div>
                <div id="member" class="container-fluid pt-4 px-4">

                    <div class="row">

                        <c:if test="${tenants == null}">
                            <h1>Chưa có khách thuê trọ</h1>
                        </c:if>

                        <c:if test="${tenants != nul}">
                            <c:forEach items="${tenants}" var="tenant">
                                <div class="col-3 mb-4">
                                    <div class="bg-secondary-cus rounded p-2 card-staff">
                                        <div class="card-staff-header">
                                            <div>
                                                <i class="fa-solid fa-mountain-sun me-1"></i><span>${tenant.tenantCountryside}</span>
                                            </div>
                                            <div>
                                                <i class="fa-regular fa-calendar-days me-1"></i><span>${tenant.tenantDob}</span>
                                            </div>
                                        </div>
                                        <div class="card-staff-body">
                                            <div class="contact text-white">
                                                <div class="phone">
                                                    <i class="fa-solid fa-phone-volume me-2 mb-2"></i>${tenant.tenantPhoneNumber}</span>
                                                </div>
                                                <div>
                                                    <i class="fa-solid fa-phone me-2"></i>${tenant.tenantParentPhone}</span>
                                                </div>
                                                <div>
                                                    <i class="fa-regular fa-id-card me-2"></i><span>${tenant.tenantCitizenIdentification}</span>
                                                </div>
                                            </div>
                                            <a href="room-member?roomId=${tenant.room.roomId}" class="a-none">
                                                <div class="room">
                                                    ${tenant.room.roomName}
                                                </div>
                                            </a>
                                            <div class="user mt-4">
                                                <div class="media d-flex">
                                                    <a class="circle">
                                                        <img class="avatar" src="assets/images/avatar.png" alt="">
                                                    </a>
                                                    <div class="media-body pt-2">
                                                        <h5 >${tenant.tenantName}</h5>
                                                        <div class="tags">

                                                            <c:forEach items="${vehicles}" var="vehicle">
                                                                <c:if test="${vehicle.tenant.tenantId eq tenant.tenantId}">
                                                                    <div class="tag">${vehicle.vehicleType.vehicleTypeName}</div>
                                                                </c:if>
                                                            </c:forEach>
                                                            <a class="tag a-none" onclick="getAllVehicleByTenant(${tenant.tenantId})" data-bs-toggle="modal"
                                                               data-bs-target="#modal-list-vehicle">View List Vehicle</a>


                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <!-------------------------------------------MODAL-------------------------------------------->
        <%@include file="component/modal/modal-delete-account-staff.jsp"%>
        <%@include file="component/modal/modal-list-vehicle.jsp"%>  

        <!-------------------------------------------JS-------------------------------------------->
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/validate.js"></script>
        <script src="assets/js/staff.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
                                                                function getAllVehicleByTenant(tenantId) {
                                                                    const request = new XMLHttpRequest();
                                                                    request.open("GET", "/ApaMan/vehicle?submitType=getAllByTenant&tenantId=" + tenantId, true);
                                                                    request.onload = function () {
                                                                        if (this.readyState === 4 && this.status === 200) {
                                                                            let listVehicle = '';
                                                                            const vehicles = JSON.parse(this.responseText);
                                                                            for (let i = 0; i < vehicles.length; i++) {
                                                                                listVehicle +=
                                                                                        '<tr>' +
                                                                                        '<td>' + vehicles[i].vehicleType.vehicleTypeName + '</td>' +
                                                                                        '<td>' + vehicles[i].vehicleDescription + '</td>' +
                                                                                        '<td>' + vehicles[i].vehicleLicensePlate + '</td>' +
                                                                                        '<td><a href="' + vehicles[i].vehicleImgPath + '" class="a-none">View</a></td>' +
                                                                                        '</tr>';
                                                                            }
                                                                            document.getElementById('list-vehicle-by-tenant').innerHTML = listVehicle;
                                                                        } else {
                                                                            console.log(2);
                                                                        }
                                                                    };
                                                                    request.send(null);
                                                                }

        </script>

        <!---------------------------------------------SHOW TOAST---------------------------------------------------------->
        <script>
            const messageUpdate = '<%= session.getAttribute("messageUpdate") %>';
            if (messageUpdate !== 'null') {
                const words = messageUpdate.split("|");
                showToast(words[0], words[1], words[2]);
            }
        </script>

    </body>
    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>