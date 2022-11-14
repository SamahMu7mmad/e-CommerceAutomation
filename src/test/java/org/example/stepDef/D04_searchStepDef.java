package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();

    @When("user click on search field")
    public void userClickOnSearchField() {
        home.searchField().click();
    }

    @And("user search with {string}")
    public void userSearchWith(String arg0) {
        home.searchField().sendKeys(arg0);
    }

    @Then("user could find {string} relative results")
    public void userCouldFindRelativeResults(String arg0) {
        home.searchBtn().click();
    }
}
