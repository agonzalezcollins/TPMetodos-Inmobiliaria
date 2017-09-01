package tpmetodos.ui;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tpmetodos.datos.entidades.constantes.IdTamVentana;
import tpmetodos.ui.panels.JPanelFondo;

/**
 * 
 * @author Ramiro
 *
 */
public class VentanaIniciarSesion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaIniciarSesion frame = new VentanaIniciarSesion();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaIniciarSesion() {
		this.setBounds(IdTamVentana.TAM_VENTANA);
		
		this.setContentPane(new JPanelFondo());
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(251)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(204)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(239, 135, 219, 36);
		panel.add(passwordField_1);
		
		JButton button = new JButton("Iniciar Sesion");
		button.setBounds(275, 236, 146, 42);
		panel.add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 61, 219, 36);
		panel.add(textField_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(138, 73, 75, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(110, 144, 119, 14);
		panel.add(lblContrasea);
		getContentPane().setLayout(groupLayout);

	}
}
