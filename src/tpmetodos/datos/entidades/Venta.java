package tpmetodos.datos.entidades;

import java.util.Date;

import tpmetodos.dtos.VentaDTO;

public class Venta {

	private int id;
	private Date fechaDeVenta;
	private double importe;
	private Inmueble inmueble;
	private Cliente cliente;

	
	public Venta(VentaDTO venta){
		this.id = venta.getIDVenta();
		this.fechaDeVenta = venta.getFechaventa();
		this.importe = venta.getImporteVenta();
		this.inmueble = new Inmueble(venta.getInmueble());
		this.cliente = new Cliente (venta.getCliente());
		
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public Date getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(Date fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
