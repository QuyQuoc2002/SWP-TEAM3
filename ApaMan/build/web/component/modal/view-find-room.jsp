<%-- 
    Document   : view-all-room
    Created on : Feb 14, 2023, 2:15:37 PM
    Author     : Laputa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="view-find-room" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true" style="margin-top: 5px;">
    <div class="modal-dialog modal-xl">
        <div class="modal-content bg-secondary-cus">
            <div class="rounded my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <a href="#" class="a-none">
                        <h3 class="text-primary-cus">${requestScope.apartment.apartmentName}</h3>
                    </a>
                    <a data-bs-dismiss="modal" style="cursor: pointer; font-size: 20px;"><i class="fa-solid fa-xmark"></i></a>
                </div>
                <table id="example3" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Floor</th>
                            <th>Room</th>
                            <th>Room Type</th>
                            <th>Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.findRoomates}" var="room" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                
                                <c:forEach items="${requestScope.allFloor}" var="floor">
                                    <c:if test="${room.floorId eq floor.floorId}">
                                        <td>${floor.floorName}</td>
                                    </c:if>
                                </c:forEach>
                                        
                                <td>${room.roomName}</td>
                                
                                <td>${room.roomtype.roomtypeName}</td>
                                <td>${room.roomtype.roomtypeCost}</td>
                                        
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- </div> -->
                <!-- <div class="row">
                   <div class="col-12">
                      <button type="submit" class="btn btn-danger py-3 w-100 mb-4" data-bs-dismiss="modal">Close</button>
                   </div>
                </div> -->
            </div>
        </div>
    </div>

</div>
