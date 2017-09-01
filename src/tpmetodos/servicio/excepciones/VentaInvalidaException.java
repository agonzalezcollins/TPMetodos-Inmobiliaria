package tpmetodos.servicio.excepciones;

public class VentaInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public VentaInvalidaException(String mensaje) {
		super(mensaje);
	}

}
