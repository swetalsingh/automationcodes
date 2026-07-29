package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElectronicsPage {
    WebDriver driver;

    private By electronicsImg = By.xpath("//img[@alt='Electronics']");

    public ElectronicsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean userOnElectronicsPage(){
        WebElement ElectronicsPageElement = driver.findElement(electronicsImg);
        return ElectronicsPageElement.isDisplayed();
    }
}
