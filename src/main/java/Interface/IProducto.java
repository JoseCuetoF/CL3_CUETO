package Interface;

import java.util.List;

import model.TblProductocl3;

public interface IProducto {

	  //declaramos los metodos
    public void RegistrarProductocl3(TblProductocl3 prod);
    public void ActualizarProductocl3(TblProductocl3 prod);
    public void EliminarProductocl3(TblProductocl3 prod);
    public TblProductocl3 BuscarProductocl3(TblProductocl3 prod);
    public List<TblProductocl3> ListadoProductocl3();
} // fin de la interface

