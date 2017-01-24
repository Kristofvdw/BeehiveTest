package com.javafortesters.junit;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Kristof on 19/01/2017.
 */
public class LoginTest {
    public String username;
    public String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    private WebDriver driver;
    public LoginTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testLogin() {
        //http://www.software-testing-tutorials-automation.com/2015/04/data-driven-test-using-csv-file-in.html
        driver.get("http://172.16.62.26/#/");
        WebElement usernameInput = driver.findElement(By.cssSelector("input[ng-model='user.username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[ng-model='user.password']"));
        WebElement submit = driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']"));
        /*usernameInput.sendKeys(getUsername());
        passwordInput.sendKeys(getPassword());*/
        usernameInput.sendKeys("username");
        passwordInput.sendKeys("Password123");
        submit.click();

        /*Wait wait = new FluentWait(driver)

                .withTimeout(30, SECONDS)

                .pollingEvery(5, SECONDS)

                .ignoring(NoSuchElementException.class);

        WebElement alert = wait.until(new Function<>(){
            public WebElement apply(WebDriver driver)
            {
                driver.findElement(By.cssSelector("label[ng-if='lc.error == 1']"));
            }
        });*/
        try {
            sleep(2000);
        }
        catch (Exception ex) {}
        //WebElement alert = driver.findElement(By.cssSelector("label[ng-if='lc.error == 1']"));
        //Assert.assertNotEquals(alert,null);
        try {
            sleep(2000);
        }
        catch (Exception ex) {}
        finally {
            driver.close();
        }
    }
    @Test
    public void testRegister()
    {
        driver.get("http://172.16.62.26/index.html#/register");
        //driver.findElement(By.xpath("//a[@href='index.html#/register']")).click();
        /*List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement webElement :list
             ) {
            System.out.println(webElement.toString());
        }
        try {
            sleep(1000);
        }catch (Exception ex) {}
        */
        driver.findElement(By.name("RegisterForm"));

        Boolean isPresent = driver.findElements(By.name("RegisterForm")).size() > 0;
        assertTrue(isPresent);
        try {
            sleep(1000);
        }catch (Exception ex) {}
        fillRegisterForm();
    }
    public void fillRegisterForm()
    {
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("cpassword")).sendKeys("Password123");
        driver.findElement(By.id("firstname")).sendKeys("firstname");
        driver.findElement(By.id("lastnameinput")).sendKeys("lastnameinput");
        driver.findElement(By.id("adresinput")).sendKeys("adress 45");
        driver.findElement(By.id("postcodeinput")).sendKeys("3600");
        driver.findElement(By.id("mobileinput")).sendKeys("0479648234");
        driver.findElement(By.id("emailinput")).sendKeys("kristof@mail.be");
        driver.findElement(By.id("submitbutton")).click();
        try {
            sleep(2000);
        }catch (Exception ex) {}
        assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/index.html#/"));

    }
}
