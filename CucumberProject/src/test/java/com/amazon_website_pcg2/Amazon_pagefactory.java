package com.amazon_website_pcg2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Amazon_pagefactory {
	WebDriver driver;
	
	@FindBy(xpath ="//input[@name='username']")
	@CacheLookup
	WebElement userId;
	
	@FindBy(xpath ="//input[@type='password']")
	@CacheLookup
	WebElement userPassword;
	
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	@CacheLookup
	WebElement LogIn;
	
	@FindBy(xpath ="//p[text()='Invalid credentials']")
	@CacheLookup
	WebElement invalidErrorMsg;
	
	@FindBy(xpath ="(//span[text()='Required'])[1]")
	@CacheLookup
	WebElement requiredUserNameErrorMsg;

	@FindBy(xpath ="(//span[text()='Required'])[2]")
	@CacheLookup
	WebElement requiredUserPswdErrorMsg;

	public Amazon_pagefactory(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}


	public void enterUserId(String userid)
	{
		userId.sendKeys(userid);
		
	}
	
	public void enterPassword(String userpassword)
	{
		userPassword.sendKeys(userpassword);
		
	}
	
	public void clickSignIn()
	{
		Actions act = new Actions(driver);
		act.moveToElement(LogIn).click().perform();	
		
	}
	
	public void validateErrorMsg(String usernm,String pswd) throws InterruptedException {
		
		System.out.println("error msg method invoked");

           
			String errormsg = invalidErrorMsg.getText();
			System.out.println(errormsg);

			if (invalidErrorMsg.equals("Invalid credentials")) {
				System.out.println("true_text are matched");
				Assert.assertEquals("Invalid credentials", errormsg);
				Thread.sleep(10000);
				driver.close();
			}
			else
				System.out.println("false_text are not matched");
			    //System.out.println(requiredUserNameErrorMsg);

		}
	

		
}
