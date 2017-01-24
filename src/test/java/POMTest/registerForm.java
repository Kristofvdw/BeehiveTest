package POMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
    *driver.findElement(By.id("username")).sendKeys("Mark");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("cpassword")).sendKeys("Password123");
        driver.findElement(By.id("firstname")).sendKeys("firstname");
        driver.findElement(By.id("lastnameinput")).sendKeys("lastnameinput");
        driver.findElement(By.id("adresinput")).sendKeys("adress 45");
        driver.findElement(By.id("postcodeinput")).sendKeys("3600");
        driver.findElement(By.id("mobileinput")).sendKeys("0479648234");
        driver.findElement(By.id("emailinput")).sendKeys("kristof@mail.be");
        //driver.findElement(By.id("submitbutton")).click();
     */
/**
 * Created by Kristof on 24/01/2017.
 */
public class registerForm extends BCentral {
    public registerForm(WebDriver driver) {
        super(driver);
    }
    public void setUsername(String username)
    {
        driver.findElement(By.id("username")).sendKeys(username);
    }
    public void setPassword(String password)
    {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    public void setConfirmPassword(String cpassword)
    {
        driver.findElement(By.id("cpassword")).sendKeys(cpassword);
    }
    public void setFirstName(String firstname)
    {
        driver.findElement(By.id("firstname")).sendKeys(firstname);
    }
    public void setLastName(String lastname)
    {
        driver.findElement(By.id("lastnameinput")).sendKeys(lastname);
    }
    //@Comment address is streetname + number
    public void setAddress(String address)
    {
        driver.findElement(By.id("adresinput")).sendKeys(address);
    }
    public void setPostCode(String postcode)
    {
        driver.findElement(By.id("postcodeinput")).sendKeys(postcode);
    }
    public void setMobile(String mobile)
    {
        driver.findElement(By.id("mobileinput")).sendKeys(mobile);
    }
    public void setEmail(String email)
    {
        driver.findElement(By.id("emailinput")).sendKeys(email);
    }

    public WebElement submitButton()
    {
        return driver.findElement(By.id("submitbutton"));
    }
    public void clickSubmit()
    {
        submitButton().click();
    }

    //Error messages
    public Boolean isFormSubmitted()
    {
        By by = new By.ByCssSelector("ng-if='RegisterForm.$submitted'");
        return driver.findElements(by).size() > 0;
    }
    public List<WebElement> getErrorMessages()
    {
        return driver.findElements(By.className("invalid label label-danger ng-scope"));
    }
    public WebElement getUsernameError()
    {
        By by = new By.ByCssSelector("RegisterForm.username.$error");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    public WebElement getPasswordError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.password.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    /*
    <label class="label label-danger ng-scope" ng-if="user.cpassword != user.password">Het controle wachtwoord komt niet overeen met het wachtwoord.</label>
     */
    public WebElement getConfirmPasswordError()
    {
        By by = new By.ByCssSelector("ng-if='user.cpassword != user.password'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    /*<span ng-if="RegisterForm.$submitted" ng-messages="RegisterForm.firstname.$error" class="ng-scope ng-active">
                        <!-- ngMessage: required --><span class="invalid label label-danger ng-scope" ng-message="required">De voornaam is verplicht.</span>
                        <!-- ngMessage: minlength --><!-- ngMessage: maxlength --><!-- ngMessage: pattern --></span>*/
    public WebElement getFirstNameError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.firstname.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    /*
    <span ng-if="RegisterForm.$submitted" ng-messages="RegisterForm.lastname.$error" class="ng-scope ng-active">
                        <!-- ngMessage: required --><span class="invalid label label-danger ng-scope" ng-message="required">De achternaam is verplicht.</span>
                        <!-- ngMessage: minlength -->
                        <!-- ngMessage: maxlength -->
                        <!-- ngMessage: pattern -->
                    </span>
     */
    public WebElement getLastNameError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.lastname.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    public WebElement getAdressError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.adres.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    public WebElement getPostCodeError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.postcode.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    public WebElement getMobileCodeError()
    {
        By by = new By.ByCssSelector("ng-messages='RegisterForm.mobile.$error'");
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }
    public WebElement getEmailError()
    {
        return errorElement("email");
    }
    public WebElement errorElement(String field)
    {
        String message = "ng-messages='RegisterForm." + field +  ".$error'";
        By by = new By.ByCssSelector(message);
        Boolean isPresent = driver.findElements(by).size() > 0;
        if(isPresent)
        {
            return driver.findElement(by);
        }
        else {return null;}
    }


}
