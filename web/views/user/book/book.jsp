<%-- 
    Document   : book
    Created on : Mar 17, 2026, 3:53:44 PM
    Author     : -HP-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Book</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->
        <link rel="stylesheet" href="static/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/css/owl.carousel.min.css">
        <link rel="stylesheet" href="static/css/magnific-popup.css">
        <link rel="stylesheet" href="static/css/font-awesome.min.css">
        <link rel="stylesheet" href="static/css/themify-icons.css">
        <link rel="stylesheet" href="static/css/nice-select.css">
        <link rel="stylesheet" href="static/css/flaticon.css">
        <link rel="stylesheet" href="static/css/gijgo.css">
        <link rel="stylesheet" href="static/css/animate.css">
        <link rel="stylesheet" href="static/css/slicknav.css">
        <link rel="stylesheet" href="static/css/style.css">
    </head>
    <body>
        <%@include file="/views/layout/header.jsp" %>

        <div style="height: 100px; background: #000;"></div>
        <div class="container d-flex justify-content-center align-items-center"
             style="min-height: 70vh; padding: 50px 0;">

            <div class="form" style="width: 400px;">
                <div class="form-panel one">
                    <div class="form-header text-center mb-3">
                        <h2>Booking Service</h2>
                    </div>

                    <div class="form-content">
                        <form action="book" method="post">

                            <!-- Hidden data -->
                            <input type="hidden" name="serviceId" value="${serviceId}">
                            <input type="hidden" name="price" value="${price}">

                            <!-- Problem description -->
                            <div class="form-group mb-3">
                                <label>Description of Problem</label>
                                <textarea name="problemDescription" class="form-control" required></textarea>
                            </div>

                            <!-- Vehicle selection -->
                            <div class="form-group mb-3">
                                <label>Select Vehicle</label>
                                <select name="vehicleId" class="form-control" required>
                                    <option value="">-- Choose Vehicle --</option>
                                    <c:forEach var="v" items="${vehicles}">
                                        <option value="${v.id}">${v.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!-- Submit -->
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-primary w-100">
                                    Book Now
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/views/layout/footer.jsp" %>
    </body>
    <script src="static/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="static/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="static/js/popper.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/owl.carousel.min.js"></script>
    <script src="static/js/isotope.pkgd.min.js"></script>
    <script src="static/js/ajax-form.js"></script>
    <script src="static/js/waypoints.min.js"></script>
    <script src="static/js/jquery.counterup.min.js"></script>
    <script src="static/js/imagesloaded.pkgd.min.js"></script>
    <script src="static/js/scrollIt.js"></script>
    <script src="static/js/jquery.scrollUp.min.js"></script>
    <script src="static/js/wow.min.js"></script>
    <script src="static/js/nice-select.min.js"></script>
    <script src="static/js/jquery.slicknav.min.js"></script>
    <script src="static/js/jquery.magnific-popup.min.js"></script>
    <script src="static/js/plugins.js"></script>
    <script src="static/js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="static/js/contact.js"></script>
    <script src="static/js/jquery.ajaxchimp.min.js"></script>
    <script src="static/js/jquery.form.js"></script>
    <script src="static/js/jquery.validate.min.js"></script>
    <script src="static/js/mail-script.js"></script>

    <script src="static/js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }

        });
    </script>
</html>
