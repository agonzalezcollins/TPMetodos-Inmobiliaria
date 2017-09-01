package tpmetodos.datos.entidades;

import tpmetodos.datos.daos.MiscelaneoDAO;
import tpmetodos.dtos.TelefonoDTO;

public class Telefono {

	private int id;
	private String codigoDeArea;
	private String numero;
	private TipoDeTelefono tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoDeArea() {
		return codigoDeArea;
	}

	public void setCodigoDeArea(String codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoDeTelefono getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTelefono tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Constructor:
	 * 
	 */
	public Telefono(){
		
	}
	
	/**
	 * Constructor:
	 * Cargar un telefono a partir de un DTO Telefono.
	 * 
	 * @param dto
	 */
	public Telefono(TelefonoDTO dto){
		codigoDeArea = dto.getCodigoDeArea();
		numero = dto.getNumero();
		tipo = MiscelaneoDAO.getTipoDeTelefonoById(dto.getIdTipo());
		
	}
}
