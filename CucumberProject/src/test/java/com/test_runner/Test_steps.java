package com.test_runner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.amazon_website_pcg2.Amazon_pagefactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Test_steps {
	
	WebDriver driver;
	Amazon_pagefactory amazon;
	

	@Given("user launch the web browser")
	public void user_launch_the_web_browser() throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\\\selenium_testing_10_aug\\\\Maven_Testng\\\\servers\\\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		amazon=new Amazon_pagefactory(driver);
		driver.manage().window().maximize();
		
		amazon= PageFactory.initElements(driver, Amazon_pagefactory.class);
	    
		System.out.println("Chrome browser opened");
		
	    
	}
	
	@When("user open the application URL")
	public void user_open_the_application_url() throws InterruptedException {
	    
	    System.out.println("openening URL");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(8000);
	    
	}

	@When("user entered valid userid and password")
	public void user_enteres_valid_userid_and_password() {

		
	amazon.enterUserId("Admin");
	amazon.enterPassword("admin123");
	
	}
	
	@When("user click on sign in button")
	public void user_click_on_sign_in_button() {
		
		amazon.clickSignIn();
	}
	
	@Then("user navigate to homepage")
	public void user_navigated_to_homepage() {
		System.out.println("user navigated to home page sucessfully");
		driver.close();
		
	}
	
	@When("user enters the invalid  {string}")
	public void user_enters_the_invalid_username(String string) {
		amazon.enterUserId(string);
	}

	@When("user enters the invalid {string}")
	public void user_enters_the_invalid_password(String string) {
		amazon.enterPassword(string);
	}

	@Then("user will get the error message for invalid sign in {string} and {string}")
	public void user_will_get_the_error_message_for_invalid_sign_in_and(String string, String string2) throws InterruptedException {
		 amazon.validateErrorMsg(string, string2);
	}
	
	@When("the user enters the following credentials")
	public void the_user_enters_the_following_credentials(DataTable dataTable) {
	    List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
	    
	    //Access the data by coulumn name
	    
	    //cucmber will convert the data table like below 
	    /*
	     [
		  { "username": "veeresh", "password": "Pass@1234" },
		  { "username": "user1",   "password": "Test@5678" },
		  { "username": "user2",   "password": "Hello@999" },
		  { "username": "user3",   "password": "Welcome@321" }
		 ]

	     */
	    
	    String username = credentials.get(0).get("username");
	    String password = credentials.get(0).get("password");
	    System.out.println("Username entered: " + username + ", Password entered: " + password);
    

	    // Call your login method here
//	    amazon.enterUserId(username);
//	    amazon.enterPassword(password);
//	    amazon.clickSignIn();
//	    
	    //if have more data and u want use it all, go with this
	    for (Map<String, String> row : credentials) {
	        String username1 = row.get("username");
	        String password1 = row.get("password");
	        System.out.println("Username1 entered: " + username1 + ", Password1 entred: " + password1);
	    }

	}

	@When("the user enters username and password")
	public void the_user_enters_username_and_password(DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists(String.class);
	    
	  //Access the data by index
	    
	    String username = data.get(0).get(0);
	    String password = data.get(0).get(1);

	    // Use these values in your login method
	    amazon.enterUserId(username);
	    amazon.enterPassword(password);
	    amazon.clickSignIn();
	    
	    
	    //if more data
//	    System.out.println(data.get(0).get(0));
//		System.out.println(data.get(0).get(1));
//		System.out.println(data.get(1).get(0));
//		System.out.println(data.get(1).get(1));
	}

	

}
