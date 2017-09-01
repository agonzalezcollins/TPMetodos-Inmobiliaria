package tpmetodos.dtos;

import java.util.Date;

import tpmetodos.datos.entidades.Cliente;
import tpmetodos.datos.entidades.Inmueble;
import tpmetodos.datos.entidades.Venta;


/**
 * CLase Data Transfer Object de Venta
 * 
 * @author Agu
 */
public class VentaDTO {

	private int idVenta;
	private Date fechaventa;
	private double importeVenta;
	
	private InmuebleDTO inmueble;
	private ClienteDTO cliente;
	

	/**
	 * Constructor:
	 * Instanciar un DTO Venta vacia
	 * 
	 * @param venta
	 */
	public VentaDTO(){
		this.inmueble = null;
		this.cliente = null;
		this.setFechaventa(new Date());
		this.importeVenta = 0d;	
	}
	
	/**
	 * Constructor:
	 * Instanciar un DTO Venta en base un objeto Venta.
	 * 
	 * @param venta
	 */
	public VentaDTO(Venta venta){
		this.inmueble = new InmuebleDTO(venta.getInmueble());
		this.cliente = new ClienteDTO(venta.getCliente());
		this.setFechaventa(venta.getFechaDeVenta());
		this.importeVenta = venta.getImporte();	
	}
	
	/**
	 * Constructor:
	 * Instanciar un DTO Venta en base un cliente, un objeto inmueble y un importe.
	 * 
	 * @param cliente
	 * @param inmueble
	 * @param importe
	 */
	public VentaDTO(Cliente cliente, Inmueble inmueble, double importe){
		this.inmueble = new InmuebleDTO(inmueble);
		this.cliente = new ClienteDTO(cliente);
		this.setFechaventa(new Date()); // Fecha del momento
		this.importeVenta = importe;
	}

	/**
	 * Constructor:
	 * Instanciar un DTO Venta en base un cliente, un objeto inmueble, un importe y una fecha.
	 * 
	 * @param cliente
	 * @param inmueble
	 * @param importe
	 * @param fecha
	 */
	public VentaDTO(Cliente cliente, Inmueble inmueble, double importe, Date fecha){
		this.inmueble = new InmuebleDTO(inmueble);
		this.cliente = new ClienteDTO(cliente);
		this.fechaventa = fecha;
		this.importeVenta = importe;
	}
	
	// -> GETTERS AND SETTERS <- //
	
	

	public void setInmueble(InmuebleDTO inmueble) {
		this.inmueble = inmueble;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public double getImporteVenta() {
		return importeVenta;
	}

	public void setImporteVenta(double importeVenta) {
		this.importeVenta = importeVenta;
	}
	
	public int getIDCliente(){
		return cliente.getId();
	}
	
	public int getIDInmueble(){
		return inmueble.getId();
	}
	
	public int getIDVenta(){
		return this.idVenta;
	}
	
	public InmuebleDTO getInmueble() {
		return inmueble;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}
	
}
