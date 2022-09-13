package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.DashboardPage;
import com.cantaloupe.moreMobile.page.PrivacyPolicyPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PrivacyPolicyPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    DashboardPage dashboardPage = new DashboardPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();


    private final String gteMorePrivacyPolicyContent = props.getProperty("more_mobile_privacyPloicyContent");


    public PrivacyPolicyPage_steps() throws IOException {
    }

    @And("user verifies the privacy policy content on the screen")
    public void verifyPrivacyPolicycontent() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String content = privacyPolicyPage.getWebElement("privacy policy content").getText();
        content = content.replaceAll("\n", "");
        String content1 = content.replaceAll("– unless", "- unless");
        String newPrivacyContent = gteMorePrivacyPolicyContent.replaceAll("\n", "");
        String newPrivacyContent1 = newPrivacyContent.replaceAll("\\? unless", "- unless");
        Assert.assertEquals(newPrivacyContent1, content1);
    }

    @Then("user verifies if the links are in enabled mode")
    public void navigateSixthLink()
    {
        Assert.assertTrue(privacyPolicyPage.getWebElement("first link").isEnabled());
        Assert.assertTrue(privacyPolicyPage.getWebElement("second link").isEnabled());
        Assert.assertTrue(privacyPolicyPage.getWebElement("third link").isEnabled());
        Assert.assertTrue(privacyPolicyPage.getWebElement("fourth link").isEnabled());
        Assert.assertTrue(privacyPolicyPage.getWebElement("fifth link").isEnabled());
        Assert.assertTrue(privacyPolicyPage.getWebElement("sixth link").isEnabled());
    }

    @Then("user clicks on back to dashboard button and is able to navigate back to the screen")
    public void navigateBackToDashboard()
    {
        privacyPolicyPage.clickOn("back to dashboard button");
        Assert.assertTrue(dashboardPage.getWebElement("profile link").isDisplayed());
    }

    @Then("user will navigate to the respective screen")
    public void navigateToRespectiveUrl()
    {
       Assert.assertTrue(privacyPolicyPage.isLinkClickable("prod application url"));
    }
}