package com.UPA_sailpoint.pages;





import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.object.LocatorObjects;
import com.relevantcodes.extentreports.ExtentTest;

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnField;
import wrappers.BaseTest;

public class AppDetailsPage extends BaseTest{
	public AppDetailsPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	public AppDetailsPage verifyAppName(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.XpathforAppName).getAttribute("value");
			if(text.equalsIgnoreCase(actual)) {
				logStatus("pass", "Application name is"+ " '"+actual+"' " +" are matched", false);
			}else {
				logStatus("fail", "Application name is"+ " '"+actual+"' " +" are not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
			logStatus("fail", "Application name not found ", true);
		}
			
		return this;
	}
	public AppDetailsPage verifyTheRevoker(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.XpathforRevoker).getAttribute("value");
			if(text.equalsIgnoreCase(actual)) {
				logStatus("pass", "Revoker name is"+ " '"+actual+"' " +" are matched", false);
			}else {
				logStatus("fail", "Revoker name is"+ " '"+actual+"' " +" are not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppDetailsPage verifyTheOwner(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.XpathforTheOwner).getAttribute("value");
			if(text.equalsIgnoreCase(actual)) {
				logStatus("pass", "Owner name is"+ " '"+actual+"' " +" are matched", false);
			}else {
				logStatus("fail", "Owner name is"+ " '"+actual+"' " +" are not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppDetailsPage verifyTheAppType(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.XpathforAppType).getText();
			if(text.equalsIgnoreCase(actual)) {
				logStatus("pass", "Application Type is"+ " '"+actual+"' " +" are matched", false);
			}else {
				logStatus("fail", "application type is"+ " '"+actual+"' " +" are not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppConfigurationPage checkForAuthoritative(String checkbox) {
		try {
			boolean obj=driver.findElementByXPath(LocatorObjects.XpathforAuthorization).isSelected();
			
			if((obj==true) && (checkbox=="TRUE")){
				logStatus("pass", "Its an Authoritative Application", true);
				System.out.println(" authoritative");
			}else if((obj==false) && (checkbox=="FALSE")){
				logStatus("pass", "Its a non Authoritative Application", true);
				System.out.println(" non authoritative");
			}else {
				logStatus("fail", "Authoritative checkbox mismatched", true);
				System.out.println("Authoritative checkbox mismatched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new AppConfigurationPage(driver, test);
	}
	public AppDetailsPage getDescription() {
		
		
		try {
			driver.switchTo().frame("appDescriptionHTMLCmp-iframeEl");
			String status=driver.findElementByXPath(LocatorObjects.getDescription).getText();
			logStatus("pass", "description of application is :"+status, false);
			System.out.println(status);
			driver.switchTo().parentFrame();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage verifyAppNameForTestConnection(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.XpathforAppName).getAttribute("value");
			if(text.equalsIgnoreCase(actual)) {
				logStatus("pass", "Application name is"+ " '"+actual+"' " +" are matched", false);
			}else {
				logStatus("fail", "Application name is"+ " '"+actual+"' " +" are not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
			
		return new AppConfigurationPage(driver, test);
	}
}