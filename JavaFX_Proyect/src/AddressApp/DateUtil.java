package AddressApp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class DateUtil {
    private static final String PATRON_FECHA = "dd-MM-yyyy";
    private static final String PATRON_FECHA_XML = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATEADOR_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);
    private static final DateTimeFormatter FORMATEADOR_FECHA_XML = DateTimeFormatter.ofPattern(PATRON_FECHA_XML);
    
    public static String format(LocalDate Fecha){
        if (Fecha == null) {
            return null;
        }
        return FORMATEADOR_FECHA.format(Fecha);
    }
    
    public static LocalDate parse(String Fecha){
        try{
            return FORMATEADOR_FECHA_XML.parse(Fecha, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
    
    public static boolean validDate(String fecha){
        return DateUtil.parse(fecha) != null;
    }
    
}
