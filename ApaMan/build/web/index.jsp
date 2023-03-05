<%-- 
    Document   : index.jsp
    Created on : Jan 12, 2023, 12:37:43 AM
    Author     : DELL
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apaman</title>
    <link rel="icon" type="image/x-icon" href="assets/system/icons8-home-pulsar-color-32.png">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
    <link href="assets/css/index.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

    <div class="logo-index">
        <a href=""><img src="assets/images/logo.png"></a>
    </div>

    <div style="padding-bottom: 300px">

        <div id="change-search-select" <c:if test="${requestScope.selectType}">style="display: none"</c:if>>
                <div class="s01" >
                    <form action="#review" method="post">
                        <div class="inner-form">
                            <div class="input-select">
                                <select id="city" class="form-select" aria-label="Default select example" style="width: 330px" onchange="setAttrDistrict(value);">
                                    <option selected="selected" value="0" hidden>Choose one city</option>

                                <c:forEach items="${requestScope.cities}" var="city">
                                    <option <c:forEach items="${requestScope.districts}" var="district">
                                            <c:if test="${city.cityId eq district.cityId}">
                                                <c:if test="${district.districtId eq requestScope.districtId}">selected="selected"</c:if> </c:if>
                                        </c:forEach>
                                        value="${city.cityId}">${city.cityName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-select">
                            <select id="district" name="districtId" class="form-select" aria-label="Default select example" style="width: 330px" onchange="setAttrBtnSearch(value);">
                                <option selected="selected" value="0" hidden>Choose one district</option>
                                <c:forEach items="${requestScope.districts}" var="district">
                                    <option <c:if test="${district.districtId eq requestScope.districtId}">selected="selected"</c:if> data-cityId="${district.cityId}" value="${district.districtId}">${district.districtName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input hidden name="searchType" value="select" />
                        <button type="submit" class="btn btn-primary" id="btn-search">Search</button>
                        <span onclick="changeFunction()" style="color: #0d6efd; cursor: pointer"><i class="fa-solid fa-arrows-rotate fs-3"></i></a></span>
                        <span onclick="searchDistanceFromDevice();" style="color: #0d6efd; font-size: 18pt; cursor: pointer" title="Search within 10km radius"><i class="fa-solid fa-map-location"></i></span>
                    </div>
                </form>
            </div>
        </div>
        <form id="search-distance-from-device-form" action="#review" method="post" style="display: none">
            <input name="radius">
            <input name="latDevice">
            <input name="lonDevice">
            <input name="searchType" value="gps">
        </form>
        <div id="change-search-text" <c:if test="${requestScope.textType}">style="display: none"</c:if>>
                <div class="s01" >
                    <form action="#review" method="post">
                        <div class="inner-form">
                            <div class="input-select">
                                <input size="80" type="text" placeholder="Enter Keywords?" class="form-control" id="keyWord" name="keyWord" value="${requestScope.keyWord}" required/>
                        </div>
                        <input hidden name="searchType" value="text"  />
                        <button type="submit" class="btn btn-primary" id="btn-search">Search</button>
                        <span onclick="changeFunction()" style="color: #0d6efd; cursor: pointer"><i class="fa-solid fa-arrows-rotate fs-3"></i></span>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <c:if test="${requestScope.apartments == null}"> 
        <div style="margin-top: -300px; ">
            <div id="review" class="blog">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="titlepage">
                                <h2>TOP APARTMENT</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- comment: List Apartment -->
                        <c:forEach items="${requestScope.apartmentTop}" var="apartment">
                            <div class="col-md-4">
                                <div class="blog_box">
                                    <div class="blog_img">
                                        <figure>
                                            <a href="homepage?apartmentId=${apartment.apartmentId}"><img src="${apartment.apartmentImgAboutus}" alt="#" /></a>
                                        </figure>
                                    </div>
                                    <div class="blog_room" style="color: black;">
                                        <a href="homepage.html">
                                            <h3>${apartment.apartmentName}</h3>
                                        </a>
                                        <span>${apartment.apartmentAddress}</span>
                                        <p>${apartment.apartmentIntro}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <nav class="d-flex justify-content-end" aria-label="Page navigation exampl">
                        <ul class="pagination">
                            <li class="page-item <c:if test="${requestScope.curPage eq 1}">disabled</c:if>"><a class="page-link" href="?page=${requestScope.curPage -1}#review">Previous</a></li>
                            <c:forEach items="${requestScope.pages}" var="page">
                                <li class="page-item <c:if test="${requestScope.curPage eq page}">active</c:if>"><a class="page-link " href="?page=${page}#review">${page}</a></li>
                            </c:forEach>
                                <li class="page-item <c:if test="${requestScope.curPage eq requestScope.pages.size()}">disabled</c:if>"><a class="page-link" href="?page=${requestScope.curPage + 1}#review">Next</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${requestScope.apartments != null}"> 
        <div style="margin-top: -300px">
            <div id="review" class="blog">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="titlepage">
                                <h2>Result</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${requestScope.apartments.size() eq 0}">
                            <div class="col-md-12" style="margin-bottom: 100px">
                                <h1 class="text-info text-uppercase text-center fw-bolder">Not found any Apart in this location</h1>
                            </div>
                        </c:if>
                        <!-- comment: List Apartment -->
                        <c:forEach items="${requestScope.apartments}" var="apartment">
                            <div class="col-md-4">
                                <div class="blog_box">
                                    <div class="blog_img">
                                        <figure>
                                            <a href="homepage?apartmentId=${apartment.apartmentId}"><img src="${apartment.apartmentImgAboutus}" alt="#" /></a>
                                        </figure>
                                    </div>
                                    <div class="blog_room" style="color: black;">
                                        <a href="homepage?apartmentId=${apartment.apartmentId}">
                                            <h3>${apartment.apartmentName}</h3>
                                        </a>
                                        <span>${apartment.apartmentAddress}</span>
                                        <p>${apartment.apartmentIntro}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </c:if>


    <%@include file="component/common/footer.jsp" %>
    <script>
        let city = document.getElementById('city');
        let district = document.getElementById('district');
        let btnSearch = document.getElementById('btn-search');
        district.disabled = Number(city.value) === 0 ? true : false;
        btnSearch.disabled = Number(district.value) === 0 ? true : false;
        showDistrictByCity(city.value);

        function setAttrDistrict(cityValue) {
            district.disabled = Number(cityValue) === 0 ? true : false;
            district.options[0].selected = true;
            setAttrBtnSearch(district.options[0].value);
            showDistrictByCity(cityValue);
        }

        function showDistrictByCity(cityValue) {
            for (let i = 0; i < district.length; i++) {
                district.options[i].style.display = district.options[i].dataset.cityid === cityValue ? "block" : "none";
            }
        }

        function setAttrBtnSearch(districtValue) {
            btnSearch.disabled = Number(districtValue) === 0 ? true : false;
        }
    </script>

    <!---------------------------------------------CHANGE---------------------------------------------------------->
    <script>

        function changeFunction() {
            var x = document.getElementById("change-search-select");
            var y = document.getElementById("change-search-text");
            if (y.style.display === "none") {
                x.style.display = "none";
                y.style.display = "block";
            } else {
                x.style.display = "block";
                y.style.display = "none";
            }
        }

    </script>
    <!---------------------------------------------Search By GPS---------------------------------------------------------->
    <script>
        function searchDistanceFromDevice() {
            if (navigator.geolocation) { // if browser support geolocation api
                navigator.geolocation.getCurrentPosition(onSuccess, onError);
            } else {
                showToast('info', "Apaman Notification", "Your browser support geolocation");
            }
        }

        function onError() {
            showToast('warning', "Apaman Notification", "Can not get your location. Try again");
        }

        function onSuccess(position) {
            const {latitude, longitude} = position.coords; // getting lat and lon of the user device
            document.querySelector('#search-distance-from-device-form input:nth-of-type(1)').value = 10;
            document.querySelector('#search-distance-from-device-form input:nth-of-type(2)').value = latitude;
            document.querySelector('#search-distance-from-device-form input:nth-of-type(3)').value = longitude;
            document.getElementById('search-distance-from-device-form').submit();
        }
    </script>

</body>

</html>