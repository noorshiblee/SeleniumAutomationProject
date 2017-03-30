package com.seleniumautomationproject.util;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

/*
 * add all helper function here.
 */
public class TestHelper {
	
	public WebDriver driver = null;
	protected PropertySettings settings = null;
	protected JavascriptExecutor jse = null;


	/**
	 * this method is responsible to setDriver for all Test suites
	 * @param ITestContext
	 * @throws MalformedURLException 
	 */
	@BeforeTest
	public void testBeforeTest(ITestContext ctx) throws MalformedURLException {
		
		if (settings == null) {
			settings = (PropertySettings)ctx.getAttribute("setting");
		}
		
		String testingClass = ctx.getCurrentXmlTest().getXmlClasses().get(0).toString(); 
	
		if (driver == null) {
		driver = settings.getDriver();
		driver = settings.getDriver();
		jse = (JavascriptExecutor)driver;
		driver.get(settings.getUrl());
	}
		
	}
	
	/**
	 * quit the driver
	 */
	@AfterTest
	protected void quitDriver(){
	  driver.quit();
	  driver = null;
	  settings.setDriverEmpty();
	}
	
	/*
	 * enter text to text field
	 */
	protected void enterText(WebElement elem, String text){
		
		elem.click();
		elem.clear();
		elem.sendKeys(text);
	}
	
	/**
	 * wait until expected element is visible
	 *
	 * @param	elemLocator			element locator
	 * @param	timeout				Maximum timeout time in second
	 */
	protected void waitForElement(By elemLocator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elemLocator));
		} catch (Exception e) {
			System.out.println("problem in waitForElement, check element is valid and visible within the time or not");
		}
	}
	
	
	/**
	 * wait until Invisibility of element is completed
	 *
	 * @param	elemLocator	element Locator
	 * @param	timeout		Maximum timeout time in second
	 */
	protected void waitForElemInvisibility(By elemLocator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elemLocator));
		}catch(Exception e){
			System.out.println("problem in waitForElemInvisibility function");
		}
	}
	
	/**
	 * go to back screen by click on device back button.
	 */
	public void navigateBack(){
	
		try{
			driver.navigate().back();	
		}
		catch(Exception e){
			System.out.println("problem in navigateBack function");
		}
	}
	
	/**
	 * click on element.
	 */
	protected void clickElem(By elem){
		try{
				driver.findElement(elem).click();
				
			}catch(Exception e){
				System.out.println("problem in click on the element.");
			}
		}
}
