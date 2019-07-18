package com.UPA_sailpoint.Aggregation;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.HomePage;

import wrappers.TestSuite;

public class AggregationOfGoogleApps extends TestSuite{
	
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname = "UPA_SailpointAggregation";
		sheetnum = 2;
		reportname = "UPA_AggregationForGoogleApps";
		browsername = "chrome";
	
	}
	
	@Test(dataProvider = "fetchdata")
	public void aggregation(String appname, String taskname) {
		startTest("Aggregation of "+appname);
		new HomePage(driver, test)
		.clickSetup()
		.clickOnTasks()
		.enterTaskName(taskname)
		.clickSearchIconOnTask()
		.verifyTheTaskname(taskname)
		.clickOnTaskResults()
		.enterResultName(taskname)
		.clickOnResult1()
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask()
		.enterResultName(taskname)
		.clickOnResult2()
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask();
	}

}
