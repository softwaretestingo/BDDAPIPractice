package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class LogHeaders 
{
	// Print Para Meters
	@Test
	public void singleQueryParameterTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given()
			.queryParam("page", 2)
				.when().log().headers()
					.get("/api/users");	
	}
}
