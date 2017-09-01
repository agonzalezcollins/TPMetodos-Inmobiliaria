package tpmetodos.tests;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.constantes.IdLocalidad;
import tpmetodos.datos.entidades.constantes.IdOrientacion;
import tpmetodos.datos.entidades.constantes.IdTipoDeInmueble;
import tpmetodos.dtos.DireccionDTO;
import tpmetodos.dtos.FotoDeInmuebleDTO;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.servicio.InmuebleService;
import tpmetodos.servicio.excepciones.InmuebleInexistenteException;
import tpmetodos.servicio.excepciones.InmuebleInvalidoException;

/**
 * Tests de la story ABM Inmueble
 * 
 * @author armandito
 * 
 */
@RunWith(JUnit4.class)
public class TestABMInmueble extends TestCase {
	public InmuebleDTO inmuebleCorrecto; // un inmueble con toda la info correcta listo para dar de alta
	public int idInmuebleValido = 1; // id de un registro de inmueble que exista en la BD
	public int idInmuebleAlta;
	
	@Before
	public void setUp(){
		System.out.println("Setting up");
		Set<FotoDeInmuebleDTO> fotos = new HashSet<FotoDeInmuebleDTO>();
		FotoDeInmuebleDTO foto = new FotoDeInmuebleDTO();
		foto.setDescripcion("Muy linda casa");
		foto.setPath("images/casita.jpg");
		fotos.add(foto);
		
		DireccionDTO direccion = new DireccionDTO();
		direccion.setBarrio("Los troncos");
		direccion.setIdLocalidad(IdLocalidad.SANTA_FE);
		direccion.setNumero("8273");
		direccion.setCalleAlternativa("Aristobulo del Valle");
		
		inmuebleCorrecto = new InmuebleDTO();
		inmuebleCorrecto.setAguaCorriente(true);
		inmuebleCorrecto.setAntiguedad(15);
		inmuebleCorrecto.setCantidadDeBanos(1);
		inmuebleCorrecto.setCantidadDeDormitorios(2);
		inmuebleCorrecto.setCloaca(true);
		inmuebleCorrecto.setDireccion(direccion);
		inmuebleCorrecto.setFechaDeAlta(new Date());
		inmuebleCorrecto.setFotos(fotos);
		inmuebleCorrecto.setGarage(true);
		inmuebleCorrecto.setGasNatural(true);
		inmuebleCorrecto.setIdOrientacion(IdOrientacion.OESTE);
		inmuebleCorrecto.setIdPropietario(1);
		inmuebleCorrecto.setIdTipo(IdTipoDeInmueble.CASA);
		inmuebleCorrecto.setLavadero(true);
		inmuebleCorrecto.setLongitudDeFondo(30.0);
		inmuebleCorrecto.setLongitudDeFrente(20);
		inmuebleCorrecto.setObservaciones("");
		inmuebleCorrecto.setPatio(true);
		inmuebleCorrecto.setPavimento(true);
		inmuebleCorrecto.setPiscina(false);
		inmuebleCorrecto.setPrecioDeVenta(500000);
		inmuebleCorrecto.setPropiedadHorizontal(false);
		inmuebleCorrecto.setSuperficie(600);
		inmuebleCorrecto.setTelefono(true);
		
		
	}
	
	@After
	public void tearDown(){
		System.out.println("Tearing down");
	}
	
	/**
	 * Se da de alta un inmueble con atributos validos. Luego de intentar darlo de alta
	 * se carga y se verifica que se haya guardado con los datos correctos.
	 * 
	 * luego se intenta dar de baja y se verifica que no exista mas dicho ID
	 * @throws InmuebleInvalidoException 
	 * @throws InmuebleInexistenteException 
	 */
	@Test
	public void testAltaBaja() throws InmuebleInvalidoException, InmuebleInexistenteException{
		//dar alta y testear q exista
		Inmueble inmueble = InmuebleService.altaInmueble(inmuebleCorrecto);
		int id = inmueble.getId();
		assertTrue(id != 0);
		
		Inmueble inmuebleCargado = InmuebleDAO.getInmuebleById(id);
		this.idInmuebleAlta = inmuebleCargado.getId();
		
		assertEquals(inmuebleCorrecto.getLongitudDeFondo(),inmuebleCargado.getLongitudDeFondo(),0.1);
		assertEquals(inmuebleCorrecto.getPrecioDeVenta(),inmuebleCargado.getPrecioDeVenta(),0.1);
		
		//dar de baja y testear q no exista mas
		InmuebleService.eliminarInmueble(id);
		
		assertNull(InmuebleDAO.getInmuebleById(id));
		
	}
	
	/**
	 * se carga un inmueble ya existente, se le modifica un campo y se vuelve a persistir
	 * luego se vuelve a obtener y se verifica q la modificacion se haya persistido
	 * @throws InmuebleInvalidoException 
	 */
	@Test
	public void testModificacion() throws InmuebleInvalidoException{
		
		Inmueble inmuebleCargado = InmuebleService.getInmuebleById(idInmuebleValido);
		int antiguedadModificada = (new Random()).nextInt(50);
		InmuebleDTO dto = new InmuebleDTO(inmuebleCargado);
		dto.setAntiguedad(antiguedadModificada);
		Inmueble inmuebleModificado = InmuebleService.modificarInmueble(dto);
		assertNotNull(inmuebleModificado);
		
		Inmueble inmuebleRecuperado = InmuebleService.getInmuebleById(idInmuebleValido);
		assertTrue(inmuebleRecuperado.getAntiguedad() == antiguedadModificada);
		
		
		
	}
	
	
	
	/**
	 * Tomar el inmueble valido definido, setear un campo obligatorio como null,
	 * y comprobar que los controles de la logica impiden que se guarde en la 
	 * base de datos.
	 */
	
	@Test
	public void testCampos(){
		
		inmuebleCorrecto.setPrecioDeVenta(-500.0);
		
		try{ 
			InmuebleService.altaInmueble(inmuebleCorrecto);
			fail();
		}catch(InmuebleInvalidoException e){/* no hago nada*/}
		
		
		
	}
	
	
	
}
