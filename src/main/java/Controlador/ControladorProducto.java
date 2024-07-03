package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.ClassProductoImp;
import model.TblProductocl3;

public class ControladorProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorProducto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        TblProductocl3 producto = new TblProductocl3();
        ClassProductoImp crud = new ClassProductoImp();

        if (accion != null) {
            switch (accion) {
                case "Modificar":
                    int codigo = Integer.parseInt(request.getParameter("cod"));
                    producto.setIdproductoscl3(codigo);
                    TblProductocl3 buscarcod = crud.BuscarProductocl3(producto);
                    request.setAttribute("codigo", buscarcod.getIdproductoscl3());
                    request.setAttribute("nombre", buscarcod.getNombrecl3());
                    request.setAttribute("precioventa", buscarcod.getPrecioventacl3());
                    request.setAttribute("preciocompra", buscarcod.getPreciocompcl3());
                    request.setAttribute("estado", buscarcod.getEstadocl3());
                    request.setAttribute("descripcion", buscarcod.getDescripcl3());
                    request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    int codigoEliminar = Integer.parseInt(request.getParameter("cod"));
                    producto.setIdproductoscl3(codigoEliminar);
                    crud.EliminarProductocl3(producto);
                    List<TblProductocl3> listado = crud.ListadoProductocl3();
                    request.setAttribute("listadoproductos", listado);
                    request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
                    break;
                case "Listar":
                    List<TblProductocl3> listadoProducto = crud.ListadoProductocl3();
                    request.setAttribute("listadoproductos", listadoProducto);
                    request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
                    break;
            }
        } else {
            List<TblProductocl3> listadoProducto = crud.ListadoProductocl3();
            request.setAttribute("listadoproductos", listadoProducto);
            request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String precioventa = request.getParameter("precioventa");
        String preciocompra = request.getParameter("preciocompra");
        String estado = request.getParameter("estado");
        String descripcion = request.getParameter("descripcion");

        TblProductocl3 productocl3 = new TblProductocl3();
        ClassProductoImp crud = new ClassProductoImp();
        productocl3.setNombrecl3(nombre);
        productocl3.setEstadocl3(estado);
        productocl3.setDescripcl3(descripcion);

        if (precioventa != null && !precioventa.trim().isEmpty()) {
            productocl3.setPrecioventacl3(Double.parseDouble(precioventa.trim()));
        }
        if (preciocompra != null && !preciocompra.trim().isEmpty()) {
            productocl3.setPreciocompcl3(Double.parseDouble(preciocompra.trim()));
        }

        if (codigo != null && !codigo.isEmpty()) {
            int cod = Integer.parseInt(codigo);
            productocl3.setIdproductoscl3(cod);
            crud.ActualizarProductocl3(productocl3);
        } else {
            crud.RegistrarProductocl3(productocl3);
        }

        List<TblProductocl3> listadoProducto = crud.ListadoProductocl3();
        request.setAttribute("listadoproductos", listadoProducto);
        request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
    }
}
