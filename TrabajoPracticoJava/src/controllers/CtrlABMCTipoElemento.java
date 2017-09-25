package controllers;

import java.util.ArrayList;

import entity.NombreTipoElemento;
import entity.TipoElemento;
import data.DataNombreTipoElemento;
import data.DataTipoElemento;

public class CtrlABMCTipoElemento {
	
	private ArrayList<TipoElemento> tipoE;
	private DataTipoElemento data;
	private DataNombreTipoElemento dataN;
	
	public CtrlABMCTipoElemento()
	{
		tipoE=new ArrayList<TipoElemento>();
		data=new DataTipoElemento();
		dataN=new DataNombreTipoElemento();
	}
	
	public void add(TipoElemento t) throws Exception
	{
		data.add(t);
	}
	
	public void delete(TipoElemento t) throws Exception
	{
		data.remove(t);
	}
	
	public void update(TipoElemento t) throws Exception
	{
		this.delete(t);
		this.add(t);
	}
	
	
	public ArrayList<TipoElemento> getAll() throws Exception
	{
		return data.getAll();
	}
	
	public TipoElemento getByNombre(TipoElemento t)
	{
		for (int i=0; i < this.tipoE.size(); i++){
			if(tipoE.get(i).getNombreCorto().equalsIgnoreCase(t.getNombreCorto())) 
			{
				return tipoE.get(i);		
			}
		}
		return null;
	}
	
	public ArrayList<NombreTipoElemento> getNombreTipoE() throws Exception{
		return dataN.getAll();
	}
}



