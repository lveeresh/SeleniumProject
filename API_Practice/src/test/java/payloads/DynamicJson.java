package payloads;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {

	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		String responce = given().header("Content-Type", "application/json").body(Payloads.addBook1(isbn,aisle)).when()
				.post("Library/Addbook.php").then().assertThat().log().all().statusCode(200).extract().response().asString();

		JsonPath js = ReusableMethods.rawToJson(responce);
		String id = js.getString("ID");
		System.out.println("New Id is : " + id);
	}
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		
		return new Object[][] {{"kgf","003"},{"msd","007"},{"vrt","018"}};
	}

}
