package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTests{

    WebDriver driver ;
    @BeforeMethod
    @Parameters({"browser", "URL"})
    public void launchBrowser(String browser, String URL){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else{
            System.out.println("Please enter any two browsers from above");
        }

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public void TakeScreenshotForPage(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String DestinationFilePath = System.getProperty("user.dir") + "/screenshots/test_"+ System.currentTimeMillis();
        File DestinationFile = new File(DestinationFilePath);
        FileUtils.copyFile(source,DestinationFile);
    }

    @AfterMethod
    public void teardown(){
        if(!driver.equals("NULL")){
            driver.quit();
        }
    }
}