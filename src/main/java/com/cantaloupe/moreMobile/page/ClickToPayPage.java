package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ClickToPayPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//input[starts-with(@id, 'toggle_')]")
    private WebElement toggleButton;

    @FindBy(id = "agreement")
    private WebElement addressCheckBox;

    @FindBy(xpath = "//*[text()='Enroll in Click to Pay']")
    private WebElement enrollInClickToPayButton;

    @FindBy(xpath = "//h2[@class='heading-xl'][contains(text(), 'Mastercard Click to Pay')]")
    private WebElement masterCardRegistrationPopUp;

    @FindBy(xpath = "//a[@data-test='cancel-button-header']")
    private WebElement closeIcon;

    @FindBy(id = "confirmation-modal-modalLabel")
    private WebElement confirmclosePopUp;

    @FindBy(xpath = "//div[@class='Toastify__toast-body'][contains(text(), 'Something went wrong, please try again later or check out another way.')]")
    private WebElement seomethingWentWrongAlertPopUp;

    @FindBy(xpath = "//div[@data-test='contact-section-userid']")
    private WebElement prefilledEmail;

    @FindBy(xpath = "//div[@data-test='contact-section-phone']")
    private WebElement prefilledPhoneNo;

    @FindBy(xpath = "//span[@data-test='country-text']")
    private WebElement prefilledCountry;

    @FindBy(xpath = "//button[@data-test='btn-identity']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@data-test='btn-cta-modal'][contains(text(), ' RETURN TO MERCHANT')]")
    private WebElement returnToMerchantButton;

    @FindBy(id = "confirmation-modal-modalLabel")
    private WebElement returnToCantaloupeModalPopUp;

    @FindBy(xpath = "//iframe[@title='dcf']")
    private WebElement clickToPayiFrame;

    @FindBy(xpath = "//button[@data-test='btn-close-modal'][contains(text(), ' Cancel')]")
    private WebElement cancelLink;

    @FindBy(xpath = "//button[@data-test='edit'][contains(text(), 'Edit')]")
    private WebElement editLink;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberInputField;

    @FindBy(id = "userId")
    private WebElement emailInputfield;

    @FindBy(xpath = "//button[@data-test='btn-identity'][contains(text(), 'CONTINUE')]")
    private WebElement continueButtonOnContactInformation;

    @FindBy(xpath = "//button[@data-test='guest-checkout'][contains(text(), 'No, thanks')]")
    private WebElement noThanksLinkOnContactInformation;

    @FindBy(xpath = "//p[contains(text(), 'Check out as a guest')]")
    private WebElement checkOutAsAGuestHeader;

    @FindBy(xpath = "//button[@data-test='btn-continue'][contains(text(), 'CONFIRM')]")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='styles__Title-sc-1uj3v6o-2 byBLCi'][contains(text(), 'Pay With')]")
    private WebElement payWithText;

    @FindBy(id = "verification-code-0")
    private WebElement firstVerificationcode;

    @FindBy(id = "verification-code-1")
    private WebElement secondVerificationcode;

    @FindBy(id = "verification-code-2")
    private WebElement thirdVerificationcode;

    @FindBy(id = "verification-code-3")
    private WebElement fourthVerificationcode;

    @FindBy(id = "verification-code-4")
    private WebElement fifthVerificationcode;

    @FindBy(id = "verification-code-5")
    private WebElement sixthVerificationcode;

    @FindBy(xpath = "//i[@class='icon-arrow-right']")
    private WebElement contactArrow;

    @FindBy(xpath = "//button[@data-test='btn-continue'][contains(text(), 'UPDATE CONTACT INFORMATION')]")
    private WebElement updateContactInformation;

    @FindBy(xpath = "//button[@data-test='go-back']")
    private WebElement goBackLink;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "toggle button":
                webElement = toggleButton;
                break;

            case "address check box":
                webElement = addressCheckBox;
                break;

            case "enroll in click to pay button":
                webElement = enrollInClickToPayButton;
                break;

            case "master card registration pop up":
                webElement = masterCardRegistrationPopUp;
                break;

            case "close icon":
                webElement = closeIcon;
                break;

            case "confirm close pop up":
                webElement = confirmclosePopUp;
                break;

            case "seomething went wrong alert pop up":
                webElement = seomethingWentWrongAlertPopUp;
                break;

            case "prefilled email":
                webElement = prefilledEmail;
                break;

            case "prefilled phone no":
                webElement = prefilledPhoneNo;
                break;

            case "prefilled country":
                webElement = prefilledCountry;
                break;

            case "continue button":
                webElement = continueButton;
                break;

            case "return to merchant button":
                webElement = returnToMerchantButton;
                break;

            case "return to cantaloupe modal pop up":
                webElement = returnToCantaloupeModalPopUp;
                break;

            case "click to pay iframe":
                webElement = clickToPayiFrame;
                break;

            case "cancel link":
                webElement = cancelLink;
                break;

            case "edit link":
                webElement = editLink;
                break;

            case "email input field":
                webElement = emailInputfield;
                break;

            case "phone number input field":
                webElement = phoneNumberInputField;
                break;

            case "continue button on contact information":
                webElement = continueButtonOnContactInformation;
                break;

            case "no thanks link on contact information":
                webElement = noThanksLinkOnContactInformation;
                break;

            case "check out a as a guest header":
                webElement = checkOutAsAGuestHeader;
                break;

            case "confirm button":
                webElement = confirmButton;
                break;

            case "pay with text":
                webElement = payWithText;
                break;

            case "first verification code":
                webElement = firstVerificationcode;
                break;

            case "second verification code":
                webElement = secondVerificationcode;
                break;

            case "third verification code":
                webElement = thirdVerificationcode;
                break;

            case "fourth verification code":
                webElement = fourthVerificationcode;
                break;

            case "fifth verification code":
                webElement = fifthVerificationcode;
                break;

            case "sixth verification code":
                webElement = sixthVerificationcode;
                break;

            case "contact arrow":
                webElement = contactArrow;
                break;

            case "update contact information":
                webElement = updateContactInformation;
                break;

            case "go back link":
                webElement = goBackLink;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }

    public boolean toggleButtonStatus() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        if (getWebElement("toggle button").isEnabled()) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", toggleButton);
            return true;
        }
        return false;
    }
}