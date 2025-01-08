package com.Origin.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LoginPage;
import com.Origin.utility.Log;
import com.Origin.utility.UniqueNameUtil;
public class LoginPageTest extends baseclass{
	
	@Test(groups = {"Smoke"})
	public void LoginTest() throws InterruptedException
	{
		Log.startTestCase("Verify Successful Login to Origin ID-T563");
		LoginPage loginPg = new LoginPage();
		Log.info("Going to enter username and password");
		String actURL = driver.get().getCurrentUrl();
		String expUrl="https://test-cmm.origincrossmedia.com/";
		Assert.assertEquals(actURL, expUrl);
	    loginPg.login(prop.getProperty("Email"),prop.getProperty("Password"));
		Log.endTestCase("Verify Successful Login Successfull");
	}
		
	@Test(groups = {"Smoke"})
	public void LogoutTest() throws InterruptedException
	{
		Log.startTestCase("Verifying Logout from Origin ID-T97");
		LoginPage loginPg = new LoginPage();
		Log.info("Going to enter username and password");
		String actURL = driver.get().getCurrentUrl();
		String expUrl="https://test-cmm.origincrossmedia.com/";
		Assert.assertEquals(actURL, expUrl);
	    loginPg.login(prop.getProperty("Email"), prop.getProperty("Password"));
		loginPg.logout();
		Log.endTestCase("Verifying Logout Successfull");
	}
     
	@Test(groups = {"Smoke"})
	public void FailedLoginTest() throws InterruptedException
	{
		Log.startTestCase("Verifiying Failed Login to Origin ID-T567");
		LoginPage loginPg = new LoginPage();
		UniqueNameUtil uniqueNameUtil = new UniqueNameUtil();
		Log.info("Going to enter invalid email and password");
		loginPg.Failedlogin(uniqueNameUtil.getRandomString(12) + "@yahoo.com", prop.getProperty("InvalidPassword"));
		loginPg.checkErrorMsg();
		Log.endTestCase("Verifying Failed login was passed");
	}
	
	@Test(groups = {"Regression"})
	public void TermsLinkPresent() throws Throwable
	{
		Log.startTestCase("Verifying Terms of Service from Origin ID-611");
		LoginPage loginPg = new LoginPage();
		Log.info("Going to validate Active present for Terms of Service");
		String actURL = driver.get().getCurrentUrl();
		String expUrl="https://test-cmm.origincrossmedia.com/";
		Assert.assertEquals(actURL, expUrl);
		loginPg.TermsofserviceLink();
		Log.endTestCase("Verifying link is active");
	    
	}
	
	@Test(groups = {"Regression"})
	public void HeaderTiles() throws Throwable
	{
		Log.startTestCase("Verifying  Terms of Service from Origin id-2306");
		LoginPage loginPg = new LoginPage();
		Log.info("Going to validate Active present for Terms of Service");
		String actURL = driver.get().getCurrentUrl();
		String expUrl="https://test-cmm.origincrossmedia.com/";
		Assert.assertEquals(actURL, expUrl);
		loginPg.LoginPageTitle();
		Log.endTestCase("Verifying the Title in the Login page and Origin Logo");
	}
	
	@Test(groups = {"Regression"})
	public void ResetPassword() throws Throwable
	{
		Log.startTestCase("Verifying  Terms of Service from Origin id-2306");
		LoginPage loginPg = new LoginPage();
		Log.info("Going to validate Active present for Terms of Service");
		String actURL = driver.get().getCurrentUrl();
		String expUrl="https://test-cmm.origincrossmedia.com/";
		Assert.assertEquals(actURL, expUrl);
		loginPg.ResetPassword(); 
		Log.endTestCase("Verifying the Reset functionality");
	}
}




