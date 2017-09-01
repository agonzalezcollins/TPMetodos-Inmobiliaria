package tpmetodos.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tpmetodos.datos.entidades.TelefonoDeVendedor;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.datos.entidades.constantes.IdTipoDeTelefono;
import tpmetodos.dtos.TelefonoDTO;
import tpmetodos.dtos.VendedorDTO;
import tpmetodos.servicio.VendedorService;
import tpmetodos.servicio.excepciones.NombreUsuarioYaExisteException;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;
import tpmetodos.servicio.excepciones.VendedorInvalidoException;

import tpmetodos.ui.panels.JPanelFondo;

import tpmetodos.ui.textfields.JTextFieldNumerosNaturales;


public class VentanaModificarVendedor extends JInternalFrame {
	private JTextField textoNombre;
	private JTextFieldNumerosNaturales textoDNI;
	private JTextField textoUsuario;
	private JPasswordField textoContrasenia;
	private JTextFieldNumerosNaturales textoFijo;
	private JTextFieldNumerosNaturales textoCelular;
	private JTextField textoFecha;
	private JTextField textoApellido;
	private Vendedor vendedorActual;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaModificarVendedor frame = new VentanaModificarVendedor();
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
	public VentanaModificarVendedor() {
		setBounds(100, 100, 978, 638);
		this.setContentPane(new JPanelFondo());
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(147, 154, 46, 14);
		getContentPane().add(label);
		
		textoNombre = new JTextField();
		textoNombre.setEditable(false);
		textoNombre.setColumns(10);
		textoNombre.setBounds(237, 151, 170, 20);
		getContentPane().add(textoNombre);
		
		JLabel label_1 = new JLabel("DNI");
		label_1.setBounds(147, 236, 46, 14);
		getContentPane().add(label_1);
		
		textoDNI = new JTextFieldNumerosNaturales(10,8);
		textoDNI.setColumns(10);
		textoDNI.setBounds(237, 233, 170, 20);
		getContentPane().add(textoDNI);
		
		JLabel label_2 = new JLabel("Usuario");
		label_2.setBounds(138, 318, 55, 17);
		getContentPane().add(label_2);
		
		textoUsuario = new JTextField();
		textoUsuario.setEditable(false);
		textoUsuario.setColumns(10);
		textoUsuario.setBounds(237, 316, 170, 20);
		getContentPane().add(textoUsuario);
		
		JLabel label_3 = new JLabel("Contrase\u00F1a");
		label_3.setBounds(127, 400, 66, 14);
		getContentPane().add(label_3);
		
		textoContrasenia = new JPasswordField();
		textoContrasenia.setEditable(false);
		textoContrasenia.setColumns(10);
		textoContrasenia.setBounds(237, 397, 170, 20);
		getContentPane().add(textoContrasenia);
		
		JLabel label_4 = new JLabel("Telefono fijo");
		label_4.setBounds(486, 400, 91, 14);
		getContentPane().add(label_4);
		
		textoFijo = new JTextFieldNumerosNaturales(10,15);
		textoFijo.setEditable(false);
		textoFijo.setColumns(10);
		textoFijo.setBounds(606, 397, 170, 20);
		getContentPane().add(textoFijo);
		
		JLabel label_5 = new JLabel("Celular");
		label_5.setBounds(502, 318, 75, 17);
		getContentPane().add(label_5);
		
		textoCelular = new JTextFieldNumerosNaturales(10,15);
		textoCelular.setEditable(false);
		textoCelular.setColumns(10);
		textoCelular.setBounds(606, 316, 170, 20);
		getContentPane().add(textoCelular);
		
		JLabel label_6 = new JLabel("Fecha de nacimiento");
		label_6.setBounds(459, 236, 118, 14);
		getContentPane().add(label_6);
		
		textoFecha = new JTextField();
		textoFecha.setEditable(false);
		textoFecha.setText("aaaa-mm-dd");
		textoFecha.setColumns(10);
		textoFecha.setBounds(606, 233, 170, 20);
		getContentPane().add(textoFecha);
		
		JLabel label_7 = new JLabel("Apellido");
		label_7.setBounds(517, 153, 60, 17);
		getContentPane().add(label_7);
		
		textoApellido = new JTextField();
		textoApellido.setEditable(false);
		textoApellido.setColumns(10);
		textoApellido.setBounds(606, 151, 170, 20);
		getContentPane().add(textoApellido);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonBuscar();
			}
		});
		btnNewButton.setBounds(237, 500, 170, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accionBotonModificar();
				
			}
		});
		btnModificar.setBounds(606, 500, 170, 23);
		getContentPane().add(btnModificar);

	}
	
	/**
	 * Busco el vendedor por DNI, a fines de modificarlo.
	 */
	void accionBotonBuscar() {
		
		try {
		vendedorActual = VendedorService.getVendedorByDNI(this.textoDNI.getText());
		
		
		this.textoNombre.setText(vendedorActual.getNombres());
		this.textoApellido.setText(vendedorActual.getApellidos());
		this.textoContrasenia.setText(vendedorActual.getContrasena());
		this.textoFecha.setText(vendedorActual.getFechaDeNacimiento().toString().substring(0,10));
		this.textoNombre.setText(vendedorActual.getNombres());
		this.textoUsuario.setText(vendedorActual.getUsuario());
		
		
		Iterator iterador = vendedorActual.getTelefonos().iterator();
		while (iterador.hasNext()){
			TelefonoDeVendedor tel = (TelefonoDeVendedor) iterador.next();
			if(tel.getTipo().getId() == IdTipoDeTelefono.CELULAR)
				this.textoCelular.setText(tel.getNumero());
			else
				this.textoFijo.setText(tel.getNumero());
		}
		
		
		
		
		
		habilitarCampos();
		
		
		
		
		
		
			} catch (VendedorInexistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
	}
	
	private void habilitarCampos() {
		
		this.textoNombre.setEditable(true);
		this.textoApellido.setEditable(true);
		this.textoContrasenia.setEditable(true);
		this.textoFecha.setEditable(true);
		this.textoNombre.setEditable(true);
		this.textoUsuario.setEditable(true);
		this.textoCelular.setEditable(true);
		this.textoFijo.setEditable(true);
		
	}
	
private void deshabilitarCampos() {
		
		this.textoNombre.setEditable(false);
		this.textoApellido.setEditable(false);
		this.textoContrasenia.setEditable(false);
		this.textoFecha.setEditable(false);
		this.textoNombre.setEditable(false);
		this.textoUsuario.setEditable(false);
		this.textoCelular.setEditable(false);
		this.textoFijo.setEditable(false);
		
	}

	/**
	 * con los datos que ingresa el usuario, se crea un nuevo
	 * vendedorDTO que se pasa al metodo de modificacion.
	 */
	void accionBotonModificar() {

		try {
			vendedorActual.setApellidos(this.textoApellido.getText());
			vendedorActual.setContrasena(this.textoContrasenia.getPassword()
					.toString());
			vendedorActual.setDni(this.textoDNI.getText());
			vendedorActual.setFechaDeNacimiento(Date.valueOf(this.textoFecha
					.getText()));
			vendedorActual.setNombres(this.textoNombre.getText());
			vendedorActual.setApellidos(this.textoApellido.getText());

			/**
			 * carga del atributo telofonos, para luego ponerlo en el DTO que se
			 * le pasa al metodo que modifica.
			 */

			VendedorDTO vdto = new VendedorDTO(vendedorActual);
			List<TelefonoDTO> tel = new ArrayList<TelefonoDTO>();
			TelefonoDTO fijo = new TelefonoDTO();
			fijo.setCodigoDeArea("0342");
			fijo.setIdTipo(IdTipoDeTelefono.FIJO);
			fijo.setNumero(textoFijo.getText());
			TelefonoDTO cel = new TelefonoDTO();
			cel.setCodigoDeArea("0342");
			cel.setIdTipo(IdTipoDeTelefono.CELULAR);
			cel.setNumero(textoCelular.getText());
			tel.add(fijo);
			tel.add(cel);
			vdto.setTelefonos(tel);

			VendedorService.modificarVendedor(vdto);
			/**
			 * TODO ver que pasa aca. Me tira una excepcion en el DTO pero sigue
			 * la ejecucion y muestra el mensaje.
			 */
			JOptionPane.showMessageDialog(null, "Modificacion exitosa.");

			this.limpiarCampos();
			this.deshabilitarCampos();

		} catch (VendedorInvalidoException | NombreUsuarioYaExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception desconocida) {
			JOptionPane.showMessageDialog(null,
					"Ocurrio un error, el vendedor no fue actualizado. Revise los campos ingresados.");
			desconocida.printStackTrace();
			limpiarCampos();
			deshabilitarCampos();
			this.vendedorActual = null;
		}

	}

	private void limpiarCampos() {
		textoApellido.setText("");
		textoCelular.setText("");
		textoContrasenia.setText("");
		textoDNI.setText("");
		textoFecha.setText("");
		textoNombre.setText("");
		textoCelular.setText("");
		textoUsuario.setText("");
		textoFijo.setText("");
		
	}

}
