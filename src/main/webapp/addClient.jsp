<%-- 
    Document   : addClient
    Created on : 20.03.2019, 21:14:35
    Author     : GoD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Client</title>
    </head>
    <body>
        <h1>Add Client!</h1>
        <form action="createClient" method="POST">
            Client Name:<br>
            <input type="text" name="name"><br>
            Client Surname:<br>
            <input type="text" name="surname"><br>
            Client Phone:<br>
            <input type="text" name="phone"><br>
            Client Country:<br>
            <input type="text" name="country"><br>
            Client Address:<br>
            <input type="text" name="address"><br>
            <br><br>
            <input type="submit" value="Add Client">
        </form>
    </body>
</html>
