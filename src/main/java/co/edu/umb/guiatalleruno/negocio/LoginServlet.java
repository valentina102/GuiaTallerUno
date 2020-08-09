/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umb.guiatalleruno.negocio;

import co.edu.umb.guiatalleruno.modelo.Usuario;
import co.edu.umb.guiatalleruno.negocio.constantes.EMensajes;
import co.edu.umb.guiatalleruno.negocio.excepciones.GuiaUnoException;
import co.edu.umb.guiatalleruno.negocio.servicios.UsuarioServicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author User
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            // Recibir los atributos del usuario desde la peticion
            Usuario usuarioLogin = new Usuario(
                    request.getParameter("txtUserName"),
                    request.getParameter("txtPassword")
            );

            if (!new UsuarioServicio().validarLogin(usuarioLogin)){
                // el flujo de datos cuando el login es invalido.
                request.setAttribute("mensaje", EMensajes.NO_AUTENTICADO.getMensaje());
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }

            // el flujo de datos cuando el login es correcto.

            request.setAttribute("usuario", usuarioLogin);
            request.setAttribute("mensaje", EMensajes.AUTENTICADO.getMensaje());
            request.getRequestDispatcher("/home.jsp").forward(request,response);

            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hola usuario: "+txtUserName+"</h1>");
            out.println("<h2>Has accedido con la contraseña: "+txtPassword+"</h2>");
            out.println(EMensajes.ERROR_LOGIN.getMensaje());
            out.println("</body>");
            out.println("</html>");*/

        } catch (GuiaUnoException e){
            // el flujo de datos cuando el se genero un error.
            request.setAttribute("mensaje", e.getDescripcion());
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        } catch(Exception ex){
            ex.printStackTrace();
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
