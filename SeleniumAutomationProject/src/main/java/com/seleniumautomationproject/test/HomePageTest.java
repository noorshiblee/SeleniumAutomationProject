package com.seleniumautomationproject.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumautomationproject.locator.HomePageLocator;

public class HomePageTest extends HomePageScenario{
	
	/**
	 * load bikroy.com.
	 * click on শহর ঢাকা
	 */
	@Test
	public void test_clickOnDhakaCity(){
		
		clickOnDhakaCity();
		
		//when the page of dhaka city loads, it will check that welcome text is shown or not.
		//welcome text = Bikroy.com-এ স্বাগতম - বাংলাদেশ-এর সবচেয়ে বড় মার্কেটপ্লেস!
		int count = driver.findElements(HomePageLocator.WELCOME_TEXT).size();
		Assert.assertTrue(count == 0);
		
	}
	
	/**
	 * load bikroy.com.
	 * click on শহর চট্টগ্রাম
	 */
	@Test
	public void test_clickOnChittagongCity(){
		
		navigateBack();
		clickOnChittagongCity();		
		//when the page of chttagong city loads, it will check that welcome text is shown or not.
		//welcome text = Bikroy.com-এ স্বাগতম - বাংলাদেশ-এর সবচেয়ে বড় মার্কেটপ্লেস!
		int count = driver.findElements(HomePageLocator.WELCOME_TEXT).size();
		Assert.assertTrue(count == 0);
		
	}

}
