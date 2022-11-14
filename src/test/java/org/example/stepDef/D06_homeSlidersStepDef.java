package org.example.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class D06_homeSlidersStepDef {

    @When("user click on first slider")
    public void userClickOnFirstSlider() {
        List<WebElement>currentSlid =Hooks.driver.findElements(By.className("nivoSlider"));
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(currentSlid.get(0),"style","display: block;"));
        currentSlid.get(0).click();
    }

    @Then("product details page for Nokia is opened")
    public void productDetailsPageForNokiaIsOpened() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
        soft.assertAll();
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() {
        List<WebElement>currentSlid =Hooks.driver.findElements(By.className("nivoSlider"));
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(currentSlid.get(1),"style","display: block;"));
        currentSlid.get(1).click();
    }

    @Then("product details page for iphone is opened")
    public void productDetailsPageForIphoneIsOpened() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
        soft.assertAll();
    }
}
