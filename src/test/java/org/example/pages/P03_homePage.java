package org.example.pages;

import org.example.stepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {
    public List<WebElement> currencyList() {
        WebElement currencyList = Hooks.driver.findElement(By.id("customerCurrency"));

        List<WebElement> currencies = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return currencies;
    }

    public WebElement searchField() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn() {
        return Hooks.driver.findElement(By.className("search-box-button"));
    }
    public WebElement fbLink(){
        return Hooks.driver.findElement(By.className("facebook"));
    }

    public WebElement twitterLink(){
        return Hooks.driver.findElement(By.className("twitter"));
    }
    public WebElement rssLink(){
        return Hooks.driver.findElement(By.className("rss"));
    }
    public WebElement youtubeLink(){
        return Hooks.driver.findElement(By.className("youtube"));
    }
    public List<WebElement> wishList(){
        List<WebElement>wishItms = Hooks.driver.findElements(By.className("add-to-wishlist-button"));
        return wishItms;
    }
}

