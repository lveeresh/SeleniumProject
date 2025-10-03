package testcases;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandlingMultipleWindows {

	public static void main(String[] args) {
		
		
		// Example Code from copilot--> Multiple Window Handling
		
		
		    try (Playwright playwright = Playwright.create()) {
		    	
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		      BrowserContext context = browser.newContext();

		      // Open the main page
		      Page page = context.newPage();
		      page.navigate("https://example.com");

		      // Trigger a popup and wait for it
		      Page popup1 = page.waitForPopup(() -> {
		        page.locator("text=Open First Popup").click();
		      });

		      // Trigger another popup from the first popup
		      Page popup2 = popup1.waitForPopup(() -> {
		        popup1.locator("text=Open Second Popup").click();
		      });

		      // List all open pages
		      List<Page> allPages = context.pages();
		      System.out.println("Total open pages: " + allPages.size());

		      // Switch between them
		      page.bringToFront();
		      page.locator("#main-input").type("Main Window");

		      popup1.bringToFront();
		      popup1.locator("#popup1-input").type("First Popup");

		      popup2.bringToFront();
		      popup2.locator("#popup2-input").type("Second Popup");
		    }
		  
		


	}

}
