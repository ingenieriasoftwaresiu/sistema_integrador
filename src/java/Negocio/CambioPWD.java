/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.correa
 */
public class CambioPWD extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
            String strUsuario = request.getParameter("txtUsuario");
            String strPwdActual = request.getParameter("txtPwdActual");
            String strPwdNueva = request.getParameter("txtPwdNueva");            
            String strSQL;
            String strMensaje = "";
            
            String[] strDatos = GestionSQL.getFila("select p.txtIdentificacion from users_personas p where p.txtUsuario = '" + strUsuario + "' and p.txtPassword = '" + strPwdActual +"'");
            
            if (strDatos == null){    
                out.println("<html>");
                out.println("<head>");              
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='TEXTOFALLO'>");
                out.println("La contraseña actual no fue encontrada en el sistema.");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
           }else{                      
                
                strSQL = "update users_personas set txtPassword = '" + strPwdNueva + "' where txtUsuario = '" + strUsuario + "' and txtPassword ='" + strPwdActual + "'";                
                strMensaje = GestionSQL.ejecuta(strSQL);

               if (strMensaje == null){
                   //Inserción exitosa                     
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet CambioPWD</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div class='TEXTOEXITO'>");
                    out.println("La contraseña fue cambiada exitosamente!.");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");                  
               }else{
                   //Inserción fallida                   
                   out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet CambioPWD</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div class='TEXTOFALLO'>");
                    out.println("La contraseña NO fue cambiada!.");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
               }                
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
