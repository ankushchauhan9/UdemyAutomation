package test.java.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudTesting {

    public static final String USERNAME = "automationTesting9898";
    public static final String ACCESS_KEY = "0aa2129a4de141aeb44c01468e509edf";//from sauce lab user setting
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String args[]) throws MalformedURLException {


        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability("platform","Windows 10");
        capabilities.setCapability("version","78.0");
        capabilities.setBrowserName("chrome");
        WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

    }

}
