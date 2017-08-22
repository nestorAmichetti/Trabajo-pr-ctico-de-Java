package entity;


public class TipoElemento {
	private int id;
	private String nombreCorto;
	private int cantMaxReservas;
	private NombreTipoElemento nombreTipo;
	
	public NombreTipoElemento getTipoElemenento(){
		return nombreTipo;
	}
	
	public void setTipoElemenento(NombreTipoElemento nombreTipo){
		this.nombreTipo=nombreTipo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public int getCantMaxReservas() {
		return cantMaxReservas;
	}
	public void setCantMaxReservas(int cantMaxReservas) {
		this.cantMaxReservas = cantMaxReservas;
	}
	

}
