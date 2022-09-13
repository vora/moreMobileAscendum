package com.cantaloupe.moreMobile;

import com.cantaloupe.moreMobile.utils.MoreMobilePropertyHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MoreMobileAbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MoreMobilePropertyHelper props = new MoreMobilePropertyHelper();
    public Logger LOG = Logger.getLogger(String.valueOf(this.getClass()));

    public MoreMobileAbstractBasePage() {
        int pageLoadTimeout = Integer.parseInt(props.getProperty("pageLoadTimeout"));
        int explicitWaitTimeout = Integer.parseInt(props.getProperty("explicitTimeout"));
        int implicitWaitTimeout = Integer.parseInt(props.getProperty("implicitWait"));

        this.driver = MoreMobileWebDriverController.getWebDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTimeout));

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTimeout));
        PageFactory.initElements(driver, this);
    }

    public abstract WebElement getWebElement(String elementName);

    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebElement("page load check element")));
            LOG.info(this.getClass().getSimpleName() + " loaded");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warn(this.getClass().getName() + " not loaded with " + e.getMessage());
            return false;
        }
    }

///////////   Common page actions used accessed from steps definitions ///////////////////

    /**
     * Wait until element is clickable, scroll into element and click on it.
     *
     * @param targetElementName
     */
    public void clickOn(String targetElementName) {
        LOG.info("clicking on \"" + targetElementName + "\"");
        waitScrollClickFunction(getWebElement(targetElementName));
    }

    /**
     * Wait until element is clickable, scroll into element and click on it.
     *
     * @param targetElementName
     */
    public void doubleClick(String targetElementName) {
        LOG.info("clicking on \"" + targetElementName + "\"");
        waitScrollClickFunctionToDoubleClick(getWebElement(targetElementName));
    }


    /**
     * Wait until element is visible, scroll into element and send a value.
     *
     * @param targetElementName
     * @param value
     */
    public void typeInText(String targetElementName, String value) {
        String targetElementNameToLc = targetElementName.toLowerCase();

        if (!targetElementNameToLc.contains("password")) {
            LOG.info("Typing \"" + value + "\" into \"" + targetElementName + "\"");
        } else {
            LOG.info("Typing a password into \"" + targetElementName + "\"");
        }

        waitClearSendKeysFunction(getWebElement(targetElementNameToLc), value);
    }

    public void enterText(String value, String targetElementName) {
        waitClearSendKeysFunction(getWebElement(targetElementName), value);
    }

    public void enterText(Keys value, String targetElementName) {
        boolean targetElementIsDisplayed = getWebElement(targetElementName).isDisplayed();

        if (targetElementIsDisplayed) {
            LOG.info("Typing \"" + value + "\" into \"" + targetElementName + "\"");
        } else {
            LOG.info("Typing a password into \"" + targetElementName + "\"");
        }
    }

    /**
     * Wait until element is visible, scroll into element and send a value.
     *
     * @param targetElementName
     */
    public void typeInText(String targetElementName) {

        Boolean isElementPresent = getWebElement(targetElementName).isDisplayed();

        if (isElementPresent == true) {
            LOG.info(targetElementName + "is displayed");
        } else {
            LOG.info(targetElementName + "is not displayed");
        }
    }

    public String getElementText(String targetElementName) {
        return getWebElement(targetElementName).getText().trim();
    }

    /**
     * Selecting the option from the select element by visible test
     *
     * @param targetElementName
     * @param textToSelect
     */
    public void selectFromDropDownListByVisibleText(String targetElementName, String textToSelect) {
        Select select = new Select(getWebElement(targetElementName));
        LOG.info("Selecting \"" + textToSelect + "\" from \"" + targetElementName + "\"");
        select.selectByVisibleText(textToSelect);
    }

    /**
     * Selecting the option which contains the text from the select element
     *
     * @param targetElementName
     * @param textToSelect
     */
    public void selectFromDropDownListByContainingText(String targetElementName, String textToSelect) {

        WebElement select = getWebElement(targetElementName);
        String optionLocation = String.format("option[contains(text(), '%s')]", textToSelect);

        LOG.info("Selecting option containing \"" + textToSelect + "\" from \"" + targetElementName + "\"");

        select.findElement(By.xpath(optionLocation)).click();

    }

    /**
     * Related to DMS
     * Set the location by entering location in search text box, and then selecting the option from
     * the select drop down
     *
     * @param dropdownList
     * @param searchValue
     */
    public void searchTextAndSelectFromDropDownListOnDMS(String dropdownList, String searchValue) {
        WebElement dropdownListElement = getWebElement(dropdownList);

        /**
         * getting the search textbox which is next to the provided dropdown list and typing text in it
         */
        String[] bySelector = (getByLocatorUsed(dropdownListElement).toString()).split(" ");
        String searchTextboxSelector = bySelector[1].trim() + " + input";
        WebElement searchTextBox = driver.findElement(By.cssSelector(searchTextboxSelector));

        waitClearSendKeysFunction(searchTextBox, searchValue);
        searchTextBox.sendKeys(Keys.ENTER);


        /*selecting an option from dropdown and retry in case of stale element*/
        int i = 0;
        boolean found = false;
        do {
            i++;
            dropdownListElement = driver.findElement(getByLocatorUsed(dropdownListElement));
            Select select = new Select(dropdownListElement);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                LOG.info(dropdownListElement.getAttribute("label") + " option text = " + optionText);
                if (optionText.startsWith(searchValue)) {
                    LOG.info("Clicking on option \"" + optionText + "\"");
                    option.click();
                    found = true;
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                LOG.info("Option " + searchValue + " not loaded trying again. Attempt=" + i);
            }
        } while (!found && i < 2);
    }


