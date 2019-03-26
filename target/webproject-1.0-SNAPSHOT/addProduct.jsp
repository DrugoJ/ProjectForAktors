<%-- 
    Document   : addProduct
    Created on : 20.03.2019, 21:14:44
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product!</h1>
        <form action="createProduct" method="POST">
            Product Name:<br>
            <input type="text" name="name"><br>
            Base price:<br>
            <input type="text" name="baseprice"><br>
            About product:<br>
            <input type="text" name="description"><br>
            Release Date:   Example(16/09/2015)<br>
            <input type="text" name="releaseDate"><br>
            <br><br>
            <input type="submit" value="Add Product">
        </form>
    </body>
</html>
