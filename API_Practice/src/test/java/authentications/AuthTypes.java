package authentications;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;    //--> given()
import static org.hamcrest.Matchers.*;			//--> equalTo-->.body("scope", equalTo("APP")

import org.testng.annotations.Test;


public class AuthTypes {

	/*BasicAuth:
	username and paswword are sent with the request.
	here the credentials are encoded in base64 (converting a text into another type)
		*/
	@Test
	public void basicAuthentication() {
		RestAssured.baseURI = "https://postman-echo.com";

        // Perform GET request with Basic Authentication
        given()
            .auth().basic("postman", "password")
        .when()
            .get("/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();

	}
	
	
	/*DigestAuth:
	instead of username and password it sents hash value.
	it is more secure than basicauth
		*/
	@Test
	public void digestAuthentication() {
		RestAssured.baseURI = "https://postman-echo.com";

        // Perform GET request with Basic Authentication
        given()
            .auth().digest("postman", "password")
        .when()
            .get("/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();
	}
	
	/*preemptiveAuth:
	it sents credentials immedietely with the first request, instead of waiting for server to ask
	
		*/
	@Test
	public void preemptiveAuthentication() {
		RestAssured.baseURI = "https://postman-echo.com";

        // Perform GET request with Basic Authentication
        given()
            .auth().preemptive().basic("postman", "password")
        .when()
            .get("/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();

	}

	
	/*Beare Token Auth:
	instead of username and password it uses token in the header.
	it is more secure than basic_auth
		*/
	@Test
	public void bearerTokenAuthentication() {
		RestAssured.baseURI = "https://postman-echo.com";

        // Perform GET request with Basic Authentication
		
		 String bearerToken = "ghp_24pH0IcziPKHC1qOtLwj57AuDYmtSz2fuVKP"; // this is git hub acccess tokan, it will fech all repos which are available in u r github
		 //usually developer/backend team provides it.
		 	
		        given()
		            .headers("Authorization", "Bearer " + bearerToken)
		        .when()
		            .get("https://api.github.com/user/repos") // git hub url path
		        .then()
		            .statusCode(200)
		            .log().all();

	}
	
	
	/*oAuth1.0:
	it is older security protocol
	it uses consumerKey, consumerSecrat, accessToken, TokenSecrat as the parameters
		*/
	@Test
	public void oAuth1Authentication() {
		RestAssured.baseURI = "https://postman-echo.com";

		        given()
		            .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokanSecrat")// this is for oAuth1 Authentication
		        .when()
		            .get("url") // 
		        .then()
		            .statusCode(200)
		            .log().all();
	}
	
	
	/*oAuth2.0:
	it is widely used secure authentication method, it takes token as input request 
	it is more secure & more advanced then oAuth1
		*/
	
	@Test
	public void oAuth2Authentication() {

		String token= "ghp_24pH0IcziPKHC1qOtLwj57AuDYmtSz2fuVKP";
		// we don't get token directly we need to call an autherization server with client_id, client secret, usernam and password
		//that server responds with the access token, then we use that token 
		
		        given()
		            .auth().oauth2(token)// oAuth2 required only one parmeter i.e token 
		        .when()
		            .get("https://api.github.com/user/repos") 
		        .then()
		            .statusCode(200)
		            .log().all();
	}
	
	
	/*
	 Api Key Authentication:
	 API key like a secrete password given to the client, when client makes the request to the api. it includes this key(usually in 
	 header or in a queryParameter). The server checks if the key is valid and it allows acccess.
	 */
	        @Test
		    public void testAPIKeyAuthentication() {
			
			//https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7
			
			//Method1
		     /*   given()
		            .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c") // appid is AppKey
		        .when()
		            .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		        .then()
		            .statusCode(200)
		            .log().all();		*/
			
			//Method2
			given().queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")	// appid is API Key
					.pathParam("mypath", "data/2.5/forecast/daily")
					.queryParam("q", "Delhi")
					.queryParam("units", "metric")
					.queryParam("cnt", "7")
					.when()
					.get("https://api.openweathermap.org/{mypath}")
					.then().statusCode(200).log().all();
		}


}
