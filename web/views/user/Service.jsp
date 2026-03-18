
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Montana</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/themify-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/nice-select.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/flaticon.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/gijgo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slicknav.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
        <!-- <link rel="stylesheet" href="css/responsive.css"> -->
    </head>

    <body>
        <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

        <!-- header-start -->
        <%@include file="/views/layout/header.jsp" %>
        <!-- header-end -->

        <!-- bradcam_area_start -->
        <div class="bradcam_area breadcam_bg_1">
            <h3>Laxaries Rooms</h3>
        </div>
        <!-- bradcam_area_end -->

        <!-- offers_area_start -->
        <div class="offers_area padding_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section_title text-center mb-100">
                            <span>Our Offers</span>
                            <h3>Ongoing Offers</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach var="s" items="${services}">
                        <div class="col-xl-4 col-md-4">
                            <div class="single_offers">
                                <div class="about_thumb">
                                    <img src="${pageContext.request.contextPath}/static/img/offers/1.png" alt="">
                                </div>
                                <h3>${s.name}</h3>
                                <ul>
                                    <li>Price: ${s.price}</li>
                                    <li>${s.description}</li>
                                </ul>

                                <a class="book_now" href="book?serviceId=${s.id}&price=${s.price}   ">book now</a>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- offers_area_end -->

        <!-- features_room_startt -->
        <div class="features_room">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section_title text-center mb-100">
                            <span>Featured Rooms</span>
                            <h3>Choose a Better Room</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rooms_here">
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/1.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>From $250/night</span>
                                <h3>Superior Room</h3>
                            </div>
                            <a href="bookController" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/2.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>From $250/night</span>
                                <h3>Deluxe Room</h3>
                            </div>
                            <a href="bookController" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/3.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>From $250/night</span>
                                <h3>Signature Room</h3>
                            </div>
                            <a href="bookController" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/4.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>From $250/night</span>
                                <h3>Couple Room</h3>
                            </div>
                            <a href="bookControler" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- features_room_end -->

        <!-- forQuery_start -->
        <div class="forQuery">
            <div class="container">
                <div class="row">
                    <div class="col-xl-10 offset-xl-1 col-md-12">
                        <div class="Query_border">
                            <div class="row align-items-center justify-content-center">
                                <div class="col-xl-6 col-md-6">
                                    <div class="Query_text">
                                        <p>For Reservation 0r Query?</p>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-md-6">
                                    <div class="phone_num">
                                        <a href="#" class="mobile_no">+10 576 377 4789</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- forQuery_end-->

        <!-- instragram_area_start -->
        <div class="instragram_area">
            <div class="single_instagram">
                <img src="${pageContext.request.contextPath}/static/img/instragram/1.png" alt="">
                <div class="ovrelay">
                    <a href="#">
                        <i class="fa fa-instagram"></i>
                    </a>
                </div>
            </div>
            <div class="single_instagram">
                <img src="${pageContext.request.contextPath}/static/img/instragram/2.png" alt="">
                <div class="ovrelay">
                    <a href="#">
                        <i class="fa fa-instagram"></i>
                    </a>
                </div>
            </div>
            <div class="single_instagram">
                <img src="${pageContext.request.contextPath}/static/img/instragram/3.png" alt="">
                <div class="ovrelay">
                    <a href="#">
                        <i class="fa fa-instagram"></i>
                    </a>
                </div>
            </div>
            <div class="single_instagram">
                <img src="${pageContext.request.contextPath}/static/img/instragram/4.png" alt="">
                <div class="ovrelay">
                    <a href="#">
                        <i class="fa fa-instagram"></i>
                    </a>
                </div>
            </div>
            <div class="single_instagram">
                <img src="${pageContext.request.contextPath}/static/img/instragram/5.png" alt="">
                <div class="ovrelay">
                    <a href="#">
                        <i class="fa fa-instagram"></i>
                    </a>
                </div>
            </div>
        </div>
        <!-- instragram_area_end -->

        <!-- footer -->
        <%@include file="/views/layout/footer.jsp" %>

        <!-- form itself end-->
        <form id="test-form" class="white-popup-block mfp-hide" action="book" method="get">
            <div class="popup_box ">
                <div class="popup_inner">
                    <h3>Booking detail</h3>
                    <div class="row">
                        <div class="col-xl-12">
                            <textarea name="des" class="form-control" placeholder="Problem Description"></textarea>
                        </div>
                        <div class="col-xl-12">
                            <select class="form-select wide" id="default-select" >
                                <option data-display="Vehicle">Vehicle</option>
                                <option value="1">Wave</option>
                                <option value="2">Vision</option>
                                <option value="3">Exciter</option>
                            </select>
                        </div>
                        <div class="col-xl-12">
                            <button type="submit" class="boxed-btn3">BOOK</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- form itself end -->


        <!-- JS here -->
        <script src="${pageContext.request.contextPath}/static/js/vendor/modernizr-3.5.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/isotope.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/ajax-form.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/imagesloaded.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/scrollIt.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.scrollUp.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/nice-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.slicknav.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/plugins.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/gijgo.min.js"></script>

        <!--contact js-->
        <script src="${pageContext.request.contextPath}/static/js/contact.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.ajaxchimp.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/mail-script.js"></script>

        <script src="${pageContext.request.contextPath}/static/js/main.js"></script>
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



    </body>

</html>