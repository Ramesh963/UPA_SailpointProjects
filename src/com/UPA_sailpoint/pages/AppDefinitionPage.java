package com.UPA_sailpoint.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.object.LocatorObjects;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class AppDefinitionPage extends BaseTest {
	public AppDefinitionPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	public AppDefinitionPage enterAppName(String data) {
		EnterDataByXpath(LocatorObjects.enterAppName, data);
		return this;
	}
	public AppDefinitionPage clickOnSearchIcon() {
		clickByXpath(LocatorObjects.clickOnSearchIcon);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppDetailsPage clickOnApplication() {
		clickByXpath(LocatorObjects.clickOnApplication);
		return new AppDetailsPage(driver, test);
	}
	
}
