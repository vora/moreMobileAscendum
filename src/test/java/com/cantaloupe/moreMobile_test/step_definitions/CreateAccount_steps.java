package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.CreateAccountPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;


public class CreateAccount_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String getMoreEmail = props.getProperty("more_mobile_Email");
    private final String getMorePassword = props.getProperty("more_mobile_Password");

    @Then("user sees the {string} is already prefilled in the {string} field on the page")
    public void verifyPrefilledEmailInput(String prefilledEmail, String targetWebElement) {
        String generatedEmail = createAccountPage.prefilledEmail(targetWebElement);
        Assert.assertEquals(generatedEmail, prefilledEmail, "The emails listed on both the screens are not equal");
    }

    @And("user is able to edit the {string} with {string}")
    public void verifyEmailIsEditable(String targetWebElement, String enterNewEmailId) {
        String generatedemail = createAccountPage.verifyEmailIsEditable(targetWebElement, enterNewEmailId);
        Assert.assertEquals(generatedemail, enterNewEmailId, "The email field is not edited with the new test data and it is not correct");
    }

    @Then("user see's the placeholders for all the fields on the screen")
    public void checkPleaceHolders() {
        boolean isPlaceHolderPresent = createAccountPage.verifyPlaceHolders();
        Assert.assertTrue(isPlaceHolderPresent, "Placeholders are not displayed on the screen");
    }

    @Then("a {string} should be displaying for the password or wrong fields")
    public void displayeErrorMessages_Password(String wrongPasswordOrConfirmPassword) throws AWTException {
        boolean errorMessage = createAccountPage.ErrorMessageForPasswordAndConfirmPassword(wrongPasswordOrConfirmPassword);
        Assert.assertTrue(errorMessage, "Error messages are not displayd");
    }

    @Then("user is able to see the entered {string} and compare them for {string}")
    public void getPasswordsAndCompare(String enteredPassword, String targetelement) {
        String value = createAccountPage.getPasswords(targetelement);
        String enteredPwd = createAccountPage.comparePasswords(targetelement, enteredPassword);
        Assert.assertEquals(enteredPwd, value, "Both the values are not same");
    }

    @Then("user compares if {string} and {string} has the same value")
    public void comparePasswords(String passwordInputElement, String confirmpasswordInputElement) {
        String passwordValue = createAccountPage.retrievePasswordValue(passwordInputElement);
        String confirmPasswordValue = createAccountPage.retrievePasswordValue(confirmpasswordInputElement);
        Assert.assertEquals(passwordValue, confirmPasswordValue, "Password and Confirm password does not have same value");
    }

    @Then("user sees if {string} error for {string} on entering {string} in {string}")
    public void verifyBlankErrorForEmail1(String expectedErrorMessage, String targetWebElement, String wrongEmail, String emailInputfield) {
        enterText(wrongEmail, emailInputfield);
        String actualErrorMessage = createAccountPage.validateErrorMessages(targetWebElement);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages are not matching");
    }

    @Then("user sees if blank email error is displayed on entering a wrong {string}")
    public void verifyBlankErrorForEmail(String wrongEmail) {
        enterText(wrongEmail, "email input field");
        String actualErrorMessage = createAccountPage.validateErrorMessages("blank email error");
        Assert.assertEquals(actualErrorMessage, "Please enter a valid email address.", "The email error message is not displaying on the screen");
    }

    @And("user verifies the entered {string}")
    public void verifyPhoneRegex(String phoneNo) {
        boolean isNumberValid = createAccountPage.regexPhoneNo(phoneNo);
        Assert.assertTrue(isNumberValid, "The entered phone number is not valid");
    }

    @And("user verifies if there is any error message displayed for the {string} input field")
    public void verifErrorsForMobile(String phoneNumber) throws IOException, AWTException {
        boolean enteredNumber = createAccountPage.verifyPhoneNoInput(phoneNumber);
        Assert.assertTrue(enteredNumber, "The entered phone number is not valid");
    }


    @Then("user verifies if the mobile number is a valid entry or not by using regexPhone expression")
    public void generateMobileNo() {
        long generatedMobileNo = createAccountPage.generateRandomMobileNo();
        boolean isValidEntry = createAccountPage.regexPhoneNo(String.valueOf(generatedMobileNo));
        Assert.assertTrue(isValidEntry, "Phone number is not valid");
    }

    @When("user enters valid password in password input field")
    public void regexPassword() {
        createAccountPage.regexPassword(getMorePassword);
    }

    @When("user enters valid {string} in confirm password input field")
    public void regexConfirmPassword(String enterValue) {
        createAccountPage.regexConfirmPassword(enterValue);
    }

    @When("user enters valid number in mobile number input field")
    public void enterRegexPhoneNo() {
        createAccountPage.enterText(String.valueOf(createAccountPage.regexPhoneNo(String.valueOf(createAccountPage.generateRandomMobileNo()))), "mobile number input field");
    }

    @When("user enters valid {string} in street address input field")
    public void regexStreetAddress(String enterValue) {
        createAccountPage.regexStreetAddress(enterValue);
    }

    @When("user enters valid {string} in city input field")
    public void regexCity(String enterValue) {
        createAccountPage.regexCity(enterValue);
    }

    @When("user enters valid {string} in state input field")
    public void regexState(String enterValue) {
        createAccountPage.regexState(enterValue);
    }

    @When("user enters valid {string} in zipcode input field")
    public void regexZipcode(String enterValue) {
        createAccountPage.regexZipcode(enterValue);
    }

    @And("user tries to verify {string} is a valid entry or not by using regexFirstname expression")
    public void regexFirstname(String enterValue) {
        boolean isValidEntry = createAccountPage.regexFirstname(enterValue);
        Assert.assertTrue(isValidEntry, "Firstname is not valid");
    }

    @When("user enters {string} in {string}")
    public void enterText(String enterValue, String targetWEbElement) {
        createAccountPage.sendText(enterValue, targetWEbElement);
    }

    @And("user tries to verify {string} is a valid entry or not by using regexLastname expression")
    public void regexLastname(String enterValue) {
        boolean isValidEntry = createAccountPage.regexLastname(enterValue);
        Assert.assertTrue(isValidEntry, "Lastname is valid");
    }


    @And("user see's no error messages on the screen")
    public void verifyListOfErrors() {
        boolean getListOfErrors = createAccountPage.checkForAnyErrorsOnScreen();
        if (getListOfErrors) {
            Assert.fail("Error messages are not displaying on the screen");
        } else {
            Assert.assertTrue(true, "Error messages are not displaying on the screen");
        }
    }

    @When("user fills out the create account form as below:")
    public void user_fills_out_the_update_profile_form_as_below(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        createAccountPage.clickOn("consent check box");
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "createPassword":
                    createAccountPage.enterText("Pass@123", element.getKey() + " input field");
                    break;
                case "confirmPassword":
                    createAccountPage.enterText("Pass@123", element.getKey() + " input field");
                    break;
                case "genericFirstName":
                    createAccountPage.enterText(String.valueOf(createAccountPage.randomString(10)), element.getKey() + " input field");
                    break;
                case "genericLastName":
                    createAccountPage.enterText(String.valueOf(createAccountPage.randomString(10)), element.getKey() + " input field");
                    break;
                case "genericMobileNo":
                    createAccountPage.enterText(String.valueOf(createAccountPage.generateRandomNumberString()), element.getKey() + " input field");
                    break;
                case "genericStreetAddress":
                    createAccountPage.enterText(String.valueOf(createAccountPage.randomString(10)), element.getKey() + " input field");
                    break;
                case "genericCity":
                    createAccountPage.enterText(String.valueOf(createAccountPage.randomString(7)), element.getKey() + " input field");
                    break;
                case "genericState":
                    createAccountPage.enterText(String.valueOf(createAccountPage.randomState()), element.getKey() + " input field");
                    break;
                case "genericZipcode":
                    createAccountPage.enterText(String.valueOf(createAccountPage.generateRandomZipcode()), element.getKey() + " input field");
                    break;
            }
        }
    }

    @When("user sees blank errors are displayed if fields are left blank:")
    public void blankErros(io.cucumber.datatable.DataTable dataTable) throws AWTException {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "firstNameBlankError":
                    createAccountPage.enterText("1", "firstname input field");
                    createAccountPage.clickOn("firstname back arrow");
                    String firstnameErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(firstnameErrorMessage, "Please enter your first name.", element.getKey() + " field error is not correct");
                    break;

                case "lastNameBlankError":
                    createAccountPage.enterText("1", "lastname input field");
                    createAccountPage.clickOn("lastname back arrow");
                    String lastnameErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(lastnameErrorMessage, "Please enter your last name.", element.getKey() + " field error is not correct");
                    break;

                case "mobileNoBlankError":
                    createAccountPage.enterText("1", "mobile number input field");
                    String mobileNumberErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(mobileNumberErrorMessage, "Invalid mobile number.", element.getKey() + " field error is not correct");
                    break;

                case "streetAddressBlankError":
                    createAccountPage.enterText("gjhhjgh", "street address input field");
                    createAccountPage.clickOn("street address back arrow");
                    String streetAddressErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(streetAddressErrorMessage, "Please enter your address.", element.getKey() + " field error is not correct");
                    break;

                case "cityBlankError":
                    createAccountPage.enterText("1", "city input field");
                    createAccountPage.clickOn("city back arrow");
                    String cityErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(cityErrorMessage, "Please enter your city.", element.getKey() + " field error is not correct");
                    break;

                case "stateBlankError":
                    createAccountPage.enterText("1", "state input field");
                    createAccountPage.clickOn("state back arrow");
                    String stateErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(stateErrorMessage, "Please enter your state.", element.getKey() + " field error is not correct");
                    break;

                case "zipcodeBlankError":
                    createAccountPage.enterText("1", "zip/postal code input field");
                    createAccountPage.clickOn("zipcode back arrow");
                    createAccountPage.clickOn("zip/postal code input field");
                    String zipcodeErrorMessage = createAccountPage.validateErrorMessages(element.getKey());
                    Assert.assertEquals(zipcodeErrorMessage, "Please enter your zip code.", element.getKey() + " field error is not correct");
                    break;
            }
        }
    }
}
