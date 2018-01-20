<%-- 
    Document   : login
    Created on : 21 Sep, 2017, 9:40:05 AM
    Author     : prema
--%>

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>

<%
	Statement st=null;
	Connection con=null;
	ResultSet rs=null;

 
 // JDBC driver name and database URL
   final String DB_URL  = "jdbc:derby://localhost:1527/user";
 //  Database credentials
      final String DB_USER = "abc";
      final String DB_PASS = "abc";
	
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
        String sessionID = session.getId();
	try{
 
	Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
	st = con.createStatement();

	String QueryString = "select name,pass from users where name='"+name+"' and pass = '"+pass+"'";
	rs = st.executeQuery(QueryString);
	if(rs.next()){
	
	out.print("WELCOME"+sessionID);
        /*mapping m = new mapping;*/
       %> 
       <jsp:forward page="mainframe.html"/>
      <%  }
	else
	out.print("User Name and password are not Valid..");
	}
	
	catch (Exception e){
  out.print(e);
	}
	finally{
	st.close();
	rs.close();
	con.close();
	}
%>

