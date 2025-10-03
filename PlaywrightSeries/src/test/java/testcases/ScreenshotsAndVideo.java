package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class ScreenshotsAndVideo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.google.com/");
		
		
		//page screen shot
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./Screenshots/screenshot.png")));

		//Locator screen shot
		page.locator("//html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./Screenshots/screenshot_locator.png")));
		
		//or
		/*  Locator element = page.locator("#example-element");
			ScreenshotOptions options = new Locator.ScreenshotOptions().setPath("./Screenshots/screenshot_locator.png");
			element.screenshot(options);
		 */
		
		
		
	}

}
