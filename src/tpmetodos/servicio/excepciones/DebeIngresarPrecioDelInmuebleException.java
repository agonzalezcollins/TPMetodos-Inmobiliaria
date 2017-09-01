package tpmetodos.servicio.excepciones;
import javax.swing.JOptionPane;


/**
 * @author Martin
 *
 */

public class  DebeIngresarPrecioDelInmuebleException extends Exception{
	public DebeIngresarPrecioDelInmuebleException(){
		JOptionPane.showMessageDialog(null, "Debe ingresar el precio del Inmueble ($)", "formato de archivo incorrecto", 0);
	}
}