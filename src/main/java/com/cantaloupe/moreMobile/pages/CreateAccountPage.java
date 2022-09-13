package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAccountPage extends MoreMobileAbstractBasePage {

    @FindBy(id = "id_email")
    private WebElement emailInputField;

//    @FindBy(xpath="//input[@id='id_email']/../span/img")
    @FindBy(css="//img[src='/icons/check-circle-orange.svg']")
    private WebElement emailBackArrow;

    @FindBy(xpath = "//input[@id='id_email']/../label")
   // @FindBy(css = "//label[@id='id_email][label[innerText='Enter your email*']")
    private WebElement emailinputfieldPlaceholders;

    @FindBy(xpath = "//input[@id='id_password']/../label")
    private WebElement createPasswordInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_confirmPassword']/../label")
    private WebElement confirmPasswordInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_firstName']/../label")
    private WebElement firstnameInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_lastName']/../label")
    private WebElement lastnameInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_mobile']/../label")
    private WebElement mobileInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_address']/../label")
    private WebElement addressInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_city']/../label")
    private WebElement cityInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_state']/../label")
    private WebElement stateInputFieldPlaceHolders;

    @FindBy(xpath = "//input[@id='id_postal']/../label")
    private WebElement zipcodeInputFieldPlaceHolders;

    @FindBy(id = "id_password")
    private WebElement passwordInputField;

    @FindBy(id = "id_confirmPassword")
    private WebElement confirmPassInputField;

    @FindBy(xpath = "//*[contains(text(),'Password must be between 8 and 20 characters')]")
    private WebElement passwordErrorCriteria;

    @FindBy(xpath = "//div[contains(text(), 'Passwords Do Not Match')]")
    private WebElement passwordDoNotMatchError;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Show')]")
    private WebElement passwordShowLink;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Hide')]")
    private WebElement passwordHideLink;

    @FindBy(xpath = "//input[@id='id_confirmPassword']/../span/span[contains(text(), 'Show')]")
    private WebElement confirmShowLink;

    @FindBy(xpath = "//input[@id='id_confirmPassword']/../span/span[contains(text(), 'Hide')]")
    private WebElement confirmHideLink;

    @FindBy(id = "id_firstName")
    private WebElement firstnameInputField;

    @FindBy(xpath = "//input[@id='id_email']/../../div/span")
    private WebElement blankEmailError;

    @FindBy(xpath = "//input[@id='id_firstName']/../../div/span")
    private WebElement blankFirstnameError;

    @FindBy(xpath = "//input[@id='id_firstName']/../span/img")
    private WebElement firstnameBackArrow;

    @FindBy(id = "id_lastName")
    private WebElement lastnameInputField;

    @FindBy(xpath = "//input[@id='id_lastName']/../../div/span")
    private WebElement blankLastnameError;

    @FindBy(xpath = "//input[@id='id_lastName']/../span/img")
    private WebElement lastnameBackArrow;

    @FindBy(id = "id_mobile")
    private WebElement mobileNumberInputField;

    @FindBy(xpath = "//input[@id='id_mobile']/../../div/span[contains(text(), 'This phone number is already in use.')]")
    private WebElement phoneNoInUseError;

    @FindBy(xpath = "//input[@id='id_mobile']/../preceding-sibling::div/span[contains(text(), 'Invalid mobile number.')]")
    private WebElement invalidMobileNumberError;

    @FindBy(xpath = "//input[@id='id_mobile']/../span/img")
    private WebElement mobileNumberTickMarkImage;

    @FindBy(xpath = "//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']")
    private WebElement listOfErrors;

    @FindBy(id = "id_address")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id='id_address']/../span/img")
    private WebElement streetAddressBackArrow;

    @FindBy(xpath = "//input[@id='id_address']/../../div/span[contains(text(), 'Please enter your address.')]")
    private WebElement blankStreetAddressError;

    @FindBy(id = "id_city")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='id_city']/../span/img")
    private WebElement cityBackArrow;

    @FindBy(xpath = "//input[@id='id_city']/../../div/span[contains(text(), 'Please enter your city.')]")
    private WebElement blankCityError;

    @FindBy(id = "id_state")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='id_state']/../span/img")
    private WebElement stateBackArrow;

    @FindBy(xpath = "//input[@id='id_state']/../../div/span[contains(text(), 'Please enter your state.')]")
    private WebElement blankStateError;

    @FindBy(id = "id_postal")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//input[@id='id_postal']/../span/img")
    private WebElement zipcodeBackArrow;

    @FindBy(xpath = "//input[@id='id_postal']/../../div/span[contains(text(), 'Please enter your zip code.')]")
    private WebElement blankZipcodeError;

    @FindBy(xpath = "//input[@id='agreement']/../div")
    private WebElement consentCheckBox;

    @FindBy(xpath = "//input[@id='agreement']/../../preceding-sibling::div/span[contains(text(), 'You must consent to our Privacy Policy and Terms of Use.')]")
    private WebElement consentCheckBoxErrorMessage;

    @FindBy(xpath = "//*[text()='Complete']")
    private WebElement completeButton;

    @FindBy(xpath="//*[text()='Terms of Use']")
    private WebElement termsOfUseLink;

    @FindBy(xpath = "//*[text()='Privacy Policy']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//*[text()='Back to Sign Up']")
    private WebElement backToSignUp;

    @FindBy(xpath = "//*[@id='registration']/label")
    private WebElement readAndAgreeText;

    @FindBy (xpath = "//*[text()='Login']")
    private WebElement loginThroughCreateScreen;

    @FindBy (xpath = "//*[text()='Password Meets Criteria']")
    private WebElement passwordMeetsCriteria;

    @FindBy (xpath = "//*[text()='That Email Address Is Already In Use. Would You Like To Log In Instead?']")
    private WebElement emailAlreadyInUseText;

    @FindBy (xpath = "//*[text()='The state you entered is invalid. Please re-enter it.']")
    private WebElement invalidStateErrorAlertPopUp;

    @FindBy (xpath = "//*[text()='You entered an invalid postal code for the country US. Please try again.']")
    private WebElement invalidZipcodeErrorAlertPopUp;

    @FindBy(xpath = "//input[@id='id_mobile']/../../div/span/a")
    private WebElement clickPhoneNo;

    @FindBy(xpath = "//*[text()='MORE User Terms']")
    private WebElement moreTermsUseText;

    @FindBy(xpath = "//*[text()='Effective Date: November 17, 2016']")
    private WebElement privacyPolicytext;

    @FindBy(xpath = "//span[contains(text(), 'This Phone Number Must Be Unique And In Your Possession.')]")
    private WebElement phoneNumberInPossessionLabel;

    @FindBy(xpath = "//span[contains(text(), 'Please Try Resetting The User Information')]")
    private WebElement tryResettingPhoneNumberLabel;

    @FindBy(xpath="//div[contains(text(), 'Enter personal details')]")
    private WebElement personalDetailsHeader;

    @FindBy(xpath="//*[text()='Back to account options']")
    private WebElement backToAccountOptionsLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "email input field":
                webElement = emailInputField;
                break;

            case "email back arrow":
                webElement = emailBackArrow;
                break;

            case "email placeholders":
                webElement = emailinputfieldPlaceholders;
                break;

            case "create password placeholders":
                webElement = createPasswordInputFieldPlaceHolders;
                break;

            case "email already in use text":
                webElement = emailAlreadyInUseText;
                break;

            case "password input field":
                webElement = passwordInputField;
                break;

            case "password meets criteria":
                webElement = passwordMeetsCriteria;
                break;

            case "password error criteria":
                webElement = passwordErrorCriteria;
                break;

            case "confirm password input field":
                webElement = confirmPassInputField;
                break;

            case "password do not match error":
                webElement = passwordDoNotMatchError;
                break;

            case "confirmpassword placeholders":
                webElement = confirmPasswordInputFieldPlaceHolders;
                break;

            case "firstname placeholders":
                webElement = firstnameInputFieldPlaceHolders;
                break;

            case "lastname placeholders":
                webElement = lastnameInputFieldPlaceHolders;
                break;

            case "mobile placeholders":
                webElement = mobileInputFieldPlaceHolders;
                break;

            case "address placeholders":
                webElement = addressInputFieldPlaceHolders;
                break;

            case "city placeholders":
                webElement = cityInputFieldPlaceHolders;
                break;

            case "state placeholders":
                webElement = stateInputFieldPlaceHolders;
                break;

            case "zipcode placeholders":
                webElement = zipcodeInputFieldPlaceHolders;
                break;

            case "password show link":
                webElement = passwordShowLink;
                break;

            case "password hide link":
                webElement = passwordHideLink;
                break;

            case "confirm password show link":
                webElement = confirmShowLink;
                break;

            case "confirm password hide link":
                webElement = confirmHideLink;
                break;

            case "firstname input field":
                webElement = firstnameInputField;
                break;

            case "firstname back arrow":
                webElement = firstnameBackArrow;
                break;

            case "blank email error":
                webElement = blankEmailError;
                break;

            case "blank firstname error":
                webElement = blankFirstnameError;
                break;

            case "lastname input field":
                webElement = lastnameInputField;
                break;

            case "blank lastname error":
                webElement = blankLastnameError;
                break;

            case "lastname back arrow":
                webElement = lastnameBackArrow;
                break;

            case "mobile number input field":
                webElement = mobileNumberInputField;
                break;

            case "invalid phone number error":
                webElement = invalidMobileNumberError;
                break;

            case "phone number in use error":
                webElement = phoneNoInUseError;
                break;

            case "mobile number tick mark image":
                webElement = mobileNumberTickMarkImage;
                break;

            case "list of errors":
                webElement = listOfErrors;
                break;

            case "street address input field":
                webElement = streetAddressInput;
                break;

            case "street address back arrow":
                webElement = streetAddressBackArrow;
                break;

            case "blank street address error":
                webElement = blankStreetAddressError;
                break;

            case "city input field":
                webElement = cityInput;
                break;

            case "blank city error":
                webElement = blankCityError;
                break;

            case "city back arrow":
                webElement = cityBackArrow;
                break;

            case "state back arrow":
                webElement = stateBackArrow;
                break;

            case "zipcode back arrow":
                webElement = zipcodeBackArrow;
                break;

            case "state input field":
                webElement = stateInput;
                break;

            case "blank state error":
                webElement = blankStateError;
                break;

            case "invalid state error alert pop up":
                webElement = invalidStateErrorAlertPopUp;
                break;

            case "zip/postal code input field":
                webElement = zipcodeInput;
                break;

            case "invalid zipcode error alert pop up":
                webElement = invalidZipcodeErrorAlertPopUp;
                break;

            case "blank zipcode error":
                webElement = blankZipcodeError;
                break;

            case "consent check box":
                webElement = consentCheckBox;
                break;

            case "consent check box error":
                webElement = consentCheckBoxErrorMessage;
                break;

            case "complete button":
                webElement = completeButton;
                break;

            case "terms of use link":
                webElement = termsOfUseLink;
                break;

            case "privacy policy link":
                webElement = privacyPolicyLink;
                break;

            case "privacy policy text":
                webElement = privacyPolicytext;
                break;

            case "more terms use text":
                webElement = moreTermsUseText;
                break;

            case "back to sign up button":
                webElement = backToSignUp;
                break;

            case "read and agree text":
                webElement = readAndAgreeText;
                break;

            case "login button":
                webElement = loginThroughCreateScreen;
                break;

            case "click phone no":
                webElement = clickPhoneNo;
                break;

            case "phone number in possession label":
                webElement = phoneNumberInPossessionLabel;
                break;

            case "try resetting phone number label":
                webElement = tryResettingPhoneNumberLabel;
                break;

            case "personal details header":
                webElement = personalDetailsHeader;
                break;

            case "back to account options link":
                webElement = backToAccountOptionsLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
        }
        return webElement;
    }

    public String prefilledEmail(String targetWebElement) {
        WebElement emailId = getWebElement(targetWebElement);
        return emailId.getAttribute("value");
    }

    public String verifyEmailIsEditable(String targetWebElement, String enterNewEmailId) {
        WebElement emailId = getWebElement(targetWebElement);

        clearInputfieldAndEnterNewData(targetWebElement, enterNewEmailId);
        return emailId.getAttribute("value");
    }

    public boolean verifyPlaceHolders() {
        Character email = getLastCharacter(emailinputfieldPlaceholders.getText());
        Character cp = getLastCharacter(createPasswordInputFieldPlaceHolders.getText());
        Character pwd = getLastCharacter(confirmPasswordInputFieldPlaceHolders.getText());
        Character fn = getLastCharacter(firstnameInputFieldPlaceHolders.getText());
        Character ln = getLastCharacter(lastnameInputFieldPlaceHolders.getText());
        Character mobile = getLastCharacter(mobileInputFieldPlaceHolders.getText());
        Character si = getLastCharacter(addressInputFieldPlaceHolders.getText());
        Character ci = getLastCharacter(cityInputFieldPlaceHolders.getText());
        Character stateI = getLastCharacter(stateInputFieldPlaceHolders.getText());
        Character zi = getLastCharacter(zipcodeInputFieldPlaceHolders.getText());

        Character[] myChar = {email, cp, pwd, fn, ln, si, stateI, ci, zi, mobile};
        ArrayList<Character> retrivedChar = new ArrayList<>();
        retrivedChar.addAll(java.util.List.of(myChar));

        for (Character s : myChar) {
            Character star = '*';
            if (star.equals(s)) {
                LOG.info("* is added at the end of all the placeHolders");
                return true;
            } else {
                LOG.info( "The placeHolders does not have a * in it");
                return false;
            }
        }
        return true;
    }

    public void tryWrongPassword(String wrongPassword) {
        enterText("DSDS", "password input field");
    }

    public boolean ErrorMessageForPasswordAndConfirmPassword(String wrongPasswordOrConfirmPassword) throws AWTException {
        randomClickBasedOnOS();
        WebElement passwordError = getWebElement(wrongPasswordOrConfirmPassword);
        boolean status = passwordError.isDisplayed();
        if (status) {

            LOG.info("Password criteria is validated");
        } else {
            LOG.info("Password criteria is not validated");
        }
        return status;
    }

    public String getPasswords(String targetelement) {
        return getWebElement(targetelement).getAttribute("value");
    }

    public String comparePasswords(String targetelement, String enteredPassword) {
        String getPasswordValue = getPasswords(targetelement);
        if (enteredPassword.equals(getPasswordValue)) {
            LOG.info("Entered data and the value present in the field both are same");
        } else {
            LOG.info("Entered data and the value present in the field both are not same");
        }
        return enteredPassword;
    }

    public String retrievePasswordValue(String targetElement)
    {
        String retrievedValue = getWebElement(targetElement).getAttribute("value");
        LOG.info(targetElement + "value is " + retrievedValue);
        return retrievedValue;
    }

    public boolean verifyPhoneNoInput(String phoneNumber) throws AWTException, IOException {
        randomClickBasedOnOS();
        boolean isNumberValid = regexPhoneNo(phoneNumber);
        WebElement phoneTick = mobileNumberTickMarkImage;
        if(isNumberValid && phoneTick.getAttribute("src").equals("/icons/check-circle-orange.svg"))
        {
            LOG.info("Entered phone number is unique");
        }
        return isNumberValid;
    }

    public boolean verifyErrorAfterTenDigitsEntry()
    {
        String phoneNoText = mobileNumberInputField.getAttribute("value");
        boolean phoneNoInUse =  isElementEnabled("phone number in use error");
        boolean invalidNoError = isElementEnabled("invalid phone number error");
        WebElement uniquenessError = phoneNoInUseError;
        String numberOnly = phoneNoText.replaceAll("[^0-9]", "");

        int phoneNoLength = numberOnly.length();
        if(phoneNoLength==10 && phoneNoInUse)
        {
            WebElement phoneNoLinkText = driver.findElement(By.linkText ("+1-888-561-4748"));
            if(uniquenessError.isDisplayed()){
                LOG.info("Error message is displayed after entering 10 digits");
            }
            if(phoneNoLinkText.isEnabled())
            {
                LOG.info("The link is in enabled mode");
            }
            wait.until(ExpectedConditions.elementToBeClickable (phoneNoLinkText));
            return true;
        }
        else if(invalidNoError)
        {
            LOG.info( "Invalid mobile number.");
            return false;
        }
        else
        {
            LOG.info("Error messages for mobile is not displayed properly");
        }
        return false;
    }

    public void scrollToTheElement(String targetElementName)
    {
        scrollToTheElementAndClick(targetElementName);
    }

    public boolean isConsentCheckboxPreChecked()
    {
        boolean checkboxErrorStatus = consentCheckBoxErrorMessage.isDisplayed();// WebElement checkboxStatus = driver.findElement(accountCreationLocators.checkboxForTerms);
        if(checkboxErrorStatus)
        {
            LOG.info("Check box is unchecked");
            clickOn("consent check box");
        }
        else
        {
            LOG.info("Checkbox is already checked");
        }
        return checkboxErrorStatus;
    }

    public long generateRandomMobileNo()
    {
        return generateRandomNumberString();
    }
}