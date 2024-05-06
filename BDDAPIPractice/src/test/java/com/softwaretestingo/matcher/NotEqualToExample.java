package com.softwaretestingo.matcher;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.not;;
public class NotEqualToExample 
{
	// If you want to perform negative assertions, then we can use any assertions with NOT
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
									.body("data.id", not(equalTo(28)));
	}
}