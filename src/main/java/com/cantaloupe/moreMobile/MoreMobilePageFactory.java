package com.cantaloupe.moreMobile;

import com.cantaloupe.moreMobile.page.AddMorePayrollCardPage;
import com.cantaloupe.moreMobile.page.AddMorePrepaidCardPage;
import com.cantaloupe.moreMobile.page.AddedMoreCardSuccessPage;
import com.cantaloupe.moreMobile.page.ChangePasswordPage;
import com.cantaloupe.moreMobile.page.ConfirmRegistrationPage;
import com.cantaloupe.moreMobile.page.CreateAccountPage;
import com.cantaloupe.moreMobile.page.CreateNewPasswordPage;
import com.cantaloupe.moreMobile.page.CreateOrLoginWithDifferentOptions;
import com.cantaloupe.moreMobile.page.DashboardPage;
import com.cantaloupe.moreMobile.page.FAQPage;
import com.cantaloupe.moreMobile.page.ForgotPasswordMessagePage;
import com.cantaloupe.moreMobile.page.ForgotPasswordPage;
import com.cantaloupe.moreMobile.page.HomePage;
import com.cantaloupe.moreMobile.page.InitialCreateAccountPage;
import com.cantaloupe.moreMobile.page.PayrollCardDeductPage;
import com.cantaloupe.moreMobile.page.PrepaidCardDetailPage;
import com.cantaloupe.moreMobile.page.PrepaidCardManualReloadPage;
import com.cantaloupe.moreMobile.page.PrepaidCardReloadPage;
import com.cantaloupe.moreMobile.page.PrivacyPolicyPage;
import com.cantaloupe.moreMobile.page.SignInWithExistingAccountPage;
import com.cantaloupe.moreMobile.page.TermsAndConditionPage;
import com.cantaloupe.moreMobile.page.UpdateProfilePage;

public class MoreMobilePageFactory {

    private static MoreMobileAbstractBasePage pom_abstract = null;

    public static void setPageName(String pageName) {

        pageName = pageName.toLowerCase();

        switch (pageName){

            case "home page":                        pom_abstract = new HomePage();                            break;
            case "initial create account page":      pom_abstract = new InitialCreateAccountPage();            break;
            case "create account page":              pom_abstract = new CreateAccountPage();                   break;
            case "different options page":           pom_abstract = new CreateOrLoginWithDifferentOptions();   break;
            case "signin existingaccount page":      pom_abstract = new SignInWithExistingAccountPage();       break;
            case "confirm registration page":        pom_abstract = new ConfirmRegistrationPage();             break;
            case "update profile page":              pom_abstract = new UpdateProfilePage();                   break;
            case "dashboard page":                   pom_abstract = new DashboardPage();                       break;
            case "change password page":             pom_abstract = new ChangePasswordPage();                  break;
            case "add more card page":               pom_abstract = new AddMorePrepaidCardPage();              break;
            case "added more card success page":     pom_abstract = new AddedMoreCardSuccessPage();            break;
            case "payroll deduct page":              pom_abstract = new PayrollCardDeductPage();               break;
            case "add more card payroll page":       pom_abstract = new AddMorePayrollCardPage();              break;
            case "faq page":                         pom_abstract = new FAQPage();                             break;
            case "create new password page":         pom_abstract = new CreateNewPasswordPage();               break;
            case "forgot password page":             pom_abstract = new ForgotPasswordPage();                  break;
            case "forgot password message page":     pom_abstract = new ForgotPasswordMessagePage();           break;
            case "prepaid card detail page":         pom_abstract = new PrepaidCardDetailPage();               break;
            case "prepaid card manual reload page":  pom_abstract = new PrepaidCardManualReloadPage();         break;
            case "prepaid card reload page":         pom_abstract = new PrepaidCardReloadPage();               break;
            case "privacy policy page":              pom_abstract = new PrivacyPolicyPage();                   break;
            case "terms and condition page":         pom_abstract = new TermsAndConditionPage();               break;


            default:
                throw new RuntimeException("Page \"" + pageName + "\" not registered in MoreMobilePageFactory" );
        }
    }

    public static MoreMobileAbstractBasePage getPageObject(){
        if (pom_abstract ==null)
            throw new RuntimeException("Page is not registered in MoreMobilePageFactory");
        return pom_abstract;
    }
}
