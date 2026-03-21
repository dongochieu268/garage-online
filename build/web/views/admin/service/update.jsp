<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Service</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="/views/admin/layouts/navbar.jsp" %>
        <div class="container mt-5 d-flex justify-content-center">

            <form style="width:95%; max-width:700px;" 
                  action="${pageContext.request.contextPath}/admin/updateService" 
                  method="post"
                  enctype="multipart/form-data">

                <input type="hidden" name="id" value="${service.id}">

                <div class="form-group mb-3">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" value="${service.name}">
                </div>

                <div class="form-group mb-3">
                    <label>Price</label>
                    <input type="number" class="form-control" name="price" value="${service.price}">
                </div>

                <div class="form-group mb-3">
                    <label>Description</label>
                    <input type="text" class="form-control" name="description" value="${service.description}">
                </div>

                <!-- giữ ảnh cũ -->
                <input type="hidden" name="oldImg" value="${service.img}">

                <div class="form-group mb-3">
                    <label>Image</label>

                    <!-- hiển thị ảnh cũ -->
                    <c:if test="${service.img != null}">
                        <div class="mb-2">
                            <img src="${pageContext.request.contextPath}/${service.img}" width="100">
                        </div>
                    </c:if>

                    <!-- giữ ảnh cũ -->
                    <input type="hidden" name="oldImg" value="${service.img}">

                    <!-- chọn ảnh mới -->
                    <input type="file" class="form-control" name="image">
                </div>

                <div class="form-group mb-4">
                    <label for="categoryId">Category</label>
                    <select class="form-control" id="categoryId" name="categoryId">
                        <c:forEach var="c" items="${categories}">
                            <option value="${c.id}" 
                                    <c:if test="${c.id == service.categoryId}">selected</c:if>>
                                ${c.name}
                            </option>
                        </c:forEach>
                    </select>
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