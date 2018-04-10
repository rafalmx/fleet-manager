package com.mazurek.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static ApplicationProperties instance = null;

    private static final ClassLoader CLASS_LOADER = ApplicationProperties.class.getClassLoader();
    private static final String CONFIG_FILENAME = "config.properties";
    private Properties properties = new Properties();

    private ApplicationProperties() {
        InputStream input = CLASS_LOADER.getResourceAsStream(CONFIG_FILENAME);
        if(input==null){
            System.out.println("Unable to find " + CONFIG_FILENAME);
            return;
        }
        //load a properties file from class path, inside static method
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load config.propeties. Exiting application");
            System.exit(1);
        }
    }

    public static ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }


}
