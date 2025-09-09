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

public class ReadExcelOneMoreExample2 {
	
	

	

	@Test(dataProvider = "specificTestData")
	public void runSpecificTest(String testcases, String vin, String data, String id) {
	    System.out.println("Test Case: " + testcases);
	    System.out.println("VIN: " + vin);
	    System.out.println("Data: " + data);
	    System.out.println("ID: " + id);
	}
	
	
	@DataProvider(name = "specificTestData")
	public Object[][] specificTestDataProvider() throws Exception {
	    return getSpecificTestCaseData("tc002");
	}


	public Object[][] getSpecificTestCaseData(String targetTestCase) throws Exception {
	    FileInputStream fis = new FileInputStream(
	        new File("C:\\\\Users\\\\VLAKKAND\\\\git\\\\SeleniumProject\\\\Maven_Testng\\\\servers\\\\Exceldata.xlsx"));
	    
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(0);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Assuming header is in row 0

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	        String testCaseId = row.getCell(0).toString();

	        if (testCaseId.equalsIgnoreCase(targetTestCase)) {
	            Object[][] data = new Object[1][colCount];
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[0][j] = (cell != null) ? cell.toString() : "";
	            }

	            workbook.close();
	            fis.close();
	            return data;
	        }
	    }

	    workbook.close();
	    fis.close();
	    return new Object[0][0]; // Return empty if not found
	}



}
