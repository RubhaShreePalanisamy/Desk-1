<%-- 
    Document   : insert
    Created on : 21 Sep, 2017, 9:32:10 AM
    Author     : prema
--%>

<%@page import="java.sql.*,java.util.*"%>
<%
    out.println("hello");
String name=request.getParameter("name");
String pass=request.getParameter("pass");
String email=request.getParameter("email");
String confirmpassword=request.getParameter("confirmpassword");

     try{
         
         Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/user", "abc", "abc");
           out.println("check");
           Statement st=con.createStatement();
           int i=st.executeUpdate("insert into users(name,pass,email,confirmpassword) values('"+name+"','"+pass+"','"+email+"','"+confirmpassword+"')");
        out.println("Data is successfully inserted!");
        out.println("<table><tr><td><a href='index1.jsp'><input type='button' value='login'></a></td>");
                       }
        catch(Exception e){
        System.out.print(e);
        e.printStackTrace();
        }
        %>
