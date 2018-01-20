<%@page import="java.sql.*,java.util.*"%>
<%
    out.println("hello");
String title=request.getParameter("title");
String description=request.getParameter("description");
String priority=request.getParameter("priority");
String createon=request.getParameter("date");
     try{
         
         Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/businfo", "bus", "bus");
           out.println("check");
           Statement st=con.createStatement();
           int i=st.executeUpdate("insert into notesinfo(title,description,priority,createon) values('"+title+"','"+description+"','"+priority+"','"+createon+"')");
        out.println("Data is successfully inserted!");
        out.println("<table><tr><td><a href='start.jsp'><input type='button' value='add more'></a></td>"
                + "<td><a href='index1.jsp'><input type='button' value='check'</a></td></tr>");
        }
        catch(Exception e){
        System.out.print(e);
        e.printStackTrace();
        }
        %>