package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import com.cantaloupe.moreMobile.MoreMobilePageFactory;
import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MoreMobileCommonSteps {

    private WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    private MoreMobileAbstractBasePage currentPage;
    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String getMoreUrl = props.getProperty("more_mobile_Url");
    private final String getMoreEmail = props.getProperty("more_mobile_Email");
    private final String getMoreAutoReloadEmail = props.getProperty("more_mobile_AutoReloadEmail");
    private final String getMoreAutoReloadPassword = props.getProperty("more_mobile_AutoReloadPassword");
    private final String getMorePassword = props.getProperty("more_mobile_Password");
    private final String getMoreConfirmPassword = props.getProperty("more_mobile_ConfirmPassword");
    private final String getMoreExistingMobileNumber = props.getProperty("more_mobile_ExistingMobileNumber");
    private final String getMoreExistingEmail = props.getProperty("more_mobile_ExistingEmail");
    private final String getMoreVisaCC = props.getProperty("more_mobile_moreVisaCC");
    private final String getMoreVisaCVV = props.getProperty("more_mobile_moreVisaCVV");
    private final String getMoreUserAddress = props.getProperty("more_mobile_UserAddress");
    private final String getMoreNewZipcode = props.getProperty("more_mobile_newZipcode");
    private final String getMoreNewState = props.getProperty("more_mobile_newState");
    private final String getMoreNewCity = props.getProperty("more_mobile_newCity");
    private final String getMoreNewStreetAddress = props.getProperty("more_mobile_newStreetAddress");
    private final String getMoreMonthDropDownValue = props.getProperty("more_mobile_monthDropdownValue");
    private final String getMoreYearDropDownValue = props.getProperty("more_mobile_yearDropdownValue");
    private final String getMoreAddMorePrepaidEmail = props.getProperty("more_mobile_AddMorePrepaidEmail");
    private final String getMoreAddMorePrepaidPassword = props.getProperty("more_mobile_AddMorePrepaidPassword");
    private final String getMorePrepaidCardNumber = props.getProperty("more_mobile_MorePrepaidCardNumber");
    private final String getMorePrepaidSecurityNumber = props.getProperty("more_mobile_PrepaidSecurityNumber");
    private final String getMoreAddMorePayrollEmail = props.getProperty("more_mobile_AddMorePayrollEmail");
    private final String getMoreAddMorePayrollPassword = props.getProperty("more_mobile_AddMorePayrollPassword");
    private final String getMorePayrollCardNumber = props.getProperty("more_mobile_MorePayrollCardNumber");
    private final String getMorePayrollSecurityNumber = props.getProperty("more_mobile_PayrollSecurityNumber");
    private final String getMoreRegisteredPayrollCard = props.getProperty("more_mobile_MorePayrollCardNumber");
    private final String getMoreRegisteredPayrollSecurityNumber = props.getProperty("more_mobile_PayrollSecurityNumber");
    private final String getMorePasswordResetUrl = props.getProperty("more_mobile_Password_Reset_Url");
    private final String getMoreUpdateProfileEmail = props.getProperty("more_mobile_UpdateProfileEmail");
    private final String getMoreUpdateProfilePassword = props.getProperty("more_mobile_UpdateProfilePassword");
    private final String getMoreManualReloadEmail = props.getProperty("more_mobile_ManualReloadEmail");
    private final String getMoreManualReloadPassword = props.getProperty("more_mobile_ManualReloadPassword");
    private final String getMorePrepaidAutoReloadCardNumber = props.getProperty("more_mobile_PrepaidAutoReloadCardNumber");
    private final String getMoreNewPrepaidCardNumber = props.getProperty("more_mobile_MoreNewPrepaidCardNumber");
    private final String getMoreNewPrepaidSecurityNumber = props.getProperty("more_mobile_MoreNewPrepaidSecurityNumber");
    private final String getMorePrepaidCardManualReloadNumber = props.getProperty("more_mobile_PrepaidManualReloadCardNumber");





    public MoreMobileCommonSteps() throws IOException {
    }

    @Given("user launches the application and navigates to Home page")
    public void navigateToMoreUrl() throws IOException {
        driver.get(getMoreUrl);
        moreMobilePageShouldLoadSuccessfully("home page");
    }

    @Given("user launches the application and navigates to Home page and clicks on create account button")
    public void clickOncreateAccountButton() throws IOException {
        navigateToMoreUrl();
        moreMobilePageShouldLoadSuccessfully("home page");
        currentPage.clickOn("create account button");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("initial create account page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("initial create account page");
            currentPage.isElementDisplayed("next button");

        }
    }

    @Given("user launches the application and navigates to sign in screen through different options page")
    public void navigateToDifferentOptions() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            currentPage.isElementDisplayed("sign in header");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            currentPage.isElementDisplayed("sign in header");
        }
    }

    @Given("user launches the application and navigates to create account options page")
    public void userClicksOn() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("create account button");
        //moreMobilePageShouldLoadSuccessfully("different options page");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.checkElementIsPresent("continue with email link");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("initial create account page");
            currentPage.isElementDisplayed("create account header");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("initial create account page");
            currentPage.isElementDisplayed("create account header");
        }
    }

    @Given(" user launches the application and to navigate to initial create account page")
    public void navigateToInitialCreateAccount() throws IOException {
        navigateToCreatePage();
        //currentPage.clickOn("continue with email link");
        //moreMobilePageShouldLoadSuccessfully("initial create account page");

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("initial create account page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("initial create account page");
        }
    }

    @Given("user logs into the account with existing email")
    public void existingUserLoginFlow() throws IOException {
        navigateToInitialCreatePage();
        enterValue(getMoreEmail, "email input field");
        Assert.assertTrue(currentPage.waitForElement("login button"));
        currentPage.clickOn("login button");
        //moreMobilePageShouldLoadSuccessfully("different options page");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
    }

    @Given("user launches the application and navigates to create account page by entering valid email")
    public void navigateToCreatePage() throws IOException {
        navigateToInitialCreatePage();
        String email = currentPage.generateRandomEmailId();
        currentPage.enterText(email, "email input field");
        currentPage.clickOn("next button");
        moreMobilePageShouldLoadSuccessfully("create account page");
    }

    @Given("user launches the application and navigates to initial create account page")
    public void navigateToInitialCreatePage() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("create account button");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("initial create account page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("initial create account page");
        }
    }

    @Given("user launches the application and to navigate to different options page by logging in with already registered email")
    public void navigateToSignPageExistingUser() throws IOException {
        navigateToInitialCreatePage();
        currentPage.enterText(getMoreEmail, "email input field");
        waitForElement("login button");
        currentPage.clickOn("login button");
        //moreMobilePageShouldLoadSuccessfully("different options page");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
    }

    @Given("user launches the application and to navigate to sign in options page")
    public void navigateTosignInOptions() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        //moreMobilePageShouldLoadSuccessfully("different options page");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
    }

    @Given("user launches the application and to navigate to sign in page")
    public void navigateToSignInPage() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
