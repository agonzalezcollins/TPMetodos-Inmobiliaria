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
import tpmetodos.datos.daos.VentaDAO;
import tpmetodos.datos.entidades.Direccion;
import tpmetodos.datos.entidades.EstadoDeInmueble;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.Venta;
import tpmetodos.datos.entidades.constantes.IdEstado;
import tpmetodos.datos.entidades.constantes.IdLocalidad;
import tpmetodos.datos.entidades.constantes.IdOrientacion;
import tpmetodos.datos.entidades.constantes.IdTipoDeInmueble;
import tpmetodos.dtos.DireccionDTO;
import tpmetodos.dtos.FotoDeInmuebleDTO;
import tpmetodos.dtos.InmuebleDTO;
import tpmetodos.dtos.VentaDTO;
import tpmetodos.dtos.ClienteDTO;
import tpmetodos.servicio.InmuebleService;
import tpmetodos.servicio.VentaService;
import tpmetodos.servicio.excepciones.InmuebleInexistenteException;
import tpmetodos.servicio.excepciones.InmuebleInvalidoException;
import tpmetodos.servicio.excepciones.InmuebleReservadoException;
import tpmetodos.servicio.excepciones.VentaInvalidaException;
import tpmetodos.ui.VentanaSeleccionarInmueble;
import tpmetodos.ui.VentanaVenta;

/**
 * Tests de la story Venta
 * 
 * @author Agu
 * 
 */

@RunWith(JUnit4.class)
public class TestVenta extends TestCase {
	
	public ClienteDTO clienteCorrecto;
	public InmuebleDTO inmuebleCorrecto;
	public VentaDTO ventaCorrecta; // un inmueble y cliente con toda la info correcta listo para la venta
	public final int idVentaValido = 1;
	public int idVentaAlta;
	
	@Before
	public void setUp(){
		System.out.println("Setting up");
		
		// Cliente //
		Direccion direccionCliente = new Direccion();
		direccionCliente.setBarrio("Guadalupe Oeste");
		direccionCliente.setNumero("1560");
		direccionCliente.setCalleAlternativa("Av. Gorriti");
		
		ClienteDTO clienteCorrecto = new ClienteDTO();
		clienteCorrecto.setId(20000);
		clienteCorrecto.setNombres("Ramon Ramiro");
		clienteCorrecto.setApellidos("Perez");
		clienteCorrecto.setDni("34785985");
		clienteCorrecto.setDireccion(direccionCliente);
		clienteCorrecto.setEmail("ramon@mail.com");
		clienteCorrecto.setFechaDeNacimiento(new Date(1970-11-12));
		
		
		
		// Inmueble //
		DireccionDTO direccionInmueble = new DireccionDTO();
		direccionCliente.setBarrio("amenabar");
		direccionCliente.setNumero("2500");
		direccionCliente.setCalleAlternativa("Barrio Suer");
		
		InmuebleDTO inmuebleCorrecto = new InmuebleDTO();
		inmuebleCorrecto.setAguaCorriente(true);
		inmuebleCorrecto.setId(IdEstado.RESERVADO);
		inmuebleCorrecto.setAntiguedad(15);
		inmuebleCorrecto.setCantidadDeBanos(1);
		inmuebleCorrecto.setCantidadDeDormitorios(2);
		inmuebleCorrecto.setCloaca(true);
		
		inmuebleCorrecto.setDireccion(direccionInmueble);
		inmuebleCorrecto.setFechaDeAlta(new Date());
		inmuebleCorrecto.setGarage(true);
		inmuebleCorrecto.setGasNatural(true);
		inmuebleCorrecto.setIdOrientacion(IdOrientacion.ESTE);
		inmuebleCorrecto.setIdPropietario(1);
		inmuebleCorrecto.setIdTipo(IdTipoDeInmueble.CASA);
		inmuebleCorrecto.setLavadero(true);
		inmuebleCorrecto.setLongitudDeFondo(40);
		inmuebleCorrecto.setLongitudDeFrente(30);
		inmuebleCorrecto.setObservaciones("");
		inmuebleCorrecto.setPatio(true);
		inmuebleCorrecto.setPavimento(true);
		inmuebleCorrecto.setPiscina(true);
		inmuebleCorrecto.setPrecioDeVenta(870000);
		inmuebleCorrecto.setPropiedadHorizontal(true);
		inmuebleCorrecto.setSuperficie(1200);
		inmuebleCorrecto.setTelefono(false);
				
		// venta
		ventaCorrecta = new VentaDTO();
		ventaCorrecta.setCliente(clienteCorrecto);
		ventaCorrecta.setInmueble(inmuebleCorrecto);
		ventaCorrecta.setFechaventa(new Date(2013-12-31));
		
	}
	
