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
                  method="post"
                  class="card shadow-sm p-4 border-0">

                <input type="hidden" name="id" value="${booking.id}">

                <h4 class="mb-4 fw-bold text-center">Update Booking Status</h4>

                <div class="mb-3">
                    <label class="form-label">Booking ID</label>
                    <input type="text" class="form-control" value="${booking.id}" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Current Status</label>
                    <input type="text" class="form-control" value="${booking.statusName}" readonly>
                </div>

                <div class="mb-4">
                    <label for="statusId" class="form-label">Next Status</label>
                    <select class="form-select" id="statusId" name="statusId"
                            <c:if test="${booking.statusName == 'Completed' || booking.statusName == 'Done'}">disabled</c:if>>

                            <c:choose>
                                <c:when test="${booking.statusName == 'Pending'}">
                                    <option value="2">Confirmed</option>
                                </c:when>

                                <c:when test="${booking.statusName == 'Confirmed'}">
                                    <option value="3">Repairing</option>
                                </c:when>

                                <c:when test="${booking.statusName == 'Repairing'}">
                                    <option value="4">Completed</option>
                                </c:when>

                                <c:when test="${booking.statusName == 'Completed'}">
                                    <option value="">Waiting for customer payment</option>
                                </c:when>

                                <c:when test="${booking.statusName == 'Done'}">
                                    <option value="">Already Done</option>
                                </c:when>
                            </c:choose>
                    </select>
                </div>

                <div class="text-end">
                    <button type="submit"
                            class="btn ${booking.statusName == 'Done' ? 'btn-secondary' : 'btn-warning'}"
                            <c:if test="${booking.statusName == 'Done'}">disabled</c:if>>
                        ${booking.statusName == 'Done' ? 'Already Done' : 'Update Status'}
                    </button>
                </div>

                <div class="text-danger mt-3">${error}</div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
    </body>
</html>