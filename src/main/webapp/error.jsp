<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='styles/style.css' type='text/css' />    
    <title>Error</title>
  </head>
  <body>
    <h1>Error!</h1>
    <h2>Class: ${pageContext.exception["class"]}</h2>
    <h2>Message: ${pageContext.exception.message}</h2>
    <h2>Stack Trace: ${pageContext.exception.stackTrace}</h2>
  </body>
</html>
