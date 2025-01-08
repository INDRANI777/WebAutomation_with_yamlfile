package com.Origin.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.LoginPage;
import com.Origin.pageobjects.SmokeSuite;
import com.Origin.utility.Log;
import com.Origin.utility.UniqueNameUtil;
public class DemograhicsTest extends baseclass{
	
	@Test(groups = {"Regression"})
	public void DemograhicsSelectionTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.DemographicView("Testcase of demographics", "ID-2375");
	}
	
}
