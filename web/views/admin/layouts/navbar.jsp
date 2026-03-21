<%-- 
    Document   : sidebar
    Created on : Mar 14, 2026, 3:48:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm px-4">

    <!-- Logo / Brand -->
    <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/">
        Admin Panel
    </a>

    <!-- Toggle mobile -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Menu -->
    <div class="collapse navbar-collapse" id="navbarNav">

        <!-- Left menu -->
        <ul class="navbar-nav me-auto">

            <li class="nav-item">
                <a class="nav-link ${pageContext.request.requestURI.contains('dashboard') ? 'active fw-bold' : ''}" 
                   href="${pageContext.request.contextPath}/admin/dashboard">
                    Home
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link ${pageContext.request.requestURI.contains('service') ? 'active fw-bold' : ''}" 
                   href="${pageContext.request.contextPath}/admin/service">
                    Services
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link ${pageContext.request.requestURI.contains('booking') ? 'active fw-bold' : ''}" 
                   href="${pageContext.request.contextPath}/admin/booking">
                    Bookings
                </a>
            </li>

        </ul>

        <!-- Right side -->
        <div class="d-flex align-items-center gap-3">


            <!-- User -->
            <div class="dropdown">
                <a class="btn btn-light btn-sm dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                    Admin
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item text-danger" href="/LogOutController">Logout</a></li>
                </ul>
            </div>

        </div>

    </div>
</nav>