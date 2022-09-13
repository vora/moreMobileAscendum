package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.ForgotPasswordPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.awt.*;
import java.io.IOException;

public class ForgotPassword_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String updatedEmail_forgotPassword = props.getProperty("more_mobile_updatedEmail_ForgotPassword");
    private final String updatedPassword_forgotPassword = props.getProperty("more_mobile_updatedPassword_forgotPassword");
    private final String getMoreUrl = props.getProperty("more_mobile_Url");


    public ForgotPassword_steps() throws IOException {
    }

    @Then("user see's that the send me a rest link is in disabled mode")
    public void sendMeAResetLinkDisabled() {
        forgotPasswordPage.verifySendMeALinkStatus("send me a rest link");
    }

    @Then("user does not enter any data in the email input field")
    public void resetLinkStatus() {
        boolean hasData = forgotPasswordPage.checkFiedIsBlankOrHasData("forgot password email input");
        Assert.assertFalse(hasData);
    }


    @Then("a {string} message will be displaying for the wrong password or blank fields")
    public void displayeErrorMessages_Password(String wrongPasswordOrConfirmPassword) throws AWTException {
        boolean isErrorDisplayed = forgotPasswordPage.ErrorMessageForPasswordAndConfirmPassword(wrongPasswordOrConfirmPassword);
        Assert.assertTrue(isErrorDisplayed);
    }
}