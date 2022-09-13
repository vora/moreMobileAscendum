package com.cantaloupe.moreMobile.page;


import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddedMoreCardSuccessPage extends MoreMobileAbstractBasePage {


    @FindBy(xpath = "//div[@class='styles__Title-sc-o3aos0-1 eXAulo'][contains(text(), 'More Card Added')]")
    private WebElement moreCardAddedText;

    @FindBy(xpath = "//div[@class='styles__Message-sc-o3aos0-3 dIocUV'][contains(text(), 'More card was successfully added to your account')]")
    private WebElement moreCardSuccessText;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
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