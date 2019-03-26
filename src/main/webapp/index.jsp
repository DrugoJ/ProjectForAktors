<%-- 
    Document   : index
    Created on : 20.03.2019, 19:50:54
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <br>
        <p>${info}</p>
        <br>
        <br><a href="addProduct">Add Product</a>
        <!--<br><a href="addClient">Add Client</a>-->
        <br><a href="addOrder">Add Order</a>
        <br><a href="getOrder">Get Orders</a>
        <br><a href="showLogin">Sign in</a>
        <br><a href="logout">Sign out</a>
        <br><a href="showRegistration">Sign up (Registration)</a>
    </body>
</html>
