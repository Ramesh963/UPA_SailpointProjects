package com.UPA_sailpoint.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.object.LocatorObjects;
import com.relevantcodes.extentreports.ExtentTest;


import wrappers.BaseTest;

public class HomePage extends BaseTest{
	public HomePage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	
	public HomePage clickOnApplications() {
		clickByXpath(LocatorObjects.clickOnApplications);
		return this;
		}
	public AppDefinitionPage clickOnAppDefinition() {
		clickByXpath(LocatorObjects.clickOnAppDefinition);
		return new AppDefinitionPage(driver, test);
	}
	public HomePage clickSetup() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		try {
			driver.findElementByXPath(LocatorObjects.clickOnsetup).sendKeys(Keys.F5);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		clickByXpath(LocatorObjects.clickOnsetup);
		return this;
	}
	public GroupConfigPage clickOnGroups() {
		clickByXpath(LocatorObjects.clickOnGroups);
		return new GroupConfigPage(driver, test);
	}
	public TasksPage clickOnTasks() {
		clickByXpath(LocatorObjects.clickOnTasks);
		return new TasksPage(driver, test);
	
	
	}

}
