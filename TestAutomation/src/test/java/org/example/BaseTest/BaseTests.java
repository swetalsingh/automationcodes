package org.example.BaseTest;

import org.apache.commons.io.FileUtils;
import org.example.Pages.ElectronicsPage;
import org.example.Pages.HomePage;
import org.example.amazon.factoey.SeleniumFactory;
import org.openqa.selenium.*;
import org.testng.Reporter;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTests {

    SeleniumFactory sf;
    Properties prop;
    protected WebDriver driver ;

    @BeforeClass
    public void setUp(){
        sf = new SeleniumFactory();
        prop = sf.initialise_Properties();
        driver = sf.initBrowser(prop);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String getCurrentMethodName(){
        return Reporter.getCurrentTestResult().getMethod().getMethodName();
    }


    public void TakeScreenshotForPage(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String DestinationFilePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "-" + System.currentTimeMillis()+ ".png";
        File DestinationFile = new File(DestinationFilePath);
        FileUtils.copyFile(source,DestinationFile);
    }

}