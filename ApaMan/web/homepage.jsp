<%-- 
    Document   : hompage.jsp
    Created on : Jan 12, 2023, 12:38:36 AM
    Author     : DELL
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Apaman</title>
        <link rel="icon" type="image/x-icon" href="assets/system/icons8-home-pulsar-color-32.png">

        <!-- bootstrap css -->
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">

        <!-- style css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" href="assets/css/hompage.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
        <!-- fevicon -->
        <link rel="icon" href="assets/images/fevicon.png" type="image/gif" />

        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
              media="screen">

        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">

    </head>
    <!-- body -->

    <body class="main-layout">

        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="header">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section ">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo" style="margin: 15px; ">
                                        <a href="/ApaMan">
                                            <img src="assets/images/logo.png" style="margin-left: -70px;" />
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                            <nav class="navigation navbar navbar-expand-md navbar-dark ">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04"
                                        aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarsExample04">
                                    <ul class="navbar-nav mr-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="#">Home</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#about">About</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#room">Room</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#service">Service</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#review">Review</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#contact">Contact Us</a>
                                        </li>
                                        <c:if test="${sessionScope.curAccount == null}">
                                            <li class="nav-item"><a class="nav-link" href="login?apartmentId=${requestScope.apartment.apartmentId}">Sign In</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.curAccount != null}">
                                            <li class="nav-item"><a class="nav-link" href="sign-out">Sign Out</a></li>
                                            <c:if test="${sessionScope.curAccount.role.roleId == 1}"><li class="nav-item"><a class="nav-link" href="admin">Menu</a></li></c:if>
                                        </c:if>

                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- end header inner -->
        <!-- end header -->
        <!-- banner -->
        <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">${requestScope.apartment.apartmentName}</div>
        <section>
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
                <div class="carousel-inner">
                    <c:forEach items="${apartmentImgBanners}" var="apartmentImgBanner" varStatus="i">
                        <div class="carousel-item <c:if test="${i.index eq 0}">active</c:if>">
                            <img style="height: 700px; object-fit: cover" src="${apartmentImgBanner.apartmentImgBannerPath}" class="d-block w-100" alt="...">
                        </div>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </section>
        <!-- end banner -->
        <!-- about -->
        <div id="about" class="about">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-5">
                        <div class="titlepage">
                            <h2>About Us</h2>
                            <div>${requestScope.apartment.apartmentContentAboutus}</div>

                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="about_img">
                            <figure><img src="${requestScope.apartment.apartmentImgAboutus}" alt="#" /></figure>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end about -->
        <!-- our_room -->
        <div id="room" class="our_room">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">
                            <h2> Room</h2>
                            <!-- <p>Lorem Ipsum available, but the majority have suffered </p> -->
                        </div>
                        <div class="controls row">
                            <div class="col-4">
                                <a href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#rooms"
                                   class="btn btn-secondary w-100">Tất Cả Các Phòng</a>
                            </div>
                            <div class="col-4">
                                <a href="javascript:void(0)" class="btn btn-secondary w-100">Các Phòng Còn Trống</a>
                            </div>
                            <div class="col-4">
                                <a href="javascript:void(0)" class="btn btn-secondary w-100">Đang Tìm Roommate</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="display: block;">
                    <c:forEach items="${requestScope.roomtypes}" var="roomtype" varStatus="i">
                        <c:if test="${i.count % 2 != 0}">
                            <div style="padding-top: 70px; padding-bottom: 50px; ">
                                <div class="col-md-12 col-sm-10" style="display: flex;">
                                    <div id="serv_hover" class="room col-md-6">
                                        <div class="room_img">

                                            <figure>
                                                <div class="container">

                                                    <c:forEach items="${requestScope.roomtypeImgBanners}" var="roomtypeImgBanner" varStatus="y">
                                                        <c:if test="${roomtypeImgBanner.roomtypeId eq roomtype.roomtypeId}">
                                                            <div class="mySlides Slideroom${i.count}">
                                                                <div class="numbertext">1 / 6</div>
                                                                <img src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%">
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>



                                                    <!-- Next and previous buttons -->
                                                    <a class="prev-btn a-none" onclick="plusSlides${i.count}(-1)">&#10094;</a>
                                                    <a class="next-btn a-none" onclick="plusSlides${i.count}(1)">&#10095;</a>



                                                    <!-- Thumbnail images -->
                                                    <div class="row">
                                                        <c:forEach items="${requestScope.roomtypeImgBanners}" var="roomtypeImgBanner" >
                                                            <c:if test="${roomtypeImgBanner.roomtypeId eq roomtype.roomtypeId}">
                                                                <div class="column">
                                                                    <img class="demo cursor slidemini${i.count}" src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%"
                                                                         onclick="currentSlide${i.count}(1)" >
                                                                </div>
                                                            </c:if>
                                                        </c:forEach>

                                                    </div>
                                                </div>
                                            </figure>

                                        </div>

                                    </div>
                                    <div class="col-md-1"></div>
                                    <div class="col-md-5">
                                        <div class="detailroom">
                                            <p style="font-size: 16pt;">
                                                <b>Roomtype detail</b>
                                                <br>
                                                <br>
                                                Roomtype name: ${roomtype.roomtypeName}
                                                <br>
                                                Roomtype max member: ${roomtype.roomtypeMaxMember}
                                                <br>
                                                Roomtype area: ${roomtype.roomtypeArea}
                                                <br> 
                                                roomtype cost: ${roomtype.roomtypeCost}
                                            </p>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <br>
                        <c:if test="${i.count % 2 == 0}">
                            <div style="padding-top: 70px; padding-bottom: 50px; ">
                                <div class="col-md-12 col-sm-10" style="display: flex;">

                                    <div class="col-md-5">
                                        <div class="detailroom">
                                            <p style="font-size: 16pt;">
                                                <b>Roomtype detail</b>
                                                <br>
                                                <br>
                                                Roomtype name: ${roomtype.roomtypeName}
                                                <br>
                                                Roomtype max member: ${roomtype.roomtypeMaxMember}
                                                <br>
                                                Roomtype area: ${roomtype.roomtypeArea}
                                                <br> 
                                                roomtype cost: ${roomtype.roomtypeCost}
                                            </p>

                                        </div>
                                    </div>
                                    <div class="col-md-1"></div>
                                    <div id="serv_hover" class="room col-md-6">
                                        <div class="room_img">
                                            <figure>
                                                <div class="container">

                                                    <c:forEach items="${requestScope.roomtypeImgBanners}" var="roomtypeImgBanner" varStatus="y">
                                                        <c:if test="${roomtypeImgBanner.roomtypeId eq roomtype.roomtypeId}">
                                                            <div class="mySlides Slideroom${i.count}">
                                                                <div class="numbertext">${y.count} / 6</div>
                                                                <img src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%">
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>

                                                    <!-- Next and previous buttons -->
                                                    <a class="prev-btn a-none" onclick="plusSlides${i.count}(-1)">&#10094;</a>
                                                    <a class="next-btn a-none" onclick="plusSlides${i.count}(1)">&#10095;</a>


                                                    <!-- Thumbnail images -->
                                                    <div class="row">
                                                        <c:forEach items="${requestScope.roomtypeImgBanners}" var="roomtypeImgBanner">
                                                            <c:if test="${roomtypeImgBanner.roomtypeId eq roomtype.roomtypeId}">
                                                                <div class="column">
                                                                    <img class="demo cursor slidemini${i.count}" src="${roomtypeImgBanner.roomtypeImgBannerPath}" style="width:100%"
                                                                         onclick="currentSlide${i.count}(1)">
                                                                </div>
                                                            </c:if>

                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </figure>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </c:if>
                        <br>

                    </c:forEach>

                    <span id="nothing"></span>
                    <span id="showmore" style="display: none;">

                        <div style="padding-top: 70px; padding-bottom: 50px; ">
                            <h1>Hello</h1>
                        </div>

                    </span>


                    <div style="text-align: center; margin-bottom: 50px;">
                        <a class="read_more a-none" onclick="viewNoreRoom()" id="buttonviewmoreroom"> Read more</a>
                    </div>

                </div>
            </div>
        </div>
        <!-- end our_room -->
        <!-- gallery -->
        <div id="service" class="gallery mb-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-15">
                        <div class="titlepage">
                            <h2>Service</h2>
                        </div>
                    </div>
                </div>
                <div>${requestScope.apartment.apartmentContentService}</div>
            </div>
        </div>
        <!-- end gallery -->
        <!-- review -->
        <div id="review" class="contain_review">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">
                            <h2>Customer reviews</h2>
                            <p>We always put the customer experience first</p>
                        </div>
                    </div>
                </div>
            </div>
            <div id="review" class="contain_wrapper">
                <div class="wrapper">
                    <i id="left" class="previcon">🔙</i>
                    <div class="carousel_rv">
                        <!-- start review-->
                        <div class="blog">
                            <div class="container">
                                <div class="review">
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời, cam on rat nhieu</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog2.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Phan Tan Trung</h3>
                                            <span>Room B204</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog3.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Tran Van Hai</h3>
                                            <span>Room A123</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog3.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Tran Van Hai</h3>
                                            <span>Room A123</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                    <div class="blog_box">
                                        <div class="blog_img">
                                            <figure><img src="assets/images/blog1.jpg" alt="#" /></figure>
                                        </div>
                                        <div class="blog_room">
                                            <h3>Truong Tuan Tu</h3>
                                            <span>Room A101</span>
                                            <p>Trải nghiệm của tôi tại đây là trên cả tuyệt vời</p>
                                            <h4>⭐⭐⭐⭐⭐</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end review-->
                    </div>
                    <i id="right" class="nexticon">🔜</i>
                </div>
            </div>
        </div>
        <!-- end review -->

        <!--  contact -->
        <div id="contact" class="contact mb-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">
                            <h2>Contact Us</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <form id="request" class="main_form">
                            <div class="row">
                                <div class="col-md-12 ">
                                    <input class="contactus" placeholder="Name" type="type" name="Name">
                                </div>
                                <div class="col-md-12">
                                    <input class="contactus" placeholder="Email" type="type" name="Email">
                                </div>
                                <div class="col-md-12">
                                    <input class="contactus" placeholder="Phone Number" type="type" name="Phone Number">
                                </div>
                                <div class="col-md-12">
                                    <textarea class="textarea" placeholder="Message" type="type" Message="Name"></textarea>
                                </div>
                                <div class="col-md-12">
                                    <button class="send_btn">Send</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <div class="map_main">
                            <div class="map-responsive">
                                <iframe src="https://maps.google.com/maps?q=+${requestScope.apartment.apartmentLat}+,+${requestScope.apartment.apartmentLon}+&hl=en&z=14&amp;output=embed" width="100%" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="recruitment" class="contain_review pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">
                            <h2>Staff Recruitment</h2>
                        </div>
                    </div>
                </div>
                <div>${requestScope.apartment.apartmentContentRecruitment}</div>
            </div>
        </div>
        <!-- end contact -->
        <!--  footer -->
        <%@include file="component/common/footer.jsp" %>

        <!--Modal-->
        <!--Room-->
        <div class="modal fade" id="rooms" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-hidden="true" style="margin-top: 5px;">
            <div class="modal-dialog modal-xl">
                <div class="modal-content bg-secondary-cus">
                    <div class="rounded my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index.html" class="">
                                <h3 class="text-primary-cus">Phenika Apartment</h3>
                            </a>
                            <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark"></i></a>
                        </div>
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tầng</th>
                                    <th>Phòng</th>
                                    <th>Loại Phòng</th>
                                    <th>Trạng Thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                                <tr>
                                    <td>#00001</td>
                                    <td>Tầng 1</td>
                                    <td>105</td>
                                    <td>LP2</td>
                                    <td>Trống</td>
                                </tr>
                            </tbody>
                        </table>

                        <!-- </div> -->
                        <!-- <div class="row">
                           <div class="col-12">
                              <button type="submit" class="btn btn-danger py-3 w-100 mb-4" data-bs-dismiss="modal">Đóng</button>
                           </div>
                        </div> -->
                    </div>
                </div>
            </div>

        </div>
        <!--EndRoom-->
        <!-- end footer -->
        <!-- Javascript files-->
        <c:forEach items="${requestScope.roomtypes}" var="roomtype" varStatus="i">
            <script >
                let slideIndex${i.count} = 1;
                showSlides${i.count}(slideIndex${i.count});

                // Next/previous controls
                function plusSlides${i.count}(n) {
                    showSlides${i.count}(slideIndex${i.count} += n);
                }

                // Thumbnail image controls
                function currentSlide${i.count}(n) {
                    showSlides${i.count}(slideIndex${i.count} = n);
                }

                function showSlides${i.count}(n) {
                    let i;
                    let slides = document.getElementsByClassName("Slideroom${i.count}");
                    let dots = document.getElementsByClassName("slidemini${i.count}");
                    if (n > slides.length) {
                        slideIndex${i.count} = 1;
                    }
                    if (n < 1) {
                        slideIndex${i.count} = slides.length;
                    }
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" active", "");
                    }
                    slides[slideIndex${i.count} - 1].style.display = "block";
                    dots[slideIndex${i.count} - 1].className += " active";
                }


            </script>
        </c:forEach>
        <script src="assets/js/viewmore-room-hompage.js"></script>
        <script src="assets/js/review-homepage.js"></script>


        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script>$(document).ready(function () {
                    $('#example').DataTable();
                });</script>
    </body>

</html>