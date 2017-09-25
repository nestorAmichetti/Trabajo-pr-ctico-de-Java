package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.*;

import entity.*;
import util.AppDataException;

public class DataPersona {
	
	public ArrayList<Persona> getAll() throws Exception{
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from personas p inner join categorias c on p.id_categoria=c.id");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));		
					p.getCategoria().setId(rs.getInt("id"));
					p.getCategoria().setDescripcion(rs.getString("categoria"));
					
					pers.add(p);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pers;
		
	}
	
	
	public Persona getByDni(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.id, nombre, apellido, dni, habilitado, id_categoria, categoria from personas p inner join categorias c on p.id_categoria=c.id where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				if (rs.getString("dni").equals(per.getDni()))
					
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("id_categoria"));
					p.getCategoria().setDescripcion(rs.getString("categoria"));
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
		return p;
	}
	
	public void add(Persona p) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into personas(dni, nombre, apellido, habilitado, id_categoria, clave, usuario) values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setInt(5, p.getCategoria().getId());
			stmt.setString(6, p.getclave());
			stmt.setString(7, p.getUsuario());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(Persona p) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String respuesta=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select usuario, clave from personas where usuario=? and clave=?");
			stmt.setString(1, p.getUsuario());
			stmt.setString(2, p.getclave());
			rs=stmt.executeQuery();
			if(rs!=null){
				if(rs.next()){
					if (rs.getString("usuario").equals(p.getUsuario())
					&& rs.getString("clave").equals(p.getclave())){
						stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
								"delete from personas where usuario=?");
						stmt.setString(1, p.getUsuario());
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
	

}