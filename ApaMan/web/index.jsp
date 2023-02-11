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


    <div id="change-search-select">
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
                    <input hidden name="searchType" value="select"  />
                    <button type="submit" class="btn btn-primary" id="btn-search">Search</button>
                    <span onclick="changeFunction()" style="color: #0d6efd"><i class="fa-solid fa-arrows-rotate fs-3"></i></a></span>
                </div>
            </form>
        </div>
    </div>


    <div id="change-search-text" style="display: none">
        <div class="s01" >
            <form action="#review" method="post">
                <div class="inner-form">
                    <div class="input-select">
                        <input size="80" type="text" placeholder="Enter Keywords?" class="form-control" name="keyWord" value="${requestScope.keyWord}"/>
                    </div>
                    <input hidden name="searchType" value="text"  />
                    <button type="submit" class="btn btn-primary" id="btn-search">Search</button>
                    <span onclick="changeFunction()" style="color: #0d6efd"><i class="fa-solid fa-arrows-rotate fs-3"></i></span>
                </div>

            </form>
        </div>
    </div>

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
                    <div class="col-md-12">
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
        </div>
    </div>
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
            if (x.style.display === "block") {
                x.style.display = "none";
                y.style.display = "block";
            } else {
                x.style.display = "block";
                y.style.display = "none";
            }
        }
    </script>

</body>

</html>