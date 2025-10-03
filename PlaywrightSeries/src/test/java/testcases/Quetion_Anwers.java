package testcases;

public class Quetion_Anwers {

	public static void main(String[] args) {
		
	/*1. what is wait for selector in playwright?
				
		Ans: The waitForSelector method in Playwright is used to wait for an element to appear on the page before proceeding with 
		further actions. This is particularly useful when dealing with dynamic content that may take some time to load. 

		    page.navigate("https://example.com");
				
            // Wait for a specific selector to appear
            page.waitForSelector("button#submit");

            // Perform actions after the element is visible
            Locator button = page.locator("button#submit");
            button.click();

	
	2. waitFornavigation in playwright?
				
		Ans:  waitForNavigation method in Playwright to ensure that the page has fully navigated before performing further actions.
				
				page.navigate("https://example.com");
				page.waitForNavigation(() -> page.navigate("https://example.com")); 


				
	3. how do u run failed test cases in playwright?			
				
				
		Ans: To run failed test cases in Playwright using Java, you can use the retry mechanism provided by Playwright. 
		This feature allows you to automatically re-run tests that fail, which is useful for handling flaky tests or temporary issues
		

		        Playwright playwright = Playwright.create();
		        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
		        options.setRetries(2); // Retry failed tests up to 2 times
		        Browser browser = playwright.chromium().launch(options);
		        // Your test code here
		        browser.close();
		
		or
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setRetries(2));

				or
				
				--> npx playwright test --retries=2
				
	 4. what is playwright fixtures?
	 
	 5. how to generate the authentication coockies in playwright using java 
	 
	 	Ans: First, perform the authentication steps to log in to your application.
			 Use the BrowserContext.storageState method to save the authenticated state (including cookies) to a file.
-->We need authentication to make sure the right person is accessing the right information and to protect private or sensitive data.
	 
	 	import com.microsoft.playwright.*;

			public class AuthExample {
			    public static void main(String[] args) {
			        try (Playwright playwright = Playwright.create()) {
			           
			            Browser browser = playwright.chromium().launch();
			            BrowserContext context = browser.newContext();
			
			            // Open a new page and navigate to the login page
			            Page page = context.newPage();
			            page.navigate("https://example.com/login");
			
			            // Perform login actions
			            page.fill("input[name='username']", "your-username");
			            page.fill("input[name='password']", "your-password");
			            page.click("button[type='submit']");
			
			            // Wait for navigation to ensure login is complete
			            page.waitForNavigation();
			
			            // Save the authenticated state to a file
			            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));
			            
			           --> check in the botton what is auth.json explained clearly
			        }
			    }
			}

	 	-->Reuse the Authenticated State:
			Load the saved state in new browser contexts to reuse the authentication cookies.
			
			import com.microsoft.playwright.*;

				public class ReuseAuthState {
				    public static void main(String[] args) {
				        try (Playwright playwright = Playwright.create()) {
				            
				            Browser browser = playwright.chromium().launch();
				
				            // Load the saved authentication state
				            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json")));
				
				            // Open a new page with the authenticated context
				            Page page = context.newPage();
				            page.navigate("https://example.com");
				
				            // Continue with your tests
				        }
				    }
					}

	 6. how to skip test, based on the browser?
	 
	 Ans: 
			Playwright playwright = Playwright.create()
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Check the browser type and skip tests based on the condition
            String browserName = browserType.name();
            if ("chromium".equals(browserName)) {
                System.out.println("Skipping tests for Chromium browser.");
                return; // Skip the test
            }

	 7. what is jenkins?
	 	
	 	Ans: Basically jenkins is a tool through which we can do contineous intigration, we can use this UI for scheduling our builds
	 	
	 8. how to validate the scenarion using assert?
	 
	 	Ans: assetThat(page);
	 
	 
	 
	 
	 
	 
	 
				
				*/
		
	/*	auth.json: 
	 In the code example, auth.json is a file that stores the authentication state of the browser session. This includes:
1.Cookies
2.Local storage
3.Session storage


json: 
	  {
  "cookies": [
    {
      "name": "session_id",
      "value": "abc123",
      "domain": "your-website.com",
      "path": "/",
      "expires": 1699999999,
      "httpOnly": true,
      "secure": true,
      "sameSite": "Lax"
    }
  ],
  "origins": [
    {
      "origin": "https://your-website.com",
      "localStorage": [
        {
          "name": "user",
          "value": "{\"id\":1,\"name\":\"Rahul\"}"
        }
      ]
    }
  ]
}

	 */
	}

}
