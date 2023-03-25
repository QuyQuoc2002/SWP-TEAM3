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

                <div class="text-center my-4 text-danger text-uppercase fw-bolder" style="font-size: 50px;">PAYMENT HISTORY</div>



                <div class="container-fluid pt-4 px-4" style="margin-bottom: 80px">
                    <div>
                        <a class="btn btn-dark-cus mb-3 ms-3 select" data-bs-toggle="modal" 
                           data-bs-target="#char-totalpayment-year"><i class="fa-solid fa-chart-simple"></i></a>   
                    </div>
                    <div class="bg-secondary-cus rounded p-4">

                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Room Money</th>
                                    <th>Water Money</th>
                                    <th>Electric Money</th>
                                    <th>Vehicle Money</th>
                                    <th>Total Money</th>
                                    <th>Done Date</th>
                                    <!--<th>More</th>-->
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.paymentHistories}" var="paymentHistory" varStatus="i">
                                    <tr>
                                        <td>${i.count}</td>
                                        <td>${paymentHistory.paymentRoomUnitFee}</td>
                                        <td>${paymentHistory.paymentWaterMoney}</td>
                                        <td>${paymentHistory.paymentElectricMoney}</td>
                                        <td>${paymentHistory.paymentCarMoney + paymentHistory.paymentMotorMoney + paymentHistory.paymentBikeMoney}</td>
                                        <td>${paymentHistory.paymentRoomUnitFee + paymentHistory.paymentWaterMoney + paymentHistory.paymentElectricMoney +  paymentHistory.paymentCarMoney + paymentHistory.paymentMotorMoney + paymentHistory.paymentBikeMoney}</td>
                                        <td>${requestScope.Calenders.formatTime("dd/MM/yyyy", paymentHistory.paymentDoneDate)}</td>
                                        <!--<td><a href="" class="a-none">Detail</a></td>-->
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>


            </div>
        </div>

        <!-------------------------MODAL-------------------------------------->
        <%@include file="component/modal/modal-char-totalpayment-year.jsp"%>



        <!-------------------------END MODAL---------------------------------->

        <script src="assets/js/bootstrap.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <body>

        

        <script>
            var xValues = [<c:forEach items="${requestScope.paymentYears}" var="paymentYear">"${paymentYear.month}",</c:forEach>];
            var yValues = [<c:forEach items="${requestScope.paymentYears}" var="paymentYear">"${paymentYear.paymentTotalMoney}",</c:forEach>];
            var barColors = ["blue", "green", "red", "orange", "brown", "red", "green", "blue", "orange", "brown", "green", "blue" ];

            new Chart("char-payment", {
                type: "bar",
                data: {
                    labels: xValues,
                    datasets: [{
                            backgroundColor: barColors,
                            data: yValues
                        }]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: ""
                        
                    }
                }
            });
        </script>

        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script>$(document).ready(function () {
                $('#example').DataTable();
            });</script>

    </body>
</html>
