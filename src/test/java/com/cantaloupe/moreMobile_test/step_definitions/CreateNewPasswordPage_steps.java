package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.CreateNewPasswordPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;


public class CreateNewPasswordPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    CreateNewPasswordPage createNewPasswordPage = new CreateNewPasswordPage();


    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();

    public CreateNewPasswordPage_steps() throws IOException {
    }

    @When("user enters {string} and {string} in password and confirm password fields")
    public void verifyPasswordMatch(String password, String confirmPassword) {
        createNewPasswordPage.enterText(password, "password input field");
        createNewPasswordPage.enterText(confirmPassword, "confirm password input field");
    }

    @Then("user sees the update button indisabled mode and password meets criteria on the screen")
    public void disableButton()
    {
        boolean isButtonEnabled = createNewPasswordPage.isButtonOrLinkEnabled("update password button");
        boolean isElementDisplayed = createNewPasswordPage.checkElementIsPresent("password meets criteria");
        Assert.assertFalse(isButtonEnabled, "Button is in enabled mode");
        Assert.assertTrue(isElementDisplayed, "Password meets criteria text is not displaying for the password field");
    }

}