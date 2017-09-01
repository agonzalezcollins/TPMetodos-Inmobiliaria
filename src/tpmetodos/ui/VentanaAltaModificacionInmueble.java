package tpmetodos.ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.datos.entidades.Localidad;
import tpmetodos.datos.entidades.Orientacion;
import tpmetodos.datos.entidades.Provincia;
import tpmetodos.datos.entidades.TipoDeInmueble;
import tpmetodos.dtos.DireccionDTO;
import tpmetodos.dtos.FotoDeInmuebleDTO;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.servicio.InmuebleService;
import tpmetodos.servicio.excepciones.InmuebleInvalidoException;
import tpmetodos.ui.panels.JPanelFondo;
import tpmetodos.ui.panels.JPanelFoto;

/**
 * 
 * @author Armando
 *
 */
@SuppressWarnings("all")
public class VentanaAltaModificacionInmueble extends javax.swing.JInternalFrame {
	/**
	 * 
	 */
	private InmuebleDTO dto;
	private static final long serialVersionUID = 1456546L;
	private JTextField tCalle;
	private JTextField tNumero;
	private JTextField tPiso;
	private JTextField tDepto;
	private JTextField tBarrio;
	private JTextField tFrente;
	private JTextField tFondo;
	private JTextField tSuperficie;
	private JTextField tAntiguedad;
	private JTextField tDormitorios;
	private JButton bCancelar;
	private JButton bAceptar;
	private JTextArea tObservaciones;
	private JButton bFoto;
	private JPanelFoto pFoto;
	private JTextField tBanos;
	private JTextField tPrecio;
	private JComboBox cPH;
	private JComboBox cPavimento;
	private JComboBox cLavadero;
	private JComboBox cTelefono;
	private JComboBox cGas;
	private JComboBox cCloacas;
	private JComboBox cAgua;
	private JComboBox cPiscina;
	private JComboBox cPatio;
	private JComboBox cGarage;
	private JComboBox cOrientacion;
	private JComboBox cTipo;
	private JComboBox cLocalidad;
	private JComboBox cProvincia;
	private JLabel lblTitulo;
	
	
	public VentanaAltaModificacionInmueble(JFrame parent,InmuebleDTO dto){
		parent.getContentPane().add(this);
		this.dto = dto;
		setTitle("Alta de inmueble");
		this.setBounds(100,100,700,694);
		this.setContentPane(new JPanelFondo());
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Alta de Inmueble");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(141, 11, 400, 28);
		getContentPane().add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel.setBounds(366, 57, 277, 96);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCallenumero = new JLabel("Calle/Numero");
		lblCallenumero.setBounds(10, 14, 78, 14);
		panel.add(lblCallenumero);
		
		tCalle = new JTextField();
		tCalle.setBounds(95, 11, 109, 20);
		panel.add(tCalle);
		tCalle.setColumns(10);
		
		tNumero = new JTextField();
		tNumero.setBounds(214, 11, 46, 20);
		panel.add(tNumero);
		tNumero.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(39, 39, 46, 14);
		panel.add(lblPiso);
		lblPiso.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tPiso = new JTextField();
		tPiso.setBounds(95, 36, 46, 20);
		panel.add(tPiso);
		tPiso.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(151, 39, 46, 14);
		panel.add(lblDepto);
		lblDepto.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tDepto = new JTextField();
		tDepto.setBounds(214, 36, 46, 20);
		panel.add(tDepto);
		tDepto.setColumns(10);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setBounds(39, 64, 46, 14);
		panel.add(lblBarrio);
		lblBarrio.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tBarrio = new JTextField();
		tBarrio.setBounds(95, 61, 166, 20);
		panel.add(tBarrio);
		tBarrio.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel_1.setBounds(42, 57, 277, 96);
		getContentPane().add(panel_1);
		
		cProvincia = new JComboBox();
		cProvincia.setBounds(112, 23, 126, 20);
		panel_1.add(cProvincia);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(29, 23, 73, 14);
		panel_1.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(29, 54, 73, 14);
		panel_1.add(lblLocalidad);
		
		cLocalidad = new JComboBox();
		cLocalidad.setBounds(112, 54, 126, 20);
		panel_1.add(cLocalidad);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipo.setBounds(61, 202, 46, 14);
		getContentPane().add(lblTipo);
		
		cTipo = new JComboBox();
		cTipo.setBounds(125, 199, 126, 20);
		getContentPane().add(cTipo);
		
		cOrientacion = new JComboBox();
		cOrientacion.setBounds(125, 224, 126, 20);
		getContentPane().add(cOrientacion);
		
		JLabel lblOrientacion = new JLabel("Orientacion");
		lblOrientacion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOrientacion.setBounds(32, 227, 75, 14);
		getContentPane().add(lblOrientacion);
		
		JLabel lblGarage = new JLabel("Garage");
		lblGarage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGarage.setBounds(32, 270, 65, 14);
		getContentPane().add(lblGarage);
		
		cGarage = new JComboBox();
		cGarage.setBounds(107, 267, 46, 20);
		getContentPane().add(cGarage);
		
		JLabel lblPatio = new JLabel("Patio");
		lblPatio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPatio.setBounds(162, 269, 65, 14);
		getContentPane().add(lblPatio);
		
		cPatio = new JComboBox();
		cPatio.setBounds(237, 266, 46, 20);
		getContentPane().add(cPatio);
		
		JLabel lblPiscina = new JLabel("Piscina");
		lblPiscina.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPiscina.setBounds(32, 299, 65, 14);
		getContentPane().add(lblPiscina);
		
		cPiscina = new JComboBox();
		cPiscina.setBounds(107, 296, 46, 20);
		getContentPane().add(cPiscina);
		
		JLabel lblAgua_1 = new JLabel("Agua");
		lblAgua_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAgua_1.setBounds(162, 298, 65, 14);
		getContentPane().add(lblAgua_1);
		
		cAgua = new JComboBox();
		cAgua.setBounds(237, 295, 46, 20);
		getContentPane().add(cAgua);
		
		JLabel lblCloacas = new JLabel("Cloacas");
		lblCloacas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCloacas.setBounds(32, 328, 65, 14);
		getContentPane().add(lblCloacas);
		
		cCloacas = new JComboBox();
		cCloacas.setBounds(107, 325, 46, 20);
		getContentPane().add(cCloacas);
		
		JLabel lblAgua = new JLabel("Gas");
		lblAgua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAgua.setBounds(162, 327, 65, 14);
		getContentPane().add(lblAgua);
		
		cGas = new JComboBox();
		cGas.setBounds(237, 324, 46, 20);
		getContentPane().add(cGas);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefono.setBounds(32, 357, 65, 14);
		getContentPane().add(lblTelefono);
		
		cTelefono = new JComboBox();
		cTelefono.setBounds(107, 354, 46, 20);
		getContentPane().add(cTelefono);
		
		JLabel lblLavadero = new JLabel("Lavadero");
		lblLavadero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLavadero.setBounds(162, 356, 65, 14);
		getContentPane().add(lblLavadero);
		
		cLavadero = new JComboBox();
		cLavadero.setBounds(237, 353, 46, 20);
		getContentPane().add(cLavadero);
		
		JLabel lblPavimento = new JLabel("Pavimento");
		lblPavimento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPavimento.setBounds(32, 386, 65, 14);
		getContentPane().add(lblPavimento);
		
		cPavimento = new JComboBox();
		cPavimento.setBounds(107, 383, 46, 20);
		getContentPane().add(cPavimento);
		
		JLabel lblPHorizontal = new JLabel("P. horizontal");
		lblPHorizontal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPHorizontal.setBounds(136, 385, 91, 14);
		getContentPane().add(lblPHorizontal);
		
		cPH = new JComboBox();
		cPH.setBounds(237, 382, 46, 20);
		getContentPane().add(cPH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel_2.setBounds(32, 178, 287, 244);
		getContentPane().add(panel_2);
		
		JLabel lblFrente = new JLabel("Frente");
		lblFrente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFrente.setBounds(400, 188, 46, 14);
		getContentPane().add(lblFrente);
		
		tFrente = new JTextField();
		tFrente.setBounds(455, 185, 86, 20);
		getContentPane().add(tFrente);
		tFrente.setColumns(10);
		
		JLabel lblMetros = new JLabel("metros");
		lblMetros.setBounds(551, 188, 46, 14);
		getContentPane().add(lblMetros);
		
		JLabel label = new JLabel("metros");
		label.setBounds(551, 213, 46, 14);
		getContentPane().add(label);
		
		tFondo = new JTextField();
		tFondo.setColumns(10);
		tFondo.setBounds(455, 210, 86, 20);
		getContentPane().add(tFondo);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFondo.setBounds(400, 213, 46, 14);
		getContentPane().add(lblFondo);
		
		JLabel lblMCuadrados = new JLabel("m. cuadrados");
		lblMCuadrados.setBounds(551, 241, 78, 14);
		getContentPane().add(lblMCuadrados);
		
		tSuperficie = new JTextField();
		tSuperficie.setColumns(10);
		tSuperficie.setBounds(455, 238, 86, 20);
		getContentPane().add(tSuperficie);
		
		JLabel lblSuperficie = new JLabel("Superficie");
		lblSuperficie.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSuperficie.setBounds(381, 241, 65, 14);
		getContentPane().add(lblSuperficie);
		
		JLabel lblAos = new JLabel("a\u00F1os");
		lblAos.setBounds(551, 270, 46, 14);
		getContentPane().add(lblAos);
		
		tAntiguedad = new JTextField();
		tAntiguedad.setColumns(10);
		tAntiguedad.setBounds(455, 267, 86, 20);
		getContentPane().add(tAntiguedad);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad");
		lblAntiguedad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAntiguedad.setBounds(381, 270, 65, 14);
		getContentPane().add(lblAntiguedad);
		
		tDormitorios = new JTextField();
		tDormitorios.setColumns(10);
		tDormitorios.setBounds(455, 296, 86, 20);
		getContentPane().add(tDormitorios);
		
		JLabel lblDormitorios = new JLabel("Dormitorios");
		lblDormitorios.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDormitorios.setBounds(371, 299, 75, 14);
		getContentPane().add(lblDormitorios);
		
		tBanos = new JTextField();
		tBanos.setColumns(10);
		tBanos.setBounds(455, 325, 86, 20);
		getContentPane().add(tBanos);
		
		JLabel lblBao = new JLabel("Ba\u00F1os");
		lblBao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBao.setBounds(381, 328, 65, 14);
		getContentPane().add(lblBao);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrecio.setBounds(381, 382, 65, 14);
		getContentPane().add(lblPrecio);
		
		tPrecio = new JTextField();
		tPrecio.setColumns(10);
		tPrecio.setBounds(455, 380, 86, 20);
		getContentPane().add(tPrecio);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(551, 382, 46, 14);
		getContentPane().add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel_3.setBounds(366, 178, 287, 244);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel_4.setBounds(32, 433, 287, 206);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		pFoto = new JPanelFoto(this.dto);
		pFoto.setBounds(12, 12, 263, 160);
		panel_4.add(pFoto);
		
		bFoto = new JButton("Cargar foto");
		bFoto.setBounds(93, 176, 98, 26);
		panel_4.add(bFoto);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 1, true));
		panel_5.setBounds(366, 433, 287, 206);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Observaciones");
		lblNewLabel.setBounds(101, 12, 86, 16);
		panel_5.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 263, 108);
		panel_5.add(scrollPane);
		
		tObservaciones = new JTextArea();
		scrollPane.setViewportView(tObservaciones);
		
		bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(46, 162, 98, 26);
		panel_5.add(bAceptar);
		
		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(154, 162, 98, 26);
		panel_5.add(bCancelar);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTitulo, panel, lblCallenumero, tCalle, tNumero, lblPiso, tPiso, lblDepto, tDepto, lblBarrio, tBarrio, panel_1, lblProvincia, lblLocalidad, cLocalidad, cProvincia}));
		
		if(dto.getId()== 0){
			lblTitulo.setText("Alta de inmueble");
		}
		else{
			lblTitulo.setText("Modificacion de inmueble " +dto.getId());
		}
		
		setListeners();
		llenarCombos();
		llenarDatosExistentes();
		this.setVisible(true);
		this.setClosable(true);
	}
	
	/**
	 * Llena los combo box
	 */
	private void llenarCombos(){
		List<Provincia> provincias = MiscelaneoDAO.getProvincias();
		List<Orientacion> orientaciones = InmuebleDAO.getOrientaciones();
		List<TipoDeInmueble> tipos = InmuebleDAO.getTiposDeInmueble();
		
		for(Provincia p : provincias){
			cProvincia.addItem(p);
		}
		for(Orientacion o : orientaciones){
			cOrientacion.addItem(o);
		}
		for(TipoDeInmueble t : tipos){
			cTipo.addItem(t);
		}
		
		cAgua.addItem("Si");
		cAgua.addItem("No");
		cCloacas.addItem("Si");
		cCloacas.addItem("No");
		cGarage.addItem("Si");
		cGarage.addItem("No");
		cGas.addItem("Si");
		cGas.addItem("No");
		cLavadero.addItem("Si");
		cLavadero.addItem("No");
		cPatio.addItem("Si");
		cPatio.addItem("No");
		cPavimento.addItem("Si");
		cPavimento.addItem("No");
		cPH.addItem("Si");
		cPH.addItem("No");
		cPiscina.addItem("Si");
		cPiscina.addItem("No");
		cTelefono.addItem("Si");
		cTelefono.addItem("No");
		
		
	}
	
	private void setListeners(){
		cProvincia.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				cambioSeleccionProvincia();
			}
			
		});
		bFoto.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickCargarFoto();
			}
			
		});
		bAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickAceptar();
				
			}
			
		});
		bCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickCancelar();
				
			}
			
		});
	}
	
	/**
	 * carga los datos del inmueble pasado como parametro en los campos de la interfaz
	 */
	private void llenarDatosExistentes(){
		Localidad loc= MiscelaneoDAO.getLocalidadById(dto.getDireccion().getIdLocalidad());
		Provincia prov = loc.getProvincia();
		Orientacion or = InmuebleDAO.getOrientacionById(dto.getIdOrientacion());
		TipoDeInmueble tipo = InmuebleDAO.getTipoById(dto.getIdTipo());
		
		cProvincia.setSelectedItem(prov); //seleccionar la provincia
		this.cambioSeleccionProvincia(); //actualizar la lista de localidades
		cLocalidad.setSelectedItem(loc); //seleccionar la localidad
		
		//variables booleanas
		cAgua.setSelectedIndex(dto.tieneAguaCorriente()?0:1);
		cCloacas.setSelectedIndex(dto.tieneCloaca()?0:1);
		cGarage.setSelectedIndex(dto.tieneGarage()?0:1);
		cGas.setSelectedIndex(dto.tieneGasNatural()?0:1);
		cLavadero.setSelectedIndex(dto.tieneLavadero()?0:1);
		cPatio.setSelectedIndex(dto.tienePatio()?0:1);
		cPavimento.setSelectedIndex(dto.tienePavimento()?0:1);
		cPH.setSelectedIndex(dto.esPropiedadHorizontal()?0:1);
		cPiscina.setSelectedIndex(dto.tienePiscina()?0:1);
		cTelefono.setSelectedIndex(dto.tieneTelefono()?0:1);
		
		//orientacion y tipo
		cOrientacion.setSelectedItem(or);
		cTipo.setSelectedItem(tipo);
		
		//text fields
		tAntiguedad.setText(""+dto.getAntiguedad());
		tBanos.setText(""+dto.getCantidadDeBanos());
		tBarrio.setText(dto.getDireccion().getBarrio());
		tCalle.setText(dto.getDireccion().getCalleAlternativa());
		tDepto.setText(dto.getDireccion().getDepartamento());
		tDormitorios.setText(""+dto.getCantidadDeDormitorios());
		tFondo.setText(""+dto.getLongitudDeFondo());
		tFrente.setText(""+dto.getLongitudDeFrente());
		tNumero.setText(dto.getDireccion().getNumero());
		tObservaciones.setText(dto.getObservaciones());
		tPiso.setText(dto.getDireccion().getPiso());
		tPrecio.setText(""+dto.getPrecioDeVenta());
		tSuperficie.setText(""+dto.getSuperficie());
		
		
	}
	
	private void cambioSeleccionProvincia(){
		Provincia prov = (Provincia) cProvincia.getSelectedItem();
		List<Localidad> locs = MiscelaneoDAO.getLocalidadesPorProvincia(prov);
		cLocalidad.removeAllItems();
		for(Localidad loc : locs){
			cLocalidad.addItem(loc);
		}
		
	}
	
	private void clickAceptar(){
		try {
			if (cLocalidad.getItemCount() <= 0){
				JOptionPane.showMessageDialog(this, "La provincia no tiene localidades");
				return;
			}
			Localidad loc = (Localidad) cLocalidad.getSelectedItem();
			Orientacion or = (Orientacion) cOrientacion.getSelectedItem();
			TipoDeInmueble tipo = (TipoDeInmueble)cTipo.getSelectedItem();
			
			DireccionDTO dir = dto.getDireccion();
			/*if(esAlta()){
				dir = new DireccionDTO();
			}
			else if (esModificacion()){
				dir = dto.getDireccion();
			}*/
			dir.setBarrio(tBarrio.getText());
			dir.setCalleAlternativa(tCalle.getText());
			dir.setNumero(tNumero.getText());
			dir.setDepartamento(tDepto.getText());
			dir.setIdLocalidad(loc.getId());
			dir.setPiso(tPiso.getText());
			
			dto.setAguaCorriente(cAgua.getSelectedIndex()==0);
			dto.setGasNatural(cGas.getSelectedIndex()==0);
			dto.setPatio(cPatio.getSelectedIndex()==0);
			dto.setGarage(cGarage.getSelectedIndex()==0);
			dto.setPavimento(cPavimento.getSelectedIndex()==0);
			dto.setTelefono(cTelefono.getSelectedIndex()==0);
			dto.setPiscina(cPiscina.getSelectedIndex()==0);
			dto.setPropiedadHorizontal(cPH.getSelectedIndex()==0);
			dto.setLavadero(cLavadero.getSelectedIndex()==0);
			dto.setCloaca(cCloacas.getSelectedIndex()==0);
			
			dto.setAntiguedad(Integer.parseInt(tAntiguedad.getText()));
			dto.setCantidadDeBanos(Integer.parseInt(tBanos.getText()));
			dto.setCantidadDeDormitorios(Integer.parseInt(tDormitorios.getText()));
			dto.setDireccion(dir);
			//la foto ya se cargo cuando se la selecciono con el dialogo
			dto.setIdOrientacion(or.getId());
			dto.setIdTipo(tipo.getId());
			dto.setLongitudDeFondo(Float.parseFloat(tFondo.getText()));
			dto.setLongitudDeFrente(Float.parseFloat(tFrente.getText()));
			dto.setObservaciones(tObservaciones.getText());
			dto.setPrecioDeVenta(Float.parseFloat(tPrecio.getText()));
			dto.setSuperficie(Float.parseFloat(tSuperficie.getText()));
			
			
			if(dto.getId() == 0){ //si no tiene ID es porque esta dandose de alta
				InmuebleService.altaInmueble(dto);
				JOptionPane.showMessageDialog(this, "Alta exitosa");
				this.dispose();
			}
			else{//si ya tenia id se llamó la ventana con un inmueble existente como parametro (modificacion)
				InmuebleService.modificarInmueble(dto);
				JOptionPane.showMessageDialog(this, "Modificacion exitosa");
			}
			
		} catch (InmuebleInvalidoException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error en datos introducidos. Info: "+e.getMessage());
		}
		
	}
	
	private void clickCancelar(){
		this.dispose();
	}
	
	private void clickCargarFoto(){
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("images"));
		int ret = fc.showOpenDialog(this);
		if(ret == JFileChooser.APPROVE_OPTION){
			File file = fc.getSelectedFile();
			String path = "images/"+file.getName(); // solo cargara imagenes de la carpeta images
			dto.getFotos().clear();
			FotoDeInmuebleDTO fdto = new FotoDeInmuebleDTO();
			fdto.setPath(path);
			dto.getFotos().add(fdto);
			pFoto.recargar();
		}
	}
	
	private boolean esAlta(){
		return dto.getId() == 0;
	}
	
	private boolean esModificacion(){
		return dto.getId() != 0;
	}
	
	
}

