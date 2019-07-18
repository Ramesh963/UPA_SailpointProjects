package com.UPA_sailpoint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.object.LocatorObjects;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class CorrelationPage extends BaseTest {
	public CorrelationPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	public CorrelationPage clickOnCorrelation() {
		
			clickByXpath(LocatorObjects.clickOnCorrelation);
		
		return this;
	}
	
	public RulePage verifyAccountCorrelation(String text) {
		if(text.equalsIgnoreCase("NA")) {
			System.out.println("AccountCorrelation is not applicable");
		}else {
			try {
			String actual=	driver.findElementByXPath(LocatorObjects.verifyAccountCorrelation).getAttribute("value");
			System.out.println(actual);
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Account correlation is "+ " '"+actual+"' " +" are matched ", true);
				System.out.println("AccountCorrelation is matched");
			}else {
				logStatus("fail", "The Account correlation is not matched ", true);
				System.out.println("AccountCorrelation is not matched");
			}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found");
			}
		}
	return new RulePage(driver,test);

	
	}
	
	public CorrelationPage verifyAccountCorrelationForAccountBasedCorrelation(String text) {
		try {
			String actual=	driver.findElementByXPath(LocatorObjects.verifyAccountCorrelation).getAttribute("value");
			System.out.println(actual);
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Account correlation is "+ " '"+actual+"' " +" are matched ", true);
				System.out.println("AccountCorrelation is matched");
			}else {
				logStatus("fail", "In Account correlation nothing is Selected ", true);
				System.out.println("AccountCorrelation is not matched");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
			// TODO Auto-generated catch block
//			System.out.println("Element not found");
		}
		return this;

		
		}
	
	public CorrelationPage verifyAttributeCorrelationValue1(String app, String id) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[1]")));
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[1]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[2]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 1 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 1 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 1 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 1 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	public RulePage verifyAttributeCorrelationValue2(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[3]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[4]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 2 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 2 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 2 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 2 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new RulePage(driver, test);
	}
	
	public CorrelationPage verifyAttributeCorrelationValue2ForGoogleApps(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[3]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[4]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 2 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 2 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 2 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 2 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public RulePage verifyAttributeCorrelationValue3(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[5]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[6]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 3 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 3 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 3 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 3 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new RulePage(driver, test);
	}
	
	public CorrelationPage verifyAttributeCorrelationValue3ForSWOW(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[5]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[6]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 3 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 3 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 3 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 3 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public RulePage verifyAttributeCorrelationValue4(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[7]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[8]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 4 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 4 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 4 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 4 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new RulePage(driver, test);
	}
	
	public CorrelationPage verifyAttributeCorrelationValue4ForSAPIDM(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[7]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[8]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 4 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 4 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 4 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 4 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public CorrelationPage verifyAttributeCorrelationValue5(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[9]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[10]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 5 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 5 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 5 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 5 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public RulePage verifyAttributeCorrelationValue6(String app, String id) {
		try {
			String actualApp = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[11]").getText();
			String actualId = driver.findElementByXPath("(//tbody[@id='editForm:dynamicAssignment:tbody_element']/tr/td)[12]").getText();
			
			if(actualApp.equalsIgnoreCase(app)) {
				logStatus("pass", "Application attribute Value 6 '"+actualApp+ "' is matched", false);
				System.out.println(actualApp+" is matched");
			}
			else {
				logStatus("fail", "Application attribute Value 6 '"+actualApp+ "' is not matched", false);
				System.out.println(actualApp+" is not matched");
			}
			
			if(actualId.equalsIgnoreCase(id)) {
				logStatus("pass", "Identity attribute Value 6 '"+actualId+ "' is matched", false);
				System.out.println(actualId+" is matched");
			}
			else {
				logStatus("fail", "Identity attribute Value 6 '"+actualId+ "' is not matched", false);
				System.out.println(actualId+" is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new RulePage(driver, test);
	}
}
