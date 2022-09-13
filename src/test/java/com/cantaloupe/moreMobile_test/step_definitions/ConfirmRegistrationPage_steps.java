package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.ConfirmRegistrationPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class ConfirmRegistrationPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    ConfirmRegistrationPage confirmRegistrationPage = new ConfirmRegistrationPage();

    public ConfirmRegistrationPage_steps() throws IOException {
    }

    @And("User verifies that he is on the confirmation screen and sees the Good News and Thank you message")
    public void completeRegistration()
    {
        boolean goodNews = confirmRegistrationPage.verifyGoodNews();
        boolean thankyouForRegistering = confirmRegistrationPage.verifyThankYouMsg();
        Assert.assertTrue(goodNews && thankyouForRegistering);
    }
}