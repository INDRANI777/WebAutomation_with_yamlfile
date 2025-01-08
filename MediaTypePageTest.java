package com.Origin.testcases;

import org.testng.annotations.Test;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.pageobjects.MediaTypePage;
import com.Origin.utility.Log;

public class MediaTypePageTest extends baseclass {
	
	private String preconditionOfMediaTypePage(String testCaseName, String mediaTypeName,String edpType) throws InterruptedException
	{
		Log.startTestCase(testCaseName);
		LoginPage loginPg = new LoginPage();
		LandingPage landingPg = new LandingPage();
		Log.info("Going to enter username and password");
		loginPg.login(prop.getProperty("Email"), prop.getProperty("Password"));
		Log.info("Going to Landing page and accept Cookie policy");
		landingPg.acceptCookiePolicy();
		landingPg.createNewReportName(mediaTypeName,edpType);
		return mediaTypeName;
	}
	
	@Test(groups = {"Regression"})
	public void VerificationOfDifferentMediaTypes() throws InterruptedException
	{
		preconditionOfMediaTypePage("Verifying Video/Display/Other media types flow TM-T77 TM-T79 TM-T80 TM-T82 TM-T117 TM-T402 TM-T403", "Video, Display, Other","");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoAndDisplayAndOtherFlow();
		Log.endTestCase("Verifying Video/Display/Other media type flow Successful");
	}
	
	@Test(groups = {"Regression"})
	public void VerificationOfMediaTypeSelectionPersistsAfterClickingBackButtonOnCampaignPage() throws InterruptedException
	{
		preconditionOfMediaTypePage("Verifying Media Type selection persists when user clicks Back button TM-T453","","");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.mediaTypeSelectionPersistsAfterClickingBackButton();
		Log.endTestCase("Verifying Media Type selection persists when user clicks Back button Successful");
	}
	
	@Test(groups = {"Regression"})
	public void checkDisabledContinueButton() throws InterruptedException
	{
		preconditionOfMediaTypePage("Verifying  Disabled Continue Button TM-T189 TM-T405", "","");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.disabledContinueButton();
		Log.endTestCase("Verifying  Disabled Continue Button Successful");
	}
	
	@Test(groups = {"Regression"})
	public void refreshWebpageAndCheckInputs() throws InterruptedException
	{
		preconditionOfMediaTypePage("Verifying refresh Media type page TM-T129 TM-T131", "","");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.refreshMediaTypePage();
		Log.endTestCase("Verifying Media type page Successful");
	}
	
	@Test(groups = {"Regression"})
	public void checkMediaTypesExpandableDescription() throws InterruptedException
	{
		preconditionOfMediaTypePage("Verifying media types expandable description TM-T131 TM-T404 TM-T493","","");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.mediaTypesExpandableDescription();
		Log.endTestCase("Verifying media types expandable description Successful");
	}
}
