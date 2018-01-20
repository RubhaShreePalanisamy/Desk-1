package ImageServ;


import entities.NewBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sampath1421
 */
public class Delete extends HttpServlet {

    @EJB
    private NewBean newBean;


    
    

    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Desk","bus","bus");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to obtaiin db connectivity",e);
            
        }
        return con;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Delete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Delete at " + request.getContextPath() + "</h1>");
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
Connection conn = null;
    PreparedStatement pst = null;
    String message=null;
    String descp = request.getParameter("desc");
    ServletOutputStream out = response.getOutputStream();
    response.setContentType("text/html");
    out.println("<html><head><title>Delete Photo</title></head>");
    
    try {
      conn = getConnection();
      pst = conn.prepareStatement("delete from GALLERYINFO where description=?");
      pst.setString(1, descp);
      pst.executeUpdate();
      message = "File "+descp+" deleted from db";
      
    } catch (SQLException e) {
      out.println("<body><h1>Error=" + e.getMessage() + "</h1></body></html>");
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
      try {
        pst.close();
        conn.close();
      } catch (SQLException e) {
      }
       //request.setAttribute("message",message);
       //getServletContext().getRequestDispatcher("/message.jsp").include(request, response);
        String msg = message;
        out.println(newBean.Messagedisp(msg));
    }
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
