package propertyFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WrirePropertyFiles {

	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();

		properties.setProperty("Name", "Lakkandi");
		properties.setProperty("Role", "Test Engneer");
		properties.setProperty("Technology", "Testing");

// not required		String filePath = System.getProperty("user.dir")+"\\Property_Data\\example.properties";
		FileOutputStream file = new FileOutputStream(
				new File("C:\\Users\\VLAKKAND\\git\\SeleniumProject\\Maven_Testng\\Property_Data\\example2.properties"));

		properties.store(file, "Sample data..");

		file.close();
		System.out.println("Properties have been written into the file");

	}

}
