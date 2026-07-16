package org.example;

import org.openqa.selenium.By;

public class LoginPageObjects {
    By UserName = By.xpath("//input[@name='username']");
    By Password = By.name("password");
    By Login = By.xpath("//button[text()=' Login ']");
    By dropdownForLogout = By.xpath("//i[contains(@class,'bi-caret-down-fill')]");
    By Logout = By.xpath("//*[text()='Logout']");
}
