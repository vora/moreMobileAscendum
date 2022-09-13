package com.cantaloupe.moreMobile.pages;


import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInWithExistingAccountPage extends MoreMobileAbstractBasePage {



    @FindBy(xpath = "//*[@id='login']/div[2]/button[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement signInHeader;

    @FindBy(id = "id_email")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='id_password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='id_password']/../../div/span[contains(text(), 'Please enter your password.')]")
    private WebElement blankPasswordError;

    @FindBy(xpath = "//input[@id='id_email']/../../div/span[contains(text(), 'Please enter your email.')]")
    private WebElement blankOrInvalidEmailError;

    @FindBy(xpath="//input[@id='id_email']/../span/img")
    private WebElement emailBackArrowImg;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Show')]")
    private WebElement passwordShowLink;

    @FindBy(xpath = "//input[@id='id_password']/../span/span[contains(text(), 'Hide')]")
    private WebElement passwordHideLink;

    @FindBy(xpath = "//*[text()='Invalid email address or password.']")
    private WebElement invalidalertPopUp;

    @FindBy(xpath = "//*[text()='Back to login options']")
    private WebElement backToLoginOptionsLink;

    @FindBy(xpath = "//*[text()='Forgot password?']")
    private WebElement forgotPasswordLink;

    @FindBy (xpath = "//*[text()='Back home']")
    private WebElement backHomeLink;

    @FindBy (xpath = "//*[text()='Back to login options']")
    private WebElement getBackToLoginOptionsLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "sign in button":
                webElement = signInButton;
                break;

            case "email input field":
                webElement = emailInputField;
                break;

            case "email back arrow img":
                webElement = emailBackArrowImg;
                break;

            case "password input field":
                webElement = passwordInputField;
                break;

            case "blank password error":
                webElement = blankPasswordError;
                break;

            case "password show link":
                webElement = passwordShowLink;
                break;

            case "password hide link":
                webElement = passwordHideLink;
                break;

            case "blank or invalid email error":
                webElement = blankOrInvalidEmailError;
                break;

            case "invalid alert pop up":
                webElement = invalidalertPopUp;
                break;

            case "back to login options":
                webElement = backToLoginOptionsLink;
                break;

            case "forgot password link":
                webElement = forgotPasswordLink;
                break;

            case "sign in header":
                webElement = signInHeader;
                break;

            case "back home link":
                webElement = backHomeLink;
                break;

            case "back to login options link":
                webElement = backToLoginOptionsLink;
                break;




            default:
                LOG.error("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
        }
        return webElement;
    }

    //Verify if the sign in button is in disabled mode when there is no data entered
    public void verifySignInDisabled(String signInButton)
    {
        if(getWebElement(signInButton).isEnabled())
        {
            LOG.info("Sign iin button is enabled and is not working as expected");
        }
        else
        {
           LOG.info("Sign in button is wprking according to the functionality");
        }
    }

    public void verifyBlankError(String email)
    {
        enterText(email, "email input field");
    }

    public void focusOnFields(String targetWebElement) {
        WebElement element = getWebElement(targetWebElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        element.sendKeys(Keys.SHIFT);
    }

    public boolean verifyAlertPopUp()
    {
        wait.until(ExpectedConditions.visibilityOf(invalidalertPopUp));
        boolean isAlertDisplayed = isElementDisplayed("invalid alert pop up");
        return isAlertDisplayed;
    }
}