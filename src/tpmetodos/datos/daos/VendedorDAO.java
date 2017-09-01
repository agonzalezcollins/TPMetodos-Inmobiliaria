package tpmetodos.datos.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.datos.hibernate.HibernateUtil;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;
import tpmetodos.servicio.excepciones.VendedorInvalidoException;

public class VendedorDAO {

	/**
	 * Inserta un nuevo vendedor en la base de datos.
	 */
	public static void saveVendedor(Vendedor vendedor) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		try {
			sesion.save(vendedor);
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

	/**
	 * Obtiene un vendedor por su Id. Si no es encontrado en la base de datos
	 * retorna <b>null</b>.
	 */
	public static Vendedor getVendedorById(int idVendedor) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Vendedor vendedor = null;

		try {
			vendedor = (Vendedor) sesion.get(Vendedor.class, idVendedor);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return vendedor;
	}

	/**
	 * Obtiene un vendedor por su usuario y contraseña. Si no es encontrado en
	 * la base de datos retorna <b>null</b>.
	 */
	public static Vendedor getVendedorByUsernameAndPassword(String username,
			String password) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Vendedor vendedor = null;

		try {
			@SuppressWarnings("unchecked")
			List<Vendedor> resultado = sesion.createCriteria(Vendedor.class)
					.add(Restrictions.eq("usuario", username))
					.add(Restrictions.eq("contrasena", password))
					.list();

			if (!resultado.isEmpty()) {
				vendedor = resultado.get(0);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return vendedor;
	}

	/**
	 * Actualiza los datos de un vendedor existente en la base de datos.
	 */
	public static void updateVendedor(Vendedor vendedor) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		try {
			sesion.update(vendedor);
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
	
	/**
	 * Elimina los registros de un vendedor de la base de datos.
	 * @throws VendedorInvalidoException 
	 */
	public static void deleteVendedor(int idVendedor) throws VendedorInexistenteException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		Vendedor vendedor = null;
		boolean found = false;
		
		try {
			vendedor = (Vendedor) sesion.get(Vendedor.class, idVendedor);
			
			if (vendedor != null) {
				sesion.delete(vendedor);
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
			throw new VendedorInexistenteException("Vendedor no encontrado. id = "+idVendedor);
		
	}
	
	public static boolean existeNombreUsuario(String usuario){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		
		boolean existe = false;
		
		try {
			@SuppressWarnings("unchecked")
			List<Vendedor> resultado = sesion.createCriteria(Vendedor.class)
					.add(Restrictions.eq("usuario", usuario))
					.list();

			if (!resultado.isEmpty()) {
				existe = true;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		
		return existe;
	}

	/**
	 * 
	 * @param string
	 * @return objeto vendedor correspondiente
	 */
	public static Vendedor getVendedorByDNI(String string) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Vendedor vendedor = null;

		try {
			@SuppressWarnings("unchecked")
			List<Vendedor> resultado = sesion.createCriteria(Vendedor.class)
					.add(Restrictions.eq("dni", string))
					.list();

			if (!resultado.isEmpty()) {
				vendedor = resultado.get(0);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return vendedor;
	}
	
}
