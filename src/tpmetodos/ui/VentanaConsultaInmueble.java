package tpmetodos.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.Localidad;
import tpmetodos.datos.entidades.Provincia;
import tpmetodos.datos.entidades.TipoDeInmueble;
import tpmetodos.datos.entidades.constantes.IdTamVentana;
import tpmetodos.ui.panels.JPanelFondo;

public class VentanaConsultaInmueble extends JInternalFrame {
	
	private JPanel JPanelPanelPrincipal;
	private JTextField textoCantidadDeDormitorios;
	private JTable tablaInmueblesEncontrados;
	private JScrollPane scrollPane;
	private JComboBox comboProvincia;
	private JComboBox comboLocalidad;
	private JRadioButton radioHastaTrecientosMil;
	private JRadioButton radioEntreTrecientosYSeisCientosMil;
	private JRadioButton radioMasDe650;
	private JComboBox comboTipo;
	
	// variables utilizadas en los filtros
	
	
	private Double precioMin, precioMax;
	private Localidad localidadSeleccionada;
	private int cantidadDeDormitoriosIngresada;
	
	// variables para la tabla
	
	String [] nombreDeColumnas = {"Provincia", "Localidad", "Barrio", "Tipo", "Dormitorios", "Precio", "Detalles"};
	Object [][] datosIniciales = {{},{},{},{},{},{},{},{},{},{},{},{}};
	DefaultTableModel modeloTabla = new DefaultTableModel(datosIniciales,nombreDeColumnas);

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaConsultaInmueble frame = new VentanaConsultaInmueble();
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
	public VentanaConsultaInmueble() {
		setBounds(100, 100, 844, 600);

		setBounds(IdTamVentana.TAM_VENTANA);
		JPanelPanelPrincipal = new JPanelFondo();
		JPanelPanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanelPanelPrincipal);
		JPanelPanelPrincipal.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel JPanelPanelSuperior = new JPanel();
		JPanelPanelSuperior.setForeground(Color.BLACK);
		JPanelPanelSuperior.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(191, 205, 219), null), "Buscar inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.foreground")));
		JPanelPanelPrincipal.add(JPanelPanelSuperior);
		JPanelPanelSuperior.setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(70, 34, 95, 14);
		JPanelPanelSuperior.add(lblProvincia);
		
		JLabel lblNewLabel = new JLabel("Localidad");
		lblNewLabel.setBounds(70, 87, 95, 14);
		JPanelPanelSuperior.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(70, 146, 95, 14);
		JPanelPanelSuperior.add(lblNewLabel_1);
		
		JLabel lblCantidadDeDormitorios = new JLabel("Cantidad de Dormitorios");
		lblCantidadDeDormitorios.setBounds(396, 193, 159, 14);
		JPanelPanelSuperior.add(lblCantidadDeDormitorios);
		
		comboProvincia = new JComboBox();
		comboProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cargarLocalidades((Provincia) comboProvincia.getSelectedItem());

			}
		});
		
		comboProvincia.setBounds(223, 34, 115, 20);
		JPanelPanelSuperior.add(comboProvincia);
		
		comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(223, 87, 115, 20);
		JPanelPanelSuperior.add(comboLocalidad);
		
		comboTipo = new JComboBox();
		comboTipo.setBounds(223, 146, 115, 20);
		JPanelPanelSuperior.add(comboTipo);
		
		textoCantidadDeDormitorios = new JTextField();
		textoCantidadDeDormitorios.setHorizontalAlignment(SwingConstants.CENTER);
		textoCantidadDeDormitorios.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				verificarSiEsDigitoCampoCorto(textoCantidadDeDormitorios,arg0);
				
			}
		});
		textoCantidadDeDormitorios.setBounds(591, 193, 104, 20);
		JPanelPanelSuperior.add(textoCantidadDeDormitorios);
		textoCantidadDeDormitorios.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(191, 205, 219), 2, true), "Rango de Precios", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(396, 34, 299, 119);
		JPanelPanelSuperior.add(panel);
		panel.setLayout(null);
		
		ButtonGroup grupoDeBotones = new ButtonGroup();
		
		radioHastaTrecientosMil = new JRadioButton("Hasta $ 300.000");
		radioHastaTrecientosMil.setFont(new Font("Calisto MT", Font.ITALIC, 14));
		radioHastaTrecientosMil.setBounds(29, 22, 117, 25);
		panel.add(radioHastaTrecientosMil);
		radioHastaTrecientosMil.setSelected(true);
		
		radioEntreTrecientosYSeisCientosMil = new JRadioButton("Entre $300.000 y $650.000");
		radioEntreTrecientosYSeisCientosMil.setFont(new Font("Calisto MT", Font.ITALIC, 14));
		radioEntreTrecientosYSeisCientosMil.setBounds(29, 50, 177, 25);
		panel.add(radioEntreTrecientosYSeisCientosMil);
		
		radioMasDe650 = new JRadioButton("Mas de $650.000");
		radioMasDe650.setFont(new Font("Calisto MT", Font.ITALIC, 14));
		radioMasDe650.setBounds(29, 78, 121, 25);
		panel.add(radioMasDe650);
		
		grupoDeBotones.add(radioHastaTrecientosMil);
		grupoDeBotones.add(radioEntreTrecientosYSeisCientosMil);
		grupoDeBotones.add(radioMasDe650);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 228, 625, 8);
		JPanelPanelSuperior.add(separator);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				accionBotonBuscar();
				
			}
		});
		btnBuscar.setBounds(70, 242, 89, 23);
		JPanelPanelSuperior.add(btnBuscar);
		
	
		
		JPanel JPanelPanelInferior = new JPanel();
		JPanelPanelInferior.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(153, 180, 209), null), "Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JPanelPanelPrincipal.add(JPanelPanelInferior);
		JPanelPanelInferior.setLayout(null);
		
		
		
		
		
	
		tablaInmueblesEncontrados = new JTable (this.modeloTabla);
		tablaInmueblesEncontrados.setSurrendersFocusOnKeystroke(true);
		tablaInmueblesEncontrados.setBorder(new EmptyBorder(2, 2, 2, 2));
		tablaInmueblesEncontrados.setVisible(true);
		tablaInmueblesEncontrados.setBounds(0, 0, 750, 270);
		scrollPane = new JScrollPane(tablaInmueblesEncontrados);
		scrollPane.setBounds(10, 20, 765, 220);
		scrollPane.setOpaque(true);
		tablaInmueblesEncontrados.setEnabled(false);
		
		
		JPanelPanelInferior.add(scrollPane,BorderLayout.CENTER);
		

		/**************************************************************/
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borarContenidoDeTabla(tablaInmueblesEncontrados);
			}
		});
		btnBorrar.setBounds(606, 242, 89, 23);
		JPanelPanelSuperior.add(btnBorrar);
		
		
		cargarCombos(); 
		
		
	}
	
	/**
	 * Obtiene los parametros que selecciona el usuario,
	 * filtra los resultados y los muestra en la tabla.
	 */
	protected void accionBotonBuscar() {
		
		this.localidadSeleccionada = (Localidad)this.comboLocalidad.getSelectedItem();
		
		if(this.radioHastaTrecientosMil.isSelected()){
			this.precioMin = 0.0;
			this.precioMax = 300000.0;
		}
		else if(this.radioEntreTrecientosYSeisCientosMil.isSelected()){
			this.precioMin = 300000.0;
			this.precioMax = 600000.0;
		} else {
			this.precioMin = 600000.0;
			this.precioMax = 600000000.0;
		}
			
		this.cantidadDeDormitoriosIngresada = Integer.parseInt(this.textoCantidadDeDormitorios.getText());
		
		List<Inmueble> lista = MiscelaneoDAO.filtrarInmuebles(this.localidadSeleccionada, this.precioMin, this.precioMax, this.cantidadDeDormitoriosIngresada);
		
		
	
		
		//* Procedimiento de carga de la tabla
		
		this.modeloTabla.setDataVector(this.datosIniciales, this.nombreDeColumnas);
		
		int j = 0;
		
		for (Inmueble i : lista){
			
			Object[] datosDeInmuebles = {i.getDireccion().getLocalidad().getProvincia().getNombre(), i.getDireccion().getLocalidad().getNombre(), i.getDireccion().getBarrio(), i.getTipo().getDescripcion(), i.getCantidadDeDormitorios(), i.getPrecioDeVenta(), null};
			
			this.modeloTabla.insertRow(j,datosDeInmuebles);
			
			j++;
		}
		
		
		
	}
	
	
	

	private void borarContenidoDeTabla(JTable tabla) {
		for(int i=0; i<tabla.getRowCount(); i++){
			for(int j=0; j<tabla.getColumnCount(); j++){
				tabla.clearSelection();
			}
		}
		
		
	}
	
	private void verificarSiEsDigitoCampoCorto(JTextField textField,KeyEvent car){
		char caracter = car.getKeyChar();
		int limite = 5;
		if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */) || textField.getText().length() == limite) {
			car.consume(); // ignorar el evento de teclado
		}
	}
	
	private void cargarCombos(){
		
		List<Provincia> provincias = MiscelaneoDAO.getProvincias();
		for (Provincia p : provincias){
			this.comboProvincia.addItem(p);
		}
		
		Provincia provinciaSeleccionada = (Provincia) comboProvincia.getSelectedItem();
		
		cargarLocalidades(provinciaSeleccionada);
		
		
		
		List<TipoDeInmueble> tipos = MiscelaneoDAO.getTiposDeInmueble();
		
		for (TipoDeInmueble t : tipos){
			this.comboTipo.addItem(t);
		}
		
		
	}
	
	private void cargarLocalidades(Provincia provinciaSeleccionada){
		
		this.comboLocalidad.removeAllItems();
		
		List<Localidad> localidades = MiscelaneoDAO.getLocalidadesPorProvincia(provinciaSeleccionada);
		
		for (Localidad l : localidades){
			this.comboLocalidad.addItem(l);
		}
	}
	

}
