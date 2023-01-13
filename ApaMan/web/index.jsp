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
    <title>Search</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
    <link href="assets/css/index.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

    <div class="logo-index">
        <div><img src="assets/images/logo.png"></div>
    </div>

    <div class="s01">

        <form>
            <div class="inner-form">
                <div class="input-select">
                        <select id="city" class="form-select" aria-label="Default select example" style="width: 330px" onchange="setAttrDistrict(value);">
                        <option selected="selected" value="0">Choose one city</option>
                        <c:forEach items="${requestScope.cities}" var="city">
                            <option value="${city.cityId}">${city.cityName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-select">
                    <select id="district" class="form-select" aria-label="Default select example" style="width: 330px" onchange="setAttrBtnSearch(value);">
                        <option selected="selected" value="0">Choose one district</option>
                        <c:forEach items="${requestScope.districts}" var="district">
                            <option data-cityId="${district.cityId}" value="${district.districtId}">${district.districtName}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="button" class="btn btn-primary" id="btn-search">Search</button>
            </div>
        </form>
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
                <div class="col-md-4">
                    <div class="blog_box">
                        <div class="blog_img">
                            <figure>
                                <a href="homepage?apartmentId=1"><img src="assets/images/blog1.jpg" alt="#" /></a>
                            </figure>
                        </div>
                        <div class="blog_room">
                            <a href="homepage.html">
                                <h3>Tuan Cuong</h3>
                            </a>
                            <span>Thon 3</span>
                            <p>Our hostel is fully equipped!</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="blog_box">
                        <div class="blog_img">
                            <figure>
                                <a href="homepage.html"><img src="assets/images/blog2.jpg" alt="#" /></a>
                            </figure>
                        </div>
                        <div class="blog_room">
                            <a href="homepage.html">
                                <h3>Mai Anh</h3>
                            </a>
                            <span>Thon 8</span>
                            <p>Our hostel is fully equipped!</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="blog_box">
                        <div class="blog_img">
                            <figure><a href="homepage.html"><img src="assets/images/blog3.jpg" alt="#" /></a></figure>
                        </div>
                        <div class="blog_room">
                            <a href="homepage.html">
                                <h3>Bao Tram</h3>
                            </a>
                            <span>Thon 2</span>
                            <p>Our hostel is fully equipped!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        let city = document.getElementById('city');
        let district = document.getElementById('district');
        let btnSearch = document.getElementById('btn-search');
        district.disabled = Number(city.value) === 0 ? true : false;
        btnSearch.disabled = Number(district.value) === 0 ? true : false;
        
        function setAttrDistrict(cityValue) {
            district.disabled = Number(cityValue) === 0 ? true : false;
            district.options[0].selected = true ;
            setAttrBtnSearch(district.options[0].value);
            for (let i = 0; i < district.length; i++) {
                district.options[i].style.display = district.options[i].dataset.cityid === cityValue ? "block" : "none";
            }
        }
        
        function setAttrBtnSearch(districtValue) {
            btnSearch.disabled = Number(districtValue) === 0 ? true : false;
        }
        
        
    </script>
</body>

</html>