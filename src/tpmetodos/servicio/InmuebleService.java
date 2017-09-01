package tpmetodos.servicio;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.entidades.FotoDeInmueble;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.constantes.IdEstado;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.servicio.excepciones.InmuebleInexistenteException;
import tpmetodos.servicio.excepciones.InmuebleInvalidoException;

public class InmuebleService {

	/**
	 * Da de alta un inmueble
	 * Debe asignar codigo
	 * 
	 * 
	 * @param dto
	 * @return 
	 */
	public static Inmueble altaInmueble(InmuebleDTO dto) throws InmuebleInvalidoException {
		//TODO
		//2 cargar los bytes de la imagen
		//3 asignar estado ALTA
		//4 asignar fecha de alta
		
		
		//instanciar el inmueble concreto
		Inmueble inm = new Inmueble(dto);
		//setear fecha de alta a la actual
		inm.setFechaDeAlta(new Date());
		//setear estado ALTa al inmueble
		inm.setEstado(InmuebleDAO.getEstadoById(IdEstado.ALTA));
		//cargar fotos
		try{
			for(FotoDeInmueble foto : inm.getFotos()){
				BufferedImage img = ImageIO.read(new File(foto.getPath()));
				byte[] byteArray = ((DataBufferByte) img.getData().getDataBuffer()).getData();
				foto.setFoto(byteArray);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new InmuebleInvalidoException("Error cargando las imagenes");
		}
		
		//validar datos
		validarInmueble(inm);
		
		//guardar en base de datos
		try{
			InmuebleDAO.saveInmueble(inm);
		}
		catch(Exception e){
			throw new InmuebleInvalidoException("Error persistiendo inmueble (error DAO)");
		}
		return inm;
	}

	public static void validarInmueble(Inmueble inm) throws InmuebleInvalidoException {
		//validar precio
		if(inm.getPrecioDeVenta() <= 0)
			throw new InmuebleInvalidoException("El precio debe ser positivo");
		
	}

	public static Inmueble modificarInmueble(InmuebleDTO dto) throws InmuebleInvalidoException {
		//instanciar un inmueble concreto
		Inmueble inm = new Inmueble(dto);
		validarInmueble(inm);
		InmuebleDAO.updateInmueble(inm);
		
		return inm;
		
	}

	public static Inmueble getInmuebleById(int idInmuebleValido) {
		// TODO Auto-generated method stub
		return InmuebleDAO.getInmuebleById(idInmuebleValido);

	}

	public static void eliminarInmueble(int idInmuebleValido) throws InmuebleInexistenteException {
		InmuebleDAO.deleteInmueble(idInmuebleValido);
		
	}
}
