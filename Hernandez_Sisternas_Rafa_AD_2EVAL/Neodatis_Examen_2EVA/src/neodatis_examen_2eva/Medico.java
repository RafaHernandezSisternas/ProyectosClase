package neodatis_examen_2eva;
public class Medico {
    private String dni;
    private String nombre;
    private String apellidos;
    private String especialidad;

    public Medico(String dni, String nombre, String apellidos, String especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", especialidad=" + especialidad + '}';
    }
    
    
}
