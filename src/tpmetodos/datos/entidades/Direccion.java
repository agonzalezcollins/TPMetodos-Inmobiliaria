package tpmetodos.datos.entidades;

import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.dtos.DireccionDTO;

public class Direccion {

	private int id;
	private Calle calle;
	private String numero;
	private String piso;
	private String departamento;
	private String barrio;
	private Localidad localidad;
	private String calleAlternativa = "";
	
	public Direccion(){
		
	}
	
	public Direccion(DireccionDTO dto) {
		id = dto.getId();
		calle = MiscelaneoDAO.getCalleById(dto.getIdCalle());
		numero = dto.getNumero();
		piso = dto.getPiso();
		departamento = dto.getDepartamento();
		barrio = dto.getBarrio();
		localidad = MiscelaneoDAO.getLocalidadById(dto.getIdLocalidad());
		calleAlternativa = dto.getCalleAlternativa();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
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

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getCalleAlternativa() {
		return calleAlternativa;
	}

	public void setCalleAlternativa(String calleAlternativa) {
		this.calleAlternativa = calleAlternativa;
	}
}