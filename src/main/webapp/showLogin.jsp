<%-- 
    Document   : showLogin
    Created on : 26.03.2019, 15:25:34
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Sign in</title>
    </head>
    <body>
        <h1>Enter login and password</h1>
        <p>${info}</p>
        <form action="login" method="POST">
        Login:<br>
        <input type="text" name="login">
        <br>
        Password:<br>
        <input type="password" name="password">
        <input type="submit" value="Login in">
        <br><br>
        </form>
        <br>
        <a href="showRegistration">Sign up</a>
    </body>
</html>
