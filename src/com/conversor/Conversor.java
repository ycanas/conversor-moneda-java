package com.conversor;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class Conversor {
    public static void main(String[] args) throws Exception {
        double amount;
        String from, to;
        String apiKey = "TiSPLRGEjbNmlSZ2Rin52bzlTAgT0yzM";

        Api comunication = new Api();

        HashMap<String, String> currencies = new HashMap<String, String>() {{
            put("Peso", "COP");
            put("Dolar", "USD");
            put("Euro", "EUR");
            put("Libra Esterlina", "GBP");
            put("Yen Japonés", "JPY");
            put("Won Sul-Coreano", "KRW");
        }};

        comunication.setUrl("https://api.apilayer.com/fixer/convert?");
        comunication.setApiKey(apiKey);

        amount = Double.parseDouble(JOptionPane.showInputDialog("Cantidad de Dinero a Convertir: "));

        from = currencies.get(JOptionPane.showInputDialog(null, "Tipo de Moneda Actual: ", "Menu", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Peso", "Dolar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Sul-Coreano"}, "Seleccion").toString());

        to = currencies.get(JOptionPane.showInputDialog(null, "Tipo de Moneda de Destino", "Menu", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Peso", "Dolar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Sul-Coreano"}, "Seleccion").toString());

        String result = comunication.convert(from, to, amount);

        JOptionPane.showMessageDialog(null, "" + result + " " + to);
    }
}
