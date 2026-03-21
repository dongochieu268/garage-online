<%-- 
    Document   : create
    Created on : Mar 14, 2026, 4:35:20 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="/views/admin/layouts/navbar.jsp" %>
        <div class="container mt-4">
            <div class="card shadow-sm border-0">
                <div class="card-body">

                    <h5 class="mb-4 fw-bold"> Filter Bookings</h5>

                    <form action="${pageContext.request.contextPath}/admin/booking" method="get">

                        <div class="row g-3">

                            <!-- STATUS -->
                            <div class="col-md-4">
                                <label class="form-label fw-semibold">Status</label>
                                <select name="statusId" class="form-select">
                                    <option value="">All Status</option>
                                    <c:forEach var="s" items="${statuses}">
                                        <option value="${s.id}" 
                                                ${selectedStatusId == s.id ? 'selected' : ''}>
                                            ${s.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!-- SERVICE -->
                            <div class="col-md-4">
                                <label class="form-label fw-semibold">Service</label>
                                <select name="serviceId" class="form-select">
                                    <option value="">All Services</option>
                                    <c:forEach var="s" items="${services}">
                                        <option value="${s.id}" 
                                                ${selectedServiceId == s.id ? 'selected' : ''}>
                                            ${s.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!-- VEHICLE -->
                            <div class="col-md-4">
                                <label class="form-label fw-semibold">Vehicle Type</label>
                                <select name="vehicleId" class="form-select">
                                    <option value="">All Vehicles</option>
                                    <c:forEach var="v" items="${vehicles}">
                                        <option value="${v.id}" 
                                                ${selectedVehicleId == v.id ? 'selected' : ''}>
                                            ${v.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>

                        <!-- BUTTON -->
                        <div class="d-flex justify-content-end gap-2 mt-4">

                            <a href="${pageContext.request.contextPath}/admin/booking" 
                               class="btn btn-outline-secondary">
                                Reset
                            </a>

                            <button type="submit" class="btn btn-primary px-4">
                                Filter
                            </button>

                        </div>

                    </form>

                </div>
            </div>
        </div>
        <div class="container mt-5">

            <div class="row g-4">
                <c:forEach var="b" items="${bookings}">
                    <div class="col-md-6 col-lg-4">
                        <div class="card h-100 shadow-sm border-0">

                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title fw-bold">Booking #${b.id}</h5>

                                <p class="mb-1"><strong>User:</strong> ${b.userName}</p>
                                <p class="mb-1"><strong>Phone:</strong> ${b.phone}</p>
                                <p class="mb-1"><strong>Service:</strong> ${b.serviceName}</p>
                                <p class="mb-1"><strong>Vehicle:</strong> ${b.vehicleName}</p>
                                <p class="mb-1"><strong>Description:</strong> ${b.problemDescription}</p>
                                <p class="mb-1"><strong>Date:</strong> ${b.bookingDate}</p>

                                <p class="mb-2">
                                    <strong>Status:</strong> 
                                    <span class="badge
                                          ${b.statusName == 'Done' ? 'bg-success' : 'bg-warning text-dark'}">
                                        ${b.statusName}
                                    </span>
                                </p>

                                <p class="fw-bold text-primary mb-3">
                                    ${b.totalPrice} VND
                                </p>

                                <!-- Button nằm dưới cùng -->
                                <div class="mt-auto">
                                    <a href="${pageContext.request.contextPath}/admin/updateBookingStatus?id=${b.id}" 
                                       class="btn btn-sm w-100
                                       ${b.statusName == 'Done' ? 'btn-secondary disabled' : 'btn-success'}">
                                        ${b.statusName == 'Done' ? 'Already Done' : 'Update Status'}
                                    </a>
                                </div>
                            </div>

                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
