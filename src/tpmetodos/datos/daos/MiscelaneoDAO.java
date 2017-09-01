package tpmetodos.datos.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import tpmetodos.datos.entidades.Calle;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.Localidad;
import tpmetodos.datos.entidades.Provincia;
import tpmetodos.datos.entidades.TipoDeInmueble;
import tpmetodos.datos.entidades.TipoDeTelefono;
import tpmetodos.datos.hibernate.HibernateUtil;

@SuppressWarnings("unchecked")
public class MiscelaneoDAO {
	
	
	public static Localidad getLocalidadById(int idLocalidad) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Localidad localidad = null;

		try {
			localidad = (Localidad) sesion.get(Localidad.class, idLocalidad);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return localidad;
	}
	
	public static TipoDeTelefono getTipoDeTelefonoById(int idTipoDeTelefono) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		TipoDeTelefono tipoDeTelefono = null;

		try {
			tipoDeTelefono = (TipoDeTelefono) sesion.get(TipoDeTelefono.class, idTipoDeTelefono);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return tipoDeTelefono;
	}

	public static Calle getCalleById(int idCalle) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		Calle calle = null;
		
		try {
			calle = (Calle) sesion.get(Calle.class, idCalle);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		return calle;
	}
	
	public static List<Provincia> getProvincias(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		return sesion.createCriteria(Provincia.class).list();
		
	}
	
	public static List<Localidad> getLocalidadesPorProvincia(Provincia prov){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		return sesion.createCriteria(Localidad.class).add(Restrictions.eq("provincia", prov)).list();
	}
	
	
	public static Provincia getProvinciaById(int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		return (Provincia) sesion.get(Provincia.class, id);
	}
	
	public static List<TipoDeInmueble> getTiposDeInmueble(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		return sesion.createCriteria(TipoDeInmueble.class).list();
		
	}
	
	/**
	 * Metodo utilizado por VentanaConsultaInmueble para realizar el filtrado.
	 * 
	 * @param object
	 * @param object2
	 * @param precioMinimo
	 * @param precioMaximo
	 * @param cantidadDeDormitorios
	 * @return Lista de inmuebles filtrados por los parametros recibidos.
	 */
	public static List<Inmueble> filtrarInmuebles(Localidad localidad, Double precioMinimo, Double precioMaximo, int cantidadDeDormitorios){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		
		
		Criteria crit = sesion.createCriteria(Inmueble.class)								// Defino la clase base sobre la que trabajo
				.add(Restrictions.between("precioDeVenta", precioMinimo, precioMaximo))		// restricciones a esa clase
				.add(Restrictions.eq("cantidadDeDormitorios", cantidadDeDormitorios))		//
				.createCriteria("direccion", "direccion.id")  								// primer join
				.createCriteria("localidad","localidad.id")   								// segundo join
				.add(Restrictions.eq("id", localidad.getId()));								// restricciones a la ultima clase
		
		
		
		
		
		List<Inmueble> result = crit.list();
		
		return result;
		
		
		
	}
}
