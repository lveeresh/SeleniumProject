 
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.ReusableMethods;

import static io.restassured.RestAssured.*;

public class OAuthTest {
	
	//when we want to test authorized api server then we must required access token
	//you must request api contract to the developer to get the access token
	//refer commented lines in the bottom

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();
		String responce = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.when().post("oauthapi/oauth2/resourceOwner/token").then().log().all()
				.statusCode(200).extract().response().asString();
		System.out.println("response1: "+responce);
		
		/*  Output will be like this :
				 {
				    "access_token": "p0RSSN3tj3Th1fuZU8OKvg==",
				    "token_type": "Bearer",
				    "expires_in": 3600,
				    "refresh_token": "tY0HqMD8A01nSzObNUUxEw==",
				    "scope": "create"
				 }
		 */

		JsonPath js = ReusableMethods.rawToJson(responce);
		String accessToken = js.getString("access_token");
		System.out.println("AccessToken is : " + accessToken);

		// Get

		String responce2 = given().queryParam("access_token", accessToken).when().get("oauthapi/getCourseDetails")
				.asString();
		System.out.println("response2: "+responce2);
		
		System.out.println("status code :"
				+ given().queryParam("access_token", accessToken).when().get("oauthapi/getCourseDetails").statusCode());
		
		
		
		/*
		
		 
Authorization Server EndPoint:	https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token

HTTP Method : POST

Form parameters :
client_id:	692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com

client_secret:  erZOWM9g3UtwNRj340YYaK_W

grant_type:   client_credentials

scope:  trust

******************************************************************

GetCourseDetails EndPoint (Secured by OAuth) :	https://rahulshettyacademy.com/oauthapi/getCourseDetails

HTTP Method : GET

Query Parameter : access_token

		 */
	}

}
