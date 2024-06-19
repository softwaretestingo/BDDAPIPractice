package com.softwaretestingo.restassuredwithexcel;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.response.Response;
import utils.ReusableMethods;
public class ExcelDriven_05_SimpleConvertHashMapToJSONWithExcelIntegration 
{
	Response resp;
	
	@Test
	public void convertHashMapToJson() throws IOException
	{
		/*{
		    "name": "SoftwareTestingO",
		    "job": "Admin"
		   }
		*/
		//Retrieve Data From Excel
		ExcelOperations retriveData=new ExcelOperations();
		ArrayList data=retriveData.getData("Json Data", "Sheet2");
		
		//Create HashMap For Above JSON
		HashMap<String, Object> jsonMap=new HashMap<>();
		jsonMap.put("name", data.get(0));
		jsonMap.put("job", data.get(1));
		
		
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
