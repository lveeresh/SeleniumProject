package Maven_Testng.Maven_Testng;

public class SeleniumNotes {
	
	/*
	 1. Condiser your application pages are loading very slowly how will you handle this case
	 
	 Ans: by implementing smart waiting strategies.
		 1. Explicite Wait
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
	
		 2. Page Load TimeOut
	 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

	 
	 2. can we override the static methods ?
	 Ans: we cant override the static methods bcz overriding works with objects, and static mehtods belongs to the class not the object
	 		Static Mehtod : Class - level
	 		Override Method: Object - level
	 		
	 
	 
	 3.is it possible t automate everything or 100% automation possible?
	 Ans: 100% qutomation is not possible. we can automate repetitive and stable tasks, but things like frequent UI changes, usability 
	 		testing, OTP or captcha's needs human effort. thats why mix of automation and human testing is always required.
	 
	 4. How does Parallel execution helps you?
	 Ans: Parallel Execution helps to save the time by running multiple testsat the same time, which improves efficiency and gives
	 		faster feedback.
	 */
	
	
	
	
	
	
	

}
