package org.example.BaseTest;

import org.apache.commons.io.FileUtils;
import org.example.setUp.testSetUp;
import org.openqa.selenium.*;
import org.testng.Reporter;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTests {

    testSetUp sf;
    Properties prop;
    protected WebDriver driver ;

    @BeforeClass
    public void setUp(){
        sf = new testSetUp();
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
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String DestinationFilePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "-" + System.currentTimeMillis()+ ".png";
        File DestinationFile = new File(DestinationFilePath);
        ImageIO.write(screenshot.getImage(),"PNG",DestinationFile);
    }

}