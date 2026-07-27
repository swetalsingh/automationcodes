package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElectronicsPage {
    WebDriver driver;

    private By txt = By.xpath("//span[@class='a-list-item']//child::h2");

    public ElectronicsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean userOnElectronicsPage(){
        WebElement ElectronicsPageElement = driver.findElement(txt);
        System.out.println(ElectronicsPageElement.getText());
        return ElectronicsPageElement.isDisplayed();
    }
}
