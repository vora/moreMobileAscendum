package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.ChangePasswordPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class UpdatePassword_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String moreMobile_OldPassword = props.getProperty("more_mobile_OldPassword");
    private final String moreMobile_NewPassword = props.getProperty("more_mobile_NewPassword");
    private final String moreMobile_ConfirmPassword = props.getProperty("more_mobile_ConfirmPassword");
    private final String invalid_moreMobile_OldPassword = props.getProperty("invalid_more_mobile_OldPassword");
    private final String invalid_moreMobile_NewPassword = props.getProperty("invalid_more_mobile_NewPassword");
    private final String invalid_moreMobile_ConfirmPassword = props.getProperty("invalid_more_mobile_ConfirmPassword");



    public UpdatePassword_steps() throws IOException {
    }

    @When("user updates the password field for {string} in {string}")
    public void updateMobileField(String newMobileNumber, String targetWebElement) throws AWTException, IOException {
        changePasswordPage.clickBackSpaceForPassword(targetWebElement);
    }


    @And("user verifies if there are any fields left blank for update password button to be active")
    public void checkFieldsForBlankData()
    {
        boolean oldPasword = changePasswordPage.checkFiedIsBlankOrHasData("old password input field");
        boolean newPassword = changePasswordPage.checkFiedIsBlankOrHasData("password input field");
        boolean confirmPassword = changePasswordPage.checkFiedIsBlankOrHasData("confirm password input field");

        Assert.assertTrue(oldPasword);
        Assert.assertTrue(newPassword);
        Assert.assertTrue(confirmPassword);
    }

    @And("user clicks on update button and a success alert pop up displays on the screen")
    public void verifyUpdatePassword()
    {
        changePasswordPage.clickOn("update password button");
        boolean isPopUpDisplayed = changePasswordPage.waitForElement("your password is updated text");
        Assert.assertTrue(isPopUpDisplayed, "Password update was not successfull");
    }

    @And("User clicks on update button and a athentication failure alert pop up displays on the screen")
    public void verifyAthenticationFailure()
    {
        changePasswordPage.clickOn("update password button");
        boolean isPopUpDisplayed = changePasswordPage.waitForElement("authentication failure alert pop up");
        Assert.assertTrue(isPopUpDisplayed, "Authentication failurealert pop up is not showing up");
    }

    @When("user enters valid old, new and confirm passwords in respective fields")
    public void enterPasswords()
    {
        changePasswordPage.enterText(moreMobile_OldPassword, "old password input field");
        changePasswordPage.enterText(moreMobile_NewPassword, "password input field");
        changePasswordPage.enterText(moreMobile_ConfirmPassword, "confirm password input field");
        changePasswordPage.scrollDown();

    }

    @When("user enters invalid old, new and confirm passwords in respective fields")
    public void enterInvalidPasswords()
    {
        changePasswordPage.enterText(invalid_moreMobile_OldPassword, "old password input field");
        changePasswordPage.enterText(moreMobile_NewPassword, "password input field");
        changePasswordPage.enterText(moreMobile_ConfirmPassword, "confirm password input field");
        changePasswordPage.scrollDown();

    }
}