package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();
    @When("user add product to wishList")
    public void userAddProductToWishList() throws InterruptedException {
       home.wishList().get(2).click();
        Thread.sleep(2000);
    }

    @Then("success message will be displayed")
    public void successMessageWillBeDisplayed() {
        String expectedResult = "The product has been added to your";
        String actualResult = Hooks.driver.findElement(By.className("bar-notification")).getText();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String bgColor = Hooks.driver.findElement(By.className("bar-notification")).getCssValue("background-color");
        String bgCol = Color.fromString(bgColor).asHex();
        System.out.println("Background color is: "+ bgCol);
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @And("wishList item quantity will be displayed")
    public void wishlistItemQuantityWillBeDisplayed() {
       String quant = Hooks.driver.findElement(By.className("wishlist-qty")).getText();
        System.out.println("WishList Quantity is: "+ quant);
        //Assert.assertTrue(quant != 0);
        //Assert.assertEquals(quant, >0);
       // Assert.assertTrue(quant > 0);
//        AssertThat(quant, is(not(equalTo(0)))
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement bar_notification = Hooks.driver.findElement(By.id("bar-notification"));
        wait.until(ExpectedConditions.invisibilityOf(bar_notification));
        Hooks.driver.findElement(By.className("wishlist-label")).click();
    }
}
