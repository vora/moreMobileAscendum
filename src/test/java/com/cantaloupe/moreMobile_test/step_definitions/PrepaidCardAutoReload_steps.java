package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.FAQPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardManualReloadPage;
import com.cantaloupe.moreMobile.pages.UpdateProfilePage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class PrepaidCardAutoReload_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    FAQPage faqPage = new FAQPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    PrepaidCardManualReloadPage prepaidCardManualReloadPage = new PrepaidCardManualReloadPage();
    UpdateProfilePage updateProfilePage = new UpdateProfilePage();

    private final String getMoreAutoReloadAddress = props.getProperty("more_mobile_AutoReloadAddress");




    public PrepaidCardAutoReload_steps() throws IOException {
    }
    @And("user fills out the remaining feilds on the auto reload page apart from credit card")
    public void fillRemaingForms_CC() {
        prepaidCardManualReloadPage.clickOn("cvv input field");
        prepaidCardManualReloadPage.selectFromDropDownListByContainingText("month dropdown", "March");
        prepaidCardManualReloadPage.selectFromDropDownListByContainingText("year dropdown", "2033");
        prepaidCardManualReloadPage.enterText("123", "cvv input field");
        prepaidCardManualReloadPage.clickOn("schedule reload button");
    }

    @And("user fills out the remaining feilds on the auto reload page apart from expiration month and year")
    public void fillRemaingForms_MonthYear() {
        prepaidCardManualReloadPage.clickOn("credit card number input field");
        prepaidCardManualReloadPage.clickOn("cvv input field");
        prepaidCardManualReloadPage.enterText("123", "cvv input field");
        prepaidCardManualReloadPage.clickOn("schedule reload button");
    }

    @And("user verifies if the email field is in non editable mode for auto reload")
    public void verifyEmailFieldISEditableOrNot() {
        boolean emailInputNotEditable = prepaidCardManualReloadPage.verifyEmailFieldISEditableOrNot("email input field");
        Assert.assertFalse(emailInputNotEditable, "Email field is in editable");
    }

    @Then("user sees that the value is present in the address field of auto flow and compares it against the registered value")
    public void nonEditableFields() {
        String actualEmailValue = prepaidCardManualReloadPage.verifyDataEdntered("address input field");
        Assert.assertEquals(actualEmailValue, getMoreAutoReloadAddress, "The data is not a match with the registered data ");
    }

    @Then("user will be see the alert pop up for {string} on the screen")
    public void checkstateAlertPopUp(String targetElement) {
        boolean isElementPresent = prepaidCardManualReloadPage.checkElementIsPresent(targetElement);
        Assert.assertTrue(isElementPresent, targetElement + " is not displayed on the screen");
    }


}