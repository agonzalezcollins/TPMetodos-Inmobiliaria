package tpmetodos.datos.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import tpmetodos.dtos.TelefonoDTO;
import tpmetodos.dtos.VendedorDTO;

public class Vendedor {

	private int id = 0;
	private String apellidos="";
	private String nombres="";
	private String usuario="";
	private String contrasena="";
	private String dni="";
	private Date fechaDeNacimiento=new Date();
	private Set<TelefonoDeVendedor> telefonos = new HashSet<TelefonoDeVendedor>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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


	public Set<TelefonoDeVendedor> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDeVendedor> telefonos) {
		this.telefonos = telefonos;
	}
	
	public Vendedor(){
		
	}
	
	public Vendedor(VendedorDTO dto){
		id = dto.getId();
		apellidos = dto.getApellidos();
		nombres = dto.getNombres();
		usuario = dto.getUsuario();
		contrasena = dto.getContrasena();
		dni = dto.getDni();
		fechaDeNacimiento = dto.getFechaDeNacimiento();
		for(TelefonoDTO tel : dto.getTelefonos()){
			telefonos.add(new TelefonoDeVendedor(tel));
		}
	}
}
