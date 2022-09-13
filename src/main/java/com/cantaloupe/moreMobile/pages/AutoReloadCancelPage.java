package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutoReloadCancelPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[text()='You Have Auto Reload Turned On']")
    private WebElement cancelAutoReloadThroughManualFlow;

    @FindBy(xpath="//button[contains(text(), 'Yes, Proceed')]")
    private WebElement yesProceedButton;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":

            case "cancel auto reload through manual flow":
                webElement = cancelAutoReloadThroughManualFlow;
                break;


            case "yes proceed button":
                webElement = yesProceedButton;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }
        return webElement;
    }

    public boolean cancelAutReload()
    {
        return cancelAutoReloadThroughManualFlow.isDisplayed() && yesProceedButton.isEnabled();
    }

    public boolean cancelAutoReloadFlow() {
        boolean isStatusActive = cancelAutReload();
        if (isStatusActive) {
            LOG.info("Auto reload is active. Cancel it through manual flow");
            clickOn("yes proceed button");
            return true;
        } else
        {
            LOG.info("Auto reload is inactve. Proceed with the auto reload flow");
            return false;
        }
    }

}