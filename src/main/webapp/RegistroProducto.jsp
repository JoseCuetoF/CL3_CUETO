<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor= yellow>
<h1 align="center">Registrar Producto</h1>
<form action="ControladorProducto" method="post">
<table border="2" align="center">
<tr>
<td>Nombre</td>
<td><input type="text" name="nombre"></td>
</tr>
<tr>
<td>Precio Venta</td>
<td><input type="number" name="preciov"></td>
</tr>
<tr>
<td>Precio Compra</td>
<td><input type="numb" name="precioc"></td>
</tr>
<tr>
<td>Estado</td>
<td><input type="text" name="estado"></td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="descripcion"></td>
</tr>

<tr>
<td colspan="2"  align="center" >
<input type="submit" value="Registrar Producto">
</td>
</tr>
</table>
</form>

</body>
</html>