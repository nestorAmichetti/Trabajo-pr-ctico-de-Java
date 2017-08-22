package controllers;

import java.util.ArrayList;

import data.DataCategoria;
import data.DataLogin;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;

public class CtrlABMCPersona {

	private DataPersona dataPer;
	private DataCategoria dataCat;
	private DataLogin dataLog; 
	
	private ArrayList<Persona> pers;
	
	public CtrlABMCPersona(){
		
		dataPer=new DataPersona();
		dataCat=new DataCategoria();
		dataLog=new DataLogin();
	}
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		this.pers.remove(p);
	}
	
	public void update(Persona p)throws Exception{
		this.delete(p);
		this.add(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
		//return this.getByDni(p.getDni());
	}
	
	public Persona getByDni(String dni)throws Exception{
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
	public Persona getByNombreApellido(Persona p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; 
		
	}
	
	public ArrayList<Persona> getAll()throws Exception{
		return dataPer.getAll();
	}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		return dataCat.getAll();
	}
	
	public Persona validar(Persona p)throws Exception{
		return dataLog.login(p);
	}
}
