package com.javafortesters.junit;



import org.junit.Test;
import org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;

import static junit.framework.Assert.assertTrue;

public class MyFirstTest {

    @Test
    public void WebDriverTest() {
        WebDriver driver = new HtmlUnitDriver();
        //WebDriver driver = new ChromeDriver();
        driver.get("http://172.16.62.26/#/");
        assertTrue(driver.getTitle().startsWith("B-Central"));

    }
    @Test
    public void FirefoxDriver() {
        System.setProperty("webdriver.firefox.marionette","C:\\Program Files (x86)\\JetBrains\\IntelliJ IDEA Community Edition 2016.3.3\\geckodriver.exe");
        DesiredCapabilities capabilities=DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("http://172.16.62.26/#/");
        assertTrue(driver.getTitle().startsWith("B-Central"));
        driver.close();
    }
    @Test
    public void ChromeDriverTest() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kristof\\Dropbox\\3SWM\\Testing\\chromedriver.exe");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://172.16.62.26/#/");
        assertTrue(driver.getTitle().startsWith("B-Central"));
        //driver.close();
    }


}
