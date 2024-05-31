package com.softwaretestingo.simpleJSONSerialization;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class GoRestSerializationWithOutArray 
{
	@Test
	public void GoRestSerializationWithOutArrayTest()
	{
		GoRestPOJOClass payload=new GoRestPOJOClass();
		payload.setName("SoftwareTestingo");
		payload.setJob("Content Creator");
		RestAssured.baseURI="https://reqres.in";
		
		Response response=given()
							.contentType("application/json")
								.body(payload)
									.when()
										.post("/api/users")
											.then()
												.assertThat()
													.statusCode(201)
														.and()
															.extract()
																.response();
		
		System.out.println(response.asPrettyString());
	}
}
