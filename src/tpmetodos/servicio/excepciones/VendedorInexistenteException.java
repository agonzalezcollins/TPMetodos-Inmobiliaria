package tpmetodos.servicio.excepciones;

public class VendedorInexistenteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public VendedorInexistenteException(String mensaje) {
		super(mensaje);
	}
}
