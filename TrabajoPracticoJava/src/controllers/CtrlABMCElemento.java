package controllers;

import java.util.ArrayList;
import data.DataElemento;
import data.DataNombreElemento;
import entity.Elemento;
import entity.NombreElemento;

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
	
	public void delete(Elemento e)
	{
		this.elem.remove(e);
	}
	
	public void update(Elemento e) throws Exception
	{
		this.delete(e);
		this.add(e);
	}
	
	
	public ArrayList<Elemento> getAll() throws Exception
	{
		return data.getAll();
	}

	
 public Elemento getByNombre(Elemento e) 
{
		for (int i=0; i < this.elem.size(); i++){
				if(elem.get(i).getNombre().equalsIgnoreCase(e.getNombre())) 
				{
					return elem.get(i);		
				}
		}
		return null;
 }	
 
 public ArrayList<NombreElemento> getCategorias() throws Exception{
		return dataN.getAll();
	}
 
}
