package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForSWOW extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=5;
		reportname="UPA_FullAppOnBoardingServiceWow";
		browsername="chrome";
		
	}
	@Test(dataProvider="fetchdata")
	public void appInfo(String Appname,String Appname1,String revoker,String owner,String Apptype
			,String checkbox,String authentication,String ServiceNowURL,String username,
			String status,String nativeobject,String displayobject,String identityobject,String rolenativeobject,
			String roledisplayobject,String roleidentityobject,String groupnativeobject,String groupdisplayobject,String groupidentityobject,
			String accountcorrelation,String appAttrValue1, String IdAttrValue1,String appAttrValue2, String IdAttrValue2,
			String appAttrValue3, String IdAttrValue3,String appAttrValue4, String IdAttrValue4,String correlation,String creation,
			String customization,String manager,String entitement,String AppOwner,String AppRevoker,
			String taskname1, String taskname2, String taskname3) {
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
		.verifyAuthenticationType(authentication)
		.verifyServiceNowURL(ServiceNowURL)
		.verifyUserNameOnSwow(username)
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
		.clickSchema()
		.verifyNativeObjectType(nativeobject)
		.verifyDisplayAttribute(displayobject)
		.verifyIdentityAttribute(identityobject);
		
		
		int count=UPA_SchemaAttributesObjects.accountAttributeServicewow.length;
		
			for(int i=0;i<count;i++) {
				if((i%15==0)||(i==count-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyAttributeForAccount(UPA_SchemaAttributesObjects.accountAttributeServicewow[i],"string");
			}
			
		new SchemaPage(driver, test)
		.verifyRoleNativeObjectType(rolenativeobject)
		.verifyRoleDisplayAttribute(roledisplayobject)
		.verifyRoleIdentityAttribute(roleidentityobject);
			
		
			int count1=UPA_SchemaAttributesObjects.roleAttributeServicewow.length;
		
			for(int j=0;j<count1;j++) {
				if((j%15==0)||(j==count-1)) {
					clickByXpath(LocatorObjects.SchemaRoleAttribute+j+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test).verifyAttributeForRole(UPA_SchemaAttributesObjects.roleAttributeServicewow[j],"string");
			}
			
		new SchemaPage(driver, test)
		.verifyGroupNativeObjectForSwow(groupnativeobject)
		.verifyGroupDisplayAttributeForSwow(groupdisplayobject)
		.verifyGroupIdentityAttributeForSwow(groupidentityobject);
			
				
					int count2=UPA_SchemaAttributesObjects.groupAttributeServicewow.length;
				
					for(int k=0;k<count2;k++) {
						if((k%15==0)||(k==count-1)) {
							clickByXpath(LocatorObjects.SchemaGroupAttribute+k+":attrName')]");
							logStatus("pass", "The screenshot of Schema attributes", true);
						}
						new SchemaPage(driver, test).verifyGroupAttributeForSwow(UPA_SchemaAttributesObjects.groupAttributeServicewow[k],"string");
					}
		
		new CorrelationPage(driver, test)
		.clickOnCorrelation()			
		.verifyAccountCorrelationForAccountBasedCorrelation(accountcorrelation)
		.verifyAttributeCorrelationValue1(appAttrValue1, IdAttrValue1)
		.verifyAttributeCorrelationValue2ForGoogleApps(appAttrValue2, IdAttrValue2)
		.verifyAttributeCorrelationValue3ForSWOW(appAttrValue3, IdAttrValue3)
		.verifyAttributeCorrelationValue4(appAttrValue4, IdAttrValue4)
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
