package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
            this.driver = driver;
    }

   private By signIn = By.cssSelector("a[href*='sign_in']");



    public void clickHomepageLogin(){
         driver.findElement(signIn).click();
    }
}
