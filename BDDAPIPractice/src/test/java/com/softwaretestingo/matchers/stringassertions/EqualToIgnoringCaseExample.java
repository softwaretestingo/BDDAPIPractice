package com.softwaretestingo.matchers.stringassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static io.restassured.RestAssured.*;
public class EqualToIgnoringCaseExample 
{
	// Checks Whether Extracted String From JSON is Equal To the Expected String
	// By Considering the Small Or Capital Cases
	@Test
	public void comparingValueTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given().log().all()
			.when()
				.get("/api/users/2")
					.then().log().all()
						.assertThat()
							.statusCode(200)
								.and()
									.body("data.first_name", equalToIgnoringCase("Janet"));
	}
}