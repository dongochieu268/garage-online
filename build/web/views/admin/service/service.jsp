<%-- 
    Document   : service
    Created on : Mar 14, 2026, 4:08:31 PM
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

            <!-- Nút Create bên phải -->
            <div class="d-flex justify-content-end mb-3">
                <a class="btn btn-success" href="/admin/createService">Create</a>
            </div>

            <!-- Bảng căn giữa -->
            <div class="d-flex justify-content-center">
                <table class="table table-hover w-90 text-center">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Description</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="service" items="${services}">
                            <tr>
                                <td>${service.id}</td>
                                <td>${service.name}</td>
                                <td>${service.price}</td>
                                <td>${service.description}</td>
                                <td>
                                    <a class="btn btn-warning btn-sm" href="/admin/updateService?id=${service.id}">Update</a>
                                    <a class="btn btn-danger btn-sm" href="/admin/deleteService?id=${service.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>

        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
