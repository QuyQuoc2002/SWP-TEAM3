<%-- 
    Document   : room-control
    Created on : Jan 30, 2023, 3:07:12 PM
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
        <link rel="stylesheet" href="assets/css/room-management.css">
        <style>
            th,
            td {
                color: white;
            }

            #example_length {
                color: wheat;
            }

            #example_length select {
                color: white;
                background: #191C24;
            }

            #example_filter {
                color: wheat !important;
            }

            #example_filter input {
                color: wheat !important;
            }

            #example_paginate {
                color: wheat !important;
            }

            #example_info {
                color: wheat !important;
            }
        </style>
    </head>

    <body>

        <div class="container-fluid position-relative d-flex p-0">
            <!-- Sidebar Start -->
            <%@include file="component/common/sidebar.jsp" %>
            <!-- Sidebar End -->
            <div class="content">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->
                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">APARTMENT ROOM CONTROL</div>
                <div id="room" class="container-fluid pt-4 px-4">
                    <div class="d-flex justify-content-around text-uppercase mb-5 info">
                        <h3>100 Rooms</h3>
                        <h3>4 Floors</h3>
                        <a class="a-none" href="">
                            <h3>Add Room</h3>
                        </a>
                        <a class="a-none" href="">
                            <h3>Add Floor</h3>
                        </a>
                    </div>
                    <div class="row">
                        <div class="col-4 mb-4">
                            <div class="bg-secondary-cus rounded p-2 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-regular fa-circle text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Empty Room</h4>
                                        <p class="text-white">25 Rooms</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-4 mb-4">
                            <div class="bg-secondary-cus rounded p-2 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-regular fa-circle-check text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Deposit Room</h4>
                                        <p class="text-white">25 Rooms</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-4 mb-4">
                            <div class="bg-secondary-cus rounded p-2 card-feature">
                                <div class="card-feature-content">
                                    <i class="fa-solid fa-circle-check text-primary-cus"></i>
                                    <div class="card-feature-title">
                                        <h4 class="text-white">Renting Room</h4>
                                        <p class="text-white">50 Rooms</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-4 mb-4">
                            <a class="a-none" href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#add-room">
                                <div class="bg-secondary-cus rounded p-2 card-feature">
                                    <div class="card-feature-content">
                                        <i class="fa-solid fa-circle-plus text-primary-cus"></i>
                                        <div class="card-feature-title">
                                            <h4 class="text-white">Room</h4>
                                            <p class="text-white">Add Room</p>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-4 mb-4">
                            <a class="a-none" href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#edit-room-type">
                                <div class="bg-secondary-cus rounded p-2 card-feature">
                                    <div class="card-feature-content">
                                        <i class="fa-solid fa-circle-plus text-primary-cus"></i>
                                        <div class="card-feature-title">
                                            <h4 class="text-white">Room Type</h4>
                                            <p class="text-white">Add, Edit, Delete Room Type</p>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-4 mb-4">
                            <a class="a-none" href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#edit-floor">
                                <div class="bg-secondary-cus rounded p-2 card-feature">
                                    <div class="card-feature-content">
                                        <i class="fa-solid fa-circle-plus text-primary-cus"></i>
                                        <div class="card-feature-title">
                                            <h4 class="text-white">Floor</h4>
                                            <p class="text-white">Add, Edit, Delete Floor</p>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-------------------------MODAL-------------------------------------->
        <%@include file="component/modal/add-room.jsp" %>
        <%@include file="component/modal/edit-room-type.jsp" %>
        <%@include file="component/modal/edit-floor.jsp" %>

    </body>
    <script src="assets/js/bootstrap.bundle.js"></script>

</html>