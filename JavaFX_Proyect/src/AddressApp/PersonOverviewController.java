/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import AddressApp.AddressAPP;
import AddressApp.model.Person;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PersonOverviewController implements Initializable {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nombre_column;
    @FXML
    private TableColumn<Person, String> apellidos_column;
    
    @FXML
    private Label nombre_label;
    @FXML
    private Label apellidos_label;
    @FXML
    private Label calle_label;
    @FXML
    private Label cp_label;
    @FXML
    private Label ciudad_label;
    @FXML
    private Label fecha_nacimiento_label;
            
    private AddressAPP address_app;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombre_column.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidos_column.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        
        showPersonDetails(null);
        
        personTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> showPersonDetails(newValue));
    }
    
    public void setAddressApp(AddressAPP addressApp){
        this.address_app = addressApp;
        
        personTable.setItems(address_app.getPersonData());
    }
    
    public PersonOverviewController(){
        
    }
    
    private void showPersonDetails(Person person){
        if (person != null) {
            nombre_label.setText(person.getNombre());
            apellidos_label.setText(person.getApellidos());
            calle_label.setText(person.getCalle());
            cp_label.setText(person.getCp());
            ciudad_label.setText(person.getCiudad());
            fecha_nacimiento_label.setText(DateUtil.format(person.getFecha_nacimiento()));
        } else {
            nombre_label.setText("");
            apellidos_label.setText("");
            calle_label.setText("");
            cp_label.setText("");
            ciudad_label.setText("");
            fecha_nacimiento_label.setText("");
        }
    }
    
    @FXML
    private void deletePerson(){
        Alert alert;
        int selected_index = personTable.getSelectionModel().getSelectedIndex();
        if (selected_index != -1){
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Borrado");
            alert.setHeaderText("Esta acción no es reversible");
            alert.setContentText("¿Seguro que quieres eliminar a esta persona?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                personTable.getItems().remove(selected_index);
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Elemento no seleccionado");
            alert.setContentText("Debes seleccionar a una persona antes de borrar");
            alert.showAndWait();
        }
    }
    @FXML
    private void newPerson(){
        Person tempPerson = new Person();
        boolean okClicked = address_app.showPersonEditDialog(tempPerson);
        if (okClicked) {
            address_app.getPersonData().add(tempPerson);
        }
    }
    @FXML
    private void editPerson(){
        Alert alert;
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null){
            boolean okClicked = address_app.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Elemento no seleccionado");
            alert.setContentText("Debes seleccionar a una persona antes de editar");
            alert.showAndWait();
        }
    }
}
