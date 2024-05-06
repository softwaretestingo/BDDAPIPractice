package com.softwaretestingo.matcher;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;;
public class NullValueExample 
{
	// Check For Null Value
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://reqres.in";
		
		// If You Want to Compare Two Integer Value Then You Can Use greaterThan()
		given()
			.when()
				.get("/api/users/2")
					.then().log().body()
						.assertThat()
							.body("id", is(nullValue()));
	}
}