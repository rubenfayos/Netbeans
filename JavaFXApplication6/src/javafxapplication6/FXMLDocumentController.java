/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Optional;


/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField text;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Val_inicio(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("El texto tiene que comenzar por a");
        a.setHeaderText("Alerta");
        
        if(!text.getText(0, 1).equalsIgnoreCase("a")){
            a.show();
        }
            
    }

    @FXML
    private void Val_length(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("La longitud del texto tiene que ser menor de 11");
        a.setHeaderText("ERROR");
        
        if(text.getText().length() > 10)
            a.show();
    }

    @FXML
    private void cont(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("La palabra tiene " + text.getText().length() + " letras.");
        a.setHeaderText("Longitud");
        
        a.show();
        
    }

    @FXML
    private void clean(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("¿Quieres borrar el texto?");
        Optional<ButtonType> option = a.showAndWait();
        
      if (option.get() == ButtonType.OK) {
        text.clear();
      } else if (option.get() == ButtonType.CANCEL) {
           
      }
        
    }  
}
