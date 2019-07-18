package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForSAP extends TestSuite {
	
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=9;
		reportname="UPA_FullAppOnBoardingSAP_Direct";
		browsername="chrome";
		
	}
	
	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox, String path,String type,
			String status,String nativeobject,String displayattribute,String identityattribute,String accountcorrelation,
			String correlation,String creation,String customization,String manager,String entitement,String AppOwner,
			String AppRevoker,String AppCertifier,String taskname1,String taskname2,String taskname3) {
		startTest("Application details and configuration of  "+Appname);
		new HomePage(driver, test)
		.clickOnApplications()
		.clickOnAppDefinition()
		.enterAppName(Appname)
		.clickOnSearchIcon()
		.clickOnApplication()
		.verifyAppName(Appname1)
		.verifyTheRevoker(revoker)
		.verifyTheOwner(owner)
		.verifyTheAppType(Apptype)
		//.getDescription()
		.checkForAuthoritative(checkbox)
		.clickOnConfiguration()
		
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
		.clickSchema()
		.verifyNativeObjectType(nativeobject)
		.verifyDisplayAttribute(displayattribute)
		.verifyIdentityAttribute(identityattribute);
		
		
		
		
		new CorrelationPage(driver, test)
		.clickOnCorrelation()
		.verifyAccountCorrelation(accountcorrelation)
		.clickOnRule()
		.verifyCorrelationRule(correlation)
		.verifyCreationRule(creation)
		.verifyCustomizationRule(customization)
		.verifyManagerCorrelationRule(manager)
		.verifyEntitlementCustomizationRule(entitement)
		.clickSetup()
		.clickOnGroups()
		.clickOnWorkgroups()
		.verifyAppOwner(AppOwner)
		.verifyAppRevokers(AppRevoker);
		driver.navigate().refresh();
		
		new HomePage(driver, test)
		.clickSetup()
		.clickOnTasks()
		.enterTaskName(taskname1)
		.verifyTheTaskname(taskname1)
		.enterTaskName(taskname2)
		.verifyTheTaskname(taskname2)
		.enterTaskName(taskname3)
		.verifyTheTaskname(taskname3)
		.clickOnTaskResults()
		.enterResultName(taskname1)
		.verifyResults(taskname1)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask()
		.enterResultName(taskname2)
		.verifyResults(taskname2)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask()
		.enterResultName(taskname3)
		.verifyResults(taskname3)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask();
		
	}
}
