package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class ChangePasswordPage extends MoreMobileAbstractBasePage {

    @FindBy (xpath = "//*[text()='Change password']")
    private WebElement changePasswordText;

    @FindBy(id= "id_oldPassword")
    private WebElement oldPasswordInputField;

    @FindBy(id= "id_password")
    private WebElement passwordInputField;

    @FindBy(id= "id_confirmPassword")
    private WebElement confirmPasswordInputField;

    @FindBy(xpath = "//input[@id='id_oldPassword']/../span/span[contains(text(), 'Show')]")
    private WebElement passwordShowLink;

    @FindBy(xpath = "//input[@id='id_oldPassword']/../span/span[contains(text(), 'Hide')]")
    private WebElement passwordHideLink;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Show')]")
    private WebElement newPasswordShowLink;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Hide')]")
    private WebElement newPpasswordHideLink;

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


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "change password text":
                webElement = changePasswordText;
                break;

            case "old password input field":
                webElement = oldPasswordInputField;
                break;

            case "password input field":
                webElement = passwordInputField;
                break;

            case "confirm password input field":
                webElement = confirmPasswordInputField;
                break;

            case "show password link":
                webElement = passwordShowLink;
                break;

            case "hide password link":
                webElement = passwordHideLink;
                break;

            case "new password show link":
                webElement = newPasswordShowLink;
                break;

            case "new password hide link":
                webElement = newPpasswordHideLink;
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

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    public void clickBackSpaceForPassword(String targetWebElement) throws AWTException {
        getWebElement(targetWebElement).click();
        clearInputfieldAndEnterNewData( targetWebElement, "qwer");
        getWebElement(targetWebElement).sendKeys(Keys.BACK_SPACE);
        randomClickBasedOnOS();
    }

}