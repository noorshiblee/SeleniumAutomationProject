package com.seleniumautomationproject.locator;

import org.openqa.selenium.By;

/*
 * @Noor Mohammad Shiblee
 * contains all element locator of the home page.
 */
public class HomePageLocator {

	//locator of শহর  ঢাকা
	public static final By DHAKA_CITY = By.cssSelector("a[href$='dhaka']");
	
	//locator of শহর  চট্টগ্রাম
	public static final By CHITTAGONG_CITY = By.cssSelector("a[href$='chittagong']");
		
	//this is locator of "Bikroy.com-এ স্বাগতম - বাংলাদেশ-এর সবচেয়ে বড় মার্কেটপ্লেস!"
	public static final By WELCOME_TEXT = By.cssSelector("div.col-6>h1");
	
}
