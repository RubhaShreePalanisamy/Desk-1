<%-- 
    Document   : index
    Created on : 12 Sep, 2017, 9:43:23 PM
    Author     : prema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
     <meta http-equiv="Content-Type"
	     content="text/html; charset=UTF-8">
         <title>todolist</title>
    </head>
    <body bgcolor="white">
        <font color=\"green\">
        <form method="post" action="insert.jsp">
         <center>Set Title:<input type="text" name="title" size="30" maxlength="20"/>
                <br><br>
                Description: <textarea name="description" rows="4" cols="25"></textarea>
                <br><br>
                Priority: <select name="priority">
                    <option> LOW </option>
                    <option> MEDIUM </option>
                    <option> HIGH </option>
            Create On: <input type="text" name="date" value="" />
            <br><br>
            <input type="submit" value="Submit" />
            <input type="reset" value="Reset" />
            <a href="start.jsp"><input type="button" value="check"></a>
         </center></font>
        </form>
    </body>
</html>

