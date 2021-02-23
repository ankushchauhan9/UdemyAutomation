package test.java.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;

public class DownloadFileTest {

    static WebDriver driver;
    //https://www.phptravels.net/
    //https://s1.demo.opensourcecms.com/s/44
    //http://the-internet.herokuapp.com/ -->
    public static void main(String args[]){
        String downloadPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",downloadPath+"/Drivers/chromedriver.exe");
        HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);

        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("File Download")).click();
        driver.findElement(By.linkText("text-sample2.txt")).click();

        File file = new File(downloadPath+"/text-sample2.txt");
        if(file.exists()){
                System.out.println("file found!!!!");
                Assert.assertTrue(file.exists());
                if(file.delete()) {
                    System.out.println("file deleted succcessfully");
                }
        }


    }



}
