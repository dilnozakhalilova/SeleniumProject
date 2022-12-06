package Class9.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//NOTE: this class reads from the properties file.Alternative  class name to this class could be "ReadFromProperties"
public class ConfigsReader_New {
    static Properties properties;

    /** Java Doc comments
     *This method will locate and prapare(load) the Properties file
     * @param filePath specify file path/location here
     */
    public static void loadProperties(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);// Java IO open --> always Close()
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();// tells you where mistake is.
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * This method will return value of the specified key from the properties file
     * @param key accepted as a String
     * @return returns value of the given key(comes from the Properties file)
     */
    public static String getProperties(String key) {// readproperties
       return properties.getProperty(key);

    }

}