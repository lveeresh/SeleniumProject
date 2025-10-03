package testcases;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;

public class Assighment2 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");

		Locator checkboxes = block.locator("[type='checkbox']");
		System.out.println(checkboxes.count());
		
		int c=0;
		for (int i = 0; i < checkboxes.count(); i++) {
			
			if(checkboxes.nth(i).isChecked()) {
				break;
			}
			else if(c<=1){
				checkboxes.nth(i).click();
				c++;
		}

		//System.out.println(checkboxes.count());

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

// TODO Auto-generated catch block

			e.printStackTrace();

		}

		page.close();

		browser.close();

		playwright.close();

	}

}}