package com.Origin.testcases;

import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.SmokeSuite;

public class DownloadFunctionalityTest extends baseclass{
	
	@Test(groups = {"Smoke"})
	public void DownloadReportTest() throws Throwable
	{
		SmokeSuite SmokePg = new SmokeSuite();
		SmokePg.downloadReport();
	}
} 