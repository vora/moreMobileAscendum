package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmRegistrationPage extends MoreMobileAbstractBasePage {

    InitialCreateAccountPage initialCreateAccountPage = new InitialCreateAccountPage();

    @FindBy(xpath = "//*[text()='Good News!']")
    private WebElement goodNewsText;

    @FindBy(xpath = "//div[@class='styles__Message-sc-o3aos0-3 dIocUV']")
    private WebElement sentAMsgToRegisteredEmail;

    @FindBy(xpath = "//*[text()='Thanks for registering with More']")
    private WebElement thanksForRegisteringWithMore;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "good news text":
                webElement = goodNewsText;
                break;

            case "sent a msg to registered email":
                webElement = sentAMsgToRegisteredEmail;
                break;

            case "thanks for registering with more text":
                webElement = thanksForRegisteringWithMore;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in the " + getClass().getSimpleName());
        }
        return webElement;
    }

    public boolean verifyGoodNews()
    {
        WebElement goodNews = goodNewsText;
        if(goodNews.isDisplayed())
        {
            LOG.info("Good news text is displayed on the screen");
        }
        return goodNews.isDisplayed();
    }

    public boolean verifyThankYouMsg()
    {
        WebElement thankYou = thanksForRegisteringWithMore;
        if(thankYou.isDisplayed())
        {
            LOG.info("Good news text is displayed on the screen");
        }
        return thankYou.isDisplayed();
    }

    public String verifySentAMessageText(String sentAMessageToRegisteredEmail)
    {
        WebElement sentAMsg = sentAMsgToRegisteredEmail;
        String msgContainsEmail = sentAMsg.getText();

        if(msgContainsEmail.equals(sentAMessageToRegisteredEmail))
        {
            LOG.info(msgContainsEmail + "is displayed on the screen");
        }
        return msgContainsEmail;
    }
}