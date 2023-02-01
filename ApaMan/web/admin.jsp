<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Motel</title>
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" href="assets/css/admin.css">
        <link rel="stylesheet" href="assets/css/switch-toggle-btn.css">
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
        <style>
            .box-account select{
                color: white;
            }

            .box-account label{
                color: wheat;
            }

            .box-account #example_info {
                color: wheat !important;
            }

            .box-account #example_paginate {
                color: wheat !important;
            }


        </style>
    </head>

    <body>
        <div class="toast-container position-fixed top-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            </div>
        </div>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Sidebar Start -->
            <div class="sidebar pe-4 pb-3">
                <nav class="navbar navbar-dark">
                    <a href="menu.html" class="navbar-brand ms-4 mb-3 text-primary-cus" style="font-size: 32px; color: red;">
                        <h3><i class="fa-solid fa-user-pen"></i>Apaman</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="assets/images/1.png" alt="" style="width: 40px; height: 40px;">
                        </div>
                        <div class="ms-2 text-white">
                            <h6 class="mb-0">Quy Quoc</h6>
                            <span>Admin</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <a href="admin" class="nav-item nav-link active"><i class="fa-solid fa-street-view me-2"></i>Host Acc</a>
                        <a href="sign-out" class="nav-item nav-link"><i class="fa-solid fa-right-from-bracket me-2"></i>Sign Out</a>
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->
            <div class="content">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->
                <div class="container-fluid pt-4 px-4">
                    <form action="admin" method="post"> <!-- form add account host -->
                        <h2 class="text-wheat">Add One Account For Host Apartment</h2>
                        <div class="row">
                            <div class="col-7">
                                <div class="row panel-form mx-0">
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Username</legend>
                                            <input type="text" class="form-control" name="accountUsername" placeholder="username" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Password</legend>
                                            <input type="text" class="form-control" name="accountPassword" placeholder="password" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Apartment Name</legend>
                                            <input type="text" class="form-control" name="apartmentName" placeholder="apartment name" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Host Name</legend>
                                            <input type="text" class="form-control" name="hostName" placeholder="host name" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Mobile</legend>
                                            <input type="text" class="form-control" name="hostMobile" placeholder="phone number" required>
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Create date</legend>
                                            <input id="currentDate" type="text" class="form-control" name="apartmentHostPhone" value="asd" readonly="">
                                        </fieldset>
                                    </div>
                                    <div class="col-12 form-group mb-3">
                                        <fieldset>
                                            <legend>Address</legend>
                                            <input type="text" class="form-control" name="apartmentAddress" placeholder="address" required>
                                        </fieldset>
                                    </div>

                                    <div class="select-field" style="display: flex;width: 100%; margin-bottom: 20px">
                                        <div class="input-select" style="width: 49%; margin-right: 4%">
                                            <select id="city" class="form-select" aria-label="Default select example" style="color: white; background-color: #191C24" onchange="setAttrDistrict(value);" required>
                                                <option selected="selected" value="0">Choose one city</option>
                                                <c:forEach items="${requestScope.listCity}" var="city">
                                                    <option <c:if test="${city.cityId eq requestScope.districtId}">selected="selected"</c:if> value="${city.cityId}">${city.cityName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="input-select" style="width: 49%">
                                            <select id="district" name="districtId" class="form-select" aria-label="Default select example" style="color: white; background-color: #191C24" onchange="setAttrBtnSearch(value);" required>
                                                <option selected="selected" value="0">Choose one district</option>
                                                <c:forEach items="${requestScope.listDistrict}" var="district">
                                                    <option <c:if test="${district.districtId eq requestScope.districtId}">selected="selected"</c:if> data-cityId="${district.cityId}" value="${district.districtId}">${district.districtName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>
                                    <button class="btn btn-primary" type="submit">Save</button>
                                </div>
                            </div>
                            <div class="col-5">
                                <div id="map" class="w-100 h-100">
                                    <div class="form-group" style="height: 18%">
                                        <fieldset >
                                            <legend>Search location</legend>
                                            <input id="map-search" type="text" class="form-control controls"
                                                   placeholder="Address" >
                                        </fieldset>
                                    </div>
                                    <!-- <iframe class="w-100 h-50"> -->
                                    <div id="map-canvas" style="height: 82%; width: 100%; border-radius:12px"></div>

                                    <!-- </iframe> -->
                                    <br>
                                    <div style="display: flex;">
                                        <input type="text" class="form-control latitude" name="apartmentLat" placeholder="Lat" readonly hidden required>
                                        <input type="text" class="form-control longitude" name="apartmentLong" placeholder="Long" readonly hidden required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <hr class="mb-5" style="color: aqua;">
                    <h2 class="text-wheat">Account Host Apartment</h2>  <!-- display apartment -->
                    <br>

                    <div style="background-color: #191C24; color: white;border-radius:0.375rem; padding: 20px;" class="box-account">
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>User Name</th>
                                    <th>Apartment Name</th>
                                    <th>Account Accessible</th>
                                    <th>Apartment Accessible</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.listApartment}" var="apartment" >
                                    <c:forEach items="${requestScope.listHostAccount}" var="hostAccount" >
                                        <c:if test="${hostAccount.apartmentId eq apartment.apartmentId}" >
                                            <tr>
                                                <td class="text-info">${hostAccount.accountUsername}</td>
                                                <td>${apartment.apartmentName}</td>
                                                <td>
                                                    <c:if test="${hostAccount.accountAccessible}"><i class="fa-solid fa-check text-success"></i></c:if>
                                                    <c:if test="${!hostAccount.accountAccessible}"><i class="fa-solid fa-xmark text-danger"></i></c:if>
                                                </td>
                                                <td>
                                                    <c:if test="${apartment.apartmentAccessible}"><i class="fa-solid fa-check text-success"></i></c:if>
                                                    <c:if test="${!apartment.apartmentAccessible}"><i class="fa-solid fa-xmark text-danger"></i></c:if>
                                                </td>
                                                <td><a href="host-apartment-detail?accountId=${hostAccount.accountId}"><i class="fa-solid fa-pen-to-square text-danger"></i></a></td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>  


                </div>
                <hr class="mb-5" >
            </div>
        </div>

        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>
        <script>
                                                let city = document.getElementById('city');
                                                let district = document.getElementById('district');
                                                district.disabled = Number(city.value) === 0 ? true : false;
                                                showDistrictByCity(city.value);

                                                function setAttrDistrict(cityValue) {
                                                    district.disabled = Number(cityValue) === 0 ? true : false;
                                                    district.options[0].selected = true;
                                                    showDistrictByCity(cityValue);
                                                }

                                                function showDistrictByCity(cityValue) {
                                                    for (let i = 0; i < district.length; i++) {
                                                        district.options[i].style.display = district.options[i].dataset.cityid === cityValue ? "block" : "none";
                                                    }
                                                }
        </script>

        <script>
            let date = new Date().toLocaleDateString();
            document.getElementById("currentDate").value = date;
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
    <script src="assets/js/map.js"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2LlIj3sk2akFpnpNcXzX9_NS08Xda1sE&libraries=places&callback=initialize"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    <script>$(document).ready(function () {
                $('#example').DataTable();
            });</script>

    <%
        request.getSession().removeAttribute("messageUpdate");
    %>
</html>