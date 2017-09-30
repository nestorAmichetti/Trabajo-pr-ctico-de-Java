package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import entity.NombreTipoElemento;
import entity.TipoElemento;

public class DataTipoElemento {
	public ArrayList<TipoElemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoE= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elementos t inner join elementos e on t.id=e.id_tipo_elemento");
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
					"insert into tipo_elementos(nombreCorto, cantMaxReservas) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, t.getTipoElemenento().getDescripcion());
			stmt.setInt(2, t.getCantMaxReservas());
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
	
	public void remove(TipoElemento t) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombreCorto from tipo_elementos where nombreCorto=?");
			stmt.setString(1, t.getNombreCorto());
			rs=stmt.executeQuery();
			if(rs!=null){
				if(rs.next()){
					if (rs.getString("nombreCorto").equals(t.getNombreCorto())){
						stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
								"delete from tipo_elementos where nombreCorto=?");
						stmt.setString(1, t.getNombreCorto());
						stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Baja exitosa");
						;
					}			
				} else {
					JOptionPane.showMessageDialog(null, "Error en Baja");
				}
			}
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}
	
	public TipoElemento getByNombre(TipoElemento tipo) throws Exception{
		TipoElemento t=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.id, nombreCorto, cantMaxReservas from tipo_elementos t inner join elementos e on t.id=e.id where nombreCorto=?");
			stmt.setString(1, tipo.getNombreCorto());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				if (rs.getString("dni").equals(tipo.getNombreCorto()))
					
					t=new TipoElemento();
					t.setTipoElemenento(new NombreTipoElemento());
					t.setId(rs.getInt("id"));
					t.setNombreCorto(rs.getString("nombre"));
					t.setCantMaxReservas(rs.getInt("cantMaxReservas"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return t;
	}
	
}
