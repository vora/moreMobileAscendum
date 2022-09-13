package com.cantaloupe.moreMobile;


import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class MoreMobileWebDriverController {

    private static final ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<>();
    private static Logger logger = Logger.getLogger(String.valueOf(MoreMobileWebDriverController.class));
    private static final String TEMP_DOWNLOADS_FOLDER = System.getProperty("java.io.tmpdir") + "autotests";
    private static final MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();



    public static void setWebDriver(String browserName) {

        if (threadWebDriver.get() == null) {
            //This condition is to run from feature files when the browser name is not provided
            if (browserName.equalsIgnoreCase("Chrome")) {

                logger.info("Initiating Chromedriver");

                File downloadFolder = new File(TEMP_DOWNLOADS_FOLDER);
                if (!downloadFolder.exists()) {
                    downloadFolder.mkdir();
                }

                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", TEMP_DOWNLOADS_FOLDER);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.setAcceptInsecureCerts(false);
                chromeOptions.addArguments("enable-automation");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--start-maximized");

                String headless = props.getProperty("headless", "true");
                if (headless.equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless");
                }

                WebDriverManager.chromedriver().setup();
                threadWebDriver.set(new ChromeDriver(chromeOptions));
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                logger.info("Initiating firefox (geckodriver)");

                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                firefoxProfile.setPreference("browser.download.dir", TEMP_DOWNLOADS_FOLDER);
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(firefoxProfile);

                String headless = props.getProperty("headless", "true");
                if (headless.equalsIgnoreCase("true")) {
                    firefoxOptions.setHeadless(true);
                }

                WebDriverManager.firefoxdriver().setup();
                threadWebDriver.set(new FirefoxDriver(firefoxOptions));
            }

            else if (browserName==null ||  browserName.equalsIgnoreCase(props.getProperty("more_mobile_browserName"))) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "iOS");
                caps.setCapability("deviceName", "iPhone 13 Pro Max");
                caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
                caps.setCapability("platformVersion", "15.2");

                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("autoAcceptAlerts", true);
                caps.setCapability(CapabilityType.APPLICATION_NAME, "Settings");


                try {
                    URL url = new URL("http://0.0.0.0:4723/wd/hub");
                    threadWebDriver.set(new RemoteWebDriver(url, caps));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }

           else if (browserName.equalsIgnoreCase("Android")) {
                WebDriverManager wdm = WebDriverManager.chromedriver();
                wdm.setup();
                String chromedriverPath = wdm.getDownloadedDriverPath();

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("androidPackage", "com.android.chrome");
                caps.setCapability("platformVersion", "12.0");
                caps.setCapability("automationName", "Appium");


                ChromeOptions options = new ChromeOptions();
                caps.merge(options);
                    try {
                        URL url = new URL("http://0.0.0.0:4723/wd/hub");
                        threadWebDriver.set(new RemoteWebDriver(url, caps));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }

            else throw new RuntimeException(browserName + " webdriver not registered in WebDriverController.class");
        }
    }

    public static synchronized WebDriver getWebDriver() {
        // adding condition to run scenario directly without com.cantaloupe.uiautomation.runners.
        if (threadWebDriver.get() == null) setWebDriver(null);
        return threadWebDriver.get();
    }

    public static synchronized void quitWebDriver() {
        if (threadWebDriver.get() != null) {
            logger.info("Quitting the webdriver " + threadWebDriver.get().getClass().getSimpleName());
            threadWebDriver.get().quit();
            threadWebDriver.set(null);
            threadWebDriver.remove();
        }
    }

}
