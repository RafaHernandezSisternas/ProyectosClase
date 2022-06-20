package actividad3_examen_2eva;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad3_Examen_2EVA {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner tec = new Scanner(System.in);
        int opcion;
        String contraseña;
        File encriptado = new File("pass.txt");
        MessageDigest algSha = MessageDigest.getInstance("SHA-1");
        // Bucle del menu
        do {
            System.out.println("Elige una opcion: ");
            System.out.println("1 - Crear fichero de contraseña");
            System.out.println("2 - Introducir contraseña y comprobar si coincide con la del fichero");
            System.out.println("3 - Salir");
            opcion = tec.nextInt();
            tec.nextLine();
            
            switch (opcion) {
                // La opcion 1 pide una contraseña mediante Scanner y la escribe a pass.txt encriptada en Base64 y SHA
                case 1:
                    System.out.println("Introduce una contraseña");
                    contraseña = tec.nextLine();
                    byte[] contraseñaBytes = contraseña.getBytes();
                    algSha.update(contraseñaBytes);
                    byte[] contraEncriptada = algSha.digest();
                    String codificado = Base64.getEncoder().encodeToString(contraEncriptada);

                    try {
                        FileWriter fw = new FileWriter(encriptado);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(codificado);
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Actividad3_Examen_2EVA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                // La opcion 1 pide una contraseña mediante Scanner, pero en vez de almacenarla, la encriptamos en Base64 y SHA
                // para poder compararla con la que esta escrita en el fichero pass.txt
                case 2:
                    System.out.println("Introduce una contraseña para comparar con la encriptada");
                    String contraseñaCompara = tec.nextLine();

                    try {
                        FileReader fr = new FileReader(encriptado);
                        BufferedReader br = new BufferedReader(fr);
                        String contraCodificada = br.readLine();
                        br.close();
                        fr.close();

                        byte[] contraseñaComparaBytes = contraseñaCompara.getBytes();
                        algSha.update(contraseñaComparaBytes);
                        byte[] contraseñaComparaEncriptada = algSha.digest();
                        String codificadoEncriptada = Base64.getEncoder().encodeToString(contraseñaComparaEncriptada);

                        if (codificadoEncriptada.equals(contraCodificada)) {
                            System.out.println("La contraseña almacenada y la contraseña introducida son iguales");
                        } else {
                            System.out.println("Las contraseñas son diferentes");
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Actividad3_Examen_2EVA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                // el caso 3 simplemente sale de la aplicacion
                case 3:
                    System.exit(0);
                    break;
            }
        } while (opcion != 3);
    }

}
