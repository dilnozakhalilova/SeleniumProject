package Class9;

//Full Path
// user.dir+Root path
// Locate the properties file within the project
// String filePath = "C:\\Users\\dilno\\JavaCourse\\JavaProjects\\SeleniumProject\\configs\\configuration.properties";// Full Path
//        String projectLocation = System.getProperty("user.dir");
//        System.out.println("projectLocation = " + projectLocation);

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
Example 1:
 // Retreaving filePath 2 different ways
        // 1. Way: Full Path
        String filePath1="C:\\Users\\dilno\\JavaCourse\\JavaProjects\\SeleniumProject\\src\\Class8\\_01_IteratorIntro.java";
        System.out.println("filePath1 = " + filePath1);

        // 2. Way: Concatinating Project filepath + Class file path. with whatever filepath I want to.
        String filePath2 = System.getProperty("user.dir")+"/src/Class8/_01_IteratorIntro.java";
        System.out.println("filePath2 = " + filePath2);
  Example 2:


        // 1. Way: Full Path
        String filePath1="C:\\Users\\dilno\\JavaCourse\\JavaProjects\\SeleniumProject\\configs\\configuration.properties";
        System.out.println("filePath1 = " + filePath1);

        // 2. Way: Concatinating Project filepath + Class file path. with whatever filepath I want to.
        String filePath2 = System.getProperty("user.dir")+"/configs/configuration.properties";
        System.out.println("filePath2 = " + filePath2);



 */
public class _01_ConnectWithPropertiesFile {
    public static void main(String[] args) throws IOException {
        // Adress of the file
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";// Telling the system where the file is located

        // to be able to transfer it (via tube) I need to put my file inside fileInputStream
        FileInputStream fis = new FileInputStream(filePath);// FilePath Handler, establish connection stream with my filePath.

        Properties properties = new Properties();
        properties.load(fis);


        // ready to use. We can call any key Value pair from the properties file.
        String url = properties.getProperty("url");// input key to get a value
        System.out.println("url = " + url);

        String browser = properties.getProperty("browser");
        System.out.println("browser = " + browser);


        // Getting keys or values, or both

        System.out.println("==============Values only ================");
        Collection<Object> values = properties.values();
        for(Object value:values){
            System.out.println(value);
        }
        System.out.println();
        System.out.println("=============Keys ony=====================");
        Set<Object> keys = properties.keySet();
        for(Object key:keys){
            System.out.println(key);
        }
        System.out.println();
        System.out.println("=========Key & Values together=============");
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
       for(Map.Entry<Object,Object>entry : entries){
           System.out.println(entry);
       }
    }
}
