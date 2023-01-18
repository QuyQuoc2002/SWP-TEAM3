<%-- 
    Document   : homepage-management
    Created on : Jan 14, 2023, 9:12:54 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="https://cdn.ckeditor.com/ckeditor5/35.3.2/classic/ckeditor.js"></script>
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
    </head>

    <body>
        <div class="toast-container position-fixed top-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            </div>
        </div>
        <div class="container-fluid position-relative d-flex p-0">
            <!-- Sidebar Start -->
            <div class="sidebar pe-4 pb-3">
                <%@include file="component/common/sidebar.jsp" %>
            </div>
            <!-- Sidebar End -->
            <div class="content">
                <!-- Navbar Start -->
                <%@include file="component/common/navbar.jsp" %>
                <!-- Navbar End -->
                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">Apartment Info Edit</div>
                <div class="container-fluid pt-4 px-4">

                    <!----------------------------------------------- Introduction ---------------------------------------->
                    <section class="recruitment mb-5">
                        <div class="top-side d-flex justify-content-between">
                            <h2 class="text-wheat">Introduction</h2>
                            <div class="controls">
                                <form action="homepage-management" method="post"> 
                                    <input type="hidden" name="editIntroductionContent">
                                    <input type="hidden" name="editType" value="editIntroduction">
                                    <button type="submit" onclick="editIntroduction()" class="btn btn-dark-cus">Save</button>
                                </form>
                            </div>
                        </div>
                        <div id="edit-introduction"></div>
                    </section>

                    <!------------------------------------------------- Banner -------------------------------------------->
                    <section id="banner" class="banner mb-5">
                        <div class="top-side d-flex justify-content-between">
                            <h2 class="text-wheat">Banner image</h2>
                            <div class="controls d-flex">
                                <form action="delete-img-banner" method="post">
                                    <input id="delete-banner" type="hidden" name="idBannerDelete">
                                    <button onclick="deleteBanner();" type="submit" class="btn btn-dark-cus me-3">Delete This</button>  
                                </form>   
                                <form action="add-img-banner" method="post" enctype="multipart/form-data">
                                    <input type="file" name="file" lang="en" class="btn btn-dark-cus" size="60" required="">
                                    <button type="submit" class="btn btn-dark-cus">Add</button>
                                </form>   
                            </div>
                        </div>

                        <div id="carouselExampleIndicators" class="carousel slide" data-bs-interval="false">
                            <div class="carousel-indicators">
                                <c:forEach items="${requestScope.apartmentImgBanners}" var="apartmentImgBanner" varStatus="i">
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${i.index}"
                                            <c:if test="${i.index eq 0}"> class="active" aria-current="true"</c:if> aria-label="Slide ${i.count}"></button>
                                </c:forEach>
                            </div>
                            <div class="carousel-inner">
                                <c:forEach items="${requestScope.apartmentImgBanners}" var="apartmentImgBanner" varStatus="i">
                                    <div data-bannerid="${apartmentImgBanner.apartmentImgBannerId}" class="carousel-item<c:if test="${i.index eq 0}"> active </c:if>">
                                        <img style="height: 500px; object-fit: cover;" src="${apartmentImgBanner.apartmentImgBannerPath}" class="d-block w-100" alt="...">
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

                    <!-------------------------------------------------------- About Us ------------------------------------------>
                    <section id="about-us" class="aboutus mb-5">
                        <div class="top-side d-flex justify-content-between">
                            <h2 class="text-wheat">About Us</h2>                          
                            <div class="controls">
                                <form action="update-img-aboutus" method="post" enctype="multipart/form-data">
                                    <input type="file" name="file" lang="en" class="btn btn-dark-cus" size="60" required="">
                                    <input type="hidden" name="apartmentImgAboutus" value="${requestScope.apartment.apartmentImgAboutus}">
                                    <button type="submit" class="btn btn-dark-cus">Save</button>
                                </form>   
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <form action="homepage-management" method="post">                                   
                                    <input type="hidden" name="editAboutusContent">
                                    <div id="edit-aboutus"></div>
                                    <input type="hidden" name="editType" value="editAboutus">
                                    <button type="submit" onclick="editAboutus()" class="btn btn-dark-cus">Save</button>
                                </form>
                            </div>
                            <div class="col-6">
                                <img src="${requestScope.apartment.apartmentImgAboutus}" class="d-block w-100" alt="...">
                            </div>
                        </div>
                    </section>

                    <!----------------------------------------------------------- Service ----------------------->
                    <section class="services mb-5">
                        <div class="top-side d-flex justify-content-between">
                            <h2 class="text-wheat">Services</h2>
                            <div class="controls">
                                <form action="homepage-management" method="post"> 
                                    <input type="hidden" name="editServiceContent">
                                    <input type="hidden" name="editType" value="editService">
                                    <button type="submit" onclick="editService()" class="btn btn-dark-cus">Save</button>
                                </form>
                            </div>
                        </div>
                        <div id="edit-service"></div>
                    </section>

                    <!--------------------- Recruitment ----------------------->
                    <section class="recruitment mb-5">
                        <div class="top-side d-flex justify-content-between">
                            <h2 class="text-wheat">Recruitment</h2>
                            <div class="controls">
                                <form action="homepage-management" method="post"> 
                                    <input type="hidden" name="editRecruitmentContent">
                                    <input type="hidden" name="editType" value="editRecruitment">
                                    <button type="submit" onclick="editRecruitment()" class="btn btn-dark-cus">Save</button>
                                </form>
                            </div>
                        </div>
                        <div id="edit-recruitment"></div>
                    </section>
                </div>
            </div>
        </div>
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>

        <!---------------------------------------------SHOW TOAST---------------------------------------------------------->
        <script>
                                        const messageUpdate = '<%= session.getAttribute("messageUpdate") %>';
                                        if (messageUpdate !== 'null') {
                                            const words = messageUpdate.split("|");
                                            showToast(words[0], words[1], words[2]);
                                        }
        </script>

        <!---------------------------------------------DELETE BANNER---------------------------------------------------------->
        <script>
            function deleteBanner() {
                document.getElementById('delete-banner').value = document.querySelector('#carouselExampleIndicators .carousel-item.active').dataset.bannerid;
            }
        </script>


        <!---------------------------------------------EDITOR---------------------------------------------------------->
        <script>
            let editorAboutus;
            let editorSerive;
            let editorRecruitment;
            let editorIntroduction;

            ClassicEditor
                    .create(document.querySelector('#edit-introduction'))
                    .then(newEditor => {
                        editorIntroduction = newEditor;
                        editorIntroduction.setData("${requestScope.apartment.apartmentIntro}");
                    })
                    .catch(error => {
                        console.error(error);
                    });
            function editIntroduction() {
                let data = editorIntroduction.getData();
                document.getElementById("edit-introduction").parentElement.firstElementChild.lastElementChild.firstElementChild.firstElementChild.value = data;
            }

            ClassicEditor
                    .create(document.querySelector('#edit-aboutus'))
                    .then(newEditor => {
                        editorAboutus = newEditor;
                        editorAboutus.setData("${requestScope.apartment.apartmentContentAboutus}");
                    })
                    .catch(error => {
                        console.error(error);
                    });
            function editAboutus() {
                let data = editorAboutus.getData();
                document.getElementById("edit-aboutus").parentElement.firstElementChild.value = data;
            }

            ClassicEditor
                    .create(document.querySelector('#edit-service'))
                    .then(newEditor => {
                        editorSerive = newEditor;
                        editorSerive.setData("${requestScope.apartment.apartmentContentService}");
                    })
                    .catch(error => {
                        console.error(error);
                    });
            function editService() {
                let data = editorSerive.getData();
                document.getElementById("edit-service").parentElement.firstElementChild.lastElementChild.firstElementChild.firstElementChild.value = data;
            }

            ClassicEditor
                    .create(document.querySelector('#edit-recruitment'))
                    .then(newEditor => {
                        editorRecruitment = newEditor;
                        editorRecruitment.setData("${requestScope.apartment.apartmentContentRecruitment}");
                    })
                    .catch(error => {
                        console.error(error);
                    });
            function editRecruitment() {
                let data = editorRecruitment.getData();
                document.getElementById("edit-recruitment").parentElement.firstElementChild.lastElementChild.firstElementChild.firstElementChild.value = data;
            }

        </script>
    </body>
    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>