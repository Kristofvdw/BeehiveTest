package POMTest;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by Kristof on 24/01/2017.
 */
public class BCentral
{
    private static WebElement element = null;
    private static String address = "http://172.16.62.26/#/";
    WebDriver driver;
    public BCentral(WebDriver driver)
    {
        this.driver = driver;
    }
    public void pressHeaderLink()
    {
        driver.findElement(By.className("col-sm-6")).click();
    }
    public String getTitle()
    {
        return driver.getTitle();
    }
    public WebElement getElement(String name)
    {
        return driver.findElement(By.cssSelector(name));
    }
    public String getSiteAdress()
    {
        return address;
    }
    public void goToSite()
    {
        driver.get(address);
    }


}
