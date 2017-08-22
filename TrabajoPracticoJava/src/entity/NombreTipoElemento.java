package entity;

public class NombreTipoElemento {
	private int id;
	private String TipoElemento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return TipoElemento;
	}
	public void setDescripcion(String descripcion) {
		this.TipoElemento = descripcion;
	}
	
	@Override
	public String toString(){
		return this.getDescripcion();
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof NombreTipoElemento && ((NombreTipoElemento)o).getId()==this.getId());
	}
	
	@Override
	public int hashCode(){
		return ((Integer)this.getId()).hashCode();
	}

}

