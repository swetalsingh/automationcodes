package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    WebDriver driver ;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    LoginPageObjects _objectsForLogin = new LoginPageObjects();
    LeavesPageObjects _lop = new LeavesPageObjects();

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


    public void clickOnLeave() {
        driver.findElement(_objectsForLogin.leaveMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(_lop.LeaveList));
    }

    public void logout(){
        driver.findElement(_objectsForLogin.dropdownForLogout).click();
        driver.findElement(_objectsForLogin.Logout).click();
    }
}
