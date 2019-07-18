package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForDelimited extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=0;
		reportname="UPA_FullAppOnBoardingDelimited";
		browsername="chrome";
		
	}

	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox,String path,
			String parsetype,String Delimvalue, String fileTransport,String numberlines, String filterempty, String status,
			String nativeobject, String displayattribute,String identityattribute,String accountcorrelation,
			String correlation,String creation,String customization,String manager,String entitement,String AppOwner,
			String AppRevoker,String taskname1,String taskname2,String taskname3, String taskname4) {
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
		.verifyTheFilePath(path)
		.checkForParsingType(parsetype)
		.fileTrasport(fileTransport)
		.getDelimiterValue(Delimvalue)
		.getNumberOfLinesToSkip(numberlines)
		.checkForFilterEmpty(filterempty)
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
//		.clickOnMerging()
//		.verifyOnMerging()
		.clickSchema()
		.verifyNativeObjectType(nativeobject)
		.verifyDisplayAttribute(displayattribute)
		.verifyIdentityAttribute(identityattribute);
		
		if(Appname.equalsIgnoreCase("HK HR")) {
			
			int count=UPA_SchemaAttributesObjects.accountAttributesHK.length;
		
			for(int i=0;i<count;i++) {
				if((i%15==0)||(i==count-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttribute(UPA_SchemaAttributesObjects.accountAttributesHK[i], "string");
		}
			
		}else if(Appname.equalsIgnoreCase("PayGlobal")) {
			
			int count1=UPA_SchemaAttributesObjects.accountAttributesPayGlobal.length;
			
			for(int j=0;j<count1;j++) {
				if((j%15==0)||(j==count1-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+j+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttribute(UPA_SchemaAttributesObjects.accountAttributesPayGlobal[j], "string");
			}
		}
		
		if(Appname.equalsIgnoreCase("ALH")) {
			
			int count2=UPA_SchemaAttributesObjects.accountAttributesALH.length;
		
			for(int k=0;k<count2;k++) {
				if((k%15==0)||(k==count2-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+k+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttribute(UPA_SchemaAttributesObjects.accountAttributesALH[k], "string");
			}
			
		}	
			
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
		.enterTaskName(taskname4)
		.verifyTheTaskname(taskname4)
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
		.clickOnReturnToTask()
		.enterResultName(taskname4)
		.verifyResults(taskname4)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask();

	}

}
