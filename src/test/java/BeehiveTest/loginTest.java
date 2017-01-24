package BeehiveTest;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Kristof on 20/01/2017.
 */
public class loginTest
{
    private static WebDriver driver;
    public loginTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        //this.driver = new HtmlUnitDriver();
        this.driver = new ChromeDriver(options);
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
    @Ignore
    @Parameters({ "username", "password","website" })
    @Test
    public void testLoginParam(String username, String password,String website)
    {
        System.out.println("Testing login for user " + username + " with password " + password);
        //driver.get("http://172.16.62.26/#/");
        driver.get(website);
        getTitle();
        //Enter username
        driver.findElement(By.cssSelector("input[ng-model='user.username']")).sendKeys(username);
        //Enter password
        driver.findElement(By.cssSelector("input[ng-model='user.password']")).sendKeys(password);
        //Click submit or press enter
        driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).sendKeys(Keys.RETURN);
        //driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).click();
        wait(20);
        getTitle();
        //Find the webelement that signals we are logged in
        WebElement alert = driver.findElement(By.cssSelector("div[ng-if='lc.isLogin == true']"));
        //Test if the element is not null, or exists
        Assert.assertNotEquals(alert,null);
        //Wait

    }
    @Parameters({ "username", "password","website" })
    @Test(description = "test the session username with the username form the login parameters")
    public void testSessionLoginNameToUsernameParameter(String username, String password)
    {
        //Get sessions to find out if we are logged in with the correct username
        SessionStorage ss = new SessionStorage(driver);
        String userSession = ss.getItemFromSessionStorage("username");
        //String passSession = ss.getItemFromSessionStorage("password");
        //Get info from sessions
        System.out.println(username + " en password " + password);
        //System.out.println("Pagesource -> " +driver.getPageSource());
        //Test if the username from the session is the same as the username to log in
        Assert.assertEquals(username,userSession);
        //System.out.println("URL of the page is -> " +driver.getCurrentUrl());
        //Assert.assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/#/dashboard"));
    }
    @Ignore
    @Test
    public void testLogin()
    {
        System.out.println("Testing login with fixed username and password");
        driver.get("http://172.16.62.26/#/");
        getTitle();
        String username = "username";
        String password = "Password123";
        WebElement usernameInput = driver.findElement(By.cssSelector("input[ng-model='user.username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[ng-model='user.password']"));
        WebElement submit = driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submit.click();
        wait(20);
        getTitle();
        WebElement alert = driver.findElement(By.cssSelector("div[ng-if='lc.isLogin == true']"));
        Assert.assertNotEquals(alert,null);
        //Wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Get sessions
        SessionStorage ss = new SessionStorage(driver);
        String user = ss.getItemFromSessionStorage("username");
        String pass = ss.getItemFromSessionStorage("password");
        //Get info from sessions
        System.out.println(user + " en password " + password);
        //System.out.println("Pagesource -> " +driver.getPageSource());
        //
        Assert.assertEquals(username,user);
        System.out.println("URL of the page is -> " +driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://172.16.62.26/#/dashboard"));
    }
    @Parameters({ "website" })
    @Test(description = "Should be logged in before testing logout")
    public void testLogout(String website)
    {
        driver.get(website);
        //<input type="button" class="btn btn-danger" ng-click="lc.logout()" value="Logout">
        driver.findElement(By.cssSelector("input[ng-click='lc.logout()']")).click();
        //Test that we are not logged in anymore
        Assert.assertFalse(driver.getPageSource().contains("Welcome"));
    }
    @Parameters({ "badUsername", "badPassword","website" })
    @Test
    public void testBadLogin(String badUsername, String badPassword, String website)
    {
        System.out.println("Testing login with bad username and password, login should fail");
        //String username = "badUsernameDoenstExist";
        //String password = "notAPassword";
        driver.get(website);
        driver.findElement(By.cssSelector("input[ng-model='user.username']")).sendKeys(badUsername);
        driver.findElement(By.cssSelector("input[ng-model='user.password']")).sendKeys(badPassword);
        driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).click();
        //Wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Test if there is an error, as the login should fail
        WebElement alert = driver.findElement(By.cssSelector("label[ng-if='lc.error == 1']"));
        Assert.assertNotEquals(alert,null);
        //Test if there is a user in the session
        SessionStorage ss = new SessionStorage(driver);
        String username = ss.getItemFromSessionStorage("username");
        String pass = ss.getItemFromSessionStorage("password");
        //Get info from sessions
        System.out.println(username + " en password " + pass);
        //username should be null
        Assert.assertNotEquals(badUsername,username);

    }
    private void getTitle()
    {
        System.out.println("Title of the page is -> " + driver.getTitle());
    }
    private void wait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    @Parameters({ "badUsername", "badPassword","website" })
    @Test(description = "Test if we can login to the site without valid credentials")
    public void hackTheSite(String badUsername, String badPassword, String website)
    {
        driver.get(website);
        //Make sure we are on the website
        Assert.assertEquals(driver.getTitle(),"B-Central");
        SessionStorage ss = new SessionStorage(driver);
        ss.setItemInSessionStorage("username",badUsername);
        ss.setItemInSessionStorage("password",badPassword);
        driver.navigate().refresh();
    }
    @Parameters({ "username", "badPassword","website" })
    @Test
    public void shouldGiveErrorOnIncorrectPassword(String username, String badPassword, String website)
    {
        driver.get(website);
        wait(5);
        WebElement usernameInput = driver.findElement(By.cssSelector("input[ng-model='user.username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[ng-model='user.password']"));
        WebElement submit = driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']"));
        usernameInput.sendKeys("username");
        passwordInput.sendKeys("lolol");
        submit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement alert = driver.findElement(By.cssSelector("label[ng-if='lc.error == 1']"));
        Assert.assertNotEquals(alert,null);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Parameters({ "badUsername", "password","website" })
    @Test
    public void shouldGiveErrorOnNotExistingUsername(String badUsername, String badPassword, String website)
    {
        driver.get(website);
        wait(5);
        driver.findElement(By.cssSelector("input[ng-model='user.username']")).sendKeys(badUsername);
        driver.findElement(By.cssSelector("input[ng-model='user.password']")).sendKeys(badPassword);
        driver.findElement(By.cssSelector("input[ng-click='lc.login(user)']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement alert = driver.findElement(By.cssSelector("label[ng-if='lc.error == 1']"));
        Assert.assertNotEquals(alert,null);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown()
    {
        driver.close();
    }


}
