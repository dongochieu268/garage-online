
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- <link rel="stylesheet" href="css/responsive.css"> -->
    </head>

    <body>
        <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

        <!-- header-start -->
        <%@include file="/views/layout/header.jsp" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <!-- header-end -->

        <!-- bradcam_area_start -->
        <div class="bradcam_area breadcam_bg_1">
            <h3>Garage Online</h3>
        </div>
        <!-- bradcam_area_end -->

        <div class="about_area">
            <div class="container">
                <div class="row">
                    <div class="col-xl-5 col-lg-5">
                        <div class="about_info">
                            <div class="section_title mb-20px">
                                <span>About Service</span>
                                <h3>A Luxuries Garage  <br>
                                    Online</h3>
                            </div>
                            <p>Dịch vụ sửa chữa và bảo dưỡng xe của chúng tôi được thực hiện bởi đội ngũ kỹ thuật viên giàu kinh nghiệm, đảm bảo chất lượng và độ an toàn cao.
                                Mỗi chiếc xe đều được kiểm tra kỹ lưỡng, sửa chữa chính xác và minh bạch về chi phí, mang lại sự yên tâm cho khách hàng.
                                Chúng tôi luôn cam kết nâng cao chất lượng dịch vụ và trải nghiệm, đáp ứng nhanh chóng và hiệu quả mọi nhu cầu chăm sóc xe máy.</p>
                            <a href="#" class="line-button">Learn More</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="features_room">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section_title text-center mb-100">
                            <span>Featured Service</span>
                            <h3>Upgrade Your Driving Experience</h3>
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
                                <span>Giúp xe vận hành ổn định và bền bỉ.</span>
                                <h3>Bảo dưỡng</h3>
                            </div>
                            <a href="#services-section" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/2.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>Khắc phục nhanh chóng mọi hư hỏng.</span>
                                <h3>Sửa chữa</h3>
                            </div>
                            <a href="#services-section" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/3.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>Làm sạch xe, giữ vẻ ngoài như mới.</span>
                                <h3>Vệ sinh</h3>
                            </div>
                            <a href="#services-section" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
                <div class="single_rooms">
                    <div class="room_thumb">
                        <img src="${pageContext.request.contextPath}/static/img/rooms/4_1.png" alt="">
                        <div class="room_heading d-flex justify-content-between align-items-center">
                            <div class="room_heading_inner">
                                <span>Hỗ trợ kịp thời khi xe gặp sự cố.</span>
                                <h3>Khẩn cấp</h3>
                            </div>
                            <a href="#services-section" class="line-button">book now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- offers_area_start -->
        <div class="offers_area padding_top" id="services-section">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section_title text-center mb-100">
                            <span>Our Offers</span>
                            <h3>Ongoing Offers</h3>
                        </div>
                    </div>
                </div>

                <!-- FILTER -->
                <div class="container mt-4">
                    <form method="get" action="Service#services-section" class="row g-3 align-items-end">

                        <!-- CATEGORY -->
                        <div class="col-md-4">
                            <label class="form-label">Category</label>
                            <select name="categoryId" class="form-select">
                                <option value="">All</option>
                                <c:forEach var="c" items="${categories}">
                                    <option value="${c.id}"
                                            ${c.id == categoryId ? "selected" : ""}>
                                        ${c.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- MIN PRICE -->
                        <div class="col-md-3">
                            <label class="form-label">Min Price</label>
                            <input type="number" name="minPrice" class="form-control"
                                   placeholder="0" value="${minPrice}">
                        </div>

                        <!-- MAX PRICE -->
                        <div class="col-md-3">
                            <label class="form-label">Max Price</label>
                            <input type="number" name="maxPrice" class="form-control"
                                   placeholder="1000000" value="${maxPrice}">
                        </div>

                        <!-- BUTTON -->
                        <div class="col-md-2 d-grid">
                            <button type="submit" class="book_now">
                                Filter
                            </button>
                        </div>

                    </form>
                </div>

                <div class="container mt-4" id="services-section">
                    <div class="row g-4">

                        <c:if test="${empty services}">
                            <p class="text-center">No services found</p>
                        </c:if>

                        <c:forEach var="s" items="${services}">
                            <div class="col-md-4">

                                <div class="card h-100 shadow-sm">

                                    <!-- IMAGE -->
                                    <div class="img-thumbnail">
                                        <img src="${pageContext.request.contextPath}/${s.img}" 
                                         class="card-img-top" 
                                         style="height:200px; object-fit:cover;" 
                                         alt="${s.name}">
                                    </div>
                                    

                                    <div class="card-body d-flex flex-column">

                                        <!-- NAME -->
                                        <h5 class="card-title">${s.name}</h5>

                                        <!-- PRICE -->
                                        <p class="text-danger fw-bold">
                                            ${s.price} VND
                                        </p>

                                        <!-- CATEGORY -->
                                        <p class="mb-1">
                                            Category:
                                            <c:forEach var="c" items="${categories}">
                                                <c:if test="${c.id == s.categoryId}">
                                                    ${c.name}
                                                </c:if>
                                            </c:forEach>
                                        </p>

                                        <!-- DESCRIPTION (cắt ngắn) -->
                                        <p class="card-text">
                                            ${fn:length(s.description) > 60 ? fn:substring(s.description, 0, 60) : s.description}...
                                        </p>

                                        <!-- BUTTON -->
                                        <a href="book?serviceId=${s.id}&price=${s.price}"
                                           class="book_now">
                                            Book Now
                                        </a>

                                    </div>

                                </div>

                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
        <!-- offers_area_end -->

        <!-- features_room_startt -->

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