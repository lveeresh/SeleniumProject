
package payloads;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;

public class Bugtest {
	public static void main(String[] args) { 
		
		
		//u need to have/create jira account to test this
		RestAssured.baseURI = "https://rahulshettyacademy-team.atlassian.net/";
		
		String createIssueResponse = given().header("Content-Type", "application/json").header("Authorization",
				"Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
				.body("{\n" + "    \"fields\": {\n" + "       \"project\":\n" + "       {\n"
						+ "          \"key\": \"SCRUM\"\n" + "       },\n"
						+ "       \"summary\": \"Website items are not working- automation Rest Assured\",\n"
						+ "       \"issuetype\": {\n" + "          \"name\": \"Bug\"\n" + "       }\n" + "   }\n" + "}")
				.log().all().post("rest/api/3/issue").then().log().all().assertThat().statusCode(201)
				.contentType("application/json").extract().response().asString();
		
		JsonPath js = new JsonPath(createIssueResponse);
		String issueId = js.getString("id");
		System.out.println(issueId);
		
		// Add attachment 
		given().pathParam("key", issueId).header("X-Atlassian-Token", "no-check").header("Authorization",
				"Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
				.multiPart("file", new File("/Users/rahulshetty/Downloads/IMG_0926.jpeg")).log().all().when()
				.post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		
/*		
 manual api interview qn : 
				1. when u want to send any file or attachment through rest api, we can do it through form parameter
				2. In form parameteres when u enter key value pair, it will ask u what kind form u r key is that is "File" form
				3. key value pair can be sent securely, so it wont come under params section becouse it will in the url level
				4. so if u want send securely go to form data and select "form-data" then send key value pair and submit
				
Automation intrview qn: if u want to send an attachment from RestAssured 
				Ans: if u want to send an attachment from RestAssured, you have to use multipart method, 
					 multipart with key value extension  
		*/
	}
}