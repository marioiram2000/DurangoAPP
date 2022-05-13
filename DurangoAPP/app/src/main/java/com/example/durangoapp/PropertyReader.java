package com.example.durangoapp;

import java.io.FileInputStream;
import java.util.Properties;

//Clase para leer las propiedades del archivo de propiedades assets/mainProperties.properties
public class PropertyReader {

    private static final Properties props = new Properties();
    private static String propertyFile = "assets/mainProperties.properties";

    static {
        try (FileInputStream input = new FileInputStream(propertyFile)) {
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    //Función que recive la clave de una propiedad y devuelve su valor
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
