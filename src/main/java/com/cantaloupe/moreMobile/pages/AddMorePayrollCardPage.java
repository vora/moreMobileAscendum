package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddMorePayrollCardPage extends MoreMobileAbstractBasePage {

    @FindBy(id = "id_cardNumber")
    private WebElement moreCardNumberInputfield;

    @FindBy(xpath = "//input[@id='id_cardNumber']/../span/img")
    private WebElement cardNumberBackArrow;

    @FindBy(id="id_securityCode")
    private WebElement securityCodeInputField;

    @FindBy(xpath = "//input[@id='id_securityCode']/../span/img")
    private WebElement securityCodeBackArrow;

    @FindBy(xpath = "//div[@class='styles__Container-sc-ajoebm-0 cUxQNN']/button[contains(text(), 'Add More Card')]")
    private WebElement addMoreCardButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'This card has already been registered. Please try another card')]")
    private WebElement moreCardRegisteredAlertPopUp;

    @FindBy(xpath = "//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI'][contains(text(), 'Please enter a valid security code.')]")
    private WebElement invalidSecurityCodeError;

    @FindBy(xpath = "//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI'][contains(text(), 'Please enter a valid card number.')]")
    private WebElement invalidMoreCardNumberError;

    @FindBy(xpath = "//img[@src='/icons/question-mark-circle-orange.svg']")
    private WebElement questionMarkImg;

    @FindBy(xpath = "//img[@src='/icons/question-mark-circle-orange.svg']/following-sibling::div[contains(text(),'Please Contact Your Program Administrator.')]")
    private WebElement dontHaveCardText;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'You entered an invalid payroll deduct card number. Please enter a valid one')]")
    private WebElement invalidMoreCardAlertPopUp;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'The card you entered does not match anything on record; please re-enter it')]")
    private WebElement invalidSecurityMatchalertPopUp;

    @FindBy(xpath = "//*[text()='BACK']")
    private WebElement backLink;

    @FindBy(id = "makePrimary")
    private WebElement setAsPrimaryCheckBox;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'You entered an invalid payroll deduct card number. Please enter a valid one.')]")
    private WebElement invalidMorePayrollCardAlertPopUp;

    @FindBy(xpath="//*[text()='More Card Added']")
    private WebElement moreCardAddedText;

    @FindBy(xpath="//*[text()='More card was successfully added to your account']")
    private WebElement moreCardSuccessText;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "more card number input field":
                webElement = moreCardNumberInputfield;
                break;

            case "security code input field":
                webElement = securityCodeInputField;
                break;

            case "add more card button":
                webElement = addMoreCardButton;
                break;

            case "more card registered alert pop up":
                webElement = moreCardRegisteredAlertPopUp;
                break;

            case "invalid more card number error":
                webElement = invalidMoreCardNumberError;
                break;


            case "invalid security code error":
                webElement = invalidSecurityCodeError;
                break;

            case "question mark image":
                webElement = questionMarkImg;
                break;

            case "dont have card text":
                webElement = dontHaveCardText;
                break;

            case "invalid more card alert pop up":
                webElement = invalidMoreCardAlertPopUp;
                break;

            case "invalid security match alert pop up":
                webElement = invalidSecurityMatchalertPopUp;
                break;

            case "back link":
                webElement = backLink;
                break;

            case "set as primary checkbox":
                webElement = setAsPrimaryCheckBox;
                break;

            case "invalid more payroll card alert pop up":
                webElement = invalidMorePayrollCardAlertPopUp;
                break;

            case "card number back arrow":
                webElement = cardNumberBackArrow;
                break;

            case "security code back arrow":
                webElement = securityCodeBackArrow;
                break;

            case "more card added text":
                webElement = moreCardAddedText;
                break;

            case "more card success text":
                webElement = moreCardSuccessText;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }
}