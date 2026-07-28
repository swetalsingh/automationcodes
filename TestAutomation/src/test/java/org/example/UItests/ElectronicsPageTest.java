package org.example.UItests;

import org.example.BaseTest.BaseTests;
import org.example.Pages.ElectronicsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElectronicsPageTest extends BaseTests {


    @Test(enabled = true)
    public void verifyNavigationToElectronicsPage() throws IOException {
        hp.clickOnElectronicsLink();
        TakeScreenshotForPage(driver, getCurrentMethodName());
        boolean onElectronicsPage = ep.userOnElectronicsPage();
        Assert.assertTrue(onElectronicsPage);
    }
}
