package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.CreateAccountPage;
import com.cantaloupe.moreMobile.pages.UpdateProfilePage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class UpdateProfile_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    UpdateProfilePage updateProfilePage = new UpdateProfilePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    private final String getMoreEmail = props.getProperty("more_mobile_Email");
    private final String getMorePassword = props.getProperty("more_mobile_Password");
    private final String getMoreUpdateProfileEmail = props.getProperty("more_mobile_UpdateProfileEmail");
    private final String getMoreUpdateProfilePassword = props.getProperty("more_mobile_UpdateProfilePassword");



    public UpdateProfile_steps() throws IOException {
    }

    @Then("user verifies the email value present against the registered value")
    public void verifyEmailIEdntered() {
        String actualEmailValue = updateProfilePage.verifyEmailIEdntered();
        Assert.assertTrue((actualEmailValue.equalsIgnoreCase(getMoreUpdateProfileEmail)), "The data is not a match with the registered data ");
    }

    @When("user verifies if the password field has masked value")
    public void verifyPasswordIsMasked()
    {
        updateProfilePage.checkPasswordMaskedOrNot("password field masked");
    }


    @When("user updates the mobile field for {string} in {string}")
    public void updateMobileField(String newMobileNumber, String targetWebElement) throws AWTException, IOException {
        updateProfilePage.clickBackSpaceForMobile(targetWebElement);
        //updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("mobile number input field", "mobile number clear icon", "mobile number error");
        updateProfilePage.clearFieldAndEnterData("mobile number input field", " ");
        updateProfilePage.clickOn(targetWebElement);
        updateProfilePage.clickOn("mobile clear icon");
        updateProfilePage.enterText(String.valueOf(updateProfilePage.regexPhoneNo(newMobileNumber)), targetWebElement);
    }

    @Then("user confirms the update has been a success by clicking on update button")
    public void clickUpdateProfileButton() throws AWTException {
        // String actualConfirmationTextValue = updateProfilePage.clickUpdateProfileButton();
        updateProfilePage.clickOn("update button");
        //String expectedConfirmationTextValue = "Your profile has been updated.";
        boolean profileUpdateStatus = updateProfilePage.waitForElement("profile update success alert");
        Assert.assertTrue(profileUpdateStatus, "Update has not been successfull");
    }

    @When("user check if there are any error displayed on the screen")
    public void verifyAnyErrorsDisplayedOnScreen() {
        updateProfilePage.checkForAnyErrorsOnScreen();
    }

    @When("user see's if the phone number used is unique or there are any errors displayed")
    public void verifyMobileuniquemness() {
        createAccountPage.checkForMobileErros("mobile input field");

    }

    @When("user tries to update {string} in the mobile number")
    public void updatesinglefield(String value) {
        createAccountPage.clearData("mobile number input field");
        createAccountPage.enterText(value, "mobile number input field");
    }


    @Then("user confirms the update has been a success by clicking on update button_")
    public void clickUpdateProfileButton_() throws AWTException {
        String actualConfirmationTextValue = updateProfilePage.clickUpdateProfileButton();
        String expectedConfirmationTextValue = "Your profile has been updated.";
        Assert.assertEquals(actualConfirmationTextValue, expectedConfirmationTextValue, "Update was not successfull");
    }

    @When("user fills out the Update Profile form as below:")
    public void user_fills_out_the_update_profile_form_as_below(io.cucumber.datatable.DataTable dataTable) throws AWTException, IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {



            switch (element.getValue()) {
                case "genericFirstName":
                   // String updateProfileFirstName = updateProfilePage.getTextForInput("first name input field");
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    updateProfilePage.clearData(element.getKey().toLowerCase() + " input field");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    //updateProfilePage.clickOn("first name clear icon");
                   // updateProfilePage.deleteCharacters(updateProfileFirstName);
                    updateProfilePage.enterText("TestFirstName" + String.valueOf(updateProfilePage.randomString(2)), element.getKey() + " input field");
                    break;
                case "genericLastName":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    //updateProfilePage.clickOn("last name clear icon");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    updateProfilePage.enterText("TestLastName" + String.valueOf(updateProfilePage.randomString(2)), element.getKey() + " input field");
                    break;
                case "genericMobileNo":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    updateProfilePage.clickBackSpaceForMobile(element.getKey().toLowerCase() + " input field");
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    updateProfilePage.clearInputfieldAndEnterNewData(element.getKey().toLowerCase() + " input field", "2");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                   // updateProfilePage.clickOn("mobile number clear icon");
                    updateProfilePage.enterText(String.valueOf(updateProfilePage.generateRandomNumberString()), element.getKey() + " input field");
                    break;
                case "genericStreetAddress":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    //updateProfilePage.clickOn("street address clear icon");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    updateProfilePage.enterText("NewyorkCityMason", element.getKey() + " input field");
                    break;
                case "genericCity":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    //updateProfilePage.clickOn("city clear icon");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    updateProfilePage.enterText("TestCity" + String.valueOf(updateProfilePage.randomString(2)), element.getKey() + " input field");
                    break;
                case "genaricState":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                   // updateProfilePage.clickOn("state clear icon");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    updateProfilePage.enterText(String.valueOf(updateProfilePage.randomState()), element.getKey() + " input field");
                    break;
                case "genericZipcode":
                    updateProfilePage.clickOn(element.getKey().toLowerCase() + " input field");
                    //updateProfilePage.clickOn("zipcode clear icon");
                    updateProfilePage.clearFieldAndEnterData( element.getKey().toLowerCase() + " input field", "3");
                    updateProfilePage.enterText(String.valueOf(updateProfilePage.generateRandomZipcode()), element.getKey() + " input field");
                    break;
            }
        }
    }

    @Then("user verifies if the error message is displayed for blank fields on the page:")
    public void blankErrors(io.cucumber.datatable.DataTable dataTable) throws AWTException, IOException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "firstNameBlankError":
                    updateProfilePage.clickOn("first name input field");
                    updateProfilePage.clearFieldAndEnterData( "first name input field", "");
                    updateProfilePage.clickBackspaceFromKeyboard("first name input field");
                    boolean firstname = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("first name input field", "first name clear icon", element.getKey());


                   // updateProfilePage.clickOn("last name input field");
                   // boolean firstname = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("first name input field",  element.getKey());
                    Assert.assertTrue(firstname, "Please enter your first name error is not displayed");
                    break;

                case "lastNameBlankError":
                    updateProfilePage.clickOn("last name input field");
                    updateProfilePage.clearFieldAndEnterData( "last name input field", "");
                    boolean lastname = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("last name input field",  "last name clear icon", element.getKey());
                    Assert.assertTrue(lastname, "Please enter your last name error is not displayed");
                    break;

                case "streetAddressBlankError":
                    updateProfilePage.clickOn("street address input field");
                    updateProfilePage.clearFieldAndEnterData( "street address input field", " ");
                    boolean streetAddress = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("street address input field", "street address clear icon",  element.getKey());
                    Assert.assertTrue(streetAddress, "Please enter a valid street address error is not displayed");
                    break;

                case "cityBlankError":
                    updateProfilePage.clickOn("city input field");
                    updateProfilePage.clearFieldAndEnterData( "city input field", " ");
                    boolean city = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("city input field", "city clear icon", element.getKey());
                    Assert.assertTrue(city, "Please enter a valid city error is not displayed");
                    break;

                case "stateBlankError":
                    updateProfilePage.clickOn("state input field");
                    updateProfilePage.clearFieldAndEnterData( "state input field", " ");
                    boolean state = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("state input field", "state clear icon",  element.getKey());
                    Assert.assertTrue(state, "Please enter a valid state error is not displayed");
                    break;

                case "zipcodeBlankError":
                    updateProfilePage.clickOn("zip/postal code input field");
                    updateProfilePage.clearFieldAndEnterData( "zip/postal code input field", " ");
                    boolean zipcode = updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("zip/postal code input field", "zipcode clear icon", element.getKey());
                    Assert.assertTrue(zipcode, "Please enter a valid zip/postal code error is not displayed");
                    break;
            }
        }
    }


    @And("user see's if there are any null values on the page")
    public void fieldsWithNullValue(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "blankFirstName":
                    boolean firstnameInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean firstname = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(firstname && firstnameInput, "First name does not have a value");
                    break;

                case "blankLastName":
                    boolean lastnameInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean lastname = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(lastname && lastnameInput, "Lastname does not have a value");
                    break;

                case "blankStreetAddress":
                    boolean streetAddressInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean streetAddress = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(streetAddress && streetAddressInput, "Street address does not have a value");
                    break;

                case "blankCity":
                    boolean cityInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean city = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(city && cityInput, "City does not have a value");
                    break;

                case "blankState":
                    boolean stateInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean state = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(state && stateInput, "State does not have a value");
                    break;

                case "blankZipcode":
                    boolean zipcodeInput = updateProfilePage.isButtonOrLinkEnabled(element.getKey().toLowerCase() + " input field");
                    boolean zipcode = updateProfilePage.checkFiedIsBlankOrHasData(element.getKey().toLowerCase() + " input field");
                    Assert.assertTrue(zipcode && zipcodeInput, "Zipcode does not have a value");
                    break;
            }
        }
    }


    @When("user updates the mobile field with a unique number")
    public void updateMobileWithUniqueNumber() throws AWTException, IOException {
        updateProfilePage.clickBackSpaceForMobile("mobile number input field");
       // updateProfilePage.verifyDetailsFieldsAndErrorsDisplayed("mobile number input field", "mobile number clear icon", "mobile number error");
        updateProfilePage.clearFieldAndEnterData("mobile number input field", " ");
        updateProfilePage.clickOn("mobile number input field");
        updateProfilePage.clickOn("mobile clear icon");
        updateProfilePage.enterText(String.valueOf(updateProfilePage.regexPhoneNo(String.valueOf(updateProfilePage.generateRandomNumberString()))), "mobile number input field");
    }

    @Then("user see's the tick mark for mobile field")
    public void verifyTickMark()
    {
        boolean isTickMarkDisplayed = updateProfilePage.validateErrorsForMobile();
        Assert.assertTrue(isTickMarkDisplayed, "Tick mark is not displayed");
    }

}