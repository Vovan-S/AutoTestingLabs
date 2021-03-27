package hw3.Util;

import java.io.*;
import java.util.Properties;

public class PropertiesHandler {
    static public String getProperty(String key) {
        try (FileInputStream fis =
                new FileInputStream("src/test/resources/hw3/local.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Error with loading properties");
            return "";
        }
    }
}
