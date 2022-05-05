/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package u10ejer1;

import java.util.ArrayList;
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
    
    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    @FXML
    private TextField text;
    @FXML
    private Button terminar;
    @FXML
    private Label total;
    @FXML
    private Label media;
    @FXML
    private Label max;
    @FXML
    private Label min;
    
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
        
        nums.add(Integer.parseInt(text.getText()));
        text.clear();
        
    }

    @FXML
    private void terminar(ActionEvent event) {
        
        int maximo=0;
        
        int tot = 0;
        
        for(int num : nums){
            
            tot += num;
            
            if(num > maximo)
                maximo=num;
        }
        
        int minimo = maximo;
        
        for(int num : nums){
            
            if(num < minimo)
              minimo=num;  
           
        }
        
        total.setText(String.valueOf(tot));
        
        media.setText(String.valueOf(tot/nums.size()));
        
        max.setText(String.valueOf(maximo));
        
        min.setText(String.valueOf(minimo));
        
    }
    
}
