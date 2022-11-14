package org.example.stepDef;

import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {
//    P03_homePage home = new P03_homePage();
//    String category;
    @When("user hoover category and select sub-cat")
    public void hooverCat_Sub(){
//        WebElement category = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
//        Actions hover = new Actions(Hooks.driver);
//        hover.moveToElement(category).perform();
//
//        Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]")).click();

        List<WebElement> categories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
        int rand = new Random().nextInt(3);

//hoover
        Actions hoover = new Actions(Hooks.driver);
        hoover.moveToElement(categories.get(rand)).perform();
        System.out.println("Main category: "+categories.get(rand).getText());

        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        rand = rand+1;
        List<WebElement> subcategory =Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+rand+"]/ul[@class=\"sublist first-level\"]/li"));

        if(subcategory.isEmpty())
        {
            String category = categories.get(rand).getText();
            categories.get(rand).click();
            String pageTitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
            Assert.assertTrue(pageTitle.toLowerCase().contains(category.toLowerCase()));
        }
        else {
            int randSub = new Random().nextInt(3);
            String subcat = subcategory.get(randSub).getText();  //assert
            subcategory.get(randSub).click();

            String pageTitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
            Assert.assertTrue(pageTitle.toLowerCase().contains(subcat.toLowerCase()));
        }

        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
