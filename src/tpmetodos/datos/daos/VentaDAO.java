package tpmetodos.datos.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tpmetodos.datos.entidades.Venta;
import tpmetodos.datos.hibernate.HibernateUtil;
import tpmetodos.servicio.excepciones.VentaInvalidaException;

/**
 * VentaDAO
 * 
 * @author Agu
 *
 */
public class VentaDAO {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Venta getVentaById(int id) {
		// TODO Todavia no es necesarai
		return null;
	}
	
	/**
	 * Almacena un objeto Venta en la Base de Datos. </br>
	 * 
	 * @param venta
	 * @throws VentaInvalidaException 
	 */
	public static void saveVenta(Venta venta) throws VentaInvalidaException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		try{
			// Se asocia Cliente e Inmueble
			sesion.save(venta);
			sesion.update(venta.getInmueble().getEstado());			
			sesion.getTransaction().commit();
		}

		catch(Exception e){
			sesion.getTransaction().rollback();
			e.printStackTrace();
			throw new VentaInvalidaException("Error persistiendo venta (error DAO)");
		}
		finally{
			sesion.close();
		}
	}
	
}
