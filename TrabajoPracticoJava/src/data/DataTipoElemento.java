package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.TipoElemento;

public class DataTipoElemento {
	public ArrayList<TipoElemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoE= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elementos");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tipo=new TipoElemento();
					tipo.setId(rs.getInt("id"));
					tipo.setNombreCorto(rs.getString("nombreCorto"));
					tipo.setCantMaxReservas(rs.getInt("cantMaxReservas"));					
					tipoE.add(tipo);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return tipoE;
		
	}
		
	public void add(TipoElemento t) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into tipo_elementos(nombre, id) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, t.getNombreCorto());
			stmt.setInt(2, t.getTipoElemenento().getId());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				t.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
