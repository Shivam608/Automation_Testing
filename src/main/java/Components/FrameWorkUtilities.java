package Components;

import java.io.*;
import java.util.Properties;

public class FrameWorkUtilities {

    /// Read from Config.properties file
    public static String readFromConfigurationFile(String key) {
        try {
            File file = new File((System.getProperty("user.dir")) + "\\src\\main\\resources\\Config.properties");
            try (InputStream stream = new FileInputStream(file)) {
                Properties properties = new Properties();
                properties.load(stream);
                return String.valueOf(properties.get(key));
            }
        } catch (IOException e) {
            System.out.println("No Value found for Key: " + key);
        }
        return key;
    }

    /// Read from Url.properties file
    public static String getUrl(String key) {
        try {
            File file = new File((System.getProperty("user.dir")) + "\\src\\main\\resources\\url.properties");
            try (InputStream stream = new FileInputStream(file)) {
                Properties prop = new Properties();
                prop.load(stream);
                return String.valueOf(prop.get(key));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
