package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrLoginWithDifferentOptions extends MoreMobileAbstractBasePage {

    @FindBy (xpath = "//a[@data-testid='continueWithEmail']")
    private WebElement continueWithEmailLink;

    @FindBy (xpath = "//*[text()='Back home']")
    private WebElement backHomeLink;

    @FindBy(xpath = "//*[text()='Sign In']")
    private WebElement signInText;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();


            switch (elementName) {
                case "page load check element":
                case "continue with email link":
                    webElement = continueWithEmailLink;
                    break;

                case "sign in text":
                    webElement = signInText;
                    break;

                case "back home link":
                    webElement = backHomeLink;
                    break;

                default:
                    LOG.error("Element \"" + elementName + "\" is not registered in this class");
                    throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
            }

        return webElement;
    }
}