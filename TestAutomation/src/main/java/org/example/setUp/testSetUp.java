package org.example.setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class testSetUp {

   WebDriver driver;
   Properties prop;

    public WebDriver initBrowser(Properties prop){

        String browserName = prop.getProperty("browserName");
        String URL = prop.getProperty("URL");
        Boolean isHeadless = Boolean.valueOf(prop.getProperty("headless"));

        switch(browserName.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Please pass the browser name");
                break;
        }

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public Properties initialise_Properties(){

        try {
            FileInputStream fs = new FileInputStream("./properties/configProperties");
            prop = new Properties();
            prop.load(fs);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
