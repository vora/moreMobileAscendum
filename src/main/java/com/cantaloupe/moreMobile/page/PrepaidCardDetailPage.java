package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrepaidCardDetailPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//div[@class='styles__Header-sc-47v5no-1 dKAYcy']/div[contains(text(), 'Auto Reload')]")
    private WebElement autoReloadLabel;

    @FindBy(xpath = "//button[@class='styles__Container-sc-1ipgw43-0 bxealn']/span[contains(text(), 'Manually Reload')]")
    private WebElement manualReloadLabel;

    @FindBy(xpath = "//span[@class='styles__Active-sc-47v5no-2 bxyYXt'][contains(text(), 'Inactive')]")
    private WebElement inactiveLabel;

    @FindBy(xpath = "//span[@class='styles__Active-sc-47v5no-2 bfUGVh'][contains(text(), 'Active')]")
    private WebElement activeLabel;

    @FindBy(xpath = "//div[@class='styles__Balance-sc-11pok88-1 fvtTnn'][contains(text(), 'Balance')]")
    private WebElement balanceLabel;

    @FindBy(xpath = "//span[@class='styles__Active-sc-47v5no-2 bfUGVh']")
    private WebElement autoReloadStatus;

    @FindBy(xpath = "//*[text()='You Have Auto Reload Turned On']")
    private WebElement cancelAutoReloadThroughManualFlow;


    @FindBy(xpath = "//h1[@class='styles__Text-sc-1m74mmd-0 RSciX'][contains(text(), 'Reload Card')]")
    private WebElement autoreloadHeader;

    @FindBy(id = "id_cardnumber")
    private WebElement creditCardNumberInputField;

    @FindBy(xpath = "//h1[@class='styles__Text-sc-1m74mmd-0 RSciX'][contains(text(), 'Set Up Auto Reload')]")
    private WebElement setUpAutoReloadHeader;

    @FindBy(xpath = "//h1[@class='styles__Text-sc-1m74mmd-0 RSciX'][contains(text(), 'Auto Reload')]")
    private WebElement autoReloadHeader;


    @FindBy(xpath = "//img[@alt='apple wallet']")
    private WebElement addtoWalletButton;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "auto reload label":
                webElement = autoReloadLabel;
                break;

            case "inactive label":
                webElement = inactiveLabel;
                break;

            case "active label":
                webElement = activeLabel;
                break;

            case "balance label":
                webElement = balanceLabel;
                break;

            case "auto reload status":
                webElement = autoReloadStatus;
                break;

            case "manual reload label":
                webElement = manualReloadLabel;
                break;

            case "reload card header":
                webElement = autoreloadHeader;

            case "cancel auto reload through manual flow":
                webElement = cancelAutoReloadThroughManualFlow;
                break;

            case "credit card number input field":
                webElement = creditCardNumberInputField;
                break;

            case "set up auto reload header":
                webElement = setUpAutoReloadHeader;
                break;

            case "auto reload header":
                webElement = autoReloadHeader;
                break;

            case "add to wallet button":
                webElement = addtoWalletButton;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }

    public boolean toggleOffAutoReload() {
        String isStatusActive = autoReloadStatus.getText();
        if (isStatusActive.equals("Active")) {
            LOG.info("Auto reload is active. Toggle it off");
            clickOn("active label");
            return true;
        } else if (isStatusActive.equals("Inactive")) {
            LOG.info("Auto reload is inactve. Proceed with the reloading");
            return false;
        }
        return false;
    }
}

