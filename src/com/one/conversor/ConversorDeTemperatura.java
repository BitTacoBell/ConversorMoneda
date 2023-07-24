package com.one.conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConversorDeTemperatura extends JFrame {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> cajaTemperaturas;
    private JComboBox<String> cajaUnidades;
    private JButton botonConvertir;
    private TemperaturaApp conversor;

    public ConversorDeTemperatura() {
        setSize(300, 150);
        setTitle("Conversor de Temperatura");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        String[] temperaturas = {"Celsius", "Fahrenheit", "Kelvin"};
        cajaTemperaturas = new JComboBox<>(temperaturas);
        cajaTemperaturas.setBounds(35, 10, 100, 30);
        panel.add(cajaTemperaturas);

        cajaUnidades = new JComboBox<>(temperaturas);
        cajaUnidades.setBounds(150, 10, 100, 30);
        panel.add(cajaUnidades);

        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(92, 50, 100, 30);
        panel.add(botonConvertir);

        conversor = new TemperaturaApp();

        botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String unidadOrigen = (String) cajaTemperaturas.getSelectedItem();
                String unidadDestino = (String) cajaUnidades.getSelectedItem();

                if (unidadOrigen.equals(unidadDestino)) {
                    JOptionPane.showMessageDialog(null, "Las unidades de temperatura deben ser diferentes");
                } else {
                    String inputValue = JOptionPane.showInputDialog(null, "Ingrese la temperatura a convertir:");

                    try {
                        double valor = Double.parseDouble(inputValue);

                        double resultado = conversor.convertirTemperatura(valor, unidadOrigen, unidadDestino);

                        if (!Double.isNaN(resultado)) {
                            DecimalFormat df = new DecimalFormat("#.#####");
                            String resultadoFormateado = df.format(resultado);

                            JOptionPane.showMessageDialog(null, valor + " " + unidadOrigen + " es " + resultadoFormateado + " " + unidadDestino);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo realizar la conversión");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese una temperatura numérica válida");
                    }
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        ConversorDeTemperatura ventanaTemperatura = new ConversorDeTemperatura();
        ventanaTemperatura.setVisible(true);
    }
}

