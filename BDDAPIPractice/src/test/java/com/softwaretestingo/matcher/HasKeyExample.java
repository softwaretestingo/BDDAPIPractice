package com.softwaretestingo.matcher;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
public class HasKeyExample 
{
	// It Checks Whether The Extracted Map has an Expected Key
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		// If You Want to Check The Response body have the mentioned Key
		given()
			.when()
				.get("/booking/2554")
					.then().log().body()
						.assertThat()
							.body("bookingdates", hasKey("checkin"));
	}
}