package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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

    public void alertaccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }catch(NoAlertPresentException e){
            System.out.println(e);
        }
    }

    @AfterMethod
    public void teardown(){
        if(!driver.equals("NULL")){
            driver.quit();
        }
    }
}