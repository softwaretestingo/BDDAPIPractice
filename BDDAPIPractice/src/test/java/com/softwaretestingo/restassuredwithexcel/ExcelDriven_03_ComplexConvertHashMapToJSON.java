package com.softwaretestingo.restassuredwithexcel;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import java.util.HashMap;

import io.restassured.response.Response;
import utils.ReusableMethods;
public class ExcelDriven_03_ComplexConvertHashMapToJSON 
{
	Response resp;
	
	@Test
	public void convertHashMapToJson()
	{
		/*
		 * { 
		 * 		"firstname" : "SoftwaretestingO",
		 * 		"lastname" : "Blog",
		 * 		"totalprice" : 111,
		 * 		"depositpaid" : true,
		 * 		"bookingdates" : 
		 * 			{ 
		 * 				"checkin" : "2024-01-01",
		 * 				"checkout": "2025-01-01" 
		 * 			}, 
		 * 		"additionalneeds" : "Breakfast" 
		 * }
		 */
		//Create HashMap For Above JSON
		HashMap<String, Object> jsonMap=new HashMap<>();
		jsonMap.put("firstname", "SoftwaretestingO");
		jsonMap.put("lastname", "Blog");
		jsonMap.put("totalprice", 111);
		jsonMap.put("depositpaid", "true");
		HashMap<String, Object> jsonMapBookingDates=new HashMap<>();
		jsonMapBookingDates.put("checkin", "2014-01-01");
		jsonMapBookingDates.put("checkout", "2025-01-01");
		jsonMap.put("bookingdates", jsonMapBookingDates);
		jsonMap.put("additionalneeds", "Breakfast");
		
		
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		
		resp= given()
				.contentType("application/json")
					.body(jsonMap)
						.when()
							.post("/booking ")
								.then().log().body()
									.assertThat()
										.statusCode(200)
											.extract()
												.response();
		
		// Get the User ID from response 
		System.out.println("--------------------------------");
		JsonPath js=ReusableMethods.responseToJSON(resp);
		int id=js.getInt("bookingid");
		System.out.println("The Booking Id Is: "+id);
	}
}
