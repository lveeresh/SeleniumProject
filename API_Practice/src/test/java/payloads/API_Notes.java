package payloads;

public class API_Notes {

	/*
	--> What is API Testing?
	
		Ans: API Testing means sending request to the server (through api's) and checking the response-data, status,time and errors(without using the UI)
	 
	 	(or)
	 	
	 	Testing the communication between client and server by sending requests and verifying the responses.
	 	
	 	Example with food app:
	 	> You open the app and click "Search for Biryani" -->your app = Client
	 	
	 	> Swiggy's backend system finds biryani restaurants and sends data back --> backend = Server
	 	
	 	> The response shows you a list of restaurants --> delivered from Server to Client
	 	
	 	
	-----------------------------------------------------	
	 	
	 ==>Get Method: no payload/body required for get the data using get method, everything will pass as a parameter	 
	 
1.	 given() --> all input details (queryparam, header, body)
	 when() --> Submit the API (responce, methods(ex post,get etc))
	 then --> Validate the responces
	 
2.	Jsonpath:JsonPath class is the one which takes the string as a input and convert that into json and it will help to parse the json
	 

3.{

"dashboard": {

				"purchaseAmount": 910,
				
				"website": "rahulshettyacademy.com"

			},

"courses": [

			{

				"title": "Selenium Python",
				
				"price": 50,
				
				"copies": 6

			},

			{
			
			"title": "Cypress",
			
			"price": 40,
			
			"copies": 4
			
			},
			
			{
			
			"title": "RPA",
			
			"price": 45,
			
			"copies": 10
			
			}

		]

}
	 
	 
4.	manual api interview qn : 
 					1. when u want to send any file or attachment through rest api, we can do it through form parameter
	 				2. In form parameteres when u enter key value pair, it will ask u what kind of form u r key is? that is "File" form
	 				3. key value pair can be sent securely, so it wont come under params section becouse it will go in the url level
	 				4. so if u want send securely go to form data and select "form-data" then send key value pair and submit
	 				
	 Automation intrview qn: if u want to send an attachment from RestAssured 
	 				Ans: if u want to send an attachment from RestAssured, you have to use multipart method, 
	 					 multipart with key value extension  -->refer Bugtest class
	 

5. How will u add attachments/files using restAssured in API testing?

		Ans: Using multPart() method
		multiPart("filename", new File("give u r file location path")) method
		
	 
6. mainly we have 2 types of parameter one is query and path, but we have one more parameter additioanlly that is form parameter

7. Maven Project is something which will give u a ready made template to get started with u r code. it makes our 
	life/automation journey easy by bringing the libraries from maven repositories to our project by simply providing the dependency
    code
    
8. json body for reference of basic Pre_Basics Class and basic calss
	
	{
  "location": {
    "lat": -38.383494,
    "lng": 33.427362
  },
  "accuracy": 50,
  "name": "Frontline house",
  "phone_number": "(+91) 983 893 3937",
  "address": "29, side layout, cohen 09",
  "types": [
    "shoe park",
    "shop"
  		 ],
  "website": "http://google.com",
  "language": "French-IN"
}


9. How can you add validations points in postman?
	Ans: In the latest Postman interface, we add validation points in the 'Script' section under the 'Post-response' tab.
	 This is where we write JavaScript-based test scripts to validate things like status code, response time, and JSON fields.
	 For example:

	pm.test("Status code is 200", () => {
    pm.response.to.have.status(200);
	});

10. what do u understand by server side validation in API
	Ans: Server-side validation means the backend checks the incoming request data for correctness before processing it.
	If the data is invalid, the server returns an error like 400 Bad Request.

11. What is three tier arcitecture in API's?
	its a desighn pattern where an application is split into three tiers/layers. each has specific responcibility.
	1. Presentation Layer: Front end Layer->ex: web app, mobile app, any client calling the API
	2. Applicatoion Layer: the middle tier where API lives->Contains buisiness rules.
	3. Data Layer: Tha back end layer that stores and retrives the data


12. What do you test in stand alone APIs
	Ans : In standalone APIs, I test key aspects like status codes, response time, data validation, error handling,
	authentication (if applicable), and the correctness of the response body. I also check edge cases and how the API behaves with invalid inputs.


13. Why is Content-Type: application/json used in headers?

	This header tells the server that the body of your request is in JSON format.
	It's especially important when you're sending data (like in a POST or PUT request) because:
	
	The server needs to know how to parse the incoming data.
	Without this header, the server might reject the request or misinterpret the payload.


14.
| Status Code 				| Category     | Meaning                          | Usage in API Testing                           |
|---------------------------|--------------|----------------------------------|--------------------------------
| 200 OK      				| Success      | Request succeeded                | Successful GET/POST requests                   |
| 201 Created 				| Success      | Resource created                 | After POST creating a resource                 |
| 204 No Content 			| Success      | No content to return             | Action successful, no response body            |
| 400 Bad Request 			| Client Error | Malformed request                | Client-side error in request formatting        |
| 401 Unauthorized 			| Client Error | Authentication required          | Missing or invalid credentials                 |
| 403 Forbidden 			| Client Error | Access denied                    | Authenticated but not authorized               |
| 404 Not Found 			| Client Error | Resource not found               | Endpoint/resource doesn’t exist                |
| 405 Method Not Allowed 	| Client Error | Method not supported      		  | E.g., POST on a GET-only endpoint              |
| 409 Conflict				| Client Error | Trying to create a resource that already exists|
| 429 Too Many Requests 	| Client Error | Rate limit exceeded      		  | API throttling                                 |
| 500 Internal Server Error | Server Error | Generic server error  			  | Server-side issue                              |
| 502 Bad Gateway 			| Server Error | Invalid upstream response        | Proxy/microservice issue                       |
| 503 Service Unavailable 	| Server Error | Server down/overloaded 		  | Temporary issue, retry later                   |
| 504 Gateway Timeout 		| Server Error | Server timeout                   | Backend/network delay                          |


15. authentication: The process of verifying the user identity



16.	Scenario: You want to update the entire user profile.
	Original Resource:
	{
	  "id": 101,
	  "name": "Veeresh",
	  "email": "veeresh@example.com",
	  "phone": "1234567890"
	}
	
	
	PUT Request body:
	{
	  "id": 101,
	  "name": "Veeresh Lakkandi",
	  "email": "veeresh.lakkandi@example.com",
	  "phone": "9876543210"
	}

	Patch:
	{
	  "phone": "9876543210"
	}


17. Pojo class? 
	POJO: stands for Plain old java object
	POjo classes in restAssured are used to represent the request body as a java object instead of writting raw json string.







----------------------------------------------------------
	 API Notes:

Email: veereshlakkandi284@gmail.com
Postman Username: veereshlakkandi284
Postman Password: LakkandiVeeresh@284

End point: Address where API is hosted on the Server.

HTTP methods which are commonly used to communicate with Rest APIs are
GET, POST, PUT, and DELETE
GET- The GET method is used to extract information from the given server using a given URI. While using GET request, it should only extract data and should have no other effect on the data. No Payload/Body required
How to send input data in GET?
Ans: Using Query Parameters

POST- A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.
How to send input data in POST?
Ans: Using Form Parameters /Body Payload


PUT- Replaces all current representations of the target resource with the uploaded content.
DELETE- Removes all current representations of the target resource given by a URI.

Resources:
Resources represent API/Collection which can be accessed from the Server
Google.com/maps
google.com/search
google.com/images

Path Parameters:
Path parameters are variable parts of a URL path. They are typically used to point to a specific resource within a collection, such as a user identified by ID
https://www.google.com/Images/1123343
https://www.google.com/docs/1123343
https://amazon.com/orders/112
https://www.google.com/search?q=newyork&oq=newyork&aqs=chrome..69i57j0l7.2501j0j7&sourceid=chrome&ie=UTF-8


Query Parameters:
Query Parameter is used to sort/filter the resources.
Query Parameters are identified with?””
https://amazon.com/orders?sort_by=2/20/2020

Headers/Cookies:
Headers represent the meta-data associated with the API request and response. In layman terms, we were sending Additional details to API to process our request.
Example : Authorization details


End Point Request URL can be constructed as below
Base URL/resource/(Query/Path)Parameters

-----------------------------------------------------
Basic API Test:

Complete URL: https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123

Base URL: https://rahulshettyacademy.com or http://216.10.245.166 – (Will be removed soon)

Resource: /maps/api/place/add/json

Parameters: key
Http request: POST
Note: Key value is hardcoded, and it is always qaclick123

Sample Body:
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
}
