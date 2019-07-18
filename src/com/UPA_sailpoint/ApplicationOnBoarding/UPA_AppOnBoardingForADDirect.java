package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForADDirect extends TestSuite {

	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=2;
		reportname="UPA_FullAppOnBoardingADDirectRport";
		browsername="chrome";
	}
	
	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname, String Appname1, String Apptype,String checkbox,String status,String nativeobject,
			String displayattribute,String identityattribute, String groupnativeobject, String groupdisplayattribute, 
			String groupidentityattribute, String accountcorrelation, String AppattributeValue1, String IdAttributeValue1, String AppattributeValue2, 
			String IdAttributeValue2 ,String correlation,String creation,String customization,
			String manager,String entitement, String taskname1, String taskname2) {
		startTest("Application details and configuration of  "+Appname);
		new HomePage(driver, test)                           
		.clickOnApplications()
		.clickOnAppDefinition()
		.enterAppName(Appname)
		.clickOnSearchIcon()
		.clickOnApplication()
		.verifyAppName(Appname1)
//		.verifyTheRevoker(revoker)
//		.verifyTheOwner(owner)
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
		
		if (Appname.equalsIgnoreCase("Active Directory - Wowcorp")){
			
			
			
			int count = UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryWowCorp.length;
			for(int i=0; i<count;i++) {
				if((i%15==0)||(i==count-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryWowCorp[i], "string");
			}
		}
		else if(Appname.equalsIgnoreCase("Active Directory - WoWCorp Privileged")){
			
			
			
				int count1 = UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryWowCorpPrivilleged.length;
				for(int j=0; j<count1;j++) {
					if((j%15==0)||(j==count1-1)) {
						clickByXpath(LocatorObjects.SchemaAccountAttribute+j+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
					new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryWowCorpPrivilleged[j], "string");
				}
		}
		else if(Appname.equalsIgnoreCase("Active Directory - CORP.DIR Forest")){
			
		
				int count2 = UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryCorpDirForest.length;
				for(int k=0; k<count2;k++) {
					if((k%15==0)||(k==count2-1)) {
						clickByXpath(LocatorObjects.SchemaAccountAttribute+k+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
					new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributesActiveDirectoryCorpDirForest[k], "string");
	}
			
		}
		else if(Appname.equalsIgnoreCase("Active Directory - CORP.DIR Privileged")) {
			
			int count3 = UPA_SchemaAttributesObjects.accountAttributesactiveDirectoryCorpDirPrivileged.length;
			for(int l=0; l<count3;l++) {
				if((l%15==0)||(l==count3-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+l+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributesactiveDirectoryCorpDirPrivileged[l], "string");
			}
		}
		
		new SchemaPage(driver, test)
		.verifyGroupNativeObjectType(groupnativeobject)
		.verifyGroupDisplayAttribute(groupdisplayattribute)
		.verifyGroupIdentityAttribute(groupidentityattribute);
		
		
		if (Appname.equalsIgnoreCase("Active Directory - Wowcorp")){
			
			int count = UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryWowCorp.length;
			for(int i=0; i<count;i++) {
				
					if((i%12==0)||(i==count-1)) {
						clickByXpath(LocatorObjects.SchemaRoleAttribute+i+":attrName')]");
						logStatus("pass", "The screenshot of Schema attributes", true);
					}
				new SchemaPage(driver, test).verifyGroupAttribute(UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryWowCorp[i], "string");
			}
			
		}
		else if(Appname.equalsIgnoreCase("Active Directory - WoWCorp Privileged")){
			
			int count1 = UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryWowCorpPrivilleged.length;
			for(int j=0; j<count1;j++) {
				if((j%12==0)||(j==count1-1)) {
					clickByXpath(LocatorObjects.SchemaRoleAttribute+j+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyGroupAttribute(UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryWowCorpPrivilleged[j], "string");
			}
		}
		else if(Appname.equalsIgnoreCase("Active Directory - CORP.DIR Forest")){
			
			int count = UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryCorpDirForest.length;
			for(int k=0; k<count;k++) {
				if((k%12==0)||(k==count-1)) {
					clickByXpath(LocatorObjects.SchemaGroupAttribute+k+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyGroupAttribute(UPA_SchemaAttributesObjects.groupAttributesActiveDirectoryCorpDirForest[k], "string");
			}
		}
		else if(Appname.equalsIgnoreCase("Active Directory - CORP.DIR Privileged")) {
			
			int count = UPA_SchemaAttributesObjects.groupAttributesactiveDirectoryCorpDirPrivileged.length;
			for(int l=0; l<count;l++) {
				if((l%12==0)||(l==count-1)) {
					clickByXpath(LocatorObjects.SchemaGroupAttribute+l+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyGroupAttribute(UPA_SchemaAttributesObjects.groupAttributesactiveDirectoryCorpDirPrivileged[l], "string");
			}
		}
		
		new CorrelationPage(driver, test)
		.clickOnCorrelation()
		.verifyAccountCorrelationForAccountBasedCorrelation(accountcorrelation)
		.verifyAttributeCorrelationValue1(AppattributeValue1, IdAttributeValue1)
		.verifyAttributeCorrelationValue2(AppattributeValue2, IdAttributeValue2)
		.clickOnRuleForADDirect()
		.verifyCorrelationRule(correlation)
		.verifyCreationRule(creation)
		.verifyCustomizationRule(customization)
		.verifyManagerCorrelationRule(manager)
		.verifyEntitlementCustomizationRule(entitement);
//		.clickSetup()
//		.clickOnGroups()
//		.clickOnWorkgroups()
//		.verifyAppOwner(AppOwner)
//		.verifyAppCertifiers(AppCertifier)
//		.verifyAppRevokers(AppRevoker);
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
