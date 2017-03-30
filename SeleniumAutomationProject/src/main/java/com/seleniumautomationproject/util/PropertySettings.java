package com.seleniumautomationproject.util;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
;

/*
 * @Noor Mohammad Shiblee
 * all necessary data is handled here before start the execution.
 */
public class PropertySettings {
	
	public WebDriver driver = null;


	private String testngxml = null;
	private String browser = null;
	private String url = null;
	
	/** 
	 * construct setting information
	 **/
	public PropertySettings()
	{
		Properties prop = null;
		try{
            prop = new Properties();
            //get setting.conf
            prop.load(new FileInputStream(AppConstant.SETTING_PATH));
            this.testngxml = prop.getProperty("testngxml");
            this.browser = prop.getProperty("browser");
            this.url = prop.getProperty("url");
            
		}catch (Exception e) {           
           System.out.println(e.getMessage());
           e.printStackTrace();
	    }
	}
	
	/** returns web driver */
	public WebDriver setDriver(){
		
		if (browser.equals("safari")) {
			driver = new SafariDriver();
			//add capabilities according to your own.
		} 
		else if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			//add capabilities according to your own.
		} 
		else if (browser.equals("firefox")){
			driver = new FirefoxDriver();
			//add capabilities according to your own.
		}
		else {
			System.err.println("\n browser is invalid.\n");
			System.exit(0);
		}
				
		driver.manage().window().maximize();
		return driver;
	}
	
	/** returns web driver */
	public WebDriver getDriver()
	{	
		if (this.driver == null) {
			this.driver = setDriver();
		}
		return driver;
	}
	
	/** set null to driver */
	public void setDriverEmpty(){
		this.driver = null;
	}
	
	/**
	 * @return the testngxml
	 */
	public String getTestngxml() {
		return testngxml;
	}

	/**
	 * @param testngxml to set
	 */
	public void setTestngxml(String testngxml) {
		this.testngxml = testngxml;
	}

	/**
	 * @return browser
	 */
	public String getBrowser() {
		return browser;
	}
	
	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
}
