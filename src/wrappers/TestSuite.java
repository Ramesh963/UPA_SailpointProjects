package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.UPA_sailpoint.pages.LoginPage;

import utilsFiles.ReadDataFromExcel;

public class TestSuite extends BaseTest {
	public static String testdatasheetname;
	public static int sheetnum;
	public static String reportname;
	public static String browsername;
	
@BeforeTest
public void beforeTest() throws InterruptedException {
	startReport(reportname);
	loadingObject();
	invokeApp(browsername, prob.getProperty("URL"));
	new LoginPage(driver, test).enterUserName().enterPassword().clickTheLoginButton();
	
}

@AfterTest
public void afterTest() {
	unloadObject();
	endReport();
	close();
}

@AfterMethod
public void afterMethod() {
	endTest();
}
@DataProvider(name="fetchdata")
public String[][] getDataFromExcel() throws IOException{
	return ReadDataFromExcel.getData(testdatasheetname, sheetnum);
	
}

}
