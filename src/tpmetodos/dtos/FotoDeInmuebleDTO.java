package tpmetodos.dtos;

import tpmetodos.datos.entidades.FotoDeInmueble;

public class FotoDeInmuebleDTO {

	private int id;
	private String descripcion;
	private String path;
	private int id_inmueble;
	
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public FotoDeInmuebleDTO(FotoDeInmueble foto){
		id = foto.getId();
		descripcion = foto.getDescripcion();
		path = foto.getPath();
		if(foto.getInmueble()!=null)
			setId_inmueble(foto.getInmueble().getId());
	}
	
	public FotoDeInmuebleDTO(){
		
	}
	public int getId_inmueble() {
		return id_inmueble;
	}
	public void setId_inmueble(int id_inmueble) {
		this.id_inmueble = id_inmueble;
	}
}
