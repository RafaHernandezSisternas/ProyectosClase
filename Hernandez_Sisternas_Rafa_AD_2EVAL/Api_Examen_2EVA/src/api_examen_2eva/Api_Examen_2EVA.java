package api_examen_2eva;

import java.io.*;
import java.net.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.util.List;
import java.util.Scanner;

public class Api_Examen_2EVA {

    public static void main(String[] args) throws MalformedURLException, IOException {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduce la id de un paciente para consultar(vacio para listar)");
        String consulta = tec.nextLine();

        URL url = new URL("http://localhost:8080/ApiExamen/api/pacientes/" + consulta);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        String jsonString = "";

        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/json");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

        while (br.readLine() != null) {
            jsonString += br.readLine();
        }
        br.close();
        conexion.disconnect();

        try {
            Gson gson = new Gson();
            List<Paciente> listPacientes = gson.fromJson(jsonString, new TypeToken<List<Paciente>>() {
            }.getType());
            if (listPacientes != null) {
                for (Paciente object : listPacientes) {
                    System.out.println(object.toString());
                }
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

}
