package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
            this.driver = driver;
    }

    private By userid = By.id("user_email");
    private By password = By.id("user_password");
    private By loginButton = By.cssSelector("input[value='Log In']");

    public void setLoginUsername(String usr){
        driver.findElement(userid).sendKeys(usr);
    }

    public void setLoginPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


}
