package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class InitialCreateAccountPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[@id='registration']/h1")
    private WebElement createAccountHeader;

    @FindBy(id = "id_email")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[text()='Next Step']")
    private WebElement nextButton;

    @FindBy(xpath = "//*[text()='Back to account options']")
    private WebElement backToLoginOptionsLink;

    @FindBy(xpath = "//input[@id='id_email']/../span/img")
    private WebElement tickMarkImage;

    @FindBy (xpath = "//span[contains(text(), 'That Email Address Is Already In Use. Would You Like To Log In Instead?')]")
    private WebElement existingEmailError;

    @FindBy (xpath = "//*[text()='Login']")
    private WebElement loginThroughCreateScreen;

    @FindBy (xpath = "//*[text()='That Email Address Is Already In Use. Would You Like To Log In Instead?']")
    private WebElement emailAlreadyInUseText;

    @FindBy (xpath = "//a[@data-testid='continueWithEmail']")
    //@FindBy(xpath="//*[text()='continue with email']")
    private WebElement continueWithEmailLink;

    @FindBy (xpath = "//*[text()='Back to account options']")
    private WebElement backToAccountOptionsLink;

    @FindBy (xpath = "//*[text()='Back home']")
    private WebElement backHomeLink;

    @FindBy (xpath = "//*[text()='Already have an account?']")
    private WebElement haveAnAccountLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        By by = null;
        elementName = elementName.toLowerCase();
        switch (elementName) {
            case "page load check element":
            case "next button":
                webElement = nextButton;
                break;

            case "create account header":
                webElement = createAccountHeader;
                break;

            case "email input field":
                webElement = emailInputField;
                break;

            case "existing email error":
                webElement = existingEmailError;
                break;

            case "login button":
                webElement = loginThroughCreateScreen;
                break;

            case "tick mark image":
                webElement = tickMarkImage;
                break;

            case "back to account link":
                webElement = backToLoginOptionsLink;
                break;

            case "email already in use text":
                webElement = emailAlreadyInUseText;
                break;

            case "continue with email link":
                webElement = continueWithEmailLink;
                break;

            case "back to account options link":
                webElement = backToAccountOptionsLink;
                break;

            case "back home link":
                webElement = backHomeLink;
                break;

            case "already have an account link":
                webElement = haveAnAccountLink;
                break;


            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }



    public boolean isElementDisplayed(String targetWebelement)
    {
        boolean isWebElementDisplayed = getWebElement(targetWebelement).isDisplayed();
        if(isWebElementDisplayed)
        {
            LOG.info(targetWebelement + "is present on the page");
        }
        else
        {
            LOG.info(targetWebelement + "is not present on the page");
        }
        return isWebElementDisplayed;
    }

    public void existingEmail_AlreadyRegistered(String alreadyRegisteredEmail) throws AWTException {
        validateEmailCriteria(alreadyRegisteredEmail);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        boolean isElementPresent = isElementDisplayed(alreadyRegisteredEmail);
        wait.until(ExpectedConditions.visibilityOf(existingEmailError));

        if (existingEmailError.isDisplayed())
        {
            LOG.info("Existing email error is displayed");
            boolean loginButtonStatus = loginThroughCreateScreen.isEnabled();
            if(loginButtonStatus)
            {
                LOG.info("Login button is displayed for existing user");
            }
            LOG.info("Login button is displayed for existing user");
        } else {
            LOG.info("Validation for existing email is not done");
        }
    }

    public boolean existingEmailError_AccountCreation(String alreadyRegisteredEmail) throws AWTException {
        existingEmail_AlreadyRegistered(alreadyRegisteredEmail);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(loginThroughCreateScreen));

        if(existingEmailError.isDisplayed())
        {
            LOG.info("That Email Address Is Already In Use. Would You Like To Log In Instead?");
        }
        else if(loginThroughCreateScreen.isDisplayed())
        {
            LOG.info("Login button is showing up for existing email");
        }
        return loginThroughCreateScreen.isEnabled();
    }
    public boolean isLoginPresent()
    {
        return getWebElement("login button").isDisplayed();
    }

    public void loginThroughExistingEmail(String alreadyRegisteredEmail) throws AWTException {
        existingEmail_AlreadyRegistered(alreadyRegisteredEmail);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(loginThroughCreateScreen));
        clickOn("login through create screen");
    }

    public List<WebElement> getElementWithByLocator(String elementName)
    {
        return getElementWithByLocator(elementName);
    }

    public boolean verifyEmailUniqueness(String email) throws AWTException {
        boolean isEmailValid = verifyRegexEmail(email);
        if(!isEmailValid) {
            LOG.info("The entered email is not valid");
        }
        return isEmailValid;
    }

    public boolean isTickMarkPresent()
    {
        return getWebElement("tick mark image").isDisplayed();
    }

}