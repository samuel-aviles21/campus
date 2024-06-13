/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dao;
import modelo.Envio;
import modelo.Usuario;

/**
 *
 * @author Estudio
 */
public class Control extends HttpServlet {

    Dao dao = new Dao();
    Envio envio = new Envio();

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
        int op = Integer.parseInt(request.getParameter("action"));
        if (op == 1) {
            iniciarSesion(request, response);
        }
        if (op == 2) {
            cerrarSesion(request, response);
        }
        if (op == 3) {
            registroUsuario(request, response);
        }
        if (op == 4) {
            verificarCodigo(request, response);
        }
        if (op == 5) {
            crearCuenta(request, response);
        }

    }

    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("username");
        String contrasena = request.getParameter("password");
        int idUsuario = dao.verificarUsuario(nombreUsuario, contrasena);
        if (idUsuario >= 1) {
            Usuario usuario = dao.inicioUsuario(idUsuario);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            String pag = "paginaPrincipalUsuario.jsp";
            //response.sendRedirect(pag);
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            String pag = "Login.jsp";
            request.setAttribute("errorMessage", "Usuario o contraseña incorrecta");
            request.getRequestDispatcher(pag).forward(request, response);
        }
    }

    protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        String pag = "paginaPrincipal.jsp";
        response.sendRedirect(pag);
    }

    protected void registroUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("email");
        dao.generarCodigo(correo);
        request.setAttribute("email", correo);
        String pag = "verificarCodigo.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void verificarCodigo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoCorreo = request.getParameter("verification_code");
        String correo = request.getParameter("email");
        if (dao.verificarCodigo(correo, codigoCorreo) == true) {
            String pag = "crearCuenta.jsp";
            request.setAttribute("correo", correo);
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            System.out.println("ERROR");
        }

    }

    protected void crearCuenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        dao.registerUser(nombre, correo, password);
        Usuario nuevoUsuario = dao.inicioUsuario(dao.verificarUsuario(nombre, password));
        HttpSession session = request.getSession();
        session.setAttribute("usuario", nuevoUsuario);
        String pag = "paginaPrincipalUsuario.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
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
