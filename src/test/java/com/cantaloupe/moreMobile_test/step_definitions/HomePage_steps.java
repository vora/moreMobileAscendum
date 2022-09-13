package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.CreateOrLoginWithDifferentOptions;
import com.cantaloupe.moreMobile.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class HomePage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();

    HomePage homePage = new HomePage();
    CreateOrLoginWithDifferentOptions createAccountPage = new CreateOrLoginWithDifferentOptions();
    MoreMobileCommonSteps moreMobileCommonSteps = new MoreMobileCommonSteps();

    public HomePage_steps() throws IOException {
    }

    @When("the carousals should be scrollable horizontally")
    public void validateCorousalAndHeaders() throws Exception {
        homePage.verifyCarousel();
    }

    @And("user sees if there is the {string} displayed")
    public void verifyUIElement(String checkHeaderElement)
    {
        boolean isHeaderPresent = homePage.checkElement(checkHeaderElement);
        Assert.assertTrue(isHeaderPresent, checkHeaderElement + "is not availale on the screen");
    }

    @And("user clicks on carousal and see's if the header is displayed accordingly:")
    public void carousalsWithHeaders(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue()) {
                case "firstHeader":
                    homePage.clickOn("first carousel");
                    boolean isFirstHeaderPresent = homePage.checkElement(element.getKey().toLowerCase());
                    Assert.assertTrue(isFirstHeaderPresent, "Element is not present on screen");
                    break;

                case "secondHeader":
                    homePage.clickOn("second carousel");
                    boolean isSecondHeaderPresent = homePage.checkElement(element.getKey().toLowerCase());
                    Assert.assertTrue(isSecondHeaderPresent, "Element is not present on screen");
                    break;

                case "thirdHeader":
                    homePage.clickOn("third carousel");
                    boolean isThirdHeaderPresent = homePage.checkElement(element.getKey().toLowerCase());
                    Assert.assertTrue(isThirdHeaderPresent, "Element is present on screen");
                    break;

                case "fourthHeader":
                    homePage.clickOn("fourth carousel");
                    boolean isFourthHeaderPresent = homePage.checkElement(element.getKey().toLowerCase());
                    Assert.assertTrue(isFourthHeaderPresent, "Element is present on screen?");
                    break;
            }
        }
    }
}