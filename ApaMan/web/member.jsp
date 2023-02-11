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
                    <div class="col-3 mb-4">
                        <div class="bg-secondary-cus rounded p-2 card-staff">
                            <div class="card-staff-header">
                                <div>
                                    <i class="fa-solid fa-mountain-sun me-1"></i><span>Hòa Lạc</span>
                                </div>
                                <div>
                                    <i class="fa-regular fa-calendar-days me-1"></i><span>11-09-2002</span>
                                </div>
                            </div>
                            <div class="card-staff-body">
                                <div class="contact text-white">
                                    <div class="phone">
                                        <i class="fa-solid fa-phone-volume me-2 mb-2"></i>01232314234</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>phone phụ huynh</span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-id-card me-2"></i><span>12312312</span>
                                    </div>
                                </div>
                                <a href="room-member.html">
                                    <div class="room">
                                        Phòng 105
                                    </div>
                                </a>
                                <div class="user mt-4">
                                    <div class="media d-flex">
                                        <a class="circle">
                                            <img class="avatar" src="assets/images/avatar.png" alt="">
                                        </a>
                                        <div class="media-body pt-2">
                                            <h5 >Nguyễn Văn A</h5>
                                            <div class="tags">
                                                <div class="tag">1 xe đạp</div>
                                                <div class="tag">1 xe máy</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                 <div class="action mt-2">
                                    <div class="row">
                                        <div class="col-6">
                                            <button class="btn btn-primary w-100">Lưu</button>
                                        </div>
                                        <div class="col-6">
                                            <button class="btn btn-danger w-100">Xóa</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                    <div class="col-3 mb-4">
                        <div class="bg-secondary-cus rounded p-2 card-staff">
                            <div class="card-staff-header">
                                <div>
                                    <i class="fa-solid fa-mountain-sun me-1"></i><span>Hòa Lạc</span>
                                </div>
                                <div>
                                    <i class="fa-regular fa-calendar-days me-1"></i><span>11-09-2002</span>
                                </div>
                            </div>
                            <div class="card-staff-body">
                                <div class="contact text-white">
                                    <div class="phone">
                                        <i class="fa-solid fa-phone-volume me-2 mb-2"></i>01232314234</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>phone phụ huynh</span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-id-card me-2"></i><span>12312312</span>
                                    </div>
                                </div>
                                <div class="room">
                                    Phòng 105
                                </div>
                                <div class="user mt-4">
                                    <div class="media d-flex">
                                        <a class="circle">
                                            <img class="avatar" src="assets/images/avatar.png" alt="">
                                        </a>
                                        <div class="media-body pt-2">
                                            <h5>Nguyễn Văn A</h5>
                                            <div class="tags">
                                                <div class="tag">1 xe đạp</div>
                                                <div class="tag">1 xe máy</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 mb-4">
                        <div class="bg-secondary-cus rounded p-2 card-staff">
                            <div class="card-staff-header">
                                <div>
                                    <i class="fa-solid fa-mountain-sun me-1"></i><span>Hòa Lạc</span>
                                </div>
                                <div>
                                    <i class="fa-regular fa-calendar-days me-1"></i><span>11-09-2002</span>
                                </div>
                            </div>
                            <div class="card-staff-body">
                                <div class="contact text-white">
                                    <div class="phone">
                                        <i class="fa-solid fa-phone-volume me-2 mb-2"></i>01232314234</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>phone phụ huynh</span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-id-card me-2"></i><span>12312312</span>
                                    </div>
                                </div>
                                <div class="room">
                                    Phòng 105
                                </div>
                                <div class="user mt-4">
                                    <div class="media d-flex">
                                        <a class="circle">
                                            <img class="avatar" src="assets/images/avatar.png" alt="">
                                        </a>
                                        <div class="media-body pt-2">
                                            <h5>Nguyễn Văn A</h5>
                                            <div class="tags">
                                                <div class="tag">1 xe đạp</div>
                                                <div class="tag">1 xe máy</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 mb-4">
                        <div class="bg-secondary-cus rounded p-2 card-staff">
                            <div class="card-staff-header">
                                <div>
                                    <i class="fa-solid fa-mountain-sun me-1"></i><span>Hòa Lạc</span>
                                </div>
                                <div>
                                    <i class="fa-regular fa-calendar-days me-1"></i><span>11-09-2002</span>
                                </div>
                            </div>
                            <div class="card-staff-body">
                                <div class="contact text-white">
                                    <div class="phone">
                                        <i class="fa-solid fa-phone-volume me-2 mb-2"></i>01232314234</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>phone phụ huynh</span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-id-card me-2"></i><span>12312312</span>
                                    </div>
                                </div>
                                <div class="room">
                                    Phòng 105
                                </div>
                                <div class="user mt-4">
                                    <div class="media d-flex">
                                        <a class="circle">
                                            <img class="avatar" src="assets/images/avatar.png" alt="">
                                        </a>
                                        <div class="media-body pt-2">
                                            <h5>Nguyễn Văn A</h5>
                                            <div class="tags">
                                                <div class="tag">1 xe đạp</div>
                                                <div class="tag">1 xe máy</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 mb-4">
                        <div class="bg-secondary-cus rounded p-2 card-staff">
                            <div class="card-staff-header">
                                <div>
                                    <i class="fa-solid fa-mountain-sun me-1"></i><span>Hòa Lạc</span>
                                </div>
                                <div>
                                    <i class="fa-regular fa-calendar-days me-1"></i><span>11-09-2002</span>
                                </div>
                            </div>
                            <div class="card-staff-body">
                                <div class="contact text-white">
                                    <div class="phone">
                                        <i class="fa-solid fa-phone-volume me-2 mb-2"></i>01232314234</span>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-phone me-2"></i>phone phụ huynh</span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-id-card me-2"></i><span>12312312</span>
                                    </div>
                                </div>
                                <div class="room">
                                    Phòng 105
                                </div>
                                <div class="user mt-4">
                                    <div class="media d-flex">
                                        <a class="circle">
                                            <img class="avatar" src="assets/images/avatar.png" alt="">
                                        </a>
                                        <div class="media-body pt-2">
                                            <h5>Nguyễn Văn A</h5>
                                            <div class="tags">
                                                <div class="tag">1 xe đạp</div>
                                                <div class="tag">1 xe máy</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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
        <script src="assets/js/staff.js"></script>
        <script src="assets/js/main.js"></script>

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