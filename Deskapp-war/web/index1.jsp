<%-- 
    Document   : index
    Created on : 20 Sep, 2017, 8:55:26 PM
    Author     : prema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="gall.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="logo1.png" />
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script>
  $(function() {

    $('#login-form-link').click(function(e) {
    	$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
  });
</script>
 <link rel="stylesheet" href="style.css" />
 <link rel="stylesheet" href="font-awesome-4.7.0\css\font-awesome.min.css" />
        <title>Notes Information System</title>
    </head>
    <body>
        <div class="navbar-wrapper">
            <ul id="Navigation"><li><a href="#">home</a></li>
                <li><a href="index1.jsp">ToDo list</a></li>
                <li><a href="index2.html">Gallery</a></li>
                <li><a href="#">Musix</a></li></ul></div>
        <div class="Homepage"><center>
                <form method="post" action="findnotes.jsp">
                <br><br>
                Enter title to search:<input type="text" value="title" name="title">
                <br><br>
               <input type="button" value="Insert" onclick="window.location='start.jsp'" />
                <br><br>
                <input type="submit" value="Search" />
                <br><br>
                </form>
                
            </center>
        </div>
           
    </body>
</html>
