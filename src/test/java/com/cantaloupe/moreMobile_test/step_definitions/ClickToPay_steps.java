package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.ClickToPayPage;
import com.cantaloupe.moreMobile.page.PrepaidCardManualReloadPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ClickToPay_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    ClickToPayPage clickToPayPage = new ClickToPayPage();
    PrepaidCardManualReloadPage prepaidCardManualReloadPage = new PrepaidCardManualReloadPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String masterCardNumber = props.getProperty("more_mobile_masterCardNumber");
    private final String masterCardCVV = props.getProperty("more_mobile_masterCardCVV");
    private final String prefilledEmail = props.getProperty("more_mobile_prefilledEmail");
    private final String prefilledCountry = props.getProperty("more_mobile_prefilledCountry");
    private final String prefilledMobile = props.getProperty("more_prefilledMobile");
    private final String clickToPayPhoneNoEditValue = props.getProperty("clickToPayPhoneNoEditValue");
    private final String expiryMonth = props.getProperty("expiryMonth");
    private final String expiryYear = props.getProperty("expiryYear");

    @When("user enters card number, expiry date and cvv in respective fields and clicks on click to pay button")
    public void enterCardCvvAndExpiry() {
        prepaidCardManualReloadPage.enterText(masterCardNumber, "credit card number input field");
        prepaidCardManualReloadPage.readDropdownValueByString(expiryMonth, "month dropdown");
        prepaidCardManualReloadPage.readDropdownValueByString(expiryYear, "year dropdown");
        prepaidCardManualReloadPage.enterText(masterCardCVV, "cvv input field");
        clickToPayPage.clickOn("enroll in click to pay button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Then("toggle button will be displayed under security code field for the first time user")
    public void verifyClikToPayTogglebutton() {
        boolean checkTogglestatus = clickToPayPage.checkElementIsPresent("toggle button");
        Assert.assertTrue(checkTogglestatus, "Toggle button is not displayed on the screen");
    }

    @And("user deactivates the click to pay by turning the toggle button off and sees classic manual reload screen")
    public void deactivateTClickToPay() {
        boolean isToggleEnabled = clickToPayPage.toggleButtonStatus();
        Assert.assertTrue(isToggleEnabled, "Toggle button is not in enabled mode to turn it off");
        boolean isAddressCheckboxDisplayed = clickToPayPage.isElementInEnabledMode("address check box");
        Assert.assertTrue(isAddressCheckboxDisplayed, "Classic manual reload csreen is not showing up");
    }

    @And("user should be displayed with master card registration modal pop up")
    public void enrollInClickToPay() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("click to pay iframe")));
        clickToPayPage.waitForElement("click to pay iframe");
        WebElement clickToPayModalPopUp = clickToPayPage.getWebElement("click to pay iframe");
        Assert.assertTrue(clickToPayModalPopUp.isDisplayed(), "Click to pay modal pop up is not showing up");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11000));
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("click to pay iframe")));
        driver.switchTo().frame(clickToPayModalPopUp);
    }

    @And("user clicks on cross icon and confirmation pop up will be displayed")
    public void closeRegistrationPopUp() {
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("close icon")));
        clickToPayPage.waitForElement("close icon");
        clickToPayPage.clickOn("close icon");
        Assert.assertTrue(clickToPayPage.checkElementIsPresent("return to merchant button"));
    }

    @And("user sees the continue button on the modal pop up")
    public void clickToPayProfile() {
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("continue button")));
        Assert.assertTrue(clickToPayPage.isButtonOrLinkEnabled("continue button"));
    }

    @Then("user should return to the default manual reload screen on clicking on return to merchant button")
    public void clickCancelOrReturnToMerchantbuttons() {
        Assert.assertTrue(clickToPayPage.checkElementIsPresent("return to merchant button"));
        clickToPayPage.clickOn("cancel link");
        clickToPayPage.clickOn("close icon");
        clickToPayPage.clickOn("return to merchant button");
        driver.switchTo().defaultContent();
        Assert.assertTrue(prepaidCardManualReloadPage.getWebElement("cvv input field").isDisplayed(), "Classic manual reload page has not loaded properly");
    }

    @Then("user sees prefilled email, country and mobile fields")
    public void prefilledEmailCountryAndMobile() {
        WebElement email = clickToPayPage.getWebElement("prefilled email");
        WebElement country = clickToPayPage.getWebElement("prefilled country");
        WebElement mobile = clickToPayPage.getWebElement("prefilled phone no");
        Assert.assertTrue(email.isDisplayed(), "Email is not displayed");
        Assert.assertEquals(email.getText(), prefilledEmail, "Both the emails are not a match");
        Assert.assertTrue(country.isDisplayed(), "Country is not displayed");
        Assert.assertEquals(country.getText(), prefilledCountry, "Both the Countries are not a match");
        Assert.assertTrue(mobile.isDisplayed(), "Mobile is not displayed");
        Assert.assertEquals(mobile.getText(), prefilledMobile, "Both the mobile numbers are not a match");
    }

    @Then("user sees prefilled email, country and mobile fields and clicks on confirm button")
    public void clickConfirmbutton() {
        prefilledEmailCountryAndMobile();
        clickToPayPage.clickOn("confirm button");
        Assert.assertTrue(clickToPayPage.checkElementIsPresent("seomething went wrong alert pop up"), "Enroll in click to pay did not work as expected");
    }

    @Then("user updates the contact information by clicking on confirm button")
    public void updatecontactInformation() {
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("edit link")));
        clickToPayPage.clickOn("edit link");
        clickToPayPage.clearInputfieldAndEnterNewData("phone number input field", clickToPayPhoneNoEditValue);
        clickToPayPage.clickOn("no thanks link on contact information");
        Assert.assertTrue(clickToPayPage.getWebElement("check out a as a guest header").isDisplayed(), "User is not on the correct pop up");
        clickToPayPage.clickOn("contact arrow");
        clickToPayPage.enterText((Keys.CONTROL + "a"), "email input field");
        clickToPayPage.enterText("1", "email input field");
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("update contact information")));
        Assert.assertFalse(clickToPayPage.isElementInEnabledMode("update contact information"));
        clickToPayPage.enterText("cntl1@yopmail.com", "email input field");
        clickToPayPage.clickOn("update contact information");
        Assert.assertTrue(clickToPayPage.getWebElement("check out a as a guest header").isDisplayed(), "User is not on the correct pop up");
        clickToPayPage.clickOn("contact arrow");
        clickToPayPage.clearInputfieldAndEnterNewData("phone number input field", clickToPayPhoneNoEditValue);
        clickToPayPage.clickOn("update contact information");
        Assert.assertTrue(clickToPayPage.getWebElement("check out a as a guest header").isDisplayed(), "User is not on the correct pop up");
    }

    @Then("user updates the contact information by clicking on no thanks button")
    public void clickOnNoThanks() {
        wait.until(ExpectedConditions.visibilityOf(clickToPayPage.getWebElement("edit link")));
        if (clickToPayPage.checkElementIsPresent("edit link")) {
            clickToPayPage.clickOn("edit link");
            clickToPayPage.clickOn("no thanks link on contact information");
            Assert.assertTrue(clickToPayPage.getWebElement("check out a as a guest header").isDisplayed(), "User is not on the correct pop up");
        } else if (clickToPayPage.checkElementIsPresent("contact arrow")) {
            clickToPayPage.clickOn("contact arrow");
            clickToPayPage.clickOn("go back link");
            Assert.assertTrue(clickToPayPage.getWebElement("check out a as a guest header").isDisplayed(), "User is not on the correct pop up");
        }
    }
}