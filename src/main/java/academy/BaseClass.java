package academy;

import Utilities.Readconfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    Readconfig readconfig = new Readconfig();
    String browserName = readconfig.getBrowser();
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

}
