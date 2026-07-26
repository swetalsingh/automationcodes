package org.example;

import org.openqa.selenium.By;

public class LeavesPageObjects {

    By LeaveList = By.xpath("//a[text()='Leave List']");
    private By assignleave = By.xpath("//a[text()='Assign Leave']");
    private By employeeName = By.xpath("//input[@placeholder= 'Type for hints...']");

}
