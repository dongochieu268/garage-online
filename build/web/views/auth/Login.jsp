<%-- 
    Document   : login
    Created on : Mar 9, 2026, 8:21:33 PM
    Author     : -HP-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garage Online - Login</title>
        <link rel="stylesheet" href="static/css/styles.css" />
        <!-- <script src="/GarageOnline/static/jss/newjavascript.js"></script> -->
    </head>
    <body>
        <div class="form">
            <div class="form-toggle"></div>
            <div class="form-panel one">
                <div class="form-header">
                    <h1>Account Login</h1>
                </div>
                <div class="form-content">
                    <form action="Login" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" id="username" name="username" required="required" value="${requestScope.username}"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" required="required" value="${requestScope.password}"/>
                        </div>
                        <!--<div class="form-group">
                            <label class="form-remember">
                                <input type="checkbox"/>Remember Me
                            </label><a class="form-recovery" href="#">Forgot Password?</a>
                        </div>-->
                        <div>${requestScope.error}</div>
                        <div class="form-group">
                            <button type="submit">Log In</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
