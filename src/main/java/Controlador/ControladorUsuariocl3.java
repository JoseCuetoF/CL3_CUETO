package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuariocl3
 */
@WebServlet("/gestionUsuario")
public class ControladorUsuariocl3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuariocl3() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opera = request.getParameter("operacion");
        if (opera != null) {
            if (opera.equalsIgnoreCase("INICIARSESION")) {
                iniciarSesionDelUsuario(request, response);
            } else {
                cerrarSesionDelUsuario(request, response);
            }
        } else {
            // Manejo adicional si opera es null (opcional)
            response.sendRedirect("IniciaSesion.jsp?error");
        }
    }

    private void cerrarSesionDelUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Obtener la sesión actual y cerrarla
        HttpSession session = request.getSession();
        session.invalidate();

        // Redireccionar a la página de inicio de sesión con mensaje de logout
        response.sendRedirect("IniciaSesion.jsp?logout");
    }

    private void iniciarSesionDelUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Recuperar los valores del formulario
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");

        // Crear instancia de DAO para realizar la autenticación
        ClassUsuarioImp us = new ClassUsuarioImp();
        TblUsuariocl3 objU = us.iniciarSesion(usuario, password);

        // Validar si el usuario y contraseña son correctos
        if (objU == null) {
            // Redireccionar a la página de inicio de sesión con mensaje de error
            response.sendRedirect("IniciaSesion.jsp?error");
        } else {
            // Guardar el usuario en sesión (opcional)
            HttpSession session = request.getSession();
            session.setAttribute("usuario", objU);

            // Redireccionar al index.jsp
            response.sendRedirect("index.jsp");
        }
    }

}
