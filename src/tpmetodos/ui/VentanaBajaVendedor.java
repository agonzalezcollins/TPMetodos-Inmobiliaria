package tpmetodos.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.servicio.VendedorService;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;
import tpmetodos.ui.panels.JPanelFondo;

public class VentanaBajaVendedor extends JInternalFrame {
	private JTextField textoDNI;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private int idVendedorAEliminar;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaBajaVendedor frame = new VentanaBajaVendedor();
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
	public VentanaBajaVendedor() {
		setBounds(100, 100, 1064, 722);
		this.setContentPane(new JPanelFondo());
		getContentPane().setLayout(null);
		
		textoDNI = new JTextField();
		textoDNI.setBounds(564, 164, 153, 20);
		getContentPane().add(textoDNI);
		textoDNI.setColumns(10);
		
		textoNombre = new JTextField();
		textoNombre.setEditable(false);
		textoNombre.setBounds(564, 248, 153, 20);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);
		
		textoApellido = new JTextField();
		textoApellido.setEditable(false);
		textoApellido.setBounds(561, 335, 159, 20);
		getContentPane().add(textoApellido);
		textoApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(508, 167, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(497, 251, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(497, 338, 46, 14);
		getContentPane().add(lblApellido);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				accionBotonBuscar();
				
				
			}
		});
		btnBuscar.setBounds(478, 432, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				accionBotonEliminar();
				
			}
		});
		btnEliminar.setBounds(628, 432, 89, 23);
		getContentPane().add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 1028, 2);
		getContentPane().add(separator);
		
		JLabel lblEliminarVendedor = new JLabel("Eliminar vendedor");
		lblEliminarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEliminarVendedor.setBounds(439, 11, 170, 34);
		getContentPane().add(lblEliminarVendedor);
		
		JLabel lblInstrucciones = new JLabel("Instrucciones:\r\n");
		lblInstrucciones.setBounds(196, 215, 160, 17);
		getContentPane().add(lblInstrucciones);
		
		JLabel lblIngreseEl = new JLabel("1) Ingrese el DNI del vendedor a eliminar");
		lblIngreseEl.setBounds(141, 259, 303, 20);
		getContentPane().add(lblIngreseEl);
		
		JLabel lblClickEn = new JLabel("2) Click en Buscar");
		lblClickEn.setBounds(141, 312, 215, 14);
		getContentPane().add(lblClickEn);
		
		JLabel lblSiLos = new JLabel("3) Si los datos son correctos, click en eliminar");
		lblSiLos.setBounds(141, 359, 348, 23);
		getContentPane().add(lblSiLos);

	}

	
	void accionBotonBuscar() {
		try {
		Vendedor v = VendedorService.getVendedorByDNI(this.textoDNI.getText());
		
		
		
		this.idVendedorAEliminar = v.getId();
		this.textoNombre.setText(v.getNombres());
		this.textoApellido.setText(v.getApellidos());
			} catch (VendedorInexistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
	}
	
	void accionBotonEliminar() {
		try {
		
			
			VendedorService.eliminarVendedor(idVendedorAEliminar);
			
			JOptionPane.showMessageDialog(null, "El vendedor ha sido eliminado correctamente");
			limpiarcampos();
			} catch (VendedorInexistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				
			}
		
	}

	private void limpiarcampos() {
		this.textoApellido.setText("");
		this.textoDNI.setText("");
		this.textoNombre.setText("");
		
	}
	
	
}
