<%-- 
    Document   : staff.jsp
    Created on : Jan 19, 2023, 2:18:38 PM
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
        <title>Motel</title>
        <link rel="stylesheet" href="assets/bootstrap-5.2.3-dist/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link rel="stylesheet" href="assets/css/common.css">
        <link rel="stylesheet" type="text/css" href="assets/css/switch-toggle-btn.css">
        <link rel="stylesheet" href="assets/css/staff.css">
    </head>

    <body>
        <div class="toast-container position-fixed top-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
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
                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">STAFF</div>
                <div id="staff" class="container-fluid pt-4 px-4">
                    <div class="row">
                        <div class="col-4 mb-4" id="new-staff">
                            <div class="bg-secondary-cus rounded p-2 card-staff">
                                <div class="row px-3 pt-2">
                                    <div class="col-12 text-center text-wheat">
                                        <h1 style="line-height: 70px">ADD NEW</h1>
                                    </div>                        
                                </div>
                                <hr>
                                <div class="card-staff-header">
                                    <div>
                                        <i class="fa-solid fa-mountain-sun me-1"></i><span><input class="border-0 bg-secondary-cus countryside" type="text" placeholder="Countryside"></span>
                                    </div>
                                    <div>
                                        <i class="fa-regular fa-calendar-days me-1"></i><span><input class="border-0 bg-secondary-cus dob" type="text" placeholder="dd-MM-yyyy"></span>
                                    </div>
                                </div>
                                <div class="card-staff-body">
                                    <div class="contact text-white">
                                        <div class="phone">
                                            <i class="fa-solid fa-phone-volume me-2"></i><span><input class="border-0 bg-secondary-cus text-white w-75 phone-number" type="text" placeholder="Phone number"></span>
                                        </div>
                                        <div>
                                            <i class="fa-regular fa-id-card me-2"></i><span><input class="border-0 bg-secondary-cus text-white citizen-identification" type="text" placeholder="citizen identification"></span>
                                        </div>
                                    </div>
                                    <div class="price"><input class="border-0 bg-transparent text-white text-center salary" type="text" placeholder="Salary"><sup>đ</sup>
                                    </div>
                                    <div class="user mt-4">
                                        <div class="media d-flex">
                                            <a class="circle">
                                                <img class="avatar" src="assets/images/avatar.png" alt="">
                                            </a>
                                            <div class="media-body pt-2">
                                                <h5><input class="border-0 bg-secondary-cus text-white name" type="text" placeholder="Name"></h5>
                                                <p class="mt-1"><input class="border-0 bg-secondary-cus text-white job" type="text" placeholder="Job"></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="action mt-2">
                                        <div class="row">
                                            <div class="col-6">
                                                <button class="btn btn-primary w-100">Create</button>
                                            </div>
                                            <div class="col-6">
                                                <button onclick="resetStaff();" class="btn btn-danger w-100">Reset</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${staffs}" var="staff">
                            <div class="col-4 mb-4">
                                <div class="bg-secondary-cus rounded p-2 card-staff">
                                    <form action="staff" method="post">
                                        <div class="row px-3 pt-2">
                                            <div class="col-8 text-wheat">
                                                <div style="line-height: 34px; font-size: 20px;">
                                                    <i class="fa-solid fa-user me-2"></i>${staff.account.accountUsername}
                                                </div>
                                                <div class="d-flex">
                                                    <i class="fa-solid fa-lock me-2" style="line-height: 34px;"></i>
                                                    <input name="password" class="text-wheat w-100 border-0" style="background: transparent; line-height: 34px; font-size: 20px;" type="text" value="${staff.account.accountPassword}">
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="d-flex justify-content-end">
                                                    <span class="text-secondary">Active</span>
                                                </div>
                                                <div class="d-flex justify-content-end">
                                                    <label class="switch ms-3">
                                                        <input name="accountAccessible" type="checkbox" <c:if test="${staff.account.accountAccessible}"> checked</c:if>><span class="slider round"></span>
                                                        </label>
                                                    </div>
                                                </div>                        
                                            </div>
                                            <hr>
                                            <div class="card-staff-header">
                                                <div><i class="fa-solid fa-mountain-sun me-1"></i><span><input name="countrySide" class="border-0 bg-secondary-cus" type="text" value="${staff.staffCountryside}"></span></div>
                                            <div>
                                                <i class="fa-regular fa-calendar-days me-1"></i><span><input name="dob" class="border-0 bg-secondary-cus" type="text" value="${staff.staffDob}"></span>
                                            </div>
                                        </div>
                                        <div class="card-staff-body">
                                            <div class="contact text-white">
                                                <div class="phone">
                                                    <i class="fa-solid fa-phone-volume me-2"></i><span><input name="phoneNumber" class="border-0 bg-secondary-cus text-white w-75" type="text" value="${staff.staffPhoneNumber}"></span>
                                                </div>
                                                <div>
                                                    <i class="fa-regular fa-id-card me-2"></i><span><input name="citizenIdentification" class="border-0 bg-secondary-cus text-white" type="text" value="${staff.staffCitizenIdentification}"></span>
                                                </div>
                                            </div>
                                            <div class="price"><input name="salary" class="border-0 bg-transparent text-white text-center" type="text" value="${staff.staffSalary}"><sup>đ</sup>
                                            </div>
                                            <div class="user mt-4">
                                                <div class="media d-flex">
                                                    <a class="circle">
                                                        <img class="avatar" src="assets/images/avatar.png" alt="">
                                                    </a>
                                                    <div class="media-body pt-2">
                                                        <h5><input name="name" class="border-0 bg-secondary-cus text-white" type="text" value="${staff.staffName}"></h5>
                                                        <p class="mt-1"><input name="job" class="border-0 bg-secondary-cus text-white" type="text" value="${staff.staffJob}"></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="action mt-2">
                                                <div class="row">
                                                    <div class="col-6">
                                                        <input type="hidden" name="accountId" value="${staff.account.accountId}">
                                                        <input type="hidden" name="staffId" value="${staff.staffId}">
                                                        <input type="submit" name="submitType" value="Save" class="btn btn-primary w-100">
                                                    </div>
                                                    <div class="col-6">
                                                        <input type="submit" name="submitType" value="Delete" class="btn btn-danger w-100">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="assets/js/toast.js"></script>

        <script>
            function resetStaff() {
                document.querySelector('#new-staff .countryside').value = null;
                document.querySelector('#new-staff .dob').value = null;
                document.querySelector('#new-staff .phone-number').value = null;
                document.querySelector('#new-staff .citizen-identification').value = null;
                document.querySelector('#new-staff .salary').value = null;
                document.querySelector('#new-staff .name').value = null;
                document.querySelector('#new-staff .job').value = null;
            }
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
    <%
            request.getSession().removeAttribute("messageUpdate");
    %>
</html>