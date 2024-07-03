package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interface.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto {

	public void RegistrarProductocl3(TblProductocl3 prod) {
		// establecer conexion  con la unidad de persistencia . . . 
				EntityManagerFactory pro= Persistence.createEntityManagerFactory("LPII_CL3_CUETOJOSE");
						 
				//permite gestionar entidades
				EntityManager em=pro.createEntityManager();
				//iniciamos transaccion
				em.getTransaction().begin();
				
				//registramos
				em.persist(prod);
				
				//confirmamos
				em.getTransaction().commit();
				
				//imprimmos
				
				System.out.println("Producto registrado correctanmente en la BD");
				
				//cerramos transaccion
				
				em.close();
		
	}

	public void ActualizarProductocl3(TblProductocl3 prod) {
		//establecer  la conexion con la unidad de persistencia...
        EntityManagerFactory em= Persistence.createEntityManagerFactory("LPII_CL3_CUETOJOSE");

        //gestionar las entidades
        EntityManager emanager= em.createEntityManager();

        //inicar la transaccion
        emanager.getTransaction().begin();

        //Actualizar
        emanager.merge(prod);

        //Emitimos mensaje
        System.out.println("Usuario actualizado correctnamente en la BD");

        //confirmamos
        emanager.getTransaction().commit();

        //cerramos
        emanager.close();
		
	}

	@Override
    public void EliminarProductocl3(TblProductocl3 pro) {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL3_CUETOJOSE");
        EntityManager emanager = em.createEntityManager();
        emanager.getTransaction().begin();

        // Recuperamos el producto a eliminar
        TblProductocl3 elim = emanager.find(TblProductocl3.class, pro.getIdproductoscl3());
        // Procedemos a eliminar
        emanager.remove(elim);

        // Emitimos mensaje por consola
        System.out.println("Producto eliminado en la BD");

        // Confirmamos
        emanager.getTransaction().commit();
        // Cerramos
        emanager.close();
    } // fin del metodo eliminar producto...

	public TblProductocl3 BuscarProductocl3(TblProductocl3 prod) {
		  EntityManagerFactory em= Persistence.createEntityManagerFactory("LPII_CL3_CUETOJOSE");

	        EntityManager emanager= em.createEntityManager();

	        emanager.getTransaction().begin();

	        TblProductocl3 buscarp=emanager.find(TblProductocl3.class, prod.getIdproductoscl3());

	        emanager.close();

	        //retornamos el usuario buscado a la BD
	        return buscarp;
	}

	public List<TblProductocl3> ListadoProductocl3() {
		 //establecer la conexion con la unidad de persistencia
        EntityManagerFactory em= Persistence.createEntityManagerFactory("LPII_CL3_CUETOJOSE");
        //gestionar las entidades
        EntityManager emanager= em.createEntityManager();
        //inicar la transaccion
        emanager.getTransaction().begin();
        //recuperamos el listado de productos de la base de datos
        List<TblProductocl3> listado= emanager.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
        //confirmamos 
        emanager.getTransaction().commit();
        //cerramos
        emanager.close();
        return listado;
	}

}
