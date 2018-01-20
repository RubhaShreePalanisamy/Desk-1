<%-- 
    Document   : Delete
    Created on : Sep 20, 2017, 6:39:22 PM
    Author     : Sampath1421
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="gall.css" type="text/css"/>
    </head>
    <body>
        <div class="navbar-wrapper">
            <ul id="Navigation"><li><a href="#">home</a></li>
                <li><a href="insex1.jsp">ToDo list</a></li>
                <li><a href="index2.html">Gallery</a></li>
                <li><a href="#">Musix</a></li></ul>
    </div>
    <center>
        <form method="get" action="Deleteimg">
            enter th image to be deleted:<input type="text" name="desc">
            <br><br>
            <input type="submit" value="submit">
            
        </form>
    </center>
    
        
        
    </body>
</html>
