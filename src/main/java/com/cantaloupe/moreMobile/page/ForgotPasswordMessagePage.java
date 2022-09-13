package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordMessagePage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[contains(text(),'Send me a reset link')]")
    private WebElement sendMeAResetLink;

    @FindBy(id = "id_password")
    private WebElement password;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

            switch (elementName) {
                case "page load check element":

                case "send me a reset link":
                    webElement = sendMeAResetLink;
                    break;

                case "create new password input field":
                    webElement = password;
                    break;

                default:
                    LOG.error("Element \"" + elementName + "\" is not registered in this class");
                    throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
            }

        return webElement;
    }

    public boolean verifySendMeALinkStatus(String targetWEbElement)
    {
        if(!(targetWEbElement.isEmpty()) && !sendMeAResetLink.isEnabled())
        {
            LOG.info( "Forgot Password functionality is working as expected");
            return true;
        }
        else
        {
           LOG.info("Forgot Password functionality is not working as expected" );
           return false;
        }
    }
}