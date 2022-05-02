/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication5;

import java.net.URL;
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
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField text_valor1;
    @FXML
    private TextField text_valor2;
    @FXML
    private TextField text_resultado;
    @FXML
    private Button button_rest;
    @FXML
    private Button button_Mult;
    @FXML
    private Button button_dividir;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sum(ActionEvent event) {
        int res = Integer.parseInt(text_valor1.getText()) + Integer.parseInt(text_valor2.getText());
        String s = String.valueOf(res);
        text_resultado.setText(s);
    }

    @FXML
    private void rest(ActionEvent event) {
        int res = Integer.parseInt(text_valor1.getText()) - Integer.parseInt(text_valor2.getText());
        String s = String.valueOf(res);
        text_resultado.setText(s);
    }

    @FXML
    private void mult(ActionEvent event) {
        float res = Integer.parseInt(text_valor1.getText()) * Integer.parseInt(text_valor2.getText());
        String s = String.valueOf(res);
        text_resultado.setText(s);
    }

    @FXML
    private void div(ActionEvent event) {
        float res = Integer.parseInt(text_valor1.getText()) / Integer.parseInt(text_valor2.getText());
        String s = String.valueOf(res);
        text_resultado.setText(s);
    }
    
}
