package com.cantaloupe.moreMobile;

import com.cantaloupe.moreMobile.pages.AddMorePayrollCardPage;
import com.cantaloupe.moreMobile.pages.AddMorePrepaidCardPage;
import com.cantaloupe.moreMobile.pages.AddedMoreCardSuccessPage;
import com.cantaloupe.moreMobile.pages.ChangePasswordPage;
import com.cantaloupe.moreMobile.pages.ConfirmRegistrationPage;
import com.cantaloupe.moreMobile.pages.CreateAccountPage;
import com.cantaloupe.moreMobile.pages.CreateNewPasswordPage;
import com.cantaloupe.moreMobile.pages.CreateOrLoginWithDifferentOptions;
import com.cantaloupe.moreMobile.pages.DashboardPage;
import com.cantaloupe.moreMobile.pages.FAQPage;
import com.cantaloupe.moreMobile.pages.ForgotPasswordMessagePage;
import com.cantaloupe.moreMobile.pages.ForgotPasswordPage;
import com.cantaloupe.moreMobile.pages.HomePage;
import com.cantaloupe.moreMobile.pages.InitialCreateAccountPage;
import com.cantaloupe.moreMobile.pages.PayrollCardDeductPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardDetailPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardManualReloadPage;
import com.cantaloupe.moreMobile.pages.PrepaidCardReloadPage;
import com.cantaloupe.moreMobile.pages.PrivacyPolicyPage;
import com.cantaloupe.moreMobile.pages.SignInWithExistingAccountPage;
import com.cantaloupe.moreMobile.pages.TermsAndConditionPage;
import com.cantaloupe.moreMobile.pages.UpdateProfilePage;

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
