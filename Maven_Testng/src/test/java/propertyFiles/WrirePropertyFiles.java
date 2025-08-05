package propertyFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WrirePropertyFiles {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		
		properties.setProperty("Name", "Veeresh");
		properties.setProperty("Role", "Automation Engneer");
		properties.setProperty("Technology", "Selenium");
		
		String filePath = System.getProperty("user.dir")+"\\Property_Data\\example.properties";
		FileOutputStream file = new FileOutputStream(filePath);
		
		properties.store(file, "Sample data..");
		
		file.close();
		System.out.println("Properties have been written into the file");
		
	}

}
