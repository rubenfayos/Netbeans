/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package u10ejer4;

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
    private Button validar;
    @FXML
    private TextField texto1;
    @FXML
    private TextField num1;
    @FXML
    private TextField bool1;
    @FXML
    private TextField texto2;
    @FXML
    private TextField num2;
    @FXML
    private TextField bool2;

    private boolean comp = true;
    
    String str;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void validar(ActionEvent event) {
        
        this.comp=true;
        
         str=num1.getText();
         comprobarNum(str);
         
         str=num2.getText();
         comprobarNum(str);
         
         str=bool1.getText();
         comprobarBool(str);
         
         str=bool2.getText();
         comprobarBool(str);
         
         System.out.println(comp);
        
    }
    
    private void comprobarText(String str){
        
        if(str.matches(""))
            this.comp=false;
    }
    
    private void comprobarNum(String str){
        
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                this.comp=false;
            }
        }
        
    }
    
    private void comprobarBool(String str){
        
        if(!str.equals("true") || !str.equals("false"))
            this.comp = false;
        
    }
    
}
