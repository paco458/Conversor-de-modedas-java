/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Conversor;
import Vitas.VentanaConversor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorConversor implements ActionListener {

    private VentanaConversor vista;
    private Conversor modelo;

    public ControladorConversor(VentanaConversor vista, Conversor modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnConvertir.addActionListener(this);
        this.vista.btnMostrarGrafico.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnConvertir) {
            convertir();
        } else if (e.getSource() == vista.btnMostrarGrafico) {
            vista.mostrarGrafico();
        }
    }

    private void convertir() {
        try {
            double cantidad = Double.parseDouble(vista.txtCantidad.getText());
            String de = vista.comboDe.getSelectedItem().toString();
            String a = vista.comboA.getSelectedItem().toString();

            double resultado = modelo.convertir(de, a, cantidad);
            double tasa = modelo.obtenerTasaCambio(de, a);

            vista.lblResultado.setText(String.format("%.2f %s = %.2f %s", cantidad, de, resultado, a));
            vista.lblTasa.setText(String.format("1 %s = %.4f %s", de, tasa, a));
        } catch (NumberFormatException ex) {
            vista.lblResultado.setText("❌ Ingrese un número válido.");
            vista.lblTasa.setText("");
        }
    }
}
