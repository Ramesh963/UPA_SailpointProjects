package com.UPA_sailpoint.ApplicationOnBoarding;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForJDBC extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=1;
		reportname="UPA_FullAppOnBoardingJDBC";
		browsername="chrome";
		
	}

	@Test(dataProvider="fetchdata")
	public void AppInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox,String connectionuser,String databaseurl,String JDBCdriver,String status,
			String nativeobject,String displayattribute,String identityattribute,String groupnativeobject,String groupdisplayattribute,String groupidentityattribute,
			String accountcorrelation,String correlation,String creation,String customization,String manager,String entitement,String AppOwner,String AppRevoker,String appcertifiers) {
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
				.verifyConnectionUser(connectionuser)
				.verifyDataBaseUrl(databaseurl)
				.verifyJDBCdriver(JDBCdriver)
				.clickTheTestConnection()
				.checkTestConnectionStatus(status)
				.clickOnMerging()
				.verifyOnMerging()
				.clickSchema()
				.verifyNativeObjectType(nativeobject)
				.verifyDisplayAttribute(displayattribute)
				.verifyIdentityAttribute(identityattribute);
				if(Appname.equalsIgnoreCase("BWS Online")) {
					String[] attributes= new String[] {"name","Role","shopper_id","email","first_name","last_name","no_offers","date_created",
							"date_last_modified","alert_flag","teammember","isbusinessaccount","isguest","lastsessioniddatetime"};
				
					int count=attributes.length;
				
					for(int i=0;i<count;i++) {
						new SchemaPage(driver, test)
						.verifyAttributeForAccount(attributes[i], "string");
				}
				}else if(Appname.equalsIgnoreCase("CA Capacity Manager")){
					String[] attributes= new String[] {"UserID","UserLevel","Name","Description","Enabled","RoleID","UpdatedOn"};
				
					
						int count=attributes.length;
					
						for(int i=0;i<count;i++) {
							new SchemaPage(driver, test)
							.verifyAttributeForAccount(attributes[i], "string");
					}
				}
				new SchemaPage(driver, test)
				.verifyGroupNativeObjectType(groupnativeobject)
				.verifyGroupDisplayAttribute(groupdisplayattribute)
				.verifyGroupIdentityAttribute(groupidentityattribute);
				if(Appname.equalsIgnoreCase("BWS Online")) {
					String[] attributes= new String[] {"Id","name","description","AccessLevel"};
				
					int count=attributes.length;
				
					for(int i=0;i<count;i++) {
						new SchemaPage(driver, test)
						.verifyGroupAttribute(attributes[i], "string");
				}
				}else if(Appname.equalsIgnoreCase("CA Capacity Manager")) {
					String[] attributes= new String[] {"RoleID","Name","Description","Enabled","UpdatedOn","AccessRightName","Rank"};
					
						int count=attributes.length;
					
						for(int i=0;i<count;i++) {
							new SchemaPage(driver, test)
							.verifyGroupAttribute(attributes[i], "string");
					}
				}
					new CorrelationPage(driver, test)
				
				.clickOnCorrelation()
				.verifyAccountCorrelation(accountcorrelation)
				.clickOnRule()
				.verifyCorrelationRule(correlation)
				.verifyCreationRule(creation)
				.verifyManagerCorrelationRule(manager)
				.verifyCustomizationRule(customization)
				.verifyEntitlementCustomizationRule(entitement)
				.clickSetup()
				.clickOnGroups()
				.clickOnWorkgroups()
				.verifyAppOwner(AppOwner)
				.verifyAppRevokers(AppRevoker)
				.verifyAppCertifiers(appcertifiers);
		
	}
}
