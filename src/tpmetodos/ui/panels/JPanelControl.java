package tpmetodos.ui.panels;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * JPanel que contiene dos botones como control universal de todas las ventanas
 * 
 * @author Agu
 */
public class JPanelControl extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	/**
	 * Constructor Panel Controls sin botones
	 */
	public JPanelControl (){
		this.setSize(760, 30);
		this.setLocation(20, 540);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setOpaque(false);
		
	}
	/**
	 * Constructor Panel Controls con botones
	 */
	public JPanelControl (String bntAceptar, String bntCancelar){
		this.setSize(760, 30);
		this.setLocation(20, 540);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setOpaque(false);
		
		// Botones
		btnAceptar = new JButton(bntAceptar);
		btnCancelar = new JButton(bntCancelar);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.add(btnAceptar);
		this.add(btnCancelar);
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
}