//        moreMobilePageShouldLoadSuccessfully("different options page");
//        currentPage.clickOn("continue with email link");
//        moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
    }

    @Given("user launches the application and navigates to dashboard page by entering valid email and password")
    public void loginWithEmailAndPassword(String email, String password) throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        moreMobilePageShouldLoadSuccessfully("different options page");
//        currentPage.clickOn("continue with email link");
//        moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
//        enterValue(getMoreEmail, "email input field");
//        enterValue(getMorePassword, "password input field");
//        currentPage.clickOn("sign in button");
//        moreMobilePageShouldLoadSuccessfully("dashboard page");

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(email, "email input field");
            enterValue(password, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(email, "email input field");
            enterValue(password, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
    }

    @Given("user launches the application and navigates to dashboard screen by entering valid email and password")
    public void loginWithEmailAndPassword() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
    }

    @Given("user launches the application and to navigate to dashboard after adding a card by entering valid email and password")
    public void navigateToDashboardAfterAddingCard() throws IOException {
        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMorePassword);;
        moreMobilePageShouldLoadSuccessfully("dashboard page");
    }

    @Given("user launches the application and to navigate to dashboard after adding a payroll card by entering valid email and password")
    public void navigateToDashboardAfterAddingPayrollCard() throws IOException {
        loginWithEmailAndPassword(getMoreAddMorePayrollEmail, getMoreAddMorePayrollPassword);;
        moreMobilePageShouldLoadSuccessfully("dashboard page");
    }

    @Given("user launches the application and to navigate to dashboard after adding a prepaid card by entering valid email and password")
    public void navigateToDashboardAfterAddingPrepaidCard() throws IOException {
        loginWithEmailAndPassword(getMoreAddMorePrepaidEmail, getMoreAddMorePrepaidPassword);;
        moreMobilePageShouldLoadSuccessfully("dashboard page");
        currentPage.checkElementIsPresent("profile link");
    }



    @Given("user launches the application and navigates to dashboard page to verify FAQ by entering valid email and password")
    public void navigateToFAQ() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
       // loginWithEmailAndPassword(getMoreEmail, getMorePassword);
    }


    @Given("user launches the application and to navigate to upda`  `featureste profile page by entering valid email and password")
    public void navigateToUpdateProfiePage() throws IOException {
        loginWithEmailAndPassword(getMoreUpdateProfileEmail, getMoreUpdateProfilePassword);
        currentPage.clickOn("profile link");
        moreMobilePageShouldLoadSuccessfully("update profile page");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Given("user launches the application and to navigate to add more card page by entering valid email and password")
    public void navigateToAddMoreCardPage() throws IOException {
        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMorePassword);
        currentPage.clickOn("add more card link");
        moreMobilePageShouldLoadSuccessfully("add more card page");
    }

    @Given("user launches the application and to navigate to add more card payroll page by entering valid email and password")
    public void navigateToAddMoreCardPayrollPage() throws IOException {
        loginWithEmailAndPassword(getMoreAddMorePayrollEmail, getMoreAddMorePayrollPassword);
        currentPage.clickOn("add more card link");
        moreMobilePageShouldLoadSuccessfully("add more card payroll page");
    }

    @Given("user launches the application and to navigate to prepaid card details page by entering valid email and password")
    public void navigateToPrepaidCardDetailsPage() throws IOException {
        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMorePassword);
        currentPage.navigationToAddedNewCardImg(getMorePrepaidAutoReloadCardNumber);
        //currentPage.clickOn("prepaid card button");
        moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
      //  driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(60));
    }

    @Given("user launches the application and to navigate to prepaid card reload page by entering valid email and password")
    public void navigationToPrepaidCardAutoReloadPage() throws IOException {
//        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMoreAutoReloadPassword);
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(60));

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreAutoReloadEmail, "email input field");
            enterValue(getMoreAutoReloadPassword, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            currentPage.navigationToAddedNewCardImg(getMorePrepaidAutoReloadCardNumber);
            // currentPage.clickOn("prepaid card button");
            moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
            currentPage.clickOn("auto reload label");
            moreMobilePageShouldLoadSuccessfully("prepaid card reload page");
        }
            else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreAutoReloadEmail, "email input field");
            enterValue(getMoreAutoReloadPassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            currentPage.navigationToAddedNewCardImg(getMorePrepaidAutoReloadCardNumber);
            // currentPage.clickOn("prepaid card button");
            moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
            currentPage.clickOn("auto reload label");
            moreMobilePageShouldLoadSuccessfully("prepaid card reload page");
        }

    }

    @Given("user launches the application and to navigate to prepaid card manual reload page by entering valid email and password")
    public void navigationToPrepaidCardManualReloadPage() throws IOException {
//        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMoreAutoReloadPassword);
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            currentPage.navigationToAddedNewCardImg(getMorePrepaidCardManualReloadNumber);
            // currentPage.clickOn("prepaid card button");
            moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
            currentPage.clickOn("auto reload label");
            moreMobilePageShouldLoadSuccessfully("prepaid card reload page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            currentPage.navigationToAddedNewCardImg(getMorePrepaidCardManualReloadNumber);
            // currentPage.clickOn("prepaid card button");
            moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
            currentPage.clickOn("auto reload label");
            moreMobilePageShouldLoadSuccessfully("prepaid card reload page");
        }

    }


