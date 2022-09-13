package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends MoreMobileAbstractBasePage {


    @FindBy(xpath = "//*[text()='Profile']")
    private WebElement profileLink;

    @FindBy(xpath = "//*[text()='Sign out']")
    private WebElement signOutLink;

    @FindBy(xpath = "//img[@src='/icons/plus-orange.svg']")
    private WebElement plusIcon;

    @FindBy(xpath = "//img[@src='/icons/plus-orange.svg']/../../span[contains(text(), 'Add More Card')]")
    private WebElement addMoreCardLink;

    @FindBy(xpath = "//div[@class='styles__CardNumber-sc-1j3b2s7-4 lbZRoy'][contains(text(),'More Card •• ')]")
    private WebElement lastFourDigitsOfCardNumber;

    @FindBy(xpath = "//*[contains(text(),'More Card •• ")
    private WebElement fourDigts;

    @FindBy(xpath = "//button[@class='styles__Container-sc-1ipgw43-0 bxealn']/span[contains(text(), 'FAQ')]")
    private WebElement faqLink;

    @FindBy(xpath = "//img[@alt='more card PREPAID CARD']/../following-sibling::div")
    private WebElement prepaidCardButton;

    @FindBy(xpath="//a[@class='styles__Link-sc-1q28vlj-2 bfrxjx'][contains(text(), 'Privacy Policy')]")
    private WebElement privacyPloicyLink;

    @FindBy(xpath = "//a[@class='styles__Link-sc-1q28vlj-2 bfrxjx'][contains(text(), 'Terms of Use')]")
    private WebElement termsAndConditionsLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "profile link":
                webElement = profileLink;
                break;

            case "sign out link":
                webElement = signOutLink;
                break;

            case "plus icon":
                webElement = plusIcon;
                break;

            case "add more card link":
                webElement = addMoreCardLink;
                break;

            case "faq link":
                webElement = faqLink;
                break;

            case "prepaid card button":
                webElement = prepaidCardButton;
                break;

            case "privacy policy link":
                webElement = privacyPloicyLink;
                break;

            case "terms and condition link":
                webElement = termsAndConditionsLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }
}