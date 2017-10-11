package controllers;

import java.util.ArrayList;
import data.DataElemento;
import data.DataNombreElemento;
import entity.Elemento;
import entity.NombreElemento;
import entity.Persona;

public class CtrlABMCElemento {
	private ArrayList<Elemento> elem;
	private DataElemento data;
	private DataNombreElemento dataN;

	public CtrlABMCElemento()
	{
		elem=new ArrayList<Elemento>();
		data=new DataElemento();
		dataN=new DataNombreElemento();
	}
	
	public void add(Elemento e) throws Exception
	{
		data.add(e);
	}
	
	public void delete(Elemento e) throws Exception
	{
		data.remove(e);
	}
	
	public void update(Elemento e) throws Exception
	{
		this.delete(e);
		this.add(e);
	}
	

	public Elemento getByNombre(Elemento e) throws Exception{
		return this.data.getByNombre(e);
	}
	
	public Elemento getByNombre(String nombre)throws Exception{
		Elemento e=new Elemento();
		e.setNombre(nombre);
		return getByNombre(e);
	}
	
 /*public Elemento getByNombre(Elemento e) 
{
		for (int i=0; i < this.elem.size(); i++){
				if(elem.get(i).getNombre().equalsIgnoreCase(e.getNombre())) 
				{
					return elem.get(i);		
				}
		}
		return null;
 }	*/
 
 public ArrayList<NombreElemento> getNombreE() throws Exception{
		return dataN.getAll();
	}
 
 public ArrayList<Elemento> getAll()throws Exception{
		return data.getAll();
	}
 
}
