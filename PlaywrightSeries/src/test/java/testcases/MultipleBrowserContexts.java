package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleBrowserContexts {

	public static void main(String[] args) {
		
		// How do u create multiple browser contexts in playwright ?
		
		//Answer : BrowserContexts in playwright provides a way to operate multiple independent browser sessions.
		
		
		
		
		//Each context operates like a seperate browser instance, enabling parallel tests without shared session data
		
		
		
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		//Page page = browser.newPage();
		
		
		// Create two separate browser contexts
		BrowserContext context1 = browser.newContext();
		BrowserContext context2 = browser.newContext();
		
		
		// Create pages in each context
		Page page1 = context1.newPage();
		Page page2 = context2.newPage();
		
		page1.navigate("https://google.com");
		page2.navigate("https://example.org");
		
		System.out.println(page1.title());
	    System.out.println(page2.title());
		
	    // Close browser
	    browser.close();
		

	}

}
