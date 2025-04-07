package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    public static Properties initializeProp() throws IOException 
    {
    	properties = new Properties();
  
    	InputStream configFile = ConfigReader.class.getClassLoader().getResourceAsStream("Config.properties");
        properties.load(configFile);
       
        return properties;
    }
    
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
