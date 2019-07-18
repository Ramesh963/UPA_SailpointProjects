package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.*;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingorLdap extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=7;
		reportname="UPA_FullAppOnBoardingLdap";
		browsername="chrome";
		
	}

	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox,String Auth,String User1,
			String Host1,String Port1,String status,String nativeobject,String displayattribute,String identityattribute,
			String privilegenative, String privilegedisplay, String privilegeidentity, String groupnative, String groupdisplay, 
			String groupidentity, String accountcorrelation, String appAttrValue1, String IdAttrValue1,String appAttrValue2, String IdAttrValue2,
			String appAttrValue3, String IdAttrValue3,String appAttrValue4, String IdAttrValue4, String appAttrValue5, String IdAttrValue5,
			String appAttrValue6, String IdAttrValue6, String correlation,String creation,String customization,String manager,
			String entitement,String taskname1,String taskname2,String taskname3) {
		
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
		.verifyAuth(Auth)
        .verifyUser1(User1)
        .verifyHost1(Host1)
        .verifyPort1(Port1)
        //.verifyPage1(Pagesize1)
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
		.verifyNativeObjectType(nativeobject)
		.verifyDisplayAttribute(displayattribute)
		.verifyIdentityAttribute(identityattribute);
		
		if(Appname.equalsIgnoreCase("SAP IDM")) {
			
			int count=UPA_SchemaAttributesObjects.accountAttributesSAP_IDM.length;
		
			for(int i=0;i<count;i++) {
				if((i%15==0)||(i==count-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttribute(UPA_SchemaAttributesObjects.accountAttributesSAP_IDM[i], "string");
			}
			
		new SchemaPage(driver, test)
		.verifyPrivilegeNativeObjectType(privilegenative)
		.verifyPrivilegeDisplayAttribute(privilegedisplay)
		.verifyPrivilegeIdentityAttribute(privilegeidentity);
		
		int count1=UPA_SchemaAttributesObjects.privillegeAttributesSAP_IDM.length;
		
			for(int j=0;j<count1;j++) {
				if((j%10==0)||(j==count-1)) {
					clickByXpath(LocatorObjects.SchemaRoleAttribute+j+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttributeForRole(UPA_SchemaAttributesObjects.groupAttributesSAP_IDM[j], "string");
			}
		
			new SchemaPage(driver, test)
			.verifyGroupNativeObjectForSwow(groupnative)
			.verifyGroupDisplayAttributeForSwow(groupdisplay)
			.verifyGroupIdentityAttributeForSwow(groupidentity);
			
			int count2=UPA_SchemaAttributesObjects.privillegeAttributesSAP_IDM.length;
			
			for(int k=0;k<count2;k++) {
				if((k%12==0)||(k==count-1)) {
					clickByXpath(LocatorObjects.SchemaGroupAttribute+k+":attrName')]");
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyGroupAttributeForSwow(UPA_SchemaAttributesObjects.groupAttributesSAP_IDM[k], "string");
			}
			
		}
		
		new CorrelationPage(driver, test)
		.clickOnCorrelation()
		.verifyAccountCorrelationForAccountBasedCorrelation(accountcorrelation)
		.verifyAttributeCorrelationValue1(appAttrValue1, IdAttrValue1)
		.verifyAttributeCorrelationValue2ForGoogleApps(appAttrValue2, IdAttrValue2)
		.verifyAttributeCorrelationValue3ForSWOW(appAttrValue3, IdAttrValue3)
		.verifyAttributeCorrelationValue4ForSAPIDM(appAttrValue4, IdAttrValue4)
		.verifyAttributeCorrelationValue5(appAttrValue5, IdAttrValue5)
		.verifyAttributeCorrelationValue6(appAttrValue6, IdAttrValue6)
		.clickOnRule()
		.verifyCorrelationRule(correlation)
		.verifyCreationRule(creation)
		.verifyCustomizationRule(customization)
		.verifyManagerCorrelationRule(manager)
		.verifyEntitlementCustomizationRule(entitement)
		.clickSetup()
		.clickOnGroups()
		.clickOnWorkgroups();
		/*.verifyAppOwner(AppOwner)
		.verifyAppRevokers(AppRevoker);*/
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
