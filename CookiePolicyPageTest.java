package com.Origin.testcases;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.pageobjects.CookiePolicyPage;
import com.Origin.utility.Log;
import org.testng.annotations.Test;

public class CookiePolicyPageTest  extends baseclass {
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
    public void verifyCookiePolicyPageElements() throws InterruptedException
    {
        Log.startTestCase("Verify Cookie Policy page elements TM-995");//need to update later for ID-2453 implementation
        loginProcess();
        CookiePolicyPage cookiePolicyPage = new CookiePolicyPage();
        cookiePolicyPage.verifyCookiePolicyPageElements();
        Log.endTestCase("Verify Cookie Policy page elements Successfull");
    }

    @Test(groups = {"Regression"})
    public void goingToCookiePolicyDuringReportCreation() throws InterruptedException
    {
        Log.startTestCase("Verify behavior of redirection into Cookie Policy page during report creation TM-284");
        loginProcess();
        CookiePolicyPage cookiePolicyPage = new CookiePolicyPage();
        cookiePolicyPage.verifyBehaviourOfGoingToCookiePolicyPageDuringReportCreation();
        Log.endTestCase("Verify behavior of redirection into Cookie Policy page during report creation Successfull");
    }
}
