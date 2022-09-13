package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.io.IOException;

public class UpdateProfilePage extends MoreMobileAbstractBasePage {


    @FindBy(xpath = "//button[@class='styles__Button-sc-wjqimh-0 jxcitq']")
    private WebElement createAccountButton;

    @FindBy(name = "email")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailFieldNonEditable;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[text()='HOME']")
    private WebElement homeLink;

    @FindBy(xpath = "//*[text()='Edit Profile']")
    private WebElement editProfileHeader;

    @FindBy(xpath = "//*[text()='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordFieldMasked;

    @FindBy(xpath = "//img[@alt='edit icon']")
    private WebElement passwordEditIcon;

    @FindBy(linkText = "Change")
    private WebElement passwordChange;

    @FindBy(xpath = "//*[text()='Details']")
    private WebElement detailsLabel;

    @FindBy(xpath = "//*[text()='First Name']")
    private WebElement firstnameLabel;

    @FindBy(xpath = "//*[text()='Last Name']")
    private WebElement lastnameLabel;

    @FindBy(xpath = "//*[text()='Mobile number']")
    private WebElement mobileNumberLabel;

    @FindBy(xpath = "//*[text()='Street address']")
    private WebElement streetAddressLabel;

    @FindBy(xpath = "//*[text()='City']")
    private WebElement cityLabel;

    @FindBy(xpath = "//*[text()='State']")
    private WebElement stateLabel;

    @FindBy(xpath = "//*[text()='ZIP / Postal code']")
    private WebElement zipcodeLabel;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='mobile']")
    private WebElement mobileInput;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@name='postal']")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//*[text()='Update profile']")
    private WebElement updateButton;

    @FindBy(xpath = "//*[text()='Please enter your first name.']")
    private WebElement firstNameError;

    @FindBy(xpath = "//*[text()='Please enter your last name.']")
    private WebElement lastNameError;

    @FindBy(xpath = "//*[text()='Invalid mobile number.']")
    private WebElement mobileError;

    //@FindBy(xpath = "//input[@name='mobile']/../parent::div/../preceding-sibling::div[1]")
    @FindBy(xpath = "//input[@name='mobile']/../span/img")
    private WebElement mobileUniqueNessError;

    @FindBy(xpath = "//input[@name='mobile']/../span/button")
    private WebElement mobileInputTickMark;

    @FindBy(xpath = "//input[@name='mobile']/../button")
    private WebElement mobileClearIcon;

    @FindBy(xpath = "//*[text()='Please enter your address.']")
    private WebElement streetAddressError;

    @FindBy(xpath = "//*[text()='Please enter your city.']")
    private WebElement cityError;

    @FindBy(xpath = "//*[text()='Please enter your state.']")
    private WebElement stateError;

    @FindBy(xpath = "//*[text()='Please enter your zip code.']")
    private WebElement zipcodeError;

    @FindBy(xpath = "//input[@name='firstName']/../button")
    private WebElement firstNameClearIcon;

    @FindBy(xpath = "//input[@name='lastName']/../button")
    private WebElement lastNameClearIcon;

    @FindBy(xpath = "//input[@name='mobile']/../span/img")
    private WebElement mobileNumberClearIcon;

    @FindBy(xpath = "//input[@name='address1']/../button")
    private WebElement streetAddressClearIcon;

    @FindBy(xpath = "//input[@name='city']/../button")
    private WebElement cityClearIcon;

    @FindBy(xpath = "//input[@name='state']/../button")
    private WebElement stateClearIcon;

    @FindBy(xpath = "//input[@name='postal']/../button")
    private WebElement zipcodeClearIcon;

    @FindBy(xpath = "change password header")
    private WebElement passwordChangeHeader;

    @FindBy(linkText = "Change")
    private WebElement changePasswordLink;

    @FindBy(xpath = "//input[@name='mobile']/../span/img")
    private WebElement tickMarkForMobile;

    @FindBy(xpath = "//*[text()='Sign out']")
    private WebElement signOutLink;

    @FindBy(xpath = "//input[@name='mobile']/../../../../div/span[contains(text(), 'This phone number is already in use.')]")
    private WebElement phoneNoInUseError;

    @FindBy(xpath = "//input[@name='mobile']/../../../../div/span/a")
    private WebElement clickPhoneNo;

    @FindBy(xpath = "//*[text()='The state you entered is invalid. Please re-enter it.']")
    private WebElement invalidStateErrorAlertPopUp;

    @FindBy(xpath = "//*[text()='You entered an invalid postal code for the country US. Please try again.']")
    private WebElement invalidZipcodeErrorAlertPopUp;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'Your profile has been updated.')]")
    private WebElement profileUpdateSuccessAlert;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "create account button":
                webElement = createAccountButton;
                break;

            case "email input field":
                webElement = emailInputField;
                break;

            case "password input field":
                webElement = passwordInputField;
                break;

            case "password change link":
                webElement = changePasswordLink;
                break;


            case "email field non editable":
                webElement = emailFieldNonEditable;
                break;

            case "home link":
                webElement = homeLink;
                break;

            case "edit profile header":
                webElement = editProfileHeader;
                break;

            case "mobile number tick mark image":
                webElement = tickMarkForMobile;
                break;

            case "password label":
                webElement = passwordLabel;
                break;

            case "password field masked":
                webElement = passwordFieldMasked;
                break;

            case "password edit icon":
                webElement = passwordEditIcon;
                break;

            case "mobile clear icon":
                webElement = mobileClearIcon;
                break;

            case "password change":
                webElement = passwordChange;
                break;

            case "details label":
                webElement = detailsLabel;
                break;

            case "first name label":
                webElement = firstnameLabel;
                break;

            case "last name label":
                webElement = lastnameLabel;
                break;

            case "street address label":
                webElement = streetAddressLabel;
                break;

            case "city label":
                webElement = cityLabel;
                break;

            case "state label":
                webElement = stateLabel;
                break;

            case "ziocode label":
                webElement = zipcodeLabel;
                break;

            case "first name input field":
                webElement = firstNameInput;
                break;

            case "last name input field":
                webElement = lastNameInput;
                break;

            case "mobile number input field":
                webElement = mobileInput;
                break;


            case "mobile number label":
                webElement = mobileNumberLabel;
                break;

            case "click phone no":
                webElement = clickPhoneNo;
                break;

            case "street address input field":
                webElement = streetAddressInput;
                break;

            case "city input field":
                webElement = cityInput;
                break;

            case "state input field":
                webElement = stateInput;
                break;

            case "zip/postal code input field":
                webElement = zipcodeInput;
                break;

            case "update button":
                webElement = updateButton;
                break;

            case "first name clear icon":
                webElement = firstNameClearIcon;
                break;

            case "last name clear icon":
                webElement = lastNameClearIcon;
                break;

            case "mobile number clear icon":
                webElement = mobileNumberClearIcon;
                break;

            case "street address clear icon":
                webElement = streetAddressClearIcon;
                break;

            case "city clear icon":
                webElement = cityClearIcon;
                break;

            case "state clear icon":
                webElement = stateClearIcon;
                break;

            case "zipcode clear icon":
                webElement = zipcodeClearIcon;
                break;

            case "first name error":
                webElement = firstNameError;
                break;

            case "last name error":
                webElement = lastNameError;
                break;

            case "mobile number error":
                webElement = mobileError;
                break;

            case "mobile uniqueness error":
                webElement = mobileUniqueNessError;
                break;

            case "mobile input tick mark":
                webElement = mobileInputTickMark;
                break;

            case "phone number in use error":
                webElement = phoneNoInUseError;
                break;


            case "street address error":
                webElement = streetAddressError;
                break;

            case "city error":
                webElement = cityError;
                break;

            case "state error":
                webElement = stateError;
                break;

            case "zipcode error":
                webElement = zipcodeError;
                break;

            case "sign out link":
                webElement = signOutLink;
                break;

            case "invalid state error alert pop up":
                webElement = invalidStateErrorAlertPopUp;
                break;

            case "invalid zipcode error alert pop up":
                webElement = invalidZipcodeErrorAlertPopUp;
                break;

            case "profile update success alert":
                webElement = profileUpdateSuccessAlert;
                break;


            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(editProfileHeader));
            wait.until(ExpectedConditions.visibilityOf(emailFieldNonEditable));
            wait.until(ExpectedConditions.visibilityOf(passwordChange));
            wait.until(ExpectedConditions.visibilityOf(passwordInputField));
            wait.until(ExpectedConditions.visibilityOf(firstNameInput));
            wait.until(ExpectedConditions.visibilityOf(lastNameInput));
            wait.until(ExpectedConditions.visibilityOf(mobileInput));
            wait.until(ExpectedConditions.visibilityOf(streetAddressInput));
            wait.until(ExpectedConditions.visibilityOf(cityInput));
            wait.until(ExpectedConditions.visibilityOf(stateInput));
            wait.until(ExpectedConditions.visibilityOf(zipcodeInput));
            LOG.info(this.getClass().getSimpleName() + " loaded");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warn(this.getClass().getName() + " not loaded with " + e.getMessage());
            return false;
        }
    }

    public boolean verifyUIElements(String targetWebElement) {
        boolean elementName = getWebElement(targetWebElement).isDisplayed();
        if (elementName) {
            LOG.info(targetWebElement + "is displayed on the screen");
        }
        return elementName;
    }

    public boolean verifyEmailFieldISEditableOrNot() {
        ;
        wait.until(ExpectedConditions.visibilityOf(emailFieldNonEditable));
        boolean isEmailNoneditable = emailFieldNonEditable.isEnabled();
        LOG.info("Is the email field editable?:" + isEmailNoneditable);
        return isEmailNoneditable;
    }

    //Verify if the email field value has the same email as login
    public String verifyEmailIEdntered() {
        wait.until(ExpectedConditions.visibilityOf(emailFieldNonEditable));
        String enteredEmail = getWebElement("email field non editable").getAttribute("value");
        LOG.info("email value is: " + enteredEmail);
        return enteredEmail;
    }

    // Verify if Password is masked and check if Change Icon and text is available
    public void verifyPasswordField_UpdateProfile() {
        WebElement passwordChangeText = getWebElement("password change");
        passwordChangeText.click();
        WebElement changePasswordHeader = getWebElement("change password header");
        LOG.info(("Change password header is displayed?: " + changePasswordHeader.isDisplayed()));
    }

    //Click a button, clear the field, random click on screen, and check if an element is available
    public boolean verifyDetailsFieldsAndErrorsDisplayed(String elementToClick, String clickClearIcon, String errorDisplayed) throws AWTException {
        clickOn(elementToClick);
        clickOn(clickClearIcon);
        randomClickBasedOnOS();
        boolean isErrorDisplayed = getWebElement(errorDisplayed).isDisplayed();
        LOG.info("The error message for the " + elementToClick + " is : " + isErrorDisplayed);
        return isErrorDisplayed;
    }

    //Verify if user is able to edit and enter new value in the mobile fields
    public boolean updateMobile(String mobileNumber, String targetWebElement) throws IOException, AWTException {
        WebElement mobileInput = getWebElement(targetWebElement);
        boolean mobileNo = regexPhoneNo(mobileNumber);
        boolean isTickMarkdisplayed = false;
        if (mobileNo) {
            mobileInput.click();
            clearInputfieldAndEnterNewData("mobile number input field", mobileNumber);
            getWebElement("mobile number clear icon").click();
            mobileInput.sendKeys(mobileNumber);
            isTickMarkdisplayed = verifyMobileUniquesNessTick();
        }
        return isTickMarkdisplayed;
    }


    //Verify that if the input number by user is unique, the number will be accepted with a ✓ on the field
    public boolean verifyMobileUniquesNessTick() throws IOException, AWTException {
        randomClickBasedOnOS();
        boolean checkTickMark = isElementEnabled("mobile input tick mark");
        if (checkTickMark) {
            LOG.info("Mobile No entered is unique");
        } else {
            LOG.info("This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748.");
        }
        return checkTickMark;
    }


    //Verify if user is able to edit and enter new value in the street fields
    public boolean updateState(String enterState) {
        WebElement stateInput = getWebElement("state input field");
        boolean state = regexState(enterState);
        if (state) {
            stateInput.click();
            clearInputfieldAndEnterNewData("state input field", enterState);
            LOG.info("Entered state is valid");
        } else {
            LOG.info("Etered state is invalid");
        }
        return state;
    }


    //Verify if user is able to edit and enter new value in the zipcode fields
    public boolean updateZipcode(String zipcode) {
        WebElement zipcodeInput = getWebElement("zipcode input field");
        boolean zipcodeValue = regexZipcode(zipcode);
        zipcodeInput.click();
        return zipcodeValue;
    }

    //Confirm Update Profile
    public String clickUpdateProfileButton() throws AWTException {
        getWebElement("update button").click();
        WebElement alertUpdateProfileSuccess = driver.findElement(By.xpath("//div[contains(@class, 'Toastify__toast-body')]"));
        return alertUpdateProfileSuccess.getText();
    }

    public void clearFieldAndEnterData(String targetWebElement, String enterValue) throws IOException, AWTException {
        clearData(targetWebElement);
        updateMobile(enterValue, targetWebElement);
    }

    //Check if a field is empty or has data
    public boolean checkFiedIsBlankOrHasData(String targetWebElement) {
        WebElement inputBox = getWebElement(targetWebElement);
        String textInsideInputBox = inputBox.getAttribute("value");
        if (textInsideInputBox.isEmpty()) {
            LOG.info(targetWebElement + " is blank.");
            return false;
        } else {
            LOG.info(targetWebElement + "has data.");
            return true;
        }
    }

    //check all possibilitis for mobile field
    public boolean validateErrorsForMobile() {
        wait.until(ExpectedConditions.visibilityOf(mobileUniqueNessError));
        WebElement checkError = mobileUniqueNessError;
        //  if((checkError.getText()).contains("Invalid mobile number.") || (checkError.getText()).contains("already in use")) {
        if (checkElementIsPresent("mobile uniqueness error")) {
            if ((checkError.getText()).contains("Invalid mobile number.") || (checkError.getText()).contains("already in use"))
            {
                LOG.info("Mobile field has invalid data");
                return false;
            }
            //else if (tickMarkForMobile.isDisplayed())
            else if(checkElementIsPresent("mobile number tick mark image"))
            {
                LOG.info("The entered mobile data is valid and will not display any errors");
                return true;
            }
        }
            return false;
        }
}