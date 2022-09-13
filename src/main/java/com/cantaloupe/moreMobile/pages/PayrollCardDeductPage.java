package com.cantaloupe.moreMobile.pages;

import com.cantaloupe.moreMobile.MoreMobileAbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayrollCardDeductPage extends MoreMobileAbstractBasePage {

    @FindBy(xpath = "//div[@class='styles__PayrollDeductLabel-sc-11pok88-7 gKFXJQ'][contains(text(), 'Card Type: Payroll Deduct')]")
    private WebElement payrollDeductHeader;

    @Override
    public WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        elementName = elementName.toLowerCase();

        switch (elementName) {
            case "page load check element":
            case "payroll deduct header":
                webElement = payrollDeductHeader;
                break;

            default:
                LOG.error("Element \"" + elementName + "\" is not registered in this class");
                throw new RuntimeException("Element \"" + elementName + "\" is not registered in this class");
        }

        return webElement;
    }
}