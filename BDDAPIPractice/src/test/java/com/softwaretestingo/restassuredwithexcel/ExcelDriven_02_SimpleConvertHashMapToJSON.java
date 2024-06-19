package com.softwaretestingo.restassuredwithexcel;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import java.util.HashMap;

import io.restassured.response.Response;
import utils.ReusableMethods;
public class ExcelDriven_02_SimpleConvertHashMapToJSON 
{
	
	
	Response resp;
	
	@Test
	public void convertHashMapToJson()
	{
		/*{
		    "name": "SoftwareTestingO",
		    "job": "Admin"
		   }
		*/
		//Create HashMap For Above JSON
		HashMap<String, Object> jsonMap=new HashMap<>();
		jsonMap.put("name", "SoftwareTestingO");
		jsonMap.put("job", "Admin");
		
		
		RestAssured.baseURI="https://reqres.in";
		
		resp= given()
				.contentType("application/json")
					.body(jsonMap)
						.when()
							.post("/api/users")
								.then().log().body()
									.assertThat()
										.statusCode(201)
											.extract()
												.response();
		
		// Get the User ID from response 
		System.out.println("--------------------------------");
		JsonPath js=ReusableMethods.responseToJSON(resp);
		int id=js.getInt("id");
		System.out.println("The User Id Is: "+id);
	}
}
