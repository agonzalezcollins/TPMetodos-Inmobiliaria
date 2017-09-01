package tpmetodos.datos.entidades;

public class TelefonoDePropietario extends Telefono {
	
	private Propietario propietario;

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
}
