package jyami.com.bot;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jyami on 21. 2. 24.
 */
public class PropertiesReader {

    public static String PROPERTIES_PATH = "application.properties";

    public String getPropertyToken() throws Exception {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_PATH);) {
            Properties prop = new Properties();
            if (resourceAsStream != null) {
                prop.load(resourceAsStream);
            } else {
                throw new FileNotFoundException("property file not found in the classpath");
            }
            return prop.getProperty("token");
        }
    }
}
