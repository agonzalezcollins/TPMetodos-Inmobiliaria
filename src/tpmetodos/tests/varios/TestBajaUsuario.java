package tpmetodos.tests.varios;

import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Telefono;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;

public class TestBajaUsuario {

	public static void main(String[] args) throws VendedorInexistenteException {
		//VendedorDAO.deleteVendedor(6);
		Vendedor v = VendedorDAO.getVendedorById(14);
		for(Telefono t : v.getTelefonos()){
			System.out.println(t.getCodigoDeArea()+" "+t.getNumero());
		}
	}

}
