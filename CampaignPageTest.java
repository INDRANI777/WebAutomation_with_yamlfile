package com.Origin.testcases;

import com.Origin.utility.AdvertUtil;
import com.Origin.utility.UniqueNameUtil;
import org.testng.annotations.Test;

import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.CampaignPage;
import com.Origin.pageobjects.LandingPage;
import com.Origin.pageobjects.LoginPage;
import com.Origin.pageobjects.MediaTypePage;
import com.Origin.utility.Log;

public class CampaignPageTest extends baseclass {

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

	private String[] preconditionOfCampaignPage(String testCaseName, String edpType, String mediaTypeName) throws InterruptedException
	{
		Log.startTestCase(testCaseName);
		loginProcess();
		LandingPage landingPage = new LandingPage();
		String campaignName = landingPage.getRepeatedCampaignName();
		Log.info("Going to create Report name");
		String reportName = landingPage.createNewReportName(edpType, mediaTypeName);
		Log.info("Going to select media type " + mediaTypeName);
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoTypeFlow();
		String[] result = {reportName, campaignName};
	    return result;
	}
	
	@Test(groups = {"Regression"})
	public void verifyCampaignPageElements() throws InterruptedException
	{
		String reportName = preconditionOfCampaignPage("Verifying campaign page elements ID-T639", "Video","")[0];
		CampaignPage campaignPage = new CampaignPage();
		campaignPage.verifyCampaignPageElements(reportName);
		Log.endTestCase("Verifying campaign page elements Successful");
	}

	@Test(groups = {"Regression"})
	public void testPublisherDropdown() throws InterruptedException
	{
		preconditionOfCampaignPage("Verifying publisher dropdown button ID-T654, ID-T655, ID-T656, ID-T657, ID-T716, ID-1054", "Video","");
		CampaignPage campaignPage = new CampaignPage();
		campaignPage.testPublisherDropdown();
		Log.endTestCase("Verifying publisher dropdown button Successful");
	}

	@Test(groups = {"Regression"})
	public void verifyVideoMediaTypeEventGroups() throws InterruptedException
	{
		Log.startTestCase("Verify event groups, when media type is Video. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Video_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Video Media Type Option");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoTypeFlow();
		campaignPage.setUpSearchFilter();
		AdvertUtil advertUtil = new AdvertUtil();
		advertUtil.set50RowsForTable();
		Log.info("Verify event groups Measured Entity name including for Video media type");
		advertUtil.VerifyEventGroupsBasedOnMediaType("Video");
		Log.endTestCase("Verify event groups, when media type is Video. Successful");
	}

	@Test(groups = {"Regression"})
	public void verifyDisplayMediaTypeEventGroups() throws InterruptedException
	{
		Log.startTestCase("Verify event groups, when media type is Display. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Display_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Display Media Type Option");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.displayTypeFlow();
		campaignPage.setUpSearchFilter();
		AdvertUtil advertUtil = new AdvertUtil();
		advertUtil.set50RowsForTable();
		Log.info("Verify event groups Measured Entity name including for Display media type");
		advertUtil.VerifyEventGroupsBasedOnMediaType("Display");
		Log.endTestCase("Verify event groups, when media type is Display. Successful");
	}

	@Test(groups = {"Regression"})
	public void verifyOtherMediaTypeEventGroups() throws InterruptedException
	{
		Log.startTestCase("Verify event groups, when media type is Other. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Other_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Other Media Type Option");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.otherTypeFlow();
		campaignPage.setUpSearchFilter();
		AdvertUtil advertUtil = new AdvertUtil();
		advertUtil.set50RowsForTable();
		Log.info("Verify event groups Measured Entity name including for Other media type");
		advertUtil.VerifyEventGroupsBasedOnMediaType("Other");
		Log.endTestCase("Verify event groups, when media type is Other. Successful");
	}

