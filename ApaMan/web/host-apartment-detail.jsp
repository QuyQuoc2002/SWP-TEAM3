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
                    <a href="menu.html" class="navbar-brand ms-4 mb-3 text-primary-cus" style="font-size: 32px;">
                        <h3><i class="fa-solid fa-user-pen"></i>Apaman</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="assets/images/1.png" alt="" style="width: 40px; height: 40px;">
                        </div>
                        <div class="ms-2 text-white">
                            <h6 class="mb-0">Admin</h6>
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
                <div id="staff" class="container-fluid pt-4 px-4">


                    <hr class="mb-5" >
                    <h2 class="text-wheat">Account Host Apartment</h2>  <!-- display apartment -->

                    <form id="hostAccountForm" action="host-apartment-detail" method="post">
                        <div class="row" style="margin-bottom: 20px">                        
                            <div class="col-7">
                                <div class="row panel-form mx-0">
                                    <input type="text" name="apartmentId" placeholder="apartmentId" value="${requestScope.hostAccount.apartmentId}" readonly hidden>
                                    <input type="text" name="accountId" placeholder="accountId" value="${requestScope.hostAccount.accountId}" readonly hidden>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Username</legend>
                                            <input id="accountUsername" type="text" class="form-control" name="accountUsername" value="${requestScope.hostAccount.accountUsername}">
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Password</legend>
                                            <input id="accountPassword" type="text" class="form-control" name="accountPassword" value="${requestScope.hostAccount.accountPassword}">
                                        </fieldset>
                                    </div>

                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Apartment Name</legend>
                                            <input id="apartmentName" type="text" class="form-control" name="apartmentName" value="${requestScope.apartment.apartmentName}">
                                        </fieldset>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Host Name</legend>
                                            <input id="hostName" type="text" class="form-control" name="hostName" value="${requestScope.apartment.hostName}">
                                        </fieldset>
                                    </div>    
                                    <div class="col-6 form-group mb-3">
                                        <fieldset>
                                            <legend>Mobile</legend>
                                            <input id="hostMobile" type="text" class="form-control" name="hostMobile" value="${requestScope.apartment.hostMobile}">
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
                                            <input id="apartmentAddress" type="text" class="form-control" name="apartmentAddress" value="${requestScope.apartment.apartmentAddress}">
                                        </fieldset>
                                    </div>


                                    <div class="select-field" style="display: flex;width: 100%; margin-bottom: 20px">
                                        <div class="input-select" style="width: 49%; margin-right: 4%">
                                            <select id="city" class="form-select" aria-label="Default select example" style="color: white; background-color: #191C24" onchange="setAttrDistrict(value);">
                                                <option selected="selected" value="0">Choose one city</option>
                                                <c:forEach items="${requestScope.listCity}" var="city">
                                                    <option <c:forEach items="${requestScope.listDistrict}" var="district">
                                                            <c:if test="${city.cityId eq district.cityId}">
                                                                <c:if test="${district.districtId eq requestScope.apartment.districtId}">selected="selected"</c:if> </c:if>
                                                        </c:forEach>
                                                        value="${city.cityId}">${city.cityName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="input-select" style="width: 49%">
                                            <select id="district" name="districtId" class="form-select" aria-label="Default select example" style="color: white; background-color: #191C24" onchange="setAttrBtnSearch(value);">
                                                <option selected="selected" value="0">Choose one district</option>
                                                <c:forEach items="${requestScope.listDistrict}" var="district">
                                                    <option <c:if test="${district.districtId eq requestScope.apartment.districtId}">selected="selected"</c:if> data-cityId="${district.cityId}" value="${district.districtId}">${district.districtName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <a href="homepage.html" class="btn btn-secondary w-100"
                                           style="border-radius: 12px; color: bisque;">Homepage</a>
                                    </div>
                                    <div class="col-6 form-group mb-3">
                                        <a href="menu.html" class="btn btn-secondary w-100"
                                           style="border-radius: 12px; color: bisque;">Dashboard</a>
                                    </div>
                                    <div class="col-6 mb-3 d-flex">
                                        <label class="switch">
                                            <input type="checkbox" name="accountAccessible"  <c:if test="${requestScope.hostAccount.accountAccessible}">checked</c:if>>
                                            <span class="slider round"></span>true
                                        </label>
                                        <h5 class="text-white ms-3" style="line-height: 34px;">Active Account</h5>
                                    </div>
                                    <div class="col-6 mb-3 d-flex">
                                        <label class="switch">
                                            <input type="checkbox" name="apartmentAccessible" <c:if test="${requestScope.apartment.apartmentAccessible}">checked</c:if> >
                                            <span class="slider round"></span>
                                        </label>
                                        <h5 class="text-white ms-3" style="line-height: 34px;">Active Apartment</h5>
                                    </div>
                                    <div class="col-6 mb-3 d-flex">
                                        <input id="submitType" type="hidden" name="submitType">
                                        <button class="btn btn-primary w-100" type="button" onclick="validateHostInfo();">Save</button>
                                    </div>
                                    <div class="col-6 mb-3 d-flex">
                                        <button class="btn btn-danger w-100" type="submit" name="submitType" value="Delete">Delete</button>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-5">
                                <div id="map" class="w-100 h-100">
                                    <div class="form-group" style="height: 15%">
                                        <fieldset >
                                            <legend>Search location</legend>
                                            <input id="map-search" type="text" class="form-control controls"
                                                   placeholder="Address" >
                                        </fieldset>
                                    </div>
                                    <!-- <iframe class="w-100 h-50"> -->
                                    <div id="map-canvas" style="height: 85%; width: 100%; border-radius:12px"></div>

                                    <!-- </iframe> -->
                                    <br>
                                    <div style="display: flex;">
                                        <input type="text" class="form-control latitude" name="apartmentLat" placeholder="Lat" readonly hidden value="${requestScope.apartment.apartmentLat}">
                                        <input type="text" class="form-control longitude" name="apartmentLong" placeholder="Long" readonly hidden value="${requestScope.apartment.apartmentLon}">

                                    </div>

                                </div>
                            </div>

                        </div>
                    </form>                                                       
                </div>
            </div>
        </div>
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>   
        <script src="assets/js/validate.js"></script>          
          
        <!---------------------------------------------SHOW TOAST---------------------------------------------------------->
        <script>
            const messageUpdate = '<%= session.getAttribute("messageUpdate") %>';
            if (messageUpdate !== 'null') {
                const words = messageUpdate.split("|");
                showToast(words[0], words[1], words[2]);
            }
        </script>      
         
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
            function initialize() {

                var mapOptions, map, marker, searchBox, city,
                        infoWindow = '',
                        addressEl = document.querySelector('#map-search'),
                        latEl = document.querySelector('.latitude'),
                        longEl = document.querySelector('.longitude'),
                        element = document.getElementById('map-canvas');
                city = document.querySelector('.reg-input-city');

                mapOptions = {

                    zoom: 15,
                    center: new google.maps.LatLng(${requestScope.apartment.apartmentLat}, ${requestScope.apartment.apartmentLon}),

                    disableDefaultUI: false,
                    scrollWheel: true,
                    draggable: true,

                };


                // Create an object map with the constructor function Map()
                map = new google.maps.Map(element, mapOptions);


                // Creates the marker on the map

                marker = new google.maps.Marker({
                    position: mapOptions.center,
                    map: map,
                    draggable: true
                });


                // Creates a search box

                searchBox = new google.maps.places.SearchBox(addressEl);


                google.maps.event.addListener(searchBox, 'places_changed', function () {
                    var places = searchBox.getPlaces(),
                            bounds = new google.maps.LatLngBounds(),
                            i, place, lat, long, resultArray,
                            addresss = places[0].formatted_address;

                    for (i = 0; place = places[i]; i++) {
                        bounds.extend(place.geometry.location);
                        marker.setPosition(place.geometry.location);
                    }

                    map.fitBounds(bounds);
                    map.setZoom(15);


                    lat = marker.getPosition().lat();
                    long = marker.getPosition().lng();

                    console.log(lat);
                    console.log(long);

                    latEl.value = lat;
                    longEl.value = long;

                    resultArray = places[0].address_components;


                    // Closes the previous info window if it already exists
                    if (infoWindow) {
                        infoWindow.close();
                    }

                    infoWindow = new google.maps.InfoWindow({
                        content: addresss
                    });

                    infoWindow.open(map, marker);
                });

                google.maps.event.addListener(marker, "dragend", function (event) {
                    var lat, long, address, resultArray, citi;


                    lat = marker.getPosition().lat();
                    long = marker.getPosition().lng();

                    console.log(lat);
                    console.log(long);


                    var geocoder = new google.maps.Geocoder();
                    geocoder.geocode({latLng: marker.getPosition()}, function (result, status) {
                        if ('OK' === status) {  // == if ( status == google.maps.GeocoderStatus.OK ) {
                            address = result[0].formatted_address;
                            resultArray = result[0].address_components;

                            addressEl.value = address;
                            latEl.value = lat;
                            longEl.value = long;

                        } else {
                            console.log('Geocode was not successful for the following reason: ' + status);
                        }


                        if (infoWindow) {
                            infoWindow.close();
                        }

                        infoWindow = new google.maps.InfoWindow({
                            content: address
                        });

                        infoWindow.open(map, marker);
                    });
                });


            }
        </script>

    </body>
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