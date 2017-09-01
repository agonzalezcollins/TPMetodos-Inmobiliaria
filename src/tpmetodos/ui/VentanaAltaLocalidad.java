package tpmetodos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javassist.tools.framedump;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Martin
 *
 */
public class VentanaAltaLocalidad extends JDialog {

	private JPanel contentPane;
	private JTextField txtfldNuevaLocalidad;

	public VentanaAltaLocalidad() {
		setAlwaysOnTop(true);
		setTitle("Nueva Localidad");
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
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnAceptar.setBounds(22, 82, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setEnabled(true);
			}
		});
		btnCancelar.setBounds(133, 82, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNuevaLocalidad = new JLabel("Localidad");
		lblNuevaLocalidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevaLocalidad.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblNuevaLocalidad.setBounds(22, 21, 85, 14);
		contentPane.add(lblNuevaLocalidad);
		
		txtfldNuevaLocalidad = new JTextField();
		txtfldNuevaLocalidad.setBounds(22, 46, 200, 20);
		contentPane.add(txtfldNuevaLocalidad);
		txtfldNuevaLocalidad.setColumns(10);
	}

}
