package DataDriven;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() throws IOException {
		return ExcelUtils.getExcelData(
				"C:\\\\Users\\\\VLAKKAND\\\\git\\\\SeleniumProject\\\\Maven_Testng\\\\servers\\\\Credentials.xlsx",
				"Credentials");
	}
}