//    @Given("user launches the application and to navigate to prepaid card manual reload page by entering valid email and password")
//    public void navigationToPrepaidCardManualReloadPage() throws IOException {
//        navigateToPrepaidCardDetailsPage();
//        currentPage.clickOn("manual reload label");
//        moreMobilePageShouldLoadSuccessfully("prepaid card manual reload page");
//    }



    @Given("user launches the application and to navigate to change password page by entering valid email and password")
    public void navigateToChangePasswordPage() throws IOException {
        navigateToUpdateProfiePage();
//        currentPage.clickOn("profile link");
//        moreMobilePageShouldLoadSuccessfully("update profile page");
        currentPage.clickOn("password change link");
        moreMobilePageShouldLoadSuccessfully("change password page");
    }
    @Given("User launches the application and to navigate to initial forgot password page")
    public void navigateToInitialForgotPasswordPage() throws IOException {
        navigateToSignInPage();
        currentPage.clickOn("forgot password link");
        moreMobilePageShouldLoadSuccessfully("forgot password page");
    }

    @Given("user launches the application and to navigate to forgot password page by entering {}")
    public void navigateToForgotPasswordPage(String email) throws IOException {
        navigateToInitialForgotPasswordPage();
        driver.findElement(By.xpath("//input[@id='id_email']")).sendKeys(email);
    }
