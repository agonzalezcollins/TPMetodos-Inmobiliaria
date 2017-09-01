package tpmetodos.tests.varios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.entidades.Orientacion;

public class TestGetListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Orientacion> or = InmuebleDAO.getOrientaciones(); 
		System.out.println(or);
		JFrame frame = new JFrame();
		frame.setBounds(100,100,300,300);
		frame.setVisible(true);
		final JComboBox combo = new JComboBox();
		frame.getContentPane().add(combo);
		for(Orientacion o : or){
			combo.addItem(o);
		}
		JButton b = new JButton();
		frame.getContentPane().add(b);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Orientacion o = (Orientacion) combo.getSelectedItem();
				System.out.println(o.getId());
				
			}
			
		});
		
	}

}
