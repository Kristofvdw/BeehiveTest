package POMTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Kristof on 24/01/2017.
 */
public class TestSuite
{
    WebDriver driver;
    loginHeader objLogin;
    @BeforeClass
    public static void setupClass() {
        //ChromeDriverManager.getInstance().setup();
    }
    @BeforeTest
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver();
    }
    @Parameters({ "username", "password"})
    @Test
    public void testIfCanLogin(String username, String password) {
        objLogin = new loginHeader(driver);
        System.out.println("Testing login for user " + username + " with password " + password);
        objLogin.goToSite();
        assertTrue(objLogin.getTitle().startsWith("B-Central"));
        objLogin.setLogin(username);
        objLogin.setPassword(password);
        objLogin.pressEnter();
        //TestSuite if the element is not null, or exists
        Assert.assertTrue(objLogin.isLogin());
    }
    @Test
    public void goToWebsite()
    {
        objLogin = new loginHeader(driver);
        objLogin.goToSite();
        assertTrue(objLogin.getTitle().startsWith("B-Central"));
    }
    @Parameters({ "badUsername", "badPassword"})
    @Test
    public void shouldGiveErrorOnIncorrectPassword(String username, String password)
    {
        objLogin = new loginHeader(driver);
        System.out.println("Testing login for user " + username + " with password " + password);
        objLogin.goToSite();
        assertTrue(objLogin.getTitle().startsWith("B-Central"));
        objLogin.setLogin(username);
        objLogin.setPassword(password);
        objLogin.pressEnter();
        //TestSuite if the element is not null, or exists
        Assert.assertFalse(objLogin.isLogin());
    }
    @Test
    public void shouldGiveErrorOnNotExistingUsername()
    {

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
