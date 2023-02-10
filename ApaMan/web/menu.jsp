<%-- 
    Document   : menu.jsp
    Created on : Jan 12, 2023, 2:22:40 AM
    Author     : DELL
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

    <link rel="stylesheet" href="assets/css/common.css">
    <link rel="stylesheet" href="assets/css/menu.css">
</head>

<body>

    <div class="container-fluid position-relative d-flex p-0">
        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <%@include file="component/common/sidebar.jsp" %>
        </div>
        <!-- Sidebar End -->
        <div class="content">
            <!-- Navbar Start -->
            <%@include file="component/common/navbar.jsp" %>
            <!-- Navbar End -->
            <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">Menu</div>
            <div class="container-fluid pt-4 px-4">
                <div class="row">
                    <div class="col-4 mb-4">
                        <a href="homepage-management.html">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa fa-tachometer-alt text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Apartment Info</h4>
                                        <p class="text-white">Update apartment information</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="members.html">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-users text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Member</h4>
                                        <p class="text-white">List of tenant</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="staff.html">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-user-gear text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Staff</h4>
                                        <p class="text-white">Staff information</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="vehical.html">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-motorcycle text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Vehical</h4>
                                        <p class="text-white">Member's vehical</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="room-management.html">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-house text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Room</h4>
                                        <p class="text-white">Apartment's rooms</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-file-signature text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Deposit Contract</h4>
                                        <p class="text-white">Deposit contract template</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-4 mb-4">
                        <a href="">
                            <div class="bg-secondary-cus rounded p-4 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-file-contract text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Tenancy Agreement</h4>
                                        <p class="text-white">Tenancy agreement template</p>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/main.js"></script>

</html>
