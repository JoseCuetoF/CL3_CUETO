<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TblProductocl3" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body bgcolor="yellow">

    <h1 align="center">Actualizar Producto</h1>
    <form action="ControladorProducto" method="post">
        <%
        String cod = request.getAttribute("codigo").toString();
        String nom = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
        String precioVenta = (request.getAttribute("precioventa") != null) ? request.getAttribute("precioventa").toString() : "";
        String precioCompra = (request.getAttribute("preciocompra") != null) ? request.getAttribute("preciocompra").toString() : "";
        String estado = (request.getAttribute("estado") != null) ? request.getAttribute("estado").toString() : "";
        String descripcion = (request.getAttribute("descripcion") != null) ? request.getAttribute("descripcion").toString() : "";

        if (cod != null) {

        }
        %>
        <table border="2" align="center">
            <tr>
                <!-- Atributo para no ver  type="hidden" -->
                <td>Código</td>
                <td><input type="text" name="codigo" value="<%=cod%>" readonly></td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="<%=nom%>"></td>
            </tr>
            <tr>
                <td>Precio Venta</td>
                <td><input type="text" name="precioventa" value="<%=precioVenta%>"></td>
            </tr>
            <tr>
                <td>Precio Compra</td>
                <td><input type="text" name="preciocompra" value="<%=precioCompra%>"></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td><input type="text" name="estado" value="<%=estado%>"></td>
            </tr>
            <tr>
                <td>Descripción</td>
                <td><input type="text" name="descripcion" value="<%=descripcion%>"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Actualizar Producto"></td>
            </tr>
        </table>

    </form>

</body>
</html>
