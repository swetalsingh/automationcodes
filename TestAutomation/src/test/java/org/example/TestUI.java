package org.example;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestUI extends BaseTests{
    LoginPage _loginPage ;

    @Test(priority = 1, enabled = true)
    public void loginTest() throws InterruptedException, IOException {
        _loginPage = new LoginPage(driver);
        _loginPage.enterUserName();
        _loginPage.enterPassword();
        TakeScreenshotForPage(driver);
        _loginPage.clickSignIn();

        _loginPage.clickOnLeave();
       // _loginPage.logout();
    }
}
