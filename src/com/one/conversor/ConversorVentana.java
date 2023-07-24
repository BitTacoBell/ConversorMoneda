package com.one.conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConversorVentana extends JFrame {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> cajaDivisas1;
    private JComboBox<String> cajaDivisas2;
    private JButton botonConvertir;
    private ConversorApp conversor;

    public ConversorVentana() {
        setSize(300, 150);
        setTitle("Conversor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        String[] opciones = {"Dolar", "Peso", "Euro", "Libra", "Yen", "Wun"};
        cajaDivisas1 = new JComboBox<>(opciones);
        cajaDivisas1.setBounds(35, 10, 100, 30);
        panel.add(cajaDivisas1);

        cajaDivisas2 = new JComboBox<>(opciones);
        cajaDivisas2.setBounds(150, 10, 100, 30);
        panel.add(cajaDivisas2);

        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(92, 50, 100, 30);
        panel.add(botonConvertir);

        conversor = new ConversorApp();

        botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion1 = (String) cajaDivisas1.getSelectedItem();
                String opcion2 = (String) cajaDivisas2.getSelectedItem();

                if (opcion1.equals(opcion2)) {
                    JOptionPane.showMessageDialog(null, "Las opciones de conversión deben ser diferentes");
                } else {
                    String inputValue = JOptionPane.showInputDialog(null, "Ingrese el valor a convertir:");

                    try {
                        double valor = Double.parseDouble(inputValue);

                        double resultado = conversor.convertirMoneda(valor, opcion1, opcion2);

                        if (resultado != -1) {
                            DecimalFormat df = new DecimalFormat("#.#####");
                            String resultadoFormateado = df.format(resultado);

                            JOptionPane.showMessageDialog(null, valor + " " + opcion1 + " es " + resultadoFormateado + " " + opcion2);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró una conversión válida");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
                    }
                }
            }
        });

        add(panel);
    }
}

