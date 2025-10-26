/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vitas;

import Controlador.ControladorConversor;
import Modelo.Conversor;
import Vitas.PanelGrafico;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;

public class VentanaConversor extends JFrame {

    public JComboBox<String> comboDe, comboA;
    public JTextField txtCantidad;
    public JButton btnConvertir, btnMostrarGrafico;
    public JLabel lblResultado, lblTasa;

    public VentanaConversor() {
        setTitle("💰 Conversor de Monedas Avanzado");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(25, 30, 45));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Convertidor de Monedas con Gráfico", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);

        comboDe = new JComboBox<>(new String[]{"USD", "EUR", "PEN", "JPY"});
        comboA = new JComboBox<>(new String[]{"USD", "EUR", "PEN", "JPY"});
        txtCantidad = new JTextField();
        btnConvertir = new JButton("Convertir");
        btnMostrarGrafico = new JButton("Mostrar Gráfico");
        lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        lblResultado.setForeground(Color.WHITE);
        lblTasa = new JLabel("Tasa: ", SwingConstants.CENTER);
        lblTasa.setForeground(Color.LIGHT_GRAY);

        gbc.gridy = 0; add(lblTitulo, gbc);
        gbc.gridy = 1; add(txtCantidad, gbc);
        gbc.gridy = 2; add(comboDe, gbc);
        gbc.gridy = 3; add(comboA, gbc);
        gbc.gridy = 4; add(btnConvertir, gbc);
        gbc.gridy = 5; add(btnMostrarGrafico, gbc);
        gbc.gridy = 6; add(lblResultado, gbc);
        gbc.gridy = 7; add(lblTasa, gbc);
    }

    public void mostrarGrafico() {
        String de = comboDe.getSelectedItem().toString();
        String a = comboA.getSelectedItem().toString();
        new PanelGrafico(de, a).setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) { e.printStackTrace(); }

        VentanaConversor vista = new VentanaConversor();
        Conversor modelo = new Conversor();
        new ControladorConversor(vista, modelo);
        vista.setVisible(true);
    }
}
