package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.HomePage;


public class HomePageTest extends BaseTest {
	
	
	@Test
	public void getHomePageTitle() {
		
		String actualTitle = homepage.getHomePageTitle(null);
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void getHomePageURL() {
		String actualURL = homepage.getHomeURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	
	@DataProvider
	public Object[][] getProductData(){
		
		return new Object[][]{
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
	};
}
	
	@Test(dataProvider = "getProductData")
	public void serchTest(String productName) throws InterruptedException {
		String actualHeader = homepage.doSearch(productName);
		Assert.assertEquals(actualHeader, "Search - "+productName);
	}
	
	
	
	
	
	

}
