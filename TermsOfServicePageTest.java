package com.Origin.testcases;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.pageobjects.TermsOfServicePage;
import com.Origin.utility.Log;
import org.testng.annotations.Test;

public class TermsOfServicePageTest  extends baseclass {
    private void loginProcess() throws InterruptedException
    {
        Log.info("Going to enter username and password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        Log.info("Going to Landing page and accept Cookie policy");
        LandingPage landingPage = new LandingPage();
        landingPage.acceptCookiePolicy();
        landingPage.acceptTermsOfService();
    }

    @Test(groups = {"Regression"})
    public void verifyTermsOfServicePageElements() throws InterruptedException
    {
        Log.startTestCase("Verify Terms of Service page elements ID-611, ID-2296");
        loginProcess();
        TermsOfServicePage termsOfServicePage = new TermsOfServicePage();
        termsOfServicePage.verifyTermsOfServicePageElements();
        Log.endTestCase("Verify Terms of Service page elements Successfull");
    }

    @Test(groups = {"Regression"})
    public void goingToTermsOfServiceDuringReportCreation() throws InterruptedException
    {
        Log.startTestCase("Verify behavior of redirection into Terms of Service page during report creation ID-611, TM-284");
        loginProcess();
        TermsOfServicePage termsOfServicePage = new TermsOfServicePage();
        termsOfServicePage.verifyBehaviourOfGoingToTermsOfServicePageDuringReportCreation();
        Log.endTestCase("Verify behavior of redirection into Terms of Service page during report creation Successfull");
    }
}
