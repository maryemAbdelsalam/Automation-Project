package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement usernameElement(WebDriver driver){
        By username = By.id("user-name");
        WebElement usernameElement = driver.findElement(username);
        return usernameElement;
    }
    public WebElement passwordElement(WebDriver driver) {
        By password = By.id("password");
        WebElement passwordElement = driver.findElement(password);
        return passwordElement;
    }
    public WebElement LoginButtonElement(WebDriver driver) {
        By loginButton = By.id("login-button");
        WebElement LoginButtonElement = driver.findElement(loginButton);
        return LoginButtonElement;
    }
    public WebElement ErrorMessage (WebDriver driver) {
        By error = By.className("error-button");
        WebElement ErrorMessage = driver.findElement(error);
        return ErrorMessage;
    }
}
