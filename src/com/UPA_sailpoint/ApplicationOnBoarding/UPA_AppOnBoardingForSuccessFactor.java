package com.UPA_sailpoint.ApplicationOnBoarding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.UPA_sailpoint.pages.CorrelationPage;
import com.UPA_sailpoint.pages.HomePage;
import com.UPA_sailpoint.pages.SchemaPage;
import com.object.LocatorObjects;
import com.object.UPA_SchemaAttributesObjects;

import wrappers.TestSuite;

public class UPA_AppOnBoardingForSuccessFactor extends TestSuite {
	@BeforeSuite
	public void beforeClass() {
		testdatasheetname="UPA_SailpointAllAppOnboarding";
		sheetnum=6;
		reportname="UPA_FullAppOnBoardingSuccessFactor";
		browsername="chrome";
		
	}
	@Test(dataProvider="fetchdata")
	public void appInfo(String Appname,String Appname1,String revoker,String owner,String Apptype,String checkbox,
			String serviceURL,String username,String Accountentity,String customfilter, String metadataList,String pagesize, String status,
			String nativeobject,String identityattribute,String accountcorrelation, String AppAttributeValue1, String IdAttributeValue1, 
			String AppAttributeValue2, String IdAttributeValue2, String correlation,
			String creation,String manager,String customization,String entitement,String AppOwner,String AppRevoker,
			String taskname1) {
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
		.verifyServiceURL(serviceURL)
		.verifyUserName(username)
		.verifyAccountEntity(Accountentity)
		.verifyCustomFilter(customfilter)
		.verifyMetadataList(metadataList)
		.verifyAccountPageSize(pagesize)
		.clickTheTestConnection()
		.checkTestConnectionStatusAll(status)
		.clickSchema()
		.verifyNativeObjectType(nativeobject)
		.verifyIdentityAttribute(identityattribute);
		
		
			int count=UPA_SchemaAttributesObjects.accountAttributeSucessfactor.length;
			
//			driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[1]").sendKeys(Keys.PAGE_DOWN);
//			logStatus("pass", "The screenshot of Schema attributes", true); 
//			driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[1]").sendKeys(Keys.PAGE_DOWN);
//			logStatus("pass", "The screenshot of Schema attributes", true); 
			
			for(int i=0;i<count;i++) {
			 
				if((i%15==0)||(i==count-1)) {
					clickByXpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]");
					WebDriverWait wait=new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocatorObjects.SchemaAccountAttribute+i+":attrName')]")));
					logStatus("pass", "The screenshot of Schema attributes", true);
				}
				new SchemaPage(driver, test)
				.verifyAttribute(UPA_SchemaAttributesObjects.accountAttributeSucessfactor[i], "string");			
				
		}
			
		new CorrelationPage(driver, test)	
		.clickOnCorrelation()
		.verifyAccountCorrelationForAccountBasedCorrelation(accountcorrelation)
		.verifyAttributeCorrelationValue1(AppAttributeValue1, IdAttributeValue1)
		.verifyAttributeCorrelationValue2(AppAttributeValue2, IdAttributeValue2)
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
		.verifyAppRevokers(AppRevoker);
		driver.navigate().refresh();
		
		
		new HomePage(driver, test)
		.clickSetup()
		.clickOnTasks()
		.enterTaskName(taskname1)
		.verifyTheTaskname(taskname1)
		.clickOnTaskResults()
		.enterResultName(taskname1)
		.verifyResults(taskname1)
		.getStartDate()
		.getCompletedDate()
		.clickOnReturnToTask();
		
		
		
	}
}
