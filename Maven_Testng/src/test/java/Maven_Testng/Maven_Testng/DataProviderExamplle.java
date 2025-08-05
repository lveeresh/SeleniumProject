package Maven_Testng.Maven_Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExamplle {

	
	//@Test(dataProvider="LoginDataProvider", dataProviderClass=className.class)  
	//the above line will work when u r dataProvider method in another class and if u want to use that
	
	@Test(dataProvider="LoginDataProvider")
	public void LogIn(String email, String password) {
		System.out.println(email+"     "+password);
	}
	
	
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData(){
		Object[][] data= {{"veersh@gmail.com","veeresh"}, {"abc@gmail.com","abc"},{"mnc@gmail.com","mnc"}};
		return data;
	}
	//based on input data in dataprovider that many times it will execute
	
	
}
