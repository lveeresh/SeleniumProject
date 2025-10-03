package testcases;
 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator.TypeOptions;
import com.microsoft.playwright.Page;
 
import com.microsoft.playwright.Playwright;
 
public class KeyboardEvents {
 
	public static void main(String[] args) throws InterruptedException {
 
 
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("http://google.com");
		
		
		page.locator("//textarea[@class='gLFyf']").type("Veeresh", new TypeOptions().setDelay(100));
		
		
		//page.navigate("https://login.yahoo.com/");
		//page.locator("#login-username").type("trainer@way2automation", new TypeOptions().setDelay(100));
		//page.keyboard().press("Enter");
		//Thread.sleep(1000);
		//page.goBack();
		
		
		page.keyboard().press("Control+A");
		Thread.sleep(2000);
		page.keyboard().press("Control+X");
		Thread.sleep(2000);
		page.keyboard().press("Control+V");
		Thread.sleep(1000);
		page.keyboard().down("Shift");
		
		for(int i=0; i<3; i++) {
			
			page.keyboard().press("ArrowLeft");
			Thread.sleep(500);
			//page.keyboard().press("Shift+U");
			
			
		}
		page.keyboard().press("u");
		//page.keyboard().press("Control+Alt").down("Delete");
		
		
		//to perfoem control+shift+p
		page.keyboard().press("Control+Shift+P");
		
		//or
	
		// Press Ctrl + Shift + P using keyboard.down and keyboard.up
		Keyboard keyboard = page.keyboard();
		keyboard.down("Control");
		keyboard.down("Shift");
		keyboard.press("P"); // This simulates pressing 'P' while Ctrl and Shift are held down
	    keyboard.up("Shift");
		keyboard.up("Control");

 
 
	}
 
}