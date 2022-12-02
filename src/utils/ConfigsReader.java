package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//NOTE: this class reads from the properties file.Alternative  class name to this class could be "ReadFromProperties"
public class ConfigsReader {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties prop = new Properties();
        prop.load(fis);

        String browser = prop.getProperty("browser");
        System.out.println("browser = " + browser);

    }






}
