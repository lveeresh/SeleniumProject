package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println(width);
		System.out.println(height);
		
		System.out.println("playwright");
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		
		//launching chrome brwser
		// browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		
		BrowserContext bc = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		Page page = bc.newPage();
		//Page page = browser.newPage();
		
		
		page.navigate("http://way2automation.com");
		//Response response = page.navigate("https://www.google.com");
		//System.out.println("Status: " + response.status());

		//page.navigate("http://way2automation.com");
		System.out.println(page.title());
		Thread.sleep(2000);
//		page.close();
//		playwright.close();
		
	}

}
