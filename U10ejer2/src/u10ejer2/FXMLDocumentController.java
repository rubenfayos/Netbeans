/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package u10ejer2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    ArrayList<vehiculo> vehiculos = new ArrayList<vehiculo>();
    
    @FXML
    private Label label;
    @FXML
    private Button generar;
    @FXML
    private TextField text_color;
    @FXML
    private TextField text_puertas;
    @FXML
    private TextField text_velmax;
    @FXML
    private Label tipo;
    @FXML
    private TextField text_tipo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generar(ActionEvent event) {
        
        vehiculos.add(new vehiculo(Integer.parseInt(text_puertas.getText()), Integer.parseInt(text_velmax.getText()), text_tipo.getText(), text_color.getText()));
        
        for(vehiculo v : vehiculos){
            System.out.println("tipo: " + v.getTipo() + ", color: " + v.getColor() + ", puertas: " + v.getPuertas() + ", vel max: " + v.getVelmax());
        }
    }
    
}
