package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.AddToAppleWallet;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class AddToAppleWallet_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    AddToAppleWallet addToAppleWallet = new AddToAppleWallet();


    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();

    public AddToAppleWallet_steps() throws IOException {
    }

    @Then("user should see the add to apple wallet button on the page and clicks on it")
    public void getPageSource()
    {
        Assert.assertTrue(addToAppleWallet.checkElementIsPresent("add to wallet button"));
        addToAppleWallet.clickOn("add to wallet button");
    }
}