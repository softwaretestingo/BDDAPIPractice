package com.softwaretestingo.restassuredwithexcel;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import utils.ReusableMethods;
public class ExcelDriven_04_ComplexConvertHashMapToJSON2 
{
	
	
	Response resp;
	
	@Test
	public void convertHashMapToJson() throws JsonMappingException, JsonProcessingException
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
		
		String jsonString="{ \r\n"
				+ "\"firstname\" : \"SoftwaretestingO\",\r\n"
				+ "\"lastname\" : \"Blog\",\r\n"
				+ "\"totalprice\" : 111,\r\n"
				+ "\"depositpaid\" : true,\r\n"
				+ "\"bookingdates\" : \r\n"
				+ "	{ \r\n"
				+ "		\"checkin\" : \"2024-01-01\",\r\n"
				+ "		\"checkout\": \"2025-01-01\" \r\n"
				+ "	}, \r\n"
				+ "\"additionalneeds\" : \"Breakfast\" \r\n"
				+ "}";
		//Create HashMap For Above JSON
		ObjectMapper mapper=new ObjectMapper();
		Map jsonMap=mapper.readValue(jsonString, Map.class);
		
		
		
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
