package main.java.academy;

import Utilities.Readconfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    Readconfig readconfig = new Readconfig();
    String browserName = readconfig.getBrowser();//System.getProperty("browser");
    String appURL = readconfig.getApplicationURL();
    public WebDriver driver;
    public static final String USERNAME = "automationTesting9898";
    public static final String ACCESS_KEY = "0aa2129a4de141aeb44c01468e509edf";//from sauce lab user setting
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public WebDriver initializeDriver() throws IOException {
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",readconfig.getChroDriverPath());
            /*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(browserName);
            capabilities.setCapability("platform","Windows 10");
            capabilities.setCapability("version","78");
            driver = new RemoteWebDriver(new URL(URL), capabilities);*/
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver",readconfig.getIEDriverPath());
            /*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setBrowserName("IE");
            capabilities.setCapability("platform","Windows 10");
            capabilities.setCapability("version","79");
            driver = new RemoteWebDriver(new URL(URL), capabilities);*/
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",readconfig.getEdgeDriverPath());
            /*MutableCapabilities sauceOptions = new MutableCapabilities();

            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setCapability("platformName", "Windows 10");
            browserOptions.setCapability("browserVersion", "latest");
            browserOptions.setCapability("sauce:options", sauceOptions);
            driver = new RemoteWebDriver(new URL(URL), browserOptions);*/
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