//
//    @Given("user launches the application and to navigate to sign in page after changing the password through forgot password")
//    public void navigateToSignInPageThroughForgotPassword() throws IOException {
//        driver.get(getMoreUrl);
//        moreMobilePageShouldLoadSuccessfully("home page");
//        currentPage.clickOn("already have an account link");
//        if (currentPage.checkElementIsPresent("continue with email link")) {
//            moreMobilePageShouldLoadSuccessfully("different options page");
//            currentPage.clickOn("continue with email link");
//        } else {
//            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
//        }
//    }


    //Manual Change


    @Given("user launches the application and to navigate to manual or auto reload cancel page by entering valid email and password")
    public void navigationToPrepaidCardReloadPage() throws IOException {
//        loginWithEmailAndPassword(getMoreAutoReloadEmail, getMoreAutoReloadPassword);
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        currentPage.navigationToAddedNewCardImg(getMorePrepaidCardManualReloadNumber);
        //currentPage.navigationToAnyCardOnAccount();
       // currentPage.clickOn("prepaid card button");
        moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
        currentPage.clickOn("manual reload label");
        if(currentPage.checkElementIsPresent("credit card number input field"))
        {
            moreMobilePageShouldLoadSuccessfully("prepaid card manual reload page");
        }
        else if(currentPage.checkElementIsPresent("cancel auto reload through manual flow"))
        {
            moreMobilePageShouldLoadSuccessfully("auto reload cancel page");
            currentPage.clickOn("yes proceed button");
            moreMobilePageShouldLoadSuccessfully("prepaid card manual reload page");
        }

    }

    @Given("user launches the application and navigates to respective page by clicking on {string} and entering valid email and password")
    public void navigateToPPOrTC(String linkName) throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            currentPage.clickOn(linkName);
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreEmail, "email input field");
            enterValue(getMorePassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
            currentPage.clickOn(linkName);
        }
    }







    //ManualChange

    @When("user clicks on the {string}")
    public void userClicksOn(String elementName) {
        currentPage.clickOn(elementName);
    }

    @Then("More {string} should load successfully")
    public void moreMobilePageShouldLoadSuccessfully(String pageName) throws IOException {
        MoreMobilePageFactory.setPageName(pageName);
        currentPage = MoreMobilePageFactory.getPageObject();
        Assert.assertTrue(currentPage.isPageLoaded());
    }

    @Then("user sees {string} on the screen")
    public void checkElementISPresentOrNot(String targetElement) {
        boolean isElementPresent = currentPage.waitForElement(targetElement);
        Assert.assertTrue(isElementPresent, targetElement + " is not displayed on the screen");
    }

    @Then("user sees {string} for state on the screen")
    public void checkStatePopUp(String targetElement) {
        boolean isElementPresent = currentPage.checkElementIsPresent(targetElement);
        Assert.assertTrue(isElementPresent, targetElement + " is not displayed on the screen");
    }

    @Then("user should see {string} on the screen")
    public void checkElementISPresentOnScreen(String targetElement) {
        boolean isElementPresent = currentPage.waitForElement(targetElement);
        Assert.assertTrue(isElementPresent, targetElement + " is not displayed on the screen");
    }

    @Then("user should see {string} and {string} on the screen")
    public void checkTwoElementISPresentOrNot(String firstElement, String secondElement) {
        boolean isFirstElementPresent = currentPage.checkElementIsPresent(firstElement);
        boolean isSecondElementPresent = currentPage.checkElementIsPresent(secondElement);
        Assert.assertTrue(isFirstElementPresent, firstElement + " is not displayed");
        Assert.assertTrue(isSecondElementPresent, secondElement + "is not displayed");
    }

    @Then("user sees if he is navigated back to home page")
    public void navigateBack()
    {
        if(currentPage.checkElementIsPresent("back home link"))
        {
            currentPage.clickOn("back home link");
            currentPage.checkElementIsPresent("already have an account link");
            Assert.assertTrue(currentPage.checkElementIsPresent("already have an account link"));
            currentPage.clickOn("already have an account link");
        }
        else if(currentPage.checkElementIsPresent("back to account options link"))
        {
            currentPage.clickOn("back to account options link");
            currentPage.clickOn("back home link");
            currentPage.checkElementIsPresent("already have an account link");
            Assert.assertTrue(currentPage.checkElementIsPresent("already have an account link"));
            currentPage.clickOn("already have an account link");
        }
//        else
//        {
//            Assert.assertTrue(currentPage.checkElementIsPresent("already have an account link"), "user has navigated to home page");
//        }
    }

    @Then("user sees if he is navigated back to home page from sign in page by clicking - {string} or {string}")
    public void navigateBackToHomeFromSignIn(String firstLinkName, String secondLinkName) throws IOException {
        if(currentPage.checkElementIsPresent(firstLinkName))
        {
            currentPage.clickOn("back home link");
            moreMobilePageShouldLoadSuccessfully("home page");
            currentPage.checkElementIsPresent("already have an account link");
            Assert.assertTrue(currentPage.checkElementIsPresent("already have an account link"));
            currentPage.clickOn("already have an account link");
        }
        else if(currentPage.checkElementIsPresent(secondLinkName))
        {
            currentPage.clickOn(secondLinkName);
            currentPage.clickOn("back home link");
            moreMobilePageShouldLoadSuccessfully("home page");
            currentPage.checkElementIsPresent("already have an account link");
            Assert.assertTrue(currentPage.checkElementIsPresent("already have an account link"));
            currentPage.clickOn("already have an account link");
        }
        else
        {
            Assert.assertFalse(currentPage.checkElementIsPresent("already have an account link"), "user has navigated to home page");
        }
    }

    @And("user will see {string} on the screen")
    public void checkElementISPresent(String targetElement) {
        boolean isElementPresent = currentPage.checkElementIsPresent(targetElement);
        Assert.assertTrue(isElementPresent, "Element is not available on the screen");
    }

    @And("the {string} will be in enabled mode")
    public void checkElementIsEnabled(String targetElement) {
        boolean isElementEnabled = currentPage.isButtonOrLinkEnabled(targetElement);
        Assert.assertTrue(isElementEnabled, "Element is not in enabled mode");
    }

    @And("the {string} should be displaying on screen")
    public void checkElementDisplayed(String targetElement) {
        boolean isElementPresent = currentPage.isElementDisplayed(targetElement);
        Assert.assertTrue(isElementPresent, "Element is not in enabled mode");
    }

    @When("user enters {string} in the {string}")
    public void enterValue(String enterValue, String targetElementName) {
        currentPage.enterText(enterValue, targetElementName);
    }

    @When("user enters valid/invalid password and confirm in password and confirm password fields")
    public void verifyPasswordMatch() {
        currentPage.enterText(getMorePassword, "password input field");
        currentPage.enterText(getMoreConfirmPassword, "confirm password input field");
    }

    @When("user does a random click on the screen")
    public void randomClickBasedOnOS() throws AWTException {
        currentPage.randomClickBasedOnOS();
    }

    @When("user scrolls down to the {string} on the screen and clicks it")
    public void scrolldownToTheElement(String targetElementName) throws AWTException {
        currentPage.scrollToTheElementAndClick(targetElementName);
    }

    @When("user tries to click the backspace button from keyboard for the {string}")
    public void clickBackspaceButton(String targetWebElement) {
        currentPage.clickBackspaceFromKeyboard(targetWebElement);
    }

    @And("the {string} will not be in enabled mode")
    public void verifyElementStatus(String targetElement) {
        boolean isElementEnabled = currentPage.isButtonOrLinkEnabled(targetElement);
        Assert.assertFalse(isElementEnabled, "Is Element enabled?: " + !isElementEnabled);
    }

    @And("user enters a mobile number and verifies that has no phone number in use error displayed")
    public void verifyPhoneNumberIsUnique() throws AWTException {
        boolean numberInUse = currentPage.checkElementIsPresent("phone number in use error");
       // driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(60));
        if (currentPage.getWebElement("mobile number tick mark image").isDisplayed()) {
            Assert.assertTrue(currentPage.getWebElement("mobile number tick mark image").isDisplayed(), "Phone number is not unique");
        } else if (numberInUse) {
            Assert.fail("Phone number is in use");
        } else {
            Assert.fail("Something is wrong with the phone number field");
        }
    }

    @Then("user enters the existing email in the email input field")
    public void existingemail() throws AWTException {
        boolean isEmailValid = currentPage.verifyRegexEmail(getMoreExistingEmail);
        Assert.assertTrue(isEmailValid, "The entered email is not valid");
    }

    @And("user sees that the {string} is masked")
    public void checkPasswordMasked(String targetWebElement) {
        boolean isFieldMasked = currentPage.checkPasswordMaskedOrNot(targetWebElement);
        Assert.assertTrue(isFieldMasked, "Field is not masked");
    }

    @And("user sees that the {string} is not masked")
    public void checkPasswordNotMasked(String targetWebElement) {
        boolean isFieldMasked = currentPage.checkPasswordMaskedOrNot(targetWebElement);
        Assert.assertFalse(isFieldMasked, "Field is masked");
    }

    @When("user enters a valid email and password in respective field")
    public void enterEmailAndPassword() throws IOException, AWTException {
        currentPage.enterText(getMoreEmail, "email input field");
        currentPage.enterText(getMorePassword, "password input field");
    }

    @When("user enters a invalid {string} in {string} field")
    public void enterEmailAndPassword(String invalidEmail, String invalidPassword) throws IOException, AWTException {
        currentPage.enterText(invalidEmail, "email input field");
        currentPage.enterText(invalidPassword, "password input field");
    }

    @And("user verifies {string} is a valid entry or not by using regexPhone expression")
    public void enterValue(String enterValue) {
        boolean isValidEntry = currentPage.regexPhoneNo(enterValue);
        Assert.assertTrue(isValidEntry, "Phone number is not valid");
    }

    @And("user sees the {string} for {string}")
    public void verifyBlankError(String expectedErrorMessage, String targetWebElement) {
        String actualErrorMessage = currentPage.validateErrorMessages(targetWebElement);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The data entered and available on the screen are not matching");
    }

    @When("user enters a new value in {string}")
    public void enterRandomStringValue(String targetWebElement) {
        String generatedString = currentPage.randomString(10);
        currentPage.clickOn(targetWebElement);
        currentPage.enterText(generatedString, targetWebElement);
    }

    @When("user enters a new state value in {string}")
    public void enterRandomStateValue(String targetWebElement) {
        String generatedString = currentPage.randomState();
        currentPage.clickOn(targetWebElement);
        currentPage.enterText(generatedString, targetWebElement);
    }

    @When("user enters a new value for zipcode in {string}")
    public void enterRandomZipcode(String targetWebElement) {
        String generatedString = currentPage.generateRandomZipcode();
        currentPage.clickOn(targetWebElement);
        currentPage.enterText(generatedString, targetWebElement);
    }

    @Then("user enters a valid mobile number in {string}")
    public void enterRandomMobileNumber(String targetWebElement) {
        String generatedString = String.valueOf(currentPage.generateRandomNumberString());
        currentPage.clickOn(targetWebElement);
        currentPage.enterText(generatedString, targetWebElement);
        boolean isValidEntry = currentPage.regexPhoneNo(generatedString);
        Assert.assertTrue(isValidEntry, "Phone number is not valid");
    }

    @And("the service number displayed in the error is clickable")
    public void extractString() {
        String getString = currentPage.extractString();
        boolean isElementClickable = currentPage.checkElementClickable();
        Assert.assertEquals(getString, "1-888-561-4748");
        Assert.assertTrue(isElementClickable, "Th service number is not clickable");
    }

    @When("user enters a unique email in the email input field")
    public void verifyEmailUniqueness() throws AWTException {
        currentPage.enterUniqueEmailID();
    }

    @And("user verifies the format for {string}")
    public void verifyPhoneNoFormat(String mobileNumber) {
        boolean validFormat = currentPage.verifyPhoneNoFormat(mobileNumber);
        Assert.assertTrue(validFormat, "The phone number is not in proper format");
    }

    @And("the user sees that the {string} is in disabled/unavailable mode")
    public void verifyElementIsDisabled(String targetWebElement) {
        boolean isElementEnabled = currentPage.isElementInEnabledMode(targetWebElement);
        Assert.assertFalse(isElementEnabled, "Element is in enabled mode");
    }

    @Then("user sees the added payroll card on the dashboard page")
    public void addedCardLastFourDigitsPayroll() {
        String lastFourdigits = currentPage.extractNumbersOnly(getMorePayrollCardNumber);
        boolean isCardDisplayed = currentPage.verifyAddedMoreCardNumber(lastFourdigits);
        Assert.assertTrue(isCardDisplayed, "Card is not present on the screen");
    }

    @Then("user sees the balance for the added card")
    public void verifyBalance_NewCard() throws IOException {
        String lastFourdigits = currentPage.extractNumbersOnly(getMorePayrollCardNumber);
        boolean isCardNumberDisplayed = currentPage.verifyAddedMoreCardNumber(lastFourdigits);
        currentPage.clickOnAddedCard(lastFourdigits);
        moreMobilePageShouldLoadSuccessfully("payroll deduct page");
        boolean isPayrollHeaderDisplayed = currentPage.isElementDisplayed("payroll deduct header");
        Assert.assertTrue(isPayrollHeaderDisplayed && isCardNumberDisplayed, "The Payroll Header and Card number are not displayed");
    }

    @Then("the {string} should not be displayed on the screen")
    public void elementNotPresent(String targetElement) {
        boolean isElementPresent = currentPage.checkElementIsPresent(targetElement);
        Assert.assertFalse(isElementPresent, targetElement + "is displayed on the screen");
    }

    @When("user enters a valid 19 digit more card number - {string} in respective field")
    public void enterMoreCardNumber(String moreCardNumber) {
        if (currentPage.regexMoreCardNo(moreCardNumber)) {
            currentPage.enterText(moreCardNumber, "more card number input field");
        }
    }

    @When("user enters a valid security code - {string} in respective field")
    public void enterSecuritycode(String moreCardNumber) {
        if (currentPage.regexSecurityCode(moreCardNumber)) {
            currentPage.enterText(moreCardNumber, "security code input field");
        }
    }

    //@When("user enters a valid more payroll card number in respective input fields")
