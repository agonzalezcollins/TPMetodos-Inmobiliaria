package tpmetodos.tests.varios;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.servicio.excepciones.InmuebleInexistenteException;

public class TestInmueble {

	public static void main(String[] args)  {
		/*Inmueble inm = InmuebleDAO.getInmuebleById(1);
		System.out.println(inm);
		
		try {
			InmuebleDAO.deleteInmueble(9);
		} catch (InmuebleInexistenteException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}*/
		
		System.out.println(InmuebleDAO.getInmuebles());
	}
	

}
