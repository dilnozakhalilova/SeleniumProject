package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
// NOTE: THIS CLASS WRITES TO PROPERTIES FILE. ALTERNATIVE NAME COULD BE " WriteToProperties"
public class ConfigsWriter {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir")+"/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        // SetUp is ready. instead of reading this time I will write to the Properties File.

        properties.setProperty("Phone","917-551-1456");
        properties.setProperty("email","tester@gmail.com");

        FileOutputStream fos = new FileOutputStream(filePath);
       properties.store(fos,"Adding phone number and email adress to the propoerties file");


      // properties.setProperty("email","tester@gmail.com");// will bring duplicates if wrote here
       properties.store(fos,"Adding email adress");










    }
}
