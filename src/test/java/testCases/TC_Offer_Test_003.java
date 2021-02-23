package test.java.testCases;

import main.java.academy.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TC_Offer_Test_003 extends BaseClass {

    WebDriver driver;

    @BeforeTest
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
    }

    @Test
    public void selectvegieTest(){

        List<WebElement> listOfVegies = driver.findElements(By.xpath("//div[@class='product']//h4"));
    }

    @AfterTest
    public void close(){
        driver.close();
    }

}
