package com.UPA_sailpoint.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.HomePage;

import wrappers.TestSuite;

public class TestconnectionForUPA extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="TestconnectionForUPA";
		sheetnum=1;
		reportname="TestconnectionUPAreport";
		browsername="chrome";
		
	}
@Test(dataProvider="fetchdata")
	public void appInfo(String Appname,String testconnection) {
	startTest("Application of  "+" '"+Appname+""+"' ");
		new HomePage(driver, test)
		.clickOnApplications()
		.clickOnAppDefinition()
		.enterAppName(Appname)
		.clickOnSearchIcon()
		.clickOnApplication()
		.verifyAppNameForTestConnection(Appname)
		//.checkForAuthoritative()
		.clickOnConfiguration()
		.clickTheTestConnection()
		.checkTestConnectionStatus(testconnection);
	}
}
