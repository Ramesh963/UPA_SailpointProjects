package com.UPA_sailpoint.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class RulePage extends BaseTest {
	public RulePage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
}
	public RulePage clickOnRule() {
		clickByXpath("//*[@id='tab-1135']");
		return this;
	}
	
	public RulePage clickOnRuleForADDirect() {
		clickByXpath("//*[@id='tab-1136']");
		return this;
	}
	
	public RulePage verifyCorrelationRule(String text) {
		logStatus("pass", "Aggregation Rules of this Application", true);
		try {
			String actual=driver.findElementByXPath("//*[@name='editForm:correlationRule']").getAttribute("value");
			if(text.equalsIgnoreCase("NA")) {
				if(actual.equalsIgnoreCase("")) {
					logStatus("pass", "Correlation rule is not applicable for this application", false);
					System.out.println("Correlation rule is not applicable for this application");
				}
				else {
					logStatus("fail", "Value mismatches, Correlation rule is not applicable for this application", false);
					System.out.println("Value mismatches, Correlation Rule is not applicable for this application");
				}
				
				
			}else {
				
				if(actual.equalsIgnoreCase(text)) {
					logStatus("pass", "Correlation rule is "+ " '"+actual+"' " +" are matched ", false);
					System.out.println("Correlation Rule is matched"+" '"+actual+"' ");
				}
				else {
					logStatus("fail", "Correlation rule is not matched ", true);
					System.out.println("Correlation Rule is not matched"+" '"+actual+"' ");
				}
			}
		} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	public RulePage verifyCreationRule(String text) {
		try {
			String actual=driver.findElementByXPath("//*[@name='editForm:creationRule']").getAttribute("value");
			if(text.equalsIgnoreCase("NA")) {
				if(actual.equalsIgnoreCase("")) {
					logStatus("pass", "Creation rule is not applicable for this application", false);
					System.out.println("Creation rule is not applicable for this application");
				}
				else {
					logStatus("fail", "Value mismatches, Creation rule is not applicable for this application", false);
					System.out.println("Value mismatches, Creation Rule is not applicable for this application");
				}
				
			}else {
				
				if(actual.equalsIgnoreCase(text)) {
					logStatus("pass", "Creation rule is "+ " '"+actual+"' " +" are matched ",false);
					System.out.println("Creation Rule is matched"+" '"+actual+"' ");
				}
				else {
					logStatus("fail", "Creation rule is not matched ", true);
					System.out.println("Creation Rule is not matched"+" '"+actual+"' ");
				}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public RulePage verifyManagerCorrelationRule(String text) {
		try {
			String actual=driver.findElementByXPath("//*[@name='editForm:managerCorrelationRule']").getAttribute("value");
			if(text.equalsIgnoreCase("NA")) {
				if(actual.equalsIgnoreCase("")) {
					logStatus("pass", "Manager Correlation rule is not applicable for this application", false);
					System.out.println("Manager Correlation rule is not applicable for this application");
				}
				else {
					logStatus("fail", "Value mismatches, Manager Correlation rule is not applicable for this application", false);
					System.out.println("Value mismatches, Manager Correlation Rule is not applicable for this application");
				}
				
			}else {
				
				System.out.println("value ="+actual);
				if(actual.equalsIgnoreCase(text)) {
					logStatus("pass", "Manager Correlation rule is "+ " '"+actual+"' " +" are matched ",false);
					System.out.println("Manager Correlation Rule is matched"+" '"+actual+"' ");
				}
				else {
					logStatus("fail", "Manager Correlation rule is not matched ", false);
					System.out.println("Manager Correlation Rule is not matched"+" '"+actual+"' ");
				}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public RulePage verifyCustomizationRule(String text) {
		
		try {
			String actual=driver.findElementByXPath("//*[@name='editForm:CustomizationRule']").getAttribute("value");
			if(text.equalsIgnoreCase("NA")) {
				if(actual.equalsIgnoreCase("")) {
					logStatus("pass", "Customization rule is not applicable for this application", false);
					System.out.println("Customization rule is not applicable for this application");
				}
				else {
					logStatus("fail", "Value mismatches, Customization rule is not applicable for this application", false);
					System.out.println("Value mismatches, Customization Rule is not applicable for this application");
				}
				
			}else {
				
				if(actual.equalsIgnoreCase(text)) {
					logStatus("pass", "Customization rule is "+ " '"+actual+"' " +" are matched ",false);
					System.out.println("Customization Rule is matched"+" '"+actual+"' ");
				}
				else {
					logStatus("fail", "Customization rule is not matched ", false);
					System.out.println("Customization Rule is not matched"+" '"+actual+"' ");
				}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public HomePage verifyEntitlementCustomizationRule(String text) {
		
		try {
			String actual=driver.findElementByXPath("//*[@name='editForm:ManagedAttributeCustomizationRule']").getAttribute("value");
			if(text.equalsIgnoreCase("NA")) {
				if(actual.equalsIgnoreCase("")) {
					logStatus("pass", "Managed Entitlement customization rule is not applicable for this application", false);
					System.out.println("Managed Entitlement customization rule is not applicable for this application");
				}
				else {
					logStatus("fail", "Value mismatches, Managed Entitlement customization rule is not applicable for this application", false);
					System.out.println("Value mismatches, Managed Entitlement customization Rule is not applicable for this application");
				}
				
			}else {
				
				if(actual.equalsIgnoreCase(text)) {
					logStatus("pass", "Managed Entitlement customization rule is "+ " '"+actual+"' " +" are matched ",false);
					System.out.println("Managed Entitlement customization Rule is matched"+" '"+actual+"' ");
				}
				else {
					logStatus("fail", "Managed Entitlement customization rule is not matched ", false);
					System.out.println("Managed Entitlement customization Rule is not matched"+" '"+actual+"' ");
				}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new HomePage(driver, test);
	}
}