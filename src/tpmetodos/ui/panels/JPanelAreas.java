package tpmetodos.ui.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * 
 * @author Agu
 */
public class JPanelAreas extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final EtchedBorder BORDE_FORMATO = new EtchedBorder(EtchedBorder.LOWERED, new Color(191, 205, 219), null);
	
	/**
	 * Constructor Panel Areas
	 */
	public JPanelAreas (String titulo){
		this.setSize(760,this.getHeight());
		this.setBorder(new TitledBorder(BORDE_FORMATO, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setOpaque(false);
	}
	
}
