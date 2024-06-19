package com.softwaretestingo.restassuredwithexcel;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ReusableMethods;

import static io.restassured.RestAssured.*;
public class ExcelDriven_01_CreateUser 
{
	Response resp;
	int id;
	@Test
	//Add or Create a User
	public void ExcelDriven()
	{
		RestAssured.baseURI="https://reqres.in";
		
		resp=given()
				.contentType("application/json")
						.body("{\r\n"
								+ "    \"name\": \"morpheus\",\r\n"
								+ "    \"job\": \"leader\"\r\n"
								+ "}")
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
		id=js.getInt("id");
		System.out.println("The User Id Is: "+id);
	}
}
