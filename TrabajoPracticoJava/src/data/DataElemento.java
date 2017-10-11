package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import entity.Elemento;
import entity.NombreElemento;
import util.AppDataException;

public class DataElemento {
	public ArrayList<Elemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> ele= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elementos e inner join tipo_elementos e on t.id=e.id");
			if(rs!=null){
				while(rs.next()){
					Elemento elemento=new Elemento();
					elemento.setElemento((new NombreElemento()));
					elemento.setId(rs.getInt("id"));
					elemento.setNombre(rs.getString("nombre"));	
					elemento.setFecha(rs.getString("fecha"));
					elemento.setHora(rs.getString("hora"));	
					elemento.getElemento().setDescripcion((rs.getString("detalle")));
					elemento.getElemento().setId((rs.getInt("id")));
					ele.add(elemento);
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
		
		return ele;
		
	}
		
	public void add(Elemento e) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into elementos( nombre, id_tipo_elemento) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, e.getNombre());
			stmt.setInt(2, e.getElemento().getId());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				e.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException ed) {
			throw ed;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ed) {
			ed.printStackTrace();
		}
	}
	
	public void remove(Elemento e) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre from elementos where nombre=?");
			stmt.setString(1, e.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null){
				if(rs.next()){
					if (rs.getString("nombre").equals(e.getNombre())){
						stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
								"delete from elementos where nombre=?");
						stmt.setString(1, e.getNombre());
						stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Baja exitosa");
						;
					}			
				} else {
					JOptionPane.showMessageDialog(null, "Error en Baja");
				}
			}
		} catch (SQLException ed) {
			
			JOptionPane.showMessageDialog(null, "No se puede dar de baja un elemento reservado");
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ed) {
			
			ed.printStackTrace();
		}
				
	}
	
	public Elemento getByNombre(Elemento ele) throws Exception{
		Elemento e=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.id, nombre, id_tipo_elemento from elementos e inner join tipo_elementos t on e.id_tipo_elemento=t.id where nombre=?");
			stmt.setString(1, ele.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				if (rs.getString("nombre").equals(ele.getNombre()))
					
					e=new Elemento();
					e.setElemento((new NombreElemento()));
					e.setId(rs.getInt("id"));
					e.setNombre(rs.getString("nombre"));
					e.getElemento().setId(rs.getInt("id_tipo_elemento"));
					
			}
			
		} catch (Exception ed) {
			throw ed;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException ed) {
				throw ed;
			}
		}
		return e;
	}
	
}