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
}
