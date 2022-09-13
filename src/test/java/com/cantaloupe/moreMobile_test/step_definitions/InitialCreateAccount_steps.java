package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.CreateAccountPage;
import com.cantaloupe.moreMobile.pages.InitialCreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class InitialCreateAccount_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    InitialCreateAccountPage initialCreateAccountPage = new InitialCreateAccountPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    public InitialCreateAccount_steps() throws IOException {
    }

    @Then("User enters the email in the email input field")
    public void verifyEmailUniqueness() throws AWTException {
        String generatedEmail = initialCreateAccountPage.generateRandomEmailId();
        boolean isEmailValid = initialCreateAccountPage.verifyRegexEmail(generatedEmail);
        Assert.assertTrue(isEmailValid,  "The entered email is not valid");
    }

    @And("Look if the emailID is already registered")
    public void validateExisting_EmailError() throws AWTException {
        boolean isLoginEnabled = initialCreateAccountPage.isElementEnabled("login button");
        Assert.assertTrue(isLoginEnabled, "Email is not registered and should be unique");
    }

    @And("look if the account is already registered and skip registration by clicking on login button before cliking on {string}")
    public void validateExisting_EmailErrorandSkipRegistration(String nextButton) throws InterruptedException {
        if(initialCreateAccountPage.checkElementIsPresent("login button"))
        {
            Assert.fail("Email is unique");
        }
        else
        {
            initialCreateAccountPage.clickOn(nextButton);
            boolean getPasswordField = createAccountPage.checkElementIsPresent("password input field");
            Assert.assertTrue(getPasswordField, "Email is already registered");
        }
    }

    @And("user verifies if he is able to login by editing the {string}")
    public void editEmailAndLogin(String createpasswordInput) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11000));
        if(initialCreateAccountPage.checkElementIsPresent("login button"))
        {
            wait.until(ExpectedConditions.visibilityOf(initialCreateAccountPage.getWebElement("login button")));
            wait.until(ExpectedConditions.visibilityOf(initialCreateAccountPage.getWebElement("existing email error")));
            Assert.assertTrue( true, "Email is not in use");
        }
        else
        {
            initialCreateAccountPage.clickOn(createpasswordInput);
            boolean getPasswordField = createAccountPage.checkElementIsPresent("password input field");
            Assert.assertTrue(getPasswordField, "Login button is showing up and email should be already registered");
        }
    }

    @When("User enters a valid email and clicks on {string}")
    public void verifyEmailInput(String nextButton) throws InterruptedException, AWTException {
        verifyEmailUniqueness();
        validateExisting_EmailErrorandSkipRegistration(nextButton);
    }

    @When("user enters a valid email and clicks on next button")
    public void enterEmail() throws InterruptedException, AWTException {
        verifyEmailUniqueness();
        boolean isTickMarkPresent = initialCreateAccountPage.isTickMarkPresent();
        Assert.assertTrue(isTickMarkPresent);
        initialCreateAccountPage.clickOn("next button");
    }

    @When("user enters a valid {string} and clicks on {string}")
    public void verifyEmailInput(String email, String nextButton) throws InterruptedException, AWTException {
        initialCreateAccountPage.verifyEmailUniqueness(email);
        validateExisting_EmailErrorandSkipRegistration(nextButton);
    }

    @And("user should be seeing the login button for existing account")
    public void verifyLoginButton()
    {
        boolean checkLogin = initialCreateAccountPage.isLoginPresent();
        Assert.assertTrue(checkLogin, "Login button is not present for an existing account");
    }

    @Then("user sees login button on the screen")
    public void checkElementISPresentOrNot()
    {
        boolean isElementPresent = initialCreateAccountPage.checkElementIsPresent("login button");
        Assert.assertTrue(isElementPresent, "Login button is not displaying on the screen");
    }
}

