package tpmetodos.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import tpmetodos.datos.entidades.Cliente;
import tpmetodos.datos.entidades.Direccion;
import tpmetodos.datos.entidades.TelefonoDeCliente;

/**
 * CLase Data Transfer Object del CLiente 
 * 
 * @author Agu
 *
 */
public class ClienteDTO {

	private int idCliente;
	private String apellidos;
	private String nombres;
	private String dni;
	private Date fechaDeNacimiento;
	private String email;
	private Direccion direccion;
	private Set<TelefonoDTO> telefonos = new HashSet<TelefonoDTO>();

	/**
	 * Contructor:
	 * Instanciar un DTO Cliente
	 * 
	 */
	public ClienteDTO(){
		this.idCliente = 0;
		this.apellidos = null;
		this.direccion = null;
		this.dni = null;
		this.email = null;
		this.nombres = null;
		this.fechaDeNacimiento =null;
	}
	/**
	 * Constructor:
	 * Instanciar un DTO Cliente en base a un objeto Cliente.
	 * 
	 * @param cliente
	 */
	public ClienteDTO(Cliente cliente) {
		this.idCliente = cliente.getId();
		this.apellidos = cliente.getApellidos();
		this.direccion = cliente.getDireccion();
		this.dni = cliente.getDni();
		this.email = cliente.getEmail();
		this.nombres = cliente.getNombres();
		this.fechaDeNacimiento = cliente.getFechaDeNacimiento();
		
		for(TelefonoDeCliente tcliente : cliente.getTelefonos()){
			TelefonoDTO telefono = new TelefonoDTO();
			telefono.setCodigoDeArea(tcliente.getCodigoDeArea());
			telefono.setIdTipo(tcliente.getTipo().getId());
			telefono.setNumero(tcliente.getNumero());
			this.telefonos.add(telefono);
			//this.telefonos.add(new TelefonoDTO(tcliente));
		}
		
	}

	// GETTERS Y SETTERS
	
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

	public Set<TelefonoDTO> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}

	public int getId() {
		return this.idCliente;
	}
	
	public void setId(int id) {
		this.idCliente = id;
	}
	
}
