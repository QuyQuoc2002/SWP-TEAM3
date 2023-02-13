<%-- 
    Document   : room_member
    Created on : Feb 13, 2023, 12:01:23 PM
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
                <div class="container-fluid pt-4 px-4">
                    <div class="top-side d-flex justify-content-between">
                        <div>
                            <div class="btn btn-dark-cus mb-3">Phòng 105</div>
                            <a href="room-member.html" class="btn btn-dark-cus mb-3 ms-3 select">
                                Thành viên
                            </a>
                            <a href="room-we-index.html" class="btn btn-dark-cus mb-3 ms-3">
                                Lịch sử số nước, số điện
                            </a>       
                        </div>
                        <div class="d-flex">
                            <h4 class="text-wheat">Find Roomate</h4>
                            <label class="switch ms-3">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                    </div>


                    <div id="cards" class="row">

                        <c:forEach items="${tenants}" var="tenant">
                            <div class="col-4 mb-4" id="new-tenant">
                                <form action="room-member" method="post">
                                <div class="bg-secondary-cus rounded p-2 card-staff">
                                    <div class="row px-3 pt-2">
                                        <div class="col-8 text-wheat">
                                            <input hidden name="accountId" value="${tenant.account.accountId}">
                                            <div style="line-height: 34px; font-size: 20px;">
                                                <i class="fa-solid fa-user me-2"></i>${tenant.account.accountUsername}
                                            </div>
                                            <div class="d-flex">
                                                <i class="fa-solid fa-lock me-2" style="line-height: 34px;"></i>
                                                <input name="password" class="text-wheat w-100 border-0" style="background: transparent; line-height: 34px; font-size: 20px;" type="text" value="${tenant.account.accountPassword}" >
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="d-flex justify-content-end">
                                                <span class="text-secondary">Active</span>
                                            </div>
                                            <div class="d-flex justify-content-end">
                                                <label class="switch ms-3">
                                                    <input type="checkbox" name="accountAccessible" <c:if test="${tenant.account.accountAccessible}"> checked</c:if>>
                                                        <span class="slider round"></span>
                                                    </label>
                                                </div>
                                            </div>                        
                                        </div>
                                        <hr>
                                        <div class="card-staff-header">
                                            <div>
                                                <i class="fa-solid fa-mountain-sun me-1"></i><span><input name="tenantCountryside"
                                                                                                          class="border-0 bg-secondary-cus" type="text" value="${tenant.tenantCountryside}" placeholder="Countryside"></span>
                                        </div>
                                        <div>
                                            <i class="fa-regular fa-calendar-days me-1"></i><span><input name="tenantDob"
                                                                                                         class="border-0 bg-secondary-cus" type="text" value="${tenant.tenantDob}" placeholder="Date of birth"></span>
                                        </div>
                                    </div>
                                    <div class="card-staff-body">
                                        <div class="contact text-white">
                                            <div class="phone">
                                                <i class="fa-solid fa-phone-volume me-2"></i><span><input name="tenantPhoneNumber"
                                                                                                          class="border-0 bg-secondary-cus text-white w-75" type="text"
                                                                                                          value="${tenant.tenantPhoneNumber}" placeholder="Phone number"></span>
                                            </div>
                                            <div class="mt-1">
                                                <i class="fa-solid fa-phone me-2"></i><input name="tenantParentPhone"
                                                                                             class="border-0 bg-secondary-cus text-white w-75" type="text"
                                                                                             value="${tenant.tenantParentPhone}" placeholder="Parent phone number"></span>
                                            </div>
                                            <div class="mt-1">
                                                <i class="fa-regular fa-id-card me-2"></i><span><input name="tenantCitizenIdentification"
                                                                                                       class="border-0 bg-secondary-cus text-white" type="text"
                                                                                                       value="${tenant.tenantCitizenIdentification}" placeholder="CitizenIdentification"></span>
                                            </div>
                                        </div>
                                        <div class="user mt-4">
                                            <div class="media d-flex">
                                                <a class="circle">
                                                    <img class="avatar" src="assets/images/avatar.png" alt="">
                                                </a>
                                                <div class="media-body pt-2">
                                                    <input hidden name="tenantId" value="${tenant.tenantId}">
                                                    <input hidden name="roomId" value="${tenant.roomId}">
                                                    <h5><input class="border-0 bg-secondary-cus text-white" type="text" name="tenantName"
                                                               value="${tenant.tenantName}" placeholder="Name"></h5>
                                                    <div class="tags">
                                                        <div class="tag">1 xe đạp</div>
                                                        <div class="tag">1 xe máy</div>
                                                        <a class="tag a-none" href="javascript:void(0)" data-bs-toggle="modal"
                                                           data-bs-target="#add-vehical">Thêm</a>
                                                        <a class="tag a-none" href="javascript:void(0)" data-bs-toggle="modal"
                                                           data-bs-target="#delete-vehical">Xóa</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="action mt-2">
                                            <div class="row">
                                                <div class="col-6">
                                                    <button class="btn btn-primary w-100">Save</button>
                                                </div>
                                                <div class="col-6">
                                                    <button class="btn btn-danger w-100">Reset</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
        </div>

        <!-------------------------------------------MODAL-------------------------------------------->
        <%@include file="component/modal/modal-delete-account-staff.jsp"%>

        <!-------------------------------------------JS-------------------------------------------->
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/validate.js"></script>
        <script src="assets/js/member.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
            function resetTenant() {
                document.querySelector('#new-tenant .countryside').value = null;
                document.querySelector('#new-tenant .dob').value = null;
                document.querySelector('#new-tenant .phone-number').value = null;
                document.querySelector('#new-tenant .citizen-identification').value = null;
                document.querySelector('#new-tenant .salary').value = null;
                document.querySelector('#new-tenant .name').value = null;
                document.querySelector('#new-tenant .job').value = null;
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