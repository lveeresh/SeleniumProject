package com.qa.opecart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aq.opencart.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	
	PlaywrightFactory pf;
	Page page;
	
	public Properties prop;
	protected HomePage homepage;
	protected LoginPage loginpage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initBrowser(prop);
		homepage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	
	
	
	
	
	
	
	
	

}
