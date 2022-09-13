package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.AutoReloadCancelPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardDetailPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardReloadPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class PrepaidCardReloadPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    PrepaidCardReloadPage prepaidCardReloadPage = new PrepaidCardReloadPage();
    PrepaidCardDetailPage prepaidCardDetailPage = new PrepaidCardDetailPage();
    AutoReloadCancelPage autoReloadCancelPage = new AutoReloadCancelPage();
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String getMoreUserAddress = props.getProperty(("more_mobile_UserAddress"));

    public PrepaidCardReloadPage_steps() throws IOException {
    }


    @And("user looks for the status of reload and toggles it off if it is active")
    public void toggleOffAutoReload() {
        boolean isReloadActive = prepaidCardDetailPage.toggleOffAutoReload();
        Assert.assertTrue(isReloadActive, "Reload has not been done successfull and is not in active status");
        boolean butttonclick = prepaidCardReloadPage.toggleButtonStatus();
        Assert.assertTrue(butttonclick);
    }

    @And("user looks for the status of reload and toggles it on if it is active")
    public void toggleONAutoReload() {
        boolean isReloadActive = prepaidCardDetailPage.toggleOffAutoReload();
        Assert.assertFalse(isReloadActive, "Reload is successfull and in active status");
    }

    @And("user looks for the status of reload and cancels it through manual flow")
    public void cancelAutoReloadThroughManualFlow() {
        boolean isReloadActive = autoReloadCancelPage.cancelAutoReloadFlow();
        Assert.assertTrue(isReloadActive, "Reload has not been done successfull and is not in active status");
    }

    @Then("user clicks on wallet button and gets the pagesource")
    public void getPageSource()
    {
        prepaidCardReloadPage.checkElementIsPresent("add to wallet button");
        prepaidCardReloadPage.clickOn("add to wallet button");
        driver.findElement(By.xpath("//button[@]")).click();
        System.out.println("**********");
    }
}
