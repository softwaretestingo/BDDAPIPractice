package com.softwaretestingo.matcher;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class MultipleAssertStateMentInSingleBodyExample 
{
	
	// BY This You Can Validate Multiple Conditions and On Failed One Condition It Will Validate Other Also 
	@Test
	public void comparingValueTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		given()
			.when()
				.get("/api/users/2")
					.then().log().all()
						.assertThat()
							.statusCode(200)
								.and()
									.body("data.first_name", equalTo("Janet1"), // Fail
										  "data.last_name", equalTo("Weaver"),  // Pass
										  "data.id", equalTo(21));              // Fail
	}
}