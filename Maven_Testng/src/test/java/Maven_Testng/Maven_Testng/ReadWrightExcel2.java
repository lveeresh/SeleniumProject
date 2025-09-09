package Maven_Testng.Maven_Testng;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadWrightExcel2 {

	@Test(dataProvider = "loginData")
	public void loginTest(String userId, String password) {

		/*
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("https://example.com/login"); // Replace with your actual login
		 * URL
		 * 
		 * driver.findElement(By.id("username")).sendKeys(userId);
		 * driver.findElement(By.id("password")).sendKeys(password);
		 * driver.findElement(By.id("loginButton")).click();
		 * 
		 *  Add validation or wait logic here driver.quit();
		 */
		
		System.out.println("UserID: " + userId);
		System.out.println("Password: " + password);

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws Exception {

		FileInputStream fis = new FileInputStream(
				new File("C:\\Users\\VLAKKAND\\git\\SeleniumProject\\Maven_Testng\\servers\\Credentials.xlsx"));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(1).getPhysicalNumberOfCells();   // Get column count
		
		Object[][] data = new Object[rowCount - 1][2]; // skip header

		int index = 0;

		for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header
			Row row = sheet.getRow(i);

			String userId = row.getCell(0).toString();
			String password = row.getCell(1).toString();

			// Skip rows that still contain header labels
			if (userId.equalsIgnoreCase("UserID") || password.equalsIgnoreCase("Password")) {
				continue;
			}

			data[index][0] = userId;
			data[index][1] = password;
			index++;
		}

		workbook.close();
		fis.close();
		return data;

	}

}
