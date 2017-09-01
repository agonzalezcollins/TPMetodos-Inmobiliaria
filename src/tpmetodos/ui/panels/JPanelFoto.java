package tpmetodos.ui.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import tpmetodos.dtos.FotoDeInmuebleDTO;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.ui.mensajes.MensajeAlerta;

public class JPanelFoto extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private BufferedImage img = null;
	private InmuebleDTO dto;
	
	
	public JPanelFoto(InmuebleDTO dto){
		this.dto = dto;
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(dto.getFotos().size() > 0 && img == null){
			FotoDeInmuebleDTO foto = (FotoDeInmuebleDTO) ((dto.getFotos().toArray())[0]);
			//System.out.println(foto.getPath());
			try{
				img = ImageIO.read(new File(foto.getPath()));
			}
			catch(Exception e){
				new MensajeAlerta(null, "Error", "Problemas al cargando foto. Path = "+foto.getPath());
				dto.getFotos().clear();
			}
		}
		
		if(img != null)
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);
	}
	public void recargar(){
		img = null;
		this.repaint();
	}
	
}
