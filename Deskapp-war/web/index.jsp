<%-- 
    Document   : index
    Created on : 21 Sep, 2017, 9:28:56 AM
    Author     : prema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="login.jsp">
            Name:<input type="text" name="name"><br>
            Password:<input type="password" name="pass"><br>
            <input type="submit" name="login">
            <br><a href="insert.jsp"><input type="button" value="register"></a>
        </form>
    </body>
</html>
