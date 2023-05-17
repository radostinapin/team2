package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
// hiding the data, it will read data from file, it is accessible only by me
        public  static String readProperty(String key){
        File file=new File("configuration.properties");
        Properties properties=new Properties();
        //this properties object will read the properties file
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  properties.getProperty(key);
    }
}
