package tpmetodos.ui.mensajes;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Clase que muestra un mensaje de Exito - Informacion
 * @author Agu
 */
public class MensajeInformacionExito {

	/**
	 * Constructor:
	 * Crea un mensaje de exito o informacion con un título y mensaje asignado</b>
	 * 
	 * 
	 * @param ventana
	 * @param titulo
	 * @param mensaje
	 */
    public MensajeInformacionExito(Component ventana, String titulo, String mensaje){
                
        JOptionPane jOptionPane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = jOptionPane.createDialog(ventana, titulo);
        dialog.setModal(true); // No Permite ir a la paguina anterior hasta cerrar
        dialog.pack();
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
    } 
}
