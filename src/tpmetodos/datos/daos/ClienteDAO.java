package tpmetodos.datos.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import tpmetodos.datos.entidades.Cliente;
import tpmetodos.datos.hibernate.HibernateUtil;

@SuppressWarnings(value="unchecked")

public class ClienteDAO {


	/**
	 * Obtiene un cliente por su Id. Si no es encontrado en la base de datos
	 * retorna <b>null</b>.
	 */
	public static Cliente getClienteById(int idCliente) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		
		Cliente cliente = null;

		try {
			cliente = (Cliente) sesion.get(Cliente.class, idCliente);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}

		return cliente;
	}

	/**
	 * Obtiene un cliente por su Id. Si no es encontrado en la base de datos
	 * retorna <b>null</b>.
	 */

	public static List<Cliente> getClienteByApellido(String apellidoCliente) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();		

		try {
			Criteria criteria = sesion.createCriteria(Cliente.class).add(Restrictions.eq("apellidos", apellidoCliente));
			return criteria.list(); //TODO PROBLEMAS .list()
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		return null;
	}

	/**
	 * 
	 * @param string
	 * @return objeto Cliente correspondiente
	 */
	public static List<Cliente> getClienteByDNI(String stringDNI) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sesion = sf.openSession();
		sesion.beginTransaction();

		try {
			Criteria criteria = sesion.createCriteria(Cliente.class).add(Restrictions.eq("dni", stringDNI));
			return criteria.list(); //TODO PROBLEMAS .list()
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sesion.close();
		}
		return null;
	}
	
}
