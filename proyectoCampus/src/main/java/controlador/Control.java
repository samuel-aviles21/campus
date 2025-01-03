/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dao;
import modelo.Profesor;
import modelo.Usuario;

/**
 *
 * @author Estudio
 */
public class Control extends HttpServlet {

    Dao dao = new Dao();

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
        if (op == 6) {
            reenvioCorreo(request, response);
        }
        if (op == 7) {
            buscarProfesor(request, response);
        }
        if (op == 8) {
            cargarProfesor(request, response);
        }
        if (op == 9) {
            comentar(request, response);
        }
        if (op == 10) {
            agregarProfesor(request, response);
        }
        if (op == 11) {
            antesCrear(request, response);
        }
        
        if(op==12){
            antesComentar(request, response);
        }
    }

    protected void antesCrear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("status"));
        if (status == 0) {
            String pag = "Login.jsp";
            response.sendRedirect(pag);
        } else {
            String pag = "agregarProfesor.jsp";
            response.sendRedirect(pag);
        }
    }
    
      protected void antesComentar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("status"));
        if (status == 0) {
            String pag = "Login.jsp";
            response.sendRedirect(pag);
        } else {
            comentar(request, response);
        }
    }

    protected void agregarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("professor-name");
        String comentario = request.getParameter("professor-comment");
        int iduser = Integer.parseInt(request.getParameter("user"));
        dao.addTeacher(nombre, iduser);
        Profesor profesor = dao.mostrarProfeAgregado(nombre);
        dao.comentar(iduser, profesor.getId_profe(), comentario);
        HttpSession session = request.getSession();
        session.setAttribute("perfil", profesor);
        String pag = "Resenas.jsp";
        response.sendRedirect(pag);
    }

    //PATRON PRG
    protected void comentar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comentario = request.getParameter("comentario");
        int idprof = Integer.parseInt(request.getParameter("idpf"));
        int iduser = Integer.parseInt(request.getParameter("user"));
        dao.comentar(iduser, idprof, comentario);
        Profesor profesor = dao.profesorPerfil(idprof);
        //request.setAttribute("perfil", profesor);
        HttpSession session = request.getSession();
        session.setAttribute("perfil", profesor);
        String pag = "Resenas.jsp";
        response.sendRedirect(pag);
        //request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void buscarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombreProfesor");
        List<Profesor> lista = dao.buscarProfesoresPorNombre(nombre);
        String pag = "resultadosProfesor.jsp";
        request.setAttribute("listaProfesores", lista);
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void cargarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProfesor = Integer.parseInt(request.getParameter("prof"));
        Profesor profesor = dao.profesorPerfil(idProfesor);
        HttpSession session = request.getSession();
        session.setAttribute("perfil", profesor);
        //request.setAttribute("perfil", profesor);
        String pag = "Resenas.jsp";
        response.sendRedirect(pag);
//request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("username");
        String contrasena = request.getParameter("password");
        int idUsuario = dao.verificarUsuario(nombreUsuario, contrasena);
        if (idUsuario >= 1) {
            Usuario usuario = dao.inicioUsuario(idUsuario);
            HttpSession session = request.getSession();
            session.setAttribute("estudiante", usuario);
            String pag = "paginaPrincipal.jsp";
            response.sendRedirect(pag);
            //request.getRequestDispatcher(pag).forward(request, response);
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
        if (dao.verificarCorreoExiste(correo)) {
            request.setAttribute("errorMessage", "Este correo ya se encuentra registrado en Campus");
            String pag = "Registrar.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            dao.generarCodigo(correo);
            request.setAttribute("email", correo);
            String pag = "verificarCodigo.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        }

    }

    protected void verificarCodigo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoCorreo = request.getParameter("verification_code");
        String correo = request.getParameter("email");
        if (dao.verificarCodigo(correo, codigoCorreo) == true) {
            request.setAttribute("correo", correo);
            String pag = "crearCuenta.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            request.setAttribute("email", correo);
            request.setAttribute("errorMessage", "Código de verificacion incorrecto");
            String pag = "verificarCodigo.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        }
    }

    protected void crearCuenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("username");
        String password = request.getParameter("password");
        if (dao.existeNombre(nombre)) {
            request.setAttribute("correo", correo);
            request.setAttribute("errorMessage", "Nombre de usuario en uso");
            String pag = "crearCuenta.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        } else {
            dao.registerUser(nombre, correo, password);
            Usuario nuevoUsuario = dao.inicioUsuario(dao.verificarUsuario(nombre, password));
            HttpSession session = request.getSession();
            session.setAttribute("estudiante", nuevoUsuario);
            String pag = "paginaPrincipal.jsp";
            request.getRequestDispatcher(pag).forward(request, response);
        }
    }

    protected void reenvioCorreo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("email");
        dao.reenviarCodigo(correo);
        request.setAttribute("email", correo);
        String pag = "verificarCodigo.jsp";
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
