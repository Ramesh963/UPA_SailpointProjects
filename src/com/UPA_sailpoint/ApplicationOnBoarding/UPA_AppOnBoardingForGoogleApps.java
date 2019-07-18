package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForGoogleApps extends TestSuite{

	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=4;
		reportname="UPA_FullAppOnBoardingGoogleAppsReport";
		browsername="chrome";
	}
	
	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname, String Appname1, String revoker, String owner, String Apptype,String checkbox, String ClientID, 
			String Readgroup, String status, String nativeobject, String displayattribute, 
			String identityattribute, String roleNativeoject, String roleDisplayattribute, String roleIdentityattribute, 
			String groupnativeobject, String groupdisplayattribute, String groupidentityattribute, String accountcorrelation,
			String AppattrValue1, String IdattrValue1, String AppattrValue2, String IdattrValue2, String AppattrValue3, String IdattrValue3,
			String correlation, String creation, String customization, String manager, String entitement, String AppOwner, 
			String AppRevoker, String taskname1, String taskname2) {
		startTest("Application details and configuration of  "+Appname);
		new com.UPA_sailpoint.pages.HomePage(driver, test)
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
		.verifyClientID_GoogleApps(ClientID)
//		.verifyClientSecret_GoogleApps(ClientSecret)
		.verifyReadGroupDetails_GoogleApps(Readgroup)
//		.verifyPageSize_GoogleApps(pagesize)
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
		.clickSchema()
		.verifyNativeObjectType(nativeobject)
		.verifyDisplayAttribute(displayattribute)
		.verifyIdentityAttribute(identityattribute);
		
		
			
				int count = UPA_SchemaAttributesObjects.accountAttributesGoogleApps.length;
				for(int i=0; i<count;i++) {
					if((i%15==0)||(i==count-1)) {
						clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
					new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributesGoogleApps[i], "string");
				}
			
		
		new SchemaPage(driver, test)
		.verifyRoleNativeObjectType(roleNativeoject)
		.verifyRoleDisplayAttribute(roleDisplayattribute)
		.verifyRoleIdentityAttribute(roleIdentityattribute);
		
				
				int count1 = UPA_SchemaAttributesObjects.roleAttributesGoogleApps.length;
				for(int j=0; j<count1;j++) {
					if((j%15==0)||(j==count-1)) {
						clickByXpath(LocatorObjects.SchemaRoleAttribute+j+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
					new SchemaPage(driver, test).verifyAttributeForRole(UPA_SchemaAttributesObjects.roleAttributesGoogleApps[j], "string");
				}
		
		new SchemaPage(driver, test)		
		.verifyGroupNativeObjectForSwow(groupnativeobject)
		.verifyGroupDisplayAttributeForSwow(groupdisplayattribute)
		.verifyGroupIdentityAttributeForSwow(groupidentityattribute);
		
			
				int count2 = UPA_SchemaAttributesObjects.groupAttributesGoogleApps.length;
				for(int k=0; k<count2;k++) {
					if((k%15==0)||(k==count-1)) {
						clickByXpath(LocatorObjects.SchemaGroupAttribute+k+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
					new SchemaPage(driver, test).verifyGroupAttributeForSwow(UPA_SchemaAttributesObjects.groupAttributesGoogleApps[k], "string");
				}
		
		new CorrelationPage(driver, test)
		.clickOnCorrelation()
		.verifyAccountCorrelationForAccountBasedCorrelation(accountcorrelation)
		.verifyAttributeCorrelationValue1(AppattrValue1, IdattrValue1)
		.verifyAttributeCorrelationValue2ForGoogleApps(AppattrValue2, IdattrValue2)
		.verifyAttributeCorrelationValue3(AppattrValue3, IdattrValue3)
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
//		.verifyAppCertifiers(AppCertifier)
		.verifyAppRevokers(AppRevoker);
		driver.navigate().refresh();
		
		new HomePage(driver, test)
		.clickSetup()
		.clickOnTasks()
		.enterTaskName(taskname1)
		.verifyTheTaskname(taskname1)
		.enterTaskName(taskname2)
		.verifyTheTaskname(taskname2)
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
		.clickOnReturnToTask();
		
		
	}
}
