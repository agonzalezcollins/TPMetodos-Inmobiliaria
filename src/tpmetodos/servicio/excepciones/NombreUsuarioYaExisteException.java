package tpmetodos.servicio.excepciones;

public class NombreUsuarioYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NombreUsuarioYaExisteException(String mensaje) {
		super(mensaje);
	}
}
