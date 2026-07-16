package org.example;

import org.testng.annotations.Test;

public class TestUI extends BaseTests{
    LoginPage _loginPage ;

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        _loginPage = new LoginPage(driver);
        _loginPage.enterUserName();
        _loginPage.enterPassword();
        _loginPage.clickSignIn();
        _loginPage.logout();
        Thread.sleep(1000);
    }
}
