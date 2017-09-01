package tpmetodos.datos.entidades;

public class Calle {
	private int id = 0;
	private String nombre = "";
	private Localidad localidad = new Localidad();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	@Override
	public String toString() {
		return "Calle [id=" + id + ", nombre=" + nombre + ", localidad="
				+ localidad + "]";
	}
	
	
	
}
