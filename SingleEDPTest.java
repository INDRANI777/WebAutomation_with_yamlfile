package com.Origin.testcases;

import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.SmokeSuite;

public class SingleEDPTest extends baseclass{
	
	@Test(groups = {"Smoke"})
	public void SingleEDPVideoTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.singleEDP("Video", "ID-T779");
	}
	
	@Test(groups = {"Smoke"})
	public void SingleEDPDisplayTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.singleEDP("Display", "ID-T598");
	}
	
	@Test(groups = { "Smoke" })
	public void SingleEDPOtherTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.singleEDP("Other", "ID-T779");
	}
}