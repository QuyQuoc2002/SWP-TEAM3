<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar pe-4 pb-3">
    <nav class="navbar navbar-dark">
        <a href="/apartment" class="navbar-brand ms-4 mb-3 text-primary-cus" style="font-size: 32px;">
            <h3><i class="fa-solid fa-user-pen"></i>QiMotel</h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
            <div class="position-relative">
                <img class="rounded-circle" src="assets/images/1.png" alt="" style="width: 40px; height: 40px;">
            </div>
            <div class="ms-2 text-white">
                <h6 class="mb-0">${sessionScope.curAccount.accountUsername}</h6>
                <span>${sessionScope.curAccount.role.roleName}</span>
            </div>
        </div>
        <div class="navbar-nav w-100">
            <a href="apartment" class="nav-item nav-link"><i class="fa-solid fa-list me-2"></i>Menu</a>
            <a href="homepage-management" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Apartment Info</a>
            <a href="members" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Members</a>
            <a href="staff" class="nav-item nav-link"><i class="fa-solid fa-user-gear me-2"></i>Staffs</a>
            <a href="vehicle-page" class="nav-item nav-link"><i class="fa-solid fa-motorcycle me-2"></i>Vehicles</a>
            <div class="nav-item dropdown">
                <a href="room-management.html" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa-solid fa-house me-2"></i></i>Room Management</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="room-control" class="dropdown-item">Controls</a>
                    <a href="roomtype" class="dropdown-item">Room Type</a>
                    <c:forEach items="${requestScope.sidebarFloors}" var="floor">
                        <a href="floor-room?floorId=${floor.floorId}" class="dropdown-item">floor ${floor.floorName}</a>
                    </c:forEach>
                </div>
            </div>
            <a href="deposit-contract.html" class="nav-item nav-link"><i class="fa-solid fa-file-signature me-2"></i>Deposit contract</a>
            <a href="leases-contract.html" class="nav-item nav-link"><i class="fa-solid fa-file-contract me-2"></i>tenancy agreement</a>
            <a href="sign-out" class="nav-item nav-link"><i class="fa-solid fa-right-from-bracket me-2"></i>Logout</a>
        </div>
    </nav>
</div>