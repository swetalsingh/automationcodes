package org.example.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    private By label = By.xpath("//a[@aria-label='Amazon.in']");
    private By signInButton = By.xpath("//div[@class='rhf-sign-in-button']//descendant::span[text()='Sign in']");
    private By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchIcon = By.xpath("//input[@id='nav-search-submit-button']");
    private By searchResults = By.xpath("//h2//child::span[contains(text(),'iphone')]");
    private By ElectronicsLink = By.xpath("//a[text()=' Electronics ']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public boolean userOnHomePage(){
        WebElement homePageElement = driver.findElement(label);
        WebElement signInButtonOnHomepage = driver.findElement(signInButton);

        if(homePageElement.isDisplayed() && signInButtonOnHomepage.isDisplayed()) {
            return true;
        }else{
            return false;
        }
    }

    public String pageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(label));
        String title = driver.getTitle();
        return title;
    }

    public String searchItem(){
        driver.findElement(searchBox).sendKeys("iphone");
        driver.findElement(searchIcon).click();
        return driver.findElement(searchResults).getText();
    }

    public void clickOnElectronicsLink(){
        driver.findElement(ElectronicsLink).click();
    }

}
