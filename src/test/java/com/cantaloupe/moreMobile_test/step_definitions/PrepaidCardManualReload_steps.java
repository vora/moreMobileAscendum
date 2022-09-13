package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.FAQPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardReloadPage;
import com.cantaloupe.moreMobile.pages.UpdateProfilePage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class PrepaidCardManualReload_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    FAQPage faqPage = new FAQPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    PrepaidCardReloadPage prepaidCardReloadPage = new PrepaidCardReloadPage();
    UpdateProfilePage updateProfilePage = new UpdateProfilePage();

    private final String getMoreUserAddress = props.getProperty("more_mobile_UserAddress");




    public PrepaidCardManualReload_steps() throws IOException {
    }

    @And("user fills out the remaining feilds on the manual reload page apart from credit card")
    public void fillRemaingForms_CC() {
        prepaidCardReloadPage.clickOn("cvv input field");
        prepaidCardReloadPage.selectFromDropDownListByContainingText("month dropdown", "March");
        prepaidCardReloadPage.selectFromDropDownListByContainingText("year dropdown", "2033");
        prepaidCardReloadPage.enterText("123", "cvv input field");
        prepaidCardReloadPage.clickOn("reload card button");
    }

    @And("user fills out the remaining feilds on the manual reload page apart from expiration month and year")
    public void fillRemaingForms_MonthYear() {
        prepaidCardReloadPage.clickOn("credit card number input field");
        prepaidCardReloadPage.clickOn("cvv input field");
        prepaidCardReloadPage.enterText("123", "cvv input field");
        prepaidCardReloadPage.clickOn("reload card button");
    }

    @Then("user sees that the value is present in the address field of manual flow and compares it against the registered value")
    public void nonEditableFields() {
        String actualAddressValue = prepaidCardReloadPage.verifyDataEdntered("address input field");
        Assert.assertEquals(actualAddressValue, getMoreUserAddress, "The data is not a match with the registered data ");
    }

}