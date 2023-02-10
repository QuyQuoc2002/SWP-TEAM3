<%-- 
    Document   : roomtype-detail
    Created on : Feb 9, 2023, 3:12:12 PM
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
        <link rel="stylesheet" href="assets/css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" href="assets/css/roomtype-detail.css">
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
            <div class="content" style="padding: 20px;">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->
                <div class="text-center my-2 text-danger text-uppercase fw-bolder" style="font-size: 50px; ">ROOM TYPE</div>


                <!-- ------------------------------------UPDATE---------------------------------------- -->
                <div class="container-fluid pt-4 px-4" style="padding-bottom: 40px;">
                    <div id="roomtype-update" class="row panel-form bg-secondary-cus rounded p-2 card-feature">
                        <form  action="roomtype-detail" method="post" class="row panel-form bg-secondary-cus rounded p-2 card-feature">
                            <input type="text" name="roomtypeId" value="${roomtype.roomtypeId}" hidden>
                            <div class="row col-10">
                                <div class="col-2 form-group mb-3">
                                    <fieldset>
                                        <legend>Name</legend>
                                        <input type="text" id="update-roomtype-name" class="form-control roomtype-name" name="roomtypeName" 
                                               value="${roomtype.roomtypeName}" required>
                                    </fieldset>
                                </div>
                                <div class="col-2 form-group mb-3">
                                    <fieldset>
                                        <legend>Max Member</legend>
                                        <input required type="text" id="update-roomtype-maxmember" class="form-control" name="roomtypeMaxMember"
                                               value="${roomtype.roomtypeMaxMember}">
                                    </fieldset>
                                </div>
                                <div class="col-2 form-group mb-3">
                                    <fieldset>
                                        <legend>Cost ($/month)</legend>
                                        <input required type="text" id="update-roomtype-cost" class="form-control" name="roomtypeCost"
                                               value="${roomtype.roomtypeCost}">
                                    </fieldset>
                                </div>
                                <div class="col-2 form-group mb-3">
                                    <fieldset>
                                        <legend>Area (m<sup>2</sup>)</legend>
                                        <input required type="text" id="update-roomtype-area" class="form-control" name="roomtypeArea"
                                               value="${roomtype.roomtypeArea}">
                                    </fieldset>
                                </div>
                                <div class="col-2 form-group mb-3">
                                    <fieldset>
                                        <legend>Member </legend>
                                        <input type="text" class="form-control" name="roomtypeRoomQuantity"
                                               value="${roomtype.roomtypeRoomQuantity}" readonly>
                                    </fieldset>
                                </div>
                                <div class="col-2 d-flex justify-content-center align-items-center"
                                     style="padding-bottom: 8px">
                                    <input type="hidden" id="submitType" name="submitType">
                                    <button type="button" onclick="validateUpdateRoomtype()" class="btn btn-primary w-75" style="height: 47px">Save</button>
                                </div>
                            </div>
                            <div class="row col-2" style="margin: 0">
                                <div class="col-12 d-flex justify-content-center align-items-center"
                                     style="padding-bottom: 8px">
                                    <button type="button" data-bs-toggle="modal" data-bs-target="#modal-delete-roomtype" class="btn btn-danger w-75 " style="height: 47px;">Delete</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="room_img">

                    <figure>
                        <div id="edit-img" style="padding-left: 20px; display: none;">
                            <form action="update-img-roomtype" method="post" enctype="multipart/form-data">
                                <input type="file" name="file" lang="en" class="btn btn-dark-cus" size="60" required="">
                                <input type="text" id="roomtypeImgBannerId" name="roomtypeImgBannerId" hidden>
                                <input type="text" id="roomtypeIdImg" name="roomtypeIdImg" hidden>                                
                                <button type="submit" class="btn btn-dark-cus">Save</button>
                            </form>
                        </div>
                        <div>
                            <form id="delete-img-form" action="delete-img-roomtype" enctype="multipart/form-data">
                                <input type="file" name="file" lang="en" class="btn btn-dark-cus" size="60" required="" hidden>
                                <input type="text" id="roomtypeImgBannerIdDel" name="roomtypeImgBannerId" hidden> 
                                <input type="text" id="roomtypeIdImgDel" name="roomtypeIdImg" hidden> 
                            </form>
                        </div>
                        <div class="container">

                            <c:forEach items="${requestScope.roomtypeImgBanner}" var="roomtypeImgBanner" varStatus="i">
                                <div class="mySlides Slideroom">
                                    <div style="display: flex;">
                                        <div class="numbertext" style="color: black">${i.count}/ 6</div>
                                        <div class="icon-edit"><span id="button">
                                                <span onclick="hiddenFunction(${roomtypeImgBanner.roomtypeImgBannerId},${roomtypeImgBanner.roomtypeId})"><i
                                                        class="fa-solid fa-pen-to-square"></i></span></div>
                                        <div class="icon-delete">
                                            <span onclick="deleteImgFunction(${roomtypeImgBanner.roomtypeImgBannerId},${roomtypeImgBanner.roomtypeId})">
                                                <i class="fa-solid fa-xmark"></i></span></div>
                                    </div>
                                    <img src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%">
                                </div>
                            </c:forEach>



                            <!-- Next and previous buttons -->
                            <a class="prev-btn" onclick="plusSlides(-1)">&#10094;</a>
                            <a class="next-btn" onclick="plusSlides(1)">&#10095;</a>

                            <!-- Thumbnail images -->
                            <div class="row">
                                <c:forEach items="${requestScope.roomtypeImgBanner}" var="roomtypeImgBanner" varStatus="i">
                                    <div class="column">
                                        <img class="demo cursor slidemini" src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%"
                                             onclick="currentSlide(${i.count})" >
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </figure>

                </div>
            </div>
        </div>      

        <%@include file="component/modal/modal-delete-roomtype.jsp"%>                      
        <!---------------------------------------------JavaScript---------------------------------------------------------->
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>
        <script src="assets/js/roomtype.js"></script>
        <script src="assets/js/room-homepage.js"></script>
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
        <!---------------------------------------------HIDDEN UPDATE---------------------------------------------------------->
        <script>
            function hiddenFunction(roomtypeImgBannerId, roomtypeIdImg) {
                var x = document.getElementById("edit-img");
                if (x.style.display === "none") {
                    x.style.display = "block";
                    document.getElementById("roomtypeImgBannerId").value = roomtypeImgBannerId;
                    document.getElementById("roomtypeIdImg").value = roomtypeIdImg;
                } else {
                    x.style.display = "none";
                }
            }
        </script>
        <!---------------------------------------------DELETE BANNER---------------------------------------------------------->
        <script>
            function deleteImgFunction(roomtypeImgBannerId, roomtypeIdImg) {
                document.getElementById("roomtypeImgBannerIdDel").value = roomtypeImgBannerId;
                document.getElementById("roomtypeIdImgDel").value = roomtypeIdImg;
                document.getElementById("delete-img-form").submit();
            }
        </script>


    </body>
    <%
                request.getSession().removeAttribute("messageUpdate");
    %>

</html>