package com.HRA.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplClass implements ITestListener {

	ExtentReports report;
	ExtentTest test ;
	public void onTestStart(ITestResult result) {
		//fetch the method name
		String methodName = result.getMethod().getMethodName();
		//creates a test
		test = report.createTest(methodName);
		//print 
		Reporter.log(methodName+"--->Script execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		//fetch the method name
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--->passed");
		Reporter.log(methodName+"--->Script passed");
	}

	public void onTestFailure(ITestResult result) {
		//fetch the method name
		String Name = result.getMethod().getMethodName();
//		String res = Name+new JavaUtility().getSystemDateInFormat();
		
//		String res = result.getName()+new JavaUtility().getSystemDateInFormat();
		
//		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./screenshot/"+res+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			String failedScript = WebDriverUtility.getScreenshot(BaseClass.sdriver, Name);
			test.addScreenCaptureFromPath(failedScript);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, Name+"--->script failed");
		//if script fails, will throw the exception
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(Name+"--->script has been failed");
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-->script skipped");
		//if script is skipped, will throw the exception
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"--->script has been skipped");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		
		//create a empty extent report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlReport.config().setDocumentTitle("SDET-50");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("HouserRentalApplication");
		
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("URL", "http://rmgtestingserver/domain/House_Rental_Application/");
		report.setSystemInfo("ReporterName", "Vikas.S");
	}

	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
	}
	
}