//    @When("user enters a valid existing more payroll card number in respective input fields")
//    public void payroll_enterNumberAndSecurity() throws AWTException {
//        currentPage.enterNumberAndCode(getMorePayrollCardNumber, getMorePayrollSecurityNumber);
//    }



//
//    @When("user enters a valid more prepaid card number in respective input fields")
//    public void enterPrepaidNumberAndSecurity() throws AWTException {
//        currentPage.enterNumberAndCode(getMoreNewPrepaidCardNumber, getMoreNewPrepaidSecurityNumber);
//        //currentPage.clickOn("set as primary check box");
//    }

    @When("user enters the invalid more card number as below: {string} and {string}")
    public void invalidAlertPopUp(String number, String security) throws AWTException {
        currentPage.enterText(number, "more card number input field");
        currentPage.enterText(security, "security code input field");
    }

    @When("user enters the invalid security as below: {string} and {string}")
    public void invalidSecurityMatchAlertPopUp(String number, String security) throws AWTException {
        currentPage.enterNumberAndCode(number, security);
    }

    @Then("user clicks on the added card - {string}")
    public void clickOnAddedCard(String cardNumber) {
        String lastFourdigits = currentPage.extractNumbersOnly(cardNumber);
        boolean isCardDisplayed = currentPage.verifyAddedMoreCardNumber(lastFourdigits);
        currentPage.clickOn(lastFourdigits);
        Assert.assertTrue(isCardDisplayed, "Card is not present on the screen");
    }

    @Then("user will be seeing {string} on the screen")
    public void waitForElement(String targetElement) {
        boolean isElementPresent = currentPage.waitForElement(targetElement);
        Assert.assertTrue(isElementPresent, targetElement + " is not displayed on the screen");
    }

    @Then("user sees that no value is entered after sending the following as input value - {string}")
    public void noValueEntered(String enterValue) {
        enterValue(enterValue, "more card number input field");
        String enteredValue = currentPage.getWebElement("more card number input field").getAttribute("value");
        Assert.assertEquals(enteredValue, "", "more card number input field is not working as expected");
    }

    @Then("user sees the card and the balance as - {string} on dashboard page")
    public void verifyBalanceForNewCard(String balance) {
        //currentPage.navigationToAddedNewCardImg(getMoreNewPrepaidCardNumber);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String lastFourdigits = currentPage.extractNumbersOnly(getMoreNewPrepaidCardNumber);
       // String availableBalance = currentPage.balanceCheck(lastFourdigits);
        String availableBalance = currentPage.balanceCheckForNewlyAddedCard(lastFourdigits);
       Assert.assertEquals(availableBalance, "$" + balance, "Balance on the card is not as expected");
    }

    @When("user enters the already registered more payroll card and security code in respective input fields")
    public void registeredMoreCard() throws AWTException {
        currentPage.enterNumberAndCode(getMoreRegisteredPayrollCard, getMoreRegisteredPayrollSecurityNumber);
    }

    @When("user enters valid/invalid {string} in {string}")
    public void enterText(String enterValue, String targetWEbElement) {
        currentPage.enterText(enterValue, targetWEbElement);
    }

    @Then("user sees that only numbers are entered even though he enters alphanumeric characters for {string}")
    public void enterAplhaNumeric(String targetWebElement) {
        String enteredValue = currentPage.getWebElement(targetWebElement).getAttribute("value");
        String extractedNumber = currentPage.extractNumbers_moreCard(enteredValue);
        Assert.assertEquals(enteredValue, extractedNumber, targetWebElement + " is not working as expected");
    }

    @Then("user sees that no value is entered after entering alphabets or special characters - {string} in {string}")
    public void enteralphabetsORSpecialCharacters_MoreCard(String enterValue, String targetWebElement) {
        enterValue(enterValue, targetWebElement);
        String enteredValue = currentPage.getWebElement(targetWebElement).getAttribute("value");
        Assert.assertEquals(enteredValue, "", targetWebElement + " is not working as expected");
    }

    @When("user adds a more card and clicks on the next button - {string} and {string}")
    public void addMoreCardSuccessfully(String cardNumber, String securityNumber) throws IOException, AWTException {
        currentPage.enterNumberAndCode(cardNumber, securityNumber);
    }

    @Then("the following {string} and {string} will display on the screen")
    public void checkElementISPresentOrNot(String targetElementOne, String targetwEbElementTwo) {
        boolean isElementPresentOne = currentPage.checkElementIsPresent(targetElementOne);
        boolean isElementPresentTwo = currentPage.checkElementIsPresent(targetwEbElementTwo);
        Assert.assertTrue(isElementPresentOne, targetElementOne + " is not displayed on the screen");
        Assert.assertTrue(isElementPresentTwo, targetwEbElementTwo + " is not displayed on the screen");
    }

    @Then("user sees that the {string} will the default value selected in {string}")
    public void reloadDropdownValue(String valueFromDropdown, String targetWEbElement) {
        currentPage.readDropdownValueByString(valueFromDropdown, targetWEbElement);
    }

    @Then("user sees that the {string} has a default value of {string}")
    public void defaultDropdownValue(String valueFromDropdown, String targetWEbElement) {
        currentPage.readDropdownValueByString(targetWEbElement, valueFromDropdown);
    }

    @Then("user will be able to see the available options for the {string} with the displayed value as {string}")
    public void availableOptionInDropdown_Reload(String targetWebElement, String initialValue) {
        boolean isBothDropdownValuesEqual = currentPage.actualDropdownOptions(targetWebElement, initialValue);
        Assert.assertTrue(isBothDropdownValuesEqual, "Dropdown values are not a match with the expected values");
    }

    @Then("user will be able to see the available options for the balance dropdown")
    public void availableOptionInDropdown_Balance(String targetWebElement) {
        boolean isBothDropdownValuesEqual = currentPage.actualDropdownOptions(targetWebElement, "10");
        Assert.assertTrue(isBothDropdownValuesEqual, "Dropdown values are not a match with the expected values");
    }

    @Then("user will be able to select the following value - {string} from {string}")
    public void selectByIndex(String valueoBeSelected, String targetWebElement) {
        String actualText = currentPage.readDropdownValueByString(valueoBeSelected, targetWebElement);
        Assert.assertEquals(actualText, valueoBeSelected, "Both the values are not same and are not as expected");
    }

    @When("user enters a valid credit card number - {string} in credit card input field")
    public void enterCreditCardNumber(String moreCardNumber) {
        if (currentPage.regexCreditCardNo(moreCardNumber)) {
            currentPage.enterText(moreCardNumber, "credit card number input field");
        }
    }



    @Then("user sees that the month - {string} will have the following value - {string}")
    public void monthDropdownValue( String targetWebElement, String valueDisplayed) {
        String isCurrentMonthValid = currentPage.readDropdownValueByString(valueDisplayed, targetWebElement);
        Assert.assertEquals(isCurrentMonthValid, getMoreMonthDropDownValue,  "Current month displayed in the dropdown is not correct");
    }

    @Then("user sees that the year - {string} will have the following value - {string}")
    public void yearDropdownValue(String targetWebElement, String valueDisplayed) {
        String isCurrentMonthValid = currentPage.readDropdownValueByString(valueDisplayed, targetWebElement);
        Assert.assertEquals(isCurrentMonthValid, getMoreYearDropDownValue,  "Current month displayed in the dropdown is not correct");
    }



    @And("user fills out the remaining feilds on the page and clicks on {string}")
    public void fillRemaingForms_Successflow(String pageName) {
        currentPage.enterText("4761739001010119", "credit card number input field");
       // currentPage.selectFromDropDownListByContainingText("month dropdown", "March");
       // currentPage.selectFromDropDownListByVisibleText("year dropdown", "2033");
        currentPage.readDropdownValueByString("March","month dropdown");
        currentPage.readDropdownValueByString("2033", "year dropdown");
        currentPage.enterText("123", "cvv input field");
        userClicksOn(pageName);
        boolean isDoneDisplayed = currentPage.waitForElement("done header");
        Assert.assertTrue(isDoneDisplayed, "Auto reload has not been successfull");
    }

    @When("user enters existing mobile number in the {string}")
    public void enterMobileNumber(String targetElementName) {
        currentPage.enterText(getMoreExistingMobileNumber, targetElementName);
    }

    @And("the fields are blank and the sign in button is in disabled mode")
    public void verifyElementIsDisabled() {
        String emailValue = currentPage.getWebElement("email input field").getAttribute("value");
        String passwordValue = currentPage.getWebElement("password input field").getAttribute("value");
        Assert.assertEquals(emailValue, "", "Email fields has value");
        Assert.assertEquals(passwordValue, "", "Password field has value");
        boolean isSignInDisabled = currentPage.isButtonOrLinkEnabled("sign in button");
        Assert.assertFalse(isSignInDisabled, "Sign in button is in enabled mode");
    }


    //Made changes
    @And("user verifies if the address field is in non editable mode")
    public void isAddressNonEditable() {
        boolean emailInputNotEditable = currentPage.verifyEmailFieldISEditableOrNot("address input field");
        Assert.assertFalse(emailInputNotEditable, "Address field is in editable");
       // currentPage.clickOn("back link");


//        String actualEmailValue = currentPage.verifyDataEdntered("address input field");
//        Assert.assertEquals(actualEmailValue, getMoreUserAddress, "The data is not a match with the registered data ");

    }

    @And("user fills out the remaining feilds on the page and clicks on reload card button")
    public void fillRemaingForms_Successflow_ManualReload() {
        currentPage.clickOn("address check box");
        Assert.assertTrue(currentPage.isElementDisplayed("credit card number input field"));
        currentPage.enterText("4761739001010119", "credit card number input field");
        currentPage.selectFromDropDownListByContainingText("month dropdown", "March");
        currentPage.selectFromDropDownListByVisibleText("year dropdown", "2033");
        currentPage.enterText("123", "cvv input field");
        currentPage.clickOn("address check box");
        userClicksOn("reload card button");
        boolean isDoneDisplayed = currentPage.waitForElement("done header");
        Assert.assertTrue(isDoneDisplayed, "Manual reload has not been successfull");
    }

    @Then("new address fields will be removed from the screen")
    public void elementNotDisplayed() {
        boolean isElementPresent = currentPage.checkElementIsPresent("city input field");
        Assert.assertFalse(isElementPresent, "city input field is displayed on the screen");
    }

    @Then("user will be seeing {string} on the entered value in the {string}")
    public void compareEnteredValue(String expectedValue, String targetWebElement) {
        String actualValue = currentPage.getWebElement(targetWebElement).getAttribute("value");
        Assert.assertEquals(actualValue, expectedValue, targetWebElement + " is not working as expected");
    }

    @When("user unchecks and checks the checkbox again")
    public void uncheckAndCheck() {
        currentPage.clickOn("address check box");
        currentPage.clickOn("address check box");
    }

    @When("user checks the address checkbox and enters new data")
    public void enterNewData() {
        //currentPage.clickOn("address check box");
        currentPage.clickOn("address check box");
        enterValue("Newyork city", "city input field");
    }


    @When("user sees blank errors are displayed for address section if fields are left blank:")
    public void blankErros(io.cucumber.datatable.DataTable dataTable) throws AWTException {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "streetAddressBlankError":
                    currentPage.isButtonOrLinkEnabled("street address input field");
                    currentPage.enterText(getMoreNewStreetAddress, "street address input field");
                    currentPage.clickOn("street address back arrow");
                    String streetAddressErrorMessage = currentPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(streetAddressErrorMessage, "Please enter your address.", element.getKey() + " field error is not correct");
                    break;

                case "cityBlankError":
                    currentPage.isButtonOrLinkEnabled("street address input field");
                    currentPage.enterText(getMoreNewCity, "city input field");
                    currentPage.clickOn("city back arrow");
                    String cityErrorMessage = currentPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(cityErrorMessage, "Please enter your city.", element.getKey() + " field error is not correct");
                    break;

                case "stateBlankError":
                    currentPage.isButtonOrLinkEnabled("street address input field");
                    currentPage.enterText(getMoreNewState, "state input field");
                    currentPage.clickOn("state back arrow");
                    String stateErrorMessage = currentPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(stateErrorMessage, "Please enter your state.", element.getKey() + " field error is not correct");
                    break;

                case "zipcodeBlankError":
                    currentPage.isButtonOrLinkEnabled("street address input field");
                    currentPage.enterText(getMoreNewZipcode, "zip/postal code input field");
                    currentPage.clickOn("zipcode back arrow");
                    currentPage.clickOn("zip/postal code input field");
                    String zipcodeErrorMessage = currentPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(zipcodeErrorMessage, "Please enter your zip code.", element.getKey() + " field error is not correct");
                    break;
            }
        }
    }


    @Then("user will be able to select reload balance, enter credit card and cvv")
    public void enterCCAndCVV() {
        currentPage.readDropdownValueByString("$10", "reload dropdown");
        currentPage.enterText(getMoreVisaCC, "credit card number input field");
        currentPage.enterText(getMoreVisaCVV, "cvv input field");
        String getCC = currentPage.getWebElement("credit card number input field").getAttribute("value");
        String getcvv = currentPage.getWebElement("cvv input field").getAttribute("value");
        currentPage.selectFromDropDownListByContainingText("month dropdown", "March");
        currentPage.readDropdownValueByString( "2033", "year dropdown");
        Assert.assertEquals(getCC, getMoreVisaCC, "The entered cc value is not proper");
        Assert.assertEquals(getcvv, getMoreVisaCVV, "The entered cvv value is not correct");
    }

    @When("user fills out the address form as below:")
    public void user_fills_out_the_addressForm(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        currentPage.clickOn("address check box");
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "creditCardNumber":
                    currentPage.enterText(getMoreVisaCC, element.getKey() + " input field");
                    break;
                case "cvvNumber":
                    currentPage.enterText(getMoreVisaCVV, element.getKey() + " input field");
                    break;
               case "genericStreetAddress":
                    currentPage.enterText("NewyorkCity", element.getKey() + " input field");
                    break;
                case "genericCity":
                    currentPage.enterText(String.valueOf(currentPage.randomString(7)), element.getKey() + " input field");
                    break;
                case "genericState":
                    currentPage.enterText(String.valueOf(currentPage.randomState()), element.getKey() + " input field");
                    break;
                case "genericZipcode":
                    currentPage.enterText(String.valueOf(currentPage.generateRandomZipcode()), element.getKey() + " input field");
                    break;
            }
        }
    }

    @Given("user navigates to create new password page")
    public void navigateToCreateNewPasswordPage() throws IOException {
        driver.get(getMorePasswordResetUrl);
        moreMobilePageShouldLoadSuccessfully("create new password page");
    }



    @Then("user sees that the following value - {string} will be displayed in the {string}")
    public void selectFirstValue(String valueDisplayed, String targetWebElement) {
        String isCurrentMonthValid = currentPage.readDropdownValueByString(valueDisplayed, targetWebElement);
        Assert.assertEquals(isCurrentMonthValid, valueDisplayed, "Current month displayed in the dropdown is not correct");
    }

    @And("user verifies if the email field is in non editable mode")
    public void verifyEmailFieldISEditableOrNot() {
        boolean emailInputNotEditable = currentPage.verifyEmailFieldISEditableOrNot("email input field");
        Assert.assertFalse(emailInputNotEditable, "Email field is in editable");
    }

    @Then("user should be navigating to the screen until the sign in page")
    public void navigateToSignIn() throws IOException {
        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
        }
    }

    @When("the toggle button is off")
    public void verifyToggleStatus() throws IOException {
        if (currentPage.checkElementIsPresent("toggle button")) {
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            if (currentPage.getWebElement("toggle button").isEnabled()) {
                Assert.assertTrue(currentPage.getWebElement("toggle button").isEnabled());
               // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", currentPage.getWebElement("toggle button"));
                Assert.assertTrue(currentPage.getWebElement("toggle button").isEnabled());
                currentPage.clickOn("back link");
                moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
                currentPage.clickOn("auto reload label");
                moreMobilePageShouldLoadSuccessfully("prepaid card reload page");


            } else {
                currentPage.clickOn("reload dropdown");
                Assert.assertTrue(currentPage.getWebElement("visa card number input field").isEnabled());
            }
        }
    }

    @Then("user sees {string} or {string} on the screen")
    public void checkForEitherOneElement(String targetElement1, String targetElement2) {
        boolean isElementPresent1 = currentPage.checkElementIsPresent(targetElement1);
        boolean isElementPresent2 = currentPage.checkElementIsPresent(targetElement2);
        Assert.assertTrue(isElementPresent1 || isElementPresent2, "Eith of the elements are not displayed on the screen");
    }

    @Then("user checks for click to pay toggle button and turns it off")
    public void deactivateTClickToPay() {

         if(currentPage.checkElementIsPresent("toggle button"))
        {
            boolean isToggleEnabled = currentPage.toggleButtonStatus();
            Assert.assertTrue(isToggleEnabled, "Toggle button is not in enabled mode to turn it off");
            boolean isAddressCheckboxDisplayed = currentPage.isElementInEnabledMode("address check box");
            Assert.assertTrue(isAddressCheckboxDisplayed, "Classic manual reload csreen is not showing up");
        }
        else
        {
           Assert.assertTrue(currentPage.isElementDisplayed("address input field"));
        }
    }

    @Given("user launches the application and navigates to manual or auto reload cancel page by entering valid email and password")
    public void navigationToPrepaidCardReloadPage_AutoOrManual() throws IOException {
        navigateToMoreUrl();
        currentPage.clickOn("already have an account link");

        if(currentPage.checkElementIsPresent("continue with email link"))
        {
            moreMobilePageShouldLoadSuccessfully("different options page");
            currentPage.clickOn("continue with email link");
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("email input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        else
        {
            moreMobilePageShouldLoadSuccessfully("signin existingaccount page");
            enterValue(getMoreManualReloadEmail, "email input field");
            enterValue(getMoreManualReloadPassword, "password input field");
            currentPage.clickOn("sign in button");
            moreMobilePageShouldLoadSuccessfully("dashboard page");
        }
        currentPage.navigationToAddedNewCardImg(getMorePrepaidCardManualReloadNumber);
        //currentPage.navigationToAnyCardOnAccount();
        // currentPage.clickOn("prepaid card button");
        moreMobilePageShouldLoadSuccessfully("prepaid card detail page");
        currentPage.clickOn("manual reload label");
        if(currentPage.checkElementIsPresent("credit card number input field"))
        {
            moreMobilePageShouldLoadSuccessfully("prepaid card manual reload page");
        }
        else if(currentPage.checkElementIsPresent("cancel auto reload through manual flow"))
        {
            moreMobilePageShouldLoadSuccessfully("auto reload cancel page");
            currentPage.clickOn("yes proceed button");
            moreMobilePageShouldLoadSuccessfully("prepaid card manual reload page");
        }

    }

}
