package com.aq.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	
	//1. According to the page object model we should not write assertion statements in page classes
	//2. According to the page object model we should not write playwright statements in test classes
	
	
	Playwright playwright;
	Browser browser;
	BrowserContext browesrContext;
	Page page;
	
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("BrowserName is  :"+browserName);
		
		playwright = Playwright.create();
		
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "edge":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
			break;
		default:
			System.out.println("please pass the rigt browser name....");
		}	
		
		browesrContext = browser.newContext();
		page = browser.newPage();
		
		page.navigate(prop.getProperty("url").trim());
		//page.url("https://naveenautomationlabs.com/opencart/");
		
		return page;
		
	}
	
	/*
	 * this method is used to initialise the proprties from config file
	 */
	public Properties init_prop() {
		
		try {
			FileInputStream ip = new FileInputStream("./src\\test\\resources_naveen\\config\\config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
