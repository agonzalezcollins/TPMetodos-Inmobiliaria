package tpmetodos.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tpmetodos.datos.daos.ClienteDAO;
import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.datos.entidades.Cliente;
import tpmetodos.datos.entidades.Localidad;
import tpmetodos.datos.entidades.Provincia;
import tpmetodos.datos.entidades.constantes.IdEstado;
import tpmetodos.datos.entidades.constantes.IdFontVentana;
import tpmetodos.datos.entidades.constantes.IdTamVentana;
import tpmetodos.datos.entidades.constantes.IdTipoDeInmueble;
import tpmetodos.dtos.ClienteDTO;
import tpmetodos.dtos.DireccionDTO;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.dtos.VentaDTO;
import tpmetodos.servicio.VentaService;
import tpmetodos.servicio.excepciones.VentaInvalidaException;
import tpmetodos.ui.mensajes.MensajeAlerta;
import tpmetodos.ui.panels.JPanelAreas;
import tpmetodos.ui.panels.JPanelControl;
import tpmetodos.ui.panels.JPanelFondo;
import tpmetodos.ui.panels.JPanelFoto;
import tpmetodos.ui.panels.JPanelTitulo;
import tpmetodos.ui.tablas.JTableBuscarCliente;
import tpmetodos.ui.textfields.JTextFieldAlfanumerico;
import tpmetodos.ui.textfields.JTextFieldNumeroReales;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class VentanaVenta extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel JPanelPanelPrincipal;
	
	private JTextFieldAlfanumerico textFieldBuscarCliente;
	private JTextFieldNumeroReales textFieldImporteVenta;
	private JTableBuscarCliente tableClientes;
	private JPanel pFoto;
	
	private JTextField jtextLocalidad;
	private JTextField jtextProvincia;
	private JTextField jtextBarrio;
	private JTextField jtextTipo;
	private JTextField jtextPiso;
	private JTextField jtextDepto;
	private JTextField jtextCalle;
	private JTextField jtextNumero;
	private JTextField jtextEstado;
	private JTextField jtextValor;

	private PageFormat format;
	
	private VentaDTO dtoVenta;
	private JFrame parent;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Inmueble i = InmuebleDAO.getInmuebleById(3);
