package com.Origin.testcases;

import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.SmokeSuite;

public class MultipleEDPTest extends baseclass{
	
	@Test(groups = {"Smoke"})
	public void MultipleEDPVideoTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.multipleEDP("Video", "ID-T1150");
	}
	
	@Test(groups = {"Smoke"})
	public void MultipleEDPDisplayTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.multipleEDP("Display", "ID-T1149");
	}
	
	@Test(groups = {"Smoke"})
	public void MultipleEDPOtherTest() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.multipleEDP("Other", "ID-T1154");
	}
}