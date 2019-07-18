package com.UPA_sailpoint.Aggregation;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.HomePage;

import wrappers.TestSuite;

public class AggregationOfDelimited_HK extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAggregation";
		sheetnum=0;
		reportname="UPA_AggregationForDelimited";
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
