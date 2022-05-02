/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button uno;
    @FXML
    private Button dos;
    @FXML
    private Button tres;
    @FXML
    private Button cuatro;
    @FXML
    private Button cinco;
    @FXML
    private Button seis;
    @FXML
    private Button siete;
    @FXML
    private Button ocho;
    @FXML
    private Button nueve;
    @FXML
    private Label numbers;
    @FXML
    private Button cero;
    @FXML
    private Button Resultado;
    @FXML
    private Button sum;
    @FXML
    private Button rest;
    @FXML
    private Button mult;
    @FXML
    private Button div;
    @FXML
    private Label numbers1;
    
    int num1=0;
    int num2=0;
    int opcion=0;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uno(ActionEvent event) {
        
        numbers.setText(numbers.getText()+1);
        
    }

    @FXML
    private void dos(ActionEvent event) {
        
        numbers.setText(numbers.getText()+2);
        
    }

    @FXML
    private void tres(ActionEvent event) {
        
        numbers.setText(numbers.getText()+3);
        
    }

    @FXML
    private void cuatro(ActionEvent event) {
        
        numbers.setText(numbers.getText()+4);
        
    }

    @FXML
    private void cinco(ActionEvent event) {
        
        numbers.setText(numbers.getText()+5);
        
    }

    @FXML
    private void seis(ActionEvent event) {
        
        numbers.setText(numbers.getText()+6);
        
    }

    @FXML
    private void siete(ActionEvent event) {
        
        numbers.setText(numbers.getText()+7);
        
    }

    @FXML
    private void ocho(ActionEvent event) {
        
        numbers.setText(numbers.getText()+8);
        
    }

    @FXML
    private void nueve(ActionEvent event) {
        
        numbers.setText(numbers.getText()+9);
        
    }

    @FXML
    private void cero(ActionEvent event) {
        
        numbers.setText(numbers.getText()+0);
        
    }

    @FXML
    private void resultado(ActionEvent event) {
        
        num2=Integer.parseInt(numbers.getText());
        
        switch(opcion){
            case 1: num1+=num2;
                numbers.setText(String.valueOf(num1));
            case 2: num1=num1-num2;
                numbers.setText(String.valueOf(num1));
            case 3: num1=num1*num2;
                numbers.setText(String.valueOf(num1));
            case 4: num1=num1/num2;
                numbers.setText(String.valueOf(num1));
        }
        
    }

    @FXML
    private void sum(ActionEvent event) {
        
       almacenar();
       opcion = 1;
        
    }

    @FXML
    private void rest(ActionEvent event) {
        
        almacenar();
       opcion = 2;
      
        
    }
      
    @FXML
    private void mult(ActionEvent event) {
        
       almacenar();
       opcion = 3;
       
    }

    @FXML
    private void div(ActionEvent event) {
        
       almacenar();
       opcion = 4;
        
    }
    
    private void almacenar(){
        
      if(this.num1==0){
          this.num1=Integer.parseInt(numbers.getText());
          numbers.setText("");
          numbers1.setText(String.valueOf(num1));
      }else{
          num2=Integer.parseInt(numbers.getText());
          numbers.setText("");
          numbers1.setText(String.valueOf(num1));
      } 
    
    }
    
}
