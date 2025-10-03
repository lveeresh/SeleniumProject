package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage  {

	private Page page;
	
	private String emialId = "#input-email";
	private String password = "#input-password";
	private String loginButton = "input[value='Login']";
	private String forgotPasswrdLink = "#content > div > div:nth-child(2) > div > form > div:nth-child(2) > a";
	private String logOutLink = "#column-right > div > a:nth-child(13)";

	public LoginPage(Page page) {
		this.page = page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPasswrdLink);
	}
	
	public void doLogIn(String appUserName, String appUserPwd) {
		System.out.println("App creds :"+appUserName+" - "+ appUserPwd);
		page.fill(emialId,appUserName );
		page.fill(password,appUserPwd);
		page.click(loginButton);
		System.out.println("checking the element:   ");
		if(page.isVisible(logOutLink)) {
			System.out.println("User succesfully loggedin...");
		}
		else
			System.out.println("User not loggedin...");
		
	}
}
