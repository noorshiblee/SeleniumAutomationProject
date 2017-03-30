package com.seleniumautomationproject.util;

/*
 * necessary path information
 */
public class AppConstant {

	private AppConstant () { } // prevents instantiation
	public static final String CURRENT_DIR = System.getProperty("user.dir");
	public static final String RESOURCE_DIR = CURRENT_DIR+"/resource/";
	public static final String APP_CONFIG = CURRENT_DIR+"/config/";
	public static final String SETTING_PATH = CURRENT_DIR+"/config/setting.conf";
	public static final String EXTENTREPORT_PATH = CURRENT_DIR + "/extentreport/";
	public static final String CHROME_DRIVER = CURRENT_DIR+"/resource/chromedriver.exe";
}
