<%-- 
    Document   : Insertnew
    Created on : Sep 20, 2017, 6:08:34 PM
    Author     : Sampath1421
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <form name="insertform" method="post" action="Insertnew" enctype="multipart/form-data">
                    Image Description:<input type="text" name="imgdes" ><br><br>
                    Photo:<input type="file" name="photo" size="50" /> <br><br>
                    <input type="submit" value="save">
                </form>
            </center>
        </body>
    </html>