package com.seleniumautomationproject.util;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.seleniumautomationproject.util.AppConstant;

/*
 * Initialize the extentreport to generate the test execution result.
 * singleton design pattern is used to initialize extent report.
 * ref website: http://extentreports.relevantcodes.com/java/
 */
public class ExtentReport {
	
	private static ExtentReports extentReport = null;
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	//generate report based on the execution time stamp.
	static String extentReportPath = "/"+timeStamp+"_TestExecutionReport.html";
	
	protected ExtentReport() {
		// Exists only to defeat instantiation.
	}
	
	public static ExtentReports getInstance() {
		if(extentReport == null) {
			extentReport = new ExtentReports(AppConstant.EXTENTREPORT_PATH+extentReportPath, false);
		}
		return extentReport;
	}   
}
