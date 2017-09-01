package tpmetodos.tests.varios;

import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Calle;
import tpmetodos.datos.entidades.Localidad;

public class TestDaoCalle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//prueba calles y localidades
		Calle calle = MiscelaneoDAO.getCalleById(1);
		System.out.println(calle.getNombre() + " " + calle.getId() + calle.getLocalidad().getNombre());
		Localidad loc = MiscelaneoDAO.getLocalidadById(1);
		System.out.println(loc.getNombre());
		System.out.println(loc.getProvincia().getPais().getNombre());
		
		//prueba usuarios
		boolean existe= VendedorDAO.existeNombreUsuario("jperez");
		System.out.println("existe jperez? "+existe);
		existe= VendedorDAO.existeNombreUsuario("pancho");
		System.out.println("existe pancho? "+existe);
		
		
	}

}
