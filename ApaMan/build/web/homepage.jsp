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
        <title>ABC Motel</title>

        <!-- bootstrap css -->
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">

        <!-- style css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" href="assets/css/hompage.css">
        <link rel="stylesheet" href="assets/css/table.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
        <!-- <link rel="stylesheet" href="assets/css/banner-hompage.css">
        <link rel="stylesheet" href="assets/css/room-homepage.css">
        <link rel="stylesheet" href="assets/css/review-homepage.css"> -->

        <!-- Responsive-->
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="assets/images/fevicon.png" type="image/gif" />

        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
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
                                            <a class="nav-link" href="#room">Our room</a>
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
                            <img style="height: 500px; object-fit: cover" src="${apartmentImgBanner.apartmentImgBannerPath}" class="d-block w-100" alt="...">
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
                    <div style="padding-top: 70px; padding-bottom: 50px; ">
                        <div class="col-md-12 col-sm-10" style="display: flex;">
                            <div id="serv_hover" class="room col-md-6">
                                <div class="room_img">

                                    <figure>
                                        <div class="container">

                                            <!-- Full-width images with number text -->
                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">1 / 6</div>
                                                <img src="assets/images/about.png" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">2 / 6</div>
                                                <img src="assets/images/banner1.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">3 / 6</div>
                                                <img src="assets/images/banner2.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">4 / 6</div>
                                                <img src="assets/images/banner3.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">5 / 6</div>
                                                <img src="assets/images/blog_bg.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom1">
                                                <div class="numbertext">6 / 6</div>
                                                <img src="assets/images/gallery1.jpg" style="width:100%">
                                            </div>

                                            <!-- Next and previous buttons -->
                                            <a class="prev-btn" onclick="plusSlides(-1)">&#10094;</a>
                                            <a class="next-btn" onclick="plusSlides(1)">&#10095;</a>

                                            <!-- Image text -->
                                            <div class="caption-container">
                                                <!-- <p id="caption"></p> -->
                                            </div>

                                            <!-- Thumbnail images -->
                                            <div class="row">
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/about.png" style="width:100%"
                                                         onclick="currentSlide(1)" alt="The Woods">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/banner1.jpg"
                                                         style="width:100%" onclick="currentSlide(2)" alt="Cinque Terre">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/banner2.jpg"
                                                         style="width:100%" onclick="currentSlide(3)" alt="Mountains and fjords">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/banner3.jpg"
                                                         style="width:100%" onclick="currentSlide(4)" alt="Northern Lights">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/blog1.jpg" style="width:100%"
                                                         onclick="currentSlide(5)" alt="Nature and sunrise">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini1" src="assets/images/blog2.jpg" style="width:100%"
                                                         onclick="currentSlide(6)" alt="Snowy Mountains">
                                                </div>

                                            </div>
                                        </div>
                                    </figure>

                                </div>

                            </div>
                            <div class="col-md-1"></div>
                            <div class="col-md-5">
                                <div class="detailroom">
                                    <p style="font-size: 16pt;">
                                        <b>Room detail</b>
                                        <br>
                                        <br>
                                        Room name: A103
                                        <br>
                                        Type room: LP1
                                        <br>
                                        Room status: full
                                        <br>
                                        Room description: ..
                                    </p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div style="padding-top: 70px; padding-bottom: 50px; ">
                        <div class="col-md-12 col-sm-10" style="display: flex;">

                            <div class="col-md-5">
                                <div class="detailroom">
                                    <p style="font-size: 16pt;">
                                        <b>Room detail</b>
                                        <br>
                                        <br>
                                        Room name: A101
                                        <br>
                                        Type room: 2 people
                                        <br>
                                        Room status: Not ordered yet
                                        <br>
                                        Room description: ..
                                    </p>

                                </div>
                            </div>
                            <div class="col-md-1"></div>
                            <div id="serv_hover" class="room col-md-6">
                                <div class="room_img">
                                    <figure>
                                        <div class="container">

                                            <!-- Full-width images with number text -->
                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">1 / 6</div>
                                                <img src="assets/images/about.png" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">2 / 6</div>
                                                <img src="assets/images/banner1.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">3 / 6</div>
                                                <img src="assets/images/banner2.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">4 / 6</div>
                                                <img src="assets/images/banner3.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">5 / 6</div>
                                                <img src="assets/images/blog_bg.jpg" style="width:100%">
                                            </div>

                                            <div class="mySlides Slideroom2">
                                                <div class="numbertext">6 / 6</div>
                                                <img src="assets/images/gallery1.jpg" style="width:100%">
                                            </div>

                                            <!-- Next and previous buttons -->
                                            <a class="prev-btn" onclick="plusSlides2(-1)">&#10094;</a>
                                            <a class="next-btn" onclick="plusSlides2(1)">&#10095;</a>

                                            <!-- Image text -->
                                            <div class="caption-container">
                                                <!-- <p id="caption"></p> -->
                                            </div>

                                            <!-- Thumbnail images -->
                                            <div class="row">
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/about.png" style="width:100%"
                                                         onclick="currentSlide2(1)" alt="The Woods">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/banner1.jpg"
                                                         style="width:100%" onclick="currentSlide2(2)" alt="Cinque Terre">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/banner2.jpg"
                                                         style="width:100%" onclick="currentSlide2(3)" alt="Mountains and fjords">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/banner3.jpg"
                                                         style="width:100%" onclick="currentSlide2(4)" alt="Northern Lights">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/blog1.jpg" style="width:100%"
                                                         onclick="currentSlide2(5)" alt="Nature and sunrise">
                                                </div>
                                                <div class="column">
                                                    <img class="demo cursor slidemini2" src="assets/images/blog2.jpg" style="width:100%"
                                                         onclick="currentSlide2(6)" alt="Snowy Mountains">
                                                </div>
                                            </div>
                                        </div>
                                    </figure>
                                </div>

                            </div>

                        </div>
                    </div>
                    <br>
                    <span id="nothing"></span>
                    <span id="showmore" style="display: none;">
                        <div style="padding-top: 70px; padding-bottom: 50px; ">
                            <div class="col-md-12 col-sm-10" style="display: flex;">
                                <div id="serv_hover" class="room col-md-6">
                                    <div class="room_img">

                                        <figure>
                                            <div class="container">

                                                <!-- Full-width images with number text -->
                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">1 / 6</div>
                                                    <img src="assets/images/about.png" style="width:100%">
                                                </div>

                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">2 / 6</div>
                                                    <img src="assets/images/banner1.jpg" style="width:100%">
                                                </div>

                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">3 / 6</div>
                                                    <img src="assets/images/banner2.jpg" style="width:100%">
                                                </div>

                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">4 / 6</div>
                                                    <img src="assets/images/banner3.jpg" style="width:100%">
                                                </div>

                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">5 / 6</div>
                                                    <img src="assets/images/blog_bg.jpg" style="width:100%">
                                                </div>

                                                <div class="mySlides Slideroom3">
                                                    <div class="numbertext">6 / 6</div>
                                                    <img src="assets/images/gallery1.jpg" style="width:100%">
                                                </div>

                                                <!-- Next and previous buttons -->
                                                <a class="prev-btn" onclick="plusSlides3(-1)">&#10094;</a>
                                                <a class="next-btn" onclick="plusSlides3(1)">&#10095;</a>

                                                <!-- Image text -->
                                                <div class="caption-container">
                                                    <!-- <p id="caption"></p> -->
                                                </div>

                                                <!-- Thumbnail images -->
                                                <div class="row">
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/about.png"
                                                             style="width:100%" onclick="currentSlide3(1)" alt="The Woods">
                                                    </div>
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/banner1.jpg"
                                                             style="width:100%" onclick="currentSlide3(2)" alt="Cinque Terre">
                                                    </div>
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/banner2.jpg"
                                                             style="width:100%" onclick="currentSlide3(3)" alt="Mountains and fjords">
                                                    </div>
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/banner3.jpg"
                                                             style="width:100%" onclick="currentSlide3(4)" alt="Northern Lights">
                                                    </div>
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/blog1.jpg"
                                                             style="width:100%" onclick="currentSlide3(5)" alt="Nature and sunrise">
                                                    </div>
                                                    <div class="column">
                                                        <img class="demo cursor slidemini3" src="assets/images/blog2.jpg"
                                                             style="width:100%" onclick="currentSlide3(6)" alt="Snowy Mountains">
                                                    </div>
                                                </div>
                                            </div>
                                        </figure>

                                    </div>

                                </div>
                                <div class="col-md-1"></div>
                                <div class="col-md-5">
                                    <div class="detailroom">
                                        <p style="font-size: 16pt;">
                                            <b>Room detail</b>
                                            <br>
                                            <br>
                                            Room name: A103
                                            <br>
                                            Type room: 1
                                            <br>
                                            Room status: full
                                            <br>
                                            Room description: ..
                                        </p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </span>


                    <div style="text-align: center; margin-bottom: 50px;">
                        <a class="read_more " onclick="viewNoreRoom()" id="buttonviewmoreroom"> Read more</a>
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
                <div>${requestScope.apartment.apartmentContentAboutus}</div>
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
                                <iframe
                                    src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&amp;q=Eiffel+Tower+Paris+France"
                                    width="600" height="400" frameborder="0" style="border:0; width: 100%;"
                                    allowfullscreen=""></iframe>
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
        <footer>
            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class=" col-md-4">
                            <h3>Contact US</h3>
                            <ul class="conta">
                                <li><i class="fa fa-map-marker" aria-hidden="true"></i> Address</li>
                                <li><i class="fa fa-mobile" aria-hidden="true"></i> +01 1234569540</li>
                                <li> <i class="fa fa-envelope" aria-hidden="true"></i><a href="#"> demo@gmail.com</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <h3>Menu Link</h3>
                            <ul class="link_menu">
                                <li><a href="#">Home</a></li>
                                <li><a href="#about">About</a></li>
                                <li><a href="#room">Room</a></li>
                                <li><a href="#service">Service</a></li>
                                <li><a href="#review">Review</a></li>
                                <li><a href="#contact">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <h3>News letter</h3>
                            <form class="bottom_form">
                                <input class="enter" placeholder="Enter your email" type="text" name="Enter your email">
                                <button class="sub_btn">subscribe</button>
                            </form>
                            <ul class="social_icon">
                                <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </footer>

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
        <script src="assets/js/room-homepage.js"></script>
        <script src="assets/js/room-homepage2.js"></script>
        <script src="assets/js/room-homepage3.js"></script>
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