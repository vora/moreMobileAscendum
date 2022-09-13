package com.cantaloupe.moreMobile_test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;


@CucumberOptions
        (       plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                features = {"src/test/java/com/cantaloupe/moreMobile_test/feature_files/AccountCreation.feature"},
                glue = {"com/cantaloupe/moreMobile_test/step_definitions"}
                //  tags = "@ReloadAuto"
        )


public class MoreMobileTests extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    void beforeClass(@Optional("iOS") String browser){

        if (System.getProperty("environment")==null){
            throw new RuntimeException("Please provide a test environment name (i.e.-Denvironment=INT)");
        }
        System.setProperty("browser", browser);
    }



    @AfterClass
    void afterClass(){
//        WebDriverController.quitWebDriver();
    }
}
