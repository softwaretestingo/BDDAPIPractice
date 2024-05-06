package com.softwaretestingo.matchers.stringassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ContainsStringExample 
{
	// Checks Whether The JSON Body contains the Expected String 
	
	@Test
	public void comparingValueTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
			.when()
				.get("/api/users/2")
					.then()
						.assertThat()
							.statusCode(200)
								.and()
									.body(containsString("Janet"));
	}
}