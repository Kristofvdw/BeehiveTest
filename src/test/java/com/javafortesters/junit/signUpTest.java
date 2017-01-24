package com.javafortesters.junit;

/**
 * Created by Kristof on 19/01/2017.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.UUID;

import static junit.framework.Assert.assertTrue;

public class signUpTest  {
    @Test
    public void singUpTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        final WebDriver driver = new ChromeDriver(options);


        // Open website
        connectionTest testSite = new connectionTest();

        driver.get("http://172.16.62.26/#/register");

        // Find the link to registration form
        //WebElement link = driver.findElement(By.cssSelector("[data-name='Register']"));

        // Click the link
        //link.click();

        // Generate a random email
        final String randomEmail = randomEmail();
        final String randomUsername = randomUsername();
        // Find the email form field
        driver.findElement(By.id("username")).sendKeys(randomUsername);
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("cpassword")).sendKeys("password123");
        driver.findElement(By.id("firstname")).sendKeys("firstname");
        driver.findElement(By.id("lastnameinput")).sendKeys("lastnameinput");
        driver.findElement(By.id("adresinput")).sendKeys("adress 45");
        driver.findElement(By.id("postcodeinput")).sendKeys("3600");
        driver.findElement(By.id("mobileinput")).sendKeys("0479648234");
        driver.findElement(By.id("register-email")).sendKeys(randomEmail);

        // Type the random email to the form
        //email.sendKeys(randomEmail);

        // Find the password form field
        //WebElement password = driver.findElement(By.id("register-password"));

        // Type a password to the form. This needs not be unique.
        //password.sendKeys("John123");

        // Submit the sign up form
        //password.submit();
        driver.findElement(By.id("submitbutton")).click();
        // Check the sign up succeeded by checking that the randomized
        // email appears in the website's header bar.
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                //WebElement header = d.findElement(By.id("header-login"));
                return d.getCurrentUrl().equals("http://172.16.62.26/index.html#/");
            }
        });
        assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/index.html#/"));
        //Close the browser
        driver.quit();
    }

    private static String randomUsername() {
        return "randomUsername-" + UUID.randomUUID().toString();
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
}