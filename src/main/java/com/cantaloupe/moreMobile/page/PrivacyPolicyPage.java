package com.cantaloupe.moreMobile.page;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class PrivacyPolicyPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//*[text()='HOME']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[@class='styles__Link-sc-1q28vlj-2 bfrxjx'][contains(text(), 'Privacy Policy')]")
    private WebElement privacyPloicyLink;

    @FindBy(xpath = "//div[@class='privacy-policy__TextContainer-sc-orkyo4-1 jLoPIz']")
    private WebElement privacyPolicycontent;

    @FindBy(xpath = "//button[contains(text(),'Back to Dashboard')]")
    private WebElement backToDashBoardButton;

    @FindBy(xpath = "//a[@class='privacy-policy__Anchor-sc-orkyo4-2 khyQKU'][contains(text(), 'Cookie Policy')]")
    private WebElement firstLink;

    @FindBy(xpath = "//a[@class='privacy-policy__Anchor-sc-orkyo4-2 khyQKU'][contains(text(), 'privacy@cantaloupe.com')]")
    private WebElement secondLink;

    @FindBy(xpath = "//a[@class='privacy-policy__Anchor-sc-orkyo4-2 khyQKU'][contains(text(), 'privacy@cantaloupe.com')]")
    private WebElement thirdLink;

    @FindBy(xpath = "//h2[@class='privacy-policy__H2-sc-orkyo4-4 ftchqr'][contains(text(), 'Changes to this Privacy Policy')]/../p/a[contains(text(), 'Privacy Policy')]")
    private WebElement fourthLink;

    @FindBy(xpath = "//h2[@class='privacy-policy__H2-sc-orkyo4-4 ftchqr'][contains(text(), 'Contacting Us')]/../p/i/a[contains(text(), 'privacy@cantaloupe.com')]")
    private WebElement fifthLink;

    @FindBy(xpath = "//a[@href='http://www.cantaloupe.com/']")
    private WebElement sixthLink;

    @FindBy(xpath = "//a[contains(text(), 'Cantaloupe, Inc.')]")
    private WebElement prodWewbsite;

    @FindBy(xpath = "//a[@href='http://www.cantaloupe.com/wp-content/uploads/2021/04/website-cookie-policy.pdf']")
    private WebElement cookiePolicyLink;

    @FindBy(xpath = "//a[@href='http://www.cantaloupe.com/']")
    private WebElement prodApplicationUrl;


    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "privacy policy link":
                webElement = privacyPloicyLink;
                break;

            case "home link":
                webElement = homeLink;
                break;

            case "privacy policy content":
                webElement = privacyPolicycontent;
                break;

            case "back to dashboard button":
                webElement = backToDashBoardButton;
                break;

            case "first link":
                webElement = firstLink;
                break;

            case "second link":
                webElement = secondLink;
                break;

            case "third link":
                webElement = thirdLink;
                break;

            case "fourth link":
                webElement = fourthLink;
                break;

            case "fifth link":
                webElement = fifthLink;
                break;

            case "sixth link":
                webElement = sixthLink;
                break;

            case "production website":
                webElement = prodWewbsite;
                break;

            case "cookie policy link":
                webElement = cookiePolicyLink;
                break;

            case "prod application url":
                webElement = prodApplicationUrl;
                break;



            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }

    public boolean isLinkActive(WebElement targetWebElement) {
        return verifyLinks(targetWebElement);
    }

    public static boolean verifyLinks(WebElement linkUrl) {
        try {
            URL url = new URL(linkUrl.getText());

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean brokenLinks() {

        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for(int i=2;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String linksToCheck= E1.getAttribute("href");
            try
            {
                URL url = new URL(linksToCheck);

                //Now we will be creating url connection and getting the response code
                HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if(httpURLConnect.getResponseCode()>=400)
                {
                    System.out.println(linksToCheck+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
                    return true;
                }

                //Fetching and Printing the response code obtained
                else{
                    System.out.println(linksToCheck+" - "+httpURLConnect.getResponseMessage());
                    return false;
                }
            }catch (Exception e) {
            }
        }
        return false;
    }

    public void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }

    public boolean isLinkClickable(String targetWebElement)
    {
        scrollToTheElementAndClick(targetWebElement);
        return getWebElement(targetWebElement).getAttribute("class").contains("active");
    }
}