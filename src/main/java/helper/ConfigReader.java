package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    public static Properties initializeProp() throws IOException 
    {
    	properties = new Properties();
  
        FileInputStream configFile = new FileInputStream("C:\\Users\\kisha\\eclipse-workspace\\AutomationCucumberProject\\src\\main\\resources\\Config.properties");
        properties.load(configFile);
       
        return properties;
    }
    
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