	@Test(groups = {"Regression"})
	public void verifyCrossMediaTypeEventGroups() throws InterruptedException
	{
		Log.startTestCase("Verify event groups, when Cross-media type report. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Cross_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Cross-Media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoAndDisplayAndOtherFlow();
		campaignPage.setUpSearchFilter();
		AdvertUtil advertUtil = new AdvertUtil();
		advertUtil.set50RowsForTable();
		Log.info("Verify event groups Measured Entity name including for cross-media type");
		advertUtil.VerifyEventGroupsBasedOnMediaType("Cross");
		Log.endTestCase("Verify event groups, when Cross-media type report. Successful");
	}

	@Test(groups = {"Regression"})
	public void negativeScenarioOfSelectingEGByVideoMediaType() throws InterruptedException
	{
		Log.startTestCase("Verify Fastflix event groups is not appearing for Video media type. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Cross_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Video media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoTypeFlow();
		campaignPage.setUpSearchFilter("Fastflix");
		AdvertUtil advertUtil = new AdvertUtil();
		Log.info("Verify advert list is empty with Fastflix");
		advertUtil.verifyAdvertListIsEmpty();
		Log.endTestCase("Verify event groups is not appearing for Video media type. Successful");
	}

	@Test(groups = {"Regression"})
	public void negativeScenarioOfSelectingEGByDisplayMediaType() throws InterruptedException
	{
		Log.startTestCase("Verify Linear TV, Fastflix event groups is not appearing for Display media type. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Cross_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Display media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.displayTypeFlow();
		campaignPage.setUpSearchFilter("Linear TV");
		AdvertUtil advertUtil = new AdvertUtil();
		Log.info("Verify advert list is empty with Linear TV");
		advertUtil.verifyAdvertListIsEmpty();
		campaignPage.setUpSearchFilter("Fastflix");
		Log.info("Verify advert list is empty with Fastflix");
		advertUtil.verifyAdvertListIsEmpty();
		Log.endTestCase("Verify event groups is not appearing for Display media type. Successful");
	}

	@Test(groups = {"Regression"})
	public void negativeScenarioOfSelectingEGByOtherMediaType() throws InterruptedException
	{
		Log.startTestCase("Verify Linear TV, Vubox event groups is not appearing for Other media type. ID-2344");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		landingPg.enterReportNameAndContinue("AutoTest_Cross_Media_Type_" + uniqueNameUtil.addingDateAndTimeAtTheEnd());
		Log.info("Going to select Other media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.otherTypeFlow();
		campaignPage.setUpSearchFilter("Linear TV");
		AdvertUtil advertUtil = new AdvertUtil();
		Log.info("Verify advert list is empty with Linear TV");
		advertUtil.verifyAdvertListIsEmpty();
		campaignPage.setUpSearchFilter("Vubox");
		Log.info("Verify advert list is empty with Vubox");
		advertUtil.verifyAdvertListIsEmpty();
		Log.endTestCase("Verify event groups is not appearing for Other media type. Successful");
	}

//	@Test(groups = {"Regression"})
//	public void datesValidationPossibilitiesTest() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//	
//	@Test(groups = {"Regression"})
//	public void clearFilter() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//	
//	@Test(groups = {"Regression"})
//	public void selectCampaignValid() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//

//	@Test(groups = {"Regression"})
//	public void createCampaignNameWithValidNameLengthAndSpecialCharAndWhitespaces() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//
//		Log.endTestCase("Verifying  Successful");
//	}

	@Test(groups = {"Regression"})
	public void validSpecialCharactersCampaignNameCheck() throws InterruptedException
	{
		Log.startTestCase("Verify valid special characters in report name ID-T585");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		CampaignPage campaignPage = new CampaignPage();
		String campaignName = campaignPage.validCharacters + uniqueNameUtil.addingDateAndTimeAtTheEnd();
		landingPg.enterReportNameAndContinue(campaignName);
		landingPg.checkReportNameTitle(campaignName);
		Log.info("Going to select Video Display Other Media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoAndDisplayAndOtherFlow();
		campaignPage.typeCampaignName(campaignName);
		campaignPage.setUpSearchFilter();
		AdvertUtil advertUtil = new AdvertUtil();
		advertUtil.selectAdvertAndTypeCampaignName("Fastflix", "Facebook", "Other");
		campaignPage.addingDateToCampaignNameInTheEnd();
		campaignPage.saveAndContinueCampaignFlow(false);
		Log.endTestCase("Verify valid characters for campaign name Successfull");
	}

//	@Test(groups = {"Regression"})
//	public void createCampaignNameWithInvalidValue() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//
//		Log.endTestCase("Verifying  Successful");
//	}

	@Test(groups = {"Regression"})
	public void invalidSpecialCharactersCampaignNameCheck() throws InterruptedException
	{
		Log.startTestCase("Verify invalid special characters in report name ID-T586");
		loginProcess();
		LandingPage landingPg = new LandingPage();
		landingPg.createNewReportName("CrossMediaEDP",  "Video,Display,Other");
		Log.info("Going to select Video Display Other Media Type Options");
		MediaTypePage mediaTypePage = new MediaTypePage();
		mediaTypePage.videoAndDisplayAndOtherFlow();
		CampaignPage campaignPage = new CampaignPage();
		campaignPage.typeCampaignName(campaignPage.invalidCharacters);
		campaignPage.checkWarningMessageOfCampaignNameInvalidCharacters();
		Log.endTestCase("Verify invalid characters for campaign name Successfull");
	}
//
//	@Test(groups = {"Regression"})
//	public void checkCampaignNameWithBlankInput() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//	
//	@Test(groups = {"Regression"})
//	public void checkReportNameWithLongInput() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//
	@Test(groups = {"Regression"})
	public void checkTheCampaignNameUniqueness() throws InterruptedException
	{
		String campaignName = preconditionOfCampaignPage("Verifying campaign name uniqueness ID-T706", "Video","")[1];
		CampaignPage campaignPage = new CampaignPage();
		campaignPage.checkTheReportNameUniqueness(campaignName);
		Log.endTestCase("Verifying campaign name uniqueness Successful");
	}
//
//	@Test(groups = {"Regression"})
//	public void checkTheSecurityAgainstXSSAttack() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
//	
//	@Test(groups = {"Regression"})
//	public void refreshWebpageAndCheckTheEmptyInput() throws InterruptedException
//	{
//		preconditionOfCampaignPage("", "Video, Display, Other");
//		
//		Log.endTestCase("Verifying  Successful");
//	}
}
