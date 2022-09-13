package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.SignInWithExistingAccountPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class SignInWithExistingAccount_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    SignInWithExistingAccountPage signInWithExistingAccountPage = new SignInWithExistingAccountPage();
    private final String updatedEmail_forgotPassword = props.getProperty("more_mobile_updatedEmail_ForgotPassword");
    private final String updatedPassword_forgotPassword = props.getProperty("more_mobile_updatedPassword_forgotPassword");



    @And("The user see's that the {string} is in disabled mode")
    public void verifySignInDisabled_existingEmail(String signInButton) {
        signInWithExistingAccountPage.verifySignInDisabled(signInButton);
    }

    @When("user enters a valid email and updated password in respective field")
    public void enterEmailAndPassword() throws IOException, AWTException {
        signInWithExistingAccountPage.enterText(updatedEmail_forgotPassword, "email input field");
        signInWithExistingAccountPage.enterText(updatedPassword_forgotPassword, "password input field");
        signInWithExistingAccountPage.clickOn("sign in button");
    }
}

