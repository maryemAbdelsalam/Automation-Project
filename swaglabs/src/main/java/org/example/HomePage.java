package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    public WebElement DropDownElement (WebDriver driver) {
        By classname = By.className("product_sort_container");
        WebElement DropDownElement = driver.findElement(classname);
        return DropDownElement;
    }

    public WebElement HighestElement (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"item_5_title_link\"]/div");
        WebElement HighestElement = driver.findElement(xpath);
        return HighestElement;
    }
    public WebElement Highestprice (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/div[3]");
        WebElement Highestprice = driver.findElement(xpath);
        return Highestprice;
    }
    public WebElement AddToCart (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");
        WebElement AddToCart = driver.findElement(xpath);
        return AddToCart;
    }
    public WebElement LowestElement (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"item_2_title_link\"]/div");
        WebElement LowestElement = driver.findElement(xpath);
        return LowestElement;
    }
    public WebElement Lowestprice (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/div[3]");
        WebElement Lowestprice = driver.findElement(xpath);
        return Lowestprice;
    }


}
