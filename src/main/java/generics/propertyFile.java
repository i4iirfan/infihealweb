package generics;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyFile implements utility{
    public static String getData(String key){
        Properties p = new Properties();
        try{
            p.load(new FileInputStream(propertyFilePath));
        }catch (Exception e){

        }
        return p.getProperty(key);
    }
}
