package AddressApp;

import AddressApp.model.Person;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class BirthdayStatisticsController implements Initializable {

    @FXML
    private BarChart<String, Integer> grafico;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> nombres_meses = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();

        nombres_meses.addAll(Arrays.asList(months));
        xAxis.setCategories(nombres_meses);
    }
    
    public void setPersonData(List<Person> persons) {
        
        int[] contadorMensual = new int[12];
        for (Person p : persons) {
            int month = p.getFecha_nacimiento().getMonthValue() - 1;
            contadorMensual[month]++;
        }
        
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for (int i = 0; i < contadorMensual.length; i++) {
            series.getData().add(new XYChart.Data<>(nombres_meses.get(i),contadorMensual[i]));
        }
        
        grafico.getData().add(series);
    }

}
