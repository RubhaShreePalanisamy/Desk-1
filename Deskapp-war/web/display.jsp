<%-- 
    Document   : display
    Created on : Sep 17, 2017, 9:52:47 AM
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
            <link rel="stylesheet" href="gall.css" type="text/css"/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Display</title>
        </head>
        <body>
            
<div class="navbar-wrapper">
            <ul id="Navigation"><li><a href="#">home</a></li>
                <li><a href="#">ToDo list</a></li>
                <li><a href="index.html">Gallery</a></li>
                <li><a href="#">Musix</a></li></ul>
    </div>
            <center><form method="get" action="RetImg">
            enter th image to be viewed:<input type="text" name="desc">
            <br><br>
            <input type="submit" value="submit">
            
        </form>
            </center>
        </body>
        
    </html>
</f:view>
