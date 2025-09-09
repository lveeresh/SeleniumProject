package Maven_Testng.Maven_Testng;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadWrightExcel {

	public static void main(String[] args) throws Exception {
		// Load Excel file
		FileInputStream fis = new FileInputStream(
				new File("C:\\Users\\VLAKKAND\\git\\SeleniumProject\\Maven_Testng\\servers\\Credentials.xlsx"));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(1).getPhysicalNumberOfCells();   // Get column count

		// Setup WebDriver
		// WebDriver driver = new ChromeDriver();
		// driver.get("https://example.com/login"); // Replace with your login URL

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);
			String userId = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

			// Skip header row if it contains column names
			if (userId.equalsIgnoreCase("UserID") || password.equalsIgnoreCase("Password")) {
				continue;
			}

			System.out.println("UserID: " + userId);
			System.out.println("Password: " + password);

			// Fill login form
//		            driver.findElement(By.id("username")).sendKeys(userId);
//		            driver.findElement(By.id("password")).sendKeys(password);
//		            driver.findElement(By.id("loginButton")).click();
//
//		            // Add wait or validation logic here if needed
//		            driver.navigate().back(); // Go back to login page for next test

		}
		workbook.close();
		fis.close();
//		driver.quit();
	}
}
