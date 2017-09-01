package tpmetodos.tests;

import java.sql.Date;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.datos.entidades.constantes.IdLocalidad;
import tpmetodos.datos.entidades.constantes.IdTipoDeTelefono;
import tpmetodos.dtos.DireccionDTO;
import tpmetodos.dtos.TelefonoDTO;
import tpmetodos.dtos.VendedorDTO;
import tpmetodos.servicio.VendedorService;
import tpmetodos.servicio.excepciones.NombreUsuarioYaExisteException;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;
import tpmetodos.servicio.excepciones.VendedorInvalidoException;

/**
 * Tests de la story ABM Vendedor
 * 
 * @author armandito
 * 
 */
@RunWith(JUnit4.class)
public class TestABMVendedor extends TestCase {
	private static VendedorDTO vendedorCorrectoDTO;
	private static Vendedor vendedorCorrecto = null;
	private static String usuarioValido; // datos de un vendedor que existe en la BD
	private static String contrasenaValida;

	
	@Before
	public void setUp() {
		// Instanciar un vendedor de prueba que sera dado de alta
		vendedorCorrectoDTO = crearVendedorCorrecto();
		// Esta info de vendedor existe en la BD y la instancia del mismo debe
		// recuperarse exitosamente
		usuarioValido = "jperez";
		contrasenaValida = "test123123";

	}

	@After
	public void tearDown() {
		// Dar de baja el vendedor de prueba ( por si no se lo dio de baja
		// antes)

	}

	/**
	 * Debe poder obtenerse un vendedor existente dado su usuario y contraseÃ±a
	 * 
	 * @throws VendedorInexistenteException
	 */
	@Test
	public void testObtenerVendedor() {
		setUp();
		Vendedor obtenido = VendedorDAO.getVendedorByUsernameAndPassword(
				usuarioValido, contrasenaValida);
		assertNotNull(
				"Debe obtenerse satisfactoriamente la instancia del vendedor ya que existe en la base de datos",
				obtenido);
		assertEquals("juan", obtenido.getNombres());
		assertEquals("perez", obtenido.getApellidos());
	}

	/**
	 * Debe dar de alta un vendedor valido.
	 * Luego darlo de baja
	 * 
	 * @throws VendedorInexistenteException
	 * @throws NombreUsuarioYaExisteException
	 */
	@Test
	public void testAltaBajaVendedor() throws VendedorInexistenteException,
			NombreUsuarioYaExisteException {
		//dar alta
		try {
			vendedorCorrecto = VendedorService
					.altaVendedor(vendedorCorrectoDTO);
		} catch (VendedorInvalidoException e) {
			fail("Datos de usuario invalidos");
		}
		//vendedorCorrecto no deberia ser null
		assertNotNull(vendedorCorrecto);
		assertNotNull(
				"Al acceder el vendedor recien dado de alta, debemos obtener una instancia valida",
				VendedorDAO.getVendedorByUsernameAndPassword(
						vendedorCorrectoDTO.getUsuario(),
						vendedorCorrectoDTO.getContrasena()));
		
		//dar de baja
		VendedorService.eliminarVendedor(vendedorCorrecto.getId());
		
		//no deberia seguir existiendo el vendedor con ese id
		assertNull(VendedorDAO.getVendedorById(vendedorCorrecto.getId()));
		
		

	}

	/**
	 * Se modifica el usuario ya existente, se persiste, y se recupera
	 * nuevamente.
	 * 
	 * @throws VendedorInexistenteException
	 * 
	 */
	@Test
	public void testModificarVendedor() throws VendedorInexistenteException {
		Vendedor existente = VendedorDAO.getVendedorByUsernameAndPassword(usuarioValido, contrasenaValida);
		
		VendedorDTO dto = new VendedorDTO(existente);
		
		String nuevoDni = ""+ (new Random()).nextInt(10000000); //generar DNI aleatorio
		
		dto.setDni(nuevoDni);

		Vendedor modificado = null;

		try {
			modificado = VendedorService.modificarVendedor(dto);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error persistiendo modificaciones");
		}
		existente = modificado;
		// se vuelve a cargar el vendedor a ver si el dni se guardo modificado
		Vendedor obtenido = VendedorDAO.getVendedorByUsernameAndPassword(usuarioValido,contrasenaValida);
		assertEquals(
				"El dni del vendedor cargado debe ser igual al recien modificado y persistido.",
				obtenido.getDni(), nuevoDni);
	}

	/**
	 * Se intenta dar de alta un vendedor con campos vacios/incompleto
	 * 
	 * Se suponen obligatorios nombre,apellido,usuario,contrasena
	 * 
	 * @throws VendedorInvalidoException
	 * @throws NombreUsuarioYaExisteException
	 * 
	 */
	@Test(expected = VendedorInvalidoException.class)
	public void testVendedorSinContrasena() throws VendedorInvalidoException,
			NombreUsuarioYaExisteException {
		VendedorDTO vendIncompleto = new VendedorDTO();
		vendIncompleto.setNombres("alberto");
		vendIncompleto.setApellidos("ruiz");
		vendIncompleto.setUsuario("aruiz");
		VendedorService.altaVendedor(vendIncompleto);
	}

	@Test(expected = VendedorInvalidoException.class)
	public void testVendedorSinUsuario() throws VendedorInvalidoException,
			NombreUsuarioYaExisteException {
		VendedorDTO vendIncompleto = new VendedorDTO();
		vendIncompleto.setNombres("alberto");
		vendIncompleto.setApellidos("ruiz");
		vendIncompleto.setContrasena("pass123");
		VendedorService.altaVendedor(vendIncompleto);
	}

