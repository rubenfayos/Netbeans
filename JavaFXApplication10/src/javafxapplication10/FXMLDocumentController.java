/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication10;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
    private TextField text;
    @FXML
    private ChoiceBox<String> lista1;
    @FXML
    private ComboBox<String> lista2;
    
    ObservableList<String> lista = FXCollections.observableArrayList();
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void añadir(ActionEvent event) {
        
        lista.add(text.getText());
        
        if(check1.isSelected())
            lista1.getItems().add(text.getText());
        if(check2.isSelected())
            lista2.getItems().add(text.getText());
        
        check1.setSelected(false);
        check2.setSelected(false);

        text.clear();
    }
    
}
