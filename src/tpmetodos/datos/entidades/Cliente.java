package tpmetodos.datos.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import tpmetodos.dtos.ClienteDTO;
import tpmetodos.dtos.TelefonoDTO;

public class Cliente {

	private int id;
	private String apellidos;
	private String nombres;
	private String dni;
	private Date fechaDeNacimiento;
	private String email;
	private Direccion direccion;
	private Set<TelefonoDeCliente> telefonos = new HashSet<TelefonoDeCliente>();

	/**
	 * Contructor
	 * @param cliente
	 */
	public Cliente(ClienteDTO cliente) {
		
		this.id=cliente.getId();
		this.apellidos = cliente.getApellidos();
		this.nombres = cliente.getNombres();
		this.dni = cliente.getDni();
		this.fechaDeNacimiento = cliente.getFechaDeNacimiento();
		this.email = cliente.getEmail();
		this.direccion = cliente.getDireccion();
		
		for(TelefonoDTO tcliente : cliente.getTelefonos()){
			TelefonoDeCliente telefono = new TelefonoDeCliente();
			telefono.setCodigoDeArea(tcliente.getCodigoDeArea());
			// TODO TIPO TELEFONO
			telefono.setNumero(tcliente.getNumero());
			this.telefonos.add(telefono);
		}
	}

	/**
	 * Contructor por Defecto
	 */
	public Cliente(){
		
	}
			
	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<TelefonoDeCliente> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDeCliente> telefonos) {
		this.telefonos = telefonos;
	}
}
