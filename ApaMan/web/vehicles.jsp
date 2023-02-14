<%-- 
    Document   : vehicles
    Created on : Feb 13, 2023, 11:29:58 PM
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

                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">VEHICLE CONTROL</div>



                <div class="container-fluid pt-4 px-4" style="margin-bottom: 80px">
                    <div class="bg-secondary-cus rounded p-4">
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Vehicle Type</th>
                                    <th>License Plate</th>
                                    <th>Tenant Name</th>
                                    <th>Room Name</th>
                                    <th>Description</th>
                                    <th>Image</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${vehiclesAll}" var="vehicle" varStatus="i">
                                <tr>
                                    <td>${i.count}</td>
                                    <td>${vehicle.vehicleType.vehicleTypeName}</td>
                                    <td>${vehicle.vehicleLicensePlate}</td>
                                    <td>${vehicle.tenant.tenantName}</td>
                                    <td>${vehicle.room.roomName}</td>
                                    <td>${vehicle.vehicleDescription}</td>
                                    <td class="d-flex justify-content-between">
                                        <a href="${vehicle.vehicleImgPath}" class="a-none">Image</a>
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
