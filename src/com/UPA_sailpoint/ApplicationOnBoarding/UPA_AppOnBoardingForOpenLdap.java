package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForOpenLdap extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=8;
		reportname="UPA_FullAppOnBoardingOpenLdap";
		browsername="chrome";
		
	}

	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox,String path,String type,String status,String nativeobject,String displayattribute,String identityattribute,String accountcorrelation,String correlation,String creation,String customization,String manager,String entitement,String AppOwner,String AppRevoker,String AppCertifier,String taskname1,String taskname2,String taskname3) {
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
		
//		if(Appname.equalsIgnoreCase("HK HR")) {
//			String[] attributes= new String[] {"STATUS","USERID","Username","First Name","Last Name","Middle Name","Manager","Human Resource","Area","Job Code","Division","Store / Site / Department","Time Zone",
//				"Hire Date","Employee Id","Title","Business Phone","Business Fax","Address 2","City","State","Post Code","Country","Review Frequency",
//				"Last Review Date","Position Id","FT/PT Casual","Cost Center","Line Manager","Employment Type","HR Level","Grade","Customizable Field 9",
//				"Customizable Field 10","Customizable Field 11","Customizable Field 12","Customizable Field 13","Customizable Field 14","HRCode","Matrix Manager","Default Locale","Custom Manager","Second Manager","Division_ID","Area_ID"};
//		
//			int count=attributes.length;
//		
//			for(int i=0;i<count;i++) {
//				new SchemaPage(driver, test)
//				.verifyAttribute(attributes[i], "string");
//		}
//		}else if(Appname.equalsIgnoreCase("PayGlobal")) {
//			String[] attributes= new String[] {"SF User ID","PAY PERIOD CODE","PAY PERIOD DESCRIPTION","EMPLOYEE CODE","FIRST NAME","MIDDLE NAMES","LAST NAME","EMAIL ID","PREFERRED NAME","MANAGER_ID","MANAGER_NAME",
//					"POST CODE","COST CENTRE DESCRIPTION","WOW COST CENTRE","DIVISION","DIVISION DESCRIPTION","REGION","REGION DESCRIPTION","AREA CODE","AREA DESCRIPTION","COUNTRY","DEPARTMENT CODE","DEPARTMENT DESCRIPTION",
//					"POSITION CODE","POSITION DESCRIPTION","SALARIED/WAGED","EMPLOYEE STATUS","GENDER","START DATE","EMPLOYEE TERMINATED Y/N","TERMINATIONDATE","TERMINATION_REASON_DESCRIPTION","RECORD_UPDATE_DATE",
//					"ABSENCE BEGIN DATE","ABSENCE END DATE","ABSENCE TYPE"};
//			
//			int count=attributes.length;
//			
//			for(int i=0;i<count;i++) {
//				new SchemaPage(driver, test)
//				.verifyAttribute(attributes[i], "string");
//			}
//		}
		
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
