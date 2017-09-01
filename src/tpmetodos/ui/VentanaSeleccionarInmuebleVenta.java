package tpmetodos.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.dtos.InmuebleDTO;

/**
 * Seleccionar inmueble para la venta
 * 
 * @author Agu
 *
 */

public class VentanaSeleccionarInmuebleVenta extends JDialog {

	private static final long serialVersionUID = 2843838845866728563L;
	private final JPanel contentPanel = new JPanel();
	private JButton bAceptar;
	private JButton bCancelar;
	private JList<Inmueble> lInmuebles;
	private JFrame parent;

	public VentanaSeleccionarInmuebleVenta(JFrame parent) {
		super(parent);
		this.parent = parent;
		setTitle("Seleccionar inmueble");
		int w = 450, h = 300;
		setBounds(parent.getX()+parent.getWidth()/2-w/2, parent.getY()+parent.getHeight()/2-h/2, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 21, 401, 183);
		contentPanel.add(scrollPane);
		
		lInmuebles = new JList<Inmueble>();
		DefaultListModel<Inmueble> model = new DefaultListModel<Inmueble>();
		lInmuebles.setModel(model);
		
		lInmuebles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lInmuebles);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				bAceptar = new JButton("Aceptar");
				bAceptar.setActionCommand("OK");
				buttonPane.add(bAceptar);
				getRootPane().setDefaultButton(bAceptar);
			}
			{
				bCancelar = new JButton("Cancelar");
				bCancelar.setActionCommand("Cancel");
				buttonPane.add(bCancelar);
			}
		}
		
		this.setTitle("Seleccionar inmueble");
		
		
		setHandlers();
		llenarInmuebles();
		this.setVisible(true);
	}
	
	private void llenarInmuebles(){
		List<Inmueble> inms = InmuebleDAO.getInmuebles();
		DefaultListModel model = (DefaultListModel) lInmuebles.getModel();
		for(Inmueble inm : inms){
			model.addElement(inm);
		}
		
	}
	
	private void setHandlers(){
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
	
	private void clickAceptar(){
	
		Inmueble inm = InmuebleDAO.getInmuebleById(lInmuebles.getSelectedValue().getId());
		VentanaVenta v = new VentanaVenta(parent,new InmuebleDTO(inm));
		parent.getContentPane().removeAll();
		parent.getContentPane().add(v);
		v.setVisible(true);
		v.setClosable(true);
		this.dispose();
		
		
	}
	
	private void clickCancelar(){
		this.dispose();
	}
}
