package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class LogCookies 
{
	// Print Para Meters
	@Test
	public void singleQueryParameterTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given()
			.queryParam("page", 2)
				.when().log().cookies()
					.get("/api/users");	
	}
}
