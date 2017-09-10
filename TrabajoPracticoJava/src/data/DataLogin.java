package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import entity.Persona;

public class DataLogin {
	
		public Persona login(Persona p) throws Exception{
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Persona persona=null;
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
							persona=p;
						}
						
					}
				}else {	
						persona=null;
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
			
			return persona;
			
		}
	
}
