/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package examenrfm2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author 1erDAM
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button insertButton;
    @FXML
    private TextField idText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField catText;
    @FXML
    private TextField precioText;
    @FXML
    private ChoiceBox<String> sedeCB;
    @FXML
    private TextField idTextDelete;
    @FXML
    private Button DeleteButton;
    @FXML
    private TextField precioMin;
    @FXML
    private TextField precioMax;
    @FXML
    private Button ListarButton;
    
    private JuegoModel jm;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn catColumn;
    @FXML
    private TableColumn precioColumn;
    @FXML
    private TableColumn sedeColumn;
    
    private ObservableList<Juego> listaJuegos;
    @FXML
    private TableView<Juego> tabla;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> sedes= FXCollections.observableArrayList();
        
        sedes.add("Valencia");
        sedes.add("Castellon");
        sedes.add("Alicante");
        
        sedeCB.setItems(sedes);
        
        this.jm = new JuegoModel();
        this.jm.getConexion();
        
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        catColumn.setCellValueFactory(new PropertyValueFactory("categoria"));
        precioColumn.setCellValueFactory(new PropertyValueFactory("precio"));
        sedeColumn.setCellValueFactory(new PropertyValueFactory("sede"));
        
         
    }    

    @FXML
    private void Insertar(ActionEvent event) {
        
        String sede = "";
        
        if(sedeCB.getSelectionModel().getSelectedItem().equals("Valencia"))
            sede="V";
        else if(sedeCB.getSelectionModel().getSelectedItem().equals("Castellon"))
            sede="C";
        else if(sedeCB.getSelectionModel().getSelectedItem().equals("Alicante"))
            sede="A";
        
        Juego j = new Juego(nombreText.getText(), catText.getText(), sede, Double.parseDouble(precioText.getText()), Integer.parseInt(idText.getText()));
        
        this.jm.insertarJuego(j);
        
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        
        Juego j = new Juego();
        
        j.setId(Integer.parseInt(idTextDelete.getText()));
        
        this.jm.borrarJuego(j);
        
    }

    @FXML
    private void Listar(ActionEvent event) {
        
        this.listaJuegos=this.jm.getJuegos(Double.parseDouble(precioMin.getText()), Double.parseDouble(precioMax.getText()));
        this.tabla.setItems(listaJuegos);
        
    }
    
}
