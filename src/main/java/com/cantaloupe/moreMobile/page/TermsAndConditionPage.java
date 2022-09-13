package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;


public class TermsAndConditionPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[text()='HOME']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[@class='styles__Link-sc-1q28vlj-2 bfrxjx'][contains(text(), 'Terms of Use')]")
    private WebElement termsAndConditionsLink;

    @FindBy(xpath = "//div[@class='terms__TextContainer-sc-1gl3uwz-1 ixXgtZ']")
    private WebElement termsAndConditionsContent;

    @FindBy(xpath = "//button[contains(text(),'Back to Dashboard')]")
    private WebElement backToDashBoardButton;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "terms and condition link":
                webElement = termsAndConditionsLink;
                break;

            case "home link":
                webElement = homeLink;
                break;

            case "terms and conditions content":
                webElement = termsAndConditionsContent;
                break;

            case "back to dashboard button":
                webElement = backToDashBoardButton;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    public boolean isLinkActive(WebElement targetWebElement)
    {
        return verifyLinks(targetWebElement);
    }

    public static boolean verifyLinks(WebElement linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl.getText());
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
        return false;
    }
}