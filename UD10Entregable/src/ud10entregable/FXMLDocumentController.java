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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    //Conexión con la bdd
    private controlador c;
    
    //Clase para el manejo de datos   
    private datos d;
    
    //Table column
    private ObservableList<Persona> personas;
    @FXML
    private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona,Integer> table_id;
    @FXML
    private TableColumn<Persona, String> table_nombre;
    @FXML
    private TableColumn<Persona, String> table_apellidos;
    @FXML
    private TableColumn<Persona, String> table_dni;
    @FXML
    private TableColumn<Persona, String> table_telefono;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.table_id.setCellValueFactory(new PropertyValueFactory("id"));
        this.table_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.table_apellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.table_dni.setCellValueFactory(new PropertyValueFactory("dni"));
        this.table_telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        
        c = new controlador();
        this.d = new datos(c.conexion());
   
    }    

    @FXML
    private void save_button(ActionEvent event) {
        
        Persona p = new Persona(nombre_save.getText(), apellidos_save.getText(), dni_save.getText(), telefono_save.getText());
        
        d.insert(p);
        
        clear();
        
    }

    @FXML
    private void modify_button(ActionEvent event) {
        
        Persona p = new Persona(nombre_modify.getText(), apellidos_modify.getText(), dni_modify.getText(), telefono_modify.getText());
        p.setId(Integer.parseInt(id_modify.getText()));
        d.update(p);
        clear();
    }

    @FXML
    private void delete_button(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("¿Quieres borrar el usuario?");
        Optional<ButtonType> option = a.showAndWait();
        
        d.delete(Integer.parseInt(id_delete.getText()), a, option);
        
        clear();
        
    }
    
    @FXML
    private void list_button(ActionEvent event) {
        
        personas=d.lista();
        
        this.tablaPersonas.setItems(personas);
        
        clear();
    }
    
    private void clear(){
        
        //Método de borrado de campos
        
        nombre_save.clear();
        apellidos_save.clear();
        dni_save.clear();
        telefono_save.clear();
        
        nombre_modify.clear();
        apellidos_modify.clear();
        dni_modify.clear();
        telefono_modify.clear();
        id_modify.clear();
        
        id_delete.clear();
        
    } 

}
