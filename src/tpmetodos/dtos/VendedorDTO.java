package tpmetodos.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tpmetodos.datos.entidades.Telefono;
import tpmetodos.datos.entidades.Vendedor;

public class VendedorDTO {

	private int id =0;
	private String apellidos="";
	private String nombres = "";
	private String usuario = "";
	private String contrasena = "";
	private String dni = "";
	private Date fechaDeNacimiento = null;
	private List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public List<TelefonoDTO> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}
	
	/**
	 * crear un DTO a partir de una instancia
	 */
	public VendedorDTO(Vendedor vend){
		id = vend.getId();
		apellidos = vend.getApellidos();
		nombres = vend.getNombres();
		usuario = vend.getUsuario();
		contrasena = vend.getContrasena();
		dni = vend.getDni();
		fechaDeNacimiento=vend.getFechaDeNacimiento();
		telefonos = new ArrayList<TelefonoDTO>();
		for(Telefono t : vend.getTelefonos()){
			telefonos.add(new TelefonoDTO(t));
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VendedorDTO(){
		
	}
}
