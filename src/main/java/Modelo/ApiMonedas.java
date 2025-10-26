/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

// Clase que obtiene tasas de cambio reales desde una API externa
public class ApiMonedas {

    private static final String API_KEY = "https://open.er-api.com/v6/latest/"; // API gratuita sin clave

    public static double obtenerTasa(String de, String a) {
        try {
            URL url = new URL(API_KEY + de);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("rates").getDouble(a);

        } catch (Exception e) {
            System.out.println("Error API: " + e.getMessage());
            return 1.0;
        }
    }
}
