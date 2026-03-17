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
        <div class="container mt-5 d-flex justify-content-center">

            <div class="row">
                <c:forEach var="b" items="${bookings}">
                    <div class="col-sm-6 mb-5">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Booking ID: ${b.id}</h5>
                                <p class="card-text">User name: ${b.userName}</p>
                                <p class="card-text">Phone number: ${b.userPhone}</p>
                                <p class="card-text">Service name: ${b.serviceName}</p>
                                <p class="card-text">Vehicle type: ${b.vehicleType}</p>
                                <p class="card-text">Description: ${b.problemDescription}</p>
                                <p class="card-text">Booking date: ${b.bookingDate}</p>
                                <p class="card-text">Status: ${b.status}</p>
                                <p class="card-text">Total price: ${b.totalPrice}</p>
                                <a href="#" class="btn btn-success">Update Status</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>s
        </form>

    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
