<%-- 
    Document   : register
    Created on : Mar 9, 2026, 8:16:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garage Online - Register</title>
        <link rel="stylesheet" href="static/css/registerStyle.css"/>
    </head>
    <body>
        
        <div class="form">
            <div class="form-toggle"></div>
            <div class="form-panel one">
                <div class="form-header">
                    <h1>Account Register</h1>
                </div>
                <div class="form-content">
                    <form action="register" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" id="name" name="name" required="required" value="${requestScope.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="passord">Password</label>
                            <input type="passord" id="password" name="password" required="required" value="${requestScope.passWord}"/>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone number</label>
                            <input type="tel" id="phone" name="phone" required="required" value="${requestScope.phone}"/>
                        </div>
                            <div>${requestScope.error   }</div>
                        <div class="form-group">
                            <button type="submit">Sign Up</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
