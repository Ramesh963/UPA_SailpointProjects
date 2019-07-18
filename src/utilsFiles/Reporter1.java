package utilsFiles;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public abstract class Reporter1  {
	static ExtentReports report;
	public ExtentTest test;
	public String description;
	static Date date=new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh");  
    static String strDate= formatter.format(date);
	public void startReport(String reportname) {
		report=new ExtentReports("G:\\Security\\UPA_Report for AppOnboard & Agg\\reports\\"+reportname+" "+strDate+".html");
	}
	public void startTest(String testname) {
		
		test=report.startTest(testname,"fetching the data from sailpoint Application details and validate to excel data");
		
	}
	public abstract long takesnap();
	public void logStatus(String status,String desc,boolean wantScreenShot) {
		long picname=takesnap();
		if(wantScreenShot) {
			if(status.equalsIgnoreCase("pass")) {
				test.log(LogStatus.PASS, desc+test.addScreenCapture("G:\\Security\\UPA_Report for AppOnboard & Agg\\Screenshot "+strDate+"\\"+picname+".jpeg"));
			}
			if(status.equalsIgnoreCase("fail")) {
				test.log(LogStatus.FAIL, desc +test.addScreenCapture("G:\\Security\\UPA_Report for AppOnboard & Agg\\Screenshot "+strDate+"\\"+picname+".jpeg"));
			}
			if(status.equalsIgnoreCase("skip")) {
			test.log(LogStatus.SKIP, desc+test.addScreenCapture("G:\\Security\\UPA_Report for AppOnboard & Agg\\Screenshot "+strDate+"\\"+picname+".jpeg"));
			}
		}
			else {
		if(status.equalsIgnoreCase("pass")) {
			test.log(LogStatus.PASS, desc);
		}
		if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, desc);
		}
		if(status.equalsIgnoreCase("skip")) {
		test.log(LogStatus.SKIP, desc);
		}
			}
	}
	
	public void endTest() {
		report.endTest(test);
	}
	public void endReport() {
		report.flush();
	}
}
