import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;

public class HeadersAlternative {
	public static void main(String args[]) {

	/*
	 Content-Type                       Use Case
	 
	1. application/json                   Sending JSON data
	2. application/x-www-form-urlencoded  Form data (like HTML forms)
	3. multipart/form-dataFile uploads 
	4. text/plain     					  Raw text
	 
	 */
	//	Content-Type: This header tells the server what type of data is being sent in the request body.
	//	application/json: This value means the body of the request is in JSON format.
	
	//for 2nd case	
		given().log().all()
	    .header("Content-Type", "application/x-www-form-urlencoded")
	    .body("username=veeresh&password=Pass@1234")
	.when()
	    .post("/login")
	.then()
	    .assertThat().statusCode(200);
		
		
	
	//for 3rd case
		given().log().all()
	    .multiPart("file", new File("path/to/file.txt"))
	    .header("Content-Type", "multipart/form-data")
	.when()
	    .post("/upload")
	.then()
	    .assertThat().statusCode(200);
		
		
		
		//for 4th case
		given().log().all()
	    .header("Content-Type", "text/plain")
	    .body("This is a plain text message.")
	.when()
	    .post("/sendText")
	.then()
	    .assertThat().statusCode(200);

	
	}
}
