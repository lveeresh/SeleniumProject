package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opecart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority =1)
	public void loginPageNavigationTest() {
		loginpage = homepage.navigateToLoginPage();
		String actLoginPageTitle = loginpage.getLoginPageTitle();
		System.out.println("Actual login page tilte is :"+actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void forgorpwdLinkExistTest() {
		Assert.assertEquals(true, loginpage.isForgotPwdLinkExist());
	}
	
	@Test(priority =3)
	public void appLoginTest() {
		//Assert.assertTrue(loginpage.doLogIn(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		loginpage.doLogIn(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	

}
