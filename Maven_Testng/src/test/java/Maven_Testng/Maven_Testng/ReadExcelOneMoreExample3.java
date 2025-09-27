package Maven_Testng.Maven_Testng;

import java.io.File;
import java.io.FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelOneMoreExample3 {
	
	@Test(dataProvider = "specificTestData")
	public void runSpecificTest(String userid, String password) {
	    System.out.println("UserId is: " + userid);
	    System.out.println("Password is: " + password);
	    
	}
	
	
	@DataProvider(name = "specificTestData")
	public Object[][] specificTestDataProvider() throws Exception {
	    return getSpecificTestCaseData();
	}


	public Object[][] getSpecificTestCaseData() throws Exception {
	    FileInputStream fis = new FileInputStream(
	        new File("C:\\Users\\VLAKKAND\\git\\SeleniumProject\\Maven_Testng\\servers\\Credentials2.xlsx"));
	    
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(0);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Assuming header is in row 0

	    Object[][] data = new Object[rowCount-1][colCount];
	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[i-1][j] = (cell != null) ? cell.toString() : "";
	            }

//	            workbook.close();
//	            fis.close();
//	            return data;
//	        
	    }

	    workbook.close();
	    fis.close();
	    return data; // Return empty if not found
	}



}