//					InmuebleDTO inmueble = new InmuebleDTO(i);
//					VentanaVenta frame = new VentanaVenta(null, inmueble);
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
	public VentanaVenta(JFrame parent,InmuebleDTO dtoInmueble) {
		
		// Crea DTO Ventana
		dtoVenta = new VentaDTO();
		
		if (dtoInmueble == null){
			InmuebleDTO inmueble = new InmuebleDTO();
			inmueble.setId(0);
			dtoVenta.setInmueble(inmueble);
		}
		else{
			dtoVenta.setInmueble(dtoInmueble);
		}
		
		// Configuracion Frame
		this.parent  = parent;
		setTitle("Venta Inmueble");
		//setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(IdTamVentana.TAM_VENTANA);
		
		// Panel Principal
		JPanelPanelPrincipal = new JPanelFondo();
		JPanelPanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanelPanelPrincipal);
		JPanelPanelPrincipal.setLayout(null);
		
		// Panel Titulo
		JPanel jPanelPanelTitulo = new JPanelTitulo("Venta");
		JPanelPanelPrincipal.add(jPanelPanelTitulo);
		
		// Panel Cliente
		JPanel jPanelPanelCliente = new JPanelAreas("Cliente");
		jPanelPanelCliente.setBounds(20, 67, 760, 231);
		JPanelPanelPrincipal.add(jPanelPanelCliente);
		jPanelPanelCliente.setLayout(null);
		
		textFieldBuscarCliente = new JTextFieldAlfanumerico();
		textFieldBuscarCliente.setToolTipText("Escriba el Nombre del Cliente o su DNI");
		textFieldBuscarCliente.setBounds(27, 21, 521, 20);
		jPanelPanelCliente.add(textFieldBuscarCliente);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(558, 20, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTablaCliente();
			}
		});
		jPanelPanelCliente.add(btnBuscar);
			
		JButton btnNuevoCliente = new JButton("Nuevo");
		btnNuevoCliente.setEnabled(false);
		btnNuevoCliente.setBounds(657, 20, 89, 23);
		jPanelPanelCliente.add(btnNuevoCliente);
		
		JSeparator separatorAreaClientes = new JSeparator();
		separatorAreaClientes.setBounds(10, 60, 740, 2);
		jPanelPanelCliente.add(separatorAreaClientes);
				
		tableClientes = new JTableBuscarCliente();
		tableClientes.setSize(720, 110);
		tableClientes.setLocation(25, 75);
		tableClientes.setVisible(true);
        
		JScrollPane scrollPaneTablaClientes = new JScrollPane();
		scrollPaneTablaClientes.setViewportView(tableClientes);
		scrollPaneTablaClientes.setSize(720, 110);
		scrollPaneTablaClientes.setLocation(25, 75);
		scrollPaneTablaClientes.setVisible(true);
		
		jPanelPanelCliente.add(scrollPaneTablaClientes);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBorarContenidoDeTabla();
			}
		});
		
		btnBorrar.setBounds(661, 197, 89, 23);
		jPanelPanelCliente.add(btnBorrar);
		
		// Panel Inmueble
		JPanel jPanelPanelInmueble = new JPanelAreas("Inmueble");
		jPanelPanelInmueble.setBounds(20, 309, 760, 220);
		JPanelPanelPrincipal.add(jPanelPanelInmueble);
		jPanelPanelInmueble.setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(IdFontVentana.FONT_TEXTO);
		lblProvincia.setBounds(220, 26, 63, 14);
		jPanelPanelInmueble.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(IdFontVentana.FONT_TEXTO);
		lblLocalidad.setBounds(220, 57, 63, 14);
		jPanelPanelInmueble.add(lblLocalidad);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(IdFontVentana.FONT_TEXTO);
		lblEstado.setBounds(220, 88, 63, 14);
		jPanelPanelInmueble.add(lblEstado);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(IdFontVentana.FONT_TEXTO);
		lblTipo.setBounds(220, 119, 63, 14);
		jPanelPanelInmueble.add(lblTipo);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(IdFontVentana.FONT_TEXTO);
		lblDireccion.setBounds(462, 26, 63, 14);
		jPanelPanelInmueble.add(lblDireccion);
		
		jtextLocalidad = new JTextField();
		jtextLocalidad.setBounds(304, 54, 123, 20);
		jtextLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		jtextLocalidad.setColumns(10);
		jPanelPanelInmueble.add(jtextLocalidad);
		
		jtextProvincia = new JTextField();
		jtextProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		jtextProvincia.setColumns(10);
		jtextProvincia.setBounds(304, 23, 123, 20);
		jPanelPanelInmueble.add(jtextProvincia);
		
		JButton btnCambiarInmueble = new JButton("Cambiar Inmueble");
		btnCambiarInmueble.setBounds(596, 186, 143, 23);
		btnCambiarInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedCambiarInmueble();
			}
		});
		jPanelPanelInmueble.add(btnCambiarInmueble);
		
		// -> FOTO
		if(dtoVenta.getInmueble().getId()==0){
			pFoto = new JPanel();	
		}
		else{
			pFoto = new JPanelFoto(dtoVenta.getInmueble());		
			
		}
		
		pFoto.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		pFoto.setBounds(31, 29, 159, 141);
		jPanelPanelInmueble.add(pFoto);
		
		
		jtextEstado = new JTextField();
		jtextEstado.setHorizontalAlignment(SwingConstants.CENTER);
		jtextEstado.setColumns(10);
		jtextEstado.setBounds(304, 85, 123, 20);
		jPanelPanelInmueble.add(jtextEstado);
		
		jtextTipo = new JTextField();
		jtextTipo.setHorizontalAlignment(SwingConstants.CENTER);
		jtextTipo.setColumns(10);
		jtextTipo.setBounds(304, 116, 123, 20);
		jPanelPanelInmueble.add(jtextTipo);
		
		// -> Panel Importe
		JPanel panelImporte = new JPanel();
		panelImporte.setLayout(null);
		panelImporte.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panelImporte.setBounds(210, 147, 242, 62);
		jPanelPanelInmueble.add(panelImporte);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 7, 53, 20);
		lblValor.setFont(IdFontVentana.FONT_TEXTO);
		panelImporte.add(lblValor);
		
		JLabel lblImporteVenta = new JLabel("Importe Venta");
		lblImporteVenta.setBounds(10, 36, 96, 20);
		lblImporteVenta.setFont(IdFontVentana.FONT_TEXTO);
		panelImporte.add(lblImporteVenta);
		
		jtextValor = new JTextField();
		jtextValor.setBounds(116, 7, 116, 20);
		jtextValor.setHorizontalAlignment(SwingConstants.CENTER);
		jtextValor.setColumns(10);
		panelImporte.add(jtextValor);
		
		textFieldImporteVenta = new JTextFieldNumeroReales();
		textFieldImporteVenta.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldImporteVenta.setColumns(10);
		textFieldImporteVenta.setBounds(116, 36, 116, 20);
		panelImporte.add(textFieldImporteVenta);
		
		// Panel interno Direccion
		JPanel panelDireccion = new JPanel();
		panelDireccion.setLayout(null);
		panelDireccion.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panelDireccion.setBounds(462, 41, 277, 109);
		jPanelPanelInmueble.add(panelDireccion);
		
		JLabel labelcalle = new JLabel("Calle/Numero");
		labelcalle.setBounds(10, 14, 78, 14);
		panelDireccion.add(labelcalle);
		
		jtextCalle = new JTextField();
		jtextCalle.setColumns(10);
		jtextCalle.setBounds(95, 11, 109, 20);
		panelDireccion.add(jtextCalle);
		
		jtextNumero = new JTextField();
		jtextNumero.setColumns(10);
		jtextNumero.setBounds(214, 11, 46, 20);
		panelDireccion.add(jtextNumero);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPiso.setBounds(39, 39, 46, 14);
		panelDireccion.add(lblPiso);
		
		jtextPiso = new JTextField();
		jtextPiso.setColumns(10);
		jtextPiso.setBounds(95, 36, 46, 20);
		panelDireccion.add(jtextPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepto.setBounds(151, 39, 46, 14);
		panelDireccion.add(lblDepto);
		
		jtextDepto = new JTextField();
		jtextDepto.setColumns(10);
		jtextDepto.setBounds(214, 36, 46, 20);
		panelDireccion.add(jtextDepto);
		
		JLabel jlabelBarrio = new JLabel("Barrio");
		jlabelBarrio.setHorizontalAlignment(SwingConstants.TRAILING);
		jlabelBarrio.setBounds(39, 64, 46, 14);
		panelDireccion.add(jlabelBarrio);
		
		jtextBarrio = new JTextField();
		jtextBarrio.setColumns(10);
		jtextBarrio.setBounds(95, 61, 166, 20);
		panelDireccion.add(jtextBarrio);
		
		JLabel lblVerMasDetalles = new JLabel("Ver mas detalles del Inmueble");
		lblVerMasDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerMasDetalles.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new MensajeAlerta(null,"Observación","Funcion no disponible");
			}
		});
		lblVerMasDetalles.setBounds(462, 158, 277, 14);
		jPanelPanelInmueble.add(lblVerMasDetalles);
		
		//-> Cargar Inmueble
		
		if(dtoVenta.getInmueble().getId()!=0){
			cargarInmueble();	
		}
				
		// Panel Controles
		JPanel jPanelPanelInferior = new JPanelControl();
		JPanelPanelPrincipal.add(jPanelPanelInferior);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedSalir();
			}
		});
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedImprimirDocumento();
			}
		});
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedConfirmarDocumento();
			}
		});
		
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_jPanelPanelInferior = new GroupLayout(jPanelPanelInferior);
		gl_jPanelPanelInferior.setHorizontalGroup(
			gl_jPanelPanelInferior.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanelPanelInferior.createSequentialGroup()
					.addContainerGap(483, Short.MAX_VALUE)
					.addComponent(btnConfirmar)
					.addGap(18)
					.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSalir)
					.addContainerGap())
		);
		gl_jPanelPanelInferior.setVerticalGroup(
			gl_jPanelPanelInferior.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanelPanelInferior.createSequentialGroup()
					.addGroup(gl_jPanelPanelInferior.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnImprimir)
						.addComponent(btnSalir))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		jPanelPanelInferior.setLayout(gl_jPanelPanelInferior);
		
		
				
		this.inhabilitarTextInmueble();
		this.setResizable(false);

		/**************************************************************/
		
	}
	
	/**
     * Action Performed: Borra los datos de la tabla
     */
	private void actionPerformedBorarContenidoDeTabla() {
		tableClientes.borrarTabla();
	}
	
	 /**
     * Action Performed: Confirmar el Documento
     */
	private void actionPerformedConfirmarDocumento() {
		
		try{
			ClienteDTO cliente = this.tableClientes.filaSeleccionada();
			this.dtoVenta.setCliente(cliente);
			if(this.dtoVenta.getInmueble().getId()==0){
				new MensajeAlerta(this, "Atencion", "Debe ingresar un inmueble");
				throw new VentaInvalidaException("No ingresa inmueble");
			}
			this.dtoVenta.setImporteVenta(Double.valueOf(this.textFieldImporteVenta.getText()));
			this.dtoVenta.setFechaventa(new Date());
			VentaService.confirmarVenta(this.dtoVenta);
		}
		catch(NumberFormatException e){
			new MensajeAlerta(this, "Atencion", "Debe ingresar un importe");
			e.printStackTrace();
		}
		catch (VentaInvalidaException e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * Action Performed: Imprimir el Documento
     */
	private void actionPerformedImprimirDocumento() {
		// TODO IMPRIMIR SI ESTA CONFIRMADA
		// TRAER VENTA BASE DE DATOS
		
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setJobName("Venta-"+dtoVenta.getIDVenta());
		
		//Objeter Formato Pagina
		format = printerJob.pageDialog(printerJob.defaultPage()); 
		
        printerJob.setPrintable(new Printable() {
 			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) 
					throws PrinterException {
 	       	   
 				System.out.println("Numero de Pagina = " + pageIndex);
 				
 				if(pageIndex > 0){
 					return NO_SUCH_PAGE;
 				}
 				
 				// El objeto gráfico lo convertimos en un objeto gráfico de dos dimensiones 
				 Graphics2D g2 = (Graphics2D) graphics; 
				 
 				// Pedimos al componente que se dibuje él mismo en al impresora 
		    	parent.getContentPane().print(g2); 
		    	
 				// Establecer Formato de Pagina
 				//pageFormat.setOrientation(PageFormat.LANDSCAPE);
		    	
		    	if (format == null){
		    		Paper papel = new Paper();
		    		// Setea Margenes VER
	 				papel.setImageableArea(0,0,0,0);
	 				papel.setSize(842,1191);
	 				pageFormat.setPaper(papel);
			
		    	}
		    	else{
		    		pageFormat = format;
		    	}
 				

        	    // Establecemos los márgenes (superior e izdo) de impresión que se 
		    	// especifican en el objeto PageFormat 
 				g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY()); 
 				
 			    // Muestra Dimensiones
 			    System.out.println("PageFormat_W:"+pageFormat.getWidth());
 				System.out.println("PageFormat_H:"+pageFormat.getHeight());
 				System.out.println("PageFormat_IX:"+pageFormat.getImageableX());
 				System.out.println("PageFormat_IY:"+pageFormat.getImageableY());
 				System.out.println("PageFormat_PIW:"+pageFormat.getPaper().getImageableWidth());
 				System.out.println("PageFormat_PIH:"+pageFormat.getPaper().getImageableHeight());
 				System.out.println("PageFormat_PIX:"+pageFormat.getPaper().getImageableX());
 				System.out.println("PageFormat_PIY:"+pageFormat.getPaper().getImageableY());
 				System.out.println("PageFormat_PW:"+pageFormat.getPaper().getWidth());
 				System.out.println("PageFormat_PH:"+pageFormat.getPaper().getHeight());
		    	
		    	
		    	// Rectangulo de Impresion (Margenes)
		    	double w = pageFormat.getImageableWidth();
 			    double h = pageFormat.getImageableHeight();

 			    int xo = (int) pageFormat.getImageableX();
 			    int yo = (int) pageFormat.getImageableY();

 			    g2.setColor(Color.red);
 			    g2.draw(new Rectangle2D.Double(xo, yo, w, h));
		    	
		    	// Imprime "Titulo de Impresion" en la primera pagina, en la posicion 10,10
		    	g2.drawString("Venta Generada por ...", 100,100);
		    	  
		    	// Imprime "Pie de Impresion" en la primera pagina, en la posicion 10,10
		    	g2.drawString("Gracias", 100,650);
		    	
		    	Line2D.Double line = new Line2D.Double();
		    	
		    	 //--- Print the vertical lines
		        for (int i = 0; i < pageFormat.getWidth(); i += 72 / 2) {
		          line.setLine(i, 0, i, pageFormat.getHeight());
		          g2.draw(line);
		        }

		        //--- Print the horizontal lines
		        for (int i = 0; i < pageFormat.getHeight(); i += 72 / 2) {
		          line.setLine(0, i, pageFormat.getWidth(), i);
		          g2.draw(line);
		        }
		    	
		    	// Imprime Linea para FIRMA: 
		    	//g2.drawLine();
		    	 
		    	//Con esta constante le decimos al PrinterJob que hemos impreso la página 
		    	return Printable.PAGE_EXISTS;        	   
        	         
			}
        	});
        //muestra ventana de dialogo para imprimir
        try {
            printerJob.print();
        } catch (PrinterException ex) {
            System.out.println("Error:" + ex);
        }
        
		//this.getContentPane().printAll(getGraphics());
		
		//new MensajeAlerta(null,"Observación","Funcion IMPRIMIR no disponible");
	}
	
	 /**
     * Action Performed: Salir
     */
	private void actionPerformedSalir() {
		this.dispose();		
	}
	
	 /**
     * Action Performed: CambiarInmueble
     */
	private void actionPerformedCambiarInmueble() {
		new VentanaSeleccionarInmuebleVenta(this.parent);
	}
	
	

	
	/**
	 * Carga la Tabla con un cliente dependiendo del DNI o Apellido
	 */
	private void cargarTablaCliente(){
		actionPerformedBorarContenidoDeTabla();
		
		String textBuscarCliente = this.textFieldBuscarCliente.getText();
		
		int i;
		List<Cliente> clientes;
		Cliente cliente = null;
		
		for(i=0; i<textBuscarCliente.length();i++){
			if(Character.isDigit(textBuscarCliente.charAt(i)))
				break;
		}
		
		try{
			if(i==textBuscarCliente.length()){
				clientes = ClienteDAO.getClienteByApellido(textBuscarCliente);
			}
			
			else{
				clientes = ClienteDAO.getClienteByDNI(textBuscarCliente);
			}
			
			if (!clientes.isEmpty()) {
				cliente = clientes.get(0);
			}
			
			ClienteDTO dtocliente = new ClienteDTO(cliente);
			this.tableClientes.agregarFilaTabla(dtocliente);
			
			
		}catch (NullPointerException e) {
			new MensajeAlerta(this, "Atención" , "Cliente no encontrado");
		}
	}
	
	/**
	 * Carga datos del Inmueble en base a un DTO Inmueble
	 */
	
	public void cargarInmueble(){
		InmuebleDTO dtoinmueble = dtoVenta.getInmueble();
		if(dtoinmueble==null){
			return;
		}
		try{
			DireccionDTO direccion = dtoinmueble.getDireccion();

			Localidad localidad = MiscelaneoDAO.getLocalidadById(direccion.getIdLocalidad());
			Provincia provincia = localidad.getProvincia();
			
			this.jtextProvincia.setText(provincia.getNombre());
			this.jtextLocalidad.setText(localidad.getNombre());
			this.jtextBarrio.setText(direccion.getCalleAlternativa());
			
			switch(dtoinmueble.getIdTipo()){
				case (int) IdTipoDeInmueble.CASA:		
					this.jtextTipo.setText("Casa");
					break;
				case (int) IdTipoDeInmueble.DEPARTAMENTO:		
					this.jtextTipo.setText("Departamento");
					break;
				case (int) IdTipoDeInmueble.GALPON:		
					this.jtextTipo.setText("Galpon");
					break;
				case (int) IdTipoDeInmueble.LOCAL_OFICINA:		
					this.jtextTipo.setText("Local Oficina");
					break;
				case (int) IdTipoDeInmueble.QUINTA:		
					this.jtextTipo.setText("Quinta");
					break;
				case (int) IdTipoDeInmueble.TERRENO:		
					this.jtextTipo.setText("Terreno");
					break;
				}
					
			this.jtextPiso.setText(direccion.getPiso());
			this.jtextCalle.setText(direccion.getCalleAlternativa());
			this.jtextDepto.setText(direccion.getDepartamento());
			this.jtextNumero.setText(direccion.getNumero());
			this.jtextValor.setText(String.valueOf(dtoinmueble.getPrecioDeVenta()));
			
			switch(dtoinmueble.getIdEstado()){
				case IdEstado.ALTA:		
					this.jtextEstado.setText("Alta");
					break;
				case IdEstado.RESERVADO:		
					this.jtextEstado.setText("Reservado");
					break;
				case IdEstado.VENDIDO:		
					this.jtextEstado.setText("Vendido");
					break;
			}
			//pFoto.recargar();
			
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Limpiar un inmueble
	 */
	public void limpiarInmueble(){

		this.jtextProvincia.setText("");
		this.jtextLocalidad.setText("");
		this.jtextBarrio.setText("");
		this.jtextTipo.setText("");
		this.jtextPiso.setText("");
		this.jtextCalle.setText("");
		this.jtextDepto.setText("");
		this.jtextNumero.setText("");
		this.jtextEstado.setText("");
		this.jtextValor.setText("");
		this.textFieldImporteVenta.setText("");
		this.pFoto.setOpaque(true);
	}
	
	/**
	 * Inhabilitar JTEXT de inmueble
	 */
    private void inhabilitarTextInmueble() {
    	this.jtextProvincia.setEditable(false);
		this.jtextLocalidad.setEditable(false);
		this.jtextBarrio.setEditable(false);
		this.jtextTipo.setEditable(false);
		this.jtextPiso.setEditable(false);
		this.jtextCalle.setEditable(false);
		this.jtextDepto.setEditable(false);
		this.jtextNumero.setEditable(false);
		this.jtextEstado.setEditable(false);
		this.jtextValor.setEditable(false);
	}
}
