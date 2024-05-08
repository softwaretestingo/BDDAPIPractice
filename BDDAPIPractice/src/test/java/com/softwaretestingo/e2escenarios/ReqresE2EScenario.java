package com.softwaretestingo.e2escenarios;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ReqresE2EScenario 
{
	/**
	 * In This Program we Will Try
	 * 1. Add a User
	 * 2. Update the User Name of the Newly Created User
	 * 3. Validate the Updated Name Is Available Or Not In the Response
	 */
	
	int userId;
	Response response, updateResponse;
	
	@Test (priority =0)
	public void reqresE2EScenarioTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		//Add a User & Get The Response
		response = given()
						.contentType("application/json")
							.body(Payload.payloadForAddingReqresUser())
								.when()
									.post("/api/users")
										.then().log().body()
											.assertThat()
												.statusCode(201)
													.and()
														.contentType(ContentType.JSON)
															.extract()
																.response();	
					
		//Extract the UserID from the response
		JsonPath pathview = response.jsonPath();
		userId= pathview.getInt("id");
		System.out.println(userId);
	}
	
	@Test (priority =1)
	public void updateUserTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		updateResponse= given()
					.contentType("application/json")
						.body(Payload.payloadforUpdateReqresUser())
							.pathParam("id", userId)
								.when()
									.put("/api/users/{id}")
										.then()
											.assertThat()
												.statusCode(200)
													.and()
														.contentType(ContentType.JSON)
															.and()
																.body("name", equalTo("SoftwareTestingo Blog"))
																	.extract()
																		.response();
		
		
		System.out.println("After Update the Response Bpody");
		System.out.println(updateResponse.asPrettyString());
	}
	
	@Test(priority = 2)
	public void validateName()
	{
		String name;
		
		JsonPath js=updateResponse.jsonPath();
		name=js.getString("name");
		System.out.println(name);
		assertThat(name, equalTo("SoftwareTestingo Blog"));
	}
}
