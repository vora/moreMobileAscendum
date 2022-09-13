package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.page.DashboardPage;
import com.cantaloupe.moreMobile.page.PrivacyPolicyPage;
import com.cantaloupe.moreMobile.page.TermsAndConditionPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TermsAndConditionsPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    TermsAndConditionPage termsAndConditionPage = new TermsAndConditionPage();
    DashboardPage dashboardPage = new DashboardPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();


    private final String gteMoreTermsAndConditionsContent = props.getProperty("more_mobile_termsAndConditionsContent");


    public TermsAndConditionsPage_steps() throws IOException {
    }

    @And("user verifies the terms and condition content on the screen")
    public void verifyPrivacyPolicycontent() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String content = termsAndConditionPage.getWebElement("terms and conditions content").getText();
        content = content.replaceAll("\n", "");
        System.out.println(content);
       // String content1 = content.replaceAll("–", "- unless");

        String termsAndConditions = gteMoreTermsAndConditionsContent.replaceAll("\n", "");
        String termsAndConditions1 = termsAndConditions.replaceAll("\\?", "\u2022");
        System.out.println(termsAndConditions1);
        Assert.assertEquals(termsAndConditions1, content);
    }

    @Then("user clicks on back to dashboard button and is able to navigate back to the screen1")
    public void navigateBackToDashboard()
    {
        termsAndConditionPage.clickOn("back to dashboard button");
        Assert.assertTrue(dashboardPage.getWebElement("profile link").isDisplayed());
    }
}