
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.Payloads;
import payloads.ReusableMethods;

import static io.restassured.RestAssured.*;    //--> given()
import static org.hamcrest.Matchers.*;			//--> equalTo-->.body("scope", equalTo("APP")

import org.testng.Assert;

public class Basics {
	
	// refer -->Basic API Test: -->in API_Notes

	public static void main(String[] args) {

		// given() --> all input details (queryparam, header, body)
		// when() --> Submit the API (responce, http methods(ex get,post,get & delete etc))
		// then --> Validate the responces
		
		//body()-->content of the file to string --> that can convert content into byte-->and byte to string
		
		
		//Post 
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();
		
//Complete URL: https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
		
		String responce = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payloads.addPayload()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200) //refer 8th point in API notes Class, for real json body
				.body("scope", equalTo("APP")).header("Connection", "Keep-Alive").extract().response().asString();
		//or
		
		//here we are fetching the json payload from exteranal ==>new String(Files.readAllBytes(Paths.get()))
		
		/*
		 String responce = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\Users\addplaces.json")))).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Connection", "Keep-Alive").extract().response().asString();
		 */

		System.out.println("responce body:" + responce);
		JsonPath js = new JsonPath(responce); // for parsing the json -->refer API_Notes class 2nd point for in details
		String placeId = js.getString("place_id");
		System.out.println("PlaceId: " + placeId);

		// Update Addreess-->put
		String newAddress = "101 winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
		
		/*
		 real json body structure for update 
		 
			 {
				"place_id":"e9f82b00ab562dd2ccbdf9f9129e60a4",
				"address":"70 winter walk, USA",
				"key":"qaclick123"
			}
			
		After update:
		{
    	   "msg": "Address successfully updated"
		}
		 */
		

		// get place
		String getResponce = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();

		
		JsonPath js1 = new JsonPath(getResponce);
		//JsonPath js1 = ReusableMethods.rawToJson(getResponce);
		String actualAddress = js1.getString("address");
		
		System.out.println("updated address: "+actualAddress );
		Assert.assertEquals(actualAddress, newAddress);
		
		//delete
		String response = given().log().all()
			    .queryParam("key", "qaclick123")
			    .body("{\"place_id\":"+ placeId+ "}")
			    .when().delete("/maps/api/place/delete/json")
			    .then().assertThat().statusCode(204)// expected status code for successful delete  204
			    .extract().response().asString();

			System.out.println("Delete Response: " + response);

	}

}
