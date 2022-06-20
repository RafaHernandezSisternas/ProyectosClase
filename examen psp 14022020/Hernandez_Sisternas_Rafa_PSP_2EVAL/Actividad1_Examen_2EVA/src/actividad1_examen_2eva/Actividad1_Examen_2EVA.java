package actividad1_examen_2eva;

import java.io.*;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Actividad1_Examen_2EVA {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("datos.txt");
        BufferedReader br = new BufferedReader(fr);
        
        // Punto 1 - leer datos del fichero datos
        String servidor = br.readLine();
        int puerto = Integer.parseInt(br.readLine());
        String usuario = br.readLine();
        String contraseña = br.readLine();
        String carpeta = br.readLine();
        String filtro = br.readLine();
        String destino = br.readLine();
        
        FTPClient cliente = new FTPClient();
        // Punto 2 - conectarse con el dato Servidor y el dato Puerto
        cliente.connect(servidor, puerto);
        cliente.enterLocalPassiveMode();
        // Punto 3 - login mediante dato Usuario y dato Contraseña
        boolean login = cliente.login(usuario, contraseña);
        if (login) {
            System.out.println("Login correcto");
        } else {
            cliente.disconnect();
            System.out.println("Login incorrecto");
            System.exit(0);
        }
        // Punto 4 - cambiar al directorio con nombre el dato Carpeta
        cliente.changeWorkingDirectory(carpeta);
        // Punto 5 - listar ficheros que son archivos de Carpeta
        FTPFile[] misFicheros = cliente.listFiles();
        for (int i = 0; i < misFicheros.length; i++) {
            if (misFicheros[i].getType() == 0) {
                System.out.println(misFicheros[i]);
            }
        }
        // Punto 6 - descargar ficheros que contengan como parte de su nombre el dato Filtro
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destino));
        for (int i = 0; i < misFicheros.length; i++) {
            if (misFicheros[i].getName().contains(filtro)) {
                cliente.retrieveFile(misFicheros[i].getName(), out);
                System.out.println("Recuperado correctamente");
            } else {
                System.out.println("Descarga fallida");
            }
        }
        
        cliente.logout();
        cliente.disconnect();
        System.out.println("Conexion finalizada");
    }
}
