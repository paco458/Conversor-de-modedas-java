/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
// Clase del modelo: realiza conversiones y obtiene tasas
public class Conversor {

    public double convertir(String de, String a, double cantidad) {
        double tasa = ApiMonedas.obtenerTasa(de, a);
        return cantidad * tasa;
    }

    public double obtenerTasaCambio(String de, String a) {
        return ApiMonedas.obtenerTasa(de, a);
    }
}
