package tpmetodos.ui.panels;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Agu
 */
public class JPanelFondo extends JPanel {
    
	private static final long serialVersionUID = 1L;
	private Image imagen;
    
	/**
	 * Constructor
	 * Imagen por defecto
	 */
    public JPanelFondo() {
        this.setImagen("/images/Fondo.jpg");
    }

    /**
     * Constructor
     * @param nombreImagen
     */
    public JPanelFondo(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(
                           getClass().getResource(nombreImagen)
                           ).getImage();
        }
    }

    /**
     * Constructor
     * @param imagenInicial
     */
    public JPanelFondo(Image imagenInicial) {
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
    }

    /**
     * Metodo para agregar Imagen a partir de la ruta
     * @param nombreImagen
     */
    public void setImagen(String nombreImagen) {
    	try {
    		
    		String PathGeneral = new File(".").getCanonicalPath();
						
	        if (nombreImagen != null) {
	            imagen = new ImageIcon(PathGeneral + nombreImagen).getImage();
	        } else {
	            imagen = null; 
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally{
			repaint();
		}
     	
    	
        
    }

    /**
     * Metodo para agregar Imagen a partir del archivo
     * @param nuevaImagen
     */
    public void setImagen(Image nuevaImagen) {
        imagen = nuevaImagen;
         repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setComponentesOpaque(false);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }
    
    @Override
    public void print(Graphics g) {
    	// Setea la posicion en la hoja y su tamaño (Del Componente)
    	g.setClip(0, 0, getWidth(), getWidth());
   
    	// Muestras
    	System.out.println("JPanelFondo.print: TAM_W:"+getWidth());
    	System.out.println("JPanelFondo.print: TAM_H:"+getHeight());
    	super.print(g);
    };
    
    /**
     * Metodo para poner en transparente o no, los conponentes hasta el 2do nivel.
     * @param valor (boolean)
     */
    public void setComponentesOpaque(Boolean valor){
        try{
	    	for(Component c1 : this.getComponents()){
	            // Paneles de 1er Nivel
	            JComponent jc1 = (JComponent) c1;
	                // Paneles de 2do Nivel
	                if(jc1 instanceof JPanel){
	                    for(Component c2 : jc1.getComponents()){
	                        JComponent jc2 = (JComponent) c2;
	                        jc2.setOpaque(valor);
	                    }
	                } 
	            jc1.setOpaque(valor);
	        }
        }catch (Exception e) {
			// Nada
		}
    }  
}
