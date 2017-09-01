package tpmetodos.dtos;

import tpmetodos.datos.entidades.Direccion;

public class DireccionDTO {

	private int id;
	private int idCalle = 0;
	private String numero = "000";
	private String piso = "";
	private String departamento = "";
	private String barrio = "";
	private int idLocalidad = 1;
	private String calleAlternativa = "";

	public DireccionDTO(Direccion d) {
		id = d.getId();
		if(d.getCalle() != null)
			idCalle = d.getCalle().getId();
		numero = d.getNumero();
		piso = d.getPiso();
		departamento = d.getDepartamento();
		barrio = d.getBarrio();
		if(d.getLocalidad() != null)
			idLocalidad = d.getLocalidad().getId();
		calleAlternativa = d.getCalleAlternativa();
		
	}

	public int getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(int calle) {
		this.idCalle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	public DireccionDTO(){
		
	}

	public String getCalleAlternativa() {
		return calleAlternativa;
	}

	public void setCalleAlternativa(String calleAlternativa) {
		this.calleAlternativa = calleAlternativa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
