package tpmetodos.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import tpmetodos.datos.entidades.constantes.IdTipoDeTelefono;
import tpmetodos.dtos.TelefonoDTO;
import tpmetodos.dtos.VendedorDTO;
import tpmetodos.servicio.VendedorService;
import tpmetodos.servicio.excepciones.NombreUsuarioYaExisteException;
import tpmetodos.servicio.excepciones.VendedorInvalidoException;
import tpmetodos.ui.panels.JPanelFondo;
import tpmetodos.ui.textfields.JTextFieldNumerosNaturales;

public class VentanaAltaVendedor extends javax.swing.JInternalFrame {
	
	private final JTextField textoNombre;
	private final JTextField textoApellido;
	private final JTextField textoUsuario;
	private final JTextFieldNumerosNaturales textoDNI;
	private final JTextField textoFecha;
	private final JTextFieldNumerosNaturales textoTelefono;
	private final JTextFieldNumerosNaturales textoCelular;
	private final JTextField textoContrasenia;
	private final JButton btnAlta;
	private final JSeparator separator;
	private final JLabel lblNewLabel_1;
	private final JButton btnNewButton;
	private final JLabel lblCelular;
	private final JLabel lblTelefonoFijo;
	private final JLabel lblApellido;
	private final JLabel lblDireccion;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					VentanaAltaVendedor frame = new VentanaAltaVendedor();
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
	public VentanaAltaVendedor() {
		setBounds(100, 100, 871, 691);
		
		this.setContentPane(new JPanelFondo());
		
		textoNombre = new JTextField();
		textoNombre.setBounds(218, 147, 170, 20);
		textoNombre.setColumns(10);
		
		textoApellido = new JTextField();
		textoApellido.setBounds(587, 147, 170, 20);
		textoApellido.setColumns(10);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(218, 312, 170, 20);
		textoUsuario.setColumns(10);
		
		textoDNI = new JTextFieldNumerosNaturales(10,8);
		textoDNI.setBounds(218, 229, 170, 20);
		textoDNI.setColumns(10);
		
		textoFecha = new JTextField();
		textoFecha.setText("aaaa-mm-dd");
		textoFecha.setBounds(587, 229, 170, 20);
		textoFecha.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(498, 149, 60, 17);
		
		lblDireccion = new JLabel("Usuario");
		lblDireccion.setBounds(119, 314, 55, 17);
		
		textoTelefono = new JTextFieldNumerosNaturales(10,15);
		textoTelefono.setBounds(587, 393, 170, 20);
		textoTelefono.setColumns(10);
		
		textoCelular = new JTextFieldNumerosNaturales(10,15);
		textoCelular.setBounds(587, 312, 170, 20);
		textoCelular.setColumns(10);
		
		lblTelefonoFijo = new JLabel("Telefono fijo");
		lblTelefonoFijo.setBounds(467, 396, 91, 14);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(483, 314, 75, 17);
		
		lblNewLabel_1 = new JLabel("Alta de vendedor");
		lblNewLabel_1.setBounds(392, 12, 181, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		btnAlta = new JButton("Alta");
		btnAlta.setIconTextGap(15);
		btnAlta.setBounds(218, 609, 170, 37);
		btnAlta.addActionListener(altaListener);
		
		btnNewButton = new JButton("Limpiar campos");
		btnNewButton.addActionListener(limpiarListener);
		btnNewButton.setBounds(519, 609, 170, 37);
		
		textoContrasenia = new JPasswordField();
		textoContrasenia.setBounds(218, 393, 170, 20);
		textoContrasenia.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(lblDireccion);
		getContentPane().add(textoUsuario);
		getContentPane().add(textoContrasenia);
		getContentPane().add(textoNombre);
		getContentPane().add(textoDNI);
		getContentPane().add(lblApellido);
		getContentPane().add(lblTelefonoFijo);
		getContentPane().add(lblCelular);
		getContentPane().add(btnAlta);
		getContentPane().add(btnNewButton);
		getContentPane().add(textoApellido);
		getContentPane().add(textoFecha);
		getContentPane().add(textoTelefono);
		getContentPane().add(textoCelular);
		getContentPane().add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setBounds(10, 51, 1129, 3);
		getContentPane().add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(128, 150, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(440, 232, 118, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblDni_1 = new JLabel("DNI");
		lblDni_1.setBounds(128, 232, 46, 14);
		getContentPane().add(lblDni_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(108, 396, 66, 14);
		getContentPane().add(lblContrasea);

	}
	
	private final ActionListener altaListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			VendedorDTO dto = new VendedorDTO();
			//nombre, apellido, usuario, contraseña, DNI
			
			dto.setNombres(textoNombre.getText());
			dto.setApellidos(textoApellido.getText());
			dto.setContrasena(textoContrasenia.getText());
			dto.setUsuario(textoUsuario.getText());
			dto.setContrasena(textoContrasenia.getText());
			dto.setDni(textoDNI.getText());
			//instanciar fecha
			try{
				Date fecha = Date.valueOf(textoFecha.getText());
				dto.setFechaDeNacimiento(fecha);
			}
			catch(Exception e2){
				JOptionPane.showMessageDialog(null, "Error en formato de fecha. Debe ser 'aaaa-mm-dd', por ejemplo 2013-01-25");
				return;
			}
			//cargar telefonos
			List<TelefonoDTO> tel = new ArrayList<TelefonoDTO>();
			TelefonoDTO fijo = new TelefonoDTO();
			fijo.setCodigoDeArea("0342");
			fijo.setIdTipo(IdTipoDeTelefono.FIJO);
			fijo.setNumero(textoTelefono.getText());
			TelefonoDTO cel = new TelefonoDTO();
			cel.setCodigoDeArea("0342");
			cel.setIdTipo(IdTipoDeTelefono.CELULAR);
			cel.setNumero(textoCelular.getText());
			tel.add(fijo);
			tel.add(cel);
			dto.setTelefonos(tel);
			
			
			try {
				
				VendedorService.altaVendedor(dto);
				JOptionPane.showMessageDialog(null, "Vendedor dado de alta correctamente");
				limpiarListener.actionPerformed(null);
				
			} catch (VendedorInvalidoException
					| NombreUsuarioYaExisteException e1) {
				// TODO acciones a realizar en caso de no poder crearse el vendedor.
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	};
	
	private final ActionListener limpiarListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			textoApellido.setText("");
			textoCelular.setText("");
			textoContrasenia.setText("");
			textoDNI.setText("");
			textoFecha.setText("");
			textoNombre.setText("");
			textoTelefono.setText("");
			textoUsuario.setText("");
			
			
			
			
		}
	};
}

	
