package com.qandoo.steps;
import com.qandoo.pages.HoversPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;


public class HoverPageStepDefinitions extends AbstractStepDefinitions{

    @Given("^I open hovers page$")
    public void iOpenHoverPage() throws Throwable {
        hoversPage = new HoversPage();
        hoversPage.openPage();
    }

    @And("^User info are not displayed$")
    public void userInfoAreNotDisplayed() throws Throwable {
        hoversPage.assertAllFigureCaptionsAreNotVisible();
    }

    @When("^I hover over (\\d+) user figures$")
    public void iHoverOverUserFigures(int userNumber) throws Throwable {
        hoversPage.hoverOverUserAvatar(userNumber);
    }

    @Then("^I see their names under each picture:$")
    public void iSeeUnderEachPicture(List<String> username) throws Throwable {
        hoversPage.assertFigureCaptionsAreVisible(username);
    }

}
