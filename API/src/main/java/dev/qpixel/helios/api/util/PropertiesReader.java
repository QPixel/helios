package dev.qpixel.helios.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(String propertyFileName) throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) throws IOException {
        String property = properties.getProperty(propertyName);
        if (property != null) {
            return property;
        } else {
            throw new IOException();
        }
    }
}
