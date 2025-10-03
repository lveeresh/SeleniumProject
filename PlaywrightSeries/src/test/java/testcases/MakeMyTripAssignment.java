package testcases;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class MakeMyTripAssignment {

	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

	 Page page = browser.newPage();
	//public static void main(String[] args) throws InterruptedException {
	 @Test(priority=1)
	public void makemytrip() throws InterruptedException {

		

		page.navigate("https://www.makemytrip.com/");
		
		//scroll down
		page.evaluate("window.scrollBy(0,1000)");
		//scroll up
		page.evaluate("window.scrollBy(0,-1000)");
		
		
		page.locator("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span").click();

		page.locator("(//span[@class='tabsCircle appendRight5'])[2]").click();

		//Thread.sleep(5000);
		//page.type("#fromCity", "New York", new TypeOptions().setDelay(100));
		
//		page.type("//*[@id='fromCity']", "New York");
		//page.fill("//*[@id='fromCity']", "New York");
		
		//page.locator("//*[@id='fromCity']").click();
		//page.type("//div[@role='combobox']//input", "New York", new Page.TypeOptions().setDelay(100));
		
//        String script = "document.evaluate('//*[@id=\"fromCity\"]', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value = 'New York';";
//        page.evaluate(script);
		
		 String text = "New York";
         for (char c : text.toCharArray()) {
        	 System.out.print(String.valueOf(c));
             page.type("//*[@id='fromCity']", String.valueOf(c), new Page.TypeOptions().setDelay(100));
         }


		// page.locator("//input[@id='fromCity']").type("New York");
		// page.locator("//input[@id='fromCity']").fill("New York");

		Thread.sleep(1000);

		page.locator("//span[text()='New York']").click();

	//	page.type("//*[@id=\"toCity\"]", "London", new Page.TypeOptions().setDelay(200));
		//await page.type("//*[@id=\"toCity\"]", "London", new Page.TypeOptions().setDelay(150));
		
		page.locator("//*[@id='toCity']").click();//		page.type("//*[@id='fromCity']", "New York");
		page.type("//div[@role='combobox']//input", "London", new Page.TypeOptions().setDelay(100));
		
		

		

		page.locator("//span[text()='London']").click();
		
		datePick();
		
		page.locator("(//span[text()='Hotels'])[1]").click();
		Thread.sleep(2000);
		page.type("//input[@class='hsw_inputField lineHeight36 latoBlack font32']","Hyderabad", new Page.TypeOptions().setDelay(100));
		page.click("(//p[@class='sr_city'])[1]");
		
		//datePick2();
		Locator dates =  page.locator("//div[@class='DayPicker-Week']//div");
		int c=0;
		
//		for (int i = 0; i < 10; i++) {
//			
//			if(dates.innerText().equals("3") || dates.innerText().equals("5")) {
//				dates.click();
//				c++;
//			}
//		}
		
		
	}

//		public void datePick2() {
//			List <ElementHandle> dates = (List<ElementHandle>) page.locator("//div[@class='DayPicker-Week']//div");
//			for(ElementHandle date : dates) {
//				if(date.innerText().equals("3") || date.innerText().equals("5")) {
//					date.click();
//				}
//			}
//		}
		
public void datePick() {
	
	String departuredate1 = "4";
	String month = "April2025";
		while (true) {

			String mnt = page.locator("(//div[@class='DayPicker-Caption'])[1]").innerText();
			System.out.println(mnt);

			if (mnt.equalsIgnoreCase(month)) {
				break;

			} else {
				page.locator("//span[@aria-label='Next Month']").click();
			}
		}

		Locator dates = page.locator("//div//div[@class='DayPicker-Week']//p[1]");

		for (int i = 0; i < dates.count(); i++) {
			String departuredate2 = dates.nth(i).innerText();
			if (departuredate1.equals(departuredate2)) {
				dates.nth(i).click();
				break;
			}
		}
		System.out.println("select return month pick====");

		String returndate1 = "5";
		String rmonth = "April2025";

		while (true) {

			String rmnt = page.locator("(//div[@class='DayPicker-Caption'])[1]").innerText();
			System.out.println("return month====" + rmnt);

			if (rmnt.equalsIgnoreCase(rmonth)) {
				break;

			} else {
				page.locator("//span[@aria-label='Next Month']").click();
			}
		}

		Locator returndates = page.locator("//div//div[@class='DayPicker-Week']//p[1]");

		for (int i = 0; i < returndates.count(); i++) {
			String returndate2 = returndates.nth(i).innerText();
			System.out.println("return dare are ===" + returndate2);
			if (returndate1.equals(returndate2)) {
				returndates.nth(i).click();
				break;
			}
		}
}
		

//		
//		page.locator("//a[text()='Search']").click();
//		
//		Thread.sleep(10000);
//		
//		//page.locator("(//div[@class='commonOverlay ']//span)[1]");
//		
//		Locator airLine = page.locator(".boldFont.blackText.airlineName");
//		for(int i=1;i<=airLine.count();i++) {
//			System.out.print("airLines are =="+airLine.innerText());
//		}

	}

