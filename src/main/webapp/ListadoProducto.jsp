<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
    <%@page import="model.TblProductocl3" %>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Productos here</title>
</head>
<body bgcolor="yellow" align="center">

<h1  align="center">Listado de Productos Registrados en BD</h1>
<table border="2" align="center">

<tr>
<td>Codigo</td>
<td>Nombre</td>
<td>Precio Venta</td>
<td>Precio Compra</td>
<td>Estado</td>
<td>Descripcion</td>
</tr>
<%
List<TblProductocl3> listado=(List<TblProductocl3>)request.getAttribute("listadoproductos");
//aplicamos una condicion..
if(listado!=null){
    //aplicamos un bucle for..
    for(TblProductocl3 lis:listado){
        %>
        <tr>
        <td><%=lis.getIdproductoscl3() %></td>
        <td><%=lis.getNombrecl3() %></td>
        <td><%=lis.getPrecioventacl3() %></td>
        <td><%=lis.getPreciocompcl3() %></td>
        <td><%=lis.getEstadocl3() %></td>
        <td><%=lis.getDescripcl3() %></td>
        <td><a href="ControladorProducto?accion=Eliminar&cod=<%=lis.getIdproductoscl3()%>">Eliminar</a></td>
        <td><a href="ControladorProducto?accion=Modificar&cod=<%=lis.getIdproductoscl3()%>">Actualizar</a></td>
        </tr>
 <%
    }  //fin del bucle for...
    %>
    <%
} //fin de la condicion ...

%>
</table>


</body>
</html>