package test.java.testCases;

import main.java.academy.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_HomePageTitle_002 extends BaseClass {

    public WebDriver driver;

    @BeforeTest
    public void lauchBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Browser is initialized");
    }

    @Test
    public void homepageTitleTest() throws IOException {
        //driver = initializeDriver();
        String expectedTitle = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }


    @AfterTest
    public void close(){
        driver.close();
    }



}
