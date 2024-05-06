package com.softwaretestingo.differentwaytopassbody;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PassBodyAsJSONInPostRequestWithMap 
{
	/*
	 * If you mention .contentType("application/json") and you want to pass the data as Map
	 * 
	 * Here In Body We Pass below Data as JSON
	 * {
	 * "name": "morpheus",
	 * "job": "leader"
	 * }
	 */
	
	@Test
	public void passBodyAsJSONInPostRequestWithMapTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		Map<String, String> payload= new HashMap<String, String>();
		payload.put("name", "morpheus");
		payload.put("job", "leader");
		
		
		
		given().log().all()
			.contentType("application/json")
				.body(payload)
					.post("/api/users")
						.then().log().all()
							.assertThat()
								.statusCode(201)
									.and()
										.contentType(ContentType.JSON);
	}
}
