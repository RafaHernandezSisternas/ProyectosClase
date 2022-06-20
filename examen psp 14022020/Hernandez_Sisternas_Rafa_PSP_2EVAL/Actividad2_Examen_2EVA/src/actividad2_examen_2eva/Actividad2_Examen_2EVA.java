package actividad2_examen_2eva;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.pop3.*;

public class Actividad2_Examen_2EVA {
    public static void main(String[] args) {
        String servidor = "pop.ionos.es";
        String usuario = "alumno@formaval.com";
        String contraseña = "Pass.2019";
        int puerto = 110;
        long bytesTotal = 0;
        
        POP3SClient pop3 = new POP3SClient();
        try {
            // Conexion al servidor
            pop3.connect(servidor, puerto);
            // Logeo al servidor
            if (!pop3.login(usuario,contraseña)) {
                System.out.println("No se ha podido iniciar sesion");
            } else {
                // Bucle para calcular el total de bytes
                POP3MessageInfo[] mensajes = pop3.listMessages();
                for (int i = 0; i < mensajes.length; i++) {
                    bytesTotal += mensajes[i].size;
                }
                System.out.println("El total actual de bytes usado por todos los mensajes es: "+bytesTotal);
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
