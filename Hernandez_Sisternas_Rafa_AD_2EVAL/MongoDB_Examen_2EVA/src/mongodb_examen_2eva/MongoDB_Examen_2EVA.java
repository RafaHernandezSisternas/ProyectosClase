package mongodb_examen_2eva;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class MongoDB_Examen_2EVA {

    public static void main(String[] args) {
        try {
            File miFichero = new File("paciente.txt");
            FileReader fr = new FileReader(miFichero);
            BufferedReader br = new BufferedReader(fr);

            String id = br.readLine();
            String nombre = br.readLine();
            String apellidos = br.readLine();
            String telefono = br.readLine();

            Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
            MongoClient conexion = new MongoClient("localhost", 27017);
            MongoDatabase base = conexion.getDatabase("hospital");
            MongoCollection tabla = base.getCollection("pacientes");

            Document miDocumento = new Document();
            miDocumento.append("id", Integer.parseInt(id));
            miDocumento.append("nombre", nombre);
            miDocumento.append("apellidos", apellidos);
            miDocumento.append("telefono", Integer.parseInt(telefono));

            //tabla.insertOne(miDocumento);

            MongoCursor<Document> pacientes = tabla.find(or(eq("nombre","Ana"),eq("nombre","Carlos"))).iterator();
            while (pacientes.hasNext()) {
                Document miPaciente = pacientes.next();
                System.out.println("ID:" + miPaciente.getInteger("id"));
                System.out.println("Nombre:" + miPaciente.getString("nombre"));
                System.out.println("Apellido:" + miPaciente.getString("apellido"));
                System.out.println("Telefono:" + miPaciente.getInteger("telefono"));
                System.out.println("--------------------------------------------");
            }
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
