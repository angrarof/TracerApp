package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    Properties properties = new Properties();
    InputStream inputStream = null;

    public PropertiesFile() {
        loadProperties();
    }

    public void loadProperties() {
        String projectLocation = System.getProperty("user.dir");
        try {
            inputStream = new FileInputStream(projectLocation+"\\src\\test\\java\\config\\config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readBrowser(){
        return properties.getProperty("browser");
    }


}
