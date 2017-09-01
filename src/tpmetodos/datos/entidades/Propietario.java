package tpmetodos.datos.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Propietario {

	private int id = 1;
	private String apellidos = "Cardona";
	private String nombres = "Ramon";
	private String dni = "24764235";
	private Date fechaDeNacimiento = new Date();
	private Direccion direccion = null;
	private Set<TelefonoDePropietario> telefonos = new HashSet<TelefonoDePropietario>();

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<TelefonoDePropietario> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDePropietario> telefonos) {
		this.telefonos = telefonos;
	}
}
