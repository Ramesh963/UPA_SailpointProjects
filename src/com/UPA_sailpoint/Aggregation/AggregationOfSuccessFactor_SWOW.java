package com.UPA_sailpoint.Aggregation;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.HomePage;

import wrappers.TestSuite;

public class AggregationOfSuccessFactor_SWOW extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAggregation";
		sheetnum=3;
		reportname="UPA_AggregationForSWOW & SF";
		browsername="chrome";
		
	}
	@Test(dataProvider="fetchdata")
	public void aggregation(String appname,String taskname) {
		startTest("Aggregation of "+appname);
		new HomePage(driver, test)
		.clickSetup()
		.clickOnTasks()
		.enterTaskName(taskname)
		.verifyTheTaskname(taskname)
		.clickOnTaskResults()
		.enterResultName(taskname)
		.verifyResults(taskname)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask();
		
		
	}
}
