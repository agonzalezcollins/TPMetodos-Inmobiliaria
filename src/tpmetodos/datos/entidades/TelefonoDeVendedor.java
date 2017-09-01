package tpmetodos.datos.entidades;

import tpmetodos.dtos.TelefonoDTO;

public class TelefonoDeVendedor extends Telefono {
	
	private Vendedor vendedor;

	public TelefonoDeVendedor(){
		
	}
	
	public TelefonoDeVendedor(TelefonoDTO tel) {
		super(tel);
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
