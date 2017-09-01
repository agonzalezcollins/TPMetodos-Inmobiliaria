package tpmetodos.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * @author Martin
 *
 */
public class VentanaAltaCalle extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtfldNuevaCalle;
	public VentanaAltaCalle() {
		cargarNuevaCalle();
	}
	
	public void cargarNuevaCalle(){
		setAlwaysOnTop(true);
		setTitle("Nueva Calle");
		setResizable(false);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		
		btnAceptar.setBounds(22, 82, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		
		btnCancelar.setBounds(133, 82, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNuevaCalle = new JLabel("Calle");
		lblNuevaCalle.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevaCalle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblNuevaCalle.setBounds(22, 21, 85, 14);
		contentPane.add(lblNuevaCalle);
		
		txtfldNuevaCalle = new JTextField();
		txtfldNuevaCalle.setBounds(22, 46, 200, 20);
		contentPane.add(txtfldNuevaCalle);
		txtfldNuevaCalle.setColumns(10);
	}

}
