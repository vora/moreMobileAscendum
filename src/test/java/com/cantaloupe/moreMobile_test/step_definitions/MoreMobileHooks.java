package com.cantaloupe.moreMobile_test.step_definitions;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MoreMobileHooks {

    @Before
    public void beforeScenario(Scenario scenario){
        MoreMobileWebDriverController.setWebDriver(System.getProperty("browser"));
    }

    @After //After each scenario
    public void afterScenario(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                TakesScreenshot screenshot = ((TakesScreenshot) MoreMobileWebDriverController.getWebDriver());
                scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png",
                        "screenshot");
            }
        }catch (Exception e){
            e.printStackTrace();
            MoreMobileWebDriverController.quitWebDriver();
        }
        MoreMobileWebDriverController.quitWebDriver();
    }
}
