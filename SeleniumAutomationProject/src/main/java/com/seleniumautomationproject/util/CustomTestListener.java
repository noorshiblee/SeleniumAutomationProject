package com.seleniumautomationproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniumautomationproject.util.PropertySettings;

/*
 * responsible to generate execution report using Extent library.
 * ref website: http://extentreports.relevantcodes.com/java/
 * ref website: http://testng.org/javadocs/org/testng/TestListenerAdapter.html
 */
public class CustomTestListener extends TestListenerAdapter{
	
	public PropertySettings propSettings;

	static ExtentReports report = ExtentReport.getInstance();
	ExtentTest extentTest;
	String suiteName = null;
	String testName = null;
	
	public CustomTestListener(PropertySettings propSettings) {
		this.propSettings = propSettings;
	}

	/* (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext testContext) {
		testContext.setAttribute("setting", propSettings);
		System.out.println("\n\t \t ==== Start Executing "+testContext.getName()+" suite =====\n");
		suiteName = testContext.getName();		
		super.onStart(testContext);
	
	}

	/* (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
		System.out.println("start executing "+result.getMethod().getMethodName());
		String testcaseName = result.getMethod().getMethodName();
		extentTest=report.startTest(testcaseName).assignCategory(suiteName);
		extentTest.log(LogStatus.INFO, "TestCase : Started");
	}

	/* 
	 * this method is invoked if the test case is success.
	 * @param testresult
	 */
	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		String testcaseName = tr.getMethod().getMethodName();
		System.out.println("TestCase : "+testcaseName+" is Passed");
		
		extentTest.log(LogStatus.PASS, "TestCase : "+testcaseName+" is Passed");
		extentTest.log(LogStatus.INFO, "TestCase : Finished");
		report.endTest(extentTest);
		report.flush();
	}
	
	/* 
	 * this method is invoked if the test case is failed.
	 * @param testresult
	 */
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		String testcaseName = tr.getMethod().getMethodName();
		System.out.println("TestCase : "+testcaseName+" is Failed");
	
		extentTest.log(LogStatus.FAIL, "TestCase : "+testcaseName+" is Failed");
		extentTest.log(LogStatus.ERROR, "Failure Reason: <br>"+tr.getThrowable().toString());		
		extentTest.log(LogStatus.INFO, "TestCase : Finished");
		report.endTest(extentTest);
		report.flush();
	}
	 
	/* 
	 * this method is invoked if the test case is skipped.
	 * @param testresult
	 */
	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		String testcaseName = tr.getMethod().getMethodName();
		System.out.println("TestCase : "+testcaseName+" is skipped");
		
		extentTest.log(LogStatus.SKIP, "TestCase : "+testcaseName+" is skipped");
		extentTest.log(LogStatus.INFO, "TestCase : Finished");
		report.endTest(extentTest);
		report.flush();
	}

}
