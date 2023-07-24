package com.one.conversor;

import java.util.HashMap;
import java.util.Map;

public class TemperaturaApp {
    private Map<String, Double> tasasConversion;

    public TemperaturaApp() {
        tasasConversion = new HashMap<>();

        tasasConversion.put("Celsius-Fahrenheit", 9.0 / 5.0);
        tasasConversion.put("Celsius-Kelvin", 1.0);
        tasasConversion.put("Fahrenheit-Celsius", 5.0 / 9.0);
        tasasConversion.put("Fahrenheit-Kelvin", 5.0 / 9.0);
        tasasConversion.put("Kelvin-Celsius", 1.0);
        tasasConversion.put("Kelvin-Fahrenheit", 9.0 / 5.0);
    }

    public double convertirTemperatura(double valor, String unidadOrigen, String unidadDestino) {
        String claveConversion = unidadOrigen + "-" + unidadDestino;
        double tasa = tasasConversion.get(claveConversion);

        if (tasa != 0.0) {
            if (claveConversion.equals("Celsius-Fahrenheit") || claveConversion.equals("Fahrenheit-Celsius")) {
                double offset = claveConversion.equals("Celsius-Fahrenheit") ? 32 : -32;
                return (valor * tasa) + offset;
            } else if (claveConversion.equals("Fahrenheit-Kelvin") || claveConversion.equals("Kelvin-Fahrenheit")) {
                double offset = claveConversion.equals("Fahrenheit-Kelvin") ? 459.67 : -459.67;
                return (valor + offset) * tasa;
            } else if (claveConversion.equals("Celsius-Kelvin") || claveConversion.equals("Kelvin-Celsius")) {
                double offset = claveConversion.equals("Celsius-Kelvin") ? 273.15 : -273.15;
                return valor + offset;
            }
        }

        return -1;
    }
}

