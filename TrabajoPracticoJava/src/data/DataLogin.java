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
			
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select usuario, clave from personas where usuario=? and clave=?");
				stmt.setString(1, p.getUsuario());
				stmt.setString(2, p.getclave());
				rs=stmt.executeQuery();
				if(rs!=null){
					while(rs.next()){
						if (rs.getString("usuario").equals(p.getUsuario())
						&& rs.getString("clave").equals(p.getclave())){
							JOptionPane.showConfirmDialog(null, "Bienvenido");
							break;
						}
						
					}
				}else {	JOptionPane.showConfirmDialog(null, "Error en nombre de usuario y/o clave");
					}
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Error en nombre de usuario y/o clave");
			}
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return p;
			
		}
	
}
