package tpmetodos.ui.mensajes;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Clase que muestra un mensaje de Advertencia
 * @author Agu
 */
public class MensajeAdvertencia {
    
    /* Variable de respuesta */
    private boolean respuesta=false;
       
    /**
     *  Constructor:
     *  Crea un mensaje de Advertencia con un título y mensaje asignado</b>
     * @param ventana
     * @param titulo
     * @param mensaje 
     */
    public MensajeAdvertencia(Component ventana, String titulo, String mensaje){
        int opcion = JOptionPane.showConfirmDialog(ventana,mensaje,titulo,JOptionPane.YES_NO_OPTION);
        if (opcion==JOptionPane.YES_OPTION)
                respuesta=true;
    }

    /**
     * Devuelve la respuesta del usuario ante el mensaje
     * @return respuesta (boolean)
     */
    public boolean isRespuesta() {
        return respuesta;
    }
    
}
