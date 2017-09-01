package tpmetodos.dtos;

import tpmetodos.datos.entidades.Telefono;

public class TelefonoDTO {

	private String codigoDeArea;
	private String numero;
	private int idTipo;

	public TelefonoDTO(Telefono t) {
		codigoDeArea = t.getCodigoDeArea();
		numero = t.getNumero();
		idTipo = t.getId();
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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public TelefonoDTO(){
		
	}
}
