package entity;

public class Elemento {
	private int id;
	private String nombre;
	private String hora;
	private String fecha;
	private NombreElemento nombreE;
	
	public NombreElemento getElemento(){
		return nombreE;
	}
	
	public void setElemento(NombreElemento nombreE){
		this.nombreE=nombreE;
	}
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
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
	
}
