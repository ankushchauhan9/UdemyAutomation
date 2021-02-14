package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver hmpdriver;
    public HomePage(WebDriver rmdriver){
            this.hmpdriver = rmdriver;
    }

   private By signIn = By.cssSelector("a[href*='sign_in']");


    public void clickHomepageLogin(){
         hmpdriver.findElement(signIn).click();
    }
}
