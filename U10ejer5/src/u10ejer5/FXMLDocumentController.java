/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package u10ejer5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button convertir;
    @FXML
    private TextField cantidad;
    @FXML
    private ChoiceBox<String> divisa;
    @FXML
    private TextField resultado;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        divisa.getItems().addAll("€", "$", "Ars");
        
    }    

    @FXML
    private void convertir(ActionEvent event) {
        
        int cant = Integer.parseInt(cantidad.getText());
        
        
        
    }
    
}
