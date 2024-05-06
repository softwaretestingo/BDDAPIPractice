package com.softwaretestingo.matchers.numberassertions;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
public class LessThanOrEqualToExample 
{
	//Check the whether the extracted Number is lesser Than or equal to the expected Number
	//import static org.hamcrest.Matchers.lessThanOrEqualTo;
	@Test
	public void greaterThanExampleTest()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		// If You Want to Compare Two Integer Value Then You Can Use lessThanOrEqualTo()
		given().log().all()
			.when()
				.get("/booking/108")
					.then().log().body()
						.assertThat()
							.body("totalprice", lessThanOrEqualTo(111));
	}
}