package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
        public WebElement firstnameElement (WebDriver driver){
            By id = By.id("first-name");
            WebElement firstnameElement = driver.findElement(id);
            return firstnameElement;
        }
        public WebElement lastnameElement (WebDriver driver){
            By id = By.id("last-name");
            WebElement lastnameElement = driver.findElement(id);
            return lastnameElement;
        }
        public WebElement PostalCodeElement (WebDriver driver){
            By id = By.id("postal-code");
            WebElement PostalCodeElement = driver.findElement(id);
            return PostalCodeElement;
        }
        public WebElement ContinueElement (WebDriver driver){
            By xpath = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
            WebElement ContinueElement = driver.findElement(xpath);
            return ContinueElement;
        }
        public WebElement FinsishElement (WebDriver driver){
            By xpath = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");
            WebElement FinishElement = driver.findElement(xpath);
            return FinishElement;
        }
        public WebElement CompleteHeaderElement (WebDriver driver){
            By classname = By.className("complete-header");
            WebElement CompleteHeaderElement = driver.findElement(classname);
            return CompleteHeaderElement;
        }

        public WebElement CancelElement (WebDriver driver){
            By xpath = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[1]");
            WebElement CancelElement = driver.findElement(xpath);
            return CancelElement;
        }
        public WebElement ErrorMessage (WebDriver driver){
            By xpath = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3");
            WebElement ErrorMessage = driver.findElement(xpath);
            return ErrorMessage;
        }
    }