/////////////////////////////////////////////////////////////////////////////////
//////////////////      Local reusable functions ////////////////////////////////

    protected void javaScriptScrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    private void waitScrollClickFunction(WebElement elementName) {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        javaScriptScrollIntoElement(elementName);
        elementName.click();
    }

    private void waitScrollClickFunctionToDoubleClick(WebElement elementName) {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        javaScriptScrollIntoElement(elementName);
        Actions a = new Actions(driver);
        a.moveToElement(elementName).doubleClick().build().perform();
    }

    private void waitClearSendKeysFunction(WebElement elementName, String text) {
        elementName.clear();
        elementName.sendKeys(text);
    }

    /**
     * Returns the locator used as a {@link By} object.
     * Null if not found
     *
     * @param element
     * @return locator used as a {@link By} object.
     */
    private By getByLocatorUsed(WebElement element) {
        By by = null;
        String[] locatorData = element.toString().split("->")[1].split(":", 2);
        String locatorType = locatorData[0].trim();
        String locatorValue = locatorData[1].substring(0, locatorData[1].length() - 1).trim();
        switch (locatorType) {
            case "css selector":
                by = By.cssSelector(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "id":
                by = By.id(locatorValue);
                break;
            case "link text":
                by = By.linkText(locatorValue);
                break;
            case "partial link text":
                by = By.partialLinkText(locatorValue);
                break;
            case "tag name":
                by = By.tagName(locatorValue);
                break;
            case "class name":
                by = By.className(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            default:
                String msg = "element type: '" + locatorType + "' not recognized";
                throw new NoSuchElementException(msg);
        }
        return by;
    }

    public boolean regexExpression(String targetElementName, String enterData, String regexType) {
        WebElement element = getWebElement(targetElementName);
        Pattern pattern = Pattern.compile(regexType);
        Matcher matcher = pattern.matcher(enterData);

        boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition) {
            element.sendKeys(enterData);
        } else if ((!checkPatternCondition)) {
            LOG.info(enterData + "is not a valid entry for the input field");
        } else {
            LOG.info("Create Account Screen : Something is not proper for the entered phone number ");
        }
        return checkPatternCondition;
    }

    /**
     * The following regex would be allowing numbers from 0 to 9, alphabets Upper and lower case, with special characters underscore(_), hyphen(-) and a dot(.)
     * dots should be consecutive and they are not allowed at the start and at the end
     * Will be allowing at a max of 64 characters
     */

    public boolean verifyEmailRegex(String email) {
        return regexExpression("email input field", email, "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    public String validateEmailCriteria(String email) throws AWTException {
        verifyEmailRegex(email);
        return email;
    }

    public boolean isElementDisplayed(String targetWebelemt) {
        boolean isWebElementDisplayed = getWebElement(targetWebelemt).isDisplayed();
        if (isWebElementDisplayed) {
            LOG.info(targetWebelemt + "is present on the page");
            return true;
        } else {
            LOG.info(targetWebelemt + "is not present on the page");
            return false;
        }
    }

    public boolean isElementEnabled(String targetElement) {
        List<WebElement> elements = driver.findElements(getByLocatorUsed(getWebElement(targetElement)));
        boolean isElementEnabled = elements.size() > 0;
        if (isElementEnabled) {
            LOG.info("Element is in enabled mode");
            return true;
        } else {
            LOG.info("Element is not in enabled mode");
            return true;
        }
    }

    public boolean isButtonOrLinkEnabled(String targetWEbElement) {
        return getWebElement(targetWEbElement).isEnabled();
    }

    public void randomClickBasedOnOS() throws AWTException {
        if ((props.getProperty("more_mobile_platformName")).equalsIgnoreCase("iOS")) {
            driver.findElement(By.xpath("//html")).click();
        } else if ((props.getProperty("more_mobile_platformName")).equalsIgnoreCase("Android")) {
            randomClickOnScreen();
        }
    }

    public void randomClickOnScreen() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(0, 0);
        actions.click().build().perform();
    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void clearInputfieldAndEnterNewData(String targetWebElement, String editValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=' " + editValue + " ';", getWebElement(targetWebElement));

    }

    public boolean isElementDislayed(String targetElement) {
        boolean isElementEnabled = driver.findElements(getByLocatorUsed(getWebElement(targetElement))).size() > 0;
        if (isElementEnabled) {
            LOG.info("Element is not in enabled mode");
            return true;
        } else {
            LOG.info("Element is in enabled mode");
            return false;
        }
    }

    public Character getLastCharacter(String str) {
        return str.charAt(str.length() - 1);
    }

    public void clearData(String targetWebelement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value= ''", getWebElement(targetWebelement));
    }

    public String sendText(String enterValue, String targetElement) {
        getWebElement(targetElement).sendKeys(targetElement);
        return enterValue;
    }

    public Object getListElements(String targetElement) {
        List<String> listOrErrors = new ArrayList<>();

        if (driver.findElements(By.xpath("//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']")).size() != 0) {
            for (WebElement webElement : (driver.findElements(By.xpath("//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']")))) {
                listOrErrors = Collections.singletonList(webElement.getText());
                return listOrErrors;
            }
        } else {
            LOG.info("No errors are displayed on the screen");
        }
        return listOrErrors;
    }

    public Object getListElements() {
        List<String> listOrErrors = new ArrayList<>();

        if (driver.findElements(By.xpath("//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']")).size() != 0) {
            for (WebElement webElement : (driver.findElements(By.xpath("//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']")))) {
                listOrErrors = Collections.singletonList(webElement.getText());
                return listOrErrors;
            }
        } else {
            LOG.info("No errors are displayed on the screen");
        }
        return listOrErrors;
    }

    public void scrollToTheElementAndClick(String elementName) {
        javaScriptScrollIntoElement(getWebElement(elementName));
        getWebElement(elementName).click();
    }

    public List<WebElement> getElementWithByLocator(String elementName) {
        return driver.findElements(By.xpath(elementName));
    }

    public List<String> getParticularElement(WebElement targetElement) {
        List<String> listOfElements = new ArrayList<>();

        boolean elemenrNeeded = (driver.findElements(By.xpath("//*[text()='Login']")).size() != 0);

        if (elemenrNeeded) {
            for (WebElement webElement : (driver.findElements(By.xpath("//*[text()='Login']")))) {
                listOfElements = Collections.singletonList(webElement.getText());
                return listOfElements;
            }
        } else {
            LOG.info("No errors are displayed on the screen");
        }
        return listOfElements;
    }

    public void clickBackspaceFromKeyboard(String targetWebElement) {
        getWebElement(targetWebElement).sendKeys(Keys.BACK_SPACE);
    }

    public boolean checkElementIsPresent(String targetWebElemnt) {
        WebElement checkElement = getWebElement(targetWebElemnt);
        try {
            if (driver.findElements(getByLocatorUsed(checkElement)).size() != 0) {
                LOG.info(checkElement + "is present on the screen");
                return true;
            } else {
                LOG.info(checkElement + "is not present on the screen");
            }
        } catch (ArrayIndexOutOfBoundsException c) {
            LOG.info("element is not present");
        }
        return false;
    }

    public boolean checkPasswordMaskedOrNot(String targetElement) {
        WebElement passwordMasked = getWebElement(targetElement);
        boolean isFieldMasked = passwordMasked.getAttribute("type").equals("password");
        if (passwordMasked.getAttribute("type").equals("password")) {
            LOG.info("Field is masked");
            return true;
        } else {
            LOG.info("Field is not masked");
            return false;
        }
    }

    public String getEneteredValue(String targetWebElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(getWebElement(targetWebElement)));
        WebElement emailInputNotEditable = getWebElement(targetWebElement);
        return emailInputNotEditable.getAttribute("value");
    }

    public String extractNumbers(String mobileNo) {
        return mobileNo.replaceAll("[^0-9]", "");
    }

    public boolean checkForAnyErrorsOnScreen() {
        List<String> listOfErrors = (List<String>) getListElements();
        return listOfErrors.size() > 0;
    }

    public List<String> checkForMobileErros(String targetWebElement) {
        return (List<String>) getListElements(targetWebElement);
    }

    public boolean verifyPhoneNoFormat(String targetWebElement) {
        String mobileFormat = getWebElement(targetWebElement).getAttribute("value");
        String number = mobileFormat.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        if (number.equals(mobileFormat)) {
            LOG.info("Mobile number is in proper format");
            return true;
        }
        return false;
    }

    public String generateRandomEmailId() {
        String genratedEmailId = RandomStringUtils.randomAlphanumeric(15);
        return genratedEmailId + "@yopmail.com";
    }

    public long generateRandomNumberString() {
        Random rnd = new Random();
        char[] digits = new char[10];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for (int i = 1; i < digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        LOG.info("Generated the following number : " + Long.parseLong(new String(digits)));
        return Long.parseLong(new String(digits));
    }

    public String validateErrorMessages(String targetWebElement) {
        WebElement webElement = getWebElement(targetWebElement);
        String errorMessage = webElement.getText();
        if (webElement.isDisplayed()) {
            LOG.info(errorMessage + " is showing up");
        } else {
            LOG.info(errorMessage + " is not shown");
        }
        return errorMessage;
    }

    public String randomString(int length) {
        SecureRandom secureRnd = new SecureRandom();
        String randomStringToGenerate = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(randomStringToGenerate.charAt(secureRnd.nextInt(randomStringToGenerate.length())));
        LOG.info(sb.toString());
        return sb.toString();
    }

    public String generateRandomZipcode() {
        SecureRandom random = new SecureRandom();
        int number = random.nextInt(100000);
        return String.format("%05d", number);
    }

    public String randomState() {
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("AL");
        listStrings.add("AK");
        listStrings.add("AZ");
        listStrings.add("AR");
        listStrings.add("CA");
        listStrings.add("CO");
        listStrings.add("CT");
        listStrings.add("DE");
        listStrings.add("DC");
        listStrings.add("FL");
        listStrings.add("GA");
        listStrings.add("HI");
        listStrings.add("ID");
        listStrings.add("IL");
        listStrings.add("IN");
        listStrings.add("IA");
        listStrings.add("KS");
        listStrings.add("KY");
        listStrings.add("LA");
        listStrings.add("ME");
        listStrings.add("MD");
        listStrings.add("MA");
        listStrings.add("MI");
        listStrings.add("MN");
        listStrings.add("MS");
        listStrings.add("MO");
        listStrings.add("MT");
        listStrings.add("NE");
        listStrings.add("NV");
        listStrings.add("NH");
        listStrings.add("NJ");
        listStrings.add("NM");
        listStrings.add("NY");
        listStrings.add("NC");
        listStrings.add("ND");
        listStrings.add("OH");
        listStrings.add("OK");
        listStrings.add("OR");
        listStrings.add("PA");
        listStrings.add("RI");
        listStrings.add("SC");
        listStrings.add("SD");
        listStrings.add("TN");
        listStrings.add("TX");
        listStrings.add("UT");
        listStrings.add("VT");
        listStrings.add("VA");
        listStrings.add("WA");
        listStrings.add("WV");
        listStrings.add("WI");
        listStrings.add("WY");

        Random r = new Random();
        int randomitem = r.nextInt(listStrings.size());
        LOG.info("Generated sate is: " + listStrings.get(randomitem));
        return listStrings.get(randomitem);
    }

    public String extractString() {
        String s = getWebElement("phone number in use error").getText();
        return s.substring(105, 119);
    }

    public boolean checkElementClickable() {
        return getWebElement("click phone no").isEnabled();
    }

    public boolean verifyButtonDisabled(String targetWebElement) {
        if (getWebElement(targetWebElement).isEnabled()) {
            LOG.info(targetWebElement + " is in enabled and is not working as expected");
            return false;
        } else {
            LOG.info(targetWebElement + " is wprking according to the functionality");
            return true;
        }
    }

    public void clickBackSpaceForMobile(String targetWebElement) throws AWTException {
        getWebElement(targetWebElement).click();
        clickOn("mobile number clear icon");
        clearInputfieldAndEnterNewData("mobile number input field", "were");
        getWebElement(targetWebElement).sendKeys(Keys.BACK_SPACE);
        randomClickBasedOnOS();
    }

    public void enterUniqueEmailID() throws AWTException {
        String email = generateRandomEmailId();
        enterText(email, "email input field");
    }

    public String extractNumbersOnly(String cardNumber) {
        String newCardNumber = cardNumber.replaceAll("\\s", "");
        return newCardNumber.substring(newCardNumber.length() - 4);
    }

    public By lastFourDigitsFromCard(String addedMoreCardLast4Numbers) {
        String lastFourDigits = "//*[contains(text(),'More Card •• " + addedMoreCardLast4Numbers + "')]";
        return By.xpath(lastFourDigits);
    }

    public By balanceCheck_NewCard(String balanceForNewlyAddedCard) {
        String balance = "//*[contains(text(),'More Card •• " + balanceForNewlyAddedCard + "')]//preceding::div[contains(text(), '$')]";
        return By.xpath(balance);
    }

    public boolean verifyAddedMoreCardNumber(String enterCardNo) {
        waitForElement("profile link");
        String addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
        return driver.findElement(lastFourDigitsFromCard(addedMoreCardLast4Numbers)).isDisplayed();
    }

    public boolean verifyBalance(String enterCardNo) {
        String addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
        return driver.findElement(balanceCheck_NewCard(addedMoreCardLast4Numbers)).isDisplayed();
    }

    public void clickOnAddedCard(String enterCardNo) {
        String addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
        driver.findElement(lastFourDigitsFromCard(addedMoreCardLast4Numbers)).click();
    }

    public void enterNumberAndCode(String moreCardNumber, String securityCode) {
        enterText(moreCardNumber, "more card number input field");
        clickOn("card number back arrow");
        enterText(moreCardNumber, "more card number input field");
        enterText(securityCode, "security code input field");
    }

    public boolean waitForElement(String targetWebElemnt) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(getWebElement(targetWebElemnt)));
        WebElement checkElement = getWebElement(targetWebElemnt);
        try {
            if (driver.findElements(getByLocatorUsed(checkElement)).size() != 0) {
                LOG.info(checkElement + "is present on the screen");
                return true;
            } else {
                LOG.info(checkElement + "is not present on the screen");
            }
        } catch (ArrayIndexOutOfBoundsException c) {
            LOG.info("element is not present");
        }
        return false;
    }

    public String extractNumbers_moreCard(String cardNumber) {
        cardNumber = cardNumber.replaceAll("[^\\d]", " ");
        cardNumber = cardNumber.trim();
        cardNumber = cardNumber.replaceAll(" +", " ");
        return cardNumber;
    }

    public String balanceCheck(String enterCardNo) {
        String addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
        return driver.findElement(balanceCheck_NewCard(addedMoreCardLast4Numbers)).getText();
    }

    public boolean actualDropdownOptions(String targetWebelement, String initialValue) {
        List<String> expectedDropdownOptions = new ArrayList<>();
        expectedDropdownOptions.add(initialValue);
        expectedDropdownOptions.add("$10");
        expectedDropdownOptions.add("$15");
        expectedDropdownOptions.add("$20");
        expectedDropdownOptions.add("$25");
        expectedDropdownOptions.add("$50");
        expectedDropdownOptions.add("$100");

        List<String> targetList = new ArrayList<String>(expectedDropdownOptions);
        Select original = new Select(getWebElement(targetWebelement));
        List<WebElement> originalListElements = original.getOptions();
        List<String> originalList = new ArrayList<String>();
        for (WebElement webElement : originalListElements) {
            originalList.add(webElement.getText());
        }
        return targetList.equals(originalList);
    }

    /**
     * Selecting the option from the select element by visible test
     *
     * @param targetWebElement
     * @param textToSelect
     */
    public String readDropdownValueByString(String textToSelect, String targetWebElement) {
        WebElement select = getWebElement(targetWebElement);
        String optionLocation = String.format("option[contains(text(), '%s')]", textToSelect);
        LOG.info("Selecting option containing \"" + textToSelect + "\" from \"" + targetWebElement + "\"");
        select.findElement(By.xpath(optionLocation)).click();
        return select.findElement(By.xpath(optionLocation)).getText();
    }

    /**
     * Selecting the option which contains the text from the select element
     *
     * @param targetElementName
     */
    public boolean selectFirstVlaueFromDropdown(String targetElementName, String displayedValue) {

        Select option = new Select(getWebElement(targetElementName));
        option.selectByIndex(1);
        String selectedValue = option.getFirstSelectedOption().getText();
        if(selectedValue.equals(displayedValue))
        {
            System.out.println(selectedValue + "***************");
            LOG.info("The displayed value for " + targetElementName + " is: " + displayedValue);
            return true;
        }
        LOG.info(targetElementName + " is not working as expected");
        return false;
    }

    public String verifyDataEdntered(String targetWebElement) {
        wait.until(ExpectedConditions.visibilityOf(getWebElement(targetWebElement)));
        String enteredValue = getWebElement(targetWebElement).getAttribute("value");
        LOG.info("The value present in the " + targetWebElement + " is: " + enteredValue);
        return enteredValue;
    }

    public boolean verifyEmailFieldISEditableOrNot(String targetWebElement) {;
        wait.until(ExpectedConditions.visibilityOf(getWebElement(targetWebElement)));
        boolean isFieldNoneditable = getWebElement(targetWebElement).isEnabled();
        LOG.info("Is the " +targetWebElement+ " editable?:" + isFieldNoneditable);
        return isFieldNoneditable;
    }

    public boolean isElementInEnabledMode(String targetWebelemt) {
        boolean isWebElementDisplayed = getWebElement(targetWebelemt).isEnabled();
        if (isWebElementDisplayed) {
            LOG.info(targetWebelemt + "is present on the page");
            return true;
        } else {
            LOG.info(targetWebelemt + "is not present on the page");
            return false;
        }
    }

    public boolean checkFieldIsBlankOrHasData(String targetWebElement)
    {
        WebElement inputBox = getWebElement(targetWebElement);
        String textInsideInputBox = inputBox.getAttribute("value");
        if(textInsideInputBox.isEmpty())
        {
            LOG.info( targetWebElement + " is blank.");
            return false;
        }
        else
        {
            LOG.info( targetWebElement + "has data.");
            return true;
        }
    }

    public String retrieveValue(String targetWebElement) {
        return getWebElement(targetWebElement).getText();
    }

    public boolean regexCreditCardNo(String phoneNo) {
        return regexExpression("credit card number input field", phoneNo, "^\\d{16}$");
    }

    /**
     * This method will be allowing only numbers and a count of 15 digits
     */
    public boolean regexCreditCardNoForAmex(String phoneNo) {
        return regexExpression("credit card number input field", phoneNo, "^\\d{15}$");
    }

    /**
     * This method will be allowing only numbers and a count of 16 digits
     */
    public boolean regexMoreCardNo(String phoneNo) {
        return regexExpression("more card number input field", phoneNo, "^\\d{19}$");
    }

    public boolean regexSecurityCode(String phoneNo) {
        return regexExpression("security code input field", phoneNo, "^\\d{4}$");
    }

    /**
     * This method will be allowing only numbers and a count of 10 digits
     */
    public boolean regexPhoneNo(String phoneNo) {
        return regexExpression("mobile number input field", phoneNo, "^\\d{10}$");
    }

    /**
     * This method will be allowing only numbers and a count of 5 digits then a hyphen and 4 digits. The - or 4 can be optional
     */
    public boolean regexZipcode(String zipcode) {
        return regexExpression("zipcode input field", zipcode, "\\d{5}(?:-\\d{4})?");
    }

    /**
     * The following regex methods will check the entered data for a particular pattern
     */
    public boolean verifyRegexEmail(String email) {
        return regexExpression("email input field", email, "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    public boolean regexPassword(String password)
    {
        return regexExpression("password input field", password, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$");
    }

    public boolean regexConfirmPassword(String password)
    {
        return regexExpression("confirm password input field", password, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$");
    }

    public boolean regexStreetAddress(String streetAddress)
    {
        return regexExpression("street address input field", streetAddress, "^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,})$|^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,})$|^\\d{1,6}\\040([A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,}\\040[A-Z]{1}[a-z]{1,})$");
    }

    public boolean regexCity(String city)
    {
        return regexExpression("city input field", city, "^[a-zA-Z\\u0080-\\u024F\\s\\/\\-\\)\\(\\`\\.\\\"\\']+$");
    }

    /**
     * This method will be allowing only the listed 50 states of US
     */
    public boolean regexState(String state)
    {
        return regexExpression("state input field", state, "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$");
    }

    public boolean regexFirstname(String firstname)
    {
        return regexExpression("firstname input field", firstname, "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}");
    }

    public boolean regexLastname(String lastname)
    {
        return regexExpression("lastname input field", lastname, "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}");
    }

    public boolean checkFiedIsBlankOrHasData(String targetWebElement)
    {
        WebElement inputBox = getWebElement(targetWebElement);
        String textInsideInputBox = inputBox.getAttribute("value");
        if(textInsideInputBox.isEmpty())
        {
            LOG.info( targetWebElement + " is blank.");
            return false;
        }
        else
        {
            LOG.info( targetWebElement + "has data.");
            return true;
        }
    }

    public void navigationToAddedNewCardImg(String newlyAddedCardFourDigits) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        String lastFourdigits = extractNumbersOnly(newlyAddedCardFourDigits);
        String addedCard = "//*[contains(text(),'More Card •• "+ lastFourdigits + "')]/../../div/img";
        driver.findElement(By.xpath(addedCard)).click();
    }

    public String balanceCheckForNewlyAddedCard(String newlyAddedCardFourDigits)
    {
        String balance = "//*[contains(text(),'More Card •• " + newlyAddedCardFourDigits + "')]/../../div/div[@class='styles__Amount-sc-1j3b2s7-3 eIObjj']";
        return driver.findElement(By.xpath(balance)).getText();
    }

    public boolean toggleButtonStatus() {
        if(getWebElement("toggle button").isEnabled())
        {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", getWebElement("toggle button"));
            return true;
        }
        return false;
    }

    public String readLineForMrecardNumber(File file) throws IOException {
        FileReader fileReader = new FileReader((file));
        BufferedReader buffer = new BufferedReader(fileReader);
        String lineData = buffer.readLine();
        LOG.info(lineData);
        return lineData;
    }

    public void deleteLineData(File file)
    {
        try {
            File inputFile = new File(String.valueOf(file));
            if (!inputFile.isFile()) {
                LOG.info("File does not exist");
                return;
            }
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().equals(readLineForMrecardNumber(file))) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            bufferedReader.close();

            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTextForInput(String targetWebelement)
    {
        clickOn(targetWebelement);
        String inputData = getElementText(targetWebelement);
        return inputData;
    }

    public void deleteCharacters(String str)
    {
        String result = "";
        int len = str.length() - 1;

        for (int i = 0; i <= len; i++)
        {
            char letter = str.charAt(i);
            if (letter == 'x' && ((i == 0) || (i == len))) {
                result += String.valueOf(letter);
            }
            else if(letter != 'x'){
                result += String.valueOf(letter);
            }
        }
    }
}