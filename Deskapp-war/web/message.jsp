<%-- 
    Document   : message
    Created on : Sep 15, 2017, 12:35:54 AM
    Author     : RUBHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" href="gall.css" type="text/css"/>
            <title>JSP Page</title>
        </head>
        <body>
            <div class="navbar-wrapper">
            <ul id="Navigation"><li><a href="index.html">home</a></li>
                <li><a href="index1.jsp">ToDo list</a></li>
                <li><a href="index2.html">Gallery</a></li>
                <li><a href="#">Musix</a></li></ul>
    </div>
        <center>
            <h3>Result of the operation: ${message}</h3>
        </center>
</body>
    </html>
</f:view>
