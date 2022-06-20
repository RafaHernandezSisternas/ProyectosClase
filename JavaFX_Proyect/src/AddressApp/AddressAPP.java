/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressApp;

import AddressApp.model.PersonListWrapper;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import AddressApp.model.Person;
import java.io.File;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author dam2
 */
public class AddressAPP extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public AddressAPP() {
        personData.add(new Person("Guillermo", "Garrido", "C/Albacete", "Valencia", "47001", 11, 2, 1995));
        personData.add(new Person("Juan", "Lopez", "C/Alzira", "Alicante", "47002", 5, 2, 2010));
        personData.add(new Person("María", "Perez", "C/Manises", "Valencia", "47003", 21, 7, 2001));
        personData.add(new Person("Estela", "Galiana", "C/Xativa", "Castellon", "47004", 19, 6, 1999));
        personData.add(new Person("David", "Camps", "Plaza España", "Valencia", "47005", 11, 12, 1955));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws JAXBException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/relit.png")));

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() throws JAXBException {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AddressAPP.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = getPersonFilePath();
        if (file != null) {
            loadPersonDataFile(file);
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AddressAPP.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setAddressApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AddressAPP.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            if (!person.getNombre().equals("")) {
                dialogStage.setTitle("Editar " + person.getNombre() + " " + person.getApellidos());
            } else {
                dialogStage.setTitle("Nuevo Contacto");
            }
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(AddressAPP.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(AddressAPP.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");
            primaryStage.setTitle("AddressApp");
        }
    }

    public void loadPersonDataFile(File file) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);

            personData.clear();
            personData.addAll(wrapper.getPersons());

            setPersonFilePath(file);

        } catch (Exception e) {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Carga Incompleta");
            alert.setContentText("No se puede cargar datos desde el archivo \n" + file.getPath());
            alert.showAndWait();
        }
    }

    public void savePersonDataFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            PersonListWrapper wrapper = new PersonListWrapper();
            wrapper.setPersons(personData);

            m.marshal(wrapper, file);

            setPersonFilePath(file);
        } catch (Exception e) {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Guardado Incompleto");
            alert.setContentText("No se pueden guardar datos desde el archivo \n" + file.getPath());
            alert.showAndWait();
        }
    }
    
    public void showBirthdayStatistics(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AddressAPP.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cumpleaños Contactos");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);
            
            dialogStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
