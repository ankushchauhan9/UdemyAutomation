package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
            this.ldriver = rdriver;
    }

    private By userid = By.id("user_email");
    private By password = By.id("user_password");
    private By loginButton = By.cssSelector("input[value='Log In']");

    public void setLoginUsername(String usr){
        ldriver.findElement(userid).sendKeys(usr);
    }

    public void setLoginPassword(String pwd){
        ldriver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton(){
        ldriver.findElement(loginButton).click();
    }


}
