package com.qandoo.steps;

import com.qandoo.pages.FlashMessageAlert;
import com.qandoo.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStepDefinitions extends AbstractStepDefinitions{

    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        loginPage.pressLoginButton();
    }

    @Given("^I open login page$")
    public void iOpenLoginPage() throws Throwable {
        loginPage = new LoginPage();
        loginPage.openPage();
    }

    @When("^I fill in username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iFillInUsernameAndPassword(String username, String password) throws Throwable {
        loginPage.fillLoginCredentials(username, password);
    }

    @Then("^\"([^\"]*)\" is displayed on the page$")
    public void isDisplayedOnThePage(String msg) throws Throwable {
        FlashMessageAlert flash = new FlashMessageAlert();
        flash.assertAlertMessageIsEqualTo(msg);
    }

}
