package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.AddMorePayrollCardPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddMorePayrollCardPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    AddMorePayrollCardPage addMorePayrollCardPage = new AddMorePayrollCardPage();
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();


    private final String getMorePayrollCardNumber = props.getProperty("more_mobile_MorePayrollCardNumber");
    private final String getMorePayrollSecurityNumber = props.getProperty("more_mobile_PayrollSecurityNumber");


    private final String addmorePayrollCardNo = props.getProperty("addmorePayrollCardNo");
    private final String addMorePayrollSecurityNo = props.getProperty("addMorePayrollSecurityNo");




    public AddMorePayrollCardPage_steps() throws IOException {
    }

    @And("user sees that set as primary card option will not be available for the payroll card")
    public void verifyElementIsDisabled() {
        boolean isElementEnabled = addMorePayrollCardPage.checkElementIsPresent("set as primary checkbox");
        Assert.assertFalse(isElementEnabled, "Element is in enabled mode");
    }

    @Then("user sees the added payroll card and the balance as - {string} on dashboard page")
    public void verifyBalanceForNewCard(String balance) {
        //currentPage.navigationToAddedNewCardImg(getMoreNewPrepaidCardNumber);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String lastFourdigits = addMorePayrollCardPage.extractNumbersOnly(getMorePayrollCardNumber);
        // String availableBalance = currentPage.balanceCheck(lastFourdigits);
        String availableBalance = addMorePayrollCardPage.balanceCheckForNewlyAddedCard(lastFourdigits);
        Assert.assertEquals(availableBalance, "$" + balance, "Balance on the card is not as expected");
    }

//    @When("user enters a valid more payroll card number in respective input fields")
//    public void enterPrepaidNumberAndSecurity() throws AWTException, IOException {
//        String newPrepaidCardNumber = addMorePayrollCardPage.readLineForMrecardNumber(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMorePayrollCard.txt"));
//        String newPrepaidCardSecurityNumber = addMorePayrollCardPage.readLineForMrecardNumber(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMorePayrollCardSecurity.txt"));
//        addMorePayrollCardPage.enterNumberAndCode(newPrepaidCardNumber, newPrepaidCardSecurityNumber);
//        addMorePayrollCardPage.deleteLineData(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMorePayrollCard.txt"));
//        addMorePayrollCardPage.deleteLineData(new File("//Users//rajeshwariprem//Documents//August//enhancements//AddMorePayrollCardSecurity.txt"));
//    }

    @When("user enters a valid existing more payroll card number in respective input fields")
    public void payroll_enterNumberAndSecurity() throws AWTException {
        addMorePayrollCardPage.enterNumberAndCode(getMorePayrollCardNumber, getMorePayrollSecurityNumber);
    }

    @When("user enters a valid more payroll card number in respective input fields")
    public void enterPrepaidNumberAndSecurity() throws AWTException, IOException {
        String newPrepaidCardNumber = addMorePayrollCardPage.readLineForMrecardNumber(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addmorePayrollCardNo));
        String newPrepaidCardSecurityNumber = addMorePayrollCardPage.readLineForMrecardNumber(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addMorePayrollSecurityNo));
        addMorePayrollCardPage.enterNumberAndCode(newPrepaidCardNumber, newPrepaidCardSecurityNumber);
        addMorePayrollCardPage.deleteLineData(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addmorePayrollCardNo));
        addMorePayrollCardPage.deleteLineData(new File("src//main//java//com//cantaloupe//moreMobile//files//" + addMorePayrollSecurityNo));
    }
}
