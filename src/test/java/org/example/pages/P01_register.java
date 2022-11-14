package org.example.pages;

import org.example.stepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P01_register {
    public WebElement registerBtn(){
               return Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
           }
           public WebElement gender(){
               return Hooks.driver.findElement(By.id("gender-female"));
           }
           public WebElement firstName(){
             return Hooks.driver.findElement(By.id("FirstName"));
           }
           public WebElement lastName(){
               return Hooks.driver.findElement(By.name("LastName"));
           }
           public WebElement userEmail(){
               return Hooks.driver.findElement(By.id("Email"));
           }
           public WebElement userPass(){
               return Hooks.driver.findElement(By.id("Password"));
           }
           public WebElement confirmPass(){
             return Hooks.driver.findElement(By.id("ConfirmPassword"));
           }
           public WebElement regBtn(){
        return Hooks.driver.findElement(By.id("register-button"));
           }
//           public void successMsg(){
//               String successMsg = Hooks.driver.findElement(By.className("result")).getText();
//               System.out.println(successMsg);
//               String textColor = Hooks.driver.findElement(By.className("result")).getCssValue("color");
//               System.out.println(textColor);
//               String expectedResult = "Your registration completed";
//               String actualResult = Hooks.driver.findElement(By.className("result")).getText();
//               Assert.assertEquals(actualResult, expectedResult);
//               System.out.println("Actual Result is: "+ actualResult);
//           }

}
