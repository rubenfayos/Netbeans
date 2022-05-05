/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ud10entregable;

import java.sql.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField nombre_save;
    @FXML
    private TextField apellidos_save;
    @FXML
    private TextField dni_save;
    @FXML
    private TextField telefono_save;
    @FXML
    private Button save_button;
    @FXML
    private TextField nombre_modify;
    @FXML
    private TextField apellidos_modify;
    @FXML
    private TextField dni_modify;
    @FXML
    private TextField telefono_modify;
    @FXML
    private TextField id_modify;
    @FXML
    private Button modify_button;
    @FXML
    private Button delete_button;
    @FXML
    private Button list_button;
    @FXML
    private TextField id_delete;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save_button(ActionEvent event) {
        
        try{
    
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/personas", "root", ""
					);
	
			PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO persona(nombre, apellidos, dni, telefono) VALUES(?, ?, ?, ?)"
				);
                        
		ps.setString(1, nombre_save.getText());
		ps.setString(2, apellidos_save.getText());
		ps.setString(3, dni_save.getText());
                ps.setString(4, telefono_save.getText());
		
		ps.execute();
	
			
				conn.close();
					
				
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        nombre_save.clear();
        apellidos_save.clear();
        dni_save.clear();
        telefono_save.clear();
        
    }

    @FXML
    private void modify_button(ActionEvent event) {
        
        try{
        
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                            Connection conn = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/personas", "root", ""
                                            );

                            PreparedStatement ps = conn.prepareStatement(
                                    "UPDATE persona SET nombre=?, apellidos=?, dni=?, telefono=? WHERE id=?"
                                    );

                    ps.setString(1, nombre_modify.getText());
                    ps.setString(2, apellidos_modify.getText());
                    ps.setString(3, dni_modify.getText());
                    ps.setString(4, telefono_modify.getText());
                    ps.setString(5, id_modify.getText());

                    ps.execute();


                                 conn.close();
					
				
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        nombre_modify.clear();
        apellidos_modify.clear();
        dni_modify.clear();
        telefono_modify.clear();
        id_modify.clear();
        
        
    }

    @FXML
    private void delete_button(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("¿Quieres borrar el usuario?");
        Optional<ButtonType> option = a.showAndWait();
        
        
        try{
        
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                            Connection conn = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/personas", "root", ""
                                            );

                            PreparedStatement ps = conn.prepareStatement(
                                    "DELETE FROM persona WHERE id=?"
                                    );

                    ps.setString(1, id_delete.getText());
                    
                    if (option.get() == ButtonType.OK) {
                        ps.execute();
                    } else if (option.get() == ButtonType.CANCEL) {
           
                    }

                                 conn.close();
					
				
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        id_delete.clear();
        
    }

    @FXML
    private void list(ActionEvent event) {
        
        String salida = "";
        
        try{
           
        
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                            Connection conn = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/personas", "root", ""
                                            );

                        Statement stmt = conn.createStatement();
                            PreparedStatement ps = conn.prepareStatement(
                                            "SELECT * FROM persona");

                            ResultSet rs = ps.executeQuery();

                            while(rs.next()) {
                                    salida+="id: ";
                                    salida+= rs.getString("id");
                                    salida+=", nombre: ";
                                    salida+= rs.getString("nombre");
                                    salida+=", apellidos: ";
                                    salida+= rs.getString("apellidos");
                                    salida+=", dni: ";
                                    salida+= rs.getString("dni");
                                    salida+=", telefono: ";
                                    salida+= rs.getString("telefono");
                                    salida+="\n";

                            }


                                 conn.close();
					
				
		}catch (SQLException e){
			e.printStackTrace();
		}
        
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(salida);
        a.setHeaderText("Personas");
        
        a.show();
        
        
    }
    
}
