package com.Origin.testcases;

import com.Origin.utility.UniqueNameUtil;
import org.testng.annotations.Test;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.utility.Log;

public class LandingPageTest extends baseclass{
	
	private void preconditionOfLandingPage(String testCaseName) throws InterruptedException
	{
		Log.startTestCase(testCaseName);
		LoginPage loginPg = new LoginPage();
		LandingPage landingPg = new LandingPage();
		Log.info("Going to enter username and password");
		loginPg.login(prop.getProperty("Email"), prop.getProperty("Password"));
		Log.info("Going to Landing page and accept Cookie policy");
		landingPg.acceptCookiePolicy();
		landingPg.acceptTermsOfService();
	}
	
	@Test(groups = {"Regression"})
	public void VerifyLandingPageElements() throws InterruptedException
	{
		preconditionOfLandingPage("Verify Landing page elements ");
		LandingPage landingPg = new LandingPage();
		landingPg.checkLandingPageElements();
		Log.endTestCase("Verify Landing page elements Successfull");
	}

	@Test(groups = {"Regression"})
	public void CreateReportName(String edpType) throws InterruptedException
	{
		preconditionOfLandingPage("Verify Creation report name to Origin TM-T55");
		LandingPage landingPg = new LandingPage();
		String reportName = landingPg.createNewReportName("Video",edpType);
		landingPg.checkReportNameTitle(reportName);
		Log.endTestCase("Verify Creation report name Successfull");
	}

	@Test(groups = {"Regression"},
			dataProvider = "setInputValueAndCompareTheResult",
			dataProviderClass = LandingPage.class)
	public void checkReportNameWithValidValues(String input, String output) throws InterruptedException
	{
		preconditionOfLandingPage("Verify Report Name with valid values TM-T55, TM-T60, TM-T61, TM-T62, TM-T64, TM-T65, TM-T66");
		LandingPage landingPg = new LandingPage();
		landingPg.typeValidReportNameAndCheckTitle(input, output);
		Log.endTestCase("Verify Creation valid report name Successfull");
	}

	@Test(groups = {"Regression"})
	public void validSpecialCharactersReportNameCheck() throws InterruptedException
	{
		preconditionOfLandingPage("Verify valid special characters in report name ID-T585");
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		String reportName = landingPg.validCharacters + uniqueNameUtil.addingDateAndTimeAtTheEnd();
		landingPg.enterReportNameAndContinue(reportName);
		landingPg.checkReportNameTitle(reportName);
		Log.endTestCase("Verify valid characters for report name Successfull");
	}

	@Test(groups = {"Regression"},
			dataProvider = "setInvalidValueAndCheckError",
			dataProviderClass = LandingPage.class)
	public void checkErrorMessageWithInvalidReportNames(String input, String errorMsg) throws InterruptedException
	{
		preconditionOfLandingPage("Verify Report Name with invalid values TM-T57, TM-T56");
		LandingPage landingPg = new LandingPage();
		landingPg.typeInvalidReportNameAndCheckError(input, errorMsg);
		Log.endTestCase("Verify Creation invalid report name Successfull");
	}

	@Test(groups = {"Regression"})
	public void invalidSpecialCharactersReportNameCheck() throws InterruptedException
	{
		preconditionOfLandingPage("Verify invalid special characters in report name ID-T586");
		LandingPage landingPg = new LandingPage();
		landingPg.typeInvalidReportNameAndCheckError(landingPg.invalidCharacters, "The report name contains invalid characters. Please enter a different name.");
		Log.endTestCase("Verify invalid characters for report name Successfull");
	}
	
	@Test(groups = {"Regression"})
	public void checkTheReportNameUniqueness() throws InterruptedException
	{
		preconditionOfLandingPage("Verify report name on uniqueness TM-T58");
		LandingPage landingPg = new LandingPage();
		landingPg.typeRepeatedReportNameAndCheckError();
		Log.endTestCase("Verify Creation unique report name Successfull");
	}

	@Test(groups = {"Regression"})
	public void checkTheSecurityAgainstXSSAttack() throws InterruptedException
	{
		preconditionOfLandingPage("Verify security check against XSS attack TM-T67");
		LandingPage landingPg = new LandingPage();
		landingPg.typeXSSCodeInReportNameInputAndCheckError();
		Log.endTestCase("Verify protection agains XSS attack Successfull");
	}

	@Test(groups = {"Regression"})
	public void cancelTheCreateReportModalWindow() throws InterruptedException
	{
		preconditionOfLandingPage("Velify cancelation of Create report name TM-T59");
		LandingPage landingPg = new LandingPage();
		landingPg.closeCreateReportWindow();
		Log.endTestCase("Verify Closing report name window Successfull");
	}

	@Test(groups = {"Regression"})
	public void refreshWebpageAndCheckTheEmptyInput() throws InterruptedException
	{
		preconditionOfLandingPage("Verify empty report name input after refreshing webpage TM-T63");
		LandingPage landingPg = new LandingPage();
		landingPg.refreshWebpageAndCheckTheEmptyInput();
		Log.endTestCase("Verify empty report name after refreshin webpage Successfull");
	}
}
