package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrepaidCardManualReloadPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//h1[@class='styles__Text-sc-1m74mmd-0 RSciX'][contains(text(), 'Reload Card')]")
    private WebElement autoreloadHeader;

    @FindBy(xpath = "//select[@name='replenish']")
    private WebElement reloadDropDown;

    @FindBy(xpath = "//select[@name='replenishMin']")
    private WebElement balanceDropfown;

    @FindBy(id = "id_cardnumber")
    private WebElement creditCardNumberInputField;


    @FindBy(xpath = "//span[text()='Please enter your bank credit card number.']")
    private WebElement creditCardBlankError;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'You entered an invalid credit card number. Please enter a valid one')]")
    private WebElement invalidCardNumberAlertPopUp;

    @FindBy(name = "ccmonth")
    private WebElement monthDropdown;

    @FindBy(name = "ccyear")
    private WebElement yearDropdown;

    @FindBy(id = "id_cvv")
    private WebElement cvvInputField;

    @FindBy(xpath = "//span[text()='Please enter your bank credit card number.']")
    private WebElement monthYearBlankError;

    @FindBy(xpath = "//span[text()='Please enter a valid security code, 3 or 4 digits only.']")
    private WebElement cvvBlankError;

    @FindBy(xpath = "//span[text()='Show']")
    private WebElement cvvShowLink;

    @FindBy(xpath = "//span[text()='Hide']")
    private WebElement cvvHideLink;

    @FindBy(name = "address1")
    private WebElement addressInputField;

    @FindBy(xpath = "//div[text()='Done']")
    private WebElement doneHedaer;

    @FindBy(xpath = "//button[]text()=' Back to home'")
    private WebElement backToHomeLink;

    @FindBy(xpath = "//input[starts-with(@id,'toggle_')]")
    private WebElement toggleButton;

    @FindBy(id = "agreement")
    private WebElement addressCheckBox;

    @FindBy(id = "id_address")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id='id_address']/../span/img")
    private WebElement streetAddressBackArrow;

    @FindBy(xpath = "//input[@id='id_address']/../../div/span[contains(text(), 'Please enter your address.')]")
    private WebElement blankStreetAddressError;

    @FindBy(id = "id_city")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='id_city']/../span/img")
    private WebElement cityBackArrow;

    @FindBy(xpath = "//input[@id='id_city']/../../div/span[contains(text(), 'Please enter your city.')]")
    private WebElement blankCityError;

    @FindBy(id = "id_state")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='id_state']/../span/img")
    private WebElement stateBackArrow;

    @FindBy(xpath = "//input[@id='id_state']/../../div/span[contains(text(), 'Please enter your state.')]")
    private WebElement blankStateError;

    @FindBy(id = "id_postal")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//input[@id='id_postal']/../span/img")
    private WebElement zipcodeBackArrow;

    @FindBy(xpath = "//input[@id='id_postal']/../../div/span[contains(text(), 'Please enter your zip code.')]")
    private WebElement blankZipcodeError;

    @FindBy (xpath = "//*[text()='The state you entered is invalid. Please re-enter it.']")
    private WebElement invalidStateErrorAlertPopUp;

    @FindBy (xpath = "//*[text()='You entered an invalid postal code for the country US. Please try again.']")
    private WebElement invalidZipcodeErrorAlertPopUp;

    @FindBy(xpath="//button[text()='Reload Card']")
    private WebElement reloadCardButton;


    @FindBy(xpath = "//button[text()='Schedule Reload']")
    private WebElement scheduleReloadButton;

    @FindBy(xpath = "//button[]text()=' Back'")
    private WebElement backLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            //case "set up auto reload header":
            case "reload card header":
                webElement = autoreloadHeader;
                break;

            case "reload dropdown":
                webElement = reloadDropDown;
                break;

            case "balance dropdown":
                webElement = balanceDropfown;
                break;

            case "credit card number input field":
                webElement = creditCardNumberInputField;
                break;

            case "credit card blank error":
                webElement = creditCardBlankError;
                break;

            case "invalid card number alert pop up":
                webElement = invalidCardNumberAlertPopUp;
                break;

            case "month dropdown":
                webElement = monthDropdown;
                break;

            case "year dropdown":
                webElement = yearDropdown;
                break;

            case "cvv input field":
                webElement = cvvInputField;
                break;

            case "month year blank error":
                webElement = monthYearBlankError;
                break;

            case "cvv blank error":
                webElement = cvvBlankError;
                break;

            case "cvv show link":
                webElement = cvvShowLink;
                break;

            case "cvv hide link":
                webElement = cvvHideLink;
                break;

            case "address input field":
                webElement = addressInputField;
                break;

            case "done header":
                webElement = doneHedaer;
                break;

            case "back to home link":
                webElement = backToHomeLink;
                break;

            case "toggle button":
                webElement = toggleButton;
                break;

            case "address check box":
                webElement = addressCheckBox;
                break;

            case "street address input field":
                webElement = streetAddressInput;
                break;

            case "street address back arrow":
                webElement = streetAddressBackArrow;
                break;

            case "blank street address error":
                webElement = blankStreetAddressError;
                break;

            case "city input field":
                webElement = cityInput;
                break;

            case "blank city error":
                webElement = blankCityError;
                break;

            case "city back arrow":
                webElement = cityBackArrow;
                break;

            case "state back arrow":
                webElement = stateBackArrow;
                break;

            case "zipcode back arrow":
                webElement = zipcodeBackArrow;
                break;

            case "state input field":
                webElement = stateInput;
                break;

            case "blank state error":
                webElement = blankStateError;
                break;

            case "invalid state error alert pop up":
                webElement = invalidStateErrorAlertPopUp;
                break;

            case "zip/postal code input field":
                webElement = zipcodeInput;
                break;

            case "invalid zipcode error alert pop up":
                webElement = invalidZipcodeErrorAlertPopUp;
                break;

            case "blank zipcode error":
                webElement = blankZipcodeError;
                break;

            case "reload card button":
                webElement = reloadCardButton;
                break;

            case "schedule reload button":
                webElement = scheduleReloadButton;
                break;

            case "back link":
                webElement = backLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }

    public boolean toggleButtonOff() {
        return getWebElement("toggle button").isSelected();
    }
}


