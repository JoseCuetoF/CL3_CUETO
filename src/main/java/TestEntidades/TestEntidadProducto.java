package TestEntidades;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		//asigamos valores
		
		producto.setNombrecl3("Jabon SPA");
		producto.setPreciocompcl3(4);
		producto.setPrecioventacl3(5);
		producto.setEstadocl3("Nuevo");
		producto.setDescripcl3("Jabon de cara");
	
		
		//invocamos al metodo registrar . .
		
		crud.RegistrarProductocl3(producto);
		
		

	}

}
