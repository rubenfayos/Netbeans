/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud10entregable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author 1erDAM
 */
public class datos {
    
    private Connection conn;
    private ObservableList<Persona> personas;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ObservableList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ObservableList<Persona> personas) {
        this.personas = personas;
    }
    
    public datos(Connection conn){
        this.conn=conn;
    }
    
     public void insert(Persona p){
        
         try{
	
                PreparedStatement ps = this.conn.prepareStatement(
		"INSERT INTO persona(nombre, apellidos, dni, telefono) VALUES(?, ?, ?, ?)"
		);
                
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getApellidos());
                ps.setString(3, p.getDni());
                ps.setString(4, p.getTelefono());
		
		ps.execute();
								
            }catch (SQLException e){
			e.printStackTrace();
            }
    }
     
    public void update(Persona p){
        
        try{
        
                PreparedStatement ps = this.conn.prepareStatement(
                "UPDATE persona SET nombre=?, apellidos=?, dni=?, telefono=? WHERE id=?"
                );

                ps.setString(1, p.getNombre());
                ps.setString(2, p.getApellidos());
                ps.setString(3, p.getDni());
                ps.setString(4, p.getTelefono());
                ps.setInt(5, p.getId());

                ps.execute();			
				
            }catch (SQLException e){
			e.printStackTrace();
            }
      
    }
    
    public void delete(int id, Alert a, Optional<ButtonType> option){
        
        try{
                PreparedStatement ps = this.conn.prepareStatement(
                "DELETE FROM persona WHERE id=?"
                );

                ps.setInt(1, id);
                
                //Confirmación de borrado
                    
                if (option.get() == ButtonType.OK) {
                    ps.execute();
                } else if (option.get() == ButtonType.CANCEL) {

                }
							
            }catch (SQLException e){
			e.printStackTrace();
            }
          
    }
    
    public ObservableList<Persona> lista(){
        
        try{

                Statement stmt = this.conn.createStatement();
                PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM persona");

                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    Persona p = new Persona(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("DNI"), rs.getString("telefono"));
                    p.setId(rs.getInt("id"));
                    personas.add(p);
                }
							
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        return personas;
        
    }
    
    
}
