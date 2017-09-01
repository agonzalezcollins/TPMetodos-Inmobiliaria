package tpmetodos.ui.mensajes;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Clase que muestra un mensaje de Alerta
 * @author Agu
 */
public class MensajeAlerta {
    
	/**
	 * Constructor:
	 * Crea un mensaje de Alerta con un título y mensaje asignado</b>
	 * 
	 * @param ventana
	 * @param titulo
	 * @param mensaje
	 */
    public MensajeAlerta(Component ventana, String titulo, String mensaje){
        
        JOptionPane jOptionPane = new JOptionPane(mensaje, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = jOptionPane.createDialog(ventana, titulo);
        Toolkit.getDefaultToolkit().beep(); // Alerta Auditiva
        dialog.setModal(true); // No Permite ir a la paguina anterior hasta cerrar
        dialog.pack();
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
    }
}
