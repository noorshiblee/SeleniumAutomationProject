package com.seleniumautomationproject.test;

import org.testng.annotations.Test;

import com.seleniumautomationproject.util.TestHelper;
import com.seleniumautomationproject.locator.HomePageLocator;

public class HomePageScenario extends TestHelper {
	
	/**
	 * click on Dhaka city
	 */
	public void clickOnDhakaCity(){
		
		waitForElement(HomePageLocator.WELCOME_TEXT, 5);
		clickElem(HomePageLocator.DHAKA_CITY);
		waitForElemInvisibility(HomePageLocator.WELCOME_TEXT, 5);
	}
	
	/**
	 * click on Chittagong city.
	 */
	public void clickOnChittagongCity(){
		
		waitForElement(HomePageLocator.WELCOME_TEXT, 5);
		clickElem(HomePageLocator.CHITTAGONG_CITY);
		waitForElemInvisibility(HomePageLocator.WELCOME_TEXT, 5);
	}
}
