package AddressApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import AddressApp.DateUtil;
import AddressApp.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class PersonEditDialogController implements Initializable {
    @FXML
    private TextField nombre_field;
    @FXML
    private TextField apellidos_field;
    @FXML
    private TextField calle_field;
    @FXML
    private TextField cp_field;
    @FXML
    private TextField ciudad_field;
    @FXML
    private DatePicker fecha_nacimiento_field;
    
    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    public void setPerson(Person person){
        this.person = person;
        nombre_field.setText(person.getNombre());
        apellidos_field.setText(person.getApellidos());
        calle_field.setText(person.getCalle());
        if (person.getCp() == null) {
            cp_field.setText("");
        } else {
            cp_field.setText(person.getCp());
        }
        ciudad_field.setText(person.getCiudad());
        fecha_nacimiento_field.setValue(person.getFecha_nacimiento());
        fecha_nacimiento_field.setPromptText("dd.mm.yyyy");
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    @FXML
    private void ok(){
        if (isInputValid()) {
            person.setNombre(nombre_field.getText());
            person.setApellidos(apellidos_field.getText());
            person.setCalle(calle_field.getText());
            person.setCp(cp_field.getText());
            person.setCiudad(ciudad_field.getText());
            person.setFecha_nacimiento(fecha_nacimiento_field.getValue());
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void cancel(){
        dialogStage.close();
    }
    
    private boolean isInputValid(){
        String errorMensaje = "";
        
        if (nombre_field.getText() == null || nombre_field.getText().length() == 0) {
            errorMensaje += "Nombre no valido! \n";
        }        
        if (apellidos_field.getText() == null || apellidos_field.getText().length() == 0) {
            errorMensaje += "Apelldo no valido! \n";
        }        
        if (calle_field.getText() == null || calle_field.getText().length() == 0) {
            errorMensaje += "Nombre no valido! \n";
        }        
        if (cp_field.getText() == null || cp_field.getText().length() == 0) {
            errorMensaje += "Nombre no valido! \n";
        } else {
            try {
                Integer.parseInt(cp_field.getText());
            } catch (NumberFormatException e){
                errorMensaje += "Codigo Postal no valido (debe ser un numero)! \n";
            }
        }   
        if (ciudad_field.getText() == null || ciudad_field.getText().length() == 0) {
            errorMensaje += "Ciudad no valida! \n";
        }           
        if (fecha_nacimiento_field.getValue() == null) {
            errorMensaje += "Fecha no valida! \n";
        } else {
            if (!DateUtil.validDate(fecha_nacimiento_field.getValue().toString())){
                errorMensaje += "Fecha no valida!  (usa el formato dd.mm.yyyy)! \n";
            }
        }
        if (errorMensaje.length()==0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos");
            alert.setContentText(errorMensaje);
            alert.showAndWait();
            return false;
        }
    }
}
