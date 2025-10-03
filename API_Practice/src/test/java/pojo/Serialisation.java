package pojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddPlace;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Serialisation {

	public static void main(String[] args) {
		
		/* 
		    Converting a java Object into a request body (payload)
		--> serialization refers to the process of converting a Java object into a JSON (or XML) format 
			so that it can be sent as the request body in an API call.
			
			Benfits:
			Save the time
			Cleaner code 
			Easy to reuse
			Easy to maintain
			
		*/
		
		// refer bottom lines for json

		AddPlace p = new AddPlace();

		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("kannada");
		p.setName("Frontline house");
		p.setPhone_number("983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();

		Response response = given().log().all().queryParam("key", "qaclick123").body(p).when().post("/maps/api/place/add/json")
				.then().statusCode(200).extract().response();
		String resp = response.asString();
		System.out.println("Responce is :"+response);

	}

}

/*
 
Serialization Json API Contract: 

Complete URL: https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
Base URL: https://rahulshettyacademy.com or http://216.10.245.166 – (Will be removed soon)
Resource: /maps/api/place/add/json
Parameters: key
Http request: POST
Note: Key value is hardcoded, and it is always qaclick123

------------------------------------------------------------
 
 {
  "location": {
    "lat": -38.383494,
    "lng": 33.427362
              },
  "accuracy": 50,
  "name": "Frontline house",
  "phone_number": "(+91) 983 893 3937",
  "address": "29, side layout, cohen 09",
  "types": ["shoe park","shop"],
  "website": "http://google.com",
  "language": "French-IN"
}


 */


