package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void loginPage(){
        login.logBtn().click();
    }

    @When("user login with valid credentials {string} and {string}")
    public void userLoginWithValidCredentialsAnd(String arg0, String arg1) {
        login.userEmail().sendKeys(arg0);
        login.userPass().sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.entrLogin().submit();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Welcome to our store";
        String actualResult = Hooks.driver.findElement(By.className("topic-block-title")).getText();
        System.out.println(actualResult);
        softAssert.assertTrue(actualResult.contains(expectedResult));
        softAssert.assertAll();
    }


    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String arg0, String arg1) {
        login.userEmail().sendKeys(arg0);
        login.userPass().sendKeys(arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        String logErrorMsg = Hooks.driver.findElement(By.className("message-error")).getText();
        System.out.println("Login Error: "+ logErrorMsg);
        String errorMsgColor = Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        String msgCol = Color.fromString(errorMsgColor).asHex();
        System.out.println("Error message text color is:"+ msgCol);
        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
        String actualResult = Hooks.driver.findElement(By.className("message-error")).getText();
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertTrue(actualResult.contains(expectedResult));
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/login?returnurl=%2F");
        softAssert.assertAll();
    }


}
