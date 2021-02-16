package test.testCases;

import academy.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_Homepage_001 extends BaseClass {

    public Logger log = LogManager.getLogger(TC_Homepage_001.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void lauchBrowser(){
        driver = initializeDriver();
        log.info("Browser is initialized");
    }

    @Test
    public void Login(){
        HomePage hp = new HomePage(driver);
        hp.clickHomepageLogin();
        log.info("Clicked on Login on Home page");
        LoginPage lp = new LoginPage(driver);
        lp.setLoginUsername("username");
        log.info("user name is entered");
        lp.setLoginPassword("password");
        log.info("password is entered");
        lp.clickLoginButton();
        log.info("click submit button is clicked");
        Assert.assertEquals(driver.getTitle(),"WebServices Testing using Soap");
        log.info("login successfully!!!");
    }
/*

    //@Test (dataProvider = "LoginData")
    public void test(String username, String password){

        HomePage hp = new HomePage(driver);
        hp.clickHomepageLogin();
        LoginPage lp = new LoginPage(driver);
        lp.setLoginUsername(username);
        lp.setLoginPassword(password);
        lp.clickLoginButton();
       // driver.navigate().refresh();
    }

    @DataProvider (name = "LoginData")
    public Object[][] getData(){

        Object [][] data = {{"abc@gmail.com","12345"},{"pqr@gmail.com","1234"},{"qwer@gmail.com","123123"}};
        return data;
    }
*/

    @AfterTest
    public void close(){
        driver.close();
    }

}
