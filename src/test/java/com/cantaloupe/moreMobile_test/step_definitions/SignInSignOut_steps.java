package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.page.SignInWithExistingAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;


public class SignInSignOut_steps {

    SignInWithExistingAccountPage signInWithExistingAccountPage = new SignInWithExistingAccountPage();

    public SignInSignOut_steps() throws IOException {
    }

    @Then("user should see {string} error for {string}")
    public void verifyBlankErrorForEmail(String expectedErrorMessage, String targetWebElement)
    {
        String actualErrorMessage = signInWithExistingAccountPage.validateErrorMessages(targetWebElement);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Both the errors are not same");
    }


    @Then("user enters the {string} in the password input field")
    public void enterPassword(String password) throws AWTException {
        boolean isPasswordFieldEnabled = signInWithExistingAccountPage.isElementEnabled("password input field");
        signInWithExistingAccountPage.enterText(password, "password input field");
        Assert.assertTrue(isPasswordFieldEnabled,  "The entered password is not valid");
    }

    @And("user verifies that the {string} will not be displaying on the screen")
    public void checkElementISPresentOrNot(String targetElement)
    {
        boolean isElementPresent = signInWithExistingAccountPage.isElementDislayed(targetElement);
        Assert.assertFalse(isElementPresent, "Element is available on the screen");
    }

    @Then("user verifies if {string} error for {string} on entering {string} in {string}")
    public void verifyBlankErrorForEmail(String expectedErrorMessage, String targetWebElement, String wrongEmail, String emailInputfield)
    {
        signInWithExistingAccountPage.enterText(wrongEmail, emailInputfield);
        String actualErrorMessage = signInWithExistingAccountPage.validateErrorMessages(targetWebElement);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error displayed on screen is not a match with the expected data");
    }

    @When("user focus on password field and moves out of it")
    public void focusOnFields()
    {

        signInWithExistingAccountPage.focusOnFields("password input field");
        signInWithExistingAccountPage.focusOnFields("email input field");
    }

    @And("user verifies the data for email and password field is blank")
    public void verifyBlankFields()
    {
        signInWithExistingAccountPage.focusOnFields("email input field");
        String emailValue = signInWithExistingAccountPage.getEneteredValue("email input field");
        signInWithExistingAccountPage.focusOnFields("password input field");
        String passwordValue = signInWithExistingAccountPage.getEneteredValue("password input field");
        Assert.assertTrue(emailValue.equals("") && passwordValue.equals(""), "The fields are not blank");
    }

    @And("user see's an alert pop up displaying on the screen")
    public void verifyAlertPopUp()
    {
        boolean isAlertdisplayed = signInWithExistingAccountPage.verifyAlertPopUp();
        Assert.assertTrue(isAlertdisplayed, "Alert pop up is not displayed");
    }



}