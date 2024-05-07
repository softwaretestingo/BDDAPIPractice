package com.softwaretestingo.log;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConditionalLogging
{
	@Test
	public void conditionalLoggingTest()
	{
		// If The StatusCode is 200 then only the Logs Will Be Printed In Console
		RestAssured.baseURI="http://ergast.com";
		
		given()
			.pathParam("year", "2018")
				.when()
					.get("/api/f1/{year}/circuits.json")
						.then().log().ifStatusCodeIsEqualTo(200);

	}
}