	@After
	public void tearDown(){
		System.out.println("Tearing down");
	}
	
	// TODO CASOS
	// Venta a un Cliente sin ALTA en la BD -> 
	// Venta en fecha Invalida
	// Venta de inmueble con estado VENDIDO -> en Proceso 
	// Venta de inmueble con estado Reservado (! DAR AL USUARIO LA FECHA DE EXPIRACION DE LA RESERVA)
	// Venta con un importe INVALIDO (! Preguntar si el importe es Menor al precio de venta)
	
	
	/**
	 * Se efectua una venta recibiendo un inmueble y un cliente validos
	 *  
	 * se intenta efectuar la venta cuando el inmueble esta en estado: vendido
	 * @throws InmuebleReservadoException 
	 */
	@Test
	public void testEjecutraVenta() throws InmuebleReservadoException{
		
		try {
			Venta venta = new Venta(ventaCorrecta);
		} catch (Exception e) {
			throw new InmuebleReservadoException();
		}
		
		
		
		
		
		
		
	}
//	
//	/**
//	 * se carga un inmueble ya existente, se le modifica un campo y se vuelve a persistir
//	 * luego se vuelve a obtener y se verifica q la modificacion se haya persistido
//	 */
//	@Test
//	public void testModificacion(){
//		
//		Inmueble inmuebleCargado = InmuebleService.getInmuebleById(idInmuebleValido);
//		int antiguedadModificada = (new Random()).nextInt(50);
//		InmuebleDTO dto = new InmuebleDTO(inmuebleCargado);
//		dto.setAntiguedad(antiguedadModificada);
//		Inmueble inmuebleModificado = InmuebleService.modificarInmueble(dto);
//		assertNotNull(inmuebleModificado);
//		
//		Inmueble inmuebleRecuperado = InmuebleService.getInmuebleById(idInmuebleValido);
//		assertTrue(inmuebleRecuperado.getAntiguedad() == antiguedadModificada);
//		
//		
//		
//	}
//	
//	/**
//	 * Verifico que exista el inmueble con id = idInmuebleAlta,
//	 * luego elimino el inmueble con ese id y finalmente
//	 * compruebo que al intentar recuperarlo obtenga null.
//	 */
//	@Test
//	public void testBaja(){
//		
//		assertNotNull(InmuebleService.getInmuebleById(idInmuebleAlta));
//		
//		InmuebleService.eliminarInmueble(idInmuebleAlta);
//		Inmueble inmuebleEliminado = InmuebleService.getInmuebleById(idInmuebleAlta);
//		
//		assertNull(inmuebleEliminado);
//		
//	}
//	
//	/**
//	 * Tomar el inmueble valido definido, setear el importe invalido,
//	 * y comprobar que los controles de la logica impiden que se guarde en la 
//	 * base de datos.
//	 */
//	@Test
//	public void testImporteVenta(){
//		
//		ventaCorrecta.setImporteVenta(-500.0);
//		
//		try{ 
//			VentaService.altaVenta(ventaCorrecta);
//			fail();
//		}catch(VentaInvalidaException e){/* no hago nada*/}
//		
//		
//		
//	}
	
	
	
}
