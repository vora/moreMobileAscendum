package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.AddMorePrepaidCardPage;
import com.cantaloupe.moreMobile.page.DashboardPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class AddMorePrepaidCardPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    AddMorePrepaidCardPage addMorePrepaidCardPage = new AddMorePrepaidCardPage();
    DashboardPage dashboardPage = new DashboardPage();
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();

    public AddMorePrepaidCardPage_steps() throws IOException {
    }

    private final String getMoreCardNumber = props.getProperty("more_mobile_MoreCardNumber");
    private final String getMoreSecurityNumber = props.getProperty("more_mobile_SecurityNumber");
    private final String getMorePrepaidCardNumber = props.getProperty("more_mobile_MorePrepaidCardNumber");
    private final String getMorePrepaidSecurityNumber = props.getProperty("more_mobile_PrepaidSecurityNumber");
    private final String getMoreAddedPrepaidCardNumber = props.getProperty("more_mobile_MoreAddedPrepaidCardNumber");
    private final String getMoreNewPrepaidCardNumber = props.getProperty("more_mobile_MoreNewPrepaidCardNumber");
    private final String getMoreNewPrepaidSecurityNumber = props.getProperty("more_mobile_MoreNewPrepaidSecurityNumber");
    private final String addmoreCardNo = props.getProperty("addmoreCardNo");
    private final String addMoreSecurityNo = props.getProperty("addMoreSecurityNo");
    private final String more_Mobile_ValidPrepaidCard = props.getProperty("more_Mobile_ValidPrepaidCard");
    private final String more_Mobile_InvalidSecurityNumber = props.getProperty("more_Mobile_InvalidSecurityNumber");
    private final String more_Mobile_inValidPrepaidCard = props.getProperty("more_Mobile_inValidPrepaidCard");
    private final String more_Mobile_ValidSecurityNumber = props.getProperty("more_Mobile_ValidSecurityNumber");
    private final String more_Mobile_Valid19DigitPrepaidCardNumber = props.getProperty("more_Mobile_Valid19DigitPrepaidCardNumber");




    @When("user enters the more card data as below:")
   // @When("user enters a valid more prepaid card number in respective input fields")
    public void user_fills_out_the_update_profile_form_as_below(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {

            switch (element.getValue()) {
                case "moreCardNumber":
                    addMorePrepaidCardPage.enterText(getMoreNewPrepaidCardNumber, element.getKey().toLowerCase() + " input field");
                    break;
                case "securityCode":
                    addMorePrepaidCardPage.enterText(getMoreNewPrepaidSecurityNumber, element.getKey().toLowerCase() + " input field");
                    break;
            }
        }

    }

    @When("user enters the invalid more card number as below:")
    public void invalidAlertPopUp(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {

            switch (element.getValue()) {
                case "moreCardNumber":
                    addMorePrepaidCardPage.enterText("1238765645657687678", element.getKey().toLowerCase() + " input field");
                    break;
                case "securityCode":
                    addMorePrepaidCardPage.enterText("1265", element.getKey().toLowerCase() + " input field");
                    break;
            }
        }
    }

    @When("user enters the invalid security as below:")
    public void invalidSecurityMatchAlertPopUp(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {

            switch (element.getValue()) {
                case "moreCardNumber":
                    addMorePrepaidCardPage.enterText("6396212035245446543", element.getKey().toLowerCase() + " input field");
                    break;
                case "securityCode":
                    addMorePrepaidCardPage.enterText("1265", element.getKey().toLowerCase() + " input field");
                    break;
            }
        }
    }

    @Then("user adds the card navigates back to dashboard page and see's the added card")
    public void addedCardLastFourDigits()
    {
       boolean isElementDisplayed = addMorePrepaidCardPage.waitForElement("proceed to home button");
       Assert.assertTrue(isElementDisplayed, "Card has not been added");
        addMorePrepaidCardPage.clickOn("proceed to home button");
        String lastFourdigits = addMorePrepaidCardPage.extractNumbersOnly(getMorePrepaidCardNumber);
        boolean isCardDisplayed = dashboardPage.verifyAddedMoreCardNumber(lastFourdigits);
        Assert.assertTrue(isCardDisplayed, "Card is not present on the screen");
    }

    @Then("user adds the card navigates back to dashboard page and see's the balance")
    public void verifyBalance_NewCard()
    {
        addMorePrepaidCardPage.clickOn("back link");
        String lastFourdigits = addMorePrepaidCardPage.extractNumbersOnly(getMoreCardNumber);
        boolean isCardDisplayed = dashboardPage.verifyBalance(lastFourdigits);
        Assert.assertTrue(isCardDisplayed, "Card is not present on the screen");

    }

    @When("user adds a more prepaid card and clicks on the next button")
    public void addMoreCardSuccessfully() throws IOException, AWTException {
        addMorePrepaidCardPage.enterNumberAndCode(getMorePrepaidCardNumber, getMorePrepaidSecurityNumber);
        addMorePrepaidCardPage.clickOn("add more card button");
    }

    @Then("user sees the prepaid card and the balance as - {string} on dashboard page")
    public void verifyBalanceForNewCard(String balance) {
        String lastFourdigits = dashboardPage.extractNumbersOnly(getMoreAddedPrepaidCardNumber);
        String availableBalance = dashboardPage.balanceCheck(lastFourdigits);
        Assert.assertEquals(availableBalance, "$" + balance, "Balance on the card is not as expected");
    }

    @Then("user sees the added prepaid card on the dashboard page")
    public void addedCardLastFourDigitsPrepaid() {
        String lastFourdigits = dashboardPage.extractNumbersOnly(getMoreAddedPrepaidCardNumber);
        boolean isCardDisplayed = dashboardPage.verifyAddedMoreCardNumber(lastFourdigits);
        Assert.assertTrue(isCardDisplayed, "Card is not present on the screen");
    }


