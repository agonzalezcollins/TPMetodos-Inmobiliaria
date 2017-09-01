package tpmetodos.ui.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import tpmetodos.datos.entidades.constantes.IdFontVentana;
import tpmetodos.datos.entidades.constantes.IdTamVentana;

/**
 * JPanel en forma de título con un JLabel central
 * 
 * @author Agu
 */
public class JPanelTitulo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	
	//private static final Color PANEL_COLORFONDO = new Color(0, 255, 255);
	private static final LineBorder PANEL_BORDELINEA = new LineBorder(new Color(0, 0, 0), 1, true);
	
	/**
	 * Constructor Panel Titulo
	 * @param titulo
	 */
	public JPanelTitulo (String titulo){
		this.setBounds(IdTamVentana.TAM_PANEL_TITULO);
		this.setBorder(PANEL_BORDELINEA);
		//this.setBackground(PANEL_COLORFONDO);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setOpaque(false);
		
		lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(IdFontVentana.FONT_TITULO);
		this.add(lblTitulo);
		
	}
	
}
