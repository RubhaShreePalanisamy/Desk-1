<%@page import="java.sql.*,java.util.*"%>
<%
String title = request.getParameter("title");
    try {
 
        Class.forName("org.apache.derby.jdbc.ClientDriver"); 
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/businfo", "bus", "bus"); 
        PreparedStatement st = con.prepareStatement("select * from notesinfo where title=?");
        st.setString(1, title); 
        ResultSet rs = st.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData(); 
        if (rs.next()) {

      
    out.print("<center><h1>Result:</h1>");
    out.print("<b>Source:</b> " + title + "");
    out.print("<table width=25% border=1>");
    out.print("<tr>");
    out.print("<td>" + rsmd.getColumnName(1) + "</td>");
    out.print("<td>" + rs.getString(1) + "</td></tr>");
    out.print("<tr><td>" + rsmd.getColumnName(2) + "</td>");
    out.print("<td>" + rs.getString(2) + "</td></tr>");
    out.print("<tr><td>" + rsmd.getColumnName(3) + "</td>");
    out.print("<td>" + rs.getString(3) + "</td></tr>");
    out.print("<tr><td>" + rsmd.getColumnName(4) + "</td>");
    out.print("<td>" + rs.getString(4) + "</td></tr>");
    out.println("</table></center>"); 
    out.println("<a href='start.jsp'>add more notes</a>");
} else 
{
    out.println("notes not available<a href='start.jsp'>click here</a>");
}
    } catch (Exception ex) {
        System.out.println(ex);
    }%>