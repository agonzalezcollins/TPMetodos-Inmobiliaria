package tpmetodos.servicio.excepciones;
import javax.swing.JOptionPane;

/**
 * @author Martin
 *
 */
public class FormatoDeArchivoInvalidoException extends Exception{
	public FormatoDeArchivoInvalidoException(){
		JOptionPane.showMessageDialog(null, "Debe ingresar un archivo en formato: "+ "'.jpg'" + " o " + "'.png'", "formato de archivo incorrecto", 0);
	}
}
