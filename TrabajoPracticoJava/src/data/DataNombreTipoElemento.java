package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.NombreTipoElemento;


public class DataNombreTipoElemento {
	public ArrayList<NombreTipoElemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<NombreTipoElemento> nombreTipo= new ArrayList<NombreTipoElemento>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elementos");
			if(rs!=null){
				while(rs.next()){
					NombreTipoElemento c=new NombreTipoElemento();
					c.setId(rs.getInt("id"));
					c.setDescripcion(rs.getString("nombreCorto"));
					nombreTipo.add(c);
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
		
		return nombreTipo;
	}
}
