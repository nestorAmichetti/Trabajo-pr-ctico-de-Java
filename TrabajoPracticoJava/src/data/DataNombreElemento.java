package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.NombreElemento;


public class DataNombreElemento {
	public ArrayList<NombreElemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<NombreElemento> nombreE= new ArrayList<NombreElemento>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elementos");
			if(rs!=null){
				while(rs.next()){
					NombreElemento ne=new NombreElemento();
					ne.setId(rs.getInt("id"));
					ne.setDescripcion(rs.getString("nombre"));
					nombreE.add(ne);
				}
			}
		} catch (Exception e){
			throw e;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nombreE;
	}
}
