<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");
    String mensajeError = null;

    if (usuario != null && password != null) {
        if ("maemos".equals(usuario) && "maemos97".equals(password)) {
            response.sendRedirect("index.jsp");
        } else {
            mensajeError = "Usuario o contraseña incorrectos";
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script type="text/javascript">
        function validarFormulario() {
            var usuario = document.forms["loginForm"]["usuario"].value;
            var password = document.forms["loginForm"]["password"].value;

            if (usuario == null || usuario == "") {
                alert("El campo Usuario no puede estar vacío");
                return false;
            }
            if (password == null || password == "") {
                alert("El campo Password no puede estar vacío");
                return false;
            }
            return true;
        }
    </script>
</head>
<body bgcolor="yellow">
    <h2 align="center">Ingresar al sistema</h2>
    <form name="loginForm" method="post" onsubmit="return validarFormulario();">
        <table border="2" align="center">
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="usuario"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Ingresar</button>
                </td>
            </tr>
        </table>
    </form>
    <% if (mensajeError != null) { %>
        <p style="color:red; text-align:center;"><%= mensajeError %></p>
    <% } %>
</body>
</html>
