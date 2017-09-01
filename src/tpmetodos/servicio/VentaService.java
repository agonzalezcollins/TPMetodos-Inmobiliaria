package tpmetodos.servicio;

import tpmetodos.datos.daos.VentaDAO;
import tpmetodos.datos.entidades.Venta;
import tpmetodos.datos.entidades.constantes.IdEstado;
import tpmetodos.dtos.VentaDTO;
import tpmetodos.servicio.excepciones.VentaInvalidaException;
import tpmetodos.ui.mensajes.MensajeAdvertencia;
import tpmetodos.ui.mensajes.MensajeAlerta;
import tpmetodos.ui.mensajes.MensajeInformacionExito;

/**
 * Servicio de Venta para Confirmar venta
 * 
 * @author Agu
 *
 */
public class VentaService {

	/**
	 * Da de alta una venta
	 * Debe asignar codigo
	 * 
	 * 
	 * @param dto
	 * @return Venta
	 * @exception VentaInvalidaException
	 */
	public static Venta confirmarVenta(VentaDTO dto) throws VentaInvalidaException {
		
		// Se instancia una venta
		Venta venta = new Venta(dto);
		
		// Control Inmueble
		if(venta.getInmueble()==null){
			new MensajeAlerta(null, "Atencion", "Debe ingresar un inmueble");
			throw new VentaInvalidaException("Inmueble incorrecto: No se ingresa");
		}
		
		switch (venta.getInmueble().getEstado().getId()) {
			case (int) IdEstado.RESERVADO:
				new MensajeAlerta(null, "Atencion", "El Inmueble esta RESERVADO");
				throw new VentaInvalidaException("Inmueble incorrecto: RESERVADO");
			case (int )IdEstado.VENDIDO:
				new MensajeAlerta(null, "Atencion", "El Inmueble ya fue VENDIDO");
				throw new VentaInvalidaException("Inmueble incorrecto: VENDIDO");
		}		
		
		// Control Cliente
		if(venta.getCliente()==null){
			new MensajeAlerta(null, "Atencion", "Debe ingresar un cliente");
			throw new VentaInvalidaException("Cliente incorrecto: No se ingresa");
		}
		
		// Control del Importe de Venta
		if(venta.getImporte()<0){
			new MensajeAlerta(null, "Atencion", "El importe debe ser correcto");
			throw new VentaInvalidaException("Importe incorrecto: Negativo");
		}
		
		if(venta.getImporte()<=venta.getInmueble().getPrecioDeVenta()){
			MensajeAdvertencia mensaje = new MensajeAdvertencia(null, "Venta Inmueble", "El importe de venta es menor que el valor del inmueble: ¿Desea Continuar?");
			if(!mensaje.isRespuesta()){
				throw new VentaInvalidaException("Importe incorrecto: Importe de venta menor al valor del inmueble");
			}
		}
		
		// Control de Fecha Venta
		if(venta.getFechaDeVenta()==null){
			new MensajeAlerta(null, "Atencion", "La Fecha debe ser correcta");
			throw new VentaInvalidaException("Fecha incorrecta: No se ingresa");
		}
		
		// ->  Todavia no corresponde otros controles de Fecha porque se ingresa la actual.
		
		// Si paso los controles, confirmamos:
		MensajeAdvertencia mensaje = new MensajeAdvertencia(null, "Venta Inmueble", "Confirma venta del inmueble a nombre de: "+venta.getCliente().getApellidos()+", "+venta.getCliente().getNombres());
		if(!mensaje.isRespuesta()){
			throw new VentaInvalidaException("Venta incorrecta: Rechazada por el usuario");
		} 
		
		// Validar Venta en la Base de Datos
		validarVenta(venta);
		
		// Avisamos que salio todo bien
		new MensajeInformacionExito(null,"Venta confirmada","La operación a sido exitosa");
		
		return venta;
	}
	
	/**
	 * Metodo que valida si se puede realizar la venta en base al estado de la venta
	 * @param venta
	 * @throws VentaInvalidaException
	 */
	private static void validarVenta(Venta venta) throws VentaInvalidaException {
		
		// ALTA VENTA
		// Agregamos Estado Inmueble VENDIDO
		venta.getInmueble().getEstado().setId(IdEstado.VENDIDO);
			
		// Guardar venta en base de datos
		try{
			VentaDAO.saveVenta(venta);
			// Setear estado VENDIDO al inmueble
			//venta.getInmueble().setEstado(InmuebleDAO.getEstadoById(IdEstado.VENDIDO));
		}
		catch(Exception e){
			new MensajeAlerta(null, "Atencion", "Hay problemas en la conexion a la base de datos, intente nuevamente");
			throw new VentaInvalidaException("Error persistiendo venta (error DAO)");
		}		
	}
}
