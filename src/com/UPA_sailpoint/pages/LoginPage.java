package com.UPA_sailpoint.pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.object.LocatorObjects;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseTest;

public class LoginPage extends BaseTest {
	public LoginPage(RemoteWebDriver driver1,ExtentTest test1) {
		this.driver=driver1;
		this.test=test1;
	}
	
public LoginPage enterUserName() {
	EnterDataByXpath(LocatorObjects.enterUserName, prob.getProperty("userName"));
	//logStatus("pass", "Username entered successfully ", true);
	return this;
}
public LoginPage enterPassword() {
	EnterDataByXpath(LocatorObjects.enterPassword, prob.getProperty("passWord"));
	//logStatus("pass", "Password entered successfully ", true);
	return this;
}
public HomePage clickTheLoginButton() throws InterruptedException {
	try {
	clickByXpath(LocatorObjects.clickTheLoginButton);
	Thread.sleep(5000);
//	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	
	}
	catch(TimeoutException e) {
		System.out.println("Login Time out");
		//logStatus("fail", "Test case failed due to Login Time out ", true);
	}
	return new HomePage(driver, test);
}

}
