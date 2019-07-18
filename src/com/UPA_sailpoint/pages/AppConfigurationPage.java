package com.UPA_sailpoint.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.object.LocatorObjects;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.BaseTest;

public class AppConfigurationPage extends BaseTest {
	public AppConfigurationPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	public AppConfigurationPage clickOnConfiguration() {
		
		clickByXpath(LocatorObjects.clickOnConfiguration);
		System.out.println("clicked config");
		
		return this;
	}
	
	public AppConfigurationPage verifyTheFilePath(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 40);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocatorObjects.XpathforFilePath)));
			String actual=driver.findElementByXPath(LocatorObjects.XpathforFilePath).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The file path of Application is "+" '"+actual+"' "+" matched correctly", true);
				System.out.println("file path verified");
			}else {
				logStatus("fail", "The file path of Application is "+" '"+actual+"' "+" not matched", true);
				System.out.println("file path not verified");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		
		return this;
	}
	public AppConfigurationPage checkForParsingType(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocatorObjects.XpathForParsingTypeIcon)));
			boolean obj=driver.findElementByXPath(LocatorObjects.XpathForParsingTypeIcon).isSelected();
			if(obj==true) {
				String Type=driver.findElementByXPath(LocatorObjects.XpathForParsingType).getText();
				System.out.println("Parsing type is checked on"+" '"+Type+"' ");
				if(Type.equalsIgnoreCase(text)) {
					logStatus("pass", "Parsing type is checked on "+" '"+Type+"' "+ "and matched correctly", false);
			}else {
				logStatus("fail", "Parsing type is"+" '"+Type+"' "+ "not matched ", false);
			}
						}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppConfigurationPage getDelimiterValue(String text) {
		try {
			String value=driver.findElementByXPath(LocatorObjects.getDelimiterValue).getAttribute("value");
			if(value.equalsIgnoreCase(text)) {
				logStatus("pass", "The value of Delimiter is = "+" '"+value+"' matched", false);
				System.out.println("Delimiter="+" '"+value+"' ");
			}
			else {
				logStatus("fail", "The value of Delimiter is =  "+" '"+value+"' not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	public AppConfigurationPage fileTrasport(String text) {
		try {
			boolean obj=driver.findElementByXPath(LocatorObjects.fileTrasport).isSelected();
			if(obj==true) {
				String Type=driver.findElementByXPath(LocatorObjects.fileTrasportvalue).getText();
				System.out.println("File Transport is checked on"+" '"+Type+"' ");
				if(Type.equalsIgnoreCase(text)) {
					logStatus("pass", "File Transport is checked on "+" '"+Type+"' "+ "and matched correctly", false);
			}else {
				logStatus("fail", "File Transport is"+" '"+Type+"' "+ "not matched ", false);
			}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage getNumberOfLinesToSkip(String text) {
		if (text.equalsIgnoreCase("NA")) {
			System.out.println("No of lines to skip is Not Applicable");
		}else {
			try {
				clickByXpath(LocatorObjects.Filterbutton);
				String value=driver.findElementByXPath(LocatorObjects.numberOfLinesToskip).getAttribute("value");
				if(value.equalsIgnoreCase(text)) {
					logStatus("pass", "The value of Number Of Lines To Skip is = "+" '"+value+"' matched", false);
					System.out.println("Number Of Lines To Skip="+" '"+value+"' ");
				}
				else {
					logStatus("fail", "The value of Number Of Lines To Skip is =  "+" '"+value+"' not matched", false);
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found");
			}
		}
		
		return this;
	}
	public AppConfigurationPage checkForFilterEmpty(String checkbox) {
		try {
			boolean obj=driver.findElementByXPath(LocatorObjects.FilterEmpty).isSelected();
			if(obj==true && checkbox=="TRUE"){
				logStatus("pass", "Data matches, FilterEmpty is checked", true);
				System.out.println("FilterEmpty Data matches");
			}else if(obj==false && checkbox=="FALSE"){
				logStatus("pass", "Data matches, FilterEmpty is not checked", true);
				System.out.println("FilterEmpty Data matches");
			}else {
				logStatus("fail", "Filter Empty checkbox mismatched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public AppConfigurationPage clickTheTestConnection() {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.clickTheTestConnection)));
		} catch (NoSuchElementException e1) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}catch (TimeoutException e) {
			System.out.println("Element not found");
		}
		
		clickByXpath(LocatorObjects.clickTheTestConnection);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public AppConfigurationPage checkTestConnectionStatus(String text) {
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.XpathForTestConnectionStatus)));
			String status=driver.findElementByXPath(LocatorObjects.XpathForTestConnectionStatus).getText();
			if(status.equalsIgnoreCase(text)) {
				logStatus("pass", "Test connection status is successful"+"   '"+status+"' ", true);
			}else {
				logStatus("fail", "Test connection is failure the error message is"+"  '"+status+"' ", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage checkTestConnectionStatusAll(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.XpathForTestConnectionStatus)));
			String status=driver.findElementByXPath(LocatorObjects.XpathForTestConnectionStatus).getText();
			if(status.equalsIgnoreCase(text)) {
				logStatus("pass", "Test connection status is successful"+"   '"+status+"' ", true);
			}else {
				logStatus("fail", "Test connection is failure the error message is"+"  '"+status+"' ", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		catch (TimeoutException e) {
			System.out.println("Element not found");
		}
		return new SchemaPage (driver, test);
	}
	
	public AppConfigurationPage clickOnMerging() {
		clickByXpath(LocatorObjects.clickOnMerging);
		return this;
	}
	public SchemaPage verifyOnMerging() {
		try {
			boolean obj=driver.findElementByXPath(LocatorObjects.verifyOnMerging).isSelected();
			if(obj==true) {
				logStatus("pass", "Data needs to be merged checkbox  'clicked'  successfully", true);
				
			}if(obj==false) {
				logStatus("pass", "Data needs to be merged checkbox 'not clicked' ", true);
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new SchemaPage(driver, test);
		
	}
	public AppConfigurationPage verifyConnectionUser(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.XpathForConnectionUser)));
			
			String actual=driver.findElementByXPath(LocatorObjects.XpathForConnectionUser).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	public AppConfigurationPage verifyDataBaseUrl(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.XpathForDataBaseUrl)));
			String actual=driver.findElementByXPath(LocatorObjects.XpathForDataBaseUrl).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The DataBase URL is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The DataBase URL is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	public AppConfigurationPage verifyJDBCdriver(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.XpathForJDBCdriver)));
			String actual=driver.findElementByXPath(LocatorObjects.XpathForJDBCdriver).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The JDBC driver is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The JDBC driver is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
	
		return this;
	}
	public AppConfigurationPage verifyServiceURL(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyServiceURL).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The ServiceURL is"+"   '"+actual+"' "+"is matched", false);
			}else {
				logStatus("fail", "The ServiceURL is"+"  '"+actual+"' "+"not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyUserName(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyUserName).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Username is"+"   '"+actual+"' "+"is matched", false);
			}else {
				logStatus("fail", "The Username is"+"  '"+actual+"' "+"not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyAccountEntity(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyAccountEntity).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The AccountEntity is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The AccountEntity is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyCustomFilter(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyCustomFilter).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The CustomFilter is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The CustomFilter is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyMetadataList(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyMetadataList).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The MetadataList is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The MetadataList is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyAccountPageSize(String text) {
		try {
			String actual = driver.findElementByXPath("//*[@id='editForm:accountPageSize']").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Account Page size is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The Account Page size is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	public AppConfigurationPage verifyAuthenticationType(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyAuthenticationType).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The AuthenticationType is"+"   '"+actual+"' "+"is matched", false);
			}else {
				logStatus("fail", "The AuthenticationType is"+"  '"+actual+"' "+"not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyServiceNowURL(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyServiceNowURL).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The ServiceNowURL is"+"   '"+actual+"' "+"is matched", false);
			}else {
				logStatus("fail", "The ServiceNowURL is"+"  '"+actual+"' "+"not matched", false);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public AppConfigurationPage verifyUserNameOnSwow(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyUserNameOnSwow).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Username is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The Username is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage verifyClientID_GoogleApps(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyClientID_GoogleApps).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Client ID is"+"   '"+actual+"' "+"is matched", true);
				System.out.println("The Client ID is"+"   '"+actual+"' "+"is matched");
			}else {
				logStatus("fail", "The Client ID is"+"  '"+actual+"' "+"not matched", true);
				System.out.println("The Client ID is"+"   '"+actual+"' "+" not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage verifyClientSecret_GoogleApps(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyClientSecret_GoogleApps).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Client Secret is"+"   '"+actual+"' "+"is matched", true);
				System.out.println("The Client Secret is"+"   '"+actual+"' "+"is matched");
			}else {
				logStatus("fail", "The Client Secret is"+"  '"+actual+"' "+"not matched", true);
				System.out.println("The Client Secret is"+"   '"+actual+"' "+" not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage verifyPageSize_GoogleApps(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyPageSize_GoogleApps).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The PageSize is"+"   '"+actual+"' "+"is matched", true);
				System.out.println("The PageSize is"+"   '"+actual+"' "+"is matched");
			}else {
				logStatus("fail", "The PageSize is"+"  '"+actual+"' "+"not matched", true);
				System.out.println("The PageSize is"+"   '"+actual+"' "+"not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public AppConfigurationPage verifyReadGroupDetails_GoogleApps(String text) {
		try {
			String actual=driver.findElementByXPath(LocatorObjects.verifyReadGroupDetails_GoogleApps).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The ReadGroupDetails is"+"   '"+actual+"' "+"is matched", true);
				System.out.println("The ReadGroupDetails is"+"   '"+actual+"' "+"is matched");
			}else {
				logStatus("fail", "The ReadGroupDetails is"+"  '"+actual+"' "+"not matched", true);
				System.out.println("The ReadGroupDetails is"+"   '"+actual+"' "+"not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	

	public AppConfigurationPage verifyAuth(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.verifyAuth)));
			
			String actual=driver.findElementByXPath(LocatorObjects.verifyAuth).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	public AppConfigurationPage verifyHost(String text) {
		try {
			String actual=driver.findElementByXPath("(//input[contains(@name,'editForm:j_idt') and @type='text'])[1]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The host is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The host is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public AppConfigurationPage verifyPort(String text) {
		try {
			String actual=driver.findElementByXPath("(//input[contains(@name,'editForm:j_idt') and @type='text'])[2]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The Port is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The Port is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;

	}
	
	public AppConfigurationPage verifyUser1(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.verifyUser1)));
			
			String actual=driver.findElementByXPath(LocatorObjects.verifyUser1).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	public AppConfigurationPage verifyHost1(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.verifyHost1)));
			
			String actual=driver.findElementByXPath(LocatorObjects.verifyHost1).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	public AppConfigurationPage verifyPort1(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.verifyPort1)));
			
			String actual=driver.findElementByXPath(LocatorObjects.verifyPort1).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	public AppConfigurationPage verifyPage1(String text) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LocatorObjects.verifyPage1)));
			
			String actual=driver.findElementByXPath(LocatorObjects.verifyPage1).getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "The connection user is"+"   '"+actual+"' "+"is matched", true);
			}else {
				logStatus("fail", "The connetion user is"+"  '"+actual+"' "+"not matched", true);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		
		return this;
	}
	
	
	
	
}