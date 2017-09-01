package tpmetodos.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import tpmetodos.datos.entidades.FotoDeInmueble;
import tpmetodos.datos.entidades.Inmueble;

public class InmuebleDTO {

	private int id = 0;
	private Date fechaDeAlta = new Date();
	private double precioDeVenta = 0;
	private int idOrientacion = 1;
	private double longitudDeFrente = 0;
	private double longitudDeFondo = 0;
	private double superficie = 0;
	private boolean propiedadHorizontal = false;
	private int antiguedad = 0;
	private int cantidadDeDormitorios = 0;
	private int cantidadDeBanos = 0;
	private boolean garage = true;
	private boolean patio = true;
	private boolean piscina = false;
	private boolean aguaCorriente = true;
	private boolean telefono = true;
	private boolean lavadero = true;
	private boolean pavimento = true;
	private boolean cloaca = true;
	private boolean gasNatural = true;
	private String observaciones = "";
	private int idPropietario = 0;
	private int idEstado = 1;
	private int idTipo = 1;
	private DireccionDTO direccion = new DireccionDTO();
	private Set<FotoDeInmuebleDTO> fotos = new HashSet<FotoDeInmuebleDTO>();
	
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
	
	public void setCloaca(boolean cloaca) {
		this.cloaca = cloaca;
	}
	
	public boolean tieneCloaca() {
		return cloaca;
	}
	

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	
	

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Set<FotoDeInmuebleDTO> getFotos() {
		return fotos;
	}

	public void setFotos(Set<FotoDeInmuebleDTO> fotos) {
		this.fotos = fotos;
	}

	
	
	public int getIdOrientacion() {
		return idOrientacion;
	}

	public void setIdOrientacion(int idOrientacion) {
		this.idOrientacion = idOrientacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	
	
	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	/**
	 * instanciar un DTO a partir de una instancia de Inmueble
	 * @param inm
	 */
	public InmuebleDTO(Inmueble inm){
		if(inm == null)
			return;
		id = inm.getId();
		fechaDeAlta = inm.getFechaDeAlta();
		precioDeVenta = inm.getPrecioDeVenta();
		if(inm.getOrientacion() != null)
			idOrientacion = inm.getOrientacion().getId();
		longitudDeFrente = inm.getLongitudDeFrente();
		longitudDeFondo = inm.getLongitudDeFondo();
		superficie = inm.getSuperficie();
		propiedadHorizontal = inm.esPropiedadHorizontal();
		antiguedad = inm.getAntiguedad();
		cantidadDeDormitorios = inm.getCantidadDeDormitorios();
		cantidadDeBanos = inm.getCantidadDeBanos();
		garage = inm.tieneGarage();
		patio = inm.tienePatio();
		piscina = inm.tienePiscina();
		aguaCorriente = inm.tieneAguaCorriente();
		telefono = inm.tieneTelefono();
		lavadero = inm.tieneLavadero();
		pavimento = inm.tienePavimento();
		cloaca = inm.tieneCloaca();
		gasNatural = inm.tieneGasNatural();
		observaciones = inm.getObservaciones();

		if(inm.getPropietario() != null)
			idPropietario = inm.getPropietario().getId();
		if(inm.getEstado() != null)
			idEstado  = inm.getEstado().getId();
		if(inm.getTipo()!=null)
			idTipo = inm.getTipo().getId();
		if(inm.getDireccion()!=null)
			direccion = new DireccionDTO(inm.getDireccion());
		
		for(FotoDeInmueble foto : inm.getFotos()){
			fotos.add(new FotoDeInmuebleDTO(foto));
		}
	}
	
	public InmuebleDTO(){		
		
	}

	public void setGasNatural(boolean gasNatural) {
		this.gasNatural = gasNatural;
	}
	
	public boolean tieneGasNatural(){
		return gasNatural;
	}

	
	
}
