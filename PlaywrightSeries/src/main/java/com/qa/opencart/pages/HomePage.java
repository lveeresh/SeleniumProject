package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	private String serach = "input[name='search']";
	private String serachButton = "#search span i";
	private String searchPageHeader = "#content h1";
	private String loginLink = "//a[text()='Login']";
	private String accountLink = "//span[text()='My Account']";



	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle(String title) {
		String pageTitle = page.title();
		System.out.println("Page Title: " + pageTitle);
		return pageTitle;
	}

	public String getHomeURL() {
		String pageURL = page.url();
		System.out.println("Page URL: " + pageURL);
		return pageURL;
	}

	public String doSearch(String productName) throws InterruptedException {
		page.fill(serach, productName);
		//Thread.sleep(30000);
		page.click(serachButton);
		String header = page.textContent(searchPageHeader);
		System.out.println("Page Header: " + header);
		return header;
		

	}

	public LoginPage navigateToLoginPage() {
		page.click(accountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
