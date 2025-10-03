package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadingFile {

	public static void main(String[] args) {
		
		
		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println(width);
		System.out.println(height);
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		Page page = bc.newPage();
		
		
		page.navigate("https://www.selenium.dev/downloads");
		
		
		Download file = page.waitForDownload(()->{
			
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
			page.locator("/html/body/div/main/div[3]/div[3]/div/div[2]/p[2]/a").click();
		});
		
	file.saveAs(Paths.get("./src/test/resources/selenium.jar"));
	}

}
