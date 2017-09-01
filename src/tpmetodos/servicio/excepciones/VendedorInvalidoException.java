package tpmetodos.servicio.excepciones;

public class VendedorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public VendedorInvalidoException(String mensaje) {
		super(mensaje);
	}
}
