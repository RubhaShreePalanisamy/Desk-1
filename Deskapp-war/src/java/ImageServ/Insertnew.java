/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageServ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author RUBHA
 */

@MultipartConfig(maxFileSize = 16177215)
    
public class Insertnew extends HttpServlet {
    private static final int BUFFER_SIZE = 4096;
    
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/businfo","bus","bus");
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to obtaiin db connectivity",e);
            
        }
        return con;
    }
    
    
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
            out.println("<title>Servlet Insertnew</title>");            
            out.println("</head>");
            out.println("<body>");
            
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
        String descp = request.getParameter("imgdes");
        InputStream inputstream = null;
        Part filePart = request.getPart("photo");
        if(filePart != null){
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputstream = filePart.getInputStream();
            
        }
        Connection con1 = null;
        String message = null;
        try{
            con1 =getConnection();
            String sql = "INSERT INTO GALLERYINFO (description ,photo) values (?, ?)";
            
            PreparedStatement pst = con1.prepareStatement(sql);
            pst.setString(1,descp);
            if(inputstream != null){
                pst.setBlob(2,inputstream);
            }
                    
            int row = pst.executeUpdate();
            if ( row>0){
                message = "File uploaded and saved into db";
            }
            String filepath = "C:\\Users\\prema\\Documents\\NetBeansProjects\\Deskapp\\Deskapp-war\\web\\Web-content\\frst.jpg";
            String sql1 = "SELECT photo FROM GALLERYINFO WHERE description=?";
            PreparedStatement pstselect = con1.prepareStatement(sql1);
            pstselect.setString(1,descp);
            ResultSet result = pstselect.executeQuery();
            if(result.next()){
                Blob blob = result.getBlob("photo");
                InputStream inputstream1 = blob.getBinaryStream();
                OutputStream ops = new FileOutputStream(filepath);
                int br = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((br = inputstream1.read(buffer)) != -1){
                    ops.write(buffer,0,br);
                }
                inputstream1.close();
                ops.close();
                System.out.println("File Saved");
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insertnew.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            message = "ERROR:" +ex.getMessage();
            ex.printStackTrace();
        }finally{
            if(con1 != null){
                try{
                    con1.close();
                }catch(SQLException ex){
            }
        }
        request.setAttribute("message",message);
        getServletContext().getRequestDispatcher("/message.jsp").include(request, response);
        
    }
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