//    @When("user enters a valid more prepaid card number in respective input fields")
//    public void enterPrepaidNumberAndSecurity() throws AWTException, IOException {
//        String newPrepaidCardNumber = addMorePrepaidCardPage.readLineForMrecardNumber(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMoreCard.txt"));
//        String newPrepaidCardSecurityNumber = addMorePrepaidCardPage.readLineForMrecardNumber(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMoreCardSecurity.txt"));
//        addMorePrepaidCardPage.enterNumberAndCode(newPrepaidCardNumber, newPrepaidCardSecurityNumber);
//        addMorePrepaidCardPage.deleteLineData(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMoreCard.txt"));
//        addMorePrepaidCardPage.deleteLineData(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMoreCardSecurity.txt"));
//    }

    @When("user enters a valid existing more prepaid card number in respective input fields")
    public void prepaid_enterNumberAndSecurity() throws AWTException {
        addMorePrepaidCardPage.enterNumberAndCode(getMorePrepaidCardNumber, getMorePrepaidSecurityNumber);
    }

    @When("user enters a existing more prepaid card number in respective input fields")
    public void existingMoreCardDetails() throws AWTException, IOException {
       addMorePrepaidCardPage.enterText(getMorePrepaidCardNumber, "more card number input field");
       addMorePrepaidCardPage.enterText(getMoreSecurityNumber, "security code input field");
    }

    @When("user enters a valid more prepaid card number in respective input fields")
    public void enterPrepaidNumberAndSecurity() throws AWTException, IOException {
        String newPrepaidCardNumber = addMorePrepaidCardPage.readLineForMrecardNumber(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addmoreCardNo));
        String newPrepaidCardSecurityNumber = addMorePrepaidCardPage.readLineForMrecardNumber(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addMoreSecurityNo));
        addMorePrepaidCardPage.enterNumberAndCode(newPrepaidCardNumber, newPrepaidCardSecurityNumber);
        addMorePrepaidCardPage.deleteLineData(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addmoreCardNo));
        addMorePrepaidCardPage.deleteLineData(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addMoreSecurityNo));
    }

    @When("user enters valid prepaid card and invalid security number")
    public void invalidSecurityMatchAlertPopUp() {
        addMorePrepaidCardPage.enterNumberAndCode(more_Mobile_ValidPrepaidCard, more_Mobile_InvalidSecurityNumber);
    }

    @When("user enters the invalid more card number and security number")
    public void invalidMoreCardAlertPopUp() {
        addMorePrepaidCardPage.enterNumberAndCode(more_Mobile_inValidPrepaidCard, more_Mobile_ValidSecurityNumber);
    }

    @When("user enters a valid 19 digit prepaid card number in respective field")
    public void enterMoreCardNumber() {
        if (addMorePrepaidCardPage.regexMoreCardNo(more_Mobile_Valid19DigitPrepaidCardNumber)) {
            addMorePrepaidCardPage.enterText(more_Mobile_Valid19DigitPrepaidCardNumber, "more card number input field");
        }
    }
}
