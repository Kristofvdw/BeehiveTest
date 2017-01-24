package POMTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kristof on 24/01/2017.
 */
public class loginHeader extends BCentral
{
    public loginHeader(WebDriver driver)
    {
        super(driver);
    }
    public void setLogin(String username)
    {
        driver.findElement(By.cssSelector("input[ng-model='user.username']")).sendKeys(username);
    }
    public void setPassword(String password)
    {
        driver.findElement(By.cssSelector("input[ng-model='user.password']")).sendKeys(password);
    }
    public void clickLoginButton()
    {
        driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).click();
    }
    public void pressEnter()
    {
        driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).sendKeys(Keys.RETURN);
    }
    public boolean isLogin()
    {

        if(driver.findElement(By.className("Button")).getAttribute("value") == "Logout") {return true;}
        else {return false;}
        //By by = By.cssSelector("div[ng-if='lc.isLogin == true']");
        //return driver.findElements(by).size() > 0;
        /*Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return true;
        }
        else {return false;}*/
    }
    public void errorElement(String field)
    {
        String message = "ng-messages='RegisterForm." + field +  ".$error'";
        By by = new By.ByCssSelector(message);
    }

}
