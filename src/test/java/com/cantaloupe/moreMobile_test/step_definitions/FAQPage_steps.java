package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import com.cantaloupe.moreMobile.pages.FAQPage;
import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.Map;


public class FAQPage_steps {

    private final WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    FAQPage faqPage = new FAQPage();

    private MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();

    private final String getFirstQuestion = props.getProperty("more_mobile_firstQuestion");
    private final String getSecondQuestion = props.getProperty("more_mobile_secondQuestion");
    private final String getThirdQuestion = props.getProperty("more_mobile_thirdQuestion");
    private final String getFourthQuestion = props.getProperty("more_mobile_fourthQuestion");
    private final String getFifthQuestion = props.getProperty("more_mobile_fifthQuestion");
    private final String getFirstAnswer = props.getProperty("more_mobile_firstAnswer");
    private final String getSecondAnswer = props.getProperty("more_mobile_secondAnswer");
    private final String getThirdAnswer = props.getProperty("more_mobile_thirdAnswer");
    private final String getFourthAnswer = props.getProperty("more_mobile_fourthAnswer");
    private final String getFifthAnswer = props.getProperty("more_mobile_fifthAnswer");



    public FAQPage_steps() throws IOException {
    }

    @And("user sees the appropriate question and answers on the screen")
    public void verifyQuestionAndAnswers(io.cucumber.datatable.DataTable dataTable) throws AWTException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> element : dataMap.entrySet()) {
            switch (element.getValue())
            {
                case "firstQuestion":
                    String firstQuestionValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(firstQuestionValue, getFirstQuestion, element.getKey() + " is not as expected");
                    break;

                case "firstAnswer":
                    String firstAnswerValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(firstAnswerValue, getFirstAnswer, element.getKey() + " is not as expected");
                    break;

                case "secondQuestion":
                    String secondQuestionValue = faqPage.retrieveValue("second question");
                    Assert.assertEquals(secondQuestionValue, getSecondQuestion, element.getKey() + " is not as expected");
                    break;

                case "secondAnswer":
                    String secondAnswerValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(secondAnswerValue, getSecondAnswer, element.getKey() + " is not as expected");
                    break;

                case "thirdQuestion":
                    String thirdQuestionValue = faqPage.retrieveValue("third question");
                    Assert.assertEquals(thirdQuestionValue, getThirdQuestion, element.getKey() + " is not as expected");
                    break;

                case "thirdAnswer":
                    String thirdAnswerValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(thirdAnswerValue, getThirdAnswer, element.getKey() + " is not as expected");
                    break;

                case "fourthQuestion":
                    String fourthQuestionValue = faqPage.retrieveValue("fourth question");
                    Assert.assertEquals(fourthQuestionValue, getFourthQuestion, element.getKey() + " is not as expected");
                    break;

                case "fourthAnswer":
                    String fourthAnswerValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(fourthAnswerValue, getFourthAnswer, element.getKey() + " is not as expected");
                    break;

                case "fifthQuestion":
                    String fifthQuestionValue = faqPage.retrieveValue("fifth question");
                    Assert.assertEquals(fifthQuestionValue, getFifthQuestion, element.getKey() + " is not as expected");
                    break;

                case "fifthAnswer":
                    String fifthAnswerValue = faqPage.retrieveValue(element.getKey().toLowerCase());
                    Assert.assertEquals(fifthAnswerValue, getFifthAnswer, element.getKey() + " is not as expected");
                    break;
            }
        }
    }
}