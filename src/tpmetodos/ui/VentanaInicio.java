package tpmetodos.ui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.ui.panels.JPanelFondo;

/**
 * 
 * @author Ramiro
 */
public class VentanaInicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio windows = new VentanaInicio();
					windows.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema Inmobiliaria");
		frame.setBounds(100, 100, 900, 800);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new EscuchaVentana());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//FondoPanel fondo = new FondoPanel();
		//frame.setContentPane(fondo);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar Sesion");
		mntmIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarVentana();
				// codigo que se ejecuta al hacer click en "Iniciar Sesion":
				VentanaIniciarSesion i = new VentanaIniciarSesion();
				frame.getContentPane().add(i);
				i.setVisible(true);
				i.setClosable(true);
				
				
			}
		});
		mnArchivo.add(mntmIniciarSesion);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenu mnVendedores = new JMenu("Vendedores");
		mnUsuarios.add(mnVendedores);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarVentana();
				VentanaAltaVendedor a = new VentanaAltaVendedor();
				frame.getContentPane().add(a);
				a.setVisible(true);
				a.setClosable(true);
				
			}
		});
		mnVendedores.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				limpiarVentana();
				VentanaBajaVendedor a = new VentanaBajaVendedor();
				frame.getContentPane().add(a);
				a.setVisible(true);
				a.setClosable(true);
				
				
				
			}
		});
		mnVendedores.add(mntmBaja);
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiarVentana();
				VentanaModificarVendedor a = new VentanaModificarVendedor();
				frame.getContentPane().add(a);
				a.setVisible(true);
				a.setClosable(true);
				
				
			}
		});
		mnVendedores.add(mntmModificacion);
		
		JMenu mnInmuebles = new JMenu("Inmuebles");
		menuBar.add(mnInmuebles);
		
		JMenuItem miAlta = new JMenuItem("Alta");
		miAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarVentana();
				VentanaAltaModificacionInmueble v = new VentanaAltaModificacionInmueble(frame,new InmuebleDTO());
				
			}
		});
		mnInmuebles.add(miAlta);
		
		JMenuItem miModificacion = new JMenuItem("Modificacion");
		miModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarVentana();
				new VentanaSeleccionarInmueble(frame,false);
			}
		});
		mnInmuebles.add(miModificacion);
		
		JMenuItem miBaja = new JMenuItem("Baja");
		miBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarVentana();
				new VentanaSeleccionarInmueble(frame,true);
			}
		});
		mnInmuebles.add(miBaja);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarVentana();
				VentanaConsultaInmueble a = new VentanaConsultaInmueble();
				frame.getContentPane().add(a);
				a.setVisible(true);
				a.setClosable(true);
				
			}
		});
		mnInmuebles.add(mntmConsulta);
		
		JMenuItem mntmVenta = new JMenuItem("Venta");
		mntmVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarVentana();
				VentanaVenta a = new VentanaVenta(frame,null);
				frame.getContentPane().add(a);
				a.setVisible(true);
				a.setClosable(true);
			}
		});
		mnInmuebles.add(mntmVenta);
	}
	
	/**
	 * Clase interna que implementa Windows Lintener para escuchar movimientos de ventana. </br> 
	 * 
	 * @author Agu
	 *
	 */
	 class EscuchaVentana implements WindowListener {
        
		public void windowClosing(WindowEvent evento){
            salir();       
        }
        public void windowActivated(WindowEvent evento) {}
        public void windowClosed(WindowEvent evento) {}
        public void windowDeactivated(WindowEvent evento) {}
        public void windowIconified(WindowEvent evento) {}
        public void windowDeiconified(WindowEvent evento) {}
        public void windowOpened(WindowEvent evento) {} 
    }
	 
    /**
    * Metodo utilizado para informar si el usuario realmente desea salir de la aplicación.<br>
    * 
    * @param void
    * @return void
    */
    private void salir(){
        int opcion = JOptionPane.showConfirmDialog(this.frame,"¿Esta seguro que desea salir de la aplicación?","Salir",JOptionPane.YES_NO_OPTION);
        if (opcion==JOptionPane.YES_OPTION)
                System.exit(1);
    }
    
   /**
    * Vacia los componentes del frame agregados en el area "ContentPane" para limpiar pantalla. </b>
    * 
    * @param void
    * @return void
    */
   private void limpiarVentana(){
	     	   
	   frame.getContentPane().removeAll();
	   
   }
   
   private class FondoPanel extends JPanel{
	   String fondo = "images/sistema/fondo.jpg";
	   BufferedImage img = null;
	   @Override
	   public void paintComponent(Graphics g){
		   if(img == null){
			   try{
				   img = ImageIO.read(new File(fondo));
			   }
			   catch(Exception e){
				   System.out.println("No se cargo fondo");
			   }
		   }
		   if(img!=null){
			   g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
		   }
		   super.paintComponent(g);
	   }
   }

}
