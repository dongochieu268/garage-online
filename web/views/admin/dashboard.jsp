<%-- 
    Document   : dashboard
    Created on : Mar 14, 2026, 3:54:00 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <%@include file="/views/admin/layouts/navbar.jsp" %>
        <div class="container mt-5">

    <div class="row text-center">

        <div class="col-md-4">
            <div class="card bg-success text-white mb-3">
                <div class="card-body">
                    <h5>Total Revenue</h5>
                    <h3>${revenue}</h3>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-primary text-white mb-3">
                <div class="card-body">
                    <h5>Total Bookings</h5>
                    <h3>${totalBookings}</h3>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-warning text-dark mb-3">
                <div class="card-body">
                    <h5>Top Service</h5>
                    <h3>${topService}</h3>
                </div>
            </div>
        </div>

    </div>

    <h4 class="mt-5">Recent Bookings</h4>

    <table class="table table-bordered">
        <tr>
            <th>User</th>
            <th>Service</th>
            <th>Date</th>
            <th>Price</th>
        </tr>

        <c:forEach var="b" items="${recent}">
            <tr>
                <td>${b.userName}</td>
                <td>${b.serviceName}</td>
                <td>${b.bookingDate}</td>
                <td>${b.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>

</div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
