package org.example;

import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class LoginPage
{
    WebDriver driver ;
    LoginPageObjects _objectsForLogin = new LoginPageObjects();

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUserName(){
         driver.findElement(_objectsForLogin.UserName).sendKeys("Admin");
    }

    public void enterPassword(){
        driver.findElement(_objectsForLogin.Password).sendKeys("admin123");
    }

    public void clickSignIn(){
          driver.findElement(_objectsForLogin.Login).click();
    }

    public void logout(){
        driver.findElement(_objectsForLogin.dropdownForLogout).click();
        driver.findElement(_objectsForLogin.Logout).click();
    }
}
