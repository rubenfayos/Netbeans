/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud10entregable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controlador {
    
    private Connection conn;
    
    public Connection conexion(){
        
        try{
    
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/personas", "root", ""
					);		
				
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        return this.conn;
          
    }
    
    public controlador(){
        
    }
    
    public void crearbdd(){
        
        try{
        
        PreparedStatement ps = this.conn.prepareStatement(
                
            "DROP DATABASE IF EXISTS personas;\n" +
            "CREATE DATABASE personas;\n" +
            "USE personas;\n" +
            "\n" +
            "CREATE TABLE persona(id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(15), apellidos VARCHAR(30), DNI VARCHAR(9), telefono VARCHAR(9));\n" +
            "INSERT INTO persona(nombre, apellidos, dni, telefono) VALUES(\"Rubén\", \"Fayos Medie\", \"2131232A\", \"213123121\");"
            );
        
        ps.execute();
        
        }catch (SQLException e){
            e.printStackTrace();
        }   
    }
    
   
    
}
