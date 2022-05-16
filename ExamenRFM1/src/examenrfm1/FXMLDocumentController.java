/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package examenrfm1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField edadText;
    @FXML
    private ToggleGroup sexo;
    @FXML
    private ChoiceBox<String> provinciaCB;
    @FXML
    private RadioButton mujer;
    @FXML
    private RadioButton hombre;
    
    int edad;
    String nombre;
    String provincia;
    String s;
    
    int hombres = 3;
    int mujeres = 2;
    int niños = 3;

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> provincias= FXCollections.observableArrayList();
        
        provincias.add("Valencia");
        provincias.add("Castellon");
        provincias.add("Alicante");
        
        provinciaCB.setItems(provincias);
        
    }    

    @FXML
    private void registrar(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.ERROR, "Lo sentimos, no hay espacio disponible o los datos son incorrectos");
        
        nombre = nombreText.getText();
        edad = Integer.parseInt(edadText.getText());
        provincia=provinciaCB.getSelectionModel().getSelectedItem();
        
        if(mujer.isSelected()){     
            if(edad >= 20 && edad <= 40){
                if(provincia.equals("Castellon")){
                    if(mujeres > 0)
                        mujeres--;
                    else
                        a.show();
                }else
                    a.show();
            }
            else if(edad >= 3 && edad <= 16){
                if(provincia.equals("Alicante")){
                    if(niños>0){
                        niños--;
                    }else
                        a.show();
                }else
                    a.show();
            }else
                a.show();      
        }else if(hombre.isSelected()){
            if(edad >= 15 && edad <= 30){
                if(provincia.equals("Valencia")){
                    if(hombres > 0)
                        hombres--;
                    else
                        a.show();
                }else
                        a.show();
            }
            else if(edad >= 3 && edad <= 16){
                if(provincia.equals("Alicante")){
                    if(niños>0)
                        niños--;
                    else
                        a.show();
                }else
                    a.show();
        }else
            a.show();
        
        nombreText.clear();
        edadText.clear();
        
        }
    }
}

