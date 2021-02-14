package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

    Properties prop;
    public Readconfig(){

        String configFilePath = System.getProperty("user.dir")+"/Configuration/config.properties";
        try{
            File file = new File(configFilePath);
            FileInputStream inputStream = new FileInputStream(file);
            prop = new Properties();
            prop.load(inputStream);
        }catch(Exception e){
           System.out.println("configuration file not found");
        }
    }

    public String getApplicationURL(){
        String appURL = prop.getProperty("appURL");
        return appURL;
    }

    public String getBrowser(){
        String browserName = prop.getProperty("browser");
        return browserName;
    }


    public String getChroDriverPath(){
        String chroPath = prop.getProperty("chromepath");
        return chroPath;
    }


    public String getEdgeDriverPath(){
        String edgePath = prop.getProperty("edgepath");
        return  edgePath;
    }


    public String getIEDriverPath(){
        String iePath = prop.getProperty("iepath");
        return iePath;
    }

}
