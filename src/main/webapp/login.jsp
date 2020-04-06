<%-- 
    Document   : login
    Created on : Apr. 6, 2020, 9:40:35 a.m.
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="j_security_check" method="post">
            <label>Username</label>
            <input type="text" name="j_username"><br><br>
            <label>Password</label>
            <input type="password" name="j_password"><br><br>
            <label>&nbsp;</label>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
