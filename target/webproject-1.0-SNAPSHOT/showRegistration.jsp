<%-- 
    Document   : showRegistration
    Created on : 26.03.2019, 15:24:58
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <p>${info}</p>
        <h1>Sign up</h1>
        <form action="registration" method="POST">
        Name:<br>
        <input type="text" name="name" value="${name}"><br>
        Surname:<br>
        <input type="text" name="surname" value="${surname}"><br>
        Phone:<br>
        <input type="text" name="phone" value="${phone}"><br>
        Country:<br>
        <input type="text" name="country" value="${country}"><br>
        Address:<br>
        <input type="text" name="address" value="${address}"><br>
        Login:<br>
        <input type="text" name="login" value="${login}"><br>
        Password:<br>
        <input type="password" name="password1"><br>
        Password:<br>
        <input type="password" name="password2"><br>
        <br><br>
        <input type="submit" name="Add Client"><br>
        </form>
    </body>
</html>
