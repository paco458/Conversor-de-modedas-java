/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vitas;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanelGrafico extends JFrame {

    public PanelGrafico(String de, String a) {
        setTitle("Gráfico de Tasa de Cambio: " + de + " → " + a);
        setSize(700, 500);
        setLocationRelativeTo(null);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Simulación de datos históricos (puedes mejorar usando API de historial)
        Random rnd = new Random();
        for (int i = 1; i <= 7; i++) {
            dataset.addValue(0.9 + rnd.nextDouble() * 0.2, "Tasa", "Día " + i);
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Evolución semanal del cambio " + de + " a " + a,
                "Días",
                "Tasa",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }
}