	@Test(expected = VendedorInvalidoException.class)
	public void testVendedorSinNombre() throws VendedorInvalidoException,
			NombreUsuarioYaExisteException {
		VendedorDTO vendIncompleto = new VendedorDTO();
		vendIncompleto.setApellidos("ruiz");
		vendIncompleto.setUsuario("aruiz");
		vendIncompleto.setContrasena("pass123");
		VendedorService.altaVendedor(vendIncompleto);
	}

	@Test(expected = VendedorInvalidoException.class)
	public void testVendedorSinApellido() throws VendedorInvalidoException,
			NombreUsuarioYaExisteException {
		VendedorDTO vendIncompleto = new VendedorDTO();
		vendIncompleto.setNombres("alberto");
		vendIncompleto.setUsuario("aruiz");
		vendIncompleto.setContrasena("pass123");
		VendedorService.altaVendedor(vendIncompleto);
	}

	/**
	 * se intentara dar de alta un vendedor con nommbre de usuario que ya existe
	 * (jperez)
	 * 
	 * @throws VendedorInvalidoException
	 * @throws NombreUsuarioYaExisteException
	 */
	@Test(expected = NombreUsuarioYaExisteException.class)
	public void testUsuarioRepetido() throws VendedorInvalidoException,
			NombreUsuarioYaExisteException {
		VendedorDTO v = new VendedorDTO();
		v.setNombres("Vendedor");
		v.setApellidos("repetido");
		v.setUsuario("jperez");
		v.setContrasena("password");
		v.setDni("35123123");
		v.setFechaDeNacimiento(Date.valueOf("1991-05-10"));
		VendedorService.altaVendedor(v);

	}

	@Test
	public void testLoguearInvalido() {
		// nombre correcto, contraseña incorrecta
		String nombre1 = "jperez";
		String pass1 = "incorrecta";
		// nombre incorrecto, contraseña incorrecta
		String nombre2 = "usuarioinexistente";
		String pass2 = "asdsad";
		// nombre inexistente, contraseña existente
		String nombre3 = "usuario324738";
		String pass3 = "test123123";

		/*
		 * try{ VendedorDAO.getVendedorByUsernameAndPassword(nombre1, pass1);
		 * fail("Deberia haber tirado excepcion"); }
		 * catch(VendedorInexistenteException e){}
		 */
		if (VendedorDAO.getVendedorByUsernameAndPassword(nombre1, pass1) != null) {
			fail();
		}

		/*
		 * try{ VendedorDAO.getVendedorByUsernameAndPassword(nombre2, pass2);
		 * fail("Deberia haber tirado excepcion"); }
		 * catch(VendedorInexistenteException e){}
		 */
		if (VendedorDAO.getVendedorByUsernameAndPassword(nombre2, pass2) != null) {
			fail();
		}

		/*
		 * try{ VendedorDAO.getVendedorByUsernameAndPassword(nombre3, pass3);
		 * fail("Deberia haber tirado excepcion"); }
		 * catch(VendedorInexistenteException e){}
		 */
		if (VendedorDAO.getVendedorByUsernameAndPassword(nombre3, pass3) != null) {
			fail();
		}
	}
	
	@Test
	public void testCaracteresInvalidos(){
		VendedorDTO prueba = crearVendedorCorrecto();
		//dni invalido
		prueba.setDni("A238734");
		try{
			VendedorService.altaVendedor(prueba);
			fail("Deberia haber fallado");} catch(Exception e){}
		prueba = crearVendedorCorrecto();
		//nombre con simbolos
		prueba.setNombres("daniel medina @");
		try{
			VendedorService.altaVendedor(prueba);
			fail("Deberia haber fallado");} catch(Exception e){}
		prueba = crearVendedorCorrecto();
		//usuario con espacios
		prueba.setUsuario("usuario con espacios");
		try{
			VendedorService.altaVendedor(prueba);
			fail("Deberia haber fallado");} catch(Exception e){}
		prueba = crearVendedorCorrecto();
		//apellido invalido
		prueba.setApellidos("#apellido");
		try{
			VendedorService.altaVendedor(prueba);
			fail("Deberia haber fallado");} catch(Exception e){}
		prueba = crearVendedorCorrecto();
		prueba.setNombres("daniel medina @");
		try{
			VendedorService.altaVendedor(prueba);
			fail("Deberia haber fallado");} catch(Exception e){}
	}
	
	
	
	private VendedorDTO crearVendedorCorrecto(){
		VendedorDTO vendedorCorrectoDTO = new VendedorDTO();
		TelefonoDTO telefono = new TelefonoDTO();
		TelefonoDTO celu = new TelefonoDTO();
		DireccionDTO direccion = new DireccionDTO();

		
		direccion.setNumero("3723");
		direccion.setIdLocalidad(IdLocalidad.SANTA_FE);
		
		telefono.setIdTipo(IdTipoDeTelefono.FIJO);
		telefono.setCodigoDeArea("0342");
		telefono.setNumero("4536698");
		
		celu.setIdTipo(IdTipoDeTelefono.CELULAR);
		celu.setCodigoDeArea("0342");
		celu.setNumero("154654998");
		
		vendedorCorrectoDTO.setNombres("Vendedor");
		vendedorCorrectoDTO.setApellidos("de Prueba");
		vendedorCorrectoDTO.setUsuario("vprueba");
		vendedorCorrectoDTO.setContrasena("test123");
		vendedorCorrectoDTO.setDni("35123123");
		vendedorCorrectoDTO.setFechaDeNacimiento(Date.valueOf("1991-05-10"));
		vendedorCorrectoDTO.getTelefonos().add(telefono);
		vendedorCorrectoDTO.getTelefonos().add(celu);
		
		return vendedorCorrectoDTO;
	}
}
