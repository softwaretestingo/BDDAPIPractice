package com.softwaretestingo.matchers.numberassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class EqualToExample 
{
	// When You Want to Compare One Value with Other Value Then you can use equalTo()
	// For Use this method you need to import a static Package
	// import static org.hamcrest.Matchers.equalTo;  
	
	// Checks Whether Extracted String From JSON is EqualTo() to the Expected String
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
									.body("data.id", equalTo(2));
	}
}