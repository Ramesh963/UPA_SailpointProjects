package com.UPA_sailpoint.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class SchemaPage extends BaseTest {
	public SchemaPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}

	public SchemaPage clickSchema() {
		clickByXpath("//*[@id='tab-1083-btnEl']");
		return this;
	}
	
	public SchemaPage verifyNativeObjectType(String text) {
		
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[1]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Native Object Type is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("native object value is matched");
			}else {
				logStatus("fail", "Native Object Type is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("native object value is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage verifyDisplayAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[3]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "DisplayAttribute is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("display attribute is matched");
			}else {
				logStatus("fail", "DisplayAttribute is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("display attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage verifyIdentityAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[2]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "IdentityAttribute is"+ " '"+actual+"' " +" are matched", true);
				System.out.println("Identity Attribute is matched");
			}else {
				logStatus("fail", "IdentityAttribute is"+ " '"+actual+"' " +" are not matched", true);
				System.out.println("Identity Attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	
	
	public CorrelationPage  verifyAttribute(String text,String type) {
		WebElement togetrow=driver.findElementByXPath("//table[@style='table-layout:fixed']/tbody");
		java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
		int count=totalrow.size();
		int count2=0;
		//System.out.println(count);
		for(int i=0;i<=count-2;i++) {
			String attribute=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':0:schemaAttrTbl:"+i+":attrName')]").getAttribute("value");
		String actual=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':0:schemaAttrTbl:"+i+":attributeType')]").getAttribute("value");
		if(attribute.equalsIgnoreCase(text)) {
			if(actual.equalsIgnoreCase(type)) {
				logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				System.out.println(attribute+" Type is "+" '"+type +"' "+" matched");
				}else if(actual.equalsIgnoreCase("group")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}else if(actual.equalsIgnoreCase("boolean")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}
				else if(actual.equalsIgnoreCase("role")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}
			else {
					System.out.println(attribute+" matched but Type is "+" '"+actual +"' "+" not matched");
					logStatus("fail", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" not matched ", false);
				}
			break;
			}
		else {
			count2=count2+1;
			if(count2==count-1) {
				
				System.out.println(text+" Type is "+" '"+type +"' "+" not matched");
				logStatus("fail", "The "+ " '"+text+"' " +" atrribute type is"+ " '"+type+"' " +" not matched ", false);
				
			}
		}
		
		}
		return new CorrelationPage(driver,test);
		
	}
	
	public SchemaPage  verifyAttributeForAccount(String text,String type) {
		try {
			WebElement togetrow=driver.findElementByXPath("//table[@style='table-layout:fixed']/tbody");
			java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
			int count=totalrow.size();
			int count2=0;
			//System.out.println(count);
			for(int i=0;i<=count-2;i++) {
				String attribute=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':0:schemaAttrTbl:"+i+":attrName')]").getAttribute("value");
			String actual=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':0:schemaAttrTbl:"+i+":attributeType')]").getAttribute("value");
			if(attribute.equalsIgnoreCase(text)) {
				if(actual.equalsIgnoreCase(type)) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					System.out.println(attribute+" Type is "+" '"+type +"' "+" matched");
					}else if(actual.equalsIgnoreCase("group")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("boolean")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("role")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}
				else {
						System.out.println(attribute+" matched but Type is "+" '"+actual +"' "+" not matched");
						logStatus("fail", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" not matched ", false);
					}
				break;
				}
			else {
				count2=count2+1;
				if(count2==count-1) {
					
					System.out.println(text+" Type is "+" '"+type +"' "+" not matched");
					logStatus("fail", "The "+ " '"+text+"' " +" atrribute type is"+ " '"+type+"' " +" not matched ", false);
					
				}
			}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage  verifyAttributeADDirect() {
		try {
			WebElement togetrow=driver.findElementByXPath("//table[@style='table-layout:fixed']/tbody");
			java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
			int count=totalrow.size();
			//System.out.println(count);
			for(int i=0;i<=count-2;i++) {
				String attribute=driver.findElementByXPath("//*[@name='editForm:j_idt509:0:schemaAttrTbl:"+i+":attrName']").getAttribute("value");
			String actual=driver.findElementByXPath("//*[@name='editForm:j_idt509:0:schemaAttrTbl:"+i+":attributeType']").getAttribute("value");
			logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' ", false);
			System.out.println(attribute+" Type is "+" '"+actual+"' ");
//		if(actual.equalsIgnoreCase(text)) {
//			logStatus("pass", "The "+ " '"+attribute+"' " +" attribute type is"+ " '"+actual+"' " +" matched successfully", false);
//			System.out.println(attribute+" Type is "+" '"+text +"' "+" matched");
//		}else {
//			logStatus("fail", "The "+ " '"+attribute+"' " +" attribute type is"+ " '"+actual+"' " +" not matched ", false);
//			System.out.println(attribute+" Type is "+" '"+text +"' "+" not matched");
//		}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	public SchemaPage verifyGroupNativeObjectType(String text) {
		
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]").getAttribute("value");
			clickByXpath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group Native Object Type is"+ " '"+actual+"' " +" are matched", false);
				System.out.println(" Group native object value is matched");
			}else {
				logStatus("fail", "Group Native Object Type is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Group native object value is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage verifyGroupDisplayAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[7]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group DisplayAttribute is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("Group display attribute is matched");
			}else {
				logStatus("fail", "Group DisplayAttribute is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Group display attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage verifyGroupIdentityAttribute(String text) {
		try {
			clickByXpath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[6]");
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[6]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group IdentityAttribute is"+ " '"+actual+"' " +" are matched", true);
				System.out.println("Group Identity Attribute is matched");
			}else {
				logStatus("fail", "Group IdentityAttribute is"+ " '"+actual+"' " +" are not matched", true);
				System.out.println("Group Identity Attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	

	
	public CorrelationPage  verifyGroupAttribute(String text, String type) {
		try {
			WebElement togetrow=driver.findElementByXPath("(//table[@style='table-layout:fixed']/tbody)[2]");
			java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
			int count=totalrow.size();
			int count2=0;
			//System.out.println(count);
			for(int i=0;i<=count-2;i++) {
				String attribute=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':1:schemaAttrTbl:"+i+":attrName')]").getAttribute("value");
			String actual=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':1:schemaAttrTbl:"+i+":attributeType')]").getAttribute("value");
			if(attribute.equalsIgnoreCase(text)) {
				if(actual.equalsIgnoreCase(type)) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					System.out.println(attribute+" Type is "+" '"+type +"' "+" matched");
					}
				else if(actual.equalsIgnoreCase("group")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}else if(actual.equalsIgnoreCase("boolean")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}else if(actual.equalsIgnoreCase("role")) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
				}
				else {
						System.out.println(attribute+" matched but Type is "+" '"+actual +"' "+" not matched");
						logStatus("fail", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" not matched ", false);
					}
				break;
				}
			else {
				count2=count2+1;
				if(count2==count-1) {
					
					System.out.println(text+" Type is "+" '"+type +"' "+" not matched");
					logStatus("fail", "The "+ " '"+text+"' " +" atrribute type is"+ " '"+type+"' " +" not matched ", false);
					
				}
			}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new CorrelationPage(driver,test);
		
	}
	public SchemaPage verifyRoleNativeObjectType(String text) {
		
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]").getAttribute("value");
			clickByXpath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Role Native Object Type is"+ " '"+actual+"' " +" are matched", false);
				System.out.println(" Role native object value is matched");
			}else {
				logStatus("fail", "Role Native Object Type is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Role native object value is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage verifyRoleDisplayAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[7]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Role DisplayAttribute is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("Role display attribute is matched");
			}else {
				logStatus("fail", "Role DisplayAttribute is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Role display attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage verifyRoleIdentityAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[6]").getAttribute("value");
			//clickByXpath("//*[@name='editForm:j_idt509:1:j_idt527' or @name='editForm:j_idt796:1:j_idt814']");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Role IdentityAttribute is"+ " '"+actual+"' " +" are matched", true);
				System.out.println("Role Identity Attribute is matched");
			}else {
				logStatus("fail", "Role IdentityAttribute is"+ " '"+actual+"' " +" are not matched", true);
				System.out.println("Role Identity Attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
public SchemaPage verifyPrivilegeNativeObjectType(String text) {
		
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]").getAttribute("value");
			clickByXpath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[5]");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Privilege Native Object Type is"+ " '"+actual+"' " +" are matched", false);
				System.out.println(" Privilege native object value is matched");
			}else {
				logStatus("fail", "Privilege Native Object Type is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Privilege native object value is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage verifyPrivilegeDisplayAttribute(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[7]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Privilege DisplayAttribute is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("Privilege display attribute is matched");
			}else {
				logStatus("fail", "Privilege DisplayAttribute is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Privilege display attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage verifyPrivilegeIdentityAttribute(String text) {
		String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[6]").getAttribute("value");
		//clickByXpath("//*[@name='editForm:j_idt509:1:j_idt527' or @name='editForm:j_idt796:1:j_idt814']");
		if(actual.equalsIgnoreCase(text)) {
			logStatus("pass", "Privilege IdentityAttribute is"+ " '"+actual+"' " +" are matched", true);
			System.out.println("Privilege Identity Attribute is matched");
		}else {
			logStatus("fail", "Privilege IdentityAttribute is"+ " '"+actual+"' " +" are not matched", true);
			System.out.println("Privilege Identity Attribute is not matched");
		}
		return this;
	}
	
	public SchemaPage  verifyAttributeForRole(String text,String type) {
		try {
			WebElement togetrow=driver.findElementByXPath("(//table[@style='table-layout:fixed']/tbody)[2]");
			java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
			int count=totalrow.size();
			int count2=0;
			//System.out.println(count);
			for(int i=0;i<=count-2;i++) {
				String attribute=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':1:schemaAttrTbl:"+i+":attrName')]").getAttribute("value");
			String actual=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':1:schemaAttrTbl:"+i+":attributeType')]").getAttribute("value");
			if(attribute.equalsIgnoreCase(text)) {
				if(actual.equalsIgnoreCase(type)) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					System.out.println(attribute+" Type is "+" '"+type +"' "+" matched");
					}else if(actual.equalsIgnoreCase("group")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("boolean")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("role")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}
				else {
						System.out.println(attribute+" matched but Type is "+" '"+actual +"' "+" not matched");
						logStatus("fail", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" not matched ", false);
					}
				break;
				}
			else {
				count2=count2+1;
				if(count2==count-1) {
					
					System.out.println(text+" Type is "+" '"+type +"' "+" not matched");
					logStatus("fail", "The "+ " '"+text+"' " +" atrribute type is"+ " '"+type+"' " +" not matched ", false);
					
				}
			}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;

	}
	public SchemaPage verifyGroupNativeObjectForSwow(String text) {
		
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[9]").getAttribute("value");
			clickByXpath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[9]");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group Native Object Type is"+ " '"+actual+"' " +" are matched", false);
				System.out.println(" Group native object value is matched");
			}else {
				logStatus("fail", "Group Native Object Type is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Group native object value is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	
	public SchemaPage verifyGroupDisplayAttributeForSwow(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[11]").getAttribute("value");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group DisplayAttribute is"+ " '"+actual+"' " +" are matched", false);
				System.out.println("Group display attribute is matched");
			}else {
				logStatus("fail", "Group DisplayAttribute is"+ " '"+actual+"' " +" are not matched", false);
				System.out.println("Group display attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
		
	}
	
	public SchemaPage verifyGroupIdentityAttributeForSwow(String text) {
		try {
			String actual=driver.findElementByXPath("(//*[@class='schema-detail-label']//following-sibling::div/input[contains(@name,'editForm:j_idt')])[10]").getAttribute("value");
			//clickByXpath("//*[@name='editForm:j_idt509:2:j_idt527' or @name='editForm:j_idt796:2:j_idt814']");
			if(actual.equalsIgnoreCase(text)) {
				logStatus("pass", "Group IdentityAttribute is"+ " '"+actual+"' " +" are matched", true);
				System.out.println("Group Identity Attribute is matched");
			}else {
				logStatus("fail", "Group IdentityAttribute is"+ " '"+actual+"' " +" are not matched", true);
				System.out.println("Group Identity Attribute is not matched");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return this;
	}
	public CorrelationPage  verifyGroupAttributeForSwow(String text,String type) {
		try {
			WebElement togetrow=driver.findElementByXPath("(//table[@style='table-layout:fixed']/tbody)[3]");
			java.util.List<WebElement> totalrow= togetrow.findElements(By.tagName("tr"));
			int count=totalrow.size();
			int count2=0;
			//System.out.println(count);
			for(int i=0;i<=count-2;i++) {
				String attribute=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':2:schemaAttrTbl:"+i+":attrName')]").getAttribute("value");
			String actual=driver.findElementByXPath("//*[contains(@name,'editForm:j_idt')and contains(@name,':2:schemaAttrTbl:"+i+":attributeType')]").getAttribute("value");
			if(attribute.equalsIgnoreCase(text)) {
				if(actual.equalsIgnoreCase(type)) {
					logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					System.out.println(attribute+" Type is "+" '"+type +"' "+" matched");
					}else if(actual.equalsIgnoreCase("group")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("boolean")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}else if(actual.equalsIgnoreCase("role")) {
						logStatus("pass", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" matched successfully", false);
					}
				else {
						System.out.println(attribute+" matched but Type is "+" '"+actual +"' "+" not matched");
						logStatus("fail", "The "+ " '"+attribute+"' " +" atrribute type is"+ " '"+actual+"' " +" not matched ", false);
					}
				break;
				}
			else {
				count2=count2+1;
				if(count2==count-1) {
					
					System.out.println(text+" Type is "+" '"+type +"' "+" not matched");
					logStatus("fail", "The "+ " '"+text+"' " +" atrribute type is"+ " '"+type+"' " +" not matched ", false);
					
				}
			}
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}
		return new CorrelationPage(driver, test);
	}
}
