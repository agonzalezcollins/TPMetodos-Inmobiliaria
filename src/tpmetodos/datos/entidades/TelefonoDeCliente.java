package tpmetodos.datos.entidades;

public class TelefonoDeCliente extends Telefono {
	
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
