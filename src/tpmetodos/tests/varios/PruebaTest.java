package tpmetodos.tests.varios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Direccion;
import tpmetodos.datos.entidades.Pais;
import tpmetodos.datos.entidades.TelefonoDeVendedor;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.datos.entidades.constantes.IdLocalidad;
import tpmetodos.datos.entidades.constantes.IdTipoDeTelefono;
import tpmetodos.datos.hibernate.HibernateUtil;

@RunWith(JUnit4.class)
public class PruebaTest {
	
	public static void main(String[] args) throws IOException{
		BufferedImage img = ImageIO.read(new File("images/casita.jpg"));
		byte[] byteArray = ((DataBufferByte) img.getData().getDataBuffer()).getData();
		for(byte b : byteArray){
			System.out.print(b);
		}
	}
	
    @Test
    public void thisAlwaysPasses() {
    	assertEquals(new Double(7), new Double(7));
    	assertTrue(true);
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    	assertTrue(false);
    }
    
    @Test
    public void testVendedorDAO() {
    	/*Vendedor vendedor = new Vendedor();
    	vendedor.setNombres("Juan");
    	vendedor.setApellidos("Pérez");
    	
    	try {
			vendedor.setFechaDeNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("25-12-2000"));
		}
    	catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	Direccion direccion = new Direccion();
    	direccion.setLocalidad(MiscelaneoDAO.getLocalidadById(IdLocalidad.SANTA_FE));
    	
    	vendedor.setDireccion(direccion);
    	
    	TelefonoDeVendedor telefono = new TelefonoDeVendedor();
    	telefono.setCodigoDeArea("0342");
    	telefono.setNumero("123456789");
    	telefono.setTipo(MiscelaneoDAO.getTipoDeTelefonoById(IdTipoDeTelefono.FIJO));
    	
    	vendedor.getTelefonos().add(telefono);
    	
    	VendedorDAO.saveVendedor(vendedor);*/
        
       // VendedorDAO.deleteVendedor(4);
    }
}