package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;
public class BlackListHeader 
{
	/*
	 * As We have mentioned .header("Content-Type", "application/json")
	 * 
	 * we need to pass in body like below
	 * 
	 * {
	 * "email": "test058566@gmail.com",
	 * "name": "softwaretestingo",
	 * "gender": "Male",
	 * "status": "Active"
	 * }
	 */
	
	@Test
	public void passBodyAsStringInPostRequestTest()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		given()
			.header("Authorization", "Bearer 1ca8e3450e4a08c05c669534d8e9591245c5d260289c7418ad924c2e98c2996b")
				.and()
					.header("Content-Type", "application/json")
						.body("{\r\n"
							+ "    \"email\": \"test086@gmail.com\",\r\n"
							+ "    \"name\": \"softwaretestingo\",\r\n"
							+ "    \"gender\": \"Male\",\r\n"
							+ "    \"status\": \"Active\"\r\n"
							+ "}")
						.config(config.logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Accept")))
								.when().log().all()
									.post("/public/v2/users")
										.then()
											.assertThat()
												.statusCode(201)
													.and()
														.statusLine("HTTP/1.1 201 Created");									
	}
}
