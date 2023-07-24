package com.one.conversor;

import javax.swing.*;

public class MenuPrincipal {
    private static final String[] opciones = {"Conversor de Monedas", "Conversor de Temperatura", "Salir"};

    public static void main(String[] args) {
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "Menú Principal",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {
            switch (seleccion) {
                case "Conversor de Monedas":
                    ConversorVentana ventanaMonedas = new ConversorVentana();
                    ventanaMonedas.setVisible(true);
                    break;
                case "Conversor de Temperatura":
                    ConversorDeTemperatura ventanaTemperatura = new ConversorDeTemperatura();
                    ventanaTemperatura.setVisible(true);
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog(null, "Gracias por usar la aplicación.");
                    break;
            }
        }
    }
}

