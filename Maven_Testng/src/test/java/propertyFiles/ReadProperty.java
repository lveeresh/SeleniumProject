package propertyFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import Maven_Testng.Maven_Testng.Alerts_Handling_And_ColourValidation;

public class ReadProperty {

	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();
		

		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\VLAKKAND\\git\\SeleniumProject\\Maven_Testng\\Property_Data\\example.properties"));

		properties.load(file);

		file.close();

		// below values are from Properties_Data file

		// Name=Veeresh
		// Role=Automation Engnr
		// Technology=Seleium

		String name = properties.getProperty("Name");
		String role = properties.getProperty("Role");
		String techn = properties.getProperty("Technology");

		System.out.println(name + "*" + role + "*" + techn);

		Set<String> keys = properties.stringPropertyNames();

		System.out.println(keys); // which will return all the keys

		Collection<Object> values = properties.values();
		System.out.println(values); // which will return all the values

		for (String key : properties.stringPropertyNames()) {
			System.out.println(key + ":" + properties.getProperty(key)); // which will return both key and the values
		}
	}

}
