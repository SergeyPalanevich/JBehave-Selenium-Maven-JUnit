package com.epam.bdd.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static String readProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        String valueProp = null;

        try {
            input = new FileInputStream("src/test/resources/config/app.properties");
            prop.load(input);
            valueProp = prop.getProperty("browser");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return valueProp;
    }

}
