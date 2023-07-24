package com.one.conversor;

import java.util.HashMap;
import java.util.Map;

public class ConversorApp {
    private Map<String, Double> tasasConversion;

    public ConversorApp () {
        tasasConversion = new HashMap<>();
        //Dolar
        tasasConversion.put("Dolar-Peso", 16.75);
        tasasConversion.put("Peso-Dolar", 0.06);
        tasasConversion.put("Dolar-Euro", 0.89);
        tasasConversion.put("Euro-Dolar", 1.12);
        tasasConversion.put("Dolar-Libra", 0.76);
        tasasConversion.put("Libra-Dolar", 1.31);
        tasasConversion.put("Dolar-Yen", 138.70);
        tasasConversion.put("Yen-Dolar", 0.007);
        tasasConversion.put("Dolar-Wun", 1.269);
        tasasConversion.put("Wun-Dolar", 0.0007);
        
        //Peso
        tasasConversion.put("Peso-Euro", 0.053);
        tasasConversion.put("Euro-Peso", 18.81);
        tasasConversion.put("Peso-Libra", 0.046);
        tasasConversion.put("Libra-Peso", 21.92);
        tasasConversion.put("Peso-Yen", 8.28);
        tasasConversion.put("Yen-Peso", 0.12);
        tasasConversion.put("Peso-Wun", 75.80);
        tasasConversion.put("Wun-Peso", 0.013);
        
        //Euro
        tasasConversion.put("Euro-Libra", 0.86);
        tasasConversion.put("Libra-Euro", 1.16);
        tasasConversion.put("Euro-Yen", 156.01);
        tasasConversion.put("Yen-Euro", 0.0064);
        tasasConversion.put("Euro-Wun", 1.426);
        tasasConversion.put("Wun-Euro", 0.0007);
        
        //Libra
        tasasConversion.put("Libra-Yen", 181.58);
        tasasConversion.put("Yen-Libra", 0.0055);
        tasasConversion.put("Libra-Wun", 1.661);
        tasasConversion.put("Wun-Libra", 0.0006);
        
        //Yen
        
        tasasConversion.put("Yen-Wun", 9.15);
        tasasConversion.put("Wun-Yen", 0.11);
        
        
        
    }

    public double convertirMoneda(double valor, String monedaOrigen, String monedaDestino) {
        double tasa = tasasConversion.get(monedaOrigen + "-" + monedaDestino);
        if (tasa != 0.0) {
            return valor * tasa;
        } else {
            return -1;
        }
    }

	public void setVisible(boolean b) {
		
	}
}

