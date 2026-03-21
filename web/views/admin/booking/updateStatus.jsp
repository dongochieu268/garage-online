<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Booking Status</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/views/admin/layouts/navbar.jsp" %>

        <div class="container mt-5 d-flex justify-content-center">
            <form style="width:95%; max-width:500px;"
                  action="${pageContext.request.contextPath}/admin/updateBookingStatus"
                  method="post">

                <input type="hidden" name="id" value="${booking.id}">

                <div class="form-group mb-3">
                    <label>Booking ID</label>
                    <input type="text" class="form-control" value="${booking.id}" readonly>
                </div>

                <div class="form-group mb-4">
                    <label for="statusId">Status</label>
                    <select class="form-control" id="statusId" name="statusId">
                        <c:forEach var="s" items="${statuses}">
                            <option value="${s.id}" <c:if test="${s.id == status.id}">selected</c:if>>
                                ${s.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-warning">Update Status</button>
                </div>

                <div class="text-danger mt-2">${error}</div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
    </body>
</html>