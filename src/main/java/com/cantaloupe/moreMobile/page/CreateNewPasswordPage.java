package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewPasswordPage extends MoreMobileAbstractBasePage {

    @FindBy (xpath = "//*[text()='Create new password']")
    private WebElement createNewPasswordHeader;

    @FindBy(id= "id_password")
    private WebElement passwordInputField;

    @FindBy(id= "id_confirmPassword")
    private WebElement confirmPasswordInputField;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Show')]")
    private WebElement passwordShowLink;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Hide')]")
    private WebElement passwordHideLink;

    @FindBy(xpath = "//input[@id='id_confirmPassword']/../span/span[contains(text(), 'Show')]")
    private WebElement confirmPasswordShowLink;

    @FindBy(xpath = "//input[@id='id_confirmPassword']/../span/span[contains(text(), 'Hide')]")
    private WebElement confirmPasswordHideLink;

    @FindBy(xpath = "//*[contains(text(),'Password must be between 8 and 20 characters')]")
    private WebElement passwordErrorCriteria;

    @FindBy(xpath = "//div[contains(text(), 'Passwords Do Not Match')]")
    private WebElement passwordDoNotMatchError;

    @FindBy (xpath = "//*[text()='Update password']")
    private WebElement updatePasswordButton;

    @FindBy (xpath = "//*[text()='Password Meets Criteria']")
    private WebElement passwordMeetsCriteria;

    @FindBy (xpath = "//*[text()='Your password is updated.']")
    private WebElement yourPasswordIsUpdatedText;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'Authentication failure')]")
    private WebElement authenticationFailureAlertPopUp;

    @FindBy (xpath = "//*[text()='The passcode is expired. A new email has been sent to you. Please use that to change your password.']")
    private WebElement passcodeIsExpiredAlertPopUp;

    @FindBy (xpath = "//*[text()='Back to welcome screen']")
    private WebElement backToWelcomeScreen;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "create new password header":
                webElement = createNewPasswordHeader;
                break;


            case "password input field":
                webElement = passwordInputField;
                break;

            case "confirm password input field":
                webElement = confirmPasswordInputField;
                break;

            case "password show link":
                webElement = passwordShowLink;
                break;

            case "password hide link":
                webElement = passwordHideLink;
                break;

            case "confirm password show link":
                webElement = confirmPasswordShowLink;
                break;

            case "confirm password hide link":
                webElement = confirmPasswordHideLink;
                break;

            case "password error criteria":
                webElement = passwordErrorCriteria;
                break;

            case "password meets criteria":
                webElement = passwordMeetsCriteria;
                break;

            case "password do not match error":
                webElement = passwordDoNotMatchError;
                break;

            case "update password button":
                webElement = updatePasswordButton;
                break;

            case "your password is updated text":
                webElement = yourPasswordIsUpdatedText;
                break;

            case "authentication failure alert pop up":
                webElement = authenticationFailureAlertPopUp;
                break;

            case "passcode is expired alert pop up":
                webElement = passcodeIsExpiredAlertPopUp;
                break;

            case "back to welcome screen link":
                webElement = backToWelcomeScreen;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }


}