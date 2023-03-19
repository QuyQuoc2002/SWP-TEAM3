<%-- 
    Document   : modal-char-totalpayment-month
    Created on : Mar 19, 2023, 9:21:51 PM
    Author     : Laputa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="char-totalpayment-year" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 5px;">
    <div class="modal-dialog modal-xl">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3 ">
                    <h3 class="text-primary-cus " style="color: wheat;padding-left: 35%">Total Money In ${requestScope.Year}</h3>

                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px; color: white"><i class="fa-solid fa-xmark"></i></a>
                </div>
                <div class="bg-secondary-cus text-center rounded ">
                    <canvas id="char-payment" style="width:100%;max-width:100%"></canvas>
                </div>

            </div>
        </div>
    </div>

</div>

