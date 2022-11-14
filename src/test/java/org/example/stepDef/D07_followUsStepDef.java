package org.example.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage home = new P03_homePage();
    @When("user opens facebook link")
    public void userOpensFacebookLink() {
        home.fbLink().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Before switch: "+Hooks.driver.getCurrentUrl());
    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        home.twitterLink().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        home.rssLink().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        home.youtubeLink().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("link is opened in new tab {string}")
    public void linkIsOpenedInNewTab(String obj) {
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));

        System.out.println("After switch: "+Hooks.driver.getCurrentUrl());

        String actualResult = Hooks.driver.getCurrentUrl();
        SoftAssert soft =  new SoftAssert();
        soft.assertEquals(actualResult, obj);

        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));

        soft.assertAll();
    }

}
