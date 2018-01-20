/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageServ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sampath1421
 */
public class RetImg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RetImg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RetImg at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
        PrintWriter out = response.getWriter();
        String descp = request.getParameter("desc");
        byte[] barr = null;
        try{  
        Class.forName("org.apache.derby.jdbc.ClientDriver");  
        try (Connection con = DriverManager.getConnection(  
            "jdbc:derby://localhost:1527/businfo","bus","bus")) {
        PreparedStatement ps=con.prepareStatement("select * from GALLERYINFO where description=?");
        ps.setString(1, descp);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            
            Blob b=rs.getBlob(2);
            barr=b.getBytes(1,(int)b.length());
            try (FileOutputStream fout = new FileOutputStream("C:\\Users\\prema\\Documents\\NetBeansProjects\\Deskapp\\Deskapp-war\\web\\Web-content\\pinky.jpg")) {
                fout.write(barr);
                
            }
        }//end of if
        out.println("image retrieved");
       /*response.setContentType("image/jpg");

    try (OutputStream o = response.getOutputStream()) {
        o.write(barr);
       // o.flush();
    } catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());

return;}*/
    out.print("<a href='Disp.jsp'>");
    out.print("view");
    out.print("</a>");
    

       
    
        System.out.println("ok");
    }  
}
catch (IOException | ClassNotFoundException | SQLException e) {
    e.printStackTrace();  }  
        
    }
        
        
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
