package com.seleniumautomationproject.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/*
 * start test using testng
 * ref web: http://testng.org/doc/documentation-main.html
 * 5.13 - Running TestNG programmatically
 */
public class TestStarter {
	
	private List<String> testSuites;
	private TestListenerAdapter tla;
	private TestNG testng;
	protected PropertySettings propSettings;
	
	public TestStarter(PropertySettings propSettings) {
		this.propSettings = propSettings;
	}
		
	/** this will run the whole test suite */
	public void startTest() {
		try	{
			testng = new TestNG();
			testng.setVerbose(0);
			testSuites = new ArrayList<String>();
			tla = new CustomTestListener(propSettings);
			testSuites.add(AppConstant.APP_CONFIG+propSettings.getTestngxml());
			testng.setTestSuites(testSuites);
			testng.addListener(tla);
			testng.run();
		  }
		catch(Exception e) {
			this.stopTest();
			System.out.println("Execution stop for driver problem or testcategory or testcase does not exist.");
			e.printStackTrace();			 
		}
	}
	
	/*
	 * quit driver and stop execution.
	 */
	public void stopTest() {
		if (propSettings.driver != null) {
			propSettings.driver.quit();
			propSettings.setDriverEmpty();
		} 
	}
}
