package tpmetodos.datos.entidades;

public class TipoDeInmueble {

	private int id;
	private String descripcion;

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public String toString(){
		return descripcion;
	}
}
