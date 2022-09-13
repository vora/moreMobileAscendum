package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FAQPage extends MoreMobileAbstractBasePage {


    @FindBy(xpath = "//h1[@class='styles__Text-sc-1m74mmd-0 dRBAgH'][contains(text(), 'FAQ')]")
    private WebElement faqHeader;

    @FindBy(xpath = "//h2[@class='styles__SubHeaderBlack-sc-e24rdh-1 izqxex'][contains(text(), 'log in to the new Web Application?')]")
    private WebElement firstQuestion;

    @FindBy(xpath = "//h2[@class='styles__SubHeaderBlack-sc-e24rdh-1 izqxex'][contains(text(), 'How do I add funds to my MORE Account within the App?')]")
    private WebElement secondQuestion;

    @FindBy(xpath = "//h2[@class='styles__SubHeaderBlack-sc-e24rdh-1 izqxex'][contains(text(), 'Can I track my purchases within the Web App?')]")
    private WebElement thirdQuestion;

    @FindBy(xpath = "//h2[@class='styles__SubHeaderBlack-sc-e24rdh-1 izqxex'][contains(text(), 'who do I contact?')]")
    private WebElement fourthQuestion;

    @FindBy(xpath = "//h2[@class='styles__SubHeaderBlack-sc-e24rdh-1 izqxex'][contains(text(), 'How do I add my Bakkt Card to my MORE Account?')]")
    private WebElement fifthQuestion;

    @FindBy(xpath = "//p[@class='styles__Text-sc-e24rdh-3 bkksfU'][contains(text(), 'If you have an existing MORE Card & a Cantaloupe GetMORE.com account')]")
    private WebElement firstAnswer;

    @FindBy(xpath = "//p[@class='styles__Text-sc-e24rdh-3 bkksfU'][contains(text(), 'Within the MORE App, you will click into the MORE Prepaid')]")
    private WebElement secondAnswer;

    @FindBy(xpath = "//p[@class='styles__Text-sc-e24rdh-3 bkksfU'][contains(text(), 'Yes. There is a transactions section within the app')]")
    private WebElement thirdAnswer;

    @FindBy(xpath = "//p[@class='styles__Text-sc-e24rdh-3 bkksfU'][contains(text(), 'Please find contact information for the machine operator')]")
    private WebElement fourthAnswer;

    @FindBy(xpath = "//p[@class='styles__Text-sc-e24rdh-3 bkksfU'][contains(text(), 'be directed to the Bakkt app')]")
    private WebElement fifthAnswer;

    @FindBy(xpath="//*[text()='HOME']")
    private WebElement homeLink;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "faq header":
                webElement = faqHeader;
                break;

            case "first question":
                webElement = firstQuestion;
                break;

            case "second question":
                webElement = secondQuestion;
                break;


            case "third question":
                webElement = thirdQuestion;
                break;


            case "fourth question":
                webElement = fourthQuestion;
                break;


            case "fifth question":
                webElement = fifthQuestion;
                break;


            case "first answer":
                webElement = firstAnswer;
                break;


            case "second answer":
                webElement = secondAnswer;
                break;


            case "third answer":
                webElement = thirdAnswer;
                break;


            case "fourth answer":
                webElement = fourthAnswer;
                break;


            case "fifth answer":
                webElement = fifthAnswer;
                break;

            case "home link":
                webElement = homeLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

}