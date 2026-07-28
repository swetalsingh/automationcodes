package org.example.UItests;

import org.example.BaseTest.BaseTests;
import org.example.Pages.ElectronicsPage;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElectronicsPageTest extends BaseTests {

    private HomePage hp;
    private ElectronicsPage ep;

    @BeforeClass
    public void init_pages(){
        hp = new HomePage(driver);
        ep = new ElectronicsPage(driver);
    }

    @Test(enabled = true)
    public void verifyNavigationToElectronicsPage() throws IOException {
        hp.clickOnElectronicsLink();
        TakeScreenshotForPage(driver, getCurrentMethodName());
        boolean onElectronicsPage = ep.userOnElectronicsPage();
        Assert.assertTrue(onElectronicsPage);
    }
}
