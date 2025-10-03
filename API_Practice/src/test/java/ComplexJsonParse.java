import payloads.Payloads;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String args[]) {

		JsonPath js = new JsonPath(Payloads.complexPayload());

		// Print No of courses returned by API -->refer bottom of lines for json payload or 3rd point in API_Notes
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// Print Purchase Amount
		int purchaceAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaceAmount);

		// Print Title of the first course
		String title = js.getString("courses[0].title");
		System.out.println(title);

		// Print All course titles and their respective Prices
		int all_courses_prices=0;
		for (int i = 0; i < count; i++) {
			
			String courses_title = js.getString("courses[" + i + "].title");
			System.out.println("courses title: " + courses_title);
			
			int prices = js.getInt("courses[" + i + "].price");
			System.out.println("courses prices: " + prices);
			
			int course_copy = js.getInt("courses["+i+"].copies");
			
			all_courses_prices = all_courses_prices+(prices*course_copy);
			//System.out.println(courses_allprices);

		}
		System.out.println("All courses prices :"+all_courses_prices);

		// Print no of copies sold by RPA Course
		for (int i = 0; i < count; i++) {
			String courses_title = js.getString("courses[" + i + "].title");
			if (courses_title.equalsIgnoreCase("RPA")) {
				int course_copy = js.getInt("courses["+i+"].copies");
				System.out.println("no of copies sold by RPA Course: " + course_copy);
				break;
			
		}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		Assert.assertEquals(all_courses_prices, purchaceAmount,"matching the price: ");

	}
}

/*
 {
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

 */
