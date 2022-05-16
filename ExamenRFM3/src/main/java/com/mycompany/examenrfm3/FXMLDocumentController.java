/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tableviewexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Salva
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private TableView<Animal> animalesTableView;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField especieTextField;
    @FXML
    private Spinner<Integer> edadSpinner;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn edadColumn;
    @FXML
    private TableColumn especieColumn;
    
    private ObservableList<Animal> animales;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Animal a = new Animal(nombreTextField.getText(), especieTextField.getText(), this.edadSpinner.getValue());
        
        if(!this.animales.contains(a)) {
            this.animales.add(a);
            this.animalesTableView.setItems(this.animales);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("El animal ya existe");
            alert.setHeaderText("Error en animales");
            alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializamos colección animales (con un arraylist vacio).
        animales = FXCollections.observableArrayList();
        
        //Inicializamos el spinner con número del 1 al 100.
        SpinnerValueFactory<Integer> valueFactoryInteger = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1, 1);
        this.edadSpinner.setValueFactory(valueFactoryInteger);
        
        //Vinculamos columnas a atributos de la clase animal
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.especieColumn.setCellValueFactory(new PropertyValueFactory("especie"));
        this.edadColumn.setCellValueFactory(new PropertyValueFactory("edad"));
       
    }    

    @FXML
    private void animalTablViewMouseClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Animal animalSeleccionado = this.animalesTableView.getSelectionModel().getSelectedItem();
            System.out.println("Doble click!");
            System.out.println(animalSeleccionado.getNombre());
        }
    }
    
}
