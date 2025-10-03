
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpecBuilder {

	public static void main(String[] args) {

		// come to this class after completion of Serialisation class
		
		/*
		 
		 Spec Builder: 
		 In Rest Assured, a Spec Builder is used to create and reuse common parts of your API test setup — like base URLs, headers,
		 queryparams, etc. — in a clean and organized way.
		 
		 or
		 
		 RequestSpec or ResponseSpec Builder are used to create reusable specifications for HTTP request and responses.
		 
		 Two Main Types:
			RequestSpecBuilder – builds a reusable setup for sending requests.
			ResponseSpecBuilder – builds a reusable setup for checking responses.
			
		 Purpose:
		 It makes your API tests cleaner, shorter, and easier to manage.
		 
		 */

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

//		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		ResponseSpecification resSpecif = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification response = given().spec(req).body(p);

		Response Totalresp = response.when().post("/maps/api/place/add/json").then().spec(resSpecif).extract()
				.response();
		
		System.out.println("getTime is :"+Totalresp.getTime());//getTime is :21551	// it will give u in milliseconds->21551
		System.out.println("getTimeIn is :"+Totalresp.getTimeIn(TimeUnit.SECONDS));	//getTimeIn is :21
		System.out.println("Time is :"+Totalresp.time());							// it will give u in milliseconds-->Time is :21551
		System.out.println("TimeIn is :"+Totalresp.timeIn(TimeUnit.SECONDS));		//TimeIn is :21

		String resp = Totalresp.asString();
		System.out.println("Total resp: " + resp);

	}

}
