package tpmetodos.datos.entidades;

import tpmetodos.dtos.FotoDeInmuebleDTO;

public class FotoDeInmueble {

	private int id = 0;
	private String descripcion = "";
	private byte[] foto; // no se usa, no se mapea.
	private String path = "";
	private Inmueble inmueble;

	public FotoDeInmueble(FotoDeInmuebleDTO fdto) {
		id = fdto.getId();
		descripcion = fdto.getDescripcion();
		path = fdto.getPath();
	}

	public FotoDeInmueble(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	
}
