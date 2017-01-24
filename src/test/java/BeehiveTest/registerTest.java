package BeehiveTest;

import com.javafortesters.junit.connectionTest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kristof on 20/01/2017.
 */
public class registerTest
{
    private static WebDriver driver;
    public registerTest()
    {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        //this.driver = new HtmlUnitDriver();
        driver = new ChromeDriver(options);
    }
    @BeforeTest
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        //this.driver = new HtmlUnitDriver();
        driver = new ChromeDriver(options);
    }
    @Test
    public void testRegister()
    {
        driver.get("http://172.16.62.26/index.html#/register");
        wait(5);
        getTitle();
        driver.findElement(By.name("RegisterForm"));
        Boolean isPresent = driver.findElements(By.name("RegisterForm")).size() > 0;
        assertTrue(isPresent);
        fillRegisterForm();
        //Wait and test
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/index.html#/"));
    }
    public void fillRegisterForm()
    {
        driver.findElement(By.id("username")).sendKeys("Mark");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("cpassword")).sendKeys("Password123");
        driver.findElement(By.id("firstname")).sendKeys("firstname");
        driver.findElement(By.id("lastnameinput")).sendKeys("lastnameinput");
        driver.findElement(By.id("adresinput")).sendKeys("adress 45");
        driver.findElement(By.id("postcodeinput")).sendKeys("3600");
        driver.findElement(By.id("mobileinput")).sendKeys("0479648234");
        driver.findElement(By.id("emailinput")).sendKeys("kristof@mail.be");
        driver.findElement(By.id("submitbutton")).click();
    }
    private void getTitle()
    {
        System.out.println("Title of the page is -> " + driver.getTitle());
    }

    @Test
    public void singUpTest()
    {
        driver.get("http://172.16.62.26/#/register");
        final String randomEmail = randomEmail();
        final String randomUsername = randomUsername();
        //wait(5);
        // Find the email form field
        driver.findElement(By.id("username")).sendKeys(randomUsername);
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("cpassword")).sendKeys("Password123");
        driver.findElement(By.id("firstname")).sendKeys("firstname");
        driver.findElement(By.id("lastnameinput")).sendKeys("lastnameinput");
        driver.findElement(By.id("adresinput")).sendKeys("adress 45");
        driver.findElement(By.id("postcodeinput")).sendKeys("3600");
        driver.findElement(By.id("mobileinput")).sendKeys("0479648234");
        driver.findElement(By.id("emailinput")).sendKeys(randomEmail);
        //Submit
        //wait(10);
        driver.findElement(By.id("submitbutton")).click();
        //wait(10);
        assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/#/"));
        //Close the browser
        System.out.println(randomUsername + " en rand email " + randomEmail);
        loginTest test = new loginTest();
        //Should be done in testsuite
        //test.testLoginParam(randomUsername,"Password123");
    }

    private static String randomUsername() {
        String unique = (UUID.randomUUID().toString()).substring(30);
        return "user" + unique;
    }

    private static String randomEmail() {
        String unique = (UUID.randomUUID().toString()).substring(30);
        return "e" + unique + "@example.com";
    }
    private void wait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    @Test
    public void itsOver9000()
    {
        for (int i = 0; i < 200; i++) {
            singUpTest();
        }
    }
    @AfterClass
    public static void tearDown()
    {
        driver.close();
    }
}
