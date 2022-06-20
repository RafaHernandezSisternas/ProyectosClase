package AddressApp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javax.xml.bind.JAXBException;

public class RootLayoutController implements Initializable {

    private AddressAPP address_app;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setMainApp(AddressAPP address_app) {
        this.address_app = address_app;
    }
    
    @FXML
    private void handleShowBirthdayStatistics(){
        address_app.showBirthdayStatistics();
    }

    @FXML
    private void newFile() {
        address_app.getPersonData().clear();
        address_app.setPersonFilePath(null);
    }

    @FXML
    private void openFile() throws JAXBException {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fc.getExtensionFilters().add(ef);

        File file = fc.showOpenDialog(address_app.getPrimaryStage());

        if (file != null) {
            address_app.loadPersonDataFile(file);
        }
    }

    @FXML
    private void saveFile() {
        File pf = address_app.getPersonFilePath();
        if (pf != null) {
            address_app.savePersonDataFile(pf);
        } else {
            saveAsFile();
        }
    }

    @FXML
    private void saveAsFile() {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fc.getExtensionFilters().add(ef);

        File file = fc.showSaveDialog(address_app.getPrimaryStage());

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            address_app.savePersonDataFile(file);
        }
    }

    @FXML
    private void about() {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("AddressAPP");
        alert.setHeaderText("Alumno que sufre eternamente con esta practica: ");
        alert.setContentText("Rafa Hernandez Sisternas\n");
        alert.showAndWait();
    }
    
    @FXML
    private void exit(){
        System.exit(0);
    }
}
