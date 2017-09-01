package tpmetodos.tests.varios;

import tpmetodos.datos.daos.MiscelaneoDAO;

public class TestLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MiscelaneoDAO.getLocalidadById(10).getProvincia());
	}

}
