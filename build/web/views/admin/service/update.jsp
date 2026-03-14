<%-- 
    Document   : create
    Created on : Mar 14, 2026, 4:35:20 PM
    Author     : ADMIN
--%>

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
        <div class="container mt-5 d-flex justify-content-center">

            <form style="width:95%; max-width:700px;" action="updateService" method="post">
                <input type="hidden" class="form-control" id="name" name="id"  value="${service.id}">
                <div class="form-group mb-3">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter service name" value="${service.name}">
                </div>

                <div class="form-group mb-3">
                    <label for="price">Price</label>
                    <input type="number" class="form-control" id="price" name="price" placeholder="Enter price" value="${service.price}">
                </div>

                <div class="form-group mb-4">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" placeholder="Enter description" value="${service.description}">
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-warning">Update</button>
                </div>
                <div>${error}</div>
            </form>

        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
    