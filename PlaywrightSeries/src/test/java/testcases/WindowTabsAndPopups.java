package testcases;
 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
 
public class WindowTabsAndPopups {
 
	public static void main(String[] args) throws InterruptedException {
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");
 
		Page popup = page.waitForPopup(() -> {
 
			page.locator("text=Privacy Policy").nth(0).click();
 
		});
		
		popup.locator("//*[@id=\"header-sign-up-btn\"]").click();
		System.out.println("child window title: "+popup.title());
		
		popup.locator("//*[@id=\"name\"]").type("Rahul Arora");
		Thread.sleep(3000);
		
		page.bringToFront();     //it will swith to original window
		page.type("#user_name", "veeru");
		

		popup.bringToFront();	//--> if u want go back again to u r child window and want to perform some actions

	
	
		System.out.println("Parent window title: "+page.title());
	//	popup.close();
		
		page.close();
		browser.close();
		playwright.close();
 
	}
 
}