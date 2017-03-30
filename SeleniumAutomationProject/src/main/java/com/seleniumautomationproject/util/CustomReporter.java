package com.seleniumautomationproject.util;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

/*
 * mainly responsible to generate the test execution summary to show in console and for testng custom report.
 * generateReport() method do this task.
 * ref. website: https://www.tutorialspoint.com/testng/testng_custom_reporter.htm
 * ref. website: https://examples.javacodegeeks.com/enterprise-java/testng/testng-html-xml-reports-example/
 */
public class CustomReporter implements ITestListener, IReporter{

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
		String suiteWiseSummaryReport = null;
    	String summaryReport = null;
    	int totalTCPassed = 0;
	    int totalTCSkipped = 0;
	    int totalTCFailed = 0;
	    int totalTCRun = 0;
    	
    	/* Iterating over each suite included in the test */
        for (ISuite suite : suites)
        {
		        /* get the suite name */
		        String suiteName = suite.getName();
			    /* Getting the results for the suite */
			    Map<String, ISuiteResult> suiteResults = suite.getResults();
			    
			    suiteWiseSummaryReport += "\nTests suite " + suiteName;
			    suiteWiseSummaryReport += "\n===============================================================\n";
			    
			    String testcaseName = "";
			    for (Map.Entry<String, ISuiteResult> sr: suiteResults.entrySet())
			    {	
			    	ITestContext tc = sr.getValue().getTestContext();
			    	testcaseName = tc.getName();
			    			
			    	int testWisePassed = tc.getPassedTests().getAllResults().size();
			    	int testWiseSKipped = tc.getSkippedTests().getAllResults().size();
			    	int testWiseFailed = tc.getFailedTests().getAllResults().size();
			    	int testWiseTotal = tc.getAllTestMethods().length;
			    	
			    	suiteWiseSummaryReport +="\nSummary for Test: "+testcaseName+"\n";
			    	suiteWiseSummaryReport +="-----------------------------------------------";
			    	suiteWiseSummaryReport += "\nPassed - " + testWisePassed;
			    	suiteWiseSummaryReport += "\nSkipped - " + testWiseSKipped;
			    	suiteWiseSummaryReport += "\nFailed - " + testWiseFailed;
			    	suiteWiseSummaryReport += "\nTotal test case run - " + testWiseTotal+"\n";
			    	suiteWiseSummaryReport +="-----------------------------------------------";
			        
			        //counts suitewise passed, skipped, failed & total testcases
			    	totalTCPassed += testWisePassed;
			    	totalTCSkipped += testWiseSKipped;
			    	totalTCFailed += testWiseFailed;
			    	totalTCRun += testWiseTotal;
			        
			     }
			
			summaryReport += "\n==================================\n";
		    summaryReport += "Summary for tests execution.";
		    summaryReport += "\n----------------------------------\n";
		    summaryReport += "Total Passed: "+totalTCPassed;
		    summaryReport += "\nTotal Skipped: "+totalTCSkipped;
		    summaryReport += "\nTotal Failed: "+totalTCFailed;
		    summaryReport += "\nTotal Run: "+totalTCRun;
		    summaryReport += "\n==================================\n";
        }
        System.out.println(summaryReport);
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
