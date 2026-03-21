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
        <div class="container mt-5">

            <!-- Header -->
            <div class="d-flex justify-content-between align-items-center mb-4">
                <div>
                    <h3 class="fw-bold mb-1">Service Management</h3>
                    <p class="text-muted mb-0">Manage all services in the system</p>
                </div>

                <a class="btn btn-success px-4" href="${pageContext.request.contextPath}/admin/createService">
                    + Create Service
                </a>
            </div>

            <!-- Table Card -->
            <div class="card shadow-sm border-0 rounded-3">
                <div class="card-body p-0">
                    <div class="table-responsive">
                        <table class="table table-hover align-middle text-center mb-0">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Description</th>
                                    <th style="width: 180px;">Action</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="service" items="${services}">
                                    <tr>
                                        <td class="fw-semibold">${service.id}</td>
                                        <td>${service.name}</td>
                                        <td class="text-primary fw-bold">${service.price}</td>
                                        <td class="text-muted">${service.description}</td>
                                        <td>
                                            <a class="btn btn-outline-warning btn-sm me-1"
                                               href="${pageContext.request.contextPath}/admin/updateService?id=${service.id}">
                                                Update
                                            </a>
                                            <a class="btn btn-outline-danger btn-sm"
                                               href="${pageContext.request.contextPath}/admin/deleteService?id=${service.id}">
                                                Delete
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                <c:if test="${empty services}">
                                    <tr>
                                        <td colspan="5" class="text-center text-muted py-4">
                                            No services found
                                        </td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
