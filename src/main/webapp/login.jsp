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
        <form action="j_security_check" method="POST">
            <p>Username:<input type="text" name="j_username" value="" /> </p>
            <p>Password: <input type="text" name="j_password" value="" /> </p>
            
        </form>
    </body>
</html>
