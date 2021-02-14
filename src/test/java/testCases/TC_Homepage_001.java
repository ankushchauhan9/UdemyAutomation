package testCases;

import academy.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_Homepage_001 extends BaseClass {

    WebDriver driver;

    @BeforeTest
    public void lauchBrowser(){
        driver = initializeDriver();
    }

    @Test (dataProvider = "LoginData")
    public void test(String username, String password){
        driver = initializeDriver();
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

    @AfterTest
    public void close(){
        driver.close();
    }

}
