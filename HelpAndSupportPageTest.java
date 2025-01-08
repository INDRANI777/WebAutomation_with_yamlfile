package com.Origin.testcases;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.HelpAndSupportPage;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.utility.Log;
import org.testng.annotations.Test;

public class HelpAndSupportPageTest extends baseclass {
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
    public void verifyHelpAndSupportPageElements() throws InterruptedException
    {
        Log.startTestCase("Verify Help and Support page elements ID-52, ID-2296");
        loginProcess();
        HelpAndSupportPage helpAndSupport = new HelpAndSupportPage();
        helpAndSupport.verifyHelpAndSupportPageElements();
        Log.endTestCase("Verify Help and Support page elements Successfull");
    }

    @Test(groups = {"Regression"})
    public void goingToHelpAndSupportDuringReportCreation() throws InterruptedException
    {
        Log.startTestCase("Verify Help and Support page elements ID-52, TM-284");
        loginProcess();
        HelpAndSupportPage helpAndSupport = new HelpAndSupportPage();
        helpAndSupport.verifyBehaviourOfGoingToHelpAndSupportPageDuringReportCreation();
        Log.endTestCase("Verify behavior of redirection into Help and Support page during report creation Successfull");
    }
}
