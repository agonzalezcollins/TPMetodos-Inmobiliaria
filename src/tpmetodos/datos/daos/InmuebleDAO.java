package tpmetodos.datos.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tpmetodos.datos.entidades.EstadoDeInmueble;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.Orientacion;
import tpmetodos.datos.entidades.TipoDeInmueble;
import tpmetodos.datos.hibernate.HibernateUtil;
import tpmetodos.servicio.excepciones.InmuebleInexistenteException;
@SuppressWarnings("unchecked")
public class InmuebleDAO {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Inmueble getInmuebleById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Inmueble inm= null;

		try {
			inm = (Inmueble) sesion.get(Inmueble.class, id);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return inm;
	}

	/**
	 * 
	 * @return
	 */
	public static List<Inmueble> getInmuebles(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		List<Inmueble> inmuebles= new ArrayList<Inmueble>();
		
		try {
			
			return sesion.createCriteria(Inmueble.class).list();
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		return inmuebles;
	}
	
	/**
	 * 
	 * @param idOrientacion
	 * @return
	 */
	public static Orientacion getOrientacionById(int idOrientacion) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Orientacion ori= null;

		try {
			ori= (Orientacion)sesion.get(Orientacion.class, idOrientacion);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return ori;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Orientacion> getOrientaciones(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		List<Orientacion> orientaciones = new ArrayList<Orientacion>();
		
		try {
			
			return sesion.createCriteria(Orientacion.class).list();
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		return orientaciones;
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<EstadoDeInmueble> getEstadosDeInmueble(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		List<EstadoDeInmueble> estadosInmuebles = new ArrayList<EstadoDeInmueble>();

		try {
			
			return sesion.createCriteria(EstadoDeInmueble.class).list();
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		return estadosInmuebles;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<TipoDeInmueble> getTiposDeInmueble(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		return sesion.createCriteria(TipoDeInmueble.class).list();
		
	}

	public static EstadoDeInmueble getEstadoById(int idEstado) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		EstadoDeInmueble estado= null;

		try {
			estado = (EstadoDeInmueble) sesion.get(EstadoDeInmueble.class, idEstado);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return estado;
	}

	public static TipoDeInmueble getTipoById(int idTipo) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		TipoDeInmueble tipo= null;

		try {
			tipo = (TipoDeInmueble) sesion.get(TipoDeInmueble.class, idTipo);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return tipo;
	}

	public static void saveInmueble(Inmueble inm) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		try{
			sesion.save(inm.getDireccion());
			sesion.save(inm);
			sesion.getTransaction().commit();
		}
		catch(Exception e){
			sesion.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			sesion.close();
		}
	}
	
	public static void updateInmueble(Inmueble inm){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		try {
			sesion.update(inm.getDireccion());
			sesion.update(inm);
			sesion.getTransaction().commit();
		}
		catch (Exception ex) {
			sesion.getTransaction().rollback();
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
	}
	
	public static void deleteInmueble(int id) throws InmuebleInexistenteException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		Inmueble inm= null;
		boolean found = false;
		
		try {
			inm = (Inmueble) sesion.get(Inmueble.class, id);
			
			if (inm != null) {
				sesion.delete(inm);
				sesion.getTransaction().commit();
				found = true;
			}
		}
		catch (Exception ex) {
			sesion.getTransaction().rollback();
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		if(!found)
			throw new InmuebleInexistenteException("inmueble no encontrado. id = "+id);
	}
	
}
