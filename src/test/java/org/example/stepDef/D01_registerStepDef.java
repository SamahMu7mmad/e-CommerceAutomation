package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.Color;


public class D01_registerStepDef {
    P01_register register = new P01_register();
    @Given("user go to register page")
        public void goRegisterPage(){
           register.registerBtn().click();
        }

    @When("user select gender type")
    public void userSelectGenderType() {
     register.gender().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstName().sendKeys(arg0);
        register.lastName().sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDay() {
        Select birthDay = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByIndex(24);
        Select birthMonth = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        birthMonth.selectByValue("10");
        Select birthYear = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        birthYear.selectByVisibleText("1988");
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.userEmail().sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.userPass().sendKeys(arg0);
        register.confirmPass().sendKeys(arg1);
    }

    @Then("user clicks on register button")
    public void userClicksOnRegisterButton() throws InterruptedException {
        register.regBtn().submit();
        Thread.sleep(3000);
    }

    @And("success message is displayed")
    public void successMessageIsDisplayed() {
        String successMsg = Hooks.driver.findElement(By.className("result")).getText();
        System.out.println(successMsg);
        String textColor = Hooks.driver.findElement(By.className("result")).getCssValue("color");

        String hexCol = Color.fromString(textColor).asHex();

        System.out.println(hexCol);
        String expectedResult = "Your registration completed";
        String actualResult = Hooks.driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
