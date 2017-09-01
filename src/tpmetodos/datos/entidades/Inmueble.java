package tpmetodos.datos.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import tpmetodos.datos.daos.InmuebleDAO;
import tpmetodos.dtos.FotoDeInmuebleDTO;
import tpmetodos.dtos.InmuebleDTO;

public class Inmueble {

	private int id;						//autogenerado
	private Date fechaDeAlta;			//autogenerado
	private double precioDeVenta;		
	private Orientacion orientacion;	
	private double longitudDeFrente;	
	private double longitudDeFondo;		
	private double superficie;
	private boolean propiedadHorizontal;
	private int antiguedad;
	private int cantidadDeDormitorios;
	private int cantidadDeBanos;
	private boolean garage;
	private boolean patio;
	private boolean piscina;
	private boolean aguaCorriente;
	private boolean telefono;
	private boolean lavadero;
	private boolean pavimento;
	private boolean cloaca;
	private boolean gasNatural;
	private String observaciones;
	private Propietario propietario = new Propietario();
	private EstadoDeInmueble estado;	//autogenerado
	private TipoDeInmueble tipo;
	private Direccion direccion;
	private Set<FotoDeInmueble> fotos = new HashSet<FotoDeInmueble>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public Orientacion getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}

	public double getLongitudDeFrente() {
		return longitudDeFrente;
	}

	public void setLongitudDeFrente(double longitudDeFrente) {
		this.longitudDeFrente = longitudDeFrente;
	}

	public double getLongitudDeFondo() {
		return longitudDeFondo;
	}

	public void setLongitudDeFondo(double longitudDeFondo) {
		this.longitudDeFondo = longitudDeFondo;
	}

	public boolean esPropiedadHorizontal() {
		return propiedadHorizontal;
	}

	public void setPropiedadHorizontal(boolean propiedadHorizontal) {
		this.propiedadHorizontal = propiedadHorizontal;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int getCantidadDeDormitorios() {
		return cantidadDeDormitorios;
	}

	public void setCantidadDeDormitorios(int cantidadDeDormitorios) {
		this.cantidadDeDormitorios = cantidadDeDormitorios;
	}

	public int getCantidadDeBanos() {
		return cantidadDeBanos;
	}

	public void setCantidadDeBanos(int cantidadDeBanos) {
		this.cantidadDeBanos = cantidadDeBanos;
	}

	public boolean tieneGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean tienePatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}

	public boolean tienePiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean tieneAguaCorriente() {
		return aguaCorriente;
	}

	public void setAguaCorriente(boolean aguaCorriente) {
		this.aguaCorriente = aguaCorriente;
	}

	public boolean tieneTelefono() {
		return telefono;
	}

	public void setTelefono(boolean telefono) {
		this.telefono = telefono;
	}

	public boolean tieneLavadero() {
		return lavadero;
	}

	public void setLavadero(boolean lavadero) {
		this.lavadero = lavadero;
	}

	public boolean tienePavimento() {
		return pavimento;
	}

	public void setPavimento(boolean pavimento) {
		this.pavimento = pavimento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public EstadoDeInmueble getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeInmueble estado) {
		this.estado = estado;
	}

	public TipoDeInmueble getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeInmueble tipo) {
		this.tipo = tipo;
	}

	public Set<FotoDeInmueble> getFotos() {
		return fotos;
	}

	public void setFotos(Set<FotoDeInmueble> fotos) {
		this.fotos = fotos;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public void setCloaca(boolean b){
		cloaca = b;
	}
	
	public boolean tieneCloaca(){
		return cloaca;
	}
	
	public void setGasNatural(boolean b){
		gasNatural = b;
	}
	
	public boolean tieneGasNatural(){
		return gasNatural;
	}
	
	
	
	public boolean isPropiedadHorizontal() {
		return propiedadHorizontal;
	}

	public boolean isGarage() {
		return garage;
	}

	public boolean isPatio() {
		return patio;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public boolean isAguaCorriente() {
		return aguaCorriente;
	}

	public boolean isTelefono() {
		return telefono;
	}

	public boolean isLavadero() {
		return lavadero;
	}

	public boolean isPavimento() {
		return pavimento;
	}

	public boolean isCloaca() {
		return cloaca;
	}

	public boolean isGasNatural() {
		return gasNatural;
	}

	public Inmueble(InmuebleDTO dto){
		id = dto.getId();
		fechaDeAlta = dto.getFechaDeAlta();
		precioDeVenta = dto.getPrecioDeVenta();
		orientacion = InmuebleDAO.getOrientacionById(dto.getIdOrientacion());
		longitudDeFrente = dto.getLongitudDeFrente();
		longitudDeFondo = dto.getLongitudDeFondo();
		superficie = dto.getSuperficie();
		propiedadHorizontal = dto.esPropiedadHorizontal();
		antiguedad = dto.getAntiguedad();
		cantidadDeDormitorios = dto.getCantidadDeDormitorios();
		cantidadDeBanos = dto.getCantidadDeBanos();
		garage = dto.tieneGarage();
		patio = dto.tienePatio();
		piscina = dto.tienePiscina();
		aguaCorriente = dto.tieneAguaCorriente();
		telefono = dto.tieneTelefono();
		lavadero = dto.tieneLavadero();
		pavimento = dto.tienePavimento();
		cloaca = dto.tieneCloaca();
		gasNatural = dto.tieneGasNatural();
		observaciones = dto.getObservaciones();
		propietario = new Propietario();
		estado = InmuebleDAO.getEstadoById(dto.getIdEstado());
		tipo = InmuebleDAO.getTipoById(dto.getIdTipo());
		direccion = new Direccion(dto.getDireccion());
		
		for(FotoDeInmuebleDTO fdto : dto.getFotos()){
			FotoDeInmueble foto = new FotoDeInmueble(fdto);
			fotos.add(foto);
		}
		
		
	}
	public Inmueble(){
		
	}

	@Override
	public String toString() {
		return ""+id+" - ["+direccion.getLocalidad()+"]\t "+direccion.getCalleAlternativa()+" "+direccion.getNumero();
	}
	
	
	
}
