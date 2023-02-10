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
        <link rel="stylesheet" href="assets/css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
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
                <div class="text-center my-2 text-danger text-uppercase fw-bolder" style="font-size: 50px;">ROOM TYPE</div>

                <!-- ------------------------------------ADD---------------------------------------- -->
                <div id="roomtype-add" class="container-fluid pt-4 px-4">
                    <form action="roomtype" method="post" class="row panel-form bg-secondary-cus rounded p-2 card-feature">
                        <div class="row col-10">
                            <div class="col-3 form-group mb-3">
                                <fieldset>
                                    <legend>Name</legend>
                                    <input type="text" id="add-roomtype-name" class="form-control roomtype-name" name="roomtypeName" required="">
                                </fieldset>
                            </div>
                            <div class="col-3 form-group mb-3">
                                <fieldset>
                                    <legend>Max Member</legend>
                                    <input type="number" id="add-roomtype-maxmember" class="form-control" name="roomtypeMaxMember" required="">
                                </fieldset>
                            </div>
                            <div class="col-3 form-group mb-3">
                                <fieldset>
                                    <legend>Cost ($/month)</legend>
                                    <input type="number" id="add-roomtype-cost" class="form-control" name="roomtypeCost" required="">
                                </fieldset>
                            </div>
                            <div class="col-3 form-group mb-3">
                                <fieldset>
                                    <legend>Area (m<sup>2</sup>)</legend>
                                    <input type="text" id="add-roomtype-area" class="form-control" name="roomtypeArea" required="">
                                </fieldset>
                            </div>
                        </div>
                        <div class="row col-2" style="margin: 0">
                            <div class="col-12 d-flex justify-content-center align-items-center" style="padding-bottom: 8px">
                                <input type="hidden" name="submitType" value="Add">
                                <button type="button" onclick="validateAddRoomtype()" class="btn btn-danger w-75" style="height: 47px">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- ------------------------------------VIEW---------------------------------------- -->
                <c:forEach items="${requestScope.roomtypes}" var="roomtype">
                    <div class="container-fluid pt-4 px-4">
                        <form action="roomtype-detail" method="get" >                      
                            <div class="row panel-form bg-secondary-cus rounded p-2 card-feature">
                                <div class="row col-10">
                                    <div class="col-3 form-group mb-3">
                                        <fieldset>
                                            <legend>Name</legend>
                                            <input readonly="" type="text" class="form-control roomtype-name" name="roomtypeName" value="${roomtype.roomtypeName}">
                                        </fieldset>
                                    </div>
                                    <div class="col-3 form-group mb-3">
                                        <fieldset>
                                            <legend>Max Member</legend>
                                            <input readonly type="text" class="form-control roomtypeMaxMember" name="roomtypeMaxMember" value="${roomtype.roomtypeMaxMember}" >
                                        </fieldset>
                                    </div>
                                    <div class="col-3 form-group mb-3">
                                        <fieldset>
                                            <legend>Cost ($/month)</legend>
                                            <input readonly type="text" class="form-control roomtypeCost" name="roomtypeCost" value="${roomtype.roomtypeCost}" >
                                        </fieldset>
                                    </div>
                                    <div class="col-3 form-group mb-3">
                                        <fieldset>
                                            <legend>Area (m<sup>2</sup>)</legend>
                                            <input readonly type="text" class="form-control roomtypeArea" name="roomtypeArea" value="${roomtype.roomtypeArea}" >
                                        </fieldset>
                                    </div>
                                </div>
                                <div class="row col-2" style="margin: 0">
                                    <div class="col-12 d-flex justify-content-center align-items-center" style="padding-bottom: 8px"> 
                                        <input type="hidden" value="${roomtype.roomtypeId}" name="roomtypeId">
                                        <button class="btn btn-primary w-75" type="submit" style="height: 47px">View</button>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!---------------------------------------------JavaScript---------------------------------------------------------->       
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/roomtype.js"></script>
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

    </body>
    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>