package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    public static final Logger logger = Logger.getLogger(ConfigReader.class.getName());
    private static final String CONFIG_FILE = "/configuration.properties";
    private static final Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream inputStream = ConfigReader.class.getResourceAsStream(CONFIG_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                logger.log(Level.SEVERE, "Cannot find config file: " + CONFIG_FILE);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading config file", e);
        }
    }
    static ConfigReader configReader = new ConfigReader();


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getTimeImplicit() {
        int defaultValue = 5000;
        try {
            return Integer.parseInt(configReader.getProperty("app.implicitlyWait"));
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid implicitlyWait value. Using default value: " + defaultValue, e);
            return defaultValue;
        }
    }

    public static String getBaseUrl() {
        return configReader.getProperty("app.baseurl");
    }

    public static String getBrowser() {
        return getProperty("app.Navegador");
    }

    public static boolean isHeadlessModeEnabled() {
        String headlessMode = configReader.getProperty("app.headless.mode");
        return Boolean.parseBoolean(headlessMode);
    }

    public static String obtenerColorElemento() {
        return configReader.getProperty("color.element");
    }

    public static int obtenerTiempoResaltadoElemento() {
        return Integer.parseInt(configReader.getProperty("color.time"));
    }

    public static String obtenerHabilitacionColor() {
        return configReader.getProperty("color.enabled");
    }

    public static int obtenerTiempoExplicito(){
        return Integer.parseInt(configReader.getProperty("app.explicitWait"));
    }

}