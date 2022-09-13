package com.cantaloupe.moreMobile.page;


import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//div[@class='styles__Container-sc-ajoebm-0 cUxQNN']/button[text()='Create account']")
    private WebElement createAccountButton;

    @FindBy (xpath = "//*[text()='Already have an account?']")
    private WebElement haveAnAccountLink;

    @FindBy(xpath = "//ul[@class='control-dots']/li")
    private WebElement carousel;

    @FindBy(xpath = "//*[text()='Reload your pass with a credit or debit card']")
    private WebElement firstHeader;

    @FindBy(xpath = "//*[text()='Your More Pass Works with Apple Wallet']")
    private WebElement secondHeader;

    @FindBy(xpath = "//*[text()='Add a CPay pass to pay with digital tokens']")
    private WebElement thirdHeader;

    @FindBy(xpath = "//*[contains(text(), 'View your transactions, get help, and more ')]")
    private WebElement fourthHeader;

    @FindBy(xpath = "//li[@aria-label='slide item 1']")
    private WebElement firstCorousel;

    @FindBy(xpath = "//li[@aria-label='slide item 2']")
    private WebElement firstCarousel;

    @FindBy(xpath = "//li[@aria-label='slide item 3']")
    private WebElement secondCarousel;

    @FindBy(xpath = "//li[@aria-label='slide item 4']")
    private WebElement thirdCarousel;

    @FindBy(xpath = "//li[@aria-label='slide item 5']")
    private WebElement fourthCarousel;

    @FindBy(xpath = "//li[@aria-label='slide item 1']")
    private WebElement initialCorousel;

    @FindBy(xpath = "//img[@src='/images/logo-more-full.svg']")
    private WebElement logo;

    @FindBy (xpath = "//*[text()='continue with email']")
    private WebElement continueWithEmailLink;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "create account button":
                webElement = createAccountButton;
                break;
            case "already have an account link":
                webElement = haveAnAccountLink;
                break;

            case "carousel":
                webElement = carousel;
                break;

            case "first header":
                webElement = firstHeader;
                break;

            case "second header":
                webElement = secondHeader;
                break;

            case "third header":
                webElement = thirdHeader;
                break;

            case "fourth header":
                webElement = fourthHeader;
                break;

            case "first carousel":
                webElement = firstCarousel;
                break;

            case "second carousel":
                webElement = secondCarousel;
                break;

            case "third carousel":
                webElement = thirdCarousel;
                break;

            case "fourth carousel":
                webElement = fourthCarousel;
                break;

            case "initial carousel":
                webElement = initialCorousel;
                break;

            case "logo":
                webElement = logo;
                break;

            case "continue with email link":
                webElement = continueWithEmailLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    public void verifyCarousel() throws InterruptedException {
        List<WebElement> corousalList = driver.findElements(By.xpath("//ul[@class='control-dots']/li"));
        List<WebElement> headerList = new ArrayList<>();
        headerList.add(firstHeader);
        headerList.add(secondHeader);
        headerList.add(thirdHeader);
        headerList.add(fourthHeader);

        for ( int i = 0 ; i<corousalList.size()-1; i++ )
        {
            corousalList.get(i).click();
            WebElement text = headerList.get(i);
            boolean status = text.isDisplayed();
            if(status) {
                LOG.info( "Header is displayed");
            }
            else
            {
                LOG.info( "Header is missing");
            }
        }
    }

    public boolean checkElement(String checkTargetWebElemnt)
    {
        return isElementDislayed(checkTargetWebElemnt);
    }
}