<%-- 
    Document   : getOrder
    Created on : 26.03.2019, 11:54:18
    Author     : GoD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Order</title>
        <style>
        table {
            border: solid 3px;
            border-collapse: collapse;           
        }
        td, tr {
            border: solid 3px;
            padding: 10px;
        }
    </style>
    </head>
    <body>
        <h1>All Orders</h1>
        <br>
        <a href="sortByName">Sort by client name   </a><br>
        <a href="sortByDate">Sort by date transaction   </a><br>
        <a href="sortByOrderId">Sort by order id   </a><br>
        <a href="sortByProductName">Sort by product name   </a><br>
        <br>

        <c:forEach var="order" items="${listOrders}">
            <table>
            <tr>
            <td style="width: 500px;">${order.product}</td>
            <td style="width: 500px;">${order.client}</td>
            <td style="width: 230px;">${order.date}</td>
            <td style="width: 100px;">Price - ${order.productprice} in cents(EUR)</td>
            </tr>
            </table>
        </c:forEach>
    </body>
</html>
