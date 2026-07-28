package org.example.UItests;


import org.example.BaseTest.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTests {

    private final String titleOfPage = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    private final String expectedsearchresult = "\"iphone\"" ;

    @Test(enabled = true)
    public void verifyUserIsonHomePage(){
        boolean onHomePage = hp.userOnHomePage();
        Assert.assertTrue(onHomePage);
    }

    @Test(enabled = true)
    public void verifyPageTitle() throws IOException {
        String title =  hp.pageTitle();
        TakeScreenshotForPage(driver, getCurrentMethodName());
        Assert.assertEquals(title, titleOfPage);
    }

    @Test(enabled = true)
    public void verifySearchResults() throws IOException {
        String searchResults = hp.searchItem();
        TakeScreenshotForPage(driver, getCurrentMethodName());
        Assert.assertEquals(searchResults,expectedsearchresult);
    }



}
