package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebElement CartElement(WebDriver driver) {
        By classname = By.id("shopping_cart_container");
        WebElement CartElement = driver.findElement(classname);
        return CartElement;
    }

    public WebElement ContShoppingElement(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
        WebElement ContShoppingElement = driver.findElement(xpath);
        return ContShoppingElement;
    }

    public WebElement Highestprice(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
        WebElement Highestprice = driver.findElement(xpath);
        return Highestprice;
    }

    public WebElement Lowestprice(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
        WebElement Lowestprice = driver.findElement(xpath);
        return Lowestprice;
    }

    public WebElement RandomItem(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"item_1_title_link\"]/div");
        WebElement RandomItem = driver.findElement(xpath);
        return RandomItem;
    }

    public WebElement AddRandomItem(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");
        WebElement AddRandomItem = driver.findElement(xpath);
        return AddRandomItem;
    }

    public WebElement RemoveRandomItem(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");
        WebElement RemoveRandomItem = driver.findElement(xpath);
        return RemoveRandomItem;
    }

    //*[@id="cart_contents_container"]/div/div[2]/a[2]
    public WebElement CheckOutElement(WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
        WebElement CheckOutElement = driver.findElement(xpath);
        return CheckOutElement;
    }
    public WebElement RemoveLowest (WebDriver driver) {
        By xpath = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button");
        WebElement RemoveLowest = driver.findElement(xpath);
        return RemoveLowest;
    }
    }


