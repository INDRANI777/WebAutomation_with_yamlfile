package com.Origin.testcases;

import org.testng.annotations.Test;
import com.Origin.baseclass.baseclass;
import com.Origin.pageobjects.SmokeSuite;

public class CrossMediaFlowTest extends baseclass {
	
	@Test(groups = {"Smoke"})
	public void CrossMediaFlow() throws Throwable
	{
		SmokeSuite smoke = new SmokeSuite();
		smoke.crossMediaEDP();
	}
}
