<%-- 
    Document   : addOrder
    Created on : 20.03.2019, 21:14:57
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Order</title>
    </head>
    <body>
        <h1>Order</h1>
        <form action="createOrder" method="POST">
            Product list:<br>
            <select name="productId">
                <c:forEach var="product" items="${listProducts}">
                    <option value="${product.barCode}">${product.name}</option>
                </c:forEach>
            </select><br>
            Client list:<br>
            <select name="clientId">
                <c:forEach var="client" items="${listClients}">
                    <option value="${client.personId}">${client.name}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Order">
        </form>
    </body>
</html>
