package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;


public class ForgotPasswordPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[contains(text(),'sent you a reset link')]")
    private WebElement resetLinkSentToEmail;

    @FindBy(xpath = "//h1[text()='Forgot password?']/../div/div/input")
    private WebElement forgotPasswordEmailInput;

    @FindBy(xpath = "//*[contains(text(),'Send me a reset link')]")
    private WebElement sendMeAResetLink;

    @FindBy(xpath =  "//h1[text()='Forgot password?']")
    private WebElement forgotPasswordHeader;

    @FindBy(xpath = "//*[contains(text(),'Password must be between 8 and 20 characters')]")
    private WebElement passwordErrorCriteria;

    @FindBy(xpath = "//div[contains(text(), 'Passwords Do Not Match')]")
    private WebElement passwordDoNotMatchError;

    @FindBy (xpath = "//*[text()='Update password']")
    private WebElement updatePasswordButton;

    @FindBy(id = "id_email")
    private WebElement emailInputField;

    @FindBy (xpath = "//*[text()='Password Meets Criteria']")
    private WebElement passwordMeetsCriteria;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":

            case "forgot password header":
                webElement = forgotPasswordHeader;
                break;

            case "forgot password email input":
                webElement = forgotPasswordEmailInput;
                break;

            case "send me a reset link":
                webElement = sendMeAResetLink;
                break;

            case "reset link sent to email":
                webElement = resetLinkSentToEmail;
                break;

            case "password error criteria":
                webElement = passwordErrorCriteria;
                break;

            case "password do not match error":
                webElement = passwordDoNotMatchError;
                break;

            case "update password button":
                webElement = updatePasswordButton;
                break;

            case "email input field":
                webElement = emailInputField;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    public boolean verifySendMeALinkStatus(String targetWEbElement)
    {
        if(!(targetWEbElement.isEmpty()) && !sendMeAResetLink.isEnabled())
        {
            LOG.info( "Forgot Password functionality is working as expected");
            return true;
        }
        else
        {
            LOG.info("Forgot Password functionality is not working as expected" );
            return false;
        }
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


}