package com.softwaretestingo.log;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class LogParameter 
{
	// Print Para Meters
	@Test
	public void singleQueryParameterTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().params()
			.queryParam("page", 2)
				.when()
					.get("/api/users");	
	}
}
