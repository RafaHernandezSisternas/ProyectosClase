package AddressApp.model;
import AddressApp.LocalDateAdapter;
import java.time.LocalDate;
import javafx.beans.property.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Person {
    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final StringProperty calle;
    private final StringProperty ciudad;
    private final StringProperty cp;
    private final ObjectProperty<LocalDate> fecha_nacimiento;

    public Person(String nombre, String apellidos, String calle, String ciudad, String cp, int day, int month, int year) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.calle = new SimpleStringProperty(calle);
        this.ciudad = new SimpleStringProperty(ciudad);
        this.cp = new SimpleStringProperty(cp);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(LocalDate.of(year, month, day));
    }

    public Person() {
        this.nombre = new SimpleStringProperty("");
        this.apellidos = new SimpleStringProperty("");
        this.calle = new SimpleStringProperty("");
        this.ciudad = new SimpleStringProperty("");
        this.cp = new SimpleStringProperty("");
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(null);
    }
    

    public final String getNombre() {
        return nombre.get();
    }

    public final void setNombre(String value) {
        this.nombre.set(value);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public final String getApellidos() {
        return apellidos.get();
    }

    public final void setApellidos(String value) {
        this.apellidos.set(value);
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public final String getCalle() {
        return calle.get();
    }

    public final void setCalle(String value) {
        this.calle.set(value);
    }

    public StringProperty calleProperty() {
        return calle;
    }

    public final String getCiudad() {
        return ciudad.get();
    }

    public final void setCiudad(String value) {
        this.ciudad.set(value);
    }

    public StringProperty ciudadProperty() {
        return ciudad;
    }

    public final String getCp() {
        return cp.get();
    }

    public final void setCp(String value) {
        this.cp.set(value);
    }

    public StringProperty cpProperty() {
        return cp;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public final LocalDate getFecha_nacimiento() {
        return fecha_nacimiento.get();
    }

    public final void setFecha_nacimiento(LocalDate value) {
        this.fecha_nacimiento.set(value);
    }

    public ObjectProperty<LocalDate> fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }

    
}
