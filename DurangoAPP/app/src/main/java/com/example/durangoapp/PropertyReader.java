package com.example.durangoapp;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties props = new Properties();
    private static String propertyFile = "";

    static {
        try (FileInputStream input = new FileInputStream(propertyFile)) {
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String clave) {
        String valor = props.getProperty(clave);
        if (valor != null) {
            return valor;
        }
        throw new RuntimeException("La clave solicitada en configuration.properties no está disponible");
    }

    public static void setPropertyFile(String file){
        propertyFile = file;
    }
}
