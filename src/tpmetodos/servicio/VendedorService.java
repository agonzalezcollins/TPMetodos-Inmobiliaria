package tpmetodos.servicio;

import java.util.List;

import tpmetodos.datos.daos.VendedorDAO;
import tpmetodos.datos.entidades.Vendedor;
import tpmetodos.dtos.VendedorDTO;
import tpmetodos.servicio.excepciones.NombreUsuarioYaExisteException;
import tpmetodos.servicio.excepciones.VendedorInexistenteException;
import tpmetodos.servicio.excepciones.VendedorInvalidoException;
import tpmetodos.utils.UtilString;

public class VendedorService {

	/**
	 * Obtiene la lista de todos los vendedores.
	 */
	public static List<VendedorDTO> getVendedores() {
		// TODO: Completar
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Da de alta un nuevo vendedor.
	 */
	public static Vendedor altaVendedor(VendedorDTO dto)
			throws VendedorInvalidoException,NombreUsuarioYaExisteException {
		validarNuevoVendedor(dto);
		Vendedor nuevo = new Vendedor(dto);
		VendedorDAO.saveVendedor(nuevo);
		return nuevo;
	}

	/**
	 * Actualiza los datos de un vendedor determinado.
	 * @throws NombreUsuarioYaExisteException 
	 */
	public static Vendedor modificarVendedor(VendedorDTO dto)
			throws VendedorInvalidoException, NombreUsuarioYaExisteException {
		validarVendedor(dto);
		Vendedor v = new Vendedor(dto);
		VendedorDAO.updateVendedor(v);
		return v;
	}
	
	/**
	 * Elimina los datos de un vendedor determinado.
	 * @throws VendedorInvalidoException 
	 */
	public static void eliminarVendedor(int idVendedor) throws VendedorInexistenteException{
		VendedorDAO.deleteVendedor(idVendedor);
	}

	/**
	 * valida los datos de un vendedor nuevo (validacion normal + chequear q no exista el nombre de usuario)
	 * @param dto
	 * @throws VendedorInvalidoException
	 * @throws NombreUsuarioYaExisteException
	 */
	private static void validarNuevoVendedor(VendedorDTO dto)
			throws VendedorInvalidoException, NombreUsuarioYaExisteException {
		//validaciones normales
		validarVendedor(dto);
		
		//verificar que no exista el usuario
		if(VendedorDAO.existeNombreUsuario(dto.getUsuario()))
			throw new NombreUsuarioYaExisteException("Ya esta registrado el nombre de usuario");
	}
	
	/**
	 * validar datos del usuario nuevo, tanto para modificar como para dar alta
	 * @param dto
	 * @throws VendedorInvalidoException
	 * @throws NombreUsuarioYaExisteException
	 */
	private static void validarVendedor(VendedorDTO dto) throws VendedorInvalidoException{
		//verificar formatos
				if(!UtilString.isAlpha(dto.getApellidos()))
					throw new VendedorInvalidoException("El apellido debe constar de letras");
				if(!UtilString.isAlpha(dto.getNombres()))
					throw new VendedorInvalidoException("El nombre debe constar de letras");
				if(!UtilString.isAlphaNumeric(dto.getUsuario(),false))
					throw new VendedorInvalidoException("El usuario debe constar de caracteres alfanumericos");
				if(!UtilString.isNumber(dto.getDni()))
					throw new VendedorInvalidoException("El DNI debe constar de numeros. DNI = "+dto.getDni());
				
				//verificar campos obligatorios y longitud
				if(dto.getNombres().length() < 2){
					throw new VendedorInvalidoException("El nombre es obligatorio y debe tener 2 o mas caracteres");
				}
				if(dto.getApellidos().length() < 2){
					throw new VendedorInvalidoException("El apellido es obligatorio y debe tener 2 o mas letras");
				}
				if(dto.getUsuario().length() < 2){
					throw new VendedorInvalidoException("El nombre de usuario es obligatorio y debe tener 2 o mas caracteres");
				}
				if(dto.getContrasena().length() < 6){
					throw new VendedorInvalidoException("La contrasena es obligatoria y debe tener 6 o mas caracteres");
				}
	}

	public static Vendedor getVendedorByDNI(String dni) throws VendedorInexistenteException{
		Vendedor v = VendedorDAO.getVendedorByDNI(dni);
		if (v == null)
			throw new VendedorInexistenteException("No existe un vendedor con ese DNI");		
		return v;
	}
	
}
