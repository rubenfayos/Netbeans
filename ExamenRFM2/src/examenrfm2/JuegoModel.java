package examenrfm2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JuegoModel extends DBUtil {

	public ObservableList<Juego> getJuegos(double min, double max) {
		
		ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();
		
		try {
			//Introduce la consulta SQL.
			String sql = "SELECT * FROM examen_programacion.juegos WHERE precio BETWEEN ? AND ?";
			PreparedStatement stmt = this.getConexion().prepareStatement(sql);
                        
                        stmt.setDouble(1, min);
                        stmt.setDouble(2, max);
                        
                        
			ResultSet rs = stmt.executeQuery();  
		
			while(rs.next()) {
                            Juego j = new Juego(rs.getString(2), rs.getString(3), rs.getString(5), rs.getDouble(4), rs.getInt(1));
                            listaJuegos.add(j);
				
			}
			
			return listaJuegos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally {
			//Cerramos conexi�n
			this.cerrarConexion();
		}
	}
	
	public boolean insertarJuego(Juego j) {
		Boolean resultado = false;
		
		try {
			// Introduce la sentencia de inserci�n, por ejemplo:
			// INSERT INTO prueba.alumnos (id, nombre, edad, nacionalidad) VALUES (?, ?, ?, ?)
			String insertSql = "insert into examen_programacion.juegos (id, nombre, categoria, precio, sede) values (?,?,?,?,?)";
				
			PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
                        
			
			//Asigna los valores a la sentencia de inserci�n
                        stmt.setInt(1, j.getId());
                        stmt.setString(2, j.getNombre());
                        stmt.setString(3, j.getCategoria());
                        stmt.setDouble(4, j.getPrecio());
                        stmt.setString(5, j.getSede());
                        
			stmt.execute();
			resultado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexi�n
			this.cerrarConexion();
			return resultado;
		}
	}
	
	public boolean borrarJuego(Juego j) {
		Boolean resultado = false;
		
		try {
			// Introduce la sentencia de inserci�n, por ejemplo:
			// DELETE FROM prueba.alumnos WHERE id = ?; 
			String deleteSql = "DELETE FROM examen_programacion.juegos WHERE id = ?";
				
			PreparedStatement stmt = this.getConexion().prepareStatement(deleteSql);
			
			//Asigna los valores a la sentencia de inserci�n
                        
                        stmt.setInt(1, j.getId());
			
			stmt.execute();
			resultado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexi�n
			this.cerrarConexion();
			return resultado;
		}
	}
}
