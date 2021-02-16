package academy;

import Utilities.Readconfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    Readconfig readconfig = new Readconfig();
    String browserName = readconfig.getBrowser();//System.getProperty("browser");
    String appURL = readconfig.getApplicationURL();
    public static WebDriver driver;


    public WebDriver initializeDriver(){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",readconfig.getChroDriverPath());
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver",readconfig.getIEDriverPath());
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",readconfig.getEdgeDriverPath());
            driver = new EdgeDriver();
        }
        log.info(browserName+" is executed");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public String captureScreenshot(String testcasename, WebDriver driver) throws IOException {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH");
        String currentTime = date.format(new Date());
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = /*System.getProperty("user.dir")*/"D:\\Screenshots/"+"/reports/"+testcasename+".png";
       // String destination = "http://127.0.0.1:8887/reports"+testcasename+".png";
        FileUtils.copyFile(file, new File(destination));
        return destination;
    }

}